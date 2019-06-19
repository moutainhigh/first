package com.deppon.dpm.module.common.server.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * Servlet的相关的工具类
 */
public class ServletUtil {
	
	//获取request
	public static HttpServletRequest getRequest(){
		// 返回
		return ServletActionContext.getRequest();
	}
	
	//获取response
	public static HttpServletResponse getResponse(){
		// 返回
		return ServletActionContext.getResponse();
	}
	
	//获取session
	public static  HttpSession getSession(){
		// 返回
		return getRequest().getSession();
	}
	
	//存入session
//	public static void setAttrToSession(String key,Object value){
//		// 返回
//		getSession().setAttribute(key, value);
//	}

	//获取session中的值
	public static Object getAttrFromSession(String key){
		// 返回
		return getSession().getAttribute(key);
	}
}
