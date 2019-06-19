package com.deppon.montal.util.redis.util;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TaskListener implements ServletContextListener {

	private Timer timer = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		/**
		 * 设置任务计划，启动和间隔时间
		 * 时间ms
		 * 5m = 5*60*1000(ms)
		 */
		timer.schedule(new TaskServlet(),0,Long.valueOf(JedisUtil.getValue("redis.employee.syn")).longValue());
	}
}
