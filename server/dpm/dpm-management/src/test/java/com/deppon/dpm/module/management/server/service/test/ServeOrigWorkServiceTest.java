package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IServeOrigWorkService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;

public class ServeOrigWorkServiceTest extends JunitTest {
	private IServeOrigWorkService workService; 
	
	private ApplicationContext appContext = null;
	
	@Before
	public void setUp() throws Exception{
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		workService =(IServeOrigWorkService)appContext.getBean("serveOrigWorkService");	
	}
	
	@Test
	public void updateOrigInfo(){
		ServeOriginatorsInfoEntity infoEntity = new ServeOriginatorsInfoEntity();
		infoEntity.setId(123);
		workService.updateOrigInfo(infoEntity);
	}
	
	@Test
	public void updatePartInfo(){
		ServeParticipantsInfoEntity infoEntity = new ServeParticipantsInfoEntity();
		infoEntity.setId(123);
		workService.updatePartInfo(infoEntity);
	}
	
}
