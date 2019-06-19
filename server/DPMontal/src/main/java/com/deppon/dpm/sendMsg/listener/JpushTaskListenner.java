package com.deppon.dpm.sendMsg.listener;

import java.text.ParseException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import com.deppon.dpm.sendMsg.TaskService.JpushTaskAction;
import com.deppon.dpm.sendMsg.quartz.QuartzManager;

public class JpushTaskListenner implements ServletContextListener {
	private Logger logger = Logger.getLogger(JpushTaskListenner.class);
	// 调度时间间隔 分钟
	public static final int INTERVAL = 30;
	public static final String PUSHJOB_NAME = "pushjob_DPMontal";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					logger.info("延迟启动调度：添加推送调度(" + PUSHJOB_NAME + ")");
					Thread.sleep(JpushTaskListenner.INTERVAL * 60 * 1000);
					QuartzManager.addJob(PUSHJOB_NAME, JpushTaskAction.class,
							INTERVAL * 60);
				} catch (InterruptedException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				} catch (SchedulerException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				} catch (ParseException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
			}
		});
		thread.start();

	}

}
