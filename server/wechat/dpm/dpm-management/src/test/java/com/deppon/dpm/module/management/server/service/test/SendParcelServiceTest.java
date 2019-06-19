package com.deppon.dpm.module.management.server.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.ISendParcelService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ParcelEntity;


public class SendParcelServiceTest  extends JunitTest {

	//ApplicationTestXML xml = new ApplicationTestXML("com/deppon/dpm/module/management/test/META-INF/spring.xml");
	
	private ISendParcelService sendParcelService ;
	
	

	public ISendParcelService getSendParcelService() {
		return sendParcelService;
	}

	public void setSendParcelService(ISendParcelService sendParcelService) {
		this.sendParcelService = sendParcelService;
	}

	protected ApplicationContext appContext = null;
	
	/**
	 * 执行测试方法之前调用
	 */
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取tpushNewsService实例
		sendParcelService = (ISendParcelService) appContext.getBean("sendParcelService");
	}
	
	@Test
	public void sendParcelData() {
		String json = "";
		this.sendParcelService.sendParcelData(json);
	}
	
	@Test
	public void getParcelList() {
		String userNo = "";
		List<ParcelEntity> list = this.sendParcelService.getParcelList(userNo);
	}
	
	@Test
	public void getPageCount() {
		// TODO Auto-generated method stub
		String userNo = "43538";
		this.sendParcelService.getPageCount(userNo);
	}

}
