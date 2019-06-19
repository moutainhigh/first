package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.ITheaterDealService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ThreaterDealServiceTest extends JunitTest {
	private ITheaterDealService theaterDealService;

	public ITheaterDealService getTheaterDealService() {
		return theaterDealService;
	}

	public void setTheaterDealService(ITheaterDealService theaterDealService) {
		this.theaterDealService = theaterDealService;
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
		theaterDealService =  (ITheaterDealService) appContext.getBean("theaterDealService");
	} 
	
	@Test
	public void theaterDealTest() {
		String res = theaterDealService.theaterDeal("ee");
		
	}

}
