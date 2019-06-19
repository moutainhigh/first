package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.PersonalCenterDao;

public class PersonalCenterDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private PersonalCenterDao personalCenterDao;
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		personalCenterDao = (PersonalCenterDao) appContext.getBean("personalCenterDao");
	}
	
	/*
	 * 根据userId返回个人信息
	 */
	@Test
	public void testqueryPersonIDByID() {
		System.out.println(personalCenterDao);
//		String userId = "005565";
//		personalCenterDao.queryPersonIDByID(userId);
	}
	/*
	 * 根据userId更新个人信息
	 */
//	@Test
//	public void testupdate() {
//		String userId = "0055651111222";
//		String userTel = "13000000000";
//		personalCenterDao.update(userId, userTel);
//	}
	/*
	 * 新增个人信息
	 */
//	@Test
//	public void testinsert() {
//		String userId = "005565";
//		String userTel = "13000000000";
//		personalCenterDao.insert(userId, userTel);
//	}
}
