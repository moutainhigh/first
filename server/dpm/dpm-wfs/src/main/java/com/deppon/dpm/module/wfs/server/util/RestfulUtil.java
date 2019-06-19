package com.deppon.dpm.module.wfs.server.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MySSLProtocolSocketFactory;
import com.deppon.dpm.module.wfs.util.Constants;

public class RestfulUtil {
	private static final Logger logger = LoggerFactory.getLogger(RestfulUtil.class);
	/**
	 * 
	* @MethodName: createClient 
	* @description : 创建restful客户端
	* @author：caibingbing 
	* @date： 2014-8-13 下午2:04:56
	* @param ws_link
	* @return WebClient
	 */
	public static final WebClient createClient(String wsLink){
		WebClient client = null;
//		String uri = ws_link;
		logger.info("接口地址:" + wsLink);
		client = WebClient.create(wsLink);
		logger.info("接口创建客户端：" + client);
		client.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		return client;
	}
	/**
	 * 
	* @MethodName: querylmsInfo 
	* @description : 调用lms接口--- restful方式
	* @author：caibingbing 
	* @date： 2014-8-13 下午2:05:53
	* @param ws_link
	* @param obj
	* @return String
	 */
	public static String querylmsInfo(String wsLink,Object obj){
		String json = null;
		WebClient client = createClient(wsLink);
		try {
			json = JsonUtil.beanToJsonString(obj);
			logger.info("调用接口json参数:" + json);
			Response response = client.post(json);
			String message = IOUtils.toString((InputStream) response.getEntity());
//			logger.info("接口返回参数结果集:" + message);
			return message;
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
	/**
	 * restful httpclient 公共方法
	 * @param uri 接口地址
	 * @param esbCode esb前端服务编码
	 * @param json json字符串
	 * @param syscode 系统编码
	 * @return
	 */
	public static String restfulWork(String uri, String esbCode, String json, String syscode) {
		String responseBody = null;
		try {
			HttpClient httpClient = new HttpClient();

			// 设置编码格式
			httpClient.getParams().setContentCharset("UTF-8");
			// 设置超时时间
			HttpConnectionManagerParams managerParams = httpClient
					.getHttpConnectionManager().getParams();
			int outTime = Constants.HTTP_CON_TIMEOUT;
			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(outTime);
			// 设置读数据超时时间(单位毫秒)
			int readTime = Constants.HTTP_READ_TIME;
			managerParams.setSoTimeout(readTime);
			Protocol myhttps = new Protocol("https",
					new MySSLProtocolSocketFactory(), Constants.HTTP_PROTOCOL);
			Protocol.registerProtocol("https", myhttps);
			// 构造PostMethod的实例
			PostMethod postMethod = new PostMethod(uri);

			Map<String, String> map = new HashMap<String, String>();
			map.put("version", "1.0");
			map.put("Content-Type", "application/json;charset=UTF-8");
			map.put("esbServiceCode", esbCode);
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "DPM");

			logger.info(syscode + " request param is :" + json);
			RequestEntity entity = new StringRequestEntity(json,
					"application/json", "UTF-8");
			postMethod.setRequestEntity(entity);
			postMethod.addRequestHeader("Content-Type",
					"application/json;charset=UTF-8");
			postMethod.addRequestHeader("requestHeaders",
					JsonUtil.mapToJsonString(map));
			// 执行postMethod
			httpClient.executeMethod(postMethod);
			responseBody = postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			responseBody=e.getMessage();
			e.printStackTrace();
		}
		logger.info(syscode + " response return is:" + responseBody);
		return responseBody;
	}
}
