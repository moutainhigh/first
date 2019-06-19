package com.deppon.dpm.module.management.server.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcCheckScoreService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcCheckScoreServiceTest extends JunitTest{
	private IProcCheckScoreService procCheckScoreService;

	public IProcCheckScoreService getProcCheckScoreService() {
		return procCheckScoreService;
	}

	public void setProcCheckScoreService(
			IProcCheckScoreService procCheckScoreService) {
		this.procCheckScoreService = procCheckScoreService;
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
		procCheckScoreService = (IProcCheckScoreService) appContext.getBean("procCheckScoreService");
	}
	@Test
	public void savaPassCheckTest() {
		String res = " {\"recordid\": \"22e3c59e-8346-4445-a64b-a52bf68c866a\"," +
				"\"navName\": \"仓库\",\"navCode\":\"YSZG0006\",\"address\":\"2015.12.17测试\"," +
				"\"addressCode\":\"GDM201512177537\",\"userNo\":\"047480\"," +
				"\"submitNub\":1,\"checkMethod\":\"测试\"," +
				"\"isKeyPro\":\"Y\",\"origItemName\":\"探头\"," +
				"\"origItemCode\":\"YSSX260\",\"score\":0," +
				"\"opinion\":\"bhhh\",\"imgOne\":\"hjh\"}";
		
		String str = this.procCheckScoreService.savaPassCheck(res);
		
	}
	@Test
	public void getProcCheckStandardTest() {
		String res = "{\"addressCode\":\"GDM-20151217-7537\"," +
				"\"navCode\":\"YSZG0006\",\"origItemCode\":\"YSSX241\"," +
				"\"selectItem\":\"正常开合\",\"submitNub\":1}";
		String str = this.procCheckScoreService.getProcCheckStandard(res);
		
	}
	@Test
	public void getisSubmitTest() {
	   this.procCheckScoreService.getisSubmit(2);
	}
	@Test
	public void getnumTest() {
		this.procCheckScoreService.getnum(1);
	}
	@Test
	public void getSplitTest() {
		this.procCheckScoreService.getSplit("abcfd");
	}
	@Test
	public void getImgTest() {
		List<Object> list = new ArrayList<Object>();
		this.procCheckScoreService.getImg("s", list);
	}
	
	
	

}
