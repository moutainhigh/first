
package com.deppon.montal.module.workitems.webservice.client; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;

import com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity;
import com.deppon.montal.util.InitDataServlet;

/** 
 * @Title: FSSCWorkItemServiceClient.java
 * @Package com.deppon.montal.module.workitems.webservice.client 
 * @Description: 对接FSSC工作流相关的接口客户端
 * @author yinrongping 
 * @date 2013-11-6 下午5:05:42 
 * @version V1.0 
 */
public class FSSCWorkItemServiceClient extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static Logger logger  = Logger.getLogger(FSSCWorkItemServiceClient.class);
	private static Client client = null;
	//报账系统的接口地址
	public static String FSSC_WEBSERVICES_LINK;
	
	@Override
	public void init() throws ServletException {
		FSSC_WEBSERVICES_LINK = InitDataServlet.getValue("fssc_ws_link");
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
        client = dcf.createClient(FSSC_WEBSERVICES_LINK);
		//FSSC_WEBSERVICES_LINK = "http://10.224.65.122:8881/claim/webservice/MobileFsscService";
	}
	
	/**
	 * 
     * @Title: getFSSCWorkItemInfo 
     * @param claimNo，userid
	 * @throws Exception 
     * @Description:获取FSSC报账的整个信息（包括审批记录）
     * @date 2013-11-6 下午5:12:24
	 */
	public static MobileFsscEntity getFSSCWorkItemInfo(Object[] args) throws Exception{
		if(client == null){
			FSSCWorkItemServiceClient wfclient = new FSSCWorkItemServiceClient();
			wfclient.init();
		}
		try {
	        //url为调用webService的wsdl地址  
	        QName name=new QName("http://service.mobile.remote.module.fssc.deppon.com/","getFsscEntityInfo");
	        //paramvalue为参数值
	        Object[] objects=client.invoke(name,args);
	        MobileFsscEntity mobileFsscEntity =  (MobileFsscEntity) objects[0];
	        return mobileFsscEntity;
		} catch (Exception e) {
			logger.info("获取报账系统业务数据异常，当前工作流信息：【报账单号："+args[0]+" 当前审批人:"+args[1]+"  工作项ID:" + args[2]+"】,异常信息："+e.getMessage(), e);
			throw new Exception("获取报账系统业务数据异常，当前工作流信息：【报账单号："+args[0]+" 当前审批人:"+args[1]+"  工作项ID:" + args[2]+"】,异常信息："+e.getMessage(), e);
		}
	}
	
	/**
	 * 
	   * @Title: approveFSSC 
	   * @param: WfParamVo(wfProcInstId、wfState、wfWorkitemId、wfDecision、wfOpinion)
	   * @throws ServletException 
	   * 
	   * @Description:审批FSSC的报账工作流Drafter
	   * @date 2013-11-6 下午5:13:41
	 */
	public static String approveFSSC(Object[] args) throws ServletException{
		if(client == null){
			FSSCWorkItemServiceClient wfclient = new FSSCWorkItemServiceClient();
			wfclient.init();
		}
		try {
	        //url为调用webService的wsdl地址  
	        QName name=new QName("http://service.mobile.remote.module.fssc.deppon.com/","submit");  
	        //paramvalue为参数值  
	        Object[] result = client.invoke(name,args);
	        return (String) result[0];
		} catch (Exception e) {
			logger.info("调用报账系统接口审批异常，当前工作流信息：【报账单号："+args[0]+" 当前审批人:"+args[1]+"  工作项ID:" + args[2]+"】,异常信息："+e.getMessage(), e);
			return "2"+"★★调用报账系统接口审批异常，当前工作流信息：【报账单号："+args[0]+" 当前审批人:"+args[1]+"  工作项ID:" + args[2]+"】,异常信息："+e.getMessage();
		}
	}
}

