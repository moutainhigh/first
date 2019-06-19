package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IBusRedPointService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class BusRedPointServiceTest extends JunitTest {

	private IBusRedPointService busRedPointService;

	public IBusRedPointService getBusRedPointService() {
		return busRedPointService;
	}

	public void setBusRedPointService(IBusRedPointService busRedPointService) {
		this.busRedPointService = busRedPointService;
	}
	
	/**
	 * spring 应用容器.
	 */
	protected ApplicationContext appContext = null;
	/**
	 * 执行测试方法之前调用.
	 */
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取busRedPointService实例
		busRedPointService = (IBusRedPointService) appContext.getBean("busRedPointService");
	}
	
	@Test
	public void getCount(){
		try {
			busRedPointService.getCount("true", "074996");
			busRedPointService.getCount("false", "074996");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
