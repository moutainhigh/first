package com.deppon.dpm.module.management.server.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcUserScoreAndAddressService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ProcUserScoreAndAddressEntity;

public class ProcUserScoreAndAddressServiceTest extends JunitTest {

	private IProcUserScoreAndAddressService procUserScoreAndAddressService;

	public IProcUserScoreAndAddressService getProcUserScoreAndAddressService() {
		return procUserScoreAndAddressService;
	}

	public void setProcUserScoreAndAddressService(
			IProcUserScoreAndAddressService procUserScoreAndAddressService) {
		this.procUserScoreAndAddressService = procUserScoreAndAddressService;
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
		procUserScoreAndAddressService = (IProcUserScoreAndAddressService) appContext.getBean("procUserScoreAndAddressService");
	}
	
	@Test
	public void getProcUserScoreAndAddressInfo(){
		ProcUserScoreAndAddressEntity pusaae = new ProcUserScoreAndAddressEntity();
		pusaae.setUserNo("268101");
		pusaae.setProAdress("上海");
		try {
			List<ProcUserScoreAndAddressEntity> list = procUserScoreAndAddressService.getProcUserScoreAndAddressInfo("268101", "上海");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
