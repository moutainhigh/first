package com.deppon.dpm.doc.server.action;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.IPersonIDService;

/**
 * @author Administrator
 *
 */
public class PersonIDCheckActionTest extends TestCase {

	protected ApplicationContext appContext = null;
	PersonIDCheckAction testpersonid;
	// 查询服务接口
	private IPersonIDService personIDService;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		testpersonid = new PersonIDCheckAction();
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		personIDService = (IPersonIDService) appContext.getBean("personIDService");

	}
	
	@Test
	public void testallMethod() throws Exception {
//		testpersonid.setPersonIDService(personIDService);
//		testpersonid.checkID();
		System.out.println(personIDService);
	}
	
}
