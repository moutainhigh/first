package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class BusMsgAssNewsServiceTest extends JunitTest{
	private IBusMsgAssNewsService busMsgAssNewsService;

	public IBusMsgAssNewsService getBusMsgAssNewsService() {
		return busMsgAssNewsService;
	}

	public void setBusMsgAssNewsService(IBusMsgAssNewsService busMsgAssNewsService) {
		this.busMsgAssNewsService = busMsgAssNewsService;
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
		busMsgAssNewsService = (IBusMsgAssNewsService) appContext.getBean("busMsgAssNewsService");
	}
	@Test
	public void getGustyMessageTest() throws Exception {
		this.busMsgAssNewsService.getGustyMessage();
		
	}
	@Test
	public void saveGustyMessageTest() throws Exception {
	String str = "{\"userNo\":268101,\"content\":\"testtest\"}";	
	this.busMsgAssNewsService.saveGustyMessage(str);
	}
	@Test
	public void saveHitsTest() throws Exception {
	String str = "{\"siteId\":1,\"userNo\":237396}";
	this.busMsgAssNewsService.saveHits(str);
	}
	@Test
	public void saveSiteTest() throws Exception {
		String str = "{\"siteName\":\"dadd\",\"userNo\":237396}";
		this.busMsgAssNewsService.saveSite(str);
		
	}
	@Test
	public void deleteReplyTest() throws Exception{
		String str = "{\"isState\":1,\"id\":2}";
		this.busMsgAssNewsService.deleteReply(str);
		
	}
	@Test
	public void saveReplyTest() throws Exception {
		String str = "{\"isState\":0,\"retId\":4,\"userNo\":237396,\"replyContent\":\"ssdddddd\"}";
		this.busMsgAssNewsService.saveReply(str);
	}
	@Test
	public void setSuggestTest() throws Exception {
		
		this.busMsgAssNewsService.setSuggest(190, "268101", "哈哈哈哈哈");
		
	}
	@Test
	public void saveOtherDataTest() throws Exception {
		this.busMsgAssNewsService.saveOtherData(3, "268101");
	}

}
