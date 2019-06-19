package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcCheckFindScoreShowService;
import com.deppon.dpm.module.management.server.service.IProcMaintainRightControlService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcCheckFindScoreShowServiceTest extends JunitTest {

	private IProcCheckFindScoreShowService procCheckFindScoreShowService;

	
	public void setProcCheckFindScoreShowService(
			IProcCheckFindScoreShowService procCheckFindScoreShowService) {
		this.procCheckFindScoreShowService = procCheckFindScoreShowService;
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
		// 实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/module/management/test/META-INF/spring.xml");
		// 获取tpushNewsService实例
		procCheckFindScoreShowService = (IProcCheckFindScoreShowService) appContext
				.getBean("procCheckFindScoreShowService");

	}

	@Test
	public void getHisScoreFind() {
		String str = "{\"addressCode\":\"GDM-20160129-7868\",\"submitNub\":1}";
		try {
			this.procCheckFindScoreShowService.getHisScoreFind(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void getCountScoreTest() {
		String str = "{\"addressCode\":\"GDM-20160129-7868\",\"submitNub\":1}";
		try {
			this.procCheckFindScoreShowService.getHisScoreFind(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void getFindListView() {
		String str = "{\"addressCode\":\"GDM-20160129-7868\",\"submitNub\":1,\"navCode\":\"YSZG0006\"}";
		try {
			this.procCheckFindScoreShowService.getHisScoreFind(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
