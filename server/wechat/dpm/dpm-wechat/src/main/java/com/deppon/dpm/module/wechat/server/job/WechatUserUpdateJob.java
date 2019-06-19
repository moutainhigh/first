package com.deppon.dpm.module.wechat.server.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.wechat.server.service.IWechatTongxunluService;

/**
 * 定时更新工信息(每天08：15 和 24：15执行)
 * @author 276344
 *
 */
public class WechatUserUpdateJob {
	IWechatTongxunluService wechatService;
	private static Logger logger  = LoggerFactory.getLogger(WechatUserUpdateJob.class);
	
	public void execute() {
		logger.info("wechat-定时删除员工信息Job");
		System.out.println("-----定时更新员工信息-----");
		wechatService.updateDepponUserAll();
	}
	
	public void setWechatService(IWechatTongxunluService wechatService) {
		this.wechatService = wechatService;
	}
	
}
