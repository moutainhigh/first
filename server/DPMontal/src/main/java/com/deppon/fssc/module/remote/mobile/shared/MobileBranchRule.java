package com.deppon.fssc.module.remote.mobile.shared;

/**
 * 
 * 手机客户端回退分支规则
 *@author 陈平樊
 * @date 2013-11-16 下午4:24:57
 * @since
 * @version
 */
public class MobileBranchRule {

	//活动定义ID
	private String activityDefId;
	//活动定义名称
	private String activityName;
	
	public String getActivityDefId() {
		return activityDefId;
	}
	public void setActivityDefId(String activityDefId) {
		this.activityDefId = activityDefId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
}
