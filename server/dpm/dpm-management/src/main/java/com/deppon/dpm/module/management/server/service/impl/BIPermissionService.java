package com.deppon.dpm.module.management.server.service.impl;


import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.management.server.service.IBIPermissionService;
import com.deppon.foss.framework.exception.BusinessException;

public class BIPermissionService implements IBIPermissionService {
	//BI权限控制
	private String biPermissionUrl;
	
	// 日志
	private static final Logger logger = Logger
			.getLogger(BIPermissionService.class);


	@Override
	public String hasBiPermission(String userId){
		try {			
			String params = "userCode=" + userId;
			String resultJson = HttpUtil.getHttp(biPermissionUrl, params, "utf-8");
			//json转对象
			JSONObject object = JSONObject.fromObject(resultJson);
			//获取值 
			String hasPermission = object.getString("hasPermission");
			//String isLock = object.getString("isLock");
			if (hasPermission.equals("true")) {
				String isLock = object.getString("isLock");
				if(isLock.equals("false")){
					logger.info("BI权限1---工号：" + userId + " 请求权限结果为：" + hasPermission  + "域名地址为：" + biPermissionUrl);
					return "true";
				}else{
					String result = object.getString("result");
					logger.info("BI权限1---工号：" + userId + " 请求权限结果为：" + hasPermission  + "islock为：" + isLock + "result为：" + result);
					return result;
				}
			}else {
				logger.info("BI权限2---工号：" + userId + " 请求权限结果为：" + hasPermission + "域名地址为：" + biPermissionUrl);
				return "false";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("BI权限4 ---工号：" + userId + "接口报错："+e + "域名地址为：" + biPermissionUrl);
			return "false";
		}
		
	}
	
	/**
	 * http get请求
	 * 
	 * @param url
	 * @param params
	 * @param encoding
	 * @return
	 */
	public static final String getHttp(String url, String params,
			String encoding) {
		// 返回信息定义
		String responseMsg = "";
		// 参数不为null
		if (params != null) {
			// 组装get请求url
			url = url + "?" + params;
		}
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建HttpGet请求
        HttpGet httpGet = new HttpGet(url);
        // 设置参数
        RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(MagicNumber.NUM5000) // 创建连接的最长时间
				.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
				.setSocketTimeout(MagicNumber.NUM30000) // 数据传输的最长时间
				.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
				.build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            //执行请求
            response = httpClient.execute(httpGet);
            if (response.getEntity() != null) {
                //如果响应中有内容就设置到HttpResult，无需考虑状态码
            	responseMsg = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
        	throw new BusinessException(e.getMessage());
		} finally {
        	// 释放资源
            if(response!=null){
                try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            try {
            	// 关闭连接
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		// 返回请求之后的信息
		return responseMsg;
	}

	/**
	 * get
	 * @return
	 */
	public String getBiPermissionUrl() {
		return biPermissionUrl;
	}
	/**
	 * set
	 * @param biPermissionUrl
	 */
	public void setBiPermissionUrl(String biPermissionUrl) {
		this.biPermissionUrl = biPermissionUrl;
	}

}
