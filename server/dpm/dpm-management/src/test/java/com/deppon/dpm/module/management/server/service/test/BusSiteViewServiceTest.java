package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IBusSiteViewService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfoByClick;

public class BusSiteViewServiceTest extends JunitTest {

	private IBusSiteViewService bussiteviewservice;

	public IBusSiteViewService getBussiteviewservice() {
		return bussiteviewservice;
	}

	public void setBussiteviewservice(IBusSiteViewService bussiteviewservice) {
		this.bussiteviewservice = bussiteviewservice;
	}

	/**
	 * spring 应用容器.
	 */
	protected ApplicationContext appContext = null;
	/**
	 * 执行测试方法之前调用.
	 */
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		
		bussiteviewservice = (IBusSiteViewService) appContext.getBean("bussiteviewservice");
	}
	
	@Test
	public void getSiteNameAndState(){
		try {
			bussiteviewservice.getSiteNameAndState("PM");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSiteByRouteTime(){
		BusSiteInfoByClick infoByClick = new BusSiteInfoByClick();
		//ccf 修改
		infoByClick.setId(21);
		infoByClick.setTimeType("AM");
		
		try {
			bussiteviewservice.getSiteByRouteTime(infoByClick);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void getSiteByLineInfo(){
		BusSiteInfoByClick busSiteInfoByClick = new BusSiteInfoByClick();
		//ccf 修改
		busSiteInfoByClick.setTimeType("AM");
		busSiteInfoByClick.setStartName("豪都");
		try {
			bussiteviewservice.getSiteByLineInfo(busSiteInfoByClick);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void getSiteByApplyInfo(){
		BusSiteInfoByClick b = new BusSiteInfoByClick();
		//ccf 修改
		b.setId(9);
		b.setTimeType("PM");
		try {
			bussiteviewservice.getSiteByApplyInfo(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSiteAddressAndSiteName(){
		BusSiteInfoByClick b = new BusSiteInfoByClick();
		//ccf 修改
		b.setSiteName("广虹公寓");
		try {
			bussiteviewservice.getSiteAddressAndSiteName(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
