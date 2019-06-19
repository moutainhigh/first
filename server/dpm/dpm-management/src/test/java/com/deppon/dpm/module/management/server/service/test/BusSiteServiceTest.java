package com.deppon.dpm.module.management.server.service.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.common.server.dao.IMonitorCountInfoDao;
import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.dpm.module.management.server.service.IBusSiteService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfo;

public class BusSiteServiceTest extends JunitTest {
	/** 
	* @Fields busSiteService 班车管理-站点管理接口
	*/ 
	private IBusSiteService busSiteService;	
	
	/** 
	* @Fields countInfoDao 数据监控需要的dao
	*/ 
	private IMonitorCountInfoDao countInfo; 
	
	
	private ApplicationContext appContext = null;
	
	@Before
	public void setUp() throws Exception{
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		busSiteService = (IBusSiteService)appContext.getBean("busSiteService");
		countInfo = (IMonitorCountInfoDao)appContext.getBean("countInfo");
	}	
	
	@Test
	public void queryAllBusSite() {
		List<BusSiteInfo> busSiteInfos = busSiteService.queryAllBusSite();
		System.out.println(busSiteInfos);
	}
	
	
	@Test
	public void selectBusSiteLineByTime() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");		
		List<BusMessageView> busMessageViews = busSiteService.selectBusSiteLineByTime(sdf.parse("18:15"));
		System.out.println(busMessageViews);
	}
	
	@Test
	public void updateBusSite() {
		BusSiteInfo busSiteInfo = new BusSiteInfo();
		busSiteInfo.setId(1);
		busSiteInfo.setSiteName("test");
		int retInt = busSiteService.updateBusSite(busSiteInfo);
		System.out.println("======retInt=>"+retInt);
	}

	@Test
	public void deleteBusLine() {		
		int id = 2;
		int busLine =  busSiteService.deleteBusLine(id);
		System.out.println("=====busLine=>"+(busLine));
	}	
	
	
	/**
	 * 数据监控
	 * @param countInfoEntity 数据监控实体类
	 * @return
	 */
	@Test
	public void busServiceWatch() {
		MonitorCountInfoEntity countInfoEntity = new MonitorCountInfoEntity();
		countInfoEntity.setUserId("268087");
		countInfoEntity.setStartTime(new Date());
		countInfoEntity.setEndTime(new Date());
		countInfoEntity.setType(17);		
		int retInt =  busSiteService.busServiceWatch(countInfoEntity);
		logger.info("监控类型："+countInfoEntity.getType());
		System.out.println("============retInt=>"+retInt);
	}
	

	public IBusSiteService getBusSiteService() {
		return busSiteService;
	}

	public void setBusSiteService(IBusSiteService busSiteService) {
		this.busSiteService = busSiteService;
	}

	public IMonitorCountInfoDao getCountInfo() {
		return countInfo;
	}

	public void setCountInfo(IMonitorCountInfoDao countInfo) {
		this.countInfo = countInfo;
	}	
	
}
