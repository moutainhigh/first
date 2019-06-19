package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.KeepOnRecordDao;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public class KeepOnRecordDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private KeepOnRecordDao keepOnRecordDao;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		keepOnRecordDao = (KeepOnRecordDao) appContext.getBean("keepOnRecordDao");
	}
	/*
	 * testqueryAllDidiRecord
	 */
	@Test
	public void testqueryAllDidiRecord() {
		keepOnRecordDao.queryAllDidiRecord();
	}
	/*
	 * testqueryRecordByConditionMobile
	 */
	@Test
	public void testqueryRecordByConditionMobile() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordDao.queryRecordByConditionMobile(vo, 0, 0);
	}
	
	/*
	 *testqueryRecordByConditionPC
	 */
	@Test
	public void testqueryRecordByConditionPC() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordDao.queryRecordByConditionPC(vo, 0, "", "", 0);
	}
	
	/*
	 * testqueryAllDidiRecordByConditionIntMobile
	 */
	@Test
	public void testqueryAllDidiRecordByConditionIntMobile() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordDao.queryAllDidiRecordByConditionIntMobile(vo);
	}
	
	/*
	 * testqueryAllDidiRecordByConditionIntPC
	 */
	@Test
	public void testqueryAllDidiRecordByConditionIntPC() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordDao.queryAllDidiRecordByConditionIntPC(vo, "", "");
	}
	
}
