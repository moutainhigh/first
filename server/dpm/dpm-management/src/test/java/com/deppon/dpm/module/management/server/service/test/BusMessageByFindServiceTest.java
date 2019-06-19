package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IBusMessageByFindService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class BusMessageByFindServiceTest extends JunitTest {

	private IBusMessageByFindService busMessageByFindService;

	public IBusMessageByFindService getBusMessageByFindService() {
		return busMessageByFindService;
	}

	public void setBusMessageByFindService(
			IBusMessageByFindService busMessageByFindService) {
		this.busMessageByFindService = busMessageByFindService;
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
		busMessageByFindService = (IBusMessageByFindService) appContext.getBean("busMessageByFindService");
	}
	
	@Test
	public void getBusMessageByFind(){
		try {
			busMessageByFindService.getBusMessageByFind();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
