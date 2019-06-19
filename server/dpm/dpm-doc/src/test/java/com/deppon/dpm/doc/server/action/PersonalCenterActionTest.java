package com.deppon.dpm.doc.server.action;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.IPersonalCenterService;

/**
 * @author Administrator
 *
 */
public class PersonalCenterActionTest extends TestCase  {

	private IPersonalCenterService personalCenterService;
	protected ApplicationContext appContext = null;
	PersonalCenterAction testpersonc;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		testpersonc = new PersonalCenterAction();
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		personalCenterService = (IPersonalCenterService) appContext.getBean("personalCenterService");

	}
	
	@Test
	public void testallMethod() throws Exception {
//		testpersonc.setPersonalCenterService(personalCenterService);
//		testpersonc.getQueryTel();
		System.out.println(personalCenterService);
//		testpersonc.addPersonalc();+++
//		testpersonc.updatePersonalc();+++
		
	}
	
}
