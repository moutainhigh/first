package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;

public class SendRoomMessServiceTest extends JunitTest {

	private ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService;
	
	private TpushNewsService tpushNewsService;
	
	private IMonitorCountInfoService monitorCountInfoService;

	public ISendReceiveRoomMessNotificationService getSendReceiveRoomMessNotificationService() {
		return sendReceiveRoomMessNotificationService;
	}

	public void setSendReceiveRoomMessNotificationService(
			ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService) {
		this.sendReceiveRoomMessNotificationService = sendReceiveRoomMessNotificationService;
	}

	public TpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}

	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	public IMonitorCountInfoService getMonitorCountInfoService() {
		return monitorCountInfoService;
	}

	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
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
		
		sendReceiveRoomMessNotificationService = (ISendReceiveRoomMessNotificationService) appContext.getBean("sendReceiveRoomMessNotificationService");
		tpushNewsService = (TpushNewsService) appContext.getBean("tpushNewsService");
		monitorCountInfoService = (IMonitorCountInfoService) appContext.getBean("monitorCountInfoService");
	}
	
	
	
	@Test
	public void generationLeaderMessage(){
		sendReceiveRoomMessNotificationService.generationLeaderMessage("268101", "陈春锋", 1L);
	}
	@Test
	public void judgmentMessageTest() {
		this.sendReceiveRoomMessNotificationService.judgmentMessage(64L);
		
	}
	@Test
	public void saveMesssageToDBTest() {
		this.sendReceiveRoomMessNotificationService.saveMesssageToDB("268101", "123", 2, "2016/4/9");
	}
	@Test
	public void saveMesssageToDBCorporalTest() {
		this.sendReceiveRoomMessNotificationService.saveMesssageToDBCorporal(64L);
	}
	
	
}
