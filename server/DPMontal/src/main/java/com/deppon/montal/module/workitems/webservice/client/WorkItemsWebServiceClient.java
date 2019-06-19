
package com.deppon.montal.module.workitems.webservice.client; 



import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.deppon.montal.util.InitDataServlet;
   /** 
 * @Title: WorkItemsWebServiceClient.java
 * @Package com.deppon.montal.module.workitems.webservice.client 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-2-21 下午6:53:08 
 * @version V1.0 
 */
public class WorkItemsWebServiceClient {
    
//	public static RPCServiceClient serviceClient;
	private static String url = null;
	private static Client client;
	static {
//		try {
//			serviceClient = new RPCServiceClient();
//		} catch (AxisFault e) {
//			e.printStackTrace();
//		}
//   	    Options options = serviceClient.getOptions();
//   		EndpointReference  targetEPR = new EndpointReference(InitDataServlet.getValue("work_ws_link"));
//   	    	
//   		options.setTo(targetEPR);
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(); 
		url = InitDataServlet.getValue("work_ws_link");
        client = dcf.createClient(url);
		
   		
	}
	
	/**
	 * 
	 * @param args 传参
	 * @param clases 返回类型
	 * @param opName 调用方法
	 * @return
	 * @throws Exception 
	 */
	public static String approval(Object[] args) throws Exception{
		
//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
//        org.apache.cxf.endpoint.Client client = dcf.createClient(url);
        //url为调用webService的wsdl地址  
        QName name=new QName("http://www.primeton.com/DPmontalWorflowWebServiceService","approveAction");
        //paramvalue为参数值
        Object[] objects=client.invoke(name,args);
        String result =  (String) objects[0].toString();
        return result;
//		try {
//			Class[] clases = new Class[]{String.class};
//			QName opName = new QName("http://www.primeton.com/DPmontalWorflowWebService","approveAction");
//			String result = serviceClient.invokeBlocking(opName, args, new Class[]{String.class})[0].toString();
//			return result;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
	}
	/**
	 * 
	 * @param args 传参
	 * @param clases 返回类型
	 * @param opName 调用方法
	 * @return
	 * @throws AxisFault 
	 */
	public static  String rollBack(Object[] args) throws Exception{
//        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
//        org.apache.cxf.endpoint.Client client = dcf.createClient(url);
        //url为调用webService的wsdl地址  
        QName name=new QName("http://www.primeton.com/DPmontalWorflowWebServiceService","reBack");
        //paramvalue为参数值
        Object[] objects=client.invoke(name,args);
        String result =  (String) objects[0].toString();
        return result;
//		Class[] clases = new Class[]{String.class};
//		String result =null;
//		QName opName = new QName("http://www.primeton.com/DPmontalWorflowWebService","reBack");
//		result = serviceClient.invokeBlocking(opName, args, new Class[]{String.class})[0].toString();
	}
	public static String findAcitivityInst( Object[] args) throws Exception{
//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
//        org.apache.cxf.endpoint.Client client = dcf.createClient(url);
        //url为调用webService的wsdl地址  
        QName name=new QName("http://www.primeton.com/DPmontalWorflowWebServiceService","findActivityInstByActivityInst");
        //paramvalue为参数值    http://www.primeton.com/DPmontalWorflowWebServiceService
//        args = new Object[44619662];
        Object[] objects=client.invoke(name,args);
        String result = objects[0].toString();
        return result;
//		Class[] clases = new Class[]{String.class};
//		QName opName = new QName("http://www.primeton.com/DPmontalWorflowWebService","findActivityInstByActivityInst");
//		
//		return serviceClient.invokeBlocking(opName, args, new Class[]{String.class})[0].toString();
	}
}

