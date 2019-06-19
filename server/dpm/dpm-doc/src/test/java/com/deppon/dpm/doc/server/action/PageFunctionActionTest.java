package com.deppon.dpm.doc.server.action;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.IPageFunctionService;

/**
 * @author Administrator
 *
 */
public class PageFunctionActionTest extends TestCase {

	PageFunctionAction testpagefun;
	protected ApplicationContext appContext = null;
	private IPageFunctionService pagefunctionservice;

	// 此方法在执行每一个测试方法之前（测试用例）之前调用
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		testpagefun = new PageFunctionAction();
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		pagefunctionservice = (IPageFunctionService) appContext
				.getBean("pagefunctionservice");

		// System.out.println("setUp()");
	}

	// 测试用例，测试Person对象的getSex()方法
	/**
	 * @throws Exception
	 */
	@Test
	public void testallMethod() throws Exception {
//		testpagefun.setUserId("005565");
//		testpagefun.setPagefunctionservice(pagefunctionservice);
//		testpagefun.totalRecord1();
//		System.out.println("testtotalRecord1()");
		System.out.println(pagefunctionservice);
		
	}

}
