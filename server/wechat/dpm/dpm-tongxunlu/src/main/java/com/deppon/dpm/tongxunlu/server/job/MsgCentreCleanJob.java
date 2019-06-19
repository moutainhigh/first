package com.deppon.dpm.tongxunlu.server.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.tongxunlu.server.service.IJpushMsgCentreService;


public class MsgCentreCleanJob {
	
	private static final Logger LOG = LoggerFactory.getLogger(MsgCentreCleanJob.class);
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private IJpushMsgCentreService msgCentreService;
	
	/**
	 * 清理2周之前的数据
	 */
	public void execute() {
		LOG.info("开始清理消息中心..." + DATE_FORMAT.format(new Date()));
		System.out.println("开始清理消息中心..." + DATE_FORMAT.format(new Date()));
		try {
			msgCentreService.cleanExpireData();
		} catch (Exception e) {
			LOG.error("清理消息中心出错!!!",e);
		}
	}

	public void setMsgCentreService(IJpushMsgCentreService msgCentreService) {
		this.msgCentreService = msgCentreService;
	}
	
	
}