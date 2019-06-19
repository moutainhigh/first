package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IMailReceiveSendServiceFunctionService;

public class MailReceiveSendServiceFunctionServiceTest {

	 private IMailReceiveSendServiceFunctionService mailReceiveSendServiceFunctionService;
		
		
		public void setMailReceiveSendServiceFunctionService(
			IMailReceiveSendServiceFunctionService mailReceiveSendServiceFunctionService) {
		this.mailReceiveSendServiceFunctionService = mailReceiveSendServiceFunctionService;
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
			mailReceiveSendServiceFunctionService = (IMailReceiveSendServiceFunctionService) appContext.getBean("mailReceiveSendServiceFunctionService");
		}
		
		
		@Test
		public void updateRecSendStateTest(){
			String json = "{\"LISTINFO\":[{\"packagesId\":123456789,\"personCode\":\"sadfsdaf\",\"personName\":\"sdfdsaf\",\"state\":1}],\"STATE\":1}";
			
			mailReceiveSendServiceFunctionService.updateRecSendState(json);
			
		}
		
}
