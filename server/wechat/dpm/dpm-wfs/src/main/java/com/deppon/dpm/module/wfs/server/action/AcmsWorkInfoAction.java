package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.wfs.server.service.IAcmsWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IApprovePeopleQueryService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.acms.AcmsApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.acms.WorkflowinfoRequest;

public class AcmsWorkInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger  = LoggerFactory.getLogger(AcmsWorkInfoAction.class);
	//service
    private IApprovePeopleQueryService approvePeopleQueryService;
    //service
    private ITpushNewsService tpushNewsService;
    //service
    private IMonitorService monitorService;
    //service
    private IAcmsWorkInfoService acmsWfsSrv;
	//审批人
	private String empName;
	//审批人工号
	private String empCode;
    private String processDefName;
    private long processInstId;
    // 工作流单据号
	private String busino;
	//工作项ID
	private String workitemid;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
    private String errorInfo;
    
    /**
	 * 工作流审批
	 */
	public void approveWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
		String json = null;
		if ("POST".equals(request.getMethod())) {
			try {
				BufferedReader bu = request.getReader();
				AcmsApproveParam audit = null;// 构建审批后勤需要的参数
				str = StringUtil.bufferString(bu);
				str = java.net.URLDecoder.decode(str, "utf-8");
				//打印出参数
				logger.info("============acms approve action param:" + str);
				if (!StringUtil.isEmpty(str)) {
					//给实体赋值
					audit = JSONObject.parseObject(str, AcmsApproveParam.class);
					audit.setAppName(java.net.URLDecoder.decode(
							audit.getAppName(), "utf-8"));
					//打印出审批人姓名
					logger.info(audit.getAppName() + "==姓名");
					//给busino赋值
					busino = audit.getBusino();
					//打印出工作流号
					logger.info("输出的工作流号"
							+ audit.getApprovelEntity().getProcessinstid());
					//打印出的busino
					logger.info("输出的号" + busino);
					//调用service
					json = acmsWfsSrv.approveWorkInfo(audit);
					if (json != null && json.equals("0")) {// 审批成功
						issuccess = "1";
					} else if(StringUtils.isNotBlank(json)) {
						String s = JsonUtil.jsonGetValueBykey(json,"resultCode");
						if("0".equals(s)) {//审批成功
							issuccess = "1";
						}
					}
				}
				errorInfo = json;
				//打印出返回的json
				logger.info("============acms approve action return:" + json);
				//返回给页面
				writeToPage(response, json);
			} catch (Exception e) {
				writeToPage(response, "1");
				errorInfo = e.getMessage();
			} finally {
				if (!StringUtil.isEmpty(str)) {
					// 保存数据监控
					WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype,
							begindate, this.busino, issuccess, this.errorInfo,
							ServletActionContext.getRequest().getSession(),
							this.monitorService, null,str);
				}
			}
		}
	}
	
    /**
	 * 工作流查询
	 */
		public void queryWorkInfo() {
			Date begindate = new Date();
			String issuccess = "0";
			// 初始化返回值
			String json = "";
			try {
				//打印出查询的参数
				logger.info("acms============queryWorkInfo action param:"+this.empCode,this.empName,this.processDefName,this.busino,this.processInstId);
				WorkflowinfoRequest workfinfo=new WorkflowinfoRequest(this.empCode,this.empName,this.processDefName,this.busino,this.processInstId);
				//调用service
					json = acmsWfsSrv.queryWorkInfo(workfinfo);
				if(!StringUtil.isEmpty(json) ){
					int excep = json.indexOf("exceptionType");
					if(excep < 0) {
						issuccess = "1";
		            }else{
		            	json= "";
		            	this.errorInfo = json;
		            	//打印返回的json
		            	logger.info("============acms action return:" + json);
		            }
				}
				
			} catch (Exception e) {
				json= "";
				this.errorInfo = e.getMessage();
				logger.info("ACMS查询出现异常",e);
			} finally {
				writeToPage(json);
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.busino, 
					issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,json);
			}
		}
	/**
	 * @param acmsWfsSrv the acmsWfsSrv to set
	 */
	public void setAcmsWfsSrv(IAcmsWorkInfoService acmsWfsSrv) {
		this.acmsWfsSrv = acmsWfsSrv;
	}
	/**
	 * @param approvePeopleQueryService the approvePeopleQueryService to set
	 */
	public void setApprovePeopleQueryService(
			IApprovePeopleQueryService approvePeopleQueryService) {
		this.approvePeopleQueryService = approvePeopleQueryService;
	}
	/**
	 * @param tpushNewsService the tpushNewsService to set
	 */
	public void setTpushNewsService(ITpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}
	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * @param processDefName the processDefName to set
	 */
	public void setProcessDefName(String processDefName) {
		this.processDefName = processDefName;
	}
	/**
	 * @param processInstId the processInstId to set
	 */
	public void setProcessInstId(long processInstId) {
		this.processInstId = processInstId;
	}
	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * @param workitemid the workitemid to set
	 */
	public void setWorkitemid(String workitemid) {
		this.workitemid = workitemid;
	}
	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}
}
