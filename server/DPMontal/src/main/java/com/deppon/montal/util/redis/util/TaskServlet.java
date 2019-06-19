package com.deppon.montal.util.redis.util;

import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.deppon.montal.util.redis.service.impl.InitAllUsers;
import com.deppon.montal.util.redis.service.impl.InitDictEntry;
import com.deppon.montal.util.redis.service.impl.InitWorkflowInfo;

/**
 * 定时任务
 * 定时操作om_employee
 * 权限的定时操作
 */
public class TaskServlet extends TimerTask {
	
	private static Logger logger = null;
	
	static{
		logger = Logger.getLogger(TaskServlet.class);
	}
	
	@Override
	public void run() {
		
		logger.info("---------------------->开始初始化用户数据和权限的数据");
		
		/**
		 * 初始化用户信息和权限信息
		 */
		try{
			InitAllUsers.initAllUser2Redis();
//			InitAllUsers.initAllRoleJobname();
//			InitAllUsers.initAllDpmonEmployee();
//			InitAllUsers.synDpmonEmployee();
//			InitAllUsers.synRole();
			InitWorkflowInfo.initAllWorkflow2Redis();
			InitWorkflowInfo.synWorkflowInfo();
			InitDictEntry.initAllDictEntry2Redis();
			InitDictEntry.synDictEntry();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		logger.info("---------------------->初始化完毕");
	}
}
