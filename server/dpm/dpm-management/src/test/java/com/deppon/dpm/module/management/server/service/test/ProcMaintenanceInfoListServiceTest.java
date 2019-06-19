package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcMaintenanceInfoListService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;

public class ProcMaintenanceInfoListServiceTest extends JunitTest{
	
	private IProcMaintenanceInfoListService procMaintenanceInfoListService;

	public IProcMaintenanceInfoListService getProcMaintenanceInfoListService() {
		return procMaintenanceInfoListService;
	}

	public void setProcMaintenanceInfoListService(
			IProcMaintenanceInfoListService procMaintenanceInfoListService) {
		this.procMaintenanceInfoListService = procMaintenanceInfoListService;
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
		//获取procMaintenanceInfoListDao实例
		procMaintenanceInfoListService =  (IProcMaintenanceInfoListService) appContext.getBean("procMaintenanceInfoListService");
	}
	
	@Test
	public void getProcMainList(){
		ProcMaintainEntity pmEntity = new ProcMaintainEntity();
		pmEntity.setUserNo("268101");
		procMaintenanceInfoListService.getProcMainList(1, 10, "268101");
		
	}
}
