package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IMailReceiveSendFunctionService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
//268101
public class MailReceiveSendFunctionServiceTest extends JunitTest{
	private IMailReceiveSendFunctionService   mailReceiveSendFunctionService;

	public IMailReceiveSendFunctionService getMailReceiveSendFunctionService() {
		return mailReceiveSendFunctionService;
	}

	public void setMailReceiveSendFunctionService(
			IMailReceiveSendFunctionService mailReceiveSendFunctionService) {
		this.mailReceiveSendFunctionService = mailReceiveSendFunctionService;
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
		mailReceiveSendFunctionService = (IMailReceiveSendFunctionService) appContext.getBean("mailReceiveSendFunctionService");
	}
	@Test
	public void updateRecInfoTest() throws Exception {
		String str = "{\"postStatus\":0,\"parcelState\":1,\"userNo\":\"268101\",\"packageId\":2}";
		mailReceiveSendFunctionService.updateRecInfo(str);
	}

}
