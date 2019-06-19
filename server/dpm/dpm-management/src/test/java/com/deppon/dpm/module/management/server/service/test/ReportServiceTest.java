package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.impl.ReportService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.OrderAddRequest;

public class ReportServiceTest extends JunitTest{
	private ReportService reportService ;

	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
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
		reportService = (ReportService) appContext.getBean("reportService");
	}
	
	@Test
	public void submitReportTest() {
		OrderAddRequest addRequest = new OrderAddRequest();
		addRequest.setAddress("ddd");
		addRequest.setAddType(1);
		try {
			reportService.submitReport(addRequest);
			
		} catch (Exception e) {
		
		}
		
	}
	
	@Test
	public void queryAuthorityTest () {
		reportService.queryAuthority("268101");
	}
	@Test
	public void queryDeptByEmpCodeTest() {
		int test = reportService.queryDeptByEmpCode("000021");
		
	}
	

}
