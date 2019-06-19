package com.deppon.dpm.doc.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 调用http工具类
 * 
 * @author guzf
 * @since 2017-11-15
 */
public class HttpClientUtil {

	static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * post
	 * 
	 * @param url
	 * @param arg
	 * @return
	 * @throws IOException 
	 */
	public static String httpPost(String url, String arg) throws IOException {
		StringBuilder result = new StringBuilder();
		//
		logger.info("开始调用接口处理"+url);
		logger.info("开始调用接口处理参数"+arg);
		URL targetUrl = new URL(url);
		HttpURLConnection httpConnection = (HttpURLConnection) targetUrl
				.openConnection();
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		httpConnection.setDoOutput(true);
		httpConnection.setDoInput(true);
		OutputStream outputStream = httpConnection.getOutputStream();
		outputStream.write(arg.getBytes("UTF-8"));// 因客户端浏览器以UTF-8的编码显示数据，固使用OutputStream流向客户端浏览器输出中文，以UTF-8的编码进行输出
		outputStream.flush();
		logger.debug(url + "开始处理获取输入流");
		// ---取得输入流，并使用Reader读取 ，设置编码utf-8,否则中文乱码
		BufferedReader responseBuffer = new BufferedReader(
				new InputStreamReader((httpConnection.getInputStream()),
						"utf-8"));
		String output;
		while ((output = responseBuffer.readLine()) != null) {
			result.append(output);
		}
		logger.info("调用接口处理完毕返回参数"+result.toString());
		return result.toString();
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			String urlNameString = url + "?" + param;
			logger.info("开始调用接口处理url"+urlNameString);
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			// 建立实际的连接
			connection.connect();
			logger.info(url + "开始处理获取输入流");
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			logger.info("发送GET请求出现异常！" + e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		logger.info("开始调用接口处理返回参数："+result.toString());
		return result.toString();
	}
}
