package com.deppon.dpm.module.management.server.service.impl;


//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.methods.RequestEntity;
//import org.apache.commons.httpclient.methods.StringRequestEntity;
//import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
//import org.apache.commons.httpclient.protocol.Protocol;

import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IReportDao;
import com.deppon.dpm.module.management.server.service.IReportService;
import com.deppon.dpm.module.management.shared.domain.OrderAddRequest;

public class ReportService implements IReportService{
	private static final String ESB_CODE_SUBMIT="ESB_ISP2ESB_EVENT_REPORT";//上报服务编码
	private static final String ESB_CODE_AUTH="ESB_ISP2ESB_TERMINAL_AUTHORITY";//查询权限服务编码
	private String reportUrl;//上报提交ESB地址
	private String authUrl;//IT上报权限ESB地址
	private IReportDao reportDao;
	
	public IReportDao getReportDao() {
		return reportDao;
	}


	public void setReportDao(IReportDao reportDao) {
		this.reportDao = reportDao;
	}


	@Override
	public String submitReport(OrderAddRequest order) {
		//JSONObject json = (JSONObject) JSON.toJSON(order);
		
		String result=null;
		try {
			result= HttpUtil.httpClient(JsonUtil.beanToJSONObject(order), reportUrl, ESB_CODE_SUBMIT);
			//result= HttpUtil.httpClient(JsonUtil.beanToJSONObject(order), "http://10.224.72.108:8080/itsm/services/app/addOrder", ESB_CODE_SUBMIT);
			//result= HttpUtil.httpClient(JsonUtil.beanToJSONObject(order), "http://192.168.17.103:8180/itsm/services/app/addOrder", ESB_CODE_SUBMIT);
		} catch (Exception e) {
			e.printStackTrace();
			result=null;
		}
		return result;
	}
	

//	private String httpClient(JSONObject json,String url,String esbServiceCode){
//		HttpClient httpClient = new HttpClient();  
//		//设置编码格式
//		httpClient.getParams().setContentCharset("UTF-8");  
//		// 设置超时时间
//		HttpConnectionManagerParams managerParams = httpClient 
//							.getHttpConnectionManager().getParams();
//
//		// 设置连接超时时间(单位毫秒)
//		managerParams.setConnectionTimeout(50000);
//		// 设置读数据超时时间(单位毫秒)
//		managerParams.setSoTimeout(5000);
//		Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);
//		Protocol.registerProtocol("https", myhttps); 	
//		//构造PostMethod的实例 
//		PostMethod postMethod = new PostMethod(url);
//		RequestEntity entity;
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("version","1.0");
//		map.put("Content-Type", "application/json;charset=UTF-8");
//		map.put("esbServiceCode", esbServiceCode);
//		map.put("requestId", UUID.randomUUID().toString());
//		map.put("sourceSystem", "APP");
//		try {
//			
//			entity = new StringRequestEntity(json.toString(),"application/json","UTF-8");
//			postMethod.setRequestEntity(entity);
//			postMethod.addRequestHeader("Content-Type","application/json;charset=UTF-8");
//			postMethod.addRequestHeader("requestHeaders", JSONObject.toJSONString(map));
//			// 执行postMethod 
//			httpClient.executeMethod(postMethod);
//			System.out.println(postMethod.getResponseBodyAsString());
//			return  postMethod.getResponseBodyAsString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	/**
	 * 查询权限
	 */
	public String queryAuthority(String userCode){
	//	JSONObject json = new JSONObject();
		String jsonStr="{\"userCode\":\""+userCode+"\"}";
	//	json=JSONObject.parseObject(jsonStr);
		String res=null;
		try {
			res= HttpUtil.httpClient(JsonUtil.parseObject(jsonStr), authUrl, ESB_CODE_AUTH);
			//res= HttpUtil.httpClient(JsonUtil.parseObject(jsonStr), "http://10.224.72.108:8080/itsm/services/app/theaterUserRole", ESB_CODE_AUTH);
			//res= HttpUtil.httpClient(JsonUtil.parseObject(jsonStr), "http://192.168.17.103:8180/itsm/services/app/theaterUserRole", ESB_CODE_AUTH);
		} catch (Exception e) {
			e.printStackTrace();
			res = "{\"resultFlag\":\"N\",\"errorMsg\":\"哎呀，请求出错，请稍后再试!\",\"dealRole\":false}";
		}
		return res;
	}
	
	public int queryDeptByEmpCode(String empCode){
		try {
			return reportDao.queryDeptByEmpCode(empCode);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}


	public String getReportUrl() {
		return reportUrl;
	}


	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}


	public String getAuthUrl() {
		return authUrl;
	}


	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}
	
}
