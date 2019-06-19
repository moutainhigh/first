package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService;

public class ReserveManageQueryListInfoServiceTest {

   private IReserveManageQueryListInfoService reserveManageQueryListInfoService;
	
	
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
		reserveManageQueryListInfoService = (IReserveManageQueryListInfoService) appContext.getBean("reserveManageQueryListInfoService");
	}
	
	@Test
	public void querySiteLeisureList(){
	    String str = "{\"areaCode\":\"0001\",\"dateStr\":\"2015-10-20\",\"siteMark\":0}";
	    
	    try {
			reserveManageQueryListInfoService.querySiteLeisureList(str);
		} catch (Exception e) {
			
		}
	}
	@Test
	public void querySiteInfo(){
	    String str = "{\"siteMark\":0}";
	    
	    try {
			reserveManageQueryListInfoService.querySiteInfo(str);
		} catch (Exception e) {
			
		}
	}
	@Test
	public void querySiteDateList(){
	    String str = "{\"dateStr\":\"2015-10-01\",\"id\":17}";
	    
	    try {
			reserveManageQueryListInfoService.querySiteDateList(str);
		} catch (Exception e) {
			
		}
	}
	
	
	
}
