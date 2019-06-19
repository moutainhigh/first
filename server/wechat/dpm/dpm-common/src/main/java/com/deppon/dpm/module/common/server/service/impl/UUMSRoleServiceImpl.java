package com.deppon.dpm.module.common.server.service.impl;
import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.service.IUUMSRoleService;
import com.deppon.dpm.module.common.server.util.IHttpClient;
import com.deppon.dpm.module.common.server.util.NetUtil;

public class UUMSRoleServiceImpl implements IUUMSRoleService{
	// 日志
	private static Logger logger = Logger.getLogger(UUMSRoleServiceImpl.class);
	
	// 请求角色url
	private String roleUrl;

	/**
	 * 获取用户角色信息
	 */
	public String getRoles(String userId) {
		// 返回的结果
		String result = "{}";
		try {
			// HttpClient
			IHttpClient httpClient = NetUtil.fetchHttpClient();
			// 请求地址
			httpClient.setRequestURL(roleUrl + "?appID=" + "DPM" + "&userCode=" + userId);
			// 请求
			httpClient.send("");
			// 获取返回的结果
			result = httpClient.getOutputStream().toString("UTF-8");
		} catch (Exception e) {
			logger.error("["+userId+"]请求uums获取角色信息失败!!",e);
		}
		return result;
	}

	// setter
	public void setRoleUrl(String roleUrl) {
		this.roleUrl = roleUrl;
	}
}
