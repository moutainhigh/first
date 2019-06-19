package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.PageFunctionDao;

public class PageFunctionDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private PageFunctionDao pageFunctionDao;
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		pageFunctionDao = (PageFunctionDao) appContext.getBean("pageFunctionDao");
	}
	/**
	 * 获取全部数据
	 */
	@Test
	public void testtotalRecord(){
		String userId = "005565";
		int pageSize = 10;
		pageFunctionDao.totalRecord(userId, pageSize);
	}
	/**
	 * 返回某一页数据集合
	 */
	@Test
	public void testpageMsg() {
		String userId = "005565";
		int requestBeginNum = 1;
		pageFunctionDao.pageMsg(userId,requestBeginNum);
	}
}
