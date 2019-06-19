package com.deppon.dpm.tongxunlu.test.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.server.service.IJPushRegistBindService;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;

public class JPuchRegistBindServiceTest extends BaseTestCase {

	@Autowired
	private IJPushRegistBindService jPushRegistBindService;
	
	@Test
	public void saveLogoutInfo(){
		Map<String,String> param = new HashMap<String,String>();
		param.put("userId", "908761");
		param.put("registId", "fasfdfadgwqrgsdfge1234sgsgfg");
		jPushRegistBindService.saveLogoutInfo(param);
	}
}
