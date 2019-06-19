package com.deppon.dpm.module.wechat.server.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.wechat.server.service.IWechatTongxunluService;

/**
 * 每天定时将部门和人员同步结果发送给相关人员job
 * @author 276344
 *
 */
public class WechatMessageSendJob {
	IWechatTongxunluService wechatService;
	private static Logger logger  = LoggerFactory.getLogger(WechatMessageSendJob.class);
	public void execute() {
		logger.info("wechat-定时发送同步结果Job");
		System.out.println("开始发送同步结果消息");
		wechatService.sendMessage(0);//部门同步结果
		wechatService.sendMessage(1);//员工同步结果
	}
	
	public void setWechatService(IWechatTongxunluService wechatService) {
		this.wechatService = wechatService;
	}
}
