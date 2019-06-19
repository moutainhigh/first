package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.impl.DidiOrderService;

public class DidiOrderServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private DidiOrderService didiOrderService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiOrderService = (DidiOrderService) appContext.getBean("didiOrderService");
	}
	/*
	 * testinsert
	 */
	@Test
	public void testinsert() {
		DidiOrderEntity didiOrder = new DidiOrderEntity();
		didiOrder.setBillno("1125900159586568");
		didiOrderService.insert(didiOrder);
	}
	/*testfind
	 * 
	 */
//	@Test
//	public void testfind() {
//		DidiOrderEntity didiOrder = new DidiOrderEntity();
//		didiOrder.setBillno("1125900159586568");
//		didiOrderService.find(didiOrder);
//	}
	/*
	 * testupdate
	 */
	@Test
	public void testupdate() {
		DidiOrderEntity didiOrder = new DidiOrderEntity();
		didiOrder.setBillno("1125900159586568");
		didiOrderService.update(didiOrder);
	}
	/*
	 * testdelete
	 */
	@Test
	public void testdelete() {
		DidiOrderEntity didiOrder = new DidiOrderEntity();
		didiOrder.setBillno("1125900159586568");
		didiOrderService.delete(didiOrder);
	}
	/*
	 * testdeleteBatch
	 */
	@Test
	public void testdeleteBatch() {
		String ids = "1";
		didiOrderService.deleteBatch(ids);
	}
}
