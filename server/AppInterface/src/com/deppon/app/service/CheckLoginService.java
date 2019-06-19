package com.deppon.app.service;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import base.util.PropertiesTools;
import base.util.StringUtils;

import com.deppon.app.util.IHttpClient;
import com.deppon.app.util.NetUtil;

/**
 * 登陆验证服务.
 * 
 * @ClassName: CheckLoginService
 * @Description: TODO
 * @date 2014-3-19 下午02:02:20
 * 
 */
@Service
public class CheckLoginService {
	private static Logger logger = Logger.getLogger(CheckLoginService.class);

	private static final String casLoginUrl = PropertiesTools
			.getConfigProperties("cas_login_url");
	private static final String casUrl = PropertiesTools
			.getConfigProperties("cas_url");

	/**
	 * 移动门户单点登录
	 * 
	 * @param validInfo
	 * @return ticket
	 */
	public String doSSOLogon(Map validInfo, String userId) throws Exception {
		String casaction = null;
		String cookie = null;
		String sessionId = null;
		String param = "_eventId=submit";
		// 集合.
		Collection keyset = validInfo.keySet();
		// 循环集合.
		for (Iterator iter = keyset.iterator(); iter.hasNext();) {
			// 参数名
			String argName = (String) iter.next();
			// 参数值
			String argValue = (String) validInfo.get(argName);
			// 判断是否等于casaction
			if (argName.equals("casaction")) {
				casaction = argValue;
			}
			// 判断是否等于kuki
			else if (argName.equals("cookie")) {
				cookie = argValue;
			}
			// 取会话
			else if (argName.equals("sessionId")) {
				sessionId = argValue;
			}
			// 拼接其他参数.
			else {
				param += "&" + argName + "="
						+ URLEncoder.encode(argValue, "utf8");
			}
		}
		// 得到链接.
		String action = casUrl + casaction + "?";// +
													// URLEncoder.encode("service="+InitDataServlet.prop.getProperty("main_page_url"),
													// "utf8");

		// 请求构造函数
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		// 设置url
		httpClient.setRequestURL(action);
		// 设置kuki
		httpClient.setCookie(cookie);
		// 日志
		logger.info("Do first login[user=" + userId + "][action=" + action
				+ "]");
		httpClient.send(param, "utf-8");
		// 取会话
		String cookei = httpClient.fetchCookie();
		// 会话不空
		if (!StringUtils.isEmpty(cookei)) {
			// String location = httpClient.getLocation();
			logger.info("[CAS][do first login][Response cookie:" + cookei
					+ "][username:" + userId + "][sessionId:" + sessionId + "]");
			// location = location + "&cookie="+cookei;
			return cookei;
		}
		// 打印日志.
		logger.info("[PORTAL][Login failure!][username:" + userId
				+ "]sessionId:" + sessionId + "]");
		return null;
	}

	/**
	 * 得到CAS登录所需的验证信息、SESSION ID
	 * 
	 * @Title: fetchCASValidInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param validInfo
	 * @param @throws Exception
	 * @return void
	 * @throws
	 */
	public void fetchCASValidInfo(Map validInfo) throws Exception {
		//得到请求构造对象
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		httpClient.setRequestURL(casLoginUrl);
		httpClient.send("");
		//得到文件流
		if (httpClient.getOutputStream() == null) {
			throw new Exception("fetchCASValidInfo no OutputStream");
		}
		//取值
		String result = httpClient.getOutputStream().toString("UTF-8");
		//正则表达式
		Pattern pattern = Pattern
				.compile("<input type=\"hidden\" name=\"lt\" value=\"[\\w\\W]{0,77}\" />");
		Matcher matcher = pattern.matcher(result);
		matcher.find();
		//找到匹配的值
		String lt = matcher.group();
		//正则表达式
		pattern = Pattern.compile("action=\"[^(\">)]{0,}(\"){1}");
		matcher = pattern.matcher(result);
		//匹配正则表达式
		matcher.find();
		String action = matcher.group();
		// System.out.println("origin action=" + action);
		// action = action.replaceFirst("action", " name='casaction' value");
		action = action.replaceFirst("action=\\\"", "");
		action = action.replace("\"", "");
		// System.out.println("origin lt=" + lt);
		lt = lt.replaceFirst("<input type=\"hidden\" name=\"lt\" value=\"", "");
		lt = lt.replace("\" />", "");
		//得到kuki
		String cookie = httpClient.fetchCookie();
		//得到会话
		String sessionId = action.replaceFirst("/cas/login;jsessionid=", "");
		// System.out.println("origin sessionId=" + sessionId);
		//设置值.
		validInfo.put("casaction", action);
		validInfo.put("lt", lt);
		validInfo.put("cookie", cookie);
		validInfo.put("sessionId", sessionId);
	}
}
