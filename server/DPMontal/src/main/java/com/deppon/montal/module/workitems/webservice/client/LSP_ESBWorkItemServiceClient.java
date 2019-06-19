package com.deppon.montal.module.workitems.webservice.client;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.xml.ws.Holder;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import com.deppon.esb.header.ESBHeader;
import com.deppon.esb.utils.EsbHeaderData;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.server.service.IMobileWorkflowService;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.Auditparameters;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowBusinessData;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity;
import com.deppon.montal.util.InitDataServlet;

public class LSP_ESBWorkItemServiceClient {
	private static Logger logger = Logger.getLogger(LSP_ESBWorkItemServiceClient.class); 
	
	//后勤系统的接口地址
	public static String LSP_WEBSERVICES_LINK;
	//后勤在esb中注册的查询的编码
	public static String LSP_ESBCODE_SEARCH;
	//后勤在esb中注册的审批的编码
	public static String LSP_ESBCODE_APPROVE;
	public static IMobileWorkflowService client = null;
	private static LSP_ESBWorkItemServiceClient obj;
	private LSP_ESBWorkItemServiceClient(){}
	public static LSP_ESBWorkItemServiceClient getLSP_ESBWorkItemServiceClient(){
		if (obj == null){
			obj =  new LSP_ESBWorkItemServiceClient();
			LSP_WEBSERVICES_LINK = InitDataServlet.getValue("lsp_esb_ws_link");
			LSP_ESBCODE_SEARCH = InitDataServlet.getValue("lsp_esbCode_search");
			LSP_ESBCODE_APPROVE = InitDataServlet.getValue("lsp_esbCode_approve");
			//FSSC_WEBSERVICES_LINK = "http://10.224.65.122:8881/claim/webservice/MobileFsscService";
			client = getClient();
		}
		return obj;
	}
	
	/**
	 * 调用后勤接口，返回查询实体
	 * @param params
	 * @return
	 */
	public WorkflowEntity getLSPEntity (Map<String,String> params) {
		
		/**
		 * 封装头信息
		 * */
		Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0",params.get("busino"), LSP_ESBCODE_SEARCH);
	
		/**
		 * 封装消息体
		 * */
		WorkflowBusinessData workflowInfoRequest = new WorkflowBusinessData();
		workflowInfoRequest.setWorkflowNumber(params.get("busino"));
		workflowInfoRequest.setEmpCode(params.get("empCode"));
		workflowInfoRequest.setEmpName(params.get("empName"));
	    
		/**
		 * 调用远程方法，获取返回值
		 * */
		WorkflowEntity workflowInfo = new WorkflowEntity();;
		try {
			workflowInfo = client.queryWorkflowInfo(workflowInfoRequest, esbHeader);
		}catch (com.deppon.lsp.module.mobileworkflowlist.controlcenter.server.service.CommException e) {
			logger.error("后勤查询接口调用异常" + e.getMessage(),e);
		}
		return workflowInfo;
	}
	//调用后勤审批
	
	public int approvalLSPWorkflow (Map<String,String> reqPara,String userId,String empName) {
		/**
		 * 存取返回值结果
		 */
		int result = 0;
		
		/**
		 * 封装消息体
		 * */
		Auditparameters audit = new Auditparameters();
		audit.setWfInstanceId(Long.parseLong(reqPara.get("processinstidDLSP")));//流程号
		audit.setWfState(reqPara.get("activityIdDLSP"));//当前活动的流程定义id
		audit.setWfWorkItemId(Long.parseLong(reqPara.get("workitemidDLSP")));//工作项定义id
		String busino = reqPara.get("businoDLSP");
		audit.setDocId(busino);//业务编号
		String options = "";
		try {
			options = new String(reqPara.get("opinionsLSP").getBytes("utf-8"), "utf-8");
		} catch (UnsupportedEncodingException e2) {
			logger.error("字节转换异常" + e2.getMessage(),e2);
		}
		audit.setAuditAdvise(options);//审批意见
		audit.setDecisionState(reqPara.get("decisionDLSP"));//审批决策
		audit.setEmpCode(userId);//登录的审批人工号
		audit.setEmpName(empName);//登录的审批人姓名
		
		/**
		 * 封装头信息
		 * */
		Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0",busino, LSP_ESBCODE_APPROVE);
		
		try {
			result = client.workflowApprove(audit, esbHeader);
		}catch (com.deppon.lsp.module.mobileworkflowlist.controlcenter.server.service.CommException e) {
			logger.error("后勤接口调用异常" + e.getMessage(),e);
		}
		/**
		 * 返还返回值
		 */
		return result;
	}
	
	public static IMobileWorkflowService getClient() {
		/**
		 * 初始化cxf客户端
		 * */
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		/**
		 * 设置访问服务器端的指定接口
		 */
		factory.setServiceClass(IMobileWorkflowService.class);
		/**
		 *  设置访问的服务的地址
		 */
		factory.setAddress(LSP_WEBSERVICES_LINK);
		/**
		 * 创建远程对象，以供远程调用
		 */
		client = (IMobileWorkflowService)factory.create();
		
		return client;
	}
	/**
	 * 
	* @MethodName: initLmsApprov 
	* @description : 初始化接口传入参数
	* @author：caibingbing 
	* @date： 2014-8-13 下午6:55:11
	* @param reqPara
	* @param userId
	* @param empName
	* @return com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.Auditparameters
	 */
	public static com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.Auditparameters initLmsApprov(
			Map<String, String> reqPara, String userId, String empName) {
		/**
		 * 封装消息体
		 * */
		com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.Auditparameters audit = new com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.Auditparameters();
		audit.setWfInstanceId(Long.parseLong(reqPara.get("processinstidDLSP")));//流程号
		audit.setWfState(reqPara.get("activityIdDLSP"));//当前活动的流程定义id
		audit.setWfWorkItemId(Long.parseLong(reqPara.get("workitemidDLSP")));//工作项定义id
		String busino = reqPara.get("businoDLSP");
		audit.setDocId(busino);//业务编号
		String options = "";
		try {
			options = new String(reqPara.get("opinionsLSP").getBytes("utf-8"), "utf-8");
		} catch (UnsupportedEncodingException e2) {
			logger.error("字节转换异常" + e2.getMessage(),e2);
		}
		audit.setAuditAdvise(options);//审批意见
		audit.setDecisionState(reqPara.get("decisionDLSP"));//审批决策
		audit.setEmpCode(userId);//登录的审批人工号
		audit.setEmpName(empName);//登录的审批人姓名
		return audit;
	}
}
