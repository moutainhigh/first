package com.deppon.dpm.module.wfs.server.service.impl;

import org.apache.commons.lang3.StringUtils;

import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.wfs.server.service.IWfsInterceptService;
import com.deppon.dpm.module.wfs.util.Constants;

public class WfsInterceptService implements IWfsInterceptService{

	private RedisService loginRedisService;
	
	/**
	 * 工作流拦截器开关
	 * @param wfstatus
	 */
	public void updateWfsSwitch(String wfstatus){
		
		if(StringUtils.isNotBlank(wfstatus)){
			loginRedisService.set("wfsintercept", wfstatus , Constants.WORKFLOW_STATUS);
		}	
	}

	public RedisService getLoginRedisService() {
		return loginRedisService;
	}

	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}

}
