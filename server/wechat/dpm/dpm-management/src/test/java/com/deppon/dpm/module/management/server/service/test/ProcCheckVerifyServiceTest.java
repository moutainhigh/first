package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcCheckVerifyService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcCheckVerifyServiceTest extends JunitTest{
	private IProcCheckVerifyService checkVerifyService;

	public IProcCheckVerifyService getCheckVerifyService() {
		return checkVerifyService;
	}

	public void setCheckVerifyService(IProcCheckVerifyService checkVerifyService) {
		this.checkVerifyService = checkVerifyService;
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
		checkVerifyService =  (IProcCheckVerifyService) appContext.getBean("checkVerifyService");
	}
	@Test
	public void checkProcSubmitTest() {
		String res = this.checkVerifyService.checkProcSubmit("GDM-20150813-2977");
	}
	

}
