package com.deppon.montal.util;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class RestfulUtil {
	private static final Log logger = LogFactory.getLog(RestfulUtil.class);
	/**
	 * @Fields client : httpClient
	 */
//	private static WebClient client;
	/**
	 * 
	* @MethodName: createClient 
	* @description : 创建restful客户端
	* @author：caibingbing 
	* @date： 2014-8-13 下午2:04:56
	* @param ws_link
	* @return WebClient
	 */
	public static final WebClient createClient(String ws_link){
		WebClient client = null;
		String uri = InitDataServlet.getValue(ws_link);
		logger.info("接口地址:"+uri);
		client = WebClient.create(uri);
		logger.info("接口创建客户端：" + client);
		client.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		return client;
	}
	/**
	 * 
	* @MethodName: invoke 
	* @description : TODO
	* @author：caibingbing 
	* @date： 2014-8-13 下午2:05:18
	* @param ws_link
	* @param obj
	* @param cls
	* @return Object
	 */
	public static final Object invoke(String ws_link,Object obj,Class<?> cls){
		WebClient client = createClient(ws_link);
		try {
			String json = JacksonTransformer.java2String(obj);
			logger.info("调用接口json参数:"+ json);
			Response response = client.post(json);
			String message = IOUtils.toString((InputStream) response.getEntity());
			logger.info("接口返回参数结果集:"+ message);
			if(message != "" && message != null && message.indexOf("exceptionType") == -1){
				return JacksonTransformer.string2java(message, cls);
			}else{
				//接口返回   异常情况
				logger.error("接口调用异常："+message);
			}
			return null;
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
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
	public static String querylmsInfo(String ws_link,Object obj){
		String json = null;
		WebClient client = createClient(ws_link);
		try {
			json = JacksonTransformer.java2String(obj);
			logger.info("调用接口json参数:"+ json);
			Response response = client.post(json);
			String message = IOUtils.toString((InputStream) response.getEntity());
			logger.info("接口返回参数结果集:"+ message);
			return message;
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage(),e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
}
