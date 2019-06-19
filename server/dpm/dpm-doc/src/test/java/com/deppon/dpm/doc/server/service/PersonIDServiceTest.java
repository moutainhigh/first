package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.PersonIDService;

/**
 * 人员信息查询服务实现类
 * @author wanc
 * 20171116
 */
public class PersonIDServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private PersonIDService personIDService;
	
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		personIDService = (PersonIDService) appContext.getBean("personIDService");
	}
	/**
	 * 根据员工号查询员工身份信息
	 */
	@Test
	public void testqueryPersonIDByID() {
		String userId = "005565";
		personIDService.queryPersonIDByID(userId);
	}
	
}
