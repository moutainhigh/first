package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.DiDiRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;

public class DiDiRecordServiceTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private DiDiRecordService didirecordService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didirecordService = (DiDiRecordService) appContext.getBean("didirecordService");
	}
	/*
	 * insert
	 */
	@Test
	public void testinsert() {
		DiDiRecordVO vo = new DiDiRecordVO();
		didirecordService.insert(vo);
	}
	/*
	 * insert
	 */
	@Test
	public void testupdate() {
		didirecordService.update(0, "", "");
	}
}
