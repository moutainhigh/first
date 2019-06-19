package com.deppon.montal.module.workitems.webservice.client;

import javax.xml.ws.Holder;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;

import com.deppon.esb.header.ESBHeader;
import com.deppon.esb.utils.EsbHeaderData;
import com.deppon.montal.module.crm.damin.QueryWorkflowInfoRequest;
import com.deppon.montal.module.crm.damin.QueryWorkflowInfoResponse;
import com.deppon.montal.module.crm.serivce.CommException;
import com.deppon.montal.module.crm.serivce.IDpmToCrmService;
import com.deppon.montal.util.InitDataServlet;

public class OtherSysWorkItemClient {
	private static Logger logger  = Logger.getLogger(OtherSysWorkItemClient.class);
	/**
	 * 
	* @MethodName: getOtherSysClient 
	* @description : 创建外部系统客户端
	* @author：caibingbing 
	* @date： 2014-4-17 上午11:48:33
	* @param icrm_ws_link
	* @param class1
	* @return Object
	 */
	public static <T> Object getOtherSysClient(String ws_link, Class<T> class1){
		String link = InitDataServlet.getValue(ws_link);
		logger.info("接口地址："+link);
		/**
		 * 2    初始化cxf客户端
		 * */
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		//设置访问服务器端的指定接口
		factory.setServiceClass(class1);
		// 设置访问的服务的地址
		factory.setAddress(link);
		//创建远程对象，以供远程调用
		Object client = factory.create();
		logger.info("接口对象："+client);
		return client;
	}
	
	public static void main(String[] args){
		/**
		 * 2    初始化cxf客户端
		 * */
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		//设置访问服务器端的指定接口
		factory.setServiceClass(IDpmToCrmService.class);
		// 设置访问的服务的地址
		factory.setAddress("http://192.168.67.12:8580/esb2/ws/dpm2crm/queryWorkflow?wsdl");
		//创建远程对象，以供远程调用
		IDpmToCrmService client = (IDpmToCrmService) factory.create();
	/**
	 * 3    封装头信息
	 * */
	Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0","","ESB_DPM2ESB_CWORKFLOW_SEARCH");

	/**
	 * 4   封装消息体
	 * */
//	QueryWorkflowInfoRequest request = new QueryWorkflowInfoRequest("ICRM201312230000144", "com.deppon.bpms.module.crm.bpsdesign.administLegal.monCustSignAppExpress", Integer.parseInt("13489647"), "007127", "李科");
	QueryWorkflowInfoRequest request = new QueryWorkflowInfoRequest("ICRM201312300000166", "com.deppon.bpms.module.crm.bpsdesign.administLegal.monCustSignEidtExpress", Integer.parseInt("13489961"), "074932", "王菲菲");

	/**
	 * 5    调用远程方法，获取返回值
	 * */
    QueryWorkflowInfoResponse response = new QueryWorkflowInfoResponse();;
	try {
		response = client.queryWorkflowInfo(request, esbHeader);
	} catch (CommException e) {
		e.printStackTrace();
	}
	System.out.println(response);
	
//	approve();
//	approCRM("http://192.168.67.12:8580/esb2/ws/dpm2crm/queryWorkflow?wsdl",IDpmToCrmService.class);
}

//private static void approCRM(String string, Class<IDpmToCrmService> class1) {
//	/**
//	 * 2    初始化cxf客户端
//	 * */
//	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//	//设置访问服务器端的指定接口
//	factory.setServiceClass(class1);
//	// 设置访问的服务的地址
//	factory.setAddress(string);
//	//创建远程对象，以供远程调用
//	IDpmToCrmService client = (IDpmToCrmService)factory.create();
//	/**
//	 * 3    封装头信息
//	 * */
//	Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", "ESB_DPM2ESB_COMPENSATE_APPLY");
//	 
//	/**
//	 * 4   封装消息体
//	 * */
//	WorkflowApproveRequest request = new WorkflowApproveRequest();
//    request.setBusino("ICRM201312250000164");
//    request.setApproverCode("050044");
//    request.setProcessDefName("com.deppon.bpms.module.crm.bpsdesign.administLegal.monCustSignAppExpress");
//    request.setApproveOperateType("0");
//    request.setApproveOpinion("接口测试同意13489781");
//    request.setProcessInstId(13489781);
//    request.setWorkItemId(48521640);
//    
//	/**
//	 * 5    调用远程方法，获取返回值
//	 * */
//    WorkflowApproveResponse response = new WorkflowApproveResponse();;
////    Object response = null;
//	try {
//		response = client.workflowApprove(request, esbHeader);
//	} catch (CommException e) {
//		e.printStackTrace();
//	}
//	System.out.println(response);
//}
//
//public static void approve(){
//	/**
//	 * 2    初始化cxf客户端
//	 * */
//	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//	//设置访问服务器端的指定接口
//	factory.setServiceClass(IDpmToCrmService.class);
//	// 设置访问的服务的地址
//	factory.setAddress("http://192.168.67.12:8580/esb2/ws/dpm2crm/queryWorkflow?wsdl");
//	//创建远程对象，以供远程调用
//	IDpmToCrmService client = (IDpmToCrmService)factory.create();
//	/**
//	 * 3    封装头信息
//	 * */
//	Holder<ESBHeader> esbHeader = EsbHeaderData.setEsbHeaderData("1.0.0", "ESB_DPM2ESB_COMPENSATE_APPLY");
//	 
//	/**
//	 * 4   封装消息体
//	 * */
//	WorkflowApproveRequest request = new WorkflowApproveRequest();
//    request.setBusino("ICRM201312250000164");
//    request.setApproverCode("074932");
//    request.setProcessDefName("com.deppon.bpms.module.crm.bpsdesign.administLegal.monCustSignAppExpress");
//    request.setApproveOperateType("0");
//    request.setApproveOpinion("接口测试同意13489781");
//    request.setProcessInstId(13489961);
//    request.setWorkItemId(48521640);
//    
//	/**
//	 * 5    调用远程方法，获取返回值
//	 * */
//    WorkflowApproveResponse response = new WorkflowApproveResponse();;
////    Object response = null;
//	try {
//		response = client.workflowApprove(request, esbHeader);
//	} catch (CommException e) {
//		e.printStackTrace();
//	}
//	System.out.println(response);
//}
}
