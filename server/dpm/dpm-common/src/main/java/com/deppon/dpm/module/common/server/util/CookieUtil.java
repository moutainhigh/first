package com.deppon.dpm.module.common.server.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	
	private static final int MAXAGE = 0;
	
	//从Cookie中获取值
	public static String getValFromCookie(Cookie[] cookies,String name){
		//健壮判断
		if( null == cookies){
			return null;
		}
		//遍历
		for (Cookie cookie : cookies) {
			//如果cookie中含有登录令牌
			if(name.equals(cookie.getName())){
				//返回令牌
				return cookie.getValue();
			}
		}
		//返回
		return null;
	}
	
	//获取cookies
	public static Cookie[] getCookies(){
		return ServletUtil.getRequest().getCookies();
	}
	
	//清除Cookie
	public static void cleanCookie(Cookie[] cookies,String name){
		//健壮判断
		if( null == cookies){
			return;
		}
		//遍历
		for (Cookie cookie : cookies) {
			//如果cookie中含有该name
			if(name.equals(cookie.getName())){
				//删除该cookie
				cookie.setValue(null);
				cookie.setMaxAge(MAXAGE);
				cookie.setPath("/");
				ServletUtil.getResponse().addCookie(cookie);
				return;
			}
		}
	}
}
