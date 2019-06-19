package com.deppon.dpm.module.lsp.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.lsp.server.service.ISynStocktaskingService;
import com.deppon.dpm.module.lsp.shared.domain.SynchronousStocktaskingInfo;

public class SynStocktaskingServiceTest{
	
	private ISynStocktaskingService synStocktaskingService;

	public ISynStocktaskingService getSynStocktaskingService() {
		return synStocktaskingService;
	}

	public void setSynStocktaskingService(
			ISynStocktaskingService synStocktaskingService) {
		this.synStocktaskingService = synStocktaskingService;
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
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/lsp/test/META-INF/spring.xml");
		//获取tpushNewsService实例
		synStocktaskingService =  (ISynStocktaskingService) appContext.getBean("synStocktaskingService");
	}
	@Test
	public void synStocktaskingTest()  {
		SynchronousStocktaskingInfo info = new SynchronousStocktaskingInfo();
		String res = this.synStocktaskingService.synStocktasking(info);
	}
	@Test
    public void getNumberTest() {
    	this.synStocktaskingService.getNumber(1);
    }
}
