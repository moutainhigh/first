package com.deppon.dpm.module.login.test.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.junit.Test;

import com.deppon.dpm.module.common.server.util.IHttpClient;
import com.deppon.dpm.module.common.server.util.NetUtil;

public class NetUtilTest extends TestCase {

	@Test
	public void test() throws Exception {
		/*
		 * // 获取casUrl String action = "http://192.168.20.27:8000"; String param
		 * = "_eventId=submit";
		 * 
		 * // 得到HTTP客户端对象 完成所有HTTP请求的工作 IHttpClient httpClient =
		 * NetUtil.fetchHttpClient(); // 设置请求url
		 * httpClient.setRequestURL(action); // 设置cookie
		 * httpClient.setCookie(""); // 发送请求 httpClient.send(param, "utf-8"); //
		 * 获取相应的cookie String cookei = httpClient.fetchCookie(); // 如果不为空 if
		 * (cookei != null && !"".equals(cookei.trim())) { // 返回cookei
		 * System.out.println(cookei); }
		 */
		String cas_login_url = "http://192.168.20.27:8000/cas/login";
		// 得到HTTP客户端对象 完成所有HTTP请求的工作
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		// 请求地址
		httpClient.setRequestURL(cas_login_url);
		// 伪造登录
		httpClient.send("");
		// 获取输出流
		if (httpClient.getOutputStream() == null) {
			// 为null直接抛出异常
			throw new Exception("fetchCASValidInfo no OutputStream");
		}
		// 获取返回信息
		String result = httpClient.getOutputStream().toString("UTF-8");
		// 匹配规则
		Pattern pattern = Pattern
				.compile("<input type=\"hidden\" name=\"lt\" value=\"[\\w\\W]{0,77}\" />");
		// 匹配内容
		Matcher matcher = pattern.matcher(result);
		// 查询
		matcher.find();
		// 获取匹配值
		String lt = matcher.group();
		// 匹配规则
		pattern = Pattern.compile("action=\"[^(\">)]{0,}(\"){1}");
		// 匹配内容
		matcher = pattern.matcher(result);
		// 查询
		matcher.find();
		// 获取匹配值
		String action = matcher.group();
		// 替换
		action = action.replaceFirst("action=\\\"", "");
		// 替换
		action = action.replace("\"", "");
		// 替换
		lt = lt.replaceFirst("<input type=\"hidden\" name=\"lt\" value=\"", "");
		// 替换
		lt = lt.replace("\" />", "");
		// 获取cookie
		String cookie = httpClient.fetchCookie();
		// 获取sessionId
		String sessionId = action.replaceFirst("/cas/login;jsessionid=", "");
		
		httpClient.getLocation();
		httpClient.isReDirect();
		httpClient.setMethod("");
		httpClient.addHead("aaa", "bbb");
	}

}
