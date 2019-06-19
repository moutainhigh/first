package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.PersonalCenterService;

/**
 * 个人中心功能调用接口
 * 
 * @author gwl
 *
 */

public class PersonalCenterServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private PersonalCenterService personalCenterService;
	
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		personalCenterService = (PersonalCenterService) appContext.getBean("personalCenterService");
	}
	
	/*
	 * 根据userId返回个人信息
	 */
	@Test
	public void testqueryPersonIDByID() {
//		String userId = "005565";
//		personalCenterService.queryPersonIDByID(userId);
		System.out.println(personalCenterService);
	}
	/*
	 * 根据userId更新个人信息
	 */
	@Test
	public void testupdate() {
//		String userId = "005565";
//		String userTel = "13000000000";
//		personalCenterService.update(userId, userTel);
	}
	/*
	 * 新增个人信息
	 */
	@Test
	public void testinsert() {
//		String userId = "005565";
//		String userTel = "13000000000";
//		personalCenterService.insert(userId, userTel);
	}
	
}
