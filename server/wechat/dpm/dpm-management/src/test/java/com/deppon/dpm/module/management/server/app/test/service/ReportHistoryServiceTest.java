package com.deppon.dpm.module.management.server.app.test.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IReportHistoryService;

public class ReportHistoryServiceTest extends TestCase{
	protected ApplicationContext context;
	private IReportHistoryService reportHistoryService;
	@Override
	protected void setUp() throws Exception {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		reportHistoryService = (IReportHistoryService)context.getBean("reportHistoryService");
	}
	@Test
	public void testQueryReportHistory() {
		reportHistoryService.queryReportHistory("116250");
	}

}
