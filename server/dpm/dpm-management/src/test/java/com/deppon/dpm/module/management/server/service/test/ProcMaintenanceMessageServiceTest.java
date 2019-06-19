package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcMaintenanceMessageService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;

public class ProcMaintenanceMessageServiceTest extends JunitTest{
	
	private IProcMaintenanceMessageService procMaintenanceMessageService;
	

	/**
	 * 推送消息方法.
	 */
	private TpushNewsService tpushNewsService;

	public TpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}

	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}
	
	public IProcMaintenanceMessageService getProcMaintenanceMessageService() {
		return procMaintenanceMessageService;
	}
	public void setProcMaintenanceMessageService(
			IProcMaintenanceMessageService procMaintenanceMessageService) {
		this.procMaintenanceMessageService = procMaintenanceMessageService;
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
		//获取procMaintenanceMessageService实例
		procMaintenanceMessageService = (IProcMaintenanceMessageService) appContext.getBean("procMaintenanceMessageService");
		tpushNewsService = (TpushNewsService) appContext.getBean("tpushNewsService");
	}
	
	@Test
	public void getProcMainMessage(){
		try {
			procMaintenanceMessageService.getProcMainMessage(0, "1000", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
