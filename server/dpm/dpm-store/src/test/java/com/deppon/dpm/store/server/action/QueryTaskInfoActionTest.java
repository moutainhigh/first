package com.deppon.dpm.store.server.action;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.store.server.service.IQueryTaskInfoService;
import com.deppon.dpm.store.server.service.IStoreTaskService;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;

import junit.framework.TestCase;
/**
 * 
 * @author RY
 *
 */
public class QueryTaskInfoActionTest extends TestCase{
		/**
		 * service
		 */
		// 查询任务信息service
		private IStoreTaskService storeTaskService;
		// 查询所有部门信息service
		private ISelectAllDeptService selectAllDeptService;
		// 注入service
		private IQueryTaskInfoService queryTaskInfoService;
		/**
		 * spring 应用容器
		 */
		protected ApplicationContext appContext = null;
		//action
		QueryTaskInfoAction queryTaskInfoAction;
		@Override
		protected void setUp() throws Exception {
			// TODO Auto-generated method stub
			super.setUp();
			queryTaskInfoAction= new QueryTaskInfoAction();
			appContext = new ClassPathXmlApplicationContext(
					"com/deppon/dpm/store/server/META-INF/spring.xml");
			storeTaskService = (IStoreTaskService) appContext.getBean("storeTaskService");
			selectAllDeptService=(ISelectAllDeptService) appContext.getBean("selectAllDeptService"); 
			queryTaskInfoService= (IQueryTaskInfoService) appContext.getBean("queryTaskInfoService");
		}
		@Test
		public void testallMethod() throws Exception {
			System.out.println(storeTaskService);//
			System.out.println(selectAllDeptService);//
			System.out.println(queryTaskInfoService);//
			
		}
}
