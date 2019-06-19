package com.deppon.dpm.module.management.server.app.test.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.impl.OutlookService;

public class OutlookServiceTest extends TestCase{
	protected ApplicationContext context;
	private OutlookService outlookService;
	@Override
	protected void setUp() throws Exception {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		outlookService = (OutlookService)context.getBean("outlookService");
	}
	@Test
	public void testInsertOrUpdateEmail() {
		outlookService.insertOrUpdateEmail("17887", "qqqqqq");
		outlookService.insertOrUpdateEmail("000043", "qqqqqq");
		
		outlookService.insertOrUpdateEmail("116250", "ltKUNIwDy7QfbLnwa2TD1g==");
	}

}
