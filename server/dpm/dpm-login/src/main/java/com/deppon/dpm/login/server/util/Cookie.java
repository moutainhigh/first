/*******************************************************************************
 * Copyright 2013 BSE TEAM
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * PROJECT NAME	: bse-baseinfo-api
 * 
 * FILE PATH        	: src/main/java/com/deppon/foss/module/frameworkimpl/shared/domain/Cookie.java
 * 
 * FILE NAME        	: Cookie.java
 * 
 * AUTHOR			: FOSS综合管理开发组
 * 
 * HOME PAGE		:  http://www.deppon.com
 * 
 * COPYRIGHT		: Copyright (c) 2013  Deppon All Rights Reserved.
 ******************************************************************************/
package com.deppon.dpm.login.server.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.deppon.foss.framework.cache.CacheManager;
import com.deppon.foss.framework.cache.ICache;
import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.exception.security.UserNotLoginException;
import com.deppon.foss.framework.server.Definitions;
import com.deppon.foss.framework.server.context.SessionContext;
import com.deppon.foss.framework.server.context.UserContext;
import com.deppon.foss.framework.server.sso.SSOConstant;

/**
 * Cookie管理类
 * ClassName: Cookie <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:22:04 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public final class Cookie {
	// 私有化构造函数
	private Cookie() {
	}
	// 类加载的时候创建Cookie对象
	private static Cookie cookie = new Cookie();
	// 对外提供获取Cookie的方法（单例）
	public static Cookie getInstance() {
		return cookie;
	}

	/**
	 * 获取Token字符串
	 * 
	 * Date:2014-8-19上午10:23:08
	 * @author 157229-zxy
	 * @return
	 * @since JDK 1.6
	 */
	public static String getTokenParam() {
		// session中获取用户userId
		String userId = (String) SessionContext.getSession().getObject(
				Definitions.KEY_USER);
		// session中获取empCode
		String empCode = (String) SessionContext.getSession().getObject(
				"FRAMEWORK_KEY_EMPCODE");
		// session中获取currentDeptCode
		String currentDeptCode = (String) SessionContext.getSession()
				.getObject("FOSS_KEY_CURRENT_DEPTCODE");
		// session中获取currentDeptName
		String currentDeptName = (String) SessionContext.getSession()
				.getObject("FOSS_KEY_CURRENT_DEPTNAME");
		// 封装到实体
		Token token = new Token(SessionContext.getSession().getId(), userId,
				empCode, currentDeptCode,currentDeptName, SessionContext.getSession()
						.getMaxInactiveInterval());
		// 返回
		return TokenMarshal.marshal(token);
	}

	/**
	 * 保存cookie 主要功能： 1.根据session重新生成cookie 2.修改cookie的时间戳
	 * 
	 * Date:2014-8-19上午10:23:18
	 * @author 157229-zxy
	 * @since JDK 1.6
	 */
	public static void saveCookie() {
		HttpServletResponse response = ServletActionContext.getResponse();

		String tokenParam = getTokenParam();
		try {
			tokenParam = URLEncoder.encode(tokenParam, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		javax.servlet.http.Cookie cook = getCookie();
		if (cook != null) {
			// 修改cookie时间戳
			cook.setValue(tokenParam);
		} else {
			// 重新new一个Cookie
			cook = new javax.servlet.http.Cookie(SSOConstant.TOKEN_NAME,
					tokenParam);
		}
		cook.setPath("/");// 同一个域名所有url cookie共享
		// cookie.setMaxAge(5*60);不写入磁盘，只写入内存，只有在当前页面有用,浏览器关闭立即失效
		response.addCookie(cook);
	}

	/**
	 * 失效Cookie
	 * 
	 */
	public static void invalidateCookie() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 失效掉token的cookie
		javax.servlet.http.Cookie cookieToken = getCookie();
		if (cookieToken != null) {
			cookieToken.setMaxAge(0);// 设置为0立即删除
			response.addCookie(cookieToken);
		}
		javax.servlet.http.Cookie cookieJsession = getCookie(SSOConstant.JSESSIONID);
		if (cookieJsession != null) {
			cookieJsession.setMaxAge(0);// 设置为0立即删除
			response.addCookie(cookieJsession);
		}
	}

	/**
	 * 获取HttpCookie对象,token对应的cookie
	 * 
	 */
	public static javax.servlet.http.Cookie getCookie() {
		return getCookie(SSOConstant.TOKEN_NAME);
	}

	/**
	 * 获取HttpCookie对象,根据传入的cookie的name值获取, 参数可以通过
	 * {@link com.deppon.foss.framework.server.sso.SSOConstant}获取
	 * 
	 * @param name
	 * @return
	 * @see
	 */
	public static javax.servlet.http.Cookie getCookie(String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (name.equals(cookies[i].getName())) {
					return cookies[i];
				}
			}
		}
		return null;
	}

	/**
	 * Cookie数据到Session 主要功能： 1.Cookie不存在，Throw UserNotLoginException异常
	 * 2.Cookie存在，赋值到Session
	 * 
	 * @see
	 */
	public static void cookieToSession() {
		javax.servlet.http.Cookie cook = getCookie();
		if (cook != null) {
			String paramToken = cook.getValue();
			if (StringUtils.isBlank(paramToken)) {
				throw new UserNotLoginException();// 用户未登录
			} else {
				Token token = TokenMarshal.unMarshalToken(paramToken);
				if (token != null && !token.expired()) {
					Cookie.getInstance().tokenToSession(token);
				} else {
					throw new UserNotLoginException();// 用户未登录
				}
			}
		} else {
			throw new UserNotLoginException();// 用户未登录
		}
	}

	/**
	 * token的内容复制到session中
	 * 
	 * @param token
	 * @see
	 */
	@SuppressWarnings("unchecked")
	private void tokenToSession(Token token) {
		SessionContext.getSession().setObject("FRAMEWORK_KEY_EMPCODE",
				token.getEmpCode());
		SessionContext.getSession().setObject(Definitions.KEY_USER,
				token.getUserId());
		SessionContext.getSession().setObject("FOSS_KEY_CURRENT_DEPTCODE",
				token.getCurrentDeptCode());
		SessionContext.getSession().setObject("FOSS_KEY_CURRENT_DEPTNAME",
				token.getCurrentDeptName());
		ICache<String, IUser> userCache = CacheManager.getInstance().getCache(
				IUser.class.getName());
		UserContext.setCurrentUser(userCache.get(token.getUserId()));
	}

}
