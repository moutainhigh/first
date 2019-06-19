package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 手势密码实体类
 *
 */
public class GestureEntity {

	// 工号
	private String userId;
	
	// 手势密码开启状态
	private String gustureStatus;
	
	// 手势密码
	private String gusturePassword;
	
	// 更新时间
	private Date updateTime;

	// getter
	public String getUserId() {
		return userId;
	}

	// setter
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// getter
	public String getGustureStatus() {
		return gustureStatus;
	}

	// setter
	public void setGustureStatus(String gustureStatus) {
		this.gustureStatus = gustureStatus;
	}

	// getter
	public String getGusturePassword() {
		return gusturePassword;
	}

	//setter
	public void setGusturePassword(String gusturePassword) {
		this.gusturePassword = gusturePassword;
	}

	// getter
	public Date getUpdateTime() {
		return updateTime;
	}

	// setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
