package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.management.server.service.IIssuesAndAddrsService;
import com.google.gson.Gson;

/**
 * 问题类型和具体位置实现接口
 * @author 233357
 * @date   2015/04/01
 */
public class IssuesAndAddrsService implements IIssuesAndAddrsService {

	//请求地址
    private String url;

    //httpClient
    private HttpClient hclient;
    
	@Override
	public String queryIssuesAndAddrs() {
		String rs = "";
		try{
			//new 一个gson
			Gson gson = new Gson();  
			//new 一个hclient
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
			//PostMethod postMethod = new PostMethod("http://10.224.72.108:8080/itsm/services/app/queryBaseInfo"); 
			//PostMethod postMethod = new PostMethod("http://192.168.17.103:8180/itsm/services/app/queryBaseInfo");
			PostMethod postMethod = new PostMethod(url);
			
			Map<String,String> map = new HashMap<String,String>();
			map.put("version","1.0");
			map.put("Content-Type", "application/json;charset=UTF-8");
			map.put("esbServiceCode", "ESB_ISP2ESB_METADATA_SYNC");
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "APP");
			String jsonStr = gson.toJson(map);
			
			postMethod.addRequestHeader("Content-Type","application/json;charset=UTF-8");
			postMethod.addRequestHeader("requestHeaders", jsonStr);
			
			//调用请求获取响应
			hclient.executeMethod(postMethod);
            //得到结果集
			rs = postMethod.getResponseBodyAsString();
			JSONObject jsonObj = JSONObject.parseObject(rs);
			if (jsonObj.getJSONArray("faults")!= null) {
				String foss=null,crm=null,desktop=null,dlp=null,wfs=null;
				JSONArray jsonArr = jsonObj.getJSONArray("faults");
				//JSONArray josnFive = new JSONArray();
				//对数据进行重组
				for (int i=0 ; i < jsonArr.size(); i++) {
					//得到faultName
 					String faultName=jsonArr.getJSONObject(i).getString("faultName");
 					//得到faultId
 					String faultId=jsonArr.getJSONObject(i).getString("faultId");
 					//进行判断
 					if (faultName.equals("FOSS")) {
 						foss=faultId;
					}
 					if (faultName.equals("CRM系统")) {
 						crm=faultId;
					}
 					if (faultName.equals("桌面维护")) {
 						desktop=faultId;
					}
 					if (faultName.equals("DLP问题")) {
 						dlp=faultId;
					}
 					if (faultName.equals("工作流系统")) {
 						wfs=faultId;
					}
				}
				//声明一个变量
 				String str="[{\"faultId\":\""+foss+"\",\"faultName\":\"FOSS\"},{\"faultId\":\""+crm+"\",\"faultName\":\"CRM系统\"}," +
 						"{\"faultId\":\""+desktop+"\",\"faultName\":\"桌面维护\"},{\"faultId\":\""+dlp+"\",\"faultName\":\"DLP问题\"}," +
 								"{\"faultId\":\""+wfs+"\",\"faultName\":\"工作流系统\"}]";
 				//String str=josnFive.toString();
 				jsonObj.put("fivefaults", str);
 				//转为字符串
 				rs = jsonObj.toJSONString();
			}
		} catch(Exception e) {
			//捕获异常
			rs = "{\"resultFlag\":\"Y\",\"errorMsg\":\"抱歉   请求暂时出错   刷新试试！\",\"faults\":null,\"addresses\":null}";
			//System.out.print(e.getMessage());
		} 
		//返回结果街
		return rs;
		
	}
	//url get set
	public String getUrl() {
		return url;
	}
	//url get set
	public void setUrl(String url) {
		this.url = url;
	}
}
