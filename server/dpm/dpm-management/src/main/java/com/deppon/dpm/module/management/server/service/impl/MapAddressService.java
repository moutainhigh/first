package com.deppon.dpm.module.management.server.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.service.IMapAddressService;

/**
 * @author 王亚男
 */
public class MapAddressService implements IMapAddressService {

	private static Logger logger = LoggerFactory.getLogger(MapAddressService.class);
	
	//pc端URL
	private String defaultUrl;
	//pc端端口
	private int defaultPort;
	
	//ESBcode
	private String esbCode;
	//公里范围
	private String radius;
	
	
	
	/**
	 * @param longitude//经度
	 * @param latitude//纬度
	 */
	public String getNameInfoByXY(String longitude, String latitude) {
		logger.info("根据经纬度 经度 longitude:"+longitude+";纬度latitude:"+latitude+"查询部门信息");
		//设置参数信息
		Map<String,String> params = new HashMap<String,String>();
		params.put("longitude", longitude);//经度
		params.put("latitude", latitude);//纬度
		params.put("radius", radius);
		params.put("esbServiceCode",esbCode);
		//获取对应地址经纬度的部门信息
		String listJson = getActionInfoMothedGet(params,defaultUrl,defaultPort);
		logger.info("根据经纬度 经度 longitude:"+longitude+";纬度latitude:"+latitude+"查询部门信息result:"+listJson);
		return listJson;
	}
	
	
	/**
	 * Get 方法获取信息
	 * @param params传递的参数Map name=key,value=map.get(key)
	 * @param url	要访问的URL地址
	 * @param port	要访问URL的端口号
	 * @return	JSON 查询出的数据
	 */
	private String getActionInfoMothedGet(Map<String,String> params,String url,int port){
		//设置返回结果
		String result = "";
		//参数不为空
		if(params != null){
			//设置参数信息
			params.put("Content-Type", "application/json;charset=UTF-8");
			//打印日志
			logger.info("GET MOTHED URL :" +url +",port"+port);
			logger.info("GET MOTHED PARAMS :" + params);
			StringBuffer sb = new StringBuffer();
			//声明参数
			String paramsString = "";
			try {
				HttpClient httpClient = new HttpClient();
				//设置访问参数格式get
				for(Map.Entry<String, String> entry : params.entrySet()){
					sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
				}
				paramsString = sb.toString();
				//打印参数
				logger.info("params:"+paramsString);
				//设置host url 和端口号
				httpClient.getHostConfiguration().setHost(url, port);      
				//设置 encode utf-8
				httpClient.getParams().setContentCharset("UTF-8");
				//新建 get Method
				HttpMethod method  = new GetMethod(url+"?"+paramsString);  
				//连接
				method.releaseConnection();
				//执行返回
				httpClient.executeMethod(method);
				//返回json
				result = method.getResponseBodyAsString();
			} catch (Exception e) {
				//记录异常信息
				logger.info("getActionInfoMothedGet has error"+url);
			}  
		}else{
			//参数为空
			result = "{\"resultFlag\":false,\"failureReason\":\"参数为空!\"}";
		}
		logger.info("GET MOTHED END");
		// 返回结果
		return result;
	}
	
	
	//getter
	public int getDefaultPort() {
		return defaultPort;
	}

	//setter
	public void setDefaultPort(int defaultPort) {
		this.defaultPort = defaultPort;
	}

	//getter
	public String getDefaultUrl() {
		return defaultUrl;
	}
	
	//setter
	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}

	
	//setter
	public void setEsbCode(String esbCode) {
		this.esbCode = esbCode;
	}

	//getter
	public void setRadius(String radius) {
		this.radius = radius;
	}
	
	

}
