package com.deppon.bamp.module.log.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * @title: HttpRequestUtil 
 * @description: 获取http请求信息的工具类
 * @author: wuyaqing
 * @date:  2014-4-23 上午8:48:44
 */
public class HttpRequestUtil {

	/**
	 * @MethodName: getParamters 
	 * @description: 获取request请求里面的参数
	 * @author: wuyaqing 
	 * @date: 2014-4-23 上午8:50:07
	 * @param request
	 * @return String
	 */
	public static String getParamters(HttpServletRequest request) {
		//获取request请求参数
	    Enumeration paramNames = request.getParameterNames();
	    StringBuilder sb = new StringBuilder();
	    sb.append("ParameterMap:[");
	    //循环取出request请求参数
	    while (paramNames.hasMoreElements()) {
	    	String paramName = (String)paramNames.nextElement();
	        sb.append(paramName);
	        sb.append("=");
	        String value = request.getParameter(paramName);
	        sb.append(value);
	        sb.append(paramNames.hasMoreElements() ? "," : "");
	    }
	    sb.append("]");
	    return sb.toString();
	}
	
	/**
	 * @MethodName: getHeaderInfo 
	 * @description: 获取request请求里面的头信息
	 * @author: wuyaqing 
	 * @date: 2014-4-23 上午8:54:34
	 * @param request
	 * @return String
	 */
	public static String getHeaderInfo(HttpServletRequest request) {
		Enumeration headerNames = request.getHeaderNames();
	    StringBuilder sb = new StringBuilder();
	    sb.append("header:[");
	    while (headerNames.hasMoreElements()) {
	        Object headerName = headerNames.nextElement();
	        sb.append(headerName).append("=").append(request.getHeader(new StringBuilder().append(headerName).append("").toString())).append(", ");
	    }
	    sb.append("]");
	    return sb.toString();
	  }
	
	/**
	 * @MethodName: getRequestInfo 
	 * @description: 获取request请求里面的其他信息
	 * @author: wuyaqing 
	 * @date: 2014-4-23 上午8:55:46
	 * @param request
	 * @return String
	 */
	public static String getRequestInfo(HttpServletRequest request) {
	    StringBuilder requestDetail = new StringBuilder().append(getHeaderInfo(request));
	    return requestDetail.toString();
	}
}
