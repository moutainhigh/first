package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IReservationManageByAdminService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ReservationManageByAdminServiceTest extends JunitTest {

	private IReservationManageByAdminService reservationManageByAdminService;

	public IReservationManageByAdminService getReservationManageByAdminService() {
		return reservationManageByAdminService;
	}

	public void setReservationManageByAdminService(
			IReservationManageByAdminService reservationManageByAdminService) {
		this.reservationManageByAdminService = reservationManageByAdminService;
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
		reservationManageByAdminService = (IReservationManageByAdminService) appContext.getBean("reservationManageByAdminService");
	}
	
	@Test
	public void getReservationManagList(){
		String areaName = "上海";
		int siteMark = 1;
		reservationManageByAdminService.getReservationManagList(areaName, siteMark,"2015-11-12");
	}
}
