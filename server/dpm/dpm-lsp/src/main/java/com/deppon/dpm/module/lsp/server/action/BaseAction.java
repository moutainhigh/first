package com.deppon.dpm.module.lsp.server.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.lsp.shared.vo.Result;
import com.deppon.foss.framework.server.web.action.AbstractAction;

/**
 * 基础Action
 * @author 233357
 * @date 2015/03/19
 */
public class BaseAction extends AbstractAction{

	private static final long serialVersionUID = -2045839747474786332L;
	
	// 用户ID
	public String userId;
	// 用户Token
	public String token;
 
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 返回ajax到前台.
	 * 
	 * @param response
	 * @param result
	 */
	protected void writeToPage(HttpServletResponse response, String result) {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回ajax到前台.
	 * 
	 * @param response
	 * @param result
	 */
	protected void writeToPage(HttpServletResponse response, Result result) {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(JSON.toJSONString(result));
			//System.out.println(JSON.toJSONString(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
