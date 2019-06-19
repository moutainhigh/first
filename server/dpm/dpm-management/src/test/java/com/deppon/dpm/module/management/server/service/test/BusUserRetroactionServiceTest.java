package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IBusUserRetroactionAddService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class BusUserRetroactionServiceTest extends JunitTest{
	
	private IBusUserRetroactionAddService buraService;

	public IBusUserRetroactionAddService getBuraService() {
		return buraService;
	}

	public void setBuraService(IBusUserRetroactionAddService buraService) {
		this.buraService = buraService;
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
		buraService = (IBusUserRetroactionAddService) appContext.getBean("buraService");
	}
	
	@Test
	public void saveBusUserRetroactionTest() throws Exception {
		String str = "{\"userNo\":268101,\"userScore\":2,\"content\":\"sb\"}";
		
		int res = this.buraService.saveBusUserRetroaction(str);
		
	}
	

}
