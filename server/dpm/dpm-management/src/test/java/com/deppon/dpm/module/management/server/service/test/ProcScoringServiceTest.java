package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcScoringService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcScoringServiceTest extends JunitTest{
	private IProcScoringService engScoringService;

	public IProcScoringService getEngScoringService() {
		return engScoringService;
	}

	public void setEngScoringService(IProcScoringService engScoringService) {
		this.engScoringService = engScoringService;
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
		engScoringService =  (IProcScoringService) appContext.getBean("engScoringService");
	}
	@Test
	public void savaScoringTest() {
		String str = "{\"userNo\":105140,\"proAdress\":\"上海青浦重固营业部\",\"proType\":\"WXQY0002\",\"scopeid\":\"WXLB0002\",\"scope\":3,\"proName\":\"aa\",\"scopeName\":\"线路\"}";
		try {
			this.engScoringService.savaScoring(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void savaMessageReasonTest() {
		String str = "{\"userNo\":105140,\"proAdress\":\"上海青浦重固营业部\",\"proType\":\"WXQY0002\",\"scopeid\":\"WXLB0002\",\"scope\":0,\"proName\":\"aa\",\"scopeName\":\"线路\"}";
		try {
			this.engScoringService.savaMessageReason(str);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	@Test
	public void savaProcWatchDeptTest() {
		String str="{\"deptcode\":\"DP01430\",\"deptid\":108,\"deptname\":\"上海青浦区徐泾营业部\"}";
		try {
			this.engScoringService.savaProcWatchDept(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
