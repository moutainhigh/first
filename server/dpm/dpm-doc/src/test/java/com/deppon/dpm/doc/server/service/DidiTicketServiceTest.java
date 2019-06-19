package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.entity.DidiTicketEntity;
import com.deppon.dpm.doc.server.service.impl.DidiTicketService;

/**
 * @author Administrator
 *20171201
 */
public class DidiTicketServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private DidiTicketService didiTicketService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiTicketService = (DidiTicketService) appContext.getBean("didiTicketService");
	}
	/*
	 * testinsert
	 */
	@Test
	public void testinsert() {
		DidiTicketEntity didiTicket = new DidiTicketEntity();
		didiTicket.setId(1);
		didiTicketService.insert(didiTicket);
	}
/*
 * testfind
 */
	@Test
	public void testfind() {
		DidiTicketEntity didiTicket = new DidiTicketEntity();
		didiTicket.setId(1);
		didiTicketService.find(didiTicket);
	}
/*
 * testupdate
 */
//	@Test
//	public void testupdate() {
//		DidiTicketEntity didiTicket = new DidiTicketEntity();
//		didiTicket.setId(1);
//		didiTicketService.update(didiTicket);
//	}
/*
 * testdelete
 */
	@Test
	public void testdelete() {
		DidiTicketEntity didiTicket = new DidiTicketEntity();
		didiTicket.setId(1);
		didiTicketService.delete(didiTicket);
	}
/*
 * testdeleteBatch
 */
	@Test
	public void testdeleteBatch() {
		String ids = "1";
		didiTicketService.deleteBatch(ids);
	}
	
}
