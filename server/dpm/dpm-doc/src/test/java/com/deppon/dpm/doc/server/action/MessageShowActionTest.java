package com.deppon.dpm.doc.server.action;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.IAddMessageService;

/**
 * @author Administrator
 *
 */
public class MessageShowActionTest extends TestCase {

	/**
	 * 
	 */
	protected ApplicationContext appContext = null;
	private IAddMessageService addmessageservice ;
	MessageShowAction testmessage;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		testmessage = new MessageShowAction();
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		addmessageservice = (IAddMessageService) appContext.getBean("addmessageservice");

	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testallMethod() throws Exception {
//		testmessage.setId(1);
//		testmessage.setUserId("00556511122");
//		testmessage.setAddmessageservice(addmessageservice);
////		testmessage.updateMessage();
//		testmessage.queryMessage();
		System.out.println(addmessageservice);
	}
	
}
