package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weaver.workflow.webservices.WorkflowBaseInfo;
import weaver.workflow.webservices.WorkflowRequestInfo;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.INHrWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowNewMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.nhr.ApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.nhr.QueryLeaveParams;
import com.deppon.dpm.module.wfs.shared.domain.nhr.QueryParam;
import com.deppon.dpm.module.wfs.shared.vo.NhrQueryParamVo;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;

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
	//根据工号查员工信息
	private IQueryEmployeeInfoService employeeService;
	//监控日志
	private IMonitorDao monitordao;
	// 工号
	private String empCode;
	// 工作流单据号
	private String busino;
	//工号等级
  	private String joblevel;
  	//员工所在岗位
  	private String jobName;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
    private String errorInfo;
    
    //老工作流 名称
    private String workFlowType;
    /**
     * 附件接口引用
     */
    private static String nhrWorkflowType;
   /* private static String nhrEmpcode;
    private static String nhrWorkFlowId;
    */
    /**
	 * 推送信息实体类
	 */
    private JPushParam jpushParam = new JPushParam();
    private IJPushNewService jPushNewService;
    
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
//				nhrWorkFlowId = busino;
				//给empCode赋值
				empCode = query.getEmpCode();
//				nhrEmpcode = empCode;
				//给workflowType赋值
				workFlowType = query.getWorkFlowType();
				nhrWorkflowType = workFlowType;
				//调用service
				String json = nhrWfsSrv.queryWorkInfo(query);
				
				//打印出返回的json
				logger.info("------nhr query empCode:"+empCode+"----nhr query action result:" + json);
				//打印出busino
	            logger.info("------nhr busino query action return:" + busino);
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
				WFSMonitorUtil.addMonitor(this.empCode, "0", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService,null,str);
			}
		}
	}
	/**
	 * 审批中  调用节点查询 接口
	 */
	public void queryAppWorkInfo() {
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
			QueryLeaveParams query = null;
			str = StringUtil.bufferString(bu);
			//打印出参数
			logger.info("----nhr approve content query action param:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				query = JSONObject.parseObject(str,
						QueryLeaveParams.class);
				//转换中文 问题
				query.setEmpName(java.net.URLDecoder.decode(query.getEmpName(), "utf-8"));
				//给busino赋值
				busino = query.getWorkFlowNum();
				//给empCode赋值
				empCode = query.getEmpCode();
				//调用service
				String json = nhrWfsSrv.queryLeaveWorkInfo(query);
				//打印出返回的json
				logger.info("----nhr approve content query empCode:"+empCode+"----nhr approve content query action result:" + json);
				//打印出busino
                logger.info("----nhr busino approve content query action return:" + busino);
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
				WFSMonitorUtil.addMonitor(this.empCode, "0", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService,null,str);
			}
		}
	}

	/**
	 * 工作流审批
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 * @throws Exception 
	 */
	public void approveWorkInfo() throws APIConnectionException, APIRequestException, Exception {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		Result<String> result = new Result<String>();
		// 构建审批后勤需要的参数
		ApproveParam audit = null;
		String str = null;
		String json = "";
		String error = "";
		String succ = "";
		try {
			//获取DPM开始时间
			startTime = System.currentTimeMillis();
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			str = StringUtil.bufferString(bu);
			//打印出审批的参数
			logger.info("============nhr approve action param:"+str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				audit = JSONObject.parseObject(str,
						ApproveParam.class);
				audit.setDealEmpName(java.net.URLDecoder.decode(audit.getDealEmpName(), "utf-8"));
				//给busino赋值
				busino = audit.getBusino();
				//给empCode赋值
				empCode = audit.getDealEmpCode();
				//审批人 等级
            	joblevel = employeeService.getJoblevel(empCode);
            	//该员工所在岗位
            	jobName = employeeService.getJobName(empCode);
            	//获取开始时间
				startTime1 = System.currentTimeMillis();
				//调用service
				json = nhrWfsSrv.approveWorkInfo(audit);
				//获取结束时间
	            endTime1 = System.currentTimeMillis();    
				logger.info("nhr工作流审批（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
				//异常监控 band10以上  改写错误信息
                if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
                	joblevel != null && joblevel.equals("10") || jobName != null && jobName.contains("总裁") ||
                			empCode != null && empCode.equals("107750")){
    				//等级10以上 返回的错误信息都将改成  审批成功
                    issuccess = "success";
                    this.errorInfo = "nhr人力VP审批返回json信息：" + json;
                    error = json;
                    json = "{\"errorMeassge\":null,\"success\":true}";
                    /*String s =  ",\"success\":true";
                    succ = JsonUtil.jsonGetValueBykey(json,"success");
                    if(succ != null && !succ.equals("true")){
                    	json = s;
                    }*/
                    //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                    result.setCount(1);
                    // errorCode  处理成功传给前端值：0
        			result.setErrorCode(Constants.ACTION_RESULT_SUC);
        			// errorMessage 成功信息传给前端：Y
        			result.setErrorMessage(Constants.ACTIVE_YES);
        			logger.info("======nhr人力VP审批empCode:"+empCode+"======busino:" + busino);
    			}else{
    				if (com.deppon.foss.framework.shared.util.string.StringUtil
                            .isEmpty(json)) {
    					//审批异常
    					issuccess = "error";
                    	//情况1：从nhr获取返回json为空
                    	this.errorInfo = "nhr审批返回json为空" + json;
                    	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                        result.setCount(0);
                        // errorCode  处理失败传给前端值：1
            			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
            			// errorMessage  失败信息传给前端：N
            			result.setErrorMessage(Constants.ACTIVE_NO);
            			logger.info("======nhr审批返回json为空empCode:"+empCode+"======busino:" + busino);
                    }else{
                    	String errorMessage = JsonUtil.jsonGetValueBykey(json,"errorMessage");
                    	String err = JsonUtil.jsonGetValueBykey(json,"success");
        				//判断审批是否成功
        				if(errorMessage != null && !("null").equals(errorMessage) || err != null && err.equals("false")) {
        					//审批异常
        					issuccess = "error";
        					this.errorInfo = "nhr审批返回json有异常：" + json;
                    		//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                            result.setCount(0);
                            // errorCode  处理失败传给前端值：1
                			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
                			// errorMessage  失败信息传给前端：N
                			result.setErrorMessage(Constants.ACTIVE_NO);
                            json = "";
                            logger.info("======nhr审批返回json有异常empCode:"+empCode+"======busino:" + busino);
        				}else{
        					succ = JsonUtil.jsonGetValueBykey(json,"success");
            				//判断审批是否成功
            				if(succ != null && succ.equals("true")) {
            					//审批成功
            					issuccess = "success";
            					this.errorInfo = "nhr审批返回json成功：" + json;
            					//如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                                result.setCount(1);
                                // errorCode  处理成功传给前端值：0
                    			result.setErrorCode(Constants.ACTION_RESULT_SUC);
                    			// errorMessage 成功信息传给前端：Y
                    			result.setErrorMessage(Constants.ACTIVE_YES);
            				}
            				//打印出返回的json
            				logger.info("============nhr approve empCode:"+empCode+"============nhr approve action result:" + json);
            				//打印出busino
                            logger.info("============nhr busino approve action return:" + busino);
            				logger.info("----nhr approve action result:" + json);
            				this.errorInfo = "nhr审批返回json：" + json;
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
    		logger.info("nhr工作流审批（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
    		
		} catch (Exception e) {
			//审批异常
			issuccess = "error";
			//打印出报错信息
			e.printStackTrace();
			writeToPage(response, "0");
			this.errorInfo = "nhr审批接口抛异常：" + e.getMessage();
			logger.info("nhr审批接口抛异常errorInfo:-----"+errorInfo);
		}finally{
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//审批类型字段 ：同意（agree）、退回（back）、不同意（disAgree）
				String decision = audit.getDecision();
				//审批意见
				String opinion = audit.getOpinion();
				//流程实例Id
				String activityinstid = audit.getActivityinstid();
				//封装实体数据
				WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
				baseInfo.setWorkflowId(activityinstid);
				baseInfo.setWorkflowName(busino);
				baseInfo.setWorkflowTypeId("");
				baseInfo.setWorkflowTypeName("INHR-人事");
				//封装实体数据
				WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
				requestInfo.setCreateTime(createDate);
				requestInfo.setRemark(opinion);
				requestInfo.setSubmitButtonName(decision);
				requestInfo.setUserid(empCode);
				requestInfo.setWorkflowBaseInfo(baseInfo);
				requestInfo.setMessageType(errorInfo);
				//这个回退节点字段 暂存 返回给前端的结果数据
				requestInfo.setRejectButtonName(result.getData());
				//将前端传来的 工作流审批参数 由json转为实体
//        		weaver.workflow.webservices.WorkflowRequestInfo requestInfo = JSONObject.parseObject(entity.getWorkflowInfo(), weaver.workflow.webservices.WorkflowRequestInfo.class);
				
				/**
				 * 封装监控实体数据
				 */
				WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
				wmEntity.setUserId(empCode);
				wmEntity.setJobLevel(joblevel);
				wmEntity.setWorkflowId(busino);
				wmEntity.setRequestId("");
				wmEntity.setWorkflowName(nhrWorkflowType);
				wmEntity.setSysCode("INHR-人事");
				wmEntity.setStatus("old");
				wmEntity.setApprovalOption(decision);
				wmEntity.setRemark(opinion);
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
				
				//VP 及 普通用户的 成功/失败信息 都先存到新工作流监控表
				if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
					monitordao.insertApprovalEntityNewMonitor(wmEntity);
//        			monitordao.insertApprovalMonitorOld(empCode,joblevel,requestInfo,issuccess);
        			
        		}
				if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
						joblevel != null && joblevel.equals("10") || jobName != null && jobName.contains("总裁") ||
	                			empCode != null && empCode.equals("107750")){
					//捕获 success:false以外的错误信息【Read timed out】
					if(error.contains("success")){
						//VP用户的错误数据  单独存到一张监控表中
						String err = JsonUtil.jsonGetValueBykey(error,"success");
						if(err != null && !err.equals("true")){
							if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
			        			//保存到 VP用户监控表
			        			monitordao.insertLevelMonitor(empCode,joblevel,requestInfo,issuccess);
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
			        		}
						}
					}else{
						if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
		        			//保存到 VP用户监控表
		        			monitordao.insertLevelMonitor(empCode,joblevel,requestInfo,issuccess);
		        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
		        			String content = "工号："+empCode+",订单编号："+busino+",审批时间："+createDate;
		        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
		        			jpushParam.setAlert(content);
		        			jpushParam.setLinktype(0);
//		    				jpushParam.setContent(content);
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
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
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
	
	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
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
	public INHrWorkInfoService getNhrWfsSrv() {
		return nhrWfsSrv;
	}
	public IMonitorService getMonitorService() {
		return monitorService;
	}
	public String getEmpCode() {
		return empCode;
	}
	public String getBusino() {
		return busino;
	}
	public String getFlowtype() {
		return flowtype;
	}
	public String getWorkFlowType() {
		return workFlowType;
	}
	public void setWorkFlowType(String workFlowType) {
		this.workFlowType = workFlowType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/*public static String getNhrEmpcode() {
		return nhrEmpcode;
	}
	public static void setNhrEmpcode(String nhrEmpcode) {
		NHrWorkInfoAction.nhrEmpcode = nhrEmpcode;
	}
	public static String getNhrWorkFlowId() {
		return nhrWorkFlowId;
	}
	public static void setNhrWorkFlowId(String nhrWorkFlowId) {
		NHrWorkInfoAction.nhrWorkFlowId = nhrWorkFlowId;
	}
	*/
	
	public static String getNhrWorkflowType() {
		return nhrWorkflowType;
	}
	public static void setNhrWorkflowType(String nhrWorkflowType) {
		NHrWorkInfoAction.nhrWorkflowType = nhrWorkflowType;
	}
}