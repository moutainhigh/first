package com.deppon.dpm.module.wfs.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weaver.workflow.webservices.WorkflowBaseInfo;
import weaver.workflow.webservices.WorkflowRequestInfo;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.DecryptNewFile;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.WeaverAndBPSMobileData;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.foss.framework.shared.util.string.StringUtil;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.IWeaverAndBPSMobileWorkflowService;

/**
 * lsp 老工作流
 * 
 * @version
 */
public class DLspWeaverAndBPSMobileWorkInfoAction extends BaseAction {

	private static final long serialVersionUID = 1397420409043898745L;
	private static Logger logger  = LoggerFactory.getLogger(DLspWeaverAndBPSMobileWorkInfoAction.class);

	/**
	 * service
	 */
	private IWeaverAndBPSMobileWorkflowService weaverAndBPSMobileWorkflowService;
	//service
	private IMonitorService monitorService;
	// service层
	private IWeaverWfsService weaverService;
	//根据工号查员工信息
	private IQueryEmployeeInfoService employeeService;
	//监控日志
	private IMonitorDao monitordao;
	
    //工作流编号
  	private String docId;
  	//操作人工号
  	private String empCode;
    //操作人姓名
	private String empName;
	//工号等级
  	private String joblevel;
  	//员工所在岗位
  	private String jobName;
	// 错误信息 用于错误预警
    private String errorInfo;
    // 工作流类型
 	private String flowtype;
 	/**
 	 * lsp 静态数据 从详情中获取值
 	 */
 	private static String workFlowId;
 	private static String empcode;
 	/**
 	 * nhr 静态数据 从NHrWorkInfoAction详情中获取值
 	 */
 	/*private static String nhrEmpcode;
 	private static String nhrWorkFlowId;
 	private static String nhrWorkflowType;
 	private NHrWorkInfoAction nhrWorkInfoAction;
 	*/
 	/**
 	 * fssc 静态数据 从FSSCWorkInfoAction详情中获取
 	 */
 	/*private static String fsscWorkflowType;
    private static String fsscEmpcode;
    private static String fsscWorkFlowId;
    private static String fsscWorkitemid;
    private FSSCWorkInfoAction fsscWorkInfoAction;
    */
 	/**
	 * 推送信息实体类
	 */
    private JPushParam jpushParam = new JPushParam();
    private IJPushNewService jPushNewService;
 	/**
 	 * 附件 参数
 	 */
 	//工号
 	private String userId;
 	//lsp 返回的 文件路径url
 	private String filePath;
 	//文件名称
    private String fileName;
    //系统类型
    private String syscode;
    
    
 	/**
 	 * lsp老工作流详情 没有头像
 	 */
	public void WeaverAndBPSMobileWorkflowInfo() {
		Date begindate = new Date();
        String issuccess = "0";
        String json = "";
        String paramStr = "";
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
        Result<String> result = new Result<String>();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Access-Control-Allow-Origin", "*");
//        if ("POST".equals(requst.getMethod())) {
            try {
            	//打印出参数
                logger.info("----bpsmobile query action param:" + this.docId
                        + "------" + this.empCode + "------" + this.empName);
              //给实体赋值
                WeaverAndBPSMobileData weaverAndBPSMobileData = new WeaverAndBPSMobileData(
    					this.empCode, this.empName, this.docId);
                paramStr = JsonUtil.beanToJsonString(weaverAndBPSMobileData);
                //打印出参数
    			logger.info("----lsp query action paramStr:" + paramStr);
    			startTime1 = System.currentTimeMillis();    //获取开始时间
                if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(paramStr)) {
                	empCode = weaverAndBPSMobileData.getEmpCode();
                	docId = weaverAndBPSMobileData.getDocId();
                	workFlowId = docId;
                	empcode = empCode;
                	// 调用service
                    //该方法通过dubbo服务调用pc端实现接口，通过参数请求pc端返回工作流详情的json数据
                    json = weaverAndBPSMobileWorkflowService.queryDetailInfo(paramStr);
                    endTime1 = System.currentTimeMillis();    //获取结束时间
        			logger.info("lsp old 工作流详情（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
                    //打印出返回的json
                    logger.info("------lsp query empCode:"+this.empCode+"----bpsmobile query action return:" + json);
                    //打印出busino
                    logger.info("------docId query action return:" + this.docId);
                    if (com.deppon.foss.framework.shared.util.string.StringUtil
                            .isEmpty(json)) {
                    	//情况1：从lsp获取返回json为空
                        this.errorInfo = "lsp查询返回json为空" + json;
                        //如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                        result.setCount(0);
                    } else if(json.indexOf("exceptionType") >= 0){
                    	//情况2：从lsp获取返回json有异常
                    	this.errorInfo = "lsp查询返回json有异常：" + json;
                    	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                        result.setCount(0);
                    	json = "";
                    } else{
                    	//情况3：查询成功
                        issuccess = "1";
                        this.errorInfo = "lsp查询返回json：" + json;
                        //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                        result.setCount(1);
                        // errorCode  处理成功传给前端值：0
            			result.setErrorCode(Constants.ACTION_RESULT_SUC);
            			// errorMessage 成功信息传给前端：Y
            			result.setErrorMessage(Constants.ACTIVE_YES);
                    }
            		//传给前端data：pc端返回的json字符串
            		result.setData(json);
            		//返回给页面
            		writeToPage(response, result);
                }
    			
            } catch (Exception e) {
                this.errorInfo = "lsp查询接口抛异常：" + e.getMessage();
                e.printStackTrace();
                // errorCode  处理失败传给前端值：1
    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
    			// errorMessage  失败信息传给前端：N
    			result.setErrorMessage(Constants.ACTIVE_NO);
            } finally {
                // 保存数据监控
                WFSMonitorUtil.addMonitor(this.empCode, "0", this.flowtype,
                        begindate, this.docId, issuccess, this.errorInfo,
                        ServletActionContext.getRequest().getSession(),
                        this.monitorService, null, paramStr);
            }
            
//        }
	}
	
	/**
	 * lsp老工作流审批
	 * @throws Exception 
	 */
	public void approveWeaverAndBPSMobile() throws Exception {
		this.solveCrossDomain();
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = System.currentTimeMillis();    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
		long startTime1 = 0;    //获取DPM开始时间
		long endTime1 = 0;    //获取DPM结束时间
		String issuccess = "0";
		HttpServletRequest request = ServletActionContext.getRequest();
		
		net.sf.json.JSONObject pJson = null;
		net.sf.json.JSONObject bJson = null;
		String processJson = null;
		String billJson = null;
		String json="";
		String data = "";
		String error = "";
		String succ = "";
		Result<String> result = new Result<String>();
        if ("POST".equals(request.getMethod())) {
        	try {
        		//前端去掉stringify 采用request.getParameter
//        		String processInfo = request.getParameter("processInfo");
//        		System.out.println(processInfo);
        		startTime1 = System.currentTimeMillis();
        		//取json字符串
        		pJson = net.sf.json.JSONObject.fromObject(request.getParameter("processInfo"));
        		bJson = net.sf.json.JSONObject.fromObject(request.getParameter("billInfo"));
        		logger.info("前端参数 processInfo----"+pJson.toString());
        		logger.info("前端参数 billInfo----"+bJson.toString());
        		//转成String参数
        		processJson = pJson.toString();
        		billJson = bJson.toString();
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(processJson) && !com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(billJson)) {
					empCode = pJson.getString("empCode");
					docId = pJson.getString("docId");
					//审批人 等级
	            	joblevel = employeeService.getJoblevel(empCode);
	            	//该员工所在岗位
	            	jobName = employeeService.getJobName(empCode);
	            	startTime = System.currentTimeMillis();    //获取开始时间
					//该方法通过dubbo服务调用pc端实现接口，通过参数请求pc端返回工作流审批的json数据
					json = weaverAndBPSMobileWorkflowService.auditBill(processJson, billJson);
					endTime = System.currentTimeMillis();    //获取结束时间
					logger.info("dlsp工作流审批（方法） - 程序运行时间  - 后台：" + (endTime - startTime) + "ms");
					//异常监控 band10以上  改写错误信息
                    if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
                    	joblevel != null && joblevel.equals("10") || jobName != null && jobName.contains("总裁") ||
                    	empCode != null && empCode.equals("107750")){
        				//等级10以上 返回的错误信息都将改成  审批成功
                        issuccess = "success";
                        data = json;
                        this.errorInfo = "lsp后勤VP审批返回json信息：" + json;
                        error = json;
                        json = "{\"result\":\"true\"}";
                        //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                        result.setCount(1);
                        // errorCode  处理成功传给前端值：0
            			result.setErrorCode(Constants.ACTION_RESULT_SUC);
            			// errorMessage 成功信息传给前端：Y
            			result.setErrorMessage(Constants.ACTIVE_YES);
            			logger.info("======lsp后勤VP审批empCode:"+empCode+"======docId:" + docId);
        			}else{
        				if (com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(json)) {
        					//审批异常
        					issuccess = "error";
    	                	//情况1：从lsp获取返回json为空
    	                	this.errorInfo = "lsp审批返回json为空" + json;
    	                	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
    	        			result.setCount(0);
    	        			// errorCode  处理失败传给前端值：1
                			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
                			// errorMessage  失败信息传给前端：N
                			result.setErrorMessage(Constants.ACTIVE_NO);
    	        			logger.info("======lsp审批返回json为空empCode:"+empCode+"======docId:" + docId);
    	                }else{
    	                	String reason = JsonUtil.jsonGetValueBykey(json,"reason");
                        	String err = JsonUtil.jsonGetValueBykey(json,"result");
                        	//判断审批是否成功
            				if(reason != null && !("null").equals(reason) || err != null && err.equals("false")) {
            					//审批异常
            					issuccess = "error";
            					data = json;
            					this.errorInfo = "lsp审批返回json有异常：" + json;
                        		//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                                result.setCount(0);
                                // errorCode  处理失败传给前端值：1
                    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
                    			// errorMessage  失败信息传给前端：N
                    			result.setErrorMessage(Constants.ACTIVE_NO);
                                json = "";
                                logger.info("======lsp审批返回json有异常empCode:"+empCode+"======docId:" + docId);
            				}else{
            					//情况3：审批成功
            					succ = JsonUtil.jsonGetValueBykey(json, "result");
                                if (succ != null && "true".equals(succ)) {// 审批成功
                                	issuccess = "success";
                                	data = json;
                                	this.errorInfo = "lsp审批返回json成功：" + json;
                                	//如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
        	                        result.setCount(0);
        	                        // errorCode  处理成功传给前端值：0
        	                		result.setErrorCode(Constants.ACTION_RESULT_SUC);
        	                		// errorMessage 成功信息传给前端：Y
        	                		result.setErrorMessage(Constants.ACTIVE_YES);
    	                        }
                                //打印出返回json
    	                        logger.info("============lsp approve empCode:"+this.empCode+"============lsp approve action return:" + json);
    	                        //打印出docId
    	                        logger.info("============docId approve action return:" + this.docId);
    	                        logger.info("----lsp approve action result:" + json);
    	                        this.errorInfo = "lsp审批返回json：" + json;
            				}
    	                }
        			}
	        		//传给前端data：pc端返回的json字符串
	        		result.setData(json);
	        		//返回给页面
	        		writeToPage(result);
	        		//获取DPM结束时间
	                endTime1 = System.currentTimeMillis();
	                resultTime = endTime1 - startTime1;
	        		logger.info("DLSP工作流审批（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
	            }
			} catch (Exception e) {
				//审批异常
				issuccess = "error";
                this.errorInfo = "lsp审批接口抛异常：" + e.getMessage();
                // errorCode  处理失败传给前端值：1
    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
    			// errorMessage 失败信息传给前端：N
    			result.setErrorMessage(Constants.ACTIVE_NO);
                logger.info("lsp审批接口抛异常errorInfo:-----"+errorInfo);
			}finally{
				if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(processJson) && !com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(billJson)){
					//审批类型字段 ：同意（agree）、退回（back）、不同意（disAgree）
					String wfDecision = pJson.getString("wfDecision");
					//审批意见
					String approveOption = pJson.getString("approveOption");
					//NO.10465170
					String wfProcInstId = pJson.getString("wfProcInstId");
					//封装实体数据
					WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
					baseInfo.setWorkflowId(docId);
					baseInfo.setWorkflowName("");
					baseInfo.setWorkflowTypeName("DLSP-人力与后勤");
					//封装实体数据
					WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
					requestInfo.setRequestId(wfProcInstId);
					requestInfo.setCreateTime(createDate);
					requestInfo.setRemark(errorInfo);
					requestInfo.setSubmitButtonName(wfDecision);
					requestInfo.setUserid(empCode);
					requestInfo.setWorkflowBaseInfo(baseInfo);
					if(approveOption.length() >= 50){
						requestInfo.setMessageType(approveOption.substring(0, 50));
					}else{
						requestInfo.setMessageType(approveOption);
					}
					//这个回退节点字段 暂存新老工作流 状态
					requestInfo.setRejectButtonName("old");
					//暂存接口名称
					requestInfo.setRequestName("approveWeaverAndBPSMobile");
					//暂存 调lsp系统返回时长字段
					requestInfo.setReceiveTime(String.valueOf(resultTime));
					//将前端传来的 工作流审批参数 由json转为实体
//	        		weaver.workflow.webservices.WorkflowRequestInfo requestInfo = JSONObject.parseObject(entity.getWorkflowInfo(), weaver.workflow.webservices.WorkflowRequestInfo.class);
					
					//VP 及 普通用户的 成功/失败信息 都先存到新工作流监控表
					if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
	        			monitordao.insertApprovalNewMonitor(empCode,joblevel,requestInfo,issuccess,data,"0");
	        		}
					if(joblevel != null && joblevel.equals("C") || joblevel != null && joblevel.equals("D") || 
							joblevel != null && joblevel.equals("10") || jobName != null && jobName.contains("总裁") ||
			                    	empCode != null && empCode.equals("107750")){
						//捕获result:false以外的错误信息【Read timed out】
						if(error.contains("result")){
							//VP用户的错误数据  单独存到一张监控表中
							String err = JsonUtil.jsonGetValueBykey(error,"result");
							if(err != null && !err.equals("true")){
								//保存到 VP用户监控表
			        			monitordao.insertLevelMonitor(empCode,joblevel,requestInfo,issuccess);
			        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
			        			String content = "工号："+empCode+",订单编号："+docId+",审批时间："+createDate;
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
						}else{
							if(empCode !=null && joblevel != null && requestInfo != null && issuccess!=null){
			        			//保存到 VP用户监控表
			        			monitordao.insertLevelMonitor(empCode,joblevel,requestInfo,issuccess);
			        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
			        			String content = "工号："+empCode+",订单编号："+docId+",审批时间："+createDate;
			        			jpushParam.setUserIds("275309,491275");
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
					//保存数据监控
//					WFSMonitorUtil.addMonitor(this.empCode, "1", this.flowtype, begindate, this.docId, 
//							issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService,null,json);
				}
			}
        }
	}
	
	/**
	 * 打开附件
	 * @throws Exception 
	 */
	public void openLspAttachmentInfo() throws Exception {
		//解决H5跨域
		solveCrossDomain();
		HttpServletResponse response = ServletActionContext.getResponse();
        //前端点一件附件时 触发 一次请求，如果列表包含很多附件 用户点哪个附件下载哪个附件
		logger.info("download workflow file param is : userId=" + userId + " fileURL=" + filePath + " fileName=" + fileName + " syscode=" + syscode);
        if(StringUtil.isEmpty(filePath) || StringUtil.isEmpty(fileName) || StringUtil.isEmpty(syscode)){
            logger.info("文件路径和文件名称为空,附件下载失败！");
        }else{
            try {
//            	boolean flag = ParamUtils.checkUserId(userId);
            	if(ParamUtils.checkUserId(userId)){
        			// errorMessage
        			logger.info("工号错误，不符合规范");
        		}
            	/**
            	 * lsp生产附件 域名地址 
            	 */
            	String url = "http://lsp.deppon.com/lsp/attachment/";
            	//lsp测试环境 域名地址 
            	String urlTest = "http://192.168.67.41:8180/lsp/attachment/";
            	//true 以url为前缀 后面拼接参数
            	boolean path = filePath.startsWith(url);
            	//true 以urlTest为前缀 后面拼接参数
            	boolean pathTest = filePath.startsWith(urlTest);
            	/**
            	 * nhr生产附件 域名地址 
            	 */
            	/*//http://nhr.deppon.com/nhr/attachment/download.action?resource.attachpath=/attachment/2019/3/30/C4C2C71D4D.jpg
            	String nhrUrl = "http://nhr.deppon.com/nhr/attachment/";
            	//nhr测试环境 域名地址 
            	String nhrUrlTest = "http://10.230.28.200:8080/nhr/attachment/";
            	//true 以nhrUrl为前缀 后面拼接参数
            	boolean pathNHR = filePath.startsWith(nhrUrl);
            	//true 以nhrUrlTest为前缀 后面拼接参数
            	boolean psthNHRTest = filePath.startsWith(nhrUrlTest);
            	*//**
            	 * fssc生产附件 域名地址 
            	 *//*
            	String fsscUrl = "http://nhr.deppon.com/fssc/attachment/";
            	//fssc测试环境 域名地址 http://192.168.20.148:8080/fssc/attachment/download.action?resource.attachpath=/attachment/2019/3/29/4C37734098.xlsx
            	String fsscUrlTest1 = "http://192.168.20.148:8080/fssc/attachment/";
            	String fsscUrlTest2 = "http://192.168.20.45:8080/fssc/attachment/";
            	//true 以fsscUrl为前缀 后面拼接参数
            	boolean pathFSSC = filePath.startsWith(fsscUrl);
            	//true 以fsscUrlTest为前缀 后面拼接参数
            	boolean psthFSSCTest1 = filePath.startsWith(fsscUrlTest1);
            	boolean psthFSSCTest2 = filePath.startsWith(fsscUrlTest2);
            	*/
            	//|| pathNHR == true && filePath.contains(nhrUrl) || psthNHRTest == true && filePath.contains(nhrUrlTest) ||
        		//pathFSSC == true && filePath.contains(fsscUrl) || psthFSSCTest1 == true && filePath.contains(fsscUrlTest1) || psthFSSCTest2 == true && filePath.contains(fsscUrlTest2)
            	if(path == true && filePath.contains(url) || pathTest == true && filePath.contains(urlTest)){
            		
            		dealAttachments(userId, filePath, fileName, syscode, response);
            		
            	}else{
            		logger.info("文件路径未匹配到lsp服务,附件下载失败！"+url+"----下载附件地址filePath:"+filePath);
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	
	/**
	 * 根据url 下载 附件到 指定目录
	 * @param userId
	 * @param fileURL
	 * @param fileName
	 * @param syscode
	 * @param response
	 * @throws Exception 
	 */
	public void dealAttachments(String userId, String filePath, String fileName, String syscode, HttpServletResponse response) throws Exception {
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = 0;    //获取开始时间
		long endTime = 0;
		long resultTime = 0;
		//构造url
        URL url = new URL(filePath);
        try {
        	//要保存的路径  测试环境 及 生产环境 要先在本地建一个workflowFile文件夹，没有权限自动创建
    		String path = "/dpmfile/emailattachment/";
    		//保存文件到本地路径
    		File file = new File(path + fileName);
    		//打开连接
            URLConnection con = url.openConnection();
            //输入流
            InputStream is = con.getInputStream();
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			OutputStream os = new FileOutputStream(file);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
			startTime = System.currentTimeMillis();    //获取开始时间
            //调用解密 方法
            //weaverService.decryptFile(userId, syscode, fileName, file);
            DecryptNewFile.delFile(userId, syscode, fileName, file);
            endTime = System.currentTimeMillis();    //获取结束时间	
            resultTime = endTime - startTime;
    		logger.info("dlsp工作流附件解密（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
    		
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
        	//审批人 等级
        	joblevel = employeeService.getJoblevel(userId);
        	/*nhrEmpcode = nhrWorkInfoAction.getNhrEmpcode();
        	nhrWorkFlowId = nhrWorkInfoAction.getNhrWorkFlowId();
        	nhrWorkflowType = nhrWorkInfoAction.getNhrWorkflowType();
        	
        	fsscWorkflowType = fsscWorkInfoAction.getFsscWorkflowType();
            fsscEmpcode = fsscWorkInfoAction.getFsscEmpcode();
            fsscWorkFlowId = fsscWorkInfoAction.getFsscWorkFlowId();
            fsscWorkitemid = fsscWorkInfoAction.getFsscWorkitemid();
            if(empcode == null || "".equals(empcode)){
        		if((nhrEmpcode == null && fsscEmpcode != null) || ("".equals(nhrEmpcode) && !"".equals(fsscEmpcode))){
        			//fssc附件监控信息
            		if(userId != "" && userId.equals(fsscEmpcode) || fsscEmpcode != "" && fsscEmpcode.equals(userId)){
                    	//封装实体数据
        				WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
        				baseInfo.setWorkflowId(fsscWorkFlowId);
        				baseInfo.setWorkflowName(fsscWorkflowType);
        				baseInfo.setWorkflowTypeName("FSSC-附件");
        	        	WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
        	        	requestInfo.setUserid(userId);
        	        	//只有新工作流附件才存在fileDocId
        	        	requestInfo.setCreatorId("");
        	        	requestInfo.setCurrentNodeName(fileName);
        	        	requestInfo.setLastOperatorName(filePath);
        	        	requestInfo.setNodename(syscode);
        	        	requestInfo.setType(String.valueOf(1));
        	        	requestInfo.setCreateTime(createDate);
        	        	requestInfo.setWorkflowBaseInfo(baseInfo);
        				requestInfo.setRequestId(fsscWorkitemid);
        				requestInfo.setRemark("");
        				requestInfo.setSubmitButtonName("");
        				requestInfo.setMessageType("");
        				//这个回退节点字段 暂存新老工作流 状态
        				requestInfo.setRejectButtonName("old");
        				//暂存附件的docId
        				requestInfo.setCurrentNodeId("");
        				//暂存接口名称
        				requestInfo.setRequestName("fssc--dealAttachments");
        				//暂存 调lsp系统返回时长字段
        				requestInfo.setReceiveTime(String.valueOf(resultTime));
        	        	monitordao.insertApprovalNewMonitor(userId,joblevel,requestInfo,"success","","1");
                    }
        		}else{
        			//nhr附件监控信息
            		if(userId != "" && userId.equals(nhrEmpcode) || nhrEmpcode != "" && nhrEmpcode.equals(userId)){
                    	//封装实体数据
        				WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
        				baseInfo.setWorkflowId(nhrWorkFlowId);
        				baseInfo.setWorkflowName(nhrWorkflowType);
        				baseInfo.setWorkflowTypeName("NHR-附件");
        	        	WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
        	        	requestInfo.setUserid(userId);
        	        	//只有新工作流附件才存在fileDocId
        	        	requestInfo.setCreatorId("");
        	        	requestInfo.setCurrentNodeName(fileName);
        	        	requestInfo.setLastOperatorName(filePath);
        	        	requestInfo.setNodename(syscode);
        	        	requestInfo.setType(String.valueOf(1));
        	        	requestInfo.setCreateTime(createDate);
        	        	requestInfo.setWorkflowBaseInfo(baseInfo);
        				requestInfo.setRequestId("");
        				requestInfo.setRemark("");
        				requestInfo.setSubmitButtonName("");
        				requestInfo.setMessageType("");
        				//这个回退节点字段 暂存新老工作流 状态
        				requestInfo.setRejectButtonName("old");
        				//暂存附件的docId
        				requestInfo.setCurrentNodeId("");
        				//暂存接口名称
        				requestInfo.setRequestName("nhr--dealAttachments");
        				//暂存 调lsp系统返回时长字段
        				requestInfo.setReceiveTime(String.valueOf(resultTime));
        	        	monitordao.insertApprovalNewMonitor(userId,joblevel,requestInfo,"success","","1");
                    }
        		}
        	}else{*/
        		//lsp附件监控信息
        		if(empcode != "" && empcode.equals(userId) || userId != "" && userId.equals(empcode)){
            		//封装实体数据
    				WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
    				baseInfo.setWorkflowId(workFlowId);
    				baseInfo.setWorkflowName("");
    				baseInfo.setWorkflowTypeName("DLSP-附件");
    	        	WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
    	        	requestInfo.setUserid(userId);
    	        	//只有新工作流附件才存在fileDocId
    	        	requestInfo.setCreatorId("");
    	        	requestInfo.setCurrentNodeName(fileName);
    	        	requestInfo.setLastOperatorName(filePath);
    	        	requestInfo.setNodename(syscode);
    	        	requestInfo.setType(String.valueOf(1));
    	        	requestInfo.setCreateTime(createDate);
    	        	requestInfo.setWorkflowBaseInfo(baseInfo);
    				requestInfo.setRequestId("");
    				requestInfo.setRemark("");
    				requestInfo.setSubmitButtonName("");
    				requestInfo.setMessageType("");
    				//这个回退节点字段 暂存新老工作流 状态
    				requestInfo.setRejectButtonName("old");
    				//暂存附件的docId
    				requestInfo.setCurrentNodeId("");
    				//暂存接口名称
    				requestInfo.setRequestName("lsp--dealAttachments");
    				//暂存 调lsp系统返回时长字段
    				requestInfo.setReceiveTime(String.valueOf(resultTime));
    	        	monitordao.insertApprovalNewMonitor(userId,joblevel,requestInfo,"success","","1");
                }
        	}
//        }
    }
	
	public void decryptFile(File file) {
		ServletOutputStream out = null;
		InputStream in = null;
		
		logger.info("附件解密开始>>>>");
		try {
			// 获取response的输出流
			out = ServletActionContext.getResponse().getOutputStream();
			
			byte[] buff = new byte[MagicNumber.NUM1024];
			int len = 0;			
				    // 获取响应数据
					in = new FileInputStream(file);
					// 将解密后的文件数据写出
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
			
		} catch (Exception e) {
			logger.error("附件解密失败>>>>", e);
			try {
				if(null != out){
					// 异常返回
					out.write("40007".getBytes());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 释放资源
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 释放资源
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

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
	 * @param weaverAndBPSMobileWorkflowService the weaverAndBPSMobileWorkflowService to set
	 */
	public void setWeaverAndBPSMobileWorkflowService(
			IWeaverAndBPSMobileWorkflowService weaverAndBPSMobileWorkflowService) {
		this.weaverAndBPSMobileWorkflowService = weaverAndBPSMobileWorkflowService;
	}
	public IWeaverAndBPSMobileWorkflowService getWeaverAndBPSMobileWorkflowService() {
		return weaverAndBPSMobileWorkflowService;
	}

	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	public String getDocId() {
		return docId;
	}

	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}
	
	public String getFlowtype() {
		return flowtype;
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

	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}

	public IMonitorService getMonitorService() {
		return monitorService;
	}

	public IWeaverWfsService getWeaverService() {
		return weaverService;
	}

	public void setWeaverService(IWeaverWfsService weaverService) {
		this.weaverService = weaverService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
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

	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	/*public NHrWorkInfoAction getNhrWorkInfoAction() {
		return nhrWorkInfoAction;
	}

	public void setNhrWorkInfoAction(NHrWorkInfoAction nhrWorkInfoAction) {
		this.nhrWorkInfoAction = nhrWorkInfoAction;
	}*/
	
	
}