package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.OrderMessageDao;

public class OrderMessageDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private OrderMessageDao orderMessageDao;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		orderMessageDao = (OrderMessageDao) appContext.getBean("orderMessageDao");
	}
	/*
	 * testfindOrderMessage
	 */
	@Test
	public void testfindOrderMessage() {
		orderMessageDao.findOrderMessage("149607");
	}
	
	/*
	 * testfindOrderMessage
	 */
	@Test
	public void testfindTodayOrder() {
		orderMessageDao.findTodayOrder("149607");
	}
}
