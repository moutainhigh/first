package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.DidiTicketDao;
import com.deppon.dpm.doc.server.entity.DidiTicketEntity;

public class DidiTicketDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private DidiTicketDao didiTicketDao;
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
		didiTicketDao = (DidiTicketDao) appContext.getBean("didiTicketDao");
	}
	/*
	 * testinsert
	 */
	@Test
	public void testinsert() {
		DidiTicketEntity didiTicket = new DidiTicketEntity();
		didiTicket.setId(1);
		didiTicketDao.insert(didiTicket);
	}
/*
 * testfind
 */
	@Test
	public void testfind() {
		DidiTicketEntity didiTicket = new DidiTicketEntity();
		didiTicket.setId(1);
		didiTicketDao.find(didiTicket);
	}
/*
 * testupdate
 */
//	@Test
//	public void testupdate() {
//		DidiTicketEntity didiTicket = new DidiTicketEntity();
//		didiTicket.setId(1);
//		didiTicketDao.update(didiTicket);
//	}
/*
 * testdelete
 */
	@Test
	public void testdelete() {
		DidiTicketEntity didiTicket = new DidiTicketEntity();
		didiTicket.setId(1);
		didiTicketDao.delete(didiTicket);
	}
/*
 * testdeleteBatch
 */
	@Test
	public void testdeleteBatch() {
		String ids = "1";
		didiTicketDao.deleteBatch(ids);
	}
}
