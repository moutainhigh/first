package com.deppon.dpm.module.projecttools.server.util;

import com.deppon.dpm.module.projecttools.server.service.ITaskLogService;
import com.deppon.dpm.module.projecttools.shared.domain.TaskLogEntity;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
/**
 * 任务跟踪日志 新增日志时日志保存成功后发送邮件  异步调用
 * 2015-08-11
 * @author gcl
 */
public class TaskMonitor implements Runnable {
	// 任务跟踪日志 service
    public ITaskLogService service; 
    // 日志信息
    public TaskLogEntity log;
    // 任务分配service
    // 任务分配信息
    public TasksEntity task;
    
    // 项目变更 审批成功后提醒人
    public String[] toEmail;
    //主题
    public String title;
    //邮件内容
    public String info;
    
    @Override
    public void run() {
    	//发送日志
    	if(log != null) {
    		//邮件发送
    		service.mailSend(log);
    	} else if (task != null) {
    		// 任务分配发送邮件
    		service.mailSendTask(task);
    	} else if (toEmail != null && toEmail.length > 0) {
    		service.mailToExecutor(toEmail , title,info);
    	}
        
    }

}
