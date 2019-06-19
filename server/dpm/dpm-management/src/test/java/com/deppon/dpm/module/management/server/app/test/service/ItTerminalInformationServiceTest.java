package com.deppon.dpm.module.management.server.app.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.management.server.app.test.BaseTestCase;
import com.deppon.dpm.module.management.server.service.IItTerminalInformationService;

public class ItTerminalInformationServiceTest extends BaseTestCase{
	
	@Autowired
	private IItTerminalInformationService itTerminalInformationService;

	@Test
	public void testGetItInfo() throws Exception{
		String jsonParam = "";
		String itInfo = itTerminalInformationService.getItInfo(jsonParam);
		System.out.println(itInfo);
	}
	
	@Test
	public void testGetItDealInfo() throws Exception{
		String jsonString = "";
		String itDealInfo = itTerminalInformationService.getItDealInfo(jsonString);
		System.out.println(itDealInfo);
	}
}
