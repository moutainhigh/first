package com.deppon.dpm.doc.server.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.AddMessageService;

/**
 * 提示消息调用接口
 * @author gwl
 *
 */

public class AddMessageServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private AddMessageService addmessageservice;
	
	@Before
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		addmessageservice = (AddMessageService) appContext.getBean("addmessageservice");
	}
	
	@Test
	public void testinsert(){
		List<String> userIdList = new ArrayList<String>();
		userIdList.add("005565");
		String dept = "95930";
		addmessageservice.insert(userIdList, dept);
	}
	@Test
	public void testupdateMessage(){
		String id = "1";
		addmessageservice.updateMessage(id);
	}
//	@Test
//	public void testqueryAlluserId(){
//		String dept = "";
//		List<String> strlist = addmessageservice.queryAlluserId(dept);
//		System.out.println(strlist);
//	}
	@Test
	public void testqueryMessage(){
		String userId = "005565";
		addmessageservice.queryMessage(userId);
	}
//	
}
