package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.deppon.dpm.module.management.server.service.ITheaterDealService;
import com.google.gson.Gson;
/**
 * 移动办公IT服务台终端任务处理接口
 * 
 * @author 245968
 * 
 */
public class ThreaterDealService implements ITheaterDealService {

	/**
	 * url 地址
	 */
	private String url;

	/**
	 * @return url 地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url url 地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param requestEntity 参数
	 * @return str
	 */
	public String theaterDeal(String requestEntity) {
		try {
			//System.err.println(requestEntity);
			HttpClient httpClient = new HttpClient();
			// 设置编码格式
			httpClient.getParams().setContentCharset("UTF-8");
			// 构造PostMethod的实例
			PostMethod postMethod = new PostMethod(url);
			// String str = JSON.toJSONString(request);
			
			Gson gson = new Gson();
			//设置map
			Map<String,String> map = new HashMap<String,String>();
			//map 插入数据
			map.put("version","1.0");
			//设置编码格式
			map.put("Content-Type", "application/json;charset=UTF-8");
			//esb 地址
			map.put("esbServiceCode", "ESB_ISP2ESB_DILL_TASK");
			//设置id
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "APP");
			//转json
			String jsonStr = gson.toJson(map);
			//转entity
			RequestEntity entity = new StringRequestEntity(requestEntity,
					"application/json", "UTF-8");
			postMethod.setRequestEntity(entity);
			postMethod.addRequestHeader("Content-Type",
					"application/json;charset=UTF-8");
			postMethod.addRequestHeader("requestHeaders", jsonStr);
			// 执行postMethod
//			int executeMethod = httpClient.executeMethod(postMethod);
			//返回数据
			return postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
