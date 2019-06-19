package com.deppon.dpm.module.projecttools.server.action;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.server.service.IDppmQueryService;
import com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor.MonitorUtil;

/**
 * TODO 项目管理工具action
 * @author 石学钢
 * 2015-9-24
 */
public class DppmQueryAction extends BaseAction {
	/*** 日志*/
	Logger logger = LoggerFactory.getLogger(DppmQueryAction.class);

	private static final long serialVersionUID = 1L;

	//service
	private IDppmQueryService dppmQueryService;
	
	//数据监控service
	private IDppmMonitorService dppmMonitorService;
	
	//权限级别
	private String jobLevel;

	//用户ID
	private String userId;

	//项目编码
	private String projectCode;

	//审核状态
	private String checkStatus;

	//审核ID
	private String taskId;

	//部门编号
	private String jobNumber;

	//权限查询
	private String power;

	//里程碑节点ID 查询会议纪要
	private String msId;
	/**
	 *  查询个人项目列表信息
	 */
	public void queryProjectInfo(){
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		//日志打印
		logger.info("个人项目管理工具查询列表  param is :"+userId+"  ——门户权限 joblever——"+jobLevel);
		//resInfo 返回信息
		String resInfo = "";
		try {
			//调用service
			resInfo = dppmQueryService.queryProjectInfo(userId,jobLevel);
			//{} 如果返回JSon对象 说明查询失败
			//[] 如果返回JSon数据 说明查询成功
		} catch (Exception e) {
			//异常处理
			logger.info("查询列表信息出现异常！", e);
			resInfo = "[]";
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "0", this.jobLevel, dppmMonitorService);
		}
		//logger.info("项目管理工具列表信息 resInfo is："+resInfo);
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
	/**
	 * 权限查询    查询部门或者全部项目(副总级别或者PMO)
	 */
	public void queryProjectPowerInfo(){
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		//日志打印
		logger.info("部门项目管理工具列表查询  param is :"+jobNumber);
		//resInfo 返回信息
		String resInfo = "";
		try {
			//调用service
			resInfo = dppmQueryService.queryDepartmentProjectInfo(userId,jobNumber);
			//{} 如果返回JSon对象 说明查询失败
			//[] 如果返回JSon数据 说明查询成功
		} catch (Exception e) {
			//异常处理
			logger.info("查询部门列表信息出现异常！", e);
			resInfo = "[]";
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "2", this.jobNumber, dppmMonitorService);
		}
		//logger.info("项目管理工具列表信息 resInfo is："+resInfo);
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}

	/**
	 * 查询项目管理明细
	 */
	public void queryProjectDeatil(){
		//日志打印
		logger.info("项目管理工具查询项目里程碑信息  param is : " + projectCode);
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		//resInfo 返回信息
		String resInfo = "";
		try {
			//调用service
			Map<String, Object> ret = dppmQueryService.queryProjectDeatil(projectCode);
			//项目资源的
			Map<String, Object> res = dppmQueryService.queryProjectResources(projectCode);
			ret.put("projectRes", res);
			resInfo = JsonUtil.mapToJsonString(ret);
			logger.info(res.toString());
			//resInfo = JsonUtil.mapToJsonString(dppmQueryService.queryProjectDeatil(projectCode));
		} catch (Exception e) {
			//异常处理
			logger.info("查询明细出现异常！",e);
			resInfo = "[]";
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "3", null, dppmMonitorService);
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
	/**
	 * 查询项目状态详情
	 */
	public void queryStatusDetailInfo(){
		//日志打印
		logger.info("项目状态详情查询信息  param is : " + projectCode);
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		//resInfo  返回信息
		String resInfo = "";
		try {
			//调用service
			resInfo = JsonUtil.mapToJsonString(dppmQueryService.queryStatusDetailInfoservice(projectCode));
		} catch (Exception e) {
			//异常处理
			logger.info("查询项目状态详情出现异常！",e);
			resInfo = "[]";
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "4", null, dppmMonitorService);
		}

		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
	/**
	 * 收藏列表查询
	 */
	public void collectProjectInfo(){
		//日志打印
		logger.info("项目收藏列表查询  param is : " + userId);
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		//resInfo 返回信息
		String resInfo = "";
		try {
			//调用service
			resInfo = JsonUtil.mapToJsonString(dppmQueryService.collectProjectInfo(userId,power,jobNumber));
		} catch (Exception e) {
			//异常处理
			logger.info("查询项目收藏列表出现异常！",e);
			resInfo = "[]";
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "1", null, dppmMonitorService);
		}
		
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
	/**
	 * 任务审核
	 */
	public void taskAuditupdate(){
		//日志打印
		logger.info("任务审核  checkStatus is : " + checkStatus+"——taskIdis"+taskId);
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//读取post传过来的参数
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");

		String resInfo = "";
		//过滤get请求
		if ("POST".equals(request.getMethod())){
			try {
				//读取post发送的请求参数
				BufferedReader bu=request.getReader();
				//opinion 审核不通过的意见
				String  opinion=StringUtil.bufferString(bu);
				//非空判断转换成JsonObject获取 opinion
				opinion = opinion!=null&&!opinion.equals("")?JsonUtil.parseObject(opinion).getString("opinion"):"";
				//判断参数正确性
				if (checkStatus!=null&&!"".equals(checkStatus)&&taskId!=null&&!"".equals(taskId)){
					resInfo = dppmQueryService.audit(checkStatus, taskId,opinion);
				} else {
					//3 请求数据错误
					resInfo = "2";
				}
				//把返回参数转换成json格式的String返回给前端
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", resInfo);
				resInfo = JsonUtil.mapToJsonString(map);
			} catch (Exception e) {
				//异常处理
				logger.info("任务审核出现异常！",e);
				resInfo = "[]";
			} finally {
				//数据监控
				MonitorUtil monitorUtil = new MonitorUtil();
				monitorUtil.dateMonitor(this.userId, "14", null, dppmMonitorService);
			}
		}
		//返回页面
		writeToPage(response, resInfo);
	}
	/**
	 * 里程碑节点会议纪要查询
	 */
	public void queryProjectMinutes(){
		//日志打印
		logger.info("项目里程碑节点会议纪要查询  param is : " + msId);
		//获取返回
		HttpServletResponse response = ServletActionContext.getResponse();
		//resInfo返回信息
		String resInfo = "";
		try {
			//调用service
			resInfo = JsonUtil.beanToJsonString(dppmQueryService.queryprojectMinutes(msId));
		} catch (Exception e) {
			//异常处理
			logger.info("查询会议纪要出现异常！",e);
			resInfo = "[]";
		} finally {
			//数据监控
			MonitorUtil monitorUtil = new MonitorUtil();
			monitorUtil.dateMonitor(this.userId, "5", null, dppmMonitorService);
		}
		//返回页面
		response.setHeader("Access-Control-Allow-Origin", "*");
		writeToPage(response, resInfo);
	}
	/**
	 * @param logger the logger to set
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	/**
	 * @param dppmQueryService the dppmQueryService to set
	 */
	public void setDppmQueryService(IDppmQueryService dppmQueryService) {
		this.dppmQueryService = dppmQueryService;
	}
	/**
	 * @param dppmMonitorService the dppmMonitorService to set
	 */
	public void setDppmMonitorService(IDppmMonitorService dppmMonitorService) {
		this.dppmMonitorService = dppmMonitorService;
	}
	/**
	 * @param jobLevel the jobLevel to set
	 */
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * @param checkStatus the checkStatus to set
	 */
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * @param jobNumber the jobNumber to set
	 */
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}
	/**
	 * @param msId the msId to set
	 */
	public void setMsId(String msId) {
		this.msId = msId;
	}
}
