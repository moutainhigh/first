package com.deppon.dpm.module.management.server.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.ISendParcelNewsService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.SendParcelNewsEntity;



public class SendParcelNewsServiceTest extends JunitTest{
	private ISendParcelNewsService sendParcelNewsService;

	public ISendParcelNewsService getSendParcelNewsService() {
		return sendParcelNewsService;
	}

	public void setSendParcelNewsService(
			ISendParcelNewsService sendParcelNewsService) {
		this.sendParcelNewsService = sendParcelNewsService;
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
		sendParcelNewsService =  (ISendParcelNewsService) appContext.getBean("sendParcelNewsService");
	}
	@Test
	public void getPushNewsTest() throws Exception {
		String res = this.sendParcelNewsService.getPushNews("268101");
	}
	@Test
	public void getNewsTest() throws Exception {
		List<SendParcelNewsEntity> entities = this.sendParcelNewsService.getNews("268101");
		
	}
	@Test
	public void updateNewsTest() {
		int res = this.sendParcelNewsService.updateNews("268101");
	}
	
	

}
