package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weaver.workflow.webservices.WorkflowBaseInfo;
import weaver.workflow.webservices.WorkflowRequestInfo;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.IFSSCWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowNewMonitorEntity;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;

/**
 * 控股报账的工作流 报账工作流 使用webservice方式
 * 
 * @version
 */
public class FSSCWorkInfoAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	private Logger logger = LoggerFactory.getLogger(FSSCWorkInfoAction.class);

	/**
	 * service
	 */
	private IFSSCWorkInfoService fsscWfsSrv;
	//service
	private IMonitorService monitorService;
	//员工信息
	private IQueryEmployeeInfoService employeeService;
	//监控日志
	private IMonitorDao monitordao;
	//操作人工号
  	private String userid;
  	//工号等级
  	private String joblevel;
  	//员工岗位
  	private String jobName;
	// 工作流单据号
	private String busino;
	private String workitemid;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
    private String errorInfo;
    /**
	 * 推送信息实体类
	 */
    private JPushParam jpushParam = new JPushParam();
    private IJPushNewService jPushNewService;
    
    /**
     * 附件接口引用
     */
    /*private static String fsscWorkflowType;
    private static String fsscEmpcode;
    private static String fsscWorkFlowId;
    private static String fsscWorkitemid;
    */
	/**
	 *Fss报账工作流查询
	 * 
	 * @author 280769 张彬
	 * @date 2015-9-14 
	 * @see
	 */
    public void fssQuery() {
        Date begindate = new Date();
        String issuccess = "0";
        String json = null;
        String str = null;
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest requst = ServletActionContext.getRequest();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.addHeader(
                "Access-Control-Allow-Headers",
                "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
        if ("POST".equals(requst.getMethod())) {
            try {
            	//打印出参数
                logger.info("----fssc query action param:" + this.userid
                        + "----" + this.busino + "------" + this.workitemid);
                BufferedReader bu = ServletActionContext.getRequest()
                        .getReader();
                str = StringUtil.bufferString(bu);
                /*String busino = JsonUtil.jsonGetValueBykey(str, "busino");
				String userId = JsonUtil.jsonGetValueBykey(str, "userId");
				String flowtype = JsonUtil.jsonGetValueBykey(str, "flowtype");
				String workitemid = JsonUtil.jsonGetValueBykey(str, "workitemid");
				fsscEmpcode = userId;
				fsscWorkFlowId = busino;
				fsscWorkflowType = flowtype;
				fsscWorkitemid = workitemid;*/
                // 调用service
                json = fsscWfsSrv.fssQueryWorkInfo(str);
                //打印出返回的json
                logger.info("----fssc query action return:" + json);
                /*if (json.indexOf("exceptionType") > 0) {
                	this.errorInfo = json;
                	json = "";
                }*/
                if (com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(json)) {
                	//情况1：从fssc获取返回json为空
                    this.errorInfo = "fssc查询返回json为空" + json;
                } else if(json.indexOf("exceptionType") >= 0){
                	//情况2：从fssc获取返回json有异常
                	this.errorInfo = "fssc查询返回json有异常：" + json;
                	json = "";
                } else{
                	//情况3：查询成功
                    issuccess = "1";
                    this.errorInfo = "fssc查询返回json：" + json;
                }

            } catch (Exception e) {
                this.errorInfo = "fssc查询接口抛异常：" + e.getMessage();
                e.printStackTrace();
            } finally {
                // 保存数据监控
                WFSMonitorUtil.addMonitor(this.userid, "0", this.flowtype,
                        begindate, this.busino, issuccess, this.errorInfo,
                        ServletActionContext.getRequest().getSession(),
                        this.monitorService, null,str);
            }
            //返回给页面
            writeToPage(response, json);
        }
    }
	
	/**
	 * Fss报账工作流审批
	 * @author 280769 张彬
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 * @throws Exception 
	 * @date 2015-9-14 
	 */
	public void fssApprove() throws APIConnectionException, APIRequestException, Exception {
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = 0;    //获取DPM开始时间
		long endTime = 0;    //获取DPM结束时间
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
		long resultTime = 0;    //获取总时长
		String issuccess = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest requst = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		Result<String> result = new Result<String>();
		String str=null;
		String json="";
		String error = "";
		
		if ("POST".equals(requst.getMethod())) {
            try {
            	//获取DPM开始时间
    			startTime = System.currentTimeMillis();
                BufferedReader bu = ServletActionContext.getRequest().getReader();
                str = StringUtil.bufferString(bu);
                //打印出参数
                logger.info("----fssc approve action param:" + str);
                if (!com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(str)) {
                	//打印参数 工号
                	userid = JsonUtil.jsonGetValueBykey(str, "userid");
                	//审批人 等级
                	joblevel = employeeService.getJoblevel(userid);
                	jobName = employeeService.getJobName(userid);
                	//打印参数 业务单号
                	busino = JsonUtil.jsonGetValueBykey(str, "claimNo");
                	//获取开始时间
    				startTime1 = System.currentTimeMillis();
                    // 调用service
                    json = fsscWfsSrv.fssApproveWorkInfo(str);
                    //获取结束时间
    	            endTime1 = System.currentTimeMillis();    
    				logger.info("fssc工作流审批（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
                    //异常监控 band10以上  改写错误信息
                    if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
                    	joblevel != null && joblevel.equals("10") || jobName != null && jobName.contains("总裁") ||
                    			userid != null && userid.equals("107750")){
        				//等级10以上 返回的错误信息都将改成  审批成功
                        issuccess = "success";
                        this.errorInfo = "fssc报账VP审批返回json信息：" + json;
                        error = json;																
                        json = "{\"reason\":\"成功\",\"type\":\"1\"}";
                        /*String type1 = ",\"type\":\"1\"";
                        String s = JsonUtil.jsonGetValueBykey(json, "type");
                        if(s != null && !"1".equals(s)){
                        	json = json + type1;
                        }*/
                        //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                        result.setCount(1);
                        // errorCode  处理成功传给前端值：0
            			result.setErrorCode(Constants.ACTION_RESULT_SUC);
            			// errorMessage 成功信息传给前端：Y
            			result.setErrorMessage(Constants.ACTIVE_YES);
            			logger.info("======fssc报账VP审批userid:"+userid+"======busino:" + busino);
            			
        			}else{
        				if (com.deppon.foss.framework.shared.util.string.StringUtil
                                .isEmpty(json)) {
        					//审批异常
        					issuccess = "error";
                        	//情况1：从fssc获取返回json为空
                        	this.errorInfo = "fssc审批返回json为空" + json;
                        	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                            result.setCount(0);
                            // errorCode  处理失败传给前端值：1
                			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
                			// errorMessage  空指针失败信息传给前端：400
                			result.setErrorMessage(Constants.STATUS_400);
                			logger.info("======fssc审批返回json为空userid:"+userid+"======busino:" + busino);
                        }else{
                        	if (json.indexOf("exceptionType") >= 0) {
                        		//审批异常
            					issuccess = "error";
                        		//情况2：从fssc获取返回json有异常
                        		this.errorInfo = "fssc审批返回json有异常：" + json;
                        		//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                                result.setCount(0);
                                json = "";
                                logger.info("======fssc审批返回json有异常userid:"+userid+"======busino:" + busino);
                            //if(s != null && "0".equals(s)
                            }else if(json.contains("\"type\":\"0\"")){
                            	//情况4：从fssc获取返回:{"reason":"手机提交用户审批请求接口报错：FSSC104181112000112,152116,9000,agree,Drafter异常信息为：JSONObject[\"workcode\"] not found.","type":"0"}
                        		this.errorInfo = "fssc审批返回reason:手机提交用户审批请求接口报错：" + json;
                        		//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                                result.setCount(0);
                                // errorCode  处理失败传给前端值：1
                    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
                    			// errorMessage reason:手机提交用户审批请求接口报错 失败信息传给前端：401
                    			result.setErrorMessage(Constants.STATUS_401);
                        		json = "";
                        		logger.info("======fssc审批返回reason:手机提交用户审批请求接口报错userid:"+userid+"======busino:" + busino);
                            } else {
                            	//情况3：审批成功
                            	String s = JsonUtil.jsonGetValueBykey(json, "type");
                                if (s != null && "1".equals(s)) {// 审批成功
                                    issuccess = "success";
                                    //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                                    result.setCount(1);
                                    // errorCode  处理成功传给前端值：0
                        			result.setErrorCode(Constants.ACTION_RESULT_SUC);
                        			// errorMessage 成功信息传给前端：Y
                        			result.setErrorMessage(Constants.ACTIVE_YES);
                                }
                                //打印出返回json
                                logger.info("======fssc approve userid:"+userid+"====fssc approve action return:" + json);
                                //打印出订单号
                                logger.info("======busino approve action return:" + busino);
                                this.errorInfo = "fssc审批返回json：" + json;
                            }                	
                        }
        			}
                }
                //传给前端data：pc端返回的json字符串
        		result.setData(json);
                //返回给页面
                writeToPage(response, result);
                //获取DPM结束时间
                endTime = System.currentTimeMillis();
                resultTime = endTime - startTime;
        		logger.info("fssc工作流审批（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
        		
            } catch (Exception e) {
            	//审批异常
				issuccess = "error";
                writeToPage(response, "");
                this.errorInfo = "fssc审批接口抛异常：" + e.getMessage();
                // errorCode  处理失败传给前端值：1
    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
    			// errorMessage  失败信息传给前端：N
    			result.setErrorMessage(Constants.ACTIVE_NO);
                logger.info("fssc审批接口抛异常errorInfo:-----"+errorInfo);
            } finally {
            	if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)){
            		String workItemId = JsonUtil.jsonGetValueBykey(str, "workItemId");
					String decision = JsonUtil.jsonGetValueBykey(str, "decision");
					String option = JsonUtil.jsonGetValueBykey(str, "option");
					
					//封装实体数据
					WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
					baseInfo.setWorkflowId(workItemId);
					baseInfo.setWorkflowName(busino);
					baseInfo.setWorkflowTypeId("");
					baseInfo.setWorkflowTypeName("FSSC-报账");
					//封装实体数据
					WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
					requestInfo.setCreateTime(createDate);
					requestInfo.setRemark(option);
					requestInfo.setSubmitButtonName(decision);
					requestInfo.setUserid(userid);
					requestInfo.setWorkflowBaseInfo(baseInfo);
					requestInfo.setMessageType(errorInfo);
					//这个回退节点字段 暂存 返回给前端的结果数据
					requestInfo.setRejectButtonName(result.getData());
					
					/**
					 * 封装监控实体数据
					 */
					WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
					wmEntity.setUserId(userid);
					wmEntity.setJobLevel(joblevel);
					wmEntity.setWorkflowId(busino);
					wmEntity.setRequestId(workItemId);
					wmEntity.setWorkflowName("");
					wmEntity.setSysCode("FSSC-报账");
					wmEntity.setStatus("old/new");
					wmEntity.setApprovalOption(decision);
					wmEntity.setRemark(option);
					wmEntity.setResult(issuccess);
					if(issuccess.equals("success")){
						wmEntity.setIsSuccess(1);
					}
					wmEntity.setData(json);
					wmEntity.setErrorInfo(errorInfo);
					wmEntity.setInterfaceName("fssApprove");
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
					
					
					//VP 及 普通用户的 成功/失败信息 都先存到新工作流监控表
					if(userid !=null && joblevel != null && requestInfo != null && issuccess!=null){
						monitordao.insertApprovalEntityNewMonitor(wmEntity);
//						monitordao.insertApprovalMonitorOld(userid,joblevel,requestInfo,issuccess);
					}
					
					//C 和 D 用户审批成功 保存到 VP用户监控表
					if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D")){
						//保存到 VP用户监控表
	        			monitordao.insertLevelMonitor(userid,joblevel,requestInfo,issuccess);
        			}
					
					if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
							joblevel != null && joblevel.equals("10")|| jobName != null && jobName.contains("总裁") ||
	                    			userid != null && userid.equals("107750")){
						//捕获type:0以外的错误信息  加入VP监控表 并且 推送通知
						if(error.contains("type")){
							//VP用户的错误数据  单独存到一张监控表中
							String err = JsonUtil.jsonGetValueBykey(error, "type");
							if(err != null && !"1".equals(err)){
								if(userid !=null && joblevel != null && requestInfo != null && issuccess!=null){
				        			//保存到 VP用户监控表
				        			monitordao.insertLevelMonitor(userid,joblevel,requestInfo,issuccess);
				        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
				        			String content = "工号："+userid+",订单编号："+busino+",审批时间："+createDate;
				        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
				        			jpushParam.setAlert(content);
				        			jpushParam.setLinktype(0);
//				    				jpushParam.setContent(content);
				    				// 保存推送记录到消息中心
				    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
				    				jPushNewService.saveToMsgCentre(jpushParam, 0);
				    				// 推送
				    				jPushNewService.pushByUserIds(jpushParam);
				        		}
							}
						}else{
							if(userid !=null && joblevel != null && requestInfo != null && issuccess!=null){
			        			//保存到 VP用户监控表
			        			monitordao.insertLevelMonitor(userid,joblevel,requestInfo,issuccess);
			        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
			        			String content = "工号："+userid+",订单编号："+busino+",审批时间："+createDate;
			        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
			        			jpushParam.setAlert(content);
			        			jpushParam.setLinktype(0);
//			    				jpushParam.setContent(content);
			    				// 保存推送记录到消息中心
			    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
			    				jPushNewService.saveToMsgCentre(jpushParam, 0);
			    				// 推送
			    				jPushNewService.pushByUserIds(jpushParam);
			        		}
						}
					}
            	}
            }
		}
	}
	
	/**
	 * @param fsscWfsSrv the fsscWfsSrv to set
	 */
	public void setFsscWfsSrv(IFSSCWorkInfoService fsscWfsSrv) {
		this.fsscWfsSrv = fsscWfsSrv;
	}

	/**
	 * @return the monitorService
	 */
	public IMonitorService getMonitorService() {
		return monitorService;
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
	/*public void setEmpName(String empName) {
		this.empName = empName;
	}*/

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

	public IQueryEmployeeInfoService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IQueryEmployeeInfoService employeeService) {
		this.employeeService = employeeService;
	}

	public IMonitorDao getMonitordao() {
		return monitordao;
	}

	public void setMonitordao(IMonitorDao monitordao) {
		this.monitordao = monitordao;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	public IFSSCWorkInfoService getFsscWfsSrv() {
		return fsscWfsSrv;
	}

	public String getBusino() {
		return busino;
	}

	public String getWorkitemid() {
		return workitemid;
	}

	public String getFlowtype() {
		return flowtype;
	}

	/*public static String getFsscWorkflowType() {
		return fsscWorkflowType;
	}

	public static void setFsscWorkflowType(String fsscWorkflowType) {
		FSSCWorkInfoAction.fsscWorkflowType = fsscWorkflowType;
	}

	public static String getFsscEmpcode() {
		return fsscEmpcode;
	}

	public static void setFsscEmpcode(String fsscEmpcode) {
		FSSCWorkInfoAction.fsscEmpcode = fsscEmpcode;
	}

	public static String getFsscWorkFlowId() {
		return fsscWorkFlowId;
	}

	public static void setFsscWorkFlowId(String fsscWorkFlowId) {
		FSSCWorkInfoAction.fsscWorkFlowId = fsscWorkFlowId;
	}

	public static String getFsscWorkitemid() {
		return fsscWorkitemid;
	}

	public static void setFsscWorkitemid(String fsscWorkitemid) {
		FSSCWorkInfoAction.fsscWorkitemid = fsscWorkitemid;
	}*/
	
	
}