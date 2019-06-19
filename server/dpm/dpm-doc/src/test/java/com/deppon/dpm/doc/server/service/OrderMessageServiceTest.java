package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.OrderMessageService;

public class OrderMessageServiceTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private OrderMessageService orderMessageService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		orderMessageService = (OrderMessageService) appContext.getBean("orderMessageService");
	}
	/*
	 * testfindOrderMessage
	 */
	@Test
	public void testfindOrderMessage() {
		orderMessageService.findOrderMessage("149607");
	}
	
	/*
	 * testfindOrderMessage
	 */
	@Test
	public void testfindTodayOrder() {
		orderMessageService.findTodayOrder("149607");
	}
}
