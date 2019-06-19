package com.deppon.dpm.module.wfs.server.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import weaver.workflow.webservices.WorkflowBaseInfo;
import weaver.workflow.webservices.WorkflowRequestInfo;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.boas.bean.workflow.entity.ApprovalRecordEntity;
import com.deppon.boas.bean.workflow.entity.regionalResolutionNew.RegionalResolutionDetailDo;
import com.deppon.boas.plugin.workflow.service.regionalResolutionNew.IRegionalResolutionNewBIService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.DecryptNewFile;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.IQueryEmployeeInfoService;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowNewMonitorEntity;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;

/**
 * dwfs 新工作流
 * 区域ST/AT决议上报工作流
 * @version
 */
public class RegionResolutionAction extends BaseAction {

	private static final long serialVersionUID = 1397420409043898745L;
	private static Logger logger  = LoggerFactory.getLogger(RegionResolutionAction.class);

	//service
	private IMonitorService monitorService;
	// service层
	private IWeaverWfsService weaverService;
	//区域ST/AT决议上报  接口
	@Autowired
	public IRegionalResolutionNewBIService regionalResolutionNewBIService;
	//工号等级
  	private String joblevel;
  	//员工所在岗位
  	private String jobName;
	//操作人工号
  	private String empCode;
  	// 工作流类型
  	private String flowtype;
    //工作流编号  必填
  	private String requestId;
  	private static String requestid;
  	//审批人工号 必填
  	private String workCode;
  	//审批意见
  	private String remark;
  	//需审批人Id  【战略绩效部, 干部政策管理部节点需要选择副总审批(必填), 多个以','分割】
  	private String approver;
  	//是否决操作  【通过传false, 否决传true】
  	//如果是需审批人和AT 主任节点且点击的是否决就传true, 其他的审批时传false
  	private boolean isDisAgree;
  	// 错误信息 用于错误预警
    private String errorInfo;
    //版本号
    private String version;
    	
  	/**
  	 * 附件信息
  	 */
    //工号
   	private String userId;
   	//区域决议 打开附件http://boas.deppon.com:8080/workflow/fileUpload/getOldFile?
	private String openAttachments;
	//设备类型
	private String deviceType;
	//获取服务器地址
	private String serverHostPort;
	
 	/**
	 * 推送信息实体类
	 */
    private JPushParam jpushParam = new JPushParam();
    private IJPushNewService jPushNewService;
    //监控日志
  	private IMonitorDao monitordao;
  	//根据工号查员工信息
  	private IQueryEmployeeInfoService employeeService;
 	/**
 	 * 区域ST/AT决议上报工作流详情
 	 */
	public void getRegionalResolutionDetail() {
		Date begindate = new Date();
        String issuccess = "0";
        com.deppon.boas.bean.workflow.entity.Result<RegionalResolutionDetailDo> js = null;
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
        Result<String> result = new Result<String>();
        try {
        	HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			//打印出参数
            logger.info("工号：" + this.userId + "----dwfs query action param:" + this.requestId);
            //打印出参数
			startTime1 = System.currentTimeMillis();    //获取开始时间
            if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(requestId)) {
            	requestid = requestId;
            	// 调用service
                js = regionalResolutionNewBIService.getRegionalResolutionDetail(Integer.parseInt(requestId));
                String json = JSON.toJSONString(js);
                //打印出返回的json
                logger.info("查询工号：" + this.userId + "----dwfs query action return:" + json);
                String data = JSON.toJSONString(js.getData());
                endTime1 = System.currentTimeMillis();    //获取结束时间
    			logger.info("dwfs new 工作流详情（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
                if (com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(json) || json==null) {
                	//情况1：从oa获取返回json为空
                    this.errorInfo ="工号：" + this.userId + "----dwfs查询返回json为空" + json;
                    result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
                    //如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
                    data = "";
                } else if(js.getErrorCode() == 10002){
                	//情况2：从oa获取返回json有异常
                	this.errorInfo = "dwfs查询请求参数校验json异常：" + js.getErrorName() + js.getErrorMessage();
                	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
                	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
                    data = "";
                } else if(js.getErrorCode() == 10001){
                	//情况3：从oa获取返回json有异常
                	this.errorInfo = "dwfs查询服务异常json异常：" + js.getErrorName() + js.getErrorMessage();
                	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
                	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
                    data = "";
                } else if(js.getErrorCode() == 10003){
                	//情况4：从oa获取返回json有异常
                	this.errorInfo = "dwfs查询失败json异常：" + js.getErrorName() + js.getErrorMessage();
                	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
                	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
                    data = "";
                } else if(js.getErrorName() != null || js.getErrorMessage() != null){
	            	//情况5：从oa获取返回json有异常
	            	this.errorInfo = "dwfs查询失败json异常：" + js.getErrorName() + js.getErrorMessage();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                json = "";
	            }else{
                	//情况6：查询成功
                	String success = JsonUtil.jsonGetValueBykey(json, "success");
                	if( success != null && success.equals("true")){
                		issuccess = "1";
                        this.errorInfo = "dwfs查询返回json：" + json;
                        //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                        result.setCount(1);
                        // errorCode  处理成功传给前端值：0
            			result.setErrorCode(Constants.ACTION_RESULT_SUC);
            			// errorMessage 成功信息传给前端：Y
            			result.setErrorMessage(Constants.ACTIVE_YES);
                	}else{
                		//情况7：查询失败
                		this.errorInfo = js.getErrorName()+ "dwfs查询json异常：" + js.getErrorMessage()+"---错误码："+js.getErrorCode();
                		result.setErrorCode(Constants.ACTION_RESULT_ERROR);
            			// errorMessage  失败信息传给前端：N
            			result.setErrorMessage(Constants.ACTIVE_NO);
                    	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                        result.setCount(0);
                        data = "";
                	}
                }
        		//传给前端data：pc端返回的json字符串
        		result.setData(data);
        		//返回给页面
        		writeToPage(response, result);
            }
			
        } catch (Exception e) {
            this.errorInfo = "dwfs查询接口抛异常：" + e.getMessage();
            e.printStackTrace();
            // errorCode  处理失败传给前端值：1
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage  失败信息传给前端：N
			result.setErrorMessage(Constants.ACTIVE_NO);
        } finally {
            // 保存数据监控
            WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype,
                    begindate, this.requestId, issuccess, this.errorInfo,
                    ServletActionContext.getRequest().getSession(),
                    this.monitorService, null, requestId);
        }
	}
	
	/**
	 * dwfs 区域ST/AT决议上报工作流  审批记录接口
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 */
	public void getRegionalResolutionApprovalLog() {
		this.solveCrossDomain();
		//我要获取当前的日期
		Date begindate = new Date();
        long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
		String issuccess = "0";
		com.deppon.boas.bean.workflow.entity.Result<List<ApprovalRecordEntity>> js = null;
		Result<String> result = new Result<String>();
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			
			//打印出参数
	        logger.info("----dwfs approve query action param:" + this.requestId + "工号：" + this.userId);
	        if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(requestId)) {
	        	//获取开始时间
				startTime1 = System.currentTimeMillis(); 
	        	// 调用service
	            js = regionalResolutionNewBIService.getRegionalResolutionApprovalLog(Integer.parseInt(requestId));
	            String json = JSON.toJSONString(js);
                //打印出返回的json
                logger.info("审批工号：" + this.userId + "----dwfs approve query action return:" + json);
                String data = JSON.toJSONString(js.getData());
	            //获取结束时间
	            endTime1 = System.currentTimeMillis();    
				logger.info("dwfs approval query 工作流审批记录查询（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
				if (com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(json) || json == null) {
	            	//情况1：从oa获取返回json为空
	                this.errorInfo = "dwfs审批记录查询json为空" + js.getErrorName() + js.getErrorMessage();
	                result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	                //如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                data = "";
	            } else if(js.getErrorCode() == 10001){
	            	//情况2：从oa获取返回json有异常
	            	this.errorInfo = "dwfs审批记录查询服务json异常：" + js.getErrorName() + js.getErrorMessage();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                data = "";
	            } else if(js.getErrorCode() == 10002){
	            	//情况3：从oa获取返回json有异常
	            	this.errorInfo = "dwfs审批记录查询参数校验，返回json有异常：" + js.getErrorName() + js.getErrorMessage();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                data = "";
	            } else if(js.getErrorCode() == 10003){
	            	//情况4：从oa获取返回json有异常
	            	this.errorInfo = "dwfs审批记录查询失败json异常：" + js.getErrorName() + js.getErrorMessage();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                data = "";
	            } else if(js.getErrorName() != null || js.getErrorMessage() != null){
	            	//情况5：从oa获取返回json有异常
	            	this.errorInfo = "dwfs审批记录失败json异常：" + js.getErrorName() + js.getErrorMessage();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                json = "";
	            }else{
	            	//情况6：查询成功
	            	String success = JsonUtil.jsonGetValueBykey(json, "success");
	            	if( success != null && success.equals("true")){
	            		issuccess = "1";
	                    this.errorInfo = "dwfs审批记录查询返回json：" + json;
	                    //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
	                    result.setCount(1);
	                    // errorCode  处理成功传给前端值：0
	        			result.setErrorCode(Constants.ACTION_RESULT_SUC);
	        			// errorMessage 成功信息传给前端：Y
	        			result.setErrorMessage(Constants.ACTIVE_YES);
	            	}else{
	            		//情况7：查询失败
	            		this.errorInfo = js.getErrorName()+ "--dwfs审批记录查询json异常：" + js.getErrorMessage();
	            		result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	        			// errorMessage  失败信息传给前端：N
	        			result.setErrorMessage(Constants.ACTIVE_NO);
	                	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                    result.setCount(0);
	                    data = "";
	            	}
	            }
	    		//传给前端data：pc端返回的json字符串
	    		result.setData(data);
	    		//返回给页面
	    		writeToPage(response, result);
	        }
		} catch (Exception e) {
            this.errorInfo = "dwfs审批记录查询接口抛异常：" + e.getMessage();
            e.printStackTrace();
            // errorCode  处理失败传给前端值：1
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage  失败信息传给前端：N
			result.setErrorMessage(Constants.ACTIVE_NO);
        } finally {
            // 保存数据监控
            WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype,
                    begindate, this.requestId, issuccess, this.errorInfo,
                    ServletActionContext.getRequest().getSession(),
                    this.monitorService, null, requestId);
        }
	}
	
	
	/**
	 * 审批同意接口
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 * @throws Exception 
	 */
	public void submitApprovalAgree() throws APIConnectionException, APIRequestException, Exception {
		//解决H5跨域
		solveCrossDomain();
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
		String json = "";
		String data = "";
		//接收前端参数的实体类
//		RegionResolutionInfo entity = new RegionResolutionInfo();
		//结果集
		Result<String> result = new Result<String>();
		com.deppon.boas.bean.workflow.entity.Result<List<Map<String, Object>>> resultStirng = null;
		try {
			//获取DPM开始时间
			startTime = System.currentTimeMillis();
			//打印出参数
            logger.info("----dwfs approval agree param:" + this.requestId + "------" + this.workCode
                    + "------" + this.remark + "------" + this.approver + "------" + this.isDisAgree  
                    + "------" + this.userId + "------" + this.version);
            if(StringUtil.isEmpty(requestId) || StringUtil.isEmpty(workCode)){
            	logger.info("------前端提交审批同意参数为空-----");
            }else{
            	//获取开始时间
				startTime1 = System.currentTimeMillis();
				//提交结果 
				resultStirng = regionalResolutionNewBIService.approval(Integer.parseInt(requestId), workCode, approver, isDisAgree, remark);
				//获取结束时间
	            endTime1 = System.currentTimeMillis();    
				logger.info("dwfs工作流审批同意（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
				json = JSON.toJSONString(resultStirng);
				//打印出返回的json
                logger.info( "审批同意工号：" + this.userId + "----dwfs approve agree return:" + json);
                //审批人 等级
            	joblevel = employeeService.getJoblevel(userId);
                if (com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(json) || json == null) {
	            	//情况1：从oa获取返回json为空
	                this.errorInfo = "dwfs审批同意json为空" + resultStirng.getErrorName();
	                //如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
	                // errorCode  处理失败传给前端值：1
	    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	    			// errorMessage  失败信息传给前端：N
	    			result.setErrorMessage(Constants.ACTIVE_NO);
	                issuccess = "error";
//	                json = "";
	            } else if(resultStirng.getErrorCode() == 10001 ){
	            	//情况2：从oa获取返回json有异常
	            	this.errorInfo = "dwfs同意服务异常json异常：" + resultStirng.getErrorMessage();
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
	                // errorCode  处理失败传给前端值：1
	    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	    			// errorMessage  失败信息传给前端：N
	    			result.setErrorMessage(Constants.ACTIVE_NO);
	            	issuccess = "error";
//	            	json = "";
	            } else if(resultStirng.getErrorCode() == 10002){
	            	//情况3：从oa获取返回json有异常
	            	this.errorInfo = "dwfs同意参数校验json异常：" + resultStirng.getErrorMessage();
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
	                // errorCode  处理失败传给前端值：1
	    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	    			// errorMessage  失败信息传给前端：N
	    			result.setErrorMessage(Constants.ACTIVE_NO);
	            	issuccess = "error";
//	            	json = "";
	            } else if(resultStirng.getErrorCode() == 10003){
	            	//情况4：从oa获取返回json有异常
	            	this.errorInfo = "dwfs同意失败json异常：" + resultStirng.getErrorMessage();
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
	                // errorCode  处理失败传给前端值：1
	    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	    			// errorMessage  失败信息传给前端：N
	    			result.setErrorMessage(Constants.ACTIVE_NO);
	            	issuccess = "error";
//	                json = "";
	            } else if(resultStirng.getErrorName() != null || resultStirng.getErrorMessage() != null){
	            	//情况5：从oa获取返回json有异常
	            	this.errorInfo = "dwfs同意失败json异常：" + resultStirng.getErrorMessage();
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
                    result.setCount(0);
	                // errorCode  处理失败传给前端值：1
	    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	    			// errorMessage  失败信息传给前端：N
	    			result.setErrorMessage(Constants.ACTIVE_NO);
	            	issuccess = "error";
//	            	json = "";
	            }else{
	            	//情况6：审批同意成功
	            	String success = JsonUtil.jsonGetValueBykey(json, "success");
	            	if( success != null && success.equals("true")){
	            		//返回数据太长  保存数据库记录
	            		data = "\"errorCode\":0,\"success\":true";
	            		issuccess = "success";
	                    this.errorInfo = "dwfs同意返回json：" + json;
	                    //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
	                    result.setCount(1);
	                    // errorCode  处理成功传给前端值：0
	        			result.setErrorCode(Constants.ACTION_RESULT_SUC);
	        			// errorMessage 成功信息传给前端：Y
	        			result.setErrorMessage(Constants.ACTIVE_YES);
	            	}else{
	            		//情况7：审批同意失败
	            		this.errorInfo = "dwfs同意json异常：" + resultStirng.getErrorMessage();
	            		//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                    result.setCount(0);
		                // errorCode  处理失败传给前端值：1
		    			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
		    			// errorMessage  失败信息传给前端：N
		    			result.setErrorMessage(Constants.ACTIVE_NO);
		    			issuccess = "error";
//		    			json = "";
	            	}
	            }
	    		//传给前端data：pc端返回的json字符串
	    		result.setData(json);
	    		//返回给页面
	    		writeToPage(result);
            }
            //获取DPM结束时间
            endTime = System.currentTimeMillis();
            resultTime = endTime - startTime;
    		logger.info("区域决议审批同意（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
			
		} catch (Exception e) {
			this.errorInfo = "dwfs审批同意抛异常：" + e.getMessage();
            e.printStackTrace();
            // errorCode  处理失败传给前端值：1
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage  失败信息传给前端：N
			result.setErrorMessage(Constants.ACTIVE_NO);
		}finally {
			/**
			 * 封装监控实体数据
			 */
			WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
			wmEntity.setUserId(userId);
			wmEntity.setJobLevel(joblevel);
			wmEntity.setWorkflowId("");
			wmEntity.setRequestId(requestId);
			wmEntity.setWorkflowName("区域ST/AT决议上报工作流");
			wmEntity.setSysCode("WFS-财务类");
			wmEntity.setStatus("new");
			wmEntity.setApprovalOption("同意");
			wmEntity.setRemark(remark);
			wmEntity.setResult(issuccess);
			if(issuccess.equals("success")){
				wmEntity.setIsSuccess(1);
			}
			wmEntity.setData(json);
//			String errInfo = errorInfo.substring(errorInfo.length()-500,errorInfo.length());
			wmEntity.setErrorInfo(errorInfo);
			wmEntity.setInterfaceName("submitApprovalAgree");
			wmEntity.setRejectNode("");
			Date createTime = sdf.parse(createDate);
			wmEntity.setCreateTime(createTime);
			wmEntity.setMethodTime(String.valueOf(resultTime));
			wmEntity.setFileDocId("");
			wmEntity.setFileName("");
			wmEntity.setFilePath("");
			wmEntity.setFileOpenCount(0);
			wmEntity.setUi_type("");
			if(!"".equals(version) && version != null){
				//暂存版本号
				wmEntity.setRemark1(version);
			}else{
				wmEntity.setRemark1("");
			}
			wmEntity.setRemark2("");
			wmEntity.setRemark3("");
			
			/**
			 * 封装OA实体数据
			 */
			WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
			baseInfo.setWorkflowId(requestId);
			baseInfo.setWorkflowName("区域ST/AT决议上报工作流");
			baseInfo.setWorkflowTypeId("");
			baseInfo.setWorkflowTypeName("WFS-财务类");
			//封装实体数据
			WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
			requestInfo.setCreateTime(createDate);
			requestInfo.setRemark(remark);
			requestInfo.setSubmitButtonName("同意");
			requestInfo.setUserid(userId);
			requestInfo.setWorkflowBaseInfo(baseInfo);
			if(errorInfo.length() >= 30){
				requestInfo.setMessageType(errorInfo.substring(0, 30));
			}else{
				requestInfo.setMessageType(errorInfo);
			}
			//这个回退节点字段 暂存 返回给前端的结果数据 有长度限制
			requestInfo.setRejectButtonName(data);
			requestInfo.setForwardButtonName(version);
			
			//VP 及 普通用户的 成功/失败信息 都先存到新工作流监控表
			/*if(userId !=null && joblevel != null && requestInfo != null && issuccess!=null){
    			monitordao.insertApprovalMonitorOld(userId,joblevel,requestInfo,issuccess);
    		}*/
			//捕获result:false以外的错误信息【Read timed out】
//			if(json.contains("false")){
				//VP用户的错误数据  单独存到一张监控表中
				String err = JsonUtil.jsonGetValueBykey(json, "success");
				if(err != null && !err.equals("true")){
					//保存到 VP用户监控表
        			monitordao.insertLevelMonitor(userId,joblevel,requestInfo,issuccess);
        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
        			String content = "工号："+userId+",工作流号："+requestId+",审批时间："+createDate;
        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
        			jpushParam.setAlert(content);
        			jpushParam.setLinktype(0);
    				// 保存推送记录到消息中心
    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
    				jPushNewService.saveToMsgCentre(jpushParam, 0);
    				// 推送
    				jPushNewService.pushByUserIds(jpushParam);
				}else if(err != null && err.equals("true")){
					if(userId !=null && joblevel != null && wmEntity != null && issuccess!=null){
		    			monitordao.insertApprovalEntityNewMonitor(wmEntity);
		    		}
				}else{
					//保存到 VP用户监控表
        			monitordao.insertLevelMonitor(userId,joblevel,requestInfo,issuccess);
        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
        			String content = "工号："+userId+",工作流号："+requestId+",审批时间："+createDate;
        			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
        			jpushParam.setAlert(content);
        			jpushParam.setLinktype(0);
    				// 保存推送记录到消息中心
    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
    				jPushNewService.saveToMsgCentre(jpushParam, 0);
    				// 推送
    				jPushNewService.pushByUserIds(jpushParam);
				}
			/*}else{
				if(userId !=null && joblevel != null && requestInfo != null && issuccess!=null){
        			//保存到 VP用户监控表
        			monitordao.insertLevelMonitor(userId,joblevel,requestInfo,issuccess);
        			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
        			String content = "工号："+userId+",工作流号："+requestId+",审批时间："+createDate;
        			jpushParam.setUserIds("275309,491275");
        			jpushParam.setAlert(content);
        			jpushParam.setLinktype(0);
//    				jpushParam.setContent(content);
    				// 保存推送记录到消息中心
    				jpushParam.setPushConditionValue(jpushParam.getUserIds());
    				jPushNewService.saveToMsgCentre(jpushParam, 0);
    				// 推送
    				jPushNewService.pushByUserIds(jpushParam);
        		}
			}*/
        }
	}
		
	/**
	 * 所有节点默认 回退到 起草人
	 * @param requestId 工作流号
	 * @param workCode 审批人工号
	 * @param  remark 审批意见
	 * @return String 提交结果
	 * @throws APIRequestException 
	 * @throws APIConnectionException 
	 * @throws Exception 
	 */
	public void getRejectNode() throws APIConnectionException, APIRequestException, Exception{
		//解决H5跨域
		solveCrossDomain();
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = 0;    //获取DPM开始时间
		long endTime = 0;    //获取DPM结束时间
		long resultTime = 0;    //获取总时长
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
		String issuccess = "0";
		String json = "";
		String data = "";
		Result<String> result = new Result<String>();
		com.deppon.boas.bean.workflow.entity.Result<String> str = null;
		try {
			//获取DPM开始时间
			startTime = System.currentTimeMillis();
			//打印出参数
            logger.info("----dwfs approval reject param:" + this.requestId + "------" + this.workCode
                    + "------" + this.remark + "------" + this.userId + "------" + this.version);
            if(StringUtil.isEmpty(requestId) || StringUtil.isEmpty(workCode) || StringUtil.isEmpty(remark)){
            	logger.info("------前端提交审批退回参数为空-----");
            }else{
            	startTime1 = System.currentTimeMillis();
				//提交结果 
            	str = regionalResolutionNewBIService.reject(Integer.parseInt(requestId), workCode, remark);
				//获取结束时间
	            endTime1 = System.currentTimeMillis();    
				logger.info("dwfs approval reject 工作流审批退回（方法） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
				json = JSON.toJSONString(str);
				//打印出返回的json
                logger.info("审批退回工号：" + this.userId + "----dwfs approve agree return:" + json);
                //审批人 等级
            	joblevel = employeeService.getJoblevel(userId);
                if (com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(json) || json == null) {
	            	//情况1：从oa获取返回json为空
	                this.errorInfo = "dwfs审批退回json为空" + str.getErrorName();
	                result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	                //如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                issuccess = "error";
//	                json = "";
	            } else if(str.getErrorCode() == 10001){
	            	//情况2：从oa获取返回json有异常
	            	this.errorInfo = "dwfs审批退回json异常：" + str.getErrorName();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                issuccess = "error";
//	                json = "";
	            } else if(str.getErrorCode() == 10002){
	            	//情况3：从oa获取返回json有异常
	            	this.errorInfo = "dwfs审批退回参数校验json异常：" + str.getErrorName();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                issuccess = "error";
//	                json = "";
	            } else if(str.getErrorCode() == 10003){
	            	//情况4：从oa获取返回json有异常
	            	this.errorInfo = "dwfs审批流程退回失败json异常：" + str.getErrorName();
	            	result.setErrorCode(Constants.ACTION_RESULT_ERROR);
        			// errorMessage  失败信息传给前端：N
        			result.setErrorMessage(Constants.ACTIVE_NO);
	            	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                result.setCount(0);
	                issuccess = "error";
//	                json = "";
	            } else{
	            	//情况5：退回成功
	            	String success = JsonUtil.jsonGetValueBykey(json, "success");
	            	if( success != null && success.equals("true")){
	            		issuccess = "success";
	            		//返回数据太长  保存数据库记录
	            		data = "{\"data\":\"流程退回成功\",\"success\":true}";
	            		this.errorInfo = "dwfs退回返回json：" + json;
	                    //如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
	                    result.setCount(1);
	                    // errorCode  处理成功传给前端值：0
	        			result.setErrorCode(Constants.ACTION_RESULT_SUC);
	        			// errorMessage 成功信息传给前端：Y
	        			result.setErrorMessage(Constants.ACTIVE_YES);
	            	}else{
	            		//情况5：退回失败
	            		this.errorInfo = str.getErrorName()+ "dwfs审批退回json异常：" + str.getErrorMessage();
	            		result.setErrorCode(Constants.ACTION_RESULT_ERROR);
	        			// errorMessage  失败信息传给前端：N
	        			result.setErrorMessage(Constants.ACTIVE_NO);
	                	//如果pc端返回的json数据为空 count返回前端赋值：0，没有数据
	                    result.setCount(0);
	                    issuccess = "error";
//	                    json = "";
	            	}
	            }
	    		//传给前端data：pc端返回的json字符串
	    		result.setData(json);
	    		//返回给页面
	    		writeToPage(result);
            }
            //获取DPM结束时间
            endTime = System.currentTimeMillis();
            resultTime = endTime - startTime;
    		logger.info("区域决议审批退回（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
			
		} catch (Exception e) {
			this.errorInfo = "dwfs审批退回接口抛异常：" + e.getMessage();
            e.printStackTrace();
            // errorCode  处理失败传给前端值：1
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage  失败信息传给前端：N
			result.setErrorMessage(Constants.ACTIVE_NO);
			logger.error("审批退回工号：" + this.userId + "---工作流获取回退节点号异常："+e);
		}finally {
			/**
			 * 封装监控实体数据
			 */
			WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
			wmEntity.setUserId(userId);
			wmEntity.setJobLevel(joblevel);
			wmEntity.setWorkflowId("");
			wmEntity.setRequestId(requestId);
			wmEntity.setWorkflowName("区域ST/AT决议上报工作流");
			wmEntity.setSysCode("WFS-财务类");
			wmEntity.setStatus("new");
			wmEntity.setApprovalOption("退回");
			wmEntity.setRemark(remark);
			wmEntity.setResult(issuccess);
			if(issuccess.equals("success")){
				wmEntity.setIsSuccess(1);
			}
			wmEntity.setData(data);
//			String errInfo = errorInfo.substring(errorInfo.length()-500,errorInfo.length());
			wmEntity.setErrorInfo(errorInfo);
			wmEntity.setInterfaceName("getRejectNode");
			wmEntity.setRejectNode("");
			Date createTime = sdf.parse(createDate);
			wmEntity.setCreateTime(createTime);
			wmEntity.setMethodTime(String.valueOf(resultTime));
			wmEntity.setFileDocId("");
			wmEntity.setFileName("");
			wmEntity.setFilePath("");
			wmEntity.setFileOpenCount(0);
			wmEntity.setUi_type("");
			if(!"".equals(version) && version != null){
				//暂存版本号
				wmEntity.setRemark1(version);
			}else{
				wmEntity.setRemark1("");
			}
			
			wmEntity.setRemark2("");
			wmEntity.setRemark3("");
			
			/**
			 * 封装实体数据
			 */
			WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
			baseInfo.setWorkflowId(requestId);
			baseInfo.setWorkflowName("区域ST/AT决议上报工作流");
			baseInfo.setWorkflowTypeId("");
			baseInfo.setWorkflowTypeName("WFS-财务类");
			//封装实体数据
			WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
			requestInfo.setCreateTime(createDate);
			requestInfo.setRemark(remark);
			requestInfo.setSubmitButtonName("退回");
			requestInfo.setUserid(userId);
			requestInfo.setWorkflowBaseInfo(baseInfo);
			if(errorInfo.length() >= 30){
				requestInfo.setMessageType(errorInfo.substring(0, 30));
			}else{
				requestInfo.setMessageType(errorInfo);
			}
			//这个回退节点字段 暂存 返回给前端的结果数据
			requestInfo.setRejectButtonName(data);
			requestInfo.setForwardButtonName(version);
			//VP用户的错误数据  单独存到一张监控表中
			String err = JsonUtil.jsonGetValueBykey(json, "success");
			if(err != null && !err.equals("true")){
				//保存到 VP用户监控表
    			monitordao.insertLevelMonitor(userId,joblevel,requestInfo,issuccess);
    			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
    			String content = "工号："+userId+",工作流号："+requestId+",审批时间："+createDate;
    			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
    			jpushParam.setAlert(content);
    			jpushParam.setLinktype(0);
//    				jpushParam.setContent(content);
				// 保存推送记录到消息中心
				jpushParam.setPushConditionValue(jpushParam.getUserIds());
				jPushNewService.saveToMsgCentre(jpushParam, 0);
				// 推送
				jPushNewService.pushByUserIds(jpushParam);
			}else if(err != null && err.equals("true")){
				if(userId !=null && joblevel != null && wmEntity != null && issuccess!=null){
	    			monitordao.insertApprovalEntityNewMonitor(wmEntity);
	    		}
			}else{
				//保存到 VP用户监控表
    			monitordao.insertLevelMonitor(userId,joblevel,requestInfo,issuccess);
    			//极光推送消息给项目组相关人员245102,265564,275309,357095,491275,496837,500612,605923,633728
    			String content = "工号："+userId+",工作流号："+requestId+",审批时间："+createDate;
    			jpushParam.setUserIds("245102,265564,275309,357095,491275,496837,500612,605923,633728");
    			jpushParam.setAlert(content);
    			jpushParam.setLinktype(0);
//    				jpushParam.setContent(content);
				// 保存推送记录到消息中心
				jpushParam.setPushConditionValue(jpushParam.getUserIds());
				jPushNewService.saveToMsgCentre(jpushParam, 0);
				// 推送
				jPushNewService.pushByUserIds(jpushParam);
			}
        }
	}
	
	/**
	 * 前端获取附件下载地址
	 * @throws Exception 
	 */
	public void attachmentInfos() throws Exception {
		//解决H5跨域
		solveCrossDomain();
		//我要获取当前的日期
		Date begindate = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createDate = sdf.format(begindate);
        long startTime = 0;    //获取DPM开始时间
		long endTime = 0;    //获取DPM结束时间
		long resultTime = 0;    //获取总时长
		long startTime1 = 0;    //获取开始时间
		long endTime1 = 0;    //获取结束时间
        //获取String类型的时间
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		net.sf.json.JSONObject json = null;
		Result<String> result = new Result<String>();
		JSONArray myJsonArray = new JSONArray();
		String attachments = "";
		String url = null;
		JSONObject jsonOb = new JSONObject();
		int docId = 0;
		String issuccess = "";
		String fileName = "";
		String isAudio = "";
		if ("POST".equals(request.getMethod())) {
			try {
				//获取DPM开始时间
				startTime = System.currentTimeMillis();    
				//取json字符串
				json = net.sf.json.JSONObject.fromObject(request.getParameter("attachments"));
				logger.info("前端参数 attachmentJson----"+json.toString());
				//转成String参数
				attachments = json.getString("attachments");
				if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(attachments) || attachments==null) {
					JSONArray attJson = JSONArray.parseArray(attachments);
					//循环附件列表 判断是不是音频
					for(int i=0;i<attJson.size();i++){
						docId = Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(attJson.get(i))).getString("attachmentFileDocId"));
						fileName = JSONObject.parseObject(JSONObject.toJSONString(attJson.get(i))).getString("attachmentName");
						if(fileName.contains(".MP3") || fileName.contains(".MP4") || fileName.contains(".MVA") || 
								fileName.contains(".mp3") || fileName.contains(".mp4") || fileName.contains(".mva")){
							isAudio = "Y";
							String openAttachment = openAttachments+"fileDocId="+docId;
							logger.info("oa download attachment http："+openAttachment);
							startTime1 = System.currentTimeMillis(); //获取开始时间	
							//下载音频
							dealAttachments(userId,openAttachment,fileName,response);
							endTime1 = System.currentTimeMillis();    //获取结束时间	
							logger.info("区域决议工作流附件解密（总时间） - 程序运行时间  - 后台：" + (endTime1 - startTime1) + "ms");
							//获取服务器地址【生产域名获取不到】
//							String hostAddress = this.getHostIp();
							//生产地址  "http://dpm.deppon.com:8881/dpm/emailattachment/"+fileName
							url = serverHostPort+"emailattachment/"+fileName;
							jsonOb = attJson.getJSONObject(i);
							jsonOb.put("url", url);
//							jsonO.put("docId", docId);
							jsonOb.put("attachmentName", fileName);
							myJsonArray.add(jsonOb);
							this.errorInfo = "音频附件详情接口，docId："+docId+"--fileName："+fileName;
						}else{
							isAudio = "N";
							this.errorInfo = "不是音频附件详情接口，docId："+docId+"--fileName："+fileName;
							logger.info("前端参数 attachmentJson不是音频附件，docId："+docId+"--fileName："+fileName);
						}
					}
					issuccess = "success";
					//如果pc端返回的json数据不为空 count暂时传值：1 如果想要取数据的总数，需要请pc端写实现接口，取total
                    result.setCount(0);
                    // errorCode  处理成功传给前端值：0
            		result.setErrorCode(Constants.ACTION_RESULT_SUC);
            		// errorMessage 成功信息传给前端：Y
            		result.setErrorMessage(Constants.ACTIVE_YES);
					//传给前端data：pc端返回的json字符串
	        		result.setData(myJsonArray.toString());
	        		//返回给页面
	        		writeToPage(result);
	        		endTime = System.currentTimeMillis();    //获取结束时间	
	                resultTime = endTime - startTime;
	        		logger.info("区域决议工作流附件下载（总时间） - 程序运行时间  - 后台：" + resultTime + "ms");
	        		
				}else{
					issuccess = "error";
					result.setCount(1);
					this.errorInfo = "附件详情接口抛异常：" + attachments.toString();
		            // errorCode  处理失败传给前端值：1
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage 失败信息传给前端：N
					result.setErrorMessage(Constants.ACTIVE_NO);
		            logger.info("附件详情接口抛异常errorInfo:-----"+errorInfo);
				}
			} catch (Exception e) {
	            this.errorInfo = "附件详情接口抛异常：" + e.getMessage();
	            result.setCount(1);
	            // errorCode  处理失败传给前端值：1
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage 失败信息传给前端：N
				result.setErrorMessage(Constants.ACTIVE_NO);
	            logger.info("附件详情接口抛异常errorInfo:-----"+errorInfo);
			}finally{
				//审批人 等级
            	joblevel = employeeService.getJoblevel(userId);
				/**
				 * 封装监控实体数据
				 */
				WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
				wmEntity.setUserId(userId);
				wmEntity.setJobLevel(joblevel);
				wmEntity.setWorkflowId("");
				wmEntity.setRequestId(requestid);
				wmEntity.setWorkflowName("区域ST/AT决议上报工作流");
				wmEntity.setSysCode("WFS-财务类");
				wmEntity.setStatus("new");
				if(isAudio.equals("Y")){
					wmEntity.setApprovalOption("音频附件");
				}else{
					wmEntity.setApprovalOption("普通附件");
				}
				wmEntity.setRemark("前端传参:"+attachments);
				wmEntity.setResult(issuccess);
				if(issuccess.equals("success")){
					wmEntity.setIsSuccess(1);
				}
				wmEntity.setData("返回前端数据："+myJsonArray.toString());
				wmEntity.setErrorInfo(errorInfo);
				wmEntity.setInterfaceName("attachmentInfos");
				wmEntity.setRejectNode("");
				Date createTime = sdf.parse(createDate);
				wmEntity.setCreateTime(createTime);
				wmEntity.setMethodTime(String.valueOf(resultTime));
				wmEntity.setFileDocId(String.valueOf(docId));
				wmEntity.setFileName(fileName);
				//只保存一条文件下载地址  docId变量  拼接地址不变
				wmEntity.setFilePath(openAttachments+"fileDocId="+docId);
				wmEntity.setFileOpenCount(1);
				wmEntity.setUi_type("");
				wmEntity.setRemark1("");
				wmEntity.setRemark2("");
				wmEntity.setRemark3("");
				
				
				//封装实体数据
				WorkflowBaseInfo baseInfo = new WorkflowBaseInfo();
				baseInfo.setWorkflowId(String.valueOf(docId));
				baseInfo.setWorkflowName(fileName);
				baseInfo.setWorkflowTypeId("");
				baseInfo.setWorkflowTypeName("DWFS-财务类");
				//封装实体数据
				WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
				requestInfo.setCreateTime(createDate);
				requestInfo.setRemark(attachments);
				if(isAudio.equals("Y")){
					requestInfo.setSubmitButtonName("音频附件");
				}else{
					requestInfo.setSubmitButtonName("普通附件");
				}
				requestInfo.setUserid(userId);
				requestInfo.setWorkflowBaseInfo(baseInfo);
				requestInfo.setMessageType(errorInfo);
				//这个回退节点字段 暂存 返回给前端的结果数据
				requestInfo.setRejectButtonName(issuccess);
				
				if(userId !=null && joblevel != null && requestInfo != null && issuccess!=null){
					monitordao.insertApprovalEntityNewMonitor(wmEntity);
        			monitordao.insertApprovalMonitorOld(userId,joblevel,requestInfo,issuccess);
        		}
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
	 * @throws MalformedURLException
	 */
	public void dealAttachments(String userId, String filePath, String fileName, HttpServletResponse response) throws MalformedURLException {
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
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
	 * @param requestId the requestId to set
	 */
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public boolean isDisAgree() {
		return isDisAgree;
	}

	public void setDisAgree(boolean isDisAgree) {
		this.isDisAgree = isDisAgree;
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


	public IRegionalResolutionNewBIService getRegionalResolutionNewBIService() {
		return regionalResolutionNewBIService;
	}


	public void setRegionalResolutionNewBIService(
			IRegionalResolutionNewBIService regionalResolutionNewBIService) {
		this.regionalResolutionNewBIService = regionalResolutionNewBIService;
	}

	public String getFlowtype() {
		return flowtype;
	}

	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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

	public JPushParam getJpushParam() {
		return jpushParam;
	}

	public void setJpushParam(JPushParam jpushParam) {
		this.jpushParam = jpushParam;
	}

	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	public IMonitorDao getMonitordao() {
		return monitordao;
	}

	public void setMonitordao(IMonitorDao monitordao) {
		this.monitordao = monitordao;
	}

	public IQueryEmployeeInfoService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IQueryEmployeeInfoService employeeService) {
		this.employeeService = employeeService;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getOpenAttachments() {
		return openAttachments;
	}

	public void setOpenAttachments(String openAttachments) {
		this.openAttachments = openAttachments;
	}

	public String getServerHostPort() {
		return serverHostPort;
	}

	public void setServerHostPort(String serverHostPort) {
		this.serverHostPort = serverHostPort;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}