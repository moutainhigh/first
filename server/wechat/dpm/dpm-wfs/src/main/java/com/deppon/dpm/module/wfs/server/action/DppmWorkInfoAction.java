package com.deppon.dpm.module.wfs.server.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.wfs.server.service.IDppmWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
/**
 * dppm 项目管理工具系统的工作流
 * 移动审核项目结项申请工作流，移动审核项目落地申请工作流
 * @author 195406 高春玲
 * @date 2015-09-28
 * @version
 */
public class DppmWorkInfoAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	// 日志
	private Logger logger  = LoggerFactory.getLogger(DppmWorkInfoAction.class);
	/**
	 * 注入service
	 */
	private IDppmWorkInfoService dppmWfsSrv;
	/**
	 * 工作流预警service
	 */
	private IMonitorService monitorService;
	// 申请人姓名
	private String empName;
	// 工作流单据号
	private String busino;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
	private String errorInfo;
	// type 1:结项 2:落地 3:项目新建 4：项目变更和年度规划变更
	private int type;
	//工作流ID
	private String wfsid;
	//节点ID
	private String activitydefid;
	/**
	 * 工作流查看:: 工号，姓名，工作流单据号
	 * @author 195406 高春玲
	 * @date 2015-9-28
	 * @see
	 */
	public void queryWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		// 初始化返回值
		String json = "";
		String paramStr = this.type + " " + this.wfsid + " " + this.busino + " " + this.userId + " " + this.empName;
		try {
			this.logger.info("============queryWorkInfo action param:" + paramStr);
			//结项工作流查看
			if( this.type == 1) {
				// 调用service 获得结项工作流详情
//				json = this.dppmWfsSrv.projClosingDetail(this.busino, this.userId, this.empName);
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("clianNo", this.busino);
				jsonObj.put("wfActivityDefId", this.activitydefid);
				jsonObj.put("processinstId", this.wfsid);
				jsonObj.put("empCode", this.userId);
				jsonObj.put("empName", this.empName);
				json = this.dppmWfsSrv.queryWf("/dppm/ws/end/projectClosingService/queryProWorkflowInfo", jsonObj.toJSONString());
			} else if ( this.type == 2) {
				// 调用service 获得落地工作流详情
				json = this.dppmWfsSrv.projFallGroundDetail(this.busino, this.userId, this.empName);
			} else if ( this.type == 3) {
				json = this.dppmWfsSrv.queryProjectInfo(this.wfsid, this.userId, this.empName);
			} else if ( this.type == 4) {
				//调用service 获得项目变更工作流详情
				json = this.dppmWfsSrv.queryChangeCheckInfo(this.wfsid, this.userId, this.empName);
			}
			
			if(json != null ){
				//判断查询详情时是否出错
				if(this.type == 1){
					String s = JsonUtil.jsonGetValueBykey(json,"isSuccess");
					if("0".equals(s)){
						 issuccess = "1";
						 json = workflowStrUtil.replaceJsonSpecialCharacter(json);
					}else{
						this.errorInfo = s;
					}
				}else{
					String s = JsonUtil.jsonGetValueBykey(json,"error");
					if(s != null && !s.equals("")){
						this.errorInfo = s;
					} else {
					    issuccess = "1";
					    json = workflowStrUtil.replaceJsonSpecialCharacter(json);
					}
				}
			}
			this.logger.info("============queryWorkInfo action return:" + json);
		} catch (Exception e) {
			this.errorInfo = e.getMessage();
			e.printStackTrace();
		} finally {
			writeToPage(json);
			//保存数据监控
			WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.busino, 
				issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,paramStr);
		}
	}

	/**
	 * 工作流审批
	 * @author 195406 高春玲
	 * @date 2015-9-29
	 */
	public void approveWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	    //初始化json 界面返回值
		String json = "";
		String str = "";
		// post提交时 执行审批
		if("POST".equals(request.getMethod())){
			try {
				// 获得前端封装的json数据
				str = StringUtil.bufferString(request.getReader());
				this.logger.info("============approveWorkInfo action param:" + str);
				this.busino = JsonUtil.jsonGetValueBykey(str,"busino");
				// 获得当前审批人姓名
				this.empName = java.net.URLDecoder.decode(JsonUtil.jsonGetValueBykey(str,"empName"), "utf-8");
				// 执行审批操作
				if( this.type == 1) {
					//结项
//					json = this.dppmWfsSrv.approvalProjClosing(str, this.userId, this.empName);
					json = this.dppmWfsSrv.approveWf("/dppm/ws/end/projectClosingService/approveProWorkflowInfo", str);
				} else if ( this.type == 2 ) {
					//落地
					json = this.dppmWfsSrv.approvalProjFallGround(str, this.userId, this.empName);
				} else if ( this.type == 3 ) {
					//项目新建
					json = this.dppmWfsSrv.approveProjInfo(str, this.userId, this.empName);
				} else if ( this.type == 4 ) {
					//项目变更
					json = this.dppmWfsSrv.approveProjChange(str, this.userId, this.empName);
				}
				
				if(json != null && json.equals("1")) {//审批成功
					issuccess = "1";
				}
				this.logger.info("============approveWorkInfo action return:" + json);
				
				this.errorInfo = json;
			} catch (Exception e) {
				e.printStackTrace();
				json = "0";
				this.errorInfo = e.getMessage();
			} finally {
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, request.getSession(), this.monitorService, null,str);
			}
		}
		writeToPage(response, json);
	}
	
	
	/**
	 * @param dppmWfsSrv
	 */
	public void setDppmWfsSrv(IDppmWorkInfoService dppmWfsSrv) {
		this.dppmWfsSrv = dppmWfsSrv;
	}

	/**
	 * @param monitorService
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}

	/**
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @param busino
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @param flowtype
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	/**
	 * @param errorInfo
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @param wfsid
	 */
	public void setWfsid(String wfsid) {
		this.wfsid = wfsid;
	}

	/**
	 * activitydefid
	 * @param activitydefid
	 */
	public void setActivitydefid(String activitydefid) {
		this.activitydefid = activitydefid;
	}
}