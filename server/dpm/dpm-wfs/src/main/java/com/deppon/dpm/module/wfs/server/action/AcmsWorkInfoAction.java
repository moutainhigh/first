package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weaver.workflow.webservices.WorkflowBaseInfo;
import weaver.workflow.webservices.WorkflowRequestInfo;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.IAcmsWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowNewMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.acms.AcmsApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.acms.WorkflowinfoRequest;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;

public class AcmsWorkInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger  = LoggerFactory.getLogger(AcmsWorkInfoAction.class);
	//service
    //private IApprovePeopleQueryService approvePeopleQueryService;
    //service
    //private ITpushNewsService tpushNewsService;
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
	//private String workitemid;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
    private String errorInfo;
    
    /**
     * 新增参数
     */
    //工号等级
  	private String joblevel;
  	//员工所在岗位
  	private String jobName;
  	//根据工号查员工信息
  	private IQueryEmployeeInfoService empService;
  	//监控日志
  	private IMonitorDao monitorDao;
  	/**
	 * 推送信息实体类
	 */
    private JPushParam jpushParam = new JPushParam();
    private IJPushNewService jPushNewService;
    
    /**
	 * 工作流审批
     * @throws APIRequestException 
     * @throws APIConnectionException 
     * @throws Exception 
	 */
	public void approveWorkInfo() throws APIConnectionException, APIRequestException, Exception {
		Date begindate = new Date();
		String issuccess = "0";
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = 0;    //获取开始时间
		long endTime = 0;
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
		long resultTime = 0;    //获取总时长
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		AcmsApproveParam audit = null;// 构建审批后勤需要的参数
		String str = null;
		String json = null;
		String data = null;
		if ("POST".equals(request.getMethod())) {
			try {
				//获取ACMS开始时间
    			startTime = System.currentTimeMillis();
				BufferedReader bu = request.getReader();
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
					//审批人工号赋值
					String appCode = audit.getAppCode();
	            	//审批人 等级
	            	joblevel = empService.getJoblevel(appCode);
	            	
					startTime1 = System.currentTimeMillis();    //获取开始时间
					//调用service
					json = acmsWfsSrv.approveWorkInfo(audit);
					endTime1 = System.currentTimeMillis();    //获取结束时间
					logger.info("acms工作流审批（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
	            	
					//异常监控 band10以上  改写错误信息
                    if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
                    	joblevel != null && joblevel.equals("10") || jobName != null && jobName.contains("总裁") ||
                    	empCode != null && empCode.equals("107750")){
        				//等级10以上 返回的错误信息都将改成  审批成功
                        issuccess = "1";
                        data = json;
                        this.errorInfo = "acms系统VP审批返回json信息：" + json;
                        json = "{\"resultCode\":\"0\"}";
            			logger.info("======acms系统VP审批empCode:"+empCode+"======busino:" + busino);
        			}else{
        				if (json != null && json.equals("0")) {// 审批成功
    						issuccess = "1";
    						errorInfo = json;
    					} else if(StringUtils.isNotBlank(json)) {
    						String s = JsonUtil.jsonGetValueBykey(json,"resultCode");
    						if("0".equals(s)) {//审批成功
    							issuccess = "1";
    							errorInfo = json;
    						}
    					}
        			}
				}
				//打印出返回的json
				logger.info("============acms approve action return:" + json);
				//返回给页面
				writeToPage(response, json);
				
				//获取ACMS结束时间
                endTime = System.currentTimeMillis();
                resultTime = endTime - startTime;
                logger.info("acms工作流审批（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
                
			} catch (Exception e) {
				//审批异常
				issuccess = "0";
				writeToPage(response, "1");
				errorInfo = e.getMessage();
			} finally {
				if (!StringUtil.isEmpty(str)) {
					//流程实例id  10465294 (每个节点相同)
//					long processinstid = audit.getApprovelEntity().getProcessinstid();
					//当前活动定义ID  manualActivity19
//					String activityDefId = audit.getApprovelEntity().getActivityDefId();
					//工作项Id   1914420(每个节点不同)
					long workItemId = audit.getApprovelEntity().getWorkItemId();
					//审批操作  0 同意 1 不同意 2 退回
					String isAgree = audit.getApprovelEntity().getIsAgree();
					//审批意见
					String approveOption = audit.getApprovelEntity().getApproveOpinion();
					//1 是子公司设立、变更及注销申请   3 是证照补办及分公司变更申请
					int flag = audit.getFlag();
					/**
					 * 封装监控实体数据
					 */
					WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
					wmEntity.setUserId(empCode);
					wmEntity.setJobLevel(joblevel);
					wmEntity.setWorkflowId(busino);
					wmEntity.setRequestId("工作项ID:"+String.valueOf(workItemId));
					//1 : 子公司设立、变更及注销申请  
					if(flag==1){
						wmEntity.setWorkflowName("com.deppon.bpms.module.acms.bpsdesign.company.subsidiaryChangeCancell");
					//3 : 证照补办及分公司变更申请
					}else if(flag==3){
						wmEntity.setWorkflowName("com.deppon.bpms.module.acms.bpsdesign.company.zzbuAndSubCompanyChange");
					}else{
						wmEntity.setWorkflowName("");
					}
					
					wmEntity.setSysCode("ACMS-证照");
					wmEntity.setStatus("old");
					if(isAgree.equals("0")){
						wmEntity.setApprovalOption("同意");
					}else if(isAgree.equals("1")){
						wmEntity.setApprovalOption("不同意");
					}else if(isAgree.equals("2")){
						wmEntity.setApprovalOption("退回");
					}else{
						wmEntity.setApprovalOption(isAgree);
					}
					wmEntity.setRemark(approveOption);
					wmEntity.setResult(issuccess);
					if(issuccess.equals("success")){
						wmEntity.setIsSuccess(1);
					}
					wmEntity.setData(json);
					wmEntity.setErrorInfo(errorInfo);
					wmEntity.setInterfaceName("approveWorkInfo");
					wmEntity.setRejectNode("");
					Date createTime = sdf.parse(createDate);
					wmEntity.setCreateTime(createTime);
					wmEntity.setMethodTime(String.valueOf(resultTime));
					wmEntity.setFileDocId("");
					wmEntity.setFileName("");
					wmEntity.setFilePath("");
					wmEntity.setFileOpenCount(0);
					wmEntity.setUi_type("");
					wmEntity.setRemark1("");
					wmEntity.setRemark2("");
					wmEntity.setRemark3("");
					
					
					//封装实体数据
					WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
					//busino为字符串  只能存 纯数字
					baseInfo.setWorkflowId(String.valueOf(workItemId));
					
					//1 : 子公司设立、变更及注销申请  
					if(flag==1){
						baseInfo.setWorkflowName(busino+":com.deppon.bpms.module.acms.bpsdesign.company.subsidiaryChangeCancell");
					//3 : 证照补办及分公司变更申请
					}else if(flag==3){
						baseInfo.setWorkflowName(busino+":com.deppon.bpms.module.acms.bpsdesign.company.zzbuAndSubCompanyChange");
					}else{
						baseInfo.setWorkflowName(busino+":");
					}
					
					baseInfo.setWorkflowTypeName("ACMS-证照");
					//封装实体数据
					WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
					requestInfo.setCreateTime(createDate);
					requestInfo.setRemark(approveOption);
					if(isAgree.equals("0")){
						requestInfo.setSubmitButtonName("同意");
					}else if(isAgree.equals("1")){
						requestInfo.setSubmitButtonName("不同意");
					}else if(isAgree.equals("2")){
						requestInfo.setSubmitButtonName("退回");
					}else{
						requestInfo.setSubmitButtonName(isAgree);
					}
					requestInfo.setUserid(empCode);
					requestInfo.setWorkflowBaseInfo(baseInfo);
					requestInfo.setMessageType(errorInfo);
					//这个回退节点字段 暂存 返回给前端的结果数据
					requestInfo.setRejectButtonName(json);
					
					//VP 及 普通用户的 成功/失败信息 都先存到新工作流监控表
					if(empCode !=null && joblevel != null && wmEntity != null && issuccess!=null){
						monitorDao.insertApprovalEntityNewMonitor(wmEntity);
					}
					
					if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
							joblevel != null && joblevel.equals("10")|| jobName != null && jobName.contains("总裁") ||
							joblevel != null && joblevel.equals("09") || joblevel != null && joblevel.equals("08") || 
									empCode != null && empCode.equals("107750")){
						//捕获resultCode:0以外的错误信息  加入VP监控表 并且 推送通知
						if("".equals(data) || data == null || com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(data)){
							if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
			        			//保存到 VP用户监控表
								monitorDao.insertLevelMonitor(empCode,joblevel,requestInfo,issuccess);
			        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
			        			String content = "工号："+empCode+",订单编号："+busino+",审批时间："+createDate;
			        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
			        			jpushParam.setAlert(content);
			        			jpushParam.setLinktype(0);
//			    				jpushParam.setContent(content);
			    				// 保存推送记录到消息中心
			    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
			    				jPushNewService.saveToMsgCentre(jpushParam, 0);
			    				// 推送
			    				jPushNewService.pushByUserIds(jpushParam);
			    				
			    				// 保存数据监控  发送邮箱
								WFSMonitorUtil.addMonitor(this.empCode, "1", this.flowtype,
										begindate, this.busino, issuccess, this.errorInfo,
										ServletActionContext.getRequest().getSession(),
										this.monitorService, null, str);
			        		}
						}else if(data.contains("resultCode")){
							//VP用户的错误数据  单独存到一张监控表中
							String code = JsonUtil.jsonGetValueBykey(data, "resultCode");
							if(code != null && !"0".equals(code)){
								if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
				        			//保存到 VP用户监控表
									monitorDao.insertLevelMonitor(empCode,joblevel,requestInfo,issuccess);
				        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
				        			String content = "工号："+empCode+",订单编号："+busino+",审批时间："+createDate;
				        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
				        			jpushParam.setAlert(content);
				        			jpushParam.setLinktype(0);
//				    				jpushParam.setContent(content);
				    				// 保存推送记录到消息中心
				    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
				    				jPushNewService.saveToMsgCentre(jpushParam, 0);
				    				// 推送
				    				jPushNewService.pushByUserIds(jpushParam);
				    				
				    				// 保存数据监控  发送邮箱
									WFSMonitorUtil.addMonitor(this.empCode, "1", this.flowtype,
											begindate, this.busino, issuccess, this.errorInfo,
											ServletActionContext.getRequest().getSession(),
											this.monitorService, null, str);
				        		}
							}
						}else{
							if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
			        			//保存到 VP用户监控表
								monitorDao.insertLevelMonitor(empCode,joblevel,requestInfo,issuccess);
			        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
			        			String content = "工号："+empCode+",订单编号："+busino+",审批时间："+createDate;
			        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
			        			jpushParam.setAlert(content);
			        			jpushParam.setLinktype(0);
//			    				jpushParam.setContent(content);
			    				// 保存推送记录到消息中心
			    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
			    				jPushNewService.saveToMsgCentre(jpushParam, 0);
			    				// 推送
			    				jPushNewService.pushByUserIds(jpushParam);
			    				
			    				// 保存数据监控  发送邮箱
								WFSMonitorUtil.addMonitor(this.empCode, "1", this.flowtype,
										begindate, this.busino, issuccess, this.errorInfo,
										ServletActionContext.getRequest().getSession(),
										this.monitorService, null, str);
			        		}
						}
					}
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
	/*public void setApprovePeopleQueryService(
			IApprovePeopleQueryService approvePeopleQueryService) {
		this.approvePeopleQueryService = approvePeopleQueryService;
	}
	*//**
	 * @param tpushNewsService the tpushNewsService to set
	 *//*
	public void setTpushNewsService(ITpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}*/
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
	/*public void setWorkitemid(String workitemid) {
		this.workitemid = workitemid;
	}*/
	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public IMonitorService getMonitorService() {
		return monitorService;
	}

	public IAcmsWorkInfoService getAcmsWfsSrv() {
		return acmsWfsSrv;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public String getProcessDefName() {
		return processDefName;
	}

	public long getProcessInstId() {
		return processInstId;
	}

	public String getFlowtype() {
		return flowtype;
	}

	public IQueryEmployeeInfoService getEmpService() {
		return empService;
	}

	public void setEmpService(IQueryEmployeeInfoService empService) {
		this.empService = empService;
	}

	public IMonitorDao getMonitorDao() {
		return monitorDao;
	}

	public void setMonitorDao(IMonitorDao monitorDao) {
		this.monitorDao = monitorDao;
	}
	
}
