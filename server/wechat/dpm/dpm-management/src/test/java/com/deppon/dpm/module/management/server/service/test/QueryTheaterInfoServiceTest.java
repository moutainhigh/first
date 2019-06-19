package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IQueryTheaterInfoService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;



public class QueryTheaterInfoServiceTest extends JunitTest{
	private IQueryTheaterInfoService queryTheaterService;

	public IQueryTheaterInfoService getQueryTheaterService() {
		return queryTheaterService;
	}

	public void setQueryTheaterService(IQueryTheaterInfoService queryTheaterService) {
		this.queryTheaterService = queryTheaterService;
	}
	
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	/**
	 * 执行测试方法之前调用
	 */
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取tpushNewsService实例
		queryTheaterService =  (IQueryTheaterInfoService) appContext.getBean("queryTheaterService");
	}
	@Test
	public void queryTheaterTest() {
	this.queryTheaterService.queryTheater("abcdf");
	}
}
