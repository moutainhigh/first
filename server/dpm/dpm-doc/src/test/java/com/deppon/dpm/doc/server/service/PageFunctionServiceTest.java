package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.PageFunctionService;

/**
 * 分页功能调用接口
 * 
 * @author gwl
 *
 */

public class PageFunctionServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private PageFunctionService pagefunctionservice;
	
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		pagefunctionservice = (PageFunctionService) appContext.getBean("pagefunctionservice");
	}
	/**
	 * 获取全部数据
	 */
	@Test
	public void testtotalRecord(){
		String userId = "005565";
		int pageSize = 10;
		pagefunctionservice.totalRecord(userId, pageSize, true, "");
	}
	/**
	 * 返回某一页数据集合
	 */
	@Test
	public void testpageMsg() {
		String userId = "005565";
		int requestBeginNum = 1;
		pagefunctionservice.pageMsg(userId,requestBeginNum);
	}
}