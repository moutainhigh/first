package com.deppon.dpm.tongxunlu.server.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.deppon.ar.bamp.client.interceptor.struts2.RequestErrorInterceptor;

/**
 * 工号拦截器，用以判断是否登陆
 * 
 * @date 2015-09-24
 * @author 231586
 * 
 */

public class MyInterceptor extends RequestErrorInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String getEmpCode() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取工号信息
		return request.getParameter("userId");
	}
}