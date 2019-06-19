package com.deppon.dpm.module.management.server.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcScoreMessageService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcScoreMessageServiceTest extends JunitTest {
	
	private IProcScoreMessageService  procScoreMessageService;
 

	
	
	public IProcScoreMessageService getProcScoreMessageService() {
		return procScoreMessageService;
	}

	public void setProcScoreMessageService(
			IProcScoreMessageService procScoreMessageService) {
		this.procScoreMessageService = procScoreMessageService;
	}

	/**
	 * 执行测试方法之前调用.
	 */
	protected ApplicationContext appContext = null;
	
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取procScoreMessageDao实例
		procScoreMessageService = (IProcScoreMessageService) appContext.getBean("procScoreMessageService");
	}
	
	@Test
	public void queryprocScoreMess(){
		String id = "a6c4d546-a168-4b55-ba43-81bf21dd0d62";
		try {
			List<Object> list =   procScoreMessageService.queryprocScoreMess(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
