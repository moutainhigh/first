package com.deppon.dpm.module.wfs.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.login.server.vo.LoginResult;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.dao.IWorkItemsListDao;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.util.monitor.MailUtil;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowInfo;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;

/**
 * 
 * 工作流数据监控Service
 * 
 * @author 195406 高春玲
 * @date 2015-6-1 下午3:45:08
 **/
public class MonitorService implements IMonitorService {
	private static Logger logger = LoggerFactory
			.getLogger(MonitorService.class);

	private IMonitorDao dao;
	private TpushNewsService tpushNewsService;
	private IWorkItemsListDao workItemsListDao;
	// 邮箱接收人
	private String toEmail;
	// 消息中心接受人工号
	private String toMsgCenter;
	// 判断当前审批人级别
	private int band;
	// 邮件发送方 邮局小天使
	private String emailFrom;
	// 邮件服务器 公司邮箱地址
	private String emailHost;
	// 邮件 用户名
	private String emailUsername;
	// 密码
	private String emailPassword;
	
	// 注入
	private RedisService loginRedisService;

	/**
	 * 工作流数据监控 kpi
	 */
	@Override
	public void addWfsMonitor(WfsMonitorVo vo) {
		this.dao.addWfsMonitor(vo);
	}

	/**
	 * 作为产品经理我希望能够识别到Band9以上人员的报错信息，以便我更高效地为用户解决报错问题， 错误信息的提醒主要通过邮件和办公APP的消息中心完成
	 * 报错预警
	 */
	@Override
	public void warningForB9(HttpSession session, String errorInfo,
			WfsMonitorVo vo) {
		logger.info("errorInfo" + errorInfo);
//		Object rstLogin = DpmCacheManager.getWfs(vo.getUserId());
		String loginInfoStr = null;
		try {
			loginInfoStr = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + vo.getUserId());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		logger.info("band9" + loginInfoStr);
		int bandd = 0;// 审批人级别
		String warn = "";
		if (StringUtils.isNotBlank(loginInfoStr)) {
//            Result<LoginResult> login = (Result<LoginResult>) rstLogin;
//			EmployeeEntity e = login.getData().getUserEntity().getEmployee();
			LoginResult loginResult = JSON.parseObject(loginInfoStr,LoginResult.class);
			EmployeeEntity e = loginResult.getUserEntity().getEmployee();
			String jobLevel = e.getJobLevel();
			// 判断当前审批人是否band9以上  C D 总裁 副总裁
			if (jobLevel != null && !jobLevel.equals("")&& (jobLevel.equals("C") || jobLevel.equals("D") || Integer.parseInt(jobLevel) > band)) {
				bandd = 1;
				// 工作流名称
				String workname = "";
				WorkflowInfo w = this.workItemsListDao.queryWorkInfo(vo
						.getWorkflowname());
				if (w != null) {
					workname = w.getWorkflowname();
				}
				// 消息中心推送信息
				warn = "审批人:" + e.getEmpCode() + "--" + e.getEmpName() + "<br>";
				warn += "职位:" + e.getJobName() + "<br>";
				warn += "部门:"
						+ loginResult.getUserEntity().getOrganization()
								.getOrgName() + "<br>";
				if (vo.getBdateStr() == null || vo.getBdateStr().equals("")) {
					if (vo.getBegindate() == null) {
						vo.setBegindate(new Date());
					}
					vo.setBdateStr(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss:SSS").format(vo.getBegindate()));
				}
				warn += "于" + vo.getBdateStr() + "审批" + workname
						+ "工作流时报错，工作流号：" + vo.getRemark() + "<br>";
			}
		}
		logger.info("band99" + warn);
		logger.info("issuccess" + vo.getIssuccess());
		if (bandd == 1) {
			// 邮件信息
			String emailinfo = "";
			// errorInfo="Connection refused: connect";
			if (!"1".equals(vo.getIssuccess())) {
				if (errorInfo != null && errorInfo.length() > 0) {
					if (errorInfo.indexOf("}") > -1) {
						String s = JsonUtil.jsonGetValueBykey(errorInfo,
								"exceptionCode");
						if ("S000099".equals(s) 
						 || "S000011".equals(s)
						 || "S000001".equals(s) 
						 || "S000003".equals(s)
						 || "S000004".equals(s)) {
							emailinfo = warn + "详细错误信息为:<br>" + errorInfo;
						}
					} else {
						emailinfo = warn + "详细错误信息为:<br>" + errorInfo;
					}

				} else {
					emailinfo = warn + "详细错误信息为:<br>" + errorInfo;
				}
				logger.info("================" + emailinfo);
				if (emailinfo.length() > 0) {
					try {
						// 办公APP的消息中心推送
						NewsCenterEntity nce = new NewsCenterEntity(
								vo.getRemark(), 2, 1, 0, "工作流报错预警");
						// String[] users=toMsgCenter.split(",");
						// for(String u:users){
						tpushNewsService.pushUserNews(toMsgCenter, "工作流报错预警",
								warn.replaceAll("<br>", ""), nce);
						// }
					} catch (Exception ee) {
						ee.printStackTrace();
					}
					// 邮件提醒
					MailUtil.sendMail(this.toEmail.split(","),
							"报错预警：工作流"
									+ ("0".equals(vo.getType()) ? "查看" : "审批"),
							emailinfo, this.emailHost, this.emailFrom, this.emailUsername,
							this.emailPassword);

				}

			}
		}

	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	public void setEmailUsername(String emailUsername) {
		this.emailUsername = emailUsername;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public void setDao(IMonitorDao dao) {
		this.dao = dao;
	}

	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	public void setWorkItemsListDao(IWorkItemsListDao workItemsListDao) {
		this.workItemsListDao = workItemsListDao;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public void setToMsgCenter(String toMsgCenter) {
		this.toMsgCenter = toMsgCenter;
	}

	public void setBand(int band) {
		this.band = band;
	}

	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}

}
