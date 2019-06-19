package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

//import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.management.server.service.IQueryTheaterInfoService;
//import com.deppon.dpm.module.management.shared.domain.QueryTheaterInfoRequset;
import com.google.gson.Gson;

public class QueryTheaterInfoService implements IQueryTheaterInfoService {

	/**
	 * 地址
	 */
	private String url;

	/**
	 * @return 地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url 地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param requestEntity 传入的参数
	 * @return str
	 */
	public String queryTheater(String requestEntity) {

		// 测试url http://10.224.72.108:8080/itsm/services/app/queryTheaterInfo
		try {
			//new  gson
			Gson gson = new Gson(); 
			// http 
			HttpClient httpClient = new HttpClient();
			// 设置编码格式
			httpClient.getParams().setContentCharset("UTF-8");
			// 构造PostMethod的实例
			PostMethod postMethod = new PostMethod(url);
			//设置map
			Map<String,String> map = new HashMap<String,String>();
			//设置map
			map.put("version","1.0");
			//设置map编码格式
			map.put("Content-Type", "application/json;charset=UTF-8");
			//设置map esb
			map.put("esbServiceCode", "ESB_ISP2ESB_TASK_QUERY");
			//设置map uuid
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "APP");
			//转json
			String jsonStr = gson.toJson(map);
			//转json得到实体类
			RequestEntity entity = new StringRequestEntity(requestEntity,
					"application/json", "UTF-8");
			postMethod.setRequestEntity(entity);
			//设置编码格式
			postMethod.addRequestHeader("Content-Type",
					"application/json;charset=UTF-8");
			postMethod.addRequestHeader("requestHeaders", jsonStr);
			// 执行postMethod
			httpClient.executeMethod(postMethod);
			return postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			//System.out.print(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

}
