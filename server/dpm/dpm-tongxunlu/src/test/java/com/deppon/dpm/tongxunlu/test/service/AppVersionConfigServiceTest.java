package com.deppon.dpm.tongxunlu.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.server.service.IAppVersionConfigService;
import com.deppon.dpm.tongxunlu.shared.domain.AppVersionConfigEntity;
import com.deppon.dpm.tongxunlu.test.BaseTestCase;

public class AppVersionConfigServiceTest extends BaseTestCase{
	
	@Autowired
	private IAppVersionConfigService appVersionConfigService;

	@Test
	public void testSeeVersion(){
		AppVersionConfigEntity seeVersion = appVersionConfigService.seeVersion("dpm", "android");
		if(null != seeVersion){
			String version = seeVersion.getVersion();
			String version1 = version;
			String version2 = version + ".1";
			String appName = "dpm";
			String osType = "android";
			String str1 = appVersionConfigService.seeVersion(null,null,"116250",version1, appName, osType);
			String str2 = appVersionConfigService.seeVersion(null,null,"116250",version2, appName, osType);
			System.out.println(str1);
			System.out.println(str2);
		}
	}
	
	@Test
	public void testSeeVersion2(){
		appVersionConfigService.seeVersion("dpm", "android");
	}
}
