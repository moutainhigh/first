package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.ITerminalMessageService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class TerminalMessageServiceTest extends JunitTest{
	private ITerminalMessageService  terminalMessageService;

	public ITerminalMessageService getTerminalMessageService() {
		return terminalMessageService;
	}

	public void setTerminalMessageService(
			ITerminalMessageService terminalMessageService) {
		this.terminalMessageService = terminalMessageService;
	}
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取tpushNewsService实例
		terminalMessageService =  (ITerminalMessageService) appContext.getBean("terminalMessageService");
	}
	@Test
	public void receiveTerminalMessageTest() {
		String res = "{\"orderCode\":\"AAAAAA\",\"dealUserCode\":\"237986\"}";
		this.terminalMessageService.receiveTerminalMessage(res);
		
	}
	
	
	

}
