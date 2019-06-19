package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.management.server.service.IBusOpenLineAndNewsSiteService;
import com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;

public class BusOpenLineAndNewsSiteServiceTest extends JunitTest {

	private IBusOpenLineAndNewsSiteService busOpenLineAndNewsSiteService;

	public IBusOpenLineAndNewsSiteService getBusOpenLineAndNewsSiteService() {
		return busOpenLineAndNewsSiteService;
	}

	public void setBusOpenLineAndNewsSiteService(
			IBusOpenLineAndNewsSiteService busOpenLineAndNewsSiteService) {
		this.busOpenLineAndNewsSiteService = busOpenLineAndNewsSiteService;
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
		
		busOpenLineAndNewsSiteService = (IBusOpenLineAndNewsSiteService) appContext.getBean("busOpenLineAndNewsSiteService");
	}
	
	@Test
	public void querySiteAll(){
		try {
			busOpenLineAndNewsSiteService.querySiteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
