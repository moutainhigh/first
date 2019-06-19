package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IServePhotoService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ServePhotoServiceTest extends JunitTest{
	private IServePhotoService servePhotoService;

	public IServePhotoService getServePhotoService() {
		return servePhotoService;
	}

	public void setServePhotoService(IServePhotoService servePhotoService) {
		this.servePhotoService = servePhotoService;
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
		servePhotoService =  (IServePhotoService) appContext.getBean("servePhotoService");
	}
	@Test
	public void getPermissionsTest() {
		this.servePhotoService.getPermissions("56627");
	}
	@Test
	public void insertPhotoTest() {

     String str =  "[{\"activeType\":0,\"id\":61,\"mark\":\"1\",\"noticeImg\":\"aaaaaaaaaaaa\",\"userNo\":268101}]";
     this.servePhotoService.insertPhoto(str);
		
		
	}
	

}
