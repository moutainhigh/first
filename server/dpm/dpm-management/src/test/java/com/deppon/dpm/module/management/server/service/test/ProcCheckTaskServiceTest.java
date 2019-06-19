package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.IProcCheckTaskService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class ProcCheckTaskServiceTest  extends JunitTest{
	/** 
	* @Fields taskService 
	*/ 
	private IProcCheckTaskService taskService;
	
	private ApplicationContext context;
	
	
	/**
	 * 执行测试方法之前调用
	 */
	@Before
	public void setUp() throws Exception {
		//实例化spring 应用容器
		context = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		//获取tpushNewsService实例
		taskService = (IProcCheckTaskService) context.getBean("checkTaskService");
	}
	
	@Test
	public void queryTaskCount() {
		String empNo="066678";
		int retInt = 0;
		retInt = taskService.queryTaskCount(empNo);
		System.out.println("==========retInt=>"+retInt);
	}
	
	@Test
	public void saveCheckTask(){
		String strJson="";
		taskService.saveCheckTask(strJson);
	}

	public IProcCheckTaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(IProcCheckTaskService taskService) {
		this.taskService = taskService;
	}	
}
