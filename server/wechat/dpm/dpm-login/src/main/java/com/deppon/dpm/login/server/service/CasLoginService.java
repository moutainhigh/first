package com.deppon.dpm.login.server.service;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.login.server.domain.CasUserEntity;
import com.deppon.dpm.module.common.server.util.IHttpClient;
import com.deppon.dpm.module.common.server.util.NetUtil;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.web.message.IMessageBundle;

/**
 * 登陆服务.
 * 
 * @author 130126
 * 
 */
public class CasLoginService implements ICasLoginService {
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(CasLoginService.class);
	/**
	 * casURl
	 */
	private String casUrl;
	/**
	 * 主页面地址
	 */
	private String mainPageUrl;
	/**
	 * cas登录地址
	 */
	private String casLoginUrl;
	/**
	 * 角色权限地址
	 */
	private String roleUrl;
	@Resource
	protected IMessageBundle messageBundle;

	/**
	 * 移动门户单点登录
	 */
	public String doSSOLogin(Map<String, Object> validInfo, String userId,
			String password) throws Exception {
		// cas请求地址
		String casaction = null;
		// cookie
		String cookie = null;
		// sessionId
		String sessionId = null;
		// 用以参数拼接
		StringBuilder param = new StringBuilder("_eventId=submit");
		// 获取casUrl
		String action = casUrl;
		// 工号存入
		validInfo.put("username", userId);
		// 密码存入
		validInfo.put("password", password);
		// // 传入的信息进行遍历
		// Collection<String> keyset = validInfo.keySet();
		// // 迭代遍历
		// for (Iterator<String> iter = keyset.iterator(); iter.hasNext();) {
		// // key
		// String argName = iter.next();
		// // value
		// String argValue = (String) validInfo.get(argName);
		// // key = casaction
		// if (argName.equals("casaction")) {
		// // 值拼接
		// casaction = argValue;
		// // key = cookie
		// } else if (argName.equals("cookie")) {
		// // 值拼接
		// cookie = argValue;
		// // key = sessionId
		// } else if (argName.equals("sessionId")) {
		// // 值拼接
		// sessionId = argValue;
		// } else {
		// // 其余直接拼接
		// param.append("&");
		// param.append(argName);
		// param.append("=");
		// param.append(URLEncoder.encode(argValue, "utf8"));
		// }
		// }
		// 传入的信息进行遍历
		Collection<Map.Entry<String, Object>> entrySet = validInfo.entrySet();
		// 迭代遍历
		for (Map.Entry<String, Object> entry : entrySet) {
			// key
			String argName = entry.getKey();
			// value
			String argValue = (String) entry.getValue();
			// key = casaction
			if (argName.equals("casaction")) {
				// 值拼接
				casaction = argValue;
				// key = cookie
			} else if (argName.equals("cookie")) {
				// 值拼接
				cookie = argValue;
				// key = sessionId
			} else if (argName.equals("sessionId")) {
				// 值拼接
				sessionId = argValue;
			} else {
				// 其余直接拼接
				param.append("&");
				param.append(argName);
				param.append("=");
				param.append(URLEncoder.encode(argValue, "utf8"));
			}
		}
		// 最终的url
		action = action + casaction + "?"
				+ URLEncoder.encode("service=" + mainPageUrl, "utf8");
		// 得到HTTP客户端对象 完成所有HTTP请求的工作
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		// 设置请求url
		httpClient.setRequestURL(action);
		// 设置cookie
		httpClient.setCookie(cookie);
		// 提示登陆信息
		logger.info("Do first login[user=" + userId + "][action=" + action
				+ "]");
		// 起始时间
		long startTime = System.currentTimeMillis();
		// 发送请求
		httpClient.send(param.toString(), "utf-8");
		// 结束时间
		long endTime = System.currentTimeMillis();
		// 日志
		logger.info("["+userId+"]cas正式登录用时>>>>>>" + (endTime - startTime));
		// 获取相应的cookie
		String cookei = httpClient.fetchCookie();
		// 如果不为空
		if (cookei != null && !"".equals(cookei.trim())) {
			// 打印log信息
			logger.info("[CAS][do first login][Response cookie:" + cookei
					+ "][username:" + userId + "][sessionId:" + sessionId + "]");
			// 返回cookei
			return cookei;
		}
		// cookie为空，登录失败,打印log
		logger.info("[PORTAL][Login failure!][username:" + userId
				+ "]sessionId:" + sessionId + "]");
		// 跳出
		return null;
	}

	/**
	 * 得到CAS登录所需的验证信息、SESSION ID. 伪造一下url进行登录
	 */
	public void fetchCASValidInfo(Map<String, Object> validInfo,String userId)
			throws Exception {
		// 得到HTTP客户端对象 完成所有HTTP请求的工作
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		// 请求地址
		httpClient.setRequestURL(casLoginUrl);
		// 请求起始时间
		long startTime = System.currentTimeMillis();
		// 伪造登录
		httpClient.send("");
		// 请求结束时间
		long endTime = System.currentTimeMillis();
		// 日志
		logger.info("["+userId+"]cas伪登录用时>>>>>>" + (endTime - startTime));
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
		action = action.replace("\"", "");
		lt = lt.replaceFirst("<input type=\"hidden\" name=\"lt\" value=\"", "");
		lt = lt.replace("\" />", "");
		// 获取cookie
		String cookie = httpClient.fetchCookie();
		// 获取sessionId
		String sessionId = action.replaceFirst("/cas/login;jsessionid=", "");
		// 拼接信息
		validInfo.put("casaction", action);
		validInfo.put("lt", lt);
		validInfo.put("cookie", cookie);
		validInfo.put("sessionId", sessionId);
	}

	@Override
	public CasUserEntity login(String userId, String pass) {
		// 返回值
		CasUserEntity casUserEntity = null;
		try {
			// 参数
			Map<String, Object> validInfo = new HashMap<String, Object>();
			// 先伪造url进行登录
			fetchCASValidInfo(validInfo,userId);
			// 进行用户名密码的登陆.单点登陆.
			String result = doSSOLogin(validInfo, userId, pass);
			// log
			logger.info("单点登陆：工号" + userId + " 返回结果" + result);
			// 如果为空就返回密码失败
			if (result == null || "".equals(result.trim())) {
				// log
				logger.error(messageBundle.getMessage("foss.login.noUserCode"));
				// throw exception
				throw new BusinessException(
						messageBundle.getMessage("foss.login.noUserCode"));
			} else {
				// new实体
				casUserEntity = new CasUserEntity();
				// 获取的cookie
				String cookie = result;
				// 获取的sessionId
				String casSessionId = (String) validInfo.get("sessionId");
//				// 获取的角色权限
//				String roles = getRole(userId + "", "DPM");
//				// json --> object
//				casUserEntity = JSON.parseObject(roles, CasUserEntity.class);
				// 设置cook
				String cook = null;
				// 不为空
				if (StringUtils.isNotBlank(cookie)) {
					// 分隔
					String[] strs = cookie.split(";");
					// 获取最近一个
					cook = strs[0];
				}
				// cookie设置
				casUserEntity.setCookie(cook);
				// sessionId设置
				casUserEntity.setCasSessionId(casSessionId);
				/**
				 * 添加登录验证校验信息
				 */
//				DpmCacheManager.setCookieAndSession(userId,
//						new LoginCheckBean(casSessionId, cook));
			}
			// 返回实体
			return casUserEntity;
		} catch (BusinessException be) {
			// log
			logger.info(be.getMessage());
			// 抛异常
			throw be;
		} catch (Exception e) {
			// log
			logger.info(e.getMessage());
			// log
			logger.error(messageBundle.getMessage("foss.login.loginError"), e);
			// 抛异常
			throw new BusinessException("-2",
					messageBundle.getMessage("foss.login.loginError"));
		}
	}
	
//	public String getRole(String userId, String appId) {
//		// 定义返回字段
//		String str = null;
//		try {
//			// logger
//			logger.info("[请求角色链接]---" + roleUrl + "?appID=" + appId
//					+ "&userCode=" + userId);
//			// 起始时间
//			long startTime = System.currentTimeMillis();
//			// 获取角色权限
//			str = LoginUtil
//					.getInstance()
//					.getUrl(roleUrl + "?appID=" + appId + "&userCode=" + userId,
//							"utf8");
//			// 结束时间
//			long endTime = System.currentTimeMillis();
//			// 日志
//			logger.info("登录获取cas实体调用uums获取角色信息用时>>>>>>" + (endTime - startTime));
//			// logger
//			logger.info("[返回角色信息]==>" + str);
//		} catch (Exception e) {
//			// 打印
//			e.printStackTrace();
//		}
//		// 返回字段
//		return str;
//	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCasUrl() {
		return casUrl;
	}

	/**
	 * set
	 * 
	 * @param casUrl
	 */
	public void setCasUrl(String casUrl) {
		this.casUrl = casUrl;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMainPageUrl() {
		return mainPageUrl;
	}

	/**
	 * set
	 * 
	 * @param mainPageUrl
	 */
	public void setMainPageUrl(String mainPageUrl) {
		this.mainPageUrl = mainPageUrl;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCasLoginUrl() {
		return casLoginUrl;
	}

	/**
	 * set
	 * 
	 * @param casLoginUrl
	 */
	public void setCasLoginUrl(String casLoginUrl) {
		this.casLoginUrl = casLoginUrl;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRoleUrl() {
		return roleUrl;
	}

	/**
	 * set
	 * 
	 * @param roleUrl
	 */
	public void setRoleUrl(String roleUrl) {
		this.roleUrl = roleUrl;
	}

}
