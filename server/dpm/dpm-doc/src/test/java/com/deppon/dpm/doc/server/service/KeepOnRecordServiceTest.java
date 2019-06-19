package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.KeepOnRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public class KeepOnRecordServiceTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private KeepOnRecordService keepOnRecordService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		keepOnRecordService = (KeepOnRecordService) appContext.getBean("keepOnRecordService");
	}
	/*
	 * testqueryAllDidiRecord
	 */
	@Test
	public void testqueryAllDidiRecord() {
		keepOnRecordService.queryAllDidiRecord();
	}
	/*
	 * testqueryRecordByConditionMobile
	 */
	@Test
	public void testqueryRecordByConditionMobile() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordService.queryRecordByConditionMobile(vo, 0, 0);
	}
	
	/*
	 *testqueryRecordByConditionPC
	 */
	@Test
	public void testqueryRecordByConditionPC() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordService.queryRecordByConditionPC(vo, 0, "", "", 0);
	}
	
	/*
	 * testqueryAllDidiRecordByConditionIntMobile
	 */
	@Test
	public void testqueryAllDidiRecordByConditionIntMobile() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordService.queryAllDidiRecordByConditionIntMobile(vo);
	}
	
	/*
	 * testqueryAllDidiRecordByConditionIntPC
	 */
	@Test
	public void testqueryAllDidiRecordByConditionIntPC() {
		DiDiRecordVO vo = new DiDiRecordVO();
		keepOnRecordService.queryAllDidiRecordByConditionIntPC(vo, "", "");
	}
	
}
