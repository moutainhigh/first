package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IReserveManageCancelService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ReserveManageCancelServiceTest extends JunitTest {

	private IReserveManageCancelService reserveManageCancelService;

	public IReserveManageCancelService getReserveManageCancelService() {
		return reserveManageCancelService;
	}

	public void setReserveManageCancelService(
			IReserveManageCancelService reserveManageCancelService) {
		this.reserveManageCancelService = reserveManageCancelService;
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
		//获取procUserScoreAndAddressDao实例
		reserveManageCancelService = (IReserveManageCancelService) appContext.getBean("reserveManageCancelService");
	}
	
	@Test
	public void updateState(){
		reserveManageCancelService.updateState(1, 1);
	}
	
}
