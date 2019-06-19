package com.deppon.dpm.module.common.server.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.impl.MySSLProtocolSocketFactory;
import com.deppon.foss.framework.exception.BusinessException;

public class HttpUtil {
	/**
	 * logger
	 */
	private static final Logger logger = Logger.getLogger(HttpUtil.class);
	/**
	 * 连接超时时间(单位毫秒)
	 */
	private static int CONNECTIONTIMEOUT = MagicNumber.NUM60000;
	/**
	 * 读数据超时时间(单位毫秒)
	 */
	private static int SOTIMEOUT = MagicNumber.NUM30000;
	/**
	 * 返回成功的状态码 200
	 */
	private static final int OK = MagicNumber.NUM200;
	
	/**
	 * 连接超时时间(单位毫秒)
	 */
	private static int CONNECTIONTIMEOUT1 = MagicNumber.NUM30000;
	
	/**
	 * 读数据超时时间(单位毫秒)
	 */
	private static int SOTIMEOUT1 = MagicNumber.NUM30000;
	
	/**
	 * http 请求
	 * 
	 * @param json
	 * @param url
	 * @param esbServiceCode
	 * @return
	 * @throws IOException 
	 */
	public static String httpClient(JSONObject json, String url,
			String esbServiceCode) throws IOException {
		// 实例化httpClient
		HttpClient httpClient = new HttpClient();
		// 设置编码格式
		httpClient.getParams().setContentCharset("UTF-8");
		// 设置超时时间
		HttpConnectionManagerParams managerParams = httpClient
				.getHttpConnectionManager().getParams();
		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(CONNECTIONTIMEOUT);
		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(SOTIMEOUT);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(), MagicNumber.NUM443);
		Protocol.registerProtocol("https", myhttps);
		// 构造PostMethod的实例
		PostMethod postMethod = new PostMethod(url);
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "APP");
		RequestEntity entity = new StringRequestEntity(json.toString(),
				"application/json", "UTF-8");
		logger.info("传入的json参数:" + json.toString());
		postMethod.setRequestEntity(entity);
		postMethod.addRequestHeader("Content-Type",
				"application/json;charset=UTF-8");
		postMethod.addRequestHeader("requestHeaders",
				JSONObject.toJSONString(map));
		// 执行postMethod
		httpClient.executeMethod(postMethod);
		logger.info("http请求之后的结果集:" + postMethod.getResponseBodyAsString());
		return postMethod.getResponseBodyAsString();
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
				.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
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
	 * http post请求
	 * 
	 * @param url
	 * @param params
	 * @param encoding
	 * @return
	 * @throws IOException 
	 * @throws UnsupportedEncodingException
	 */
	public static final String postHttp(String url, String params,
			String encoding) throws IOException {
		// 返回信息定义
		String responseMsg = null;
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        // 设置参数
        RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
				.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
				.setSocketTimeout(MagicNumber.NUM30000) // 数据传输的最长时间
				.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
				.build();
        httpPost.setConfig(requestConfig);
        if (StringUtils.isNotEmpty(params)) {
            // 构造一个String的实体
            StringEntity stringEntity = new StringEntity(params,ContentType.APPLICATION_JSON);
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(stringEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            if (response.getEntity() != null) {
                //如果响应中有内容就设置到HttpResult，无需考虑状态码
            	responseMsg = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } finally {
        	// 释放资源
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
		// 返回请求值
		return responseMsg;
	}

	/**
	 * POST请求，提交表单数据
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws
	 * @throws IOException
	 */
	public static String doPost(String url, Map<String, Object> params)
			throws IOException {

		// 健壮性判断
		if (StringUtils.isBlank(url) || null == params || params.size() == 0) {
			return null;
		}

		// 返回的数据
		String content = null;

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建http POST请求
		HttpPost httpPost = new HttpPost(url);

		// 构建请求配置信息
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
				.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
				.setSocketTimeout(MagicNumber.NUM30000) // 数据传输的最长时间
				.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
				.build();

		httpPost.setConfig(config);

		// 设置post参数，
		List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
		for (Entry<String, Object> entry : params.entrySet()) {
			if (null == entry.getValue()) {
				// 忽略该参数
				continue;
			}
			parameters.add(new BasicNameValuePair(entry.getKey(), String
					.valueOf(entry.getValue())));
		}
		// 构造一个form表单式的实体
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,
				"UTF-8");
		// 将请求实体设置到httpPost对象中
		httpPost.setEntity(formEntity);

		CloseableHttpResponse response = null;
		try {
			// 执行请求
			response = httpclient.execute(httpPost);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == HttpUtil.OK) {
				content = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} finally {
			//释放资源
			if (response != null) {
				response.close();
			}
			httpclient.close();
		}
		return content;
	}
	/**
	 * POST请求，提交表单数据
	 * 
	 * @param url 请求的URL
	 * @param params 包含Header数据,即在params中加入key为Header的一个HashMap<String,String>对象
	 * @return content JSON格式的字符串
	 * @throws
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static String doPost2Header(String url, Map<String, Object> params)
			throws IOException {

		// 健壮性判断
		if (StringUtils.isBlank(url) || null == params || params.size() == 0) {
			return null;
		}

		// 返回的数据
		String content = null;

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建http POST请求
		HttpPost httpPost = new HttpPost(url);
		
		//设置Header数据
		Map<String,String> header = (Map<String, String>) params.get("Header");
		if(null != header && !header.isEmpty()){
			Iterator<Entry<String, String>> headerIter = header.entrySet().iterator();
			while(headerIter.hasNext()){
				Entry<String, String> e = headerIter.next();
				httpPost.setHeader(e.getKey(),e.getValue());
			}
		}

		// 构建请求配置信息
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
				.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
				.setSocketTimeout(MagicNumber.NUM30000) // 数据传输的最长时间
				.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
				.build();

		httpPost.setConfig(config);

		// 设置post参数，
		List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
		for (Entry<String, Object> entry : params.entrySet()) {
			if (null == entry.getValue()) {
				// 忽略该参数
				continue;
			}
			parameters.add(new BasicNameValuePair(entry.getKey(), String
					.valueOf(entry.getValue())));
		}
		// 构造一个form表单式的实体
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,
				"UTF-8");
		// 将请求实体设置到httpPost对象中
		httpPost.setEntity(formEntity);

		CloseableHttpResponse response = null;
		try {
			// 执行请求
			response = httpclient.execute(httpPost);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == HttpUtil.OK) {
				content = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} finally {
			//释放资源
			if (response != null) {
				response.close();
			}
			httpclient.close();
		}
		return content;
	}
	
	/**
     * post请求，接收json字符串
     * 
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String doPostJson(String url, String json) throws ClientProtocolException, IOException {
    	// 返回的数据
		String content = null;
		
    	// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        // 构建请求配置信息
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
				.setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
				.setSocketTimeout(MagicNumber.NUM30000) // 数据传输的最长时间
				.setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
				.build();
        httpPost.setConfig(config);
        if (StringUtils.isNotEmpty(json)) {
            // 构造一个String的实体
            StringEntity stringEntity = new StringEntity(json,ContentType.APPLICATION_JSON);
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(stringEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 如果响应响应状态吗为200，说明请求成功
            if (response.getStatusLine().getStatusCode() == MagicNumber.NUM200) {
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } finally {
        	// 释放资源
            if (response != null) {
                response.close();
            }
        }
        return content;
    }
	
	/**
	 * http 请求
	 * 
	 * @param json
	 * @param url
	 * @param esbServiceCode
	 * @return
	 * @throws Exception
	 */
	public static String httpClientPost(JSONObject json, String url,
			String esbServiceCode) throws IOException {
		// 实例化httpClient
		HttpClient httpClient = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true) );
		// 设置编码格式
		httpClient.getParams().setContentCharset("UTF-8");
		// 设置超时时间
		HttpConnectionManagerParams managerParams = httpClient
				.getHttpConnectionManager().getParams();
		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(CONNECTIONTIMEOUT1);
		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(SOTIMEOUT1);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(), MagicNumber.NUM443);
		Protocol.registerProtocol("https", myhttps);
		// 构造PostMethod的实例
		PostMethod postMethod = new PostMethod(url);
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "APP");
		RequestEntity entity = new StringRequestEntity(json.toString(),
				"application/json", "UTF-8");
		logger.info("传入的json参数:" + json.toString());
		postMethod.setRequestEntity(entity);
		postMethod.addRequestHeader("Content-Type",
				"application/json;charset=UTF-8");
		postMethod.addRequestHeader("requestHeaders",
				JSONObject.toJSONString(map));
		try {
			// 执行postMethod
			httpClient.executeMethod(postMethod);
			logger.info("http请求之后的结果集:" + postMethod.getResponseBodyAsString());
		}/* catch (Exception e) {
			logger.error("[httpClient]------请求出错,错误信息:"+e.getMessage());
		}	*/
		finally{
			postMethod.releaseConnection();
		}
		return postMethod.getResponseBodyAsString();
	}
	 private static HttpMethod getMethod(String url,String param) throws IOException{
		// 参数不为null
			if (param != null) {
				// 组装get请求url
				url = url + "?" + param;
			}
	        GetMethod get = new GetMethod(url);
	        get.releaseConnection();
	        return get;
	    }
	/**
	 * restful httpclient 公共方法
	 * @param uri 接口地址
	 * @param esbCode esb前端服务编码
	 * @param json json字符串
	 * @param syscode 系统编码
	 * @return
	 */
	 public static final int NUMBER_OF_443 = 443;

	 public static final int NUMBER_OF_50000 = 50000;

	 public static final int NUMBER_OF_60000 = 60000;

	public static String restfulWork(String url, String esbCode, String json, String syscode) {
		String responseBody = null;
		try {
			HttpClient httpClient = new HttpClient();
			 HttpMethod method = getMethod(url, json);

			// 设置编码格式
			httpClient.getParams().setContentCharset("UTF-8");
			// 设置超时时间
			HttpConnectionManagerParams managerParams = httpClient
					.getHttpConnectionManager().getParams();
			int outTime = NUMBER_OF_60000;
			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(outTime);
			// 设置读数据超时时间(单位毫秒)
			int readTime = NUMBER_OF_50000;
			managerParams.setSoTimeout(readTime);
			Protocol myhttps = new Protocol("https",
					new MySSLProtocolSocketFactory(), NUMBER_OF_443);
			Protocol.registerProtocol("https", myhttps);
			// 构造PostMethod的实例

			Map<String, String> map = new HashMap<String, String>();
			map.put("version", "1.0");
			map.put("Content-Type", "application/json;charset=UTF-8");
			map.put("esbServiceCode", esbCode);
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "DPM");

			logger.info(syscode + " request param is :" + json);
//			new StringRequestEntity(json,"application/json", "UTF-8");
			/*postMethod.setRequestEntity(entity);
			postMethod.addRequestHeader("Content-Type",
					"application/json;charset=UTF-8");
			postMethod.addRequestHeader("requestHeaders",
					JsonUtil.mapToJsonString(map));*/
			// 执行postMethod
			httpClient.executeMethod(method);
			responseBody = method.getResponseBodyAsString();
		} catch (Exception e) {
			responseBody=e.getMessage();
			e.printStackTrace();
		}
		logger.info(syscode + " response return is:" + responseBody);
		return responseBody;
	}
}
