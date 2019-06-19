package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcMaintainRightControlService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcMaintainRightControlServiceTest extends JunitTest{
	private IProcMaintainRightControlService procMaintainRightControlService;

	public IProcMaintainRightControlService getProcMaintainRightControlService() {
		return procMaintainRightControlService;
	}

	public void setProcMaintainRightControlService(
			IProcMaintainRightControlService procMaintainRightControlService) {
		this.procMaintainRightControlService = procMaintainRightControlService;
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
		procMaintainRightControlService =  (IProcMaintainRightControlService) appContext.getBean("procMaintainRightControlService");
		
	}
	@Test
	public void checkRightControlTest() {
		String str = "{\"userNo\":268101,\"module\":1}";
		try {
			this.procMaintainRightControlService.checkRightControl(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
