package com.deppon.dpm.tongxunlu.server.job;

import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;

public class MsgCentreRunnable implements Runnable{

		private JPushParam jPushParam;
		
		private IJPushNewService jPushNewService;
		
		public MsgCentreRunnable(JPushParam jPushParam,
				IJPushNewService jPushNewService) {
			super();
			this.jPushParam = jPushParam;
			this.jPushNewService = jPushNewService;
		}

		@Override
		public void run() {
			// 保存推送记录到消息中心
			jPushParam.setPushConditionValue(jPushParam.getUserIds());
			jPushNewService.saveToMsgCentre(jPushParam, 0);
		}
		
	}