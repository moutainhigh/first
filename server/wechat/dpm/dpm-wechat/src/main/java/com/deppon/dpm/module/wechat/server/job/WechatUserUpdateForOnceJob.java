package com.deppon.dpm.module.wechat.server.job;

import com.deppon.dpm.module.wechat.server.service.IWechatTongxunluService;

/**
 * 首次上线时，执行一次全量更新员工
 * @author 276344
 *
 */
public class WechatUserUpdateForOnceJob {
	IWechatTongxunluService wechatService;


	public void execute() {
		System.out.println("-----首次上线全量更新员工信息-----");
//		wechatService.updateDepponUserAllForOnce();
	}
	
	public void setWechatService(IWechatTongxunluService wechatService) {
		this.wechatService = wechatService;
	}
}
