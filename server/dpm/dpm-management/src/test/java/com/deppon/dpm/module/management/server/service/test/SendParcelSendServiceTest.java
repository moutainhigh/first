package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.ISendParcelSendSerice;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.SendParcelSendEntity;

public class SendParcelSendServiceTest  extends JunitTest{
	 /**
	  * 注入对象
	  */
	private ISendParcelSendSerice sendParcelSendService;

	public ISendParcelSendSerice getSendParcelSendService() {
		return sendParcelSendService;
	}

	public void setSendParcelSendService(ISendParcelSendSerice sendParcelSendService) {
		this.sendParcelSendService = sendParcelSendService;
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
		sendParcelSendService =  (ISendParcelSendSerice) appContext.getBean("sendParcelSendService");
	}
	@Test
	public void getNeedManageTest() {
		String res = "{\"sendCompany\":\"ss\",\"sendPhone\":\"13761302259\"," +
				"\"sendName\":\"ccf\",\"ManageCode\":\"SELECT\",\"photoCode\":\"dpm\"}";
		try {
			String str = this.sendParcelSendService.getNeedManage(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void savaSendParcelSendTest() {
		String res = "{\"sendCompany\":\"ss\",\"sendPhone\":\"13761302259\"," +
				"\"sendName\":\"ccf\",\"ManageCode\":\"SELECT\",\"photoCode\":\"dpm\"}";
		SendParcelSendEntity sendParcelSendEntity = JsonUtil.jsonToEntity(res,SendParcelSendEntity.class);
		String str = this.sendParcelSendService.savaSendParcelSend(sendParcelSendEntity);
		
	}
	@Test
	public void selectSendParcelSendTest() {
		this.sendParcelSendService.selectSendParcelSend();
	}
	@Test
	public void updateSendParcelSendTest() {
		String res = "{\"sendCompany\":\"ss\",\"sendPhone\":\"13761302259\"," +
				"\"sendName\":\"ccf\",\"ManageCode\":\"SELECT\",\"photoCode\":\"dpm\",\"id\":72}";
		SendParcelSendEntity sendParcelSendEntity = JsonUtil.jsonToEntity(res,SendParcelSendEntity.class);	
		this.sendParcelSendService.updateSendParcelSend(sendParcelSendEntity);
	}
	@Test
	public void getidTest() {
		String res = "{\"sendCompany\":\"ss\",\"sendPhone\":\"13761302259\"," +
				"\"sendName\":\"ccf\",\"ManageCode\":\"SELECT\",\"photoCode\":\"dpm\",\"id\":72}";
		SendParcelSendEntity sendParcelSendEntity = JsonUtil.jsonToEntity(res,SendParcelSendEntity.class);
		this.sendParcelSendService.getid(sendParcelSendEntity);
		
	}
	@Test
	public void getIsNotNullTest() {
		String res = "{\"sendCompany\":\"ss\",\"sendPhone\":\"13761302259\"," +
				"\"sendName\":\"ccf\",\"ManageCode\":\"SELECT\",\"photoCode\":\"dpm\",\"id\":72}";
		SendParcelSendEntity sendParcelSendEntity = JsonUtil.jsonToEntity(res,SendParcelSendEntity.class);
		this.sendParcelSendService.getIsNotNull(sendParcelSendEntity);
	}
	@Test
	public void isNumTest() {
		this.sendParcelSendService.isNum(2);
	}
	
	
	

}
