package com.deppon.montal.module.workitems.webservice.client;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;

import com.deppon.montal.util.InitDataServlet;

/**
 * @Title: LSPWorkItemServiceClient.java
 * @Package com.deppon.montal.module.workitems.webservice.client
 * @Description: 对接LSP工作流相关的接口客户端
 * @author yinrongping
 * @date 2013-11-6 下午5:05:42
 * @version V1.0
**/ 
public class LSPWorkItemServiceClient {

	public static final LSPWorkItemServiceClient LSPWorkItemServiceClient = null;
	// 后勤自助系统的接口地址
	public static String LSP_WEBSERVICES_LINK;
	private static Logger logger = Logger.getLogger(LSPWorkItemServiceClient.class);
	private static Client client = null;
	private static LSPWorkItemServiceClient obj ;
	private LSPWorkItemServiceClient(){
	}
	public static LSPWorkItemServiceClient getLSPWorkItemServiceClient(){
		if (obj == null){
			obj = new LSPWorkItemServiceClient();
			LSP_WEBSERVICES_LINK = InitDataServlet.getValue("lsp_ws_link");
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
	        client = dcf.createClient(LSP_WEBSERVICES_LINK);
		}
		return obj;
	}
	
	//原来的设计是放到静态代码块中这样不好，类加载的时候就会开辟这些空间，但是如果我还没有使用呢
	/*static {
		LSP_WEBSERVICES_LINK = InitDataServlet.getValue("lsp_ws_link");
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
        client = dcf.createClient(LSP_WEBSERVICES_LINK);
	}*/

	/**
	 * 
	 * @MethodName: getLSPWorkItemInfo
	 * @description : TODO
	 * @author：何玲菠
	 * @date： 2013-12-10 下午2:27:24
	 * @param args
	 * @return WorkflowData
	 */
	public Object getLSPWorkItemInfo(Object[] params, String methodName) {
        //url为调用webService的wsdl地址  
        QName name=new QName("http://service.server.mobileworkflow.module.lsp.deppon.com/",methodName);
        //paramvalue为参数值  
        Object[] result = null;
		try {
			result = client.invoke(name,params);
		} catch (Exception e) {
			logger.error("后勤查询未走esb接口调用异常" + e.getMessage(),e);
			result = new Object[]{1};
		}
		return result[0];
	}
	/**
	 * 
	 * @Title: approveLSP
	 * @Description:TODO(LSP审批接口方法)
	 * @param @param 审批参数
	 * @param @return 设定文件
	 * @throws Exception 
	 * @returnString 返回类型
	 * @throws
	 * @date 2013-11-11 上午11:26:08
	 */
	public String approveLSP(Object[] args , String methodName){
//		try {
//			// 客户端
//			RPCServiceClient serviceClient = new RPCServiceClient();
//			Options options = serviceClient.getOptions();
//			EndpointReference targetEPR = new EndpointReference(LSP_WEBSERVICES_LINK);
//			options.setTo(targetEPR);
//			QName opName = new QName("http://service.server.mobileworkflow.module.lsp.deppon.com/", methodName);
//			String result = serviceClient.invokeBlocking(opName, args, new Class[] { String.class })[0].toString();
//			logger.info("call webservice result:" + result);
//			return result;
//		} catch (AxisFault e) {
//			logger.info("getLSPWorkItemInfo exception:" + e);
//			return "2";
//		}
		/*JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
        org.apache.cxf.endpoint.Client client = dcf.createClient(LSP_WEBSERVICES_LINK);  */
        //url为调用webService的wsdl地址  
        QName name=new QName("http://service.server.mobileworkflow.module.lsp.deppon.com/",methodName);  
        //paramvalue为参数值  
        Object[] objects = null;
        String result = "";
		try {
			objects = client.invoke(name,args);
			result = "" + objects[0];
		} catch (Exception e) {
			logger.error("后勤查询未走esb接口调用异常" + e.getMessage(),e);
			result="2"+"★★后勤查询未走esb接口调用异常" + e.getMessage();
		}
//		String result = "" + objects[0];
		return result;
	}
}
