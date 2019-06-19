package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IServeMonitoringOrAddressService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ServeMonitoringOrAddressServiceTest extends JunitTest {
	private IServeMonitoringOrAddressService serveMonitoringOrAddressService;

	public IServeMonitoringOrAddressService getServeMonitoringOrAddressService() {
		return serveMonitoringOrAddressService;
	}

	public void setServeMonitoringOrAddressService(
			IServeMonitoringOrAddressService serveMonitoringOrAddressService) {
		this.serveMonitoringOrAddressService = serveMonitoringOrAddressService;
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
		serveMonitoringOrAddressService = (IServeMonitoringOrAddressService) appContext.getBean("serveMonitoringOrAddressService");
	}
	@Test
	public void queryAddressNationwideTest() {
		try {
			this.serveMonitoringOrAddressService.queryAddressNationwide();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void saveMonitoringTest() {
	String str = "{\"userNo\":268101,\"type\":1}";
	try {
		this.serveMonitoringOrAddressService.saveMonitoring(str);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	@Test
	public void queryProcTaskTest() {
		String str = "{\"userNo\":268101}";
		try {
			this.serveMonitoringOrAddressService.queryProcTask(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void queryServeTaskTest() {
		String str = "{\"userNo\":268101}";
		try {
			this.serveMonitoringOrAddressService.queryServeTask(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
