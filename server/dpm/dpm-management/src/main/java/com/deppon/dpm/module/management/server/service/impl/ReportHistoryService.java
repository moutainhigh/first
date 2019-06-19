package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.management.server.service.IReportHistoryService;
import com.google.gson.Gson;

/**
* @ClassName: ReportHistoryService
* @Description: ReportHistoryService
* @author A18ccms a18ccms_gmail_com
* @date 2016-4-8 下午2:15:20
* 
*/

public class ReportHistoryService implements IReportHistoryService {
	// 请求地址
	private String url;

	// httpClient
	private HttpClient hclient;
	/**
     * @param userId 工号
     * @return 查询信息
     */
	@Override
	public String queryReportHistory(String userId) {
		//声明一个变量
		String rs = "";
		try{
			//new 一个gson
			Gson gson = new Gson(); 
			//new 一个HttpClient
			hclient = new HttpClient();
			//设置编码格式
			hclient.getParams().setContentCharset("UTF-8");
			// 设置超时时间
			HttpConnectionManagerParams managerParams = hclient
								.getHttpConnectionManager().getParams();

			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(MagicNumber.NUM60000);
			// 设置读数据超时时间(单位毫秒)
			managerParams.setSoTimeout(MagicNumber.NUM10000);
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), MagicNumber.NUM443);
			Protocol.registerProtocol("https", myhttps); 	
			//构造PostMethod的实例
			PostMethod postMethod = new PostMethod(url);
			Map<String,String> map = new HashMap<String,String>();
			//设置版本
			map.put("version","1.0");
			//设置编码格式
			map.put("Content-Type", "application/json;charset=UTF-8");
			map.put("esbServiceCode", "ESB_ISP2ESB_QUERY_REQ");
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "APP");
			//得到数据
			String jsonStr = gson.toJson(map);
			//new 一个jsonObj
			JSONObject jsonObj = new JSONObject();
			//put 数据
			jsonObj.put("userCode", userId); 
			String js = jsonObj.toString(); 
			//设置编码格式
			RequestEntity entity = new StringRequestEntity(js,"application/json","UTF-8");
			//把实体set进去
			postMethod.setRequestEntity(entity);
			//设置编码格式
			postMethod.addRequestHeader("Content-Type","application/json;charset=UTF-8");
			postMethod.addRequestHeader("requestHeaders", jsonStr);
			//调用请求获取响应
			hclient.executeMethod(postMethod);
            //得到结果集
			rs = postMethod.getResponseBodyAsString();
			
		} catch(Exception e) {
			rs = "{\"resultFlag\":\"Y\",\"errorMsg\":\"抱歉   请求暂时出错   刷新试试！\",\"orderApps\":null}";
			//System.out.print(e.getMessage());
		} 
		//返回数据
		return rs;

	}
    //get set url
	public String getUrl() {
		return url;
	}
    //get set url
	public void setUrl(String url) {
		this.url = url;
	}
}
