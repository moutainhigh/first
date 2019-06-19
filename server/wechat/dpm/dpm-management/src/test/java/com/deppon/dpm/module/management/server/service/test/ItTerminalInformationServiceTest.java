package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.impl.ItTerminalInformationService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ItTerminalInformationServiceTest extends JunitTest{
	private ItTerminalInformationService itTerminalInformationService;

	public ItTerminalInformationService getItTerminalInformationService() {
		return itTerminalInformationService;
	}

	public void setItTerminalInformationService(
			ItTerminalInformationService itTerminalInformationService) {
		this.itTerminalInformationService = itTerminalInformationService;
	}
	
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	/**
	 * 执行测试方法之前调用
	 */
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取tpushNewsService实例
		itTerminalInformationService =  (ItTerminalInformationService) appContext.getBean("itTerminalInformationService");
	}
	
	@Test
	public void getItInfoTest() throws Exception {
		String res = itTerminalInformationService.getItDealInfo("ss");
	}
	
	@Test
	public void getItDealInfoTest() throws Exception {
		String res = itTerminalInformationService.getItDealInfo("ee");
	}
	
	

}
