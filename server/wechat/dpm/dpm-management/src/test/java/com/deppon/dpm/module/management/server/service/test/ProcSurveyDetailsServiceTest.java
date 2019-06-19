package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcSurveyDetailsService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcSurveyDetailsServiceTest extends JunitTest {
	/**
	 * service接口
	 */
	private IProcSurveyDetailsService procSurveyDetailsService;

	public IProcSurveyDetailsService getProcSurveyDetailsService() {
		return procSurveyDetailsService;
	}

	public void setProcSurveyDetailsService(
			IProcSurveyDetailsService procSurveyDetailsService) {
		this.procSurveyDetailsService = procSurveyDetailsService;
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
		procSurveyDetailsService = (IProcSurveyDetailsService) appContext.getBean("procSurveyDetailsService");
	}
	@Test
	public void getProcDeatilsTest () {
		String res = this.procSurveyDetailsService.getProcDeatils("storeType", "54");
		
	}
	@Test
	public void getProcSelectTest() {
		String res = this.procSurveyDetailsService.getProcSelect(2, "storeType");
		
	}
	@Test
	public void getPhotoDetailTest() {
		String res = this.procSurveyDetailsService.getPhotoDetail("54");
	}
	
	
}
