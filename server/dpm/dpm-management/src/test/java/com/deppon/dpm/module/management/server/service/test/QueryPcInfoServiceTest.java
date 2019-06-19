package com.deppon.dpm.module.management.server.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IQueryPcInfoService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.vo.PcDetailInfoVo;





public class QueryPcInfoServiceTest extends JunitTest {

	IQueryPcInfoService queryPcInfoService;
	
	public IQueryPcInfoService getiQueryPCInfoService() {
		return queryPcInfoService;
	}
	public void setiQueryPCInfoService(IQueryPcInfoService queryPCInfoService) {
		this.queryPcInfoService = queryPCInfoService;
	}
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取tpushNewsService实例
		queryPcInfoService = (IQueryPcInfoService) appContext.getBean("queryPcInfoService");
	}
	@Test
	public void queryPCDetailById() throws Exception {
		PcDetailInfoVo entities = queryPcInfoService.queryPCDetailById("397");
		System.out.println(entities.getServeOriginatorsInfoEntity().getId());
		
	}
	
	@Test
	public void queryPCListByType() throws Exception {
		List<ServeOriginatorsInfoEntity> list = queryPcInfoService.queryPCListByType(1, 1, "0", "310000", "", -1, -1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}
	}
	
	@Test
	public void queryPCListByOrgiNo() throws Exception {
		List<ServeOriginatorsInfoEntity> list = queryPcInfoService.queryPCListByOrgiNo("123");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}
		
	}
	
	@Test
	public void queryPCListById() throws Exception {
		@SuppressWarnings("unused")
		List<ServeOriginatorsInfoEntity> list = queryPcInfoService.queryPCListById("555");
		System.out.println(list);
		
	}
	
	
}
