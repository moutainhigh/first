package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.DiDiRecordDao;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public class DiDiRecordDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private DiDiRecordDao didirecordDao;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didirecordDao = (DiDiRecordDao) appContext.getBean("didirecordDao");
	}
	/*
	 * insert
	 */
	@Test
	public void testinsert() {
		DiDiRecordVO vo = new DiDiRecordVO();
		didirecordDao.insert(vo);
	}
	/*
	 * insert
	 */
	@Test
	public void testupdate() {
		didirecordDao.update(0, "", "");
	}
}
