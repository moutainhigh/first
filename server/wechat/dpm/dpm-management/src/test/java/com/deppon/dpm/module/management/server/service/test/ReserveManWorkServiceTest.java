package com.deppon.dpm.module.management.server.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IReserveManWorkService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.vo.ReserveManWorkVO;

public class ReserveManWorkServiceTest  extends JunitTest {
	/** 
	* @Fields workService 预订管理
	*/ 
	private IReserveManWorkService workService;
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		workService = (IReserveManWorkService)context.getBean("reserveManWorkService");
	}

	
	@Test
	public void checkIsAdmin() throws Exception {
		HashMap<String, String> paramHashMap = new HashMap<String, String>();		
		paramHashMap.put("userNO", "066107");
		paramHashMap.put("orgCode", "W01080101");
		int retInt = workService.checkIsAdmByOrgCode(paramHashMap);
	}
	
	@Test
	public void queryResList() {
		HashMap<String, String> paramHashMap = new HashMap<String, String>();		
		paramHashMap.put("userNo", "098861");
		paramHashMap.put("limitDayNum", "1");
		paramHashMap.put("siteMark", "0");
		List<ReserveManWorkVO> manWorkVO =  workService.queryResList(paramHashMap);
	}
	 
	
	
	
	
	public IReserveManWorkService getWorkService() {
		return workService;
	}
	public void setWorkService(IReserveManWorkService workService) {
		this.workService = workService;
	}
	public ApplicationContext getContext() {
		return context;
	}
	public void setContext(ApplicationContext context) {
		this.context = context;
	}	
}
