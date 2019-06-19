package com.deppon.dpm.module.management.server.service.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcManWorkService;
import com.deppon.dpm.module.management.server.service.impl.ProcManWorkService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;

public class ProcManWorkServiceTest extends JunitTest {
	/** 
	* @Fields workService 工程维修接口
	*/ 
	private IProcManWorkService workService;
	
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		workService = (IProcManWorkService)context.getBean("procManWorkService");
	}

	@Test
	public void queryForList(){
		String pid = "100103";
		ProcMaintainEntity maintainEntity =   workService.queryForList(pid);
	}
	
	@Test
	public void checkIsRepMan(){
		String userNo = "126768";
		int retInt = workService.checkIsRepMan(userNo);
	}
	
	
	@Test
	public void  saveProcMan() throws Exception { 
		HashMap<String, Object> map = new HashMap<String, Object>();
		ProcMaintainEntity maintainEntity = new ProcMaintainEntity();
		maintainEntity.setUserNo("268101");
		//workService.saveProcMan(maintainEntity, map);
	}
	
	@Test
	public void updateProcMan(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ProcMaintainEntity maintainEntity = new ProcMaintainEntity();
		maintainEntity.setId(100093);
		maintainEntity.setProName("ccf");
		maintainEntity.setProCode("GDM-20130320-0057");
		maintainEntity.setDepartment("（待清理）广州工程部");
		maintainEntity.setApplyReason("test");
		maintainEntity.setImgOne("ss");
		//workService.updateProcMan(maintainEntity, map);
	}
	
	public IProcManWorkService getWorkService() {
		return workService;
	}

	public void setWorkService(IProcManWorkService workService) {
		this.workService = workService;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}	
}
