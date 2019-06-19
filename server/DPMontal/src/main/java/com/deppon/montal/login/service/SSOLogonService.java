package com.deppon.montal.login.service;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.deppon.montal.login.action.SSOLogonAction;
import com.deppon.montal.util.IHttpClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.NetUtil;
import com.deppon.montal.util.StringUtil;

/**
 * 
 * @author lin.liu
 *
 */
public class SSOLogonService {
	private static Logger logger  = Logger.getLogger(SSOLogonService.class);
	public SSOLogonService() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 单点登录OA，为工作流审批创建用户信息
	 * 
	 * @param urlstr
	 * @param param
	 * @param cookies
	 * @return
	 */
	public String doClientLogin(String urlstr, String param, String cookies) {
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		httpClient.setRequestURL(urlstr);
		httpClient.setCookie(cookies);
		httpClient.send(param);
		String location = httpClient.getLocation();

		if (httpClient.isReDirect()) {
			logger.info("location="+location);
			return location;
		}
		return null;
	}
	
	/**
	 * 移动门户单点登录
	 * 
	 * @param validInfo
	 * @return ticket
	 */
	public String doSSOLogon(Map validInfo,String userId)throws Exception{
		String casaction=null;
		String cookie=null;
		String sessionId=null;
		String param = "_eventId=submit";
		String action = InitDataServlet.prop.getProperty("cas_url");
		Collection keyset = validInfo.keySet();
		for(Iterator iter = keyset.iterator(); iter.hasNext(); ){
			String argName = (String) iter.next();
			String argValue = (String) validInfo.get(argName);
			if (argName.equals("casaction") ) {
				casaction = argValue;
			}else if (argName.equals("cookie")) {
				cookie = argValue;
			}else if (argName.equals("sessionId")) {
				sessionId = argValue;
			}else{
				param += "&" + argName + "=" + URLEncoder.encode(argValue, "utf8");
			}
		}
		action = action + casaction + "?" + URLEncoder.encode("service="+InitDataServlet.prop.getProperty("main_page_url"), "utf8");
		
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		httpClient.setRequestURL(action);
		httpClient.setCookie(cookie);
		logger.info("Do first login[user="+userId+"][action="+action+"]");
		httpClient.send(param, "utf-8");

		String cookei = httpClient.fetchCookie();
		if (!StringUtil.isEmptyOrNull(cookei)) {
			//String location = httpClient.getLocation();
			logger.info("[CAS][do first login][Response cookie:" + cookei+ "][username:" + userId + "][sessionId:" + sessionId+ "]");
			//location = location + "&cookie="+cookei;
			return cookei;
		}
		
		logger.info("[PORTAL][Login failure!][username:" + userId + "]sessionId:" + sessionId+"]");
		return null;
	}
	
	/**
	 * 得到CAS登录所需的验证信息、SESSION ID
	 */
	public void fetchCASValidInfo(Map validInfo) throws Exception {
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		httpClient.setRequestURL(InitDataServlet.prop.getProperty("cas_login_url"));
		httpClient.send("");

		if (httpClient.getOutputStream() == null) {
			throw new Exception("fetchCASValidInfo no OutputStream");
		}

		String result = httpClient.getOutputStream().toString("UTF-8");

		Pattern pattern = Pattern.compile("<input type=\"hidden\" name=\"lt\" value=\"[\\w\\W]{0,77}\" />");
		Matcher matcher = pattern.matcher(result);
		matcher.find();
		String lt = matcher.group();

		pattern = Pattern.compile("action=\"[^(\">)]{0,}(\"){1}");
		matcher = pattern.matcher(result);
		matcher.find();
		String action = matcher.group();
		System.out.println("origin action="+action);
		//action = action.replaceFirst("action", " name='casaction' value");
		action = action.replaceFirst("action=\\\"", "");
		action = action.replace("\"", "");
		System.out.println("origin lt="+lt);
		lt = lt.replaceFirst("<input type=\"hidden\" name=\"lt\" value=\"", "");
		lt = lt.replace("\" />", "");
		
		String cookie = httpClient.fetchCookie();
		String sessionId = action.replaceFirst("/cas/login;jsessionid=", "");;
		System.out.println("origin sessionId="+sessionId);
		
		validInfo.put("casaction", action);
		validInfo.put("lt", lt);
		validInfo.put("cookie", cookie);
		validInfo.put("sessionId", sessionId);
	}
}
