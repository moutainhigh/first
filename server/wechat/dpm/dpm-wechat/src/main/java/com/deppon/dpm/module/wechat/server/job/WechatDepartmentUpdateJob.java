package com.deppon.dpm.module.wechat.server.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.wechat.server.service.IWechatTongxunluService;

/**
 * 定时更新部门信息（每天08：00和24：00执行）
 * @author 276344
 *
 */
public class WechatDepartmentUpdateJob {
	IWechatTongxunluService wechatService;
	private static Logger logger  = LoggerFactory.getLogger(WechatDepartmentUpdateJob.class);
	public void execute() {
		logger.info("wechat-定时更新部门信息Job");
		System.out.println("定时更新部门信息");
		wechatService.updateDepponDepartmentAll();
	}
	
	public void setWechatService(IWechatTongxunluService wechatService) {
		this.wechatService = wechatService;
	}
}
