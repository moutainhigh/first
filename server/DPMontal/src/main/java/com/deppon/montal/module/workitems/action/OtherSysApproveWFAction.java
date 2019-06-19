
package com.deppon.montal.module.workitems.action; 

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.Holder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.bamp.module.log.client.LogRestServiceClient;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.dpm.module.acms.domain.ApproveResultRequest;
import com.deppon.dpm.module.acms.domain.ApproveResultResponse;
import com.deppon.dpm.module.acms.domain.ApprovelEntity;
import com.deppon.esb.header.ESBHeader;
import com.deppon.esb.utils.EsbHeaderData;
import com.deppon.fins.esb.mobile.domain.ApproveRequest;
import com.deppon.fins.esb.mobile.domain.ApproveResponse;
import com.deppon.fins.esb.mobile.mobileservice.IFinsMobileService;
import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.module.crm.damin.WorkflowApproveRequest;
import com.deppon.montal.module.crm.damin.WorkflowApproveResponse;
import com.deppon.montal.module.crm.serivce.CommException;
import com.deppon.montal.module.crm.serivce.IDpmToCrmService;
import com.deppon.montal.module.workitems.webservice.client.OtherSysWorkItemClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.RestfulUtil;
import com.deppon.nhr.module.remote.dpm.service.CommonException;
import com.deppon.nhr.module.remote.dpm.service.WorkFlowToDPMService;
import com.deppon.nhr.module.remote.dpm.shared.domain.workflow.DealWorkFlowRequest;
import com.deppon.nhr.module.remote.dpm.shared.domain.workflow.DealWorkFlowResponse;
import com.deppon.wdgh.inteface.domain.IDpmToWdghService;
   /** 
 * @Title: FsscApproveWFAction.java
 * @Package com.deppon.montal.module.workitems.action 
 * @Description: FSSC工作流审批Action 
 * @author yinrongping 
 * @date 2013-11-12 下午4:11:18 
 * @version V1.0 
 */
public class OtherSysApproveWFAction extends AppDelegateAction {

	private static Logger logger  = Logger.getLogger(OtherSysApproveWFAction.class);
	public static final String CRM_WORKFLOW_SYSCODE = "ICRM";
	public static final String FIN_SELF_WORKFLOW_SYSCODE = "FINS";
	public static final String HR_WORKFLOW_SYSCODE = "INHR";
	public static final String WDGH_WORKFLOW_SYSCODE = "WDGH";
	@SuppressWarnings("unused")
	protected void response() {
		Date begindate=new Date();
		String errorInfo="";
		//数据监控
		String issuccess="0";
		LoginUser login = (LoginUser)getUserRedisService().getFromRedisBySession(getSessionId());
		String opinion = reqPara.get("opinion");//决策
		String decision = reqPara.get("decision");//意见
		String busino = reqPara.get("busino");//业务编号
		String workitemid = reqPara.get("workitemid");//工作项ID
		String backnode = reqPara.get("backnode");//回退节点
		String syscode = reqPara.get("syscode");//业务系统编码
		String processinstid = reqPara.get("processinstid");//工作流号
		String processDefName = reqPara.get("processDefName");//工作流定义名称
		// 活动定义ID
		String activitydefid = reqPara.get("activitydefid");
		
		/*busino="ICRM11111111";
		processDefName="444444444444";
		opinion="tongtongtongyiiii";
		decision="agree";
		workitemid="2210101";
		processinstid="854120";
		syscode="ICRM";*/
		
//		WorkflowApproveResponse result = null;		
//		ApprovalRet result=new ApprovalRet();
		Map<String, Object>  result=new HashMap<String, Object>();
		ApproveResponse finsResp = null;
		DealWorkFlowResponse hrResp = null;
		com.deppon.wdgh.inteface.domain.WorkflowApproveResponse wdghResp = null;
		ApproveResultResponse approvResponse = null;
		logger.info("OtherSysApproveWFAction args is [syscode:"+syscode+" workitemid:"+workitemid+" busino:"+busino+" opinion:"+opinion+" backnode:"+backnode+"]");
		try{
			
		
		if(null != opinion && null != busino && null != workitemid){
			if (CRM_WORKFLOW_SYSCODE.equals(syscode)){
				try{
					logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + busino + " 接口请求业务ID：shenp】");

					HttpClient httpClient = new HttpClient();
					
					//设置编码格式
					httpClient.getParams().setContentCharset("UTF-8");
					// 设置超时时间
					HttpConnectionManagerParams managerParams = httpClient
										.getHttpConnectionManager().getParams();

					// 设置连接超时时间(单位毫秒)
					managerParams.setConnectionTimeout(100000);
					// 设置读数据超时时间(单位毫秒)
					managerParams.setSoTimeout(60000);
					Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);
					Protocol.registerProtocol("https", myhttps); 	
					//构造PostMethod的实例
					String approve_link = InitDataServlet.getValue("icrm_ws_link_esb");
					PostMethod postMethod = new PostMethod(approve_link);//"http://10.224.65.13:8080/crm-interface/ws/workflow/workflow/approve"
//					busino="ICRM11111111";
//					processDefName="444444444444";
//					opinion="tongtongtongyiiii";
//					decision="agree";
//					workitemid="2210101";
//					processinstid="854120";
//					syscode="ICRM";
					
					String json = "{\"busino\": \""+busino+"\",\"processDefName\": \""+processDefName+"\"," +
							"\"approveOperateType\": \""+opinion+"\",\"approveOpinion\": \""+decision+"\"," +
									"\"approverCode\": \""+login.getUserId()+"\",\"workItemId\": "+workitemid +
											",\"processInstId\": "+processinstid+"}";
					
					Map<String,String> map = new HashMap<String,String>();
					map.put("version","1.0");
					map.put("Content-Type", "application/json;charset=UTF-8");
					map.put("esbServiceCode", "ESB_DPM2ESB_WORKFLOW_APPROVAL");
					map.put("requestId", UUID.randomUUID().toString());
					map.put("sourceSystem", "DPM");
					
				    RequestEntity entity = new StringRequestEntity(json,"application/json","UTF-8");
					postMethod.setRequestEntity(entity);
					postMethod.addRequestHeader("Content-Type","application/json;charset=UTF-8");
					postMethod.addRequestHeader("requestHeaders", JSONObject.toJSONString(map));
					// 执行postMethod
					httpClient.executeMethod(postMethod);
					String responseBody = postMethod.getResponseBodyAsString();
//					result = JSONObject.parseObject(responseBody,
//							ApprovalRet.class);
					result=JSON.parseObject(responseBody);
//					System.out.println(map.get("success"));
					errorInfo="★★"+responseBody;
					System.out.println(responseBody+"  返回");
				}catch(Exception e){
					e.printStackTrace();
				}
				
				logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + busino + " 审批是否成功" + result.get("success")+ " 失败原因:" + result.get("failReason") + "】");
				logger.info("end   approveCRM...");

				
//				String approve_link = InitDataServlet.getValue("icrm_esbCode_approve");
//				IDpmToCrmService client = (IDpmToCrmService) OtherSysWorkItemClient.getOtherSysClient("icrm_ws_link", IDpmToCrmService.class);
//				/**
//				 * 3    封装头信息
//				 * */
//				Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino,approve_link);
//				
//				/**
//				 * 4   封装消息体
//				 * */
//				WorkflowApproveRequest request = new WorkflowApproveRequest(busino, processDefName, opinion, decision, login.getUserId(),Double.parseDouble(workitemid),Float.parseFloat(processinstid));
//				
//				logger.info("begin approveCRM..."+"");
//				logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + busino + " 接口请求业务ID：" + esbHeader.value.getBusinessId() + "】");
//				try {
//					result = client.workflowApprove(request, esbHeader);
//				} catch (CommException e) {
//					logger.error("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + busino + " 接口请求业务ID：" + esbHeader.value.getBusinessId()+ " 审批是否成功" + result.isIsSucess() + " 失败原因" + result.getFailReason() + "】,异常原因:" + e.getMessage(),e);
//					result = new WorkflowApproveResponse();
//					result.setIsSucess(false);
//				}
//				logger.info("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + busino + " 审批是否成功" + result.isIsSucess() + " 失败原因:" + result.getFailReason() + "】");
//				logger.info("end   approveCRM...");
			}else if(FIN_SELF_WORKFLOW_SYSCODE.equals(syscode)) {
				
				IFinsMobileService finsClient = (IFinsMobileService)OtherSysWorkItemClient.getOtherSysClient("fins_ws_link", IFinsMobileService.class);
				Holder<ESBHeader> finsEsbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino, InitDataServlet.getValue("fins_esbCode_appr"));
				ApproveRequest finsReq = new ApproveRequest(processinstid,workitemid,busino,opinion,decision,login.getUserId(),login.getEmpName());
				try {
					finsResp = finsClient.approve(finsEsbHeader, finsReq);
				} catch (com.deppon.fins.esb.mobile.mobileservice.CommException e) {
					logger.error("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + processinstid + " 接口请求业务ID：" + finsEsbHeader.value.getBusinessId()+ " 是否调用成功" + finsResp.getIsSuccess() + "】",e);
				}catch(Exception ee){
					logger.info("FINS审批接口异常，异常信息："+ee.getMessage(), ee);
					finsResp = new ApproveResponse();
					//审批失败
					finsResp.setIsSuccess(0);
				}
				
			}else if(HR_WORKFLOW_SYSCODE.equals(syscode)) {
				
				WorkFlowToDPMService hrClient = (WorkFlowToDPMService) OtherSysWorkItemClient.getOtherSysClient("hr_ws_link", WorkFlowToDPMService.class);
				Holder<ESBHeader> hrEsbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino, InitDataServlet.getValue("hr_esbCode_appr"));
				//目前hr没有回退功能，补充后需要将option的判断按照服务端需求修改
				DealWorkFlowRequest hrReq = null;
				if ("0".equals(opinion)) {
					hrReq = new DealWorkFlowRequest(workitemid, "agree",decision,  busino, backnode, processinstid, login.getUserId(), login.getEmpName(),activitydefid,processDefName);
					//特殊审批节点处理
					if(F_Constants.HR_POSITIVEAPPLY_PROCEDEFNAME.equals(processDefName) && "manualActivity1".equals(reqPara.get("activitydefid"))){
						String score = reqPara.get("score");
						hrReq.setSpareFieldOne(score);
					}
					
				}else if("sendback".equals(opinion)) {
					backnode = "Drafter";
					hrReq = new DealWorkFlowRequest(workitemid, opinion,decision,  busino, backnode, processinstid, login.getUserId(), login.getEmpName(),activitydefid,processDefName);
				}else{
					hrReq = new DealWorkFlowRequest(workitemid, "disagree",decision,  busino, backnode, processinstid, login.getUserId(), login.getEmpName(),activitydefid,processDefName);
				}
				
				try {
					hrResp = hrClient.dealWorkFlow(hrReq, hrEsbHeader);
				} catch (CommonException e) {
					logger.error("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + processinstid + " 接口请求业务ID：" + hrEsbHeader.value.getBusinessId()+ " 是否调用成功" + hrResp.getErrorMessage() + "】",e);
				}catch(Exception ee){
					logger.info("HR审批接口异常，异常信息："+ee.getMessage(), ee);
					//审批失败
					hrResp = new DealWorkFlowResponse();
					hrResp.setIsSuccess(false);
				}
			}else if(WDGH_WORKFLOW_SYSCODE.equals(syscode)) {
				IDpmToWdghService wdghClient = (IDpmToWdghService) OtherSysWorkItemClient.getOtherSysClient("wdgh_ws_link", IDpmToWdghService.class);
				Holder<ESBHeader> wdghEsbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", busino, InitDataServlet.getValue("wdgh_esbCode_appr"));
				com.deppon.wdgh.inteface.domain.WorkflowApproveRequest wdghReq = null;
				wdghReq = new com.deppon.wdgh.inteface.domain.WorkflowApproveRequest(busino, processDefName, opinion, decision, login.getUserId(),login.getEmpName() , workitemid, processinstid);
				try {
					wdghResp = wdghClient.workflowApprove(wdghReq, wdghEsbHeader);
				} catch (com.deppon.wdgh.inteface.domain.CommException e) {
					logger.error("【操作记录日志:" + "姓名 " + login.getEmpName() + " 工号:" + login.getUserId() +  " 操作类型" + opinion + "  工作流号" + processinstid + " 接口请求业务ID：" + wdghEsbHeader.value.getBusinessId()+ " 是否调用成功" + wdghResp.getIsSucess() + "】",e);
				}
					
			}else if(F_Constants.ACMS_WORKFLOW_SYSCODE.equals(syscode)){
				/**证照系统审批*/
				//证照系统工作流审批客户端
//				String link = InitDataServlet.getValue("acms_wfs_appro_link");
//				WebClient acmsClient = RestfulUtil.createClient(link);
				//审批参数处理
				ApprovelEntity appro = new ApprovelEntity(Long.parseLong(workitemid),Long.parseLong(processinstid),decision,opinion);
				ApproveResultRequest approvReq = new ApproveResultRequest(login.getUserId(),login.getEmpName(),appro);
				//调用接口
				approvResponse = (ApproveResultResponse) RestfulUtil.invoke("acms_wfs_appro_link",approvReq, ApproveResultResponse.class);
				if(approvResponse == null){
					approvResponse = new ApproveResultResponse();
					approvResponse.setReason("审批异常，请查看后台日志。。。");
					approvResponse.setResultCode(1);
				}
				logger.info("审批结果:"+approvResponse.getResultCode() + ":" + approvResponse.getReason());
			}
			
		}
		
		HttpServletResponse rs = response;
     	rs.setHeader( "Pragma", "no-cache" );
     	rs.addHeader( "Cache-Control", "must-revalidate" );
     	rs.addHeader( "Cache-Control", "no-cache" );
     	rs.addHeader( "Cache-Control", "no-store" );
     	rs.setDateHeader("Expires", 0); 
    	try {
    		
    		//返回结果
    		if (CRM_WORKFLOW_SYSCODE.equals(syscode)){
    			rs.getWriter().write("{\"msg\":\"" + (result.get("success")!=null&&result.get("success").toString().equals("true") ? 0 : 1) + "\"}");
			    if(result.get("success")!=null&&result.get("success").toString().equals("true")){
			    	issuccess="1";
			    }
    		}else if(FIN_SELF_WORKFLOW_SYSCODE.equals(syscode)) {
				rs.getWriter().write("{\"msg\":\"" + (finsResp.getIsSuccess() == 1 ? 1 : 0) + "\"}");
			    if(finsResp.getIsSuccess() == 1){
			    	issuccess="1";
			    }
    		}else if(HR_WORKFLOW_SYSCODE.equals(syscode)) {
				logger.info("审批是否成功: 【"+ hrResp.isIsSuccess() + "】 失败原因：【" + hrResp.getErrorMessage()+"】");
//				rs.getWriter().write("{\"msg\":\"" + (hrResp.isIsSuccess() == true ? 1 : 0) +"\"}");

				/**
				 * 修改，添加报错提示信息
				 * 	1:注释上面一行
				 *  2：添加下面内容  
				 * by张龙哲
				 */
				String rtn = "";
				if(hrResp.isIsSuccess()){
					rtn = "{\"msg\":\"1\"}";
				}else{
					rtn = "{\"msg\":\"0\",\"reason\":\""+hrResp.getErrorMessage()+"\"}";
				}
				rs.getWriter().write(rtn);
				if(hrResp.isIsSuccess()){
					issuccess="1";
				}else{
					errorInfo="★★失败原因：" + hrResp.getErrorMessage();
				}
			}else if(WDGH_WORKFLOW_SYSCODE.equals(syscode)) {
				rs.getWriter().write("{\"msg\":\"" + ("1".equals(wdghResp.getIsSucess()) ? 1 : 0) +"\"}");
			    if("1".equals(wdghResp.getIsSucess())){
			    	issuccess="1";
			    }else{
			    	errorInfo="★★失败原因：" +wdghResp.getFailReason();
			    }
			}else if(F_Constants.ACMS_WORKFLOW_SYSCODE.equals(syscode)){
				rs.getWriter().write("{\"msg\":\"" + approvResponse.getResultCode()+"\",\"reason\":\""+approvResponse.getReason()+"\"}");
			    if(approvResponse.getResultCode()==0){
			    	issuccess="1";
			    }else{
			    	errorInfo="★★失败原因：" +approvResponse.getReason();
			    }
			}
    	}catch(Exception e){
    		errorInfo="★★"+e.getMessage();
    	}
    		
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}finally{
    		
    		try {
    			new ToApproveAction().requestClient(login.getUserId(),(String)request.getSession().getAttribute("newflowtype"),begindate,new Date(),(String)request.getSession().getAttribute("newbusino"),issuccess,"1",errorInfo);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
	}
	
	
	@Override
	protected void mapParameters() {
		// TODO Auto-generated method stub
		super.mapParameters();
	}
	
	/**
	 * @MethodName: initParamsInfos 
	 * @description: 重载初始化访问参数
	 * @author: wuyaqing 
	 * @date: 2014-5-12 上午8:32:44
	 */
	@Override
	protected void initParamsInfos() {
		//设置用户工号
		busiOpertEntity.setEmpCode(getUserId());
		//设置操作时间
		busiOpertEntity.setOperationTime(LogClientUtil.getNowDate());
		//设置模块名称
		busiOpertEntity.setModuleName("审批工作流");
		//设置操作内容
		busiOpertEntity.setOperationContent("审批CRM或者FIN或者NHR的工作流");
	}
	
	/**
	 * @MethodName: saveAccessOperInfo 
	 * @description: 重载调用BAMP日志的方法
	 * @author: wuyaqing 
	 * @date: 2014-5-12 上午8:41:10
	 */
	@Override
	protected void saveAccessOperInfo() {
		//通过客户端调BPMS接口记录操作日志
		LogRestServiceClient.insertBusiOperInfo(busiOpertEntity);
	}
	
}

