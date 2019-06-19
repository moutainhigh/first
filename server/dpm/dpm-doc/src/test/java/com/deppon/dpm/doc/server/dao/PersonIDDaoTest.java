package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.PersonIDDao;

public class PersonIDDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private PersonIDDao personidDao;
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		personidDao = (PersonIDDao) appContext.getBean("personidDao");
	}
	/**
	 * 根据员工号查询员工身份信息
	 */
	@Test
	public void testqueryPersonIDByID() {
		String userId = "005565";
		personidDao.queryPersonIDByID(userId);
	}
}
