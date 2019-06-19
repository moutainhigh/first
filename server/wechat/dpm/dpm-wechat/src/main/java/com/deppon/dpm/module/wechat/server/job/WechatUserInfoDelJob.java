package com.deppon.dpm.module.wechat.server.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.wechat.server.service.IWechatTongxunluService;
/**
 * 每天删除离职人员产信息
 * @author 276344
 *
 */
public class WechatUserInfoDelJob {
	IWechatTongxunluService wechatService;

	private static Logger logger  = LoggerFactory.getLogger(WechatUserInfoDelJob.class);
	public void execute() {
		logger.info("wechat-定时更新员工信息Job");
		System.out.println("定时删除员工信息");
		wechatService.deleteUserInfo();
	}
	
	public void setWechatService(IWechatTongxunluService wechatService) {
		this.wechatService = wechatService;
	}

}
