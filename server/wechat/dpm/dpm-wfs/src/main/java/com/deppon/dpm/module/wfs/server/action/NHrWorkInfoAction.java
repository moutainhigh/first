package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.INHrWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.nhr.ApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.nhr.QueryParam;
import com.deppon.dpm.module.wfs.shared.vo.NhrQueryParamVo;

/**
 * nhr的工作流
 * 补考勤 加班/加班工资申请工作流
 * @version
 */
public class NHrWorkInfoAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	private static Logger logger  = LoggerFactory.getLogger(NHrWorkInfoAction.class);
	/**
	 * service
	 */
	private INHrWorkInfoService nhrWfsSrv;
	//service
	private IMonitorService monitorService;
	// 工作流单据号
	private String busino;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
    private String errorInfo;
    
	/**
	 * 盘点单详情 根据审批流程中任一人的工号，姓名，工作流单据号 使用restful的方式进行接口调用
	 * 
	 * @author 195406 高春玲
	 * @date 2015-5-7 上午9:45:08
	 * @return
	 * @see
	 */
	public void queryWorkInfo() {
		Date begindate = new Date();
		String str = null;
		String issuccess = "0";
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//构建查询实体
			QueryParam query = null;
			str = StringUtil.bufferString(bu);
			//打印出参数
			logger.info("----nhr query action param:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				query = JSONObject.parseObject(str,
						QueryParam.class);
				query.setEmpName(java.net.URLDecoder.decode(query.getEmpName(), "utf-8"));
				//给busino赋值
				busino = query.getWorkFlowNum();
				//调用service
				String json = nhrWfsSrv.queryWorkInfo(query);
				//打印出返回的json
				logger.info("----nhr query action result:" + json);
				int excep = json.indexOf("exceptionType");
				if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(json) && excep < 0) {
	                issuccess = "1";
	                json = workflowStrUtil.replaceJsonSpecialCharacter(json);
	            }
				//返回给页面
				writeToPage(response, json);
				errorInfo = json;
			}
		} catch (Exception e) {
			errorInfo = e.getMessage();
			//打印报错信息
			e.printStackTrace();
		}finally{
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService,null,str);
			}
		}
	}

	/**
	 * 工作流审批
	 */
	public void approveWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			// 构建审批后勤需要的参数
			ApproveParam audit = null;
			str = StringUtil.bufferString(bu);
			//打印出审批的参数
			logger.info("----nhr approve action param:"+str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				audit = JSONObject.parseObject(str,
						ApproveParam.class);
				audit.setDealEmpName(java.net.URLDecoder.decode(audit.getDealEmpName(), "utf-8"));
				//给busino赋值
				busino = audit.getBusino();
				//调用service
				String json = nhrWfsSrv.approveWorkInfo(audit);
				String s = JsonUtil.jsonGetValueBykey(json,"success");
				//判断审批是否成功
				if(s != null && s.equals("true")) {
					//审批成功
					issuccess = "1";
				}
				logger.info("----nhr approve action result:" + json);
				errorInfo = json;
				//返回给页面
				writeToPage(response, json);
			}
		} catch (Exception e) {
			//打印出报错信息
			e.printStackTrace();
			writeToPage(response, "0");
			errorInfo = e.getMessage();
		}finally{
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService,null,str);
			}
		}
	}

	/**
	 * NHR工作流，人员选择器
	 * P7异动，直属上级M6，可选择任何等级P类人员交接。
	 * 职能事业群高级总监M9离职/异动，直属上级为高级副总裁D，可选择D及以下人员交接
	 * C>D>10
	 */
	public void queryUserInfo(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			String str = StringUtil.bufferString(bu);
			//打印出参数
			logger.info("----nhr queryUserInfo action param:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				String json = "{}";
				// 给实体赋值
				NhrQueryParamVo paramVo = JSONObject.parseObject(str,NhrQueryParamVo.class);
				// 参数校验
				if(paramVo != null&&StringUtils.isNotEmpty(paramVo.getApplypsncode())
						&&StringUtils.isNotEmpty(userId)){
					// 查询数据
					json = nhrWfsSrv.queryUserInfo(paramVo, userId);
				}
				//返回给页面
				writeToPage(response, json);
			}
		} catch (Exception e) {
			//打印报错信息
			e.printStackTrace();
		}
	}
	
	/**
	 * @param nhrWfsSrv the nhrWfsSrv to set
	 */
	public void setNhrWfsSrv(INHrWorkInfoService nhrWfsSrv) {
		this.nhrWfsSrv = nhrWfsSrv;
	}

	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

}