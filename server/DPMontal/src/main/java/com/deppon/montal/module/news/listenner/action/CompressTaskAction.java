package com.deppon.montal.module.news.listenner.action;


import org.apache.log4j.Logger;


import com.deppon.dpm.sendMsg.listener.JpushTaskListenner;
import com.deppon.montal.module.news.service.ImageCompressJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class CompressTaskAction implements Job{
	private Logger logger = Logger.getLogger(CompressTaskAction.class);
	//异常数据最多推送次数 3次
	private static final int SENDMSGCOUNT = 3;
	ImageCompressJob imageJob = ImageCompressJob.getInstance();
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("开始执行调度("+JpushTaskListenner.PUSHJOB_NAME+")");
		imageJob.compressJob();
	}
	
}
