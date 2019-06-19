package com.deppon.dpm.module.wfs.server.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.deppon.dpm.module.wfs.server.dao.impl.WorkItemsListDao;

public class TaskListener implements ServletContextListener {

	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		event.getServletContext().log("服务器加载完毕......");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();
		application.log("服务器加载开始......");
		ApplicationContext cxt = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
		WorkItemsListDao workdao = (WorkItemsListDao)cxt.getBean("workItemsListDao");
		workdao.syncWorkflow();
		
//		timer = new Timer(true);
//		/**
//		 * 设置任务计划，启动和间隔时间
//		 * 时间ms
//		 * 5m = 5*60*1000(ms)
//		 */
//		timer.schedule(new TaskServlet(),0,Long.valueOf(JedisUtil.getValue("redis.employee.syn")).longValue());
	}
}
