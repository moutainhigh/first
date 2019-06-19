package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.DepositorDao;
import com.deppon.dpm.doc.server.vo.DidiBankCardVO;

public class DepositorDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private DepositorDao DepositorDao;
	
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		DepositorDao = (DepositorDao) appContext.getBean("DepositorDao");
	}
	
	/*
	 * testinsert
	 */
	@Test
	public void testinsertAccount() {
		DidiBankCardVO didiBankCardvo = new DidiBankCardVO();
		DepositorDao.insertAccount(didiBankCardvo);
	}
	@Test
	public void testqueryByDeptName() {
		DepositorDao.queryByDeptName("");
	}
}
