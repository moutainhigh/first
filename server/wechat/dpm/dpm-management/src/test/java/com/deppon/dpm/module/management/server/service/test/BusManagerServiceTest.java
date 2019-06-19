package com.deppon.dpm.module.management.server.service.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IBusManagerService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.BusFormBeanEntity;
import com.deppon.dpm.module.management.shared.domain.BusLineInfo;
import com.deppon.dpm.module.management.shared.domain.BusLineOfSite;
import com.deppon.dpm.module.management.shared.domain.BusManagerView;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;

public class BusManagerServiceTest extends JunitTest{
	
	/**
	 * 班车管理service接口
	 */

	private IBusManagerService busManagerService;

	public IBusManagerService getBusManagerService() {
		return busManagerService;
	}

	public void setBusManagerService(IBusManagerService busManagerService) {
		this.busManagerService = busManagerService;
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
		busManagerService = (IBusManagerService) appContext.getBean("busManagerService");
	}
	@Test
	public void getWayMessageTest() throws Exception {
		List<BusManagerView> busView  =     busManagerService.getWayMessage();
		
		
	}
	
	@Test
	public void getOneMessageTest() throws Exception {
		List<BusMessageView> busMessageViews = busManagerService.getOneMessage("2");
	}
	
	@Test
	public void updateStationTest() throws Exception {
		BusLineOfSite busLineOfSite = new BusLineOfSite();
		busLineOfSite.setIsAct(0);
		busLineOfSite.setId(5);
		String result = busManagerService.updateStation(busLineOfSite);
		
	}
	
	
	
	@Test
	public void updateLineTimeTest() throws Exception {
		BusLineInfo busLineInfo = new BusLineInfo();
		busLineInfo.setId(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		
		try {
			Date da = dateFormat.parse("12:30");
			busLineInfo.setStartDate(da);
			String res = busManagerService.updateLineTime(busLineInfo);
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void saveLineInfoTest() throws Exception {
		BusLineInfo busLineInfo = new BusLineInfo();
		busLineInfo.setId(2);
		String res = busManagerService.saveLineInfo(busLineInfo);
		
		
	}
	
	@Test
	public void getEvaManDataTest() throws Exception {
		String res = busManagerService.getEvaManData();
		
	}
	
	@Test
	public void getHistoryDataTest() throws Exception {
		String res = busManagerService.getHistoryData("268101");
	}
	
	@Test
	public void delReplyTest() throws Exception {
		BusFormBeanEntity beanEntity = new BusFormBeanEntity();
		beanEntity.setAdviceId(1);
		
		String res = busManagerService.delReply(beanEntity);
	}
	
	
	
	

}
