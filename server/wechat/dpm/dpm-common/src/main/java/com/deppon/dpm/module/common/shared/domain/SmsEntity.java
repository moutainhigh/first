package com.deppon.dpm.module.common.shared.domain;

/**
 * 短信开关实体
 *
 */
public class SmsEntity {
	// id
	private Integer id;
	
	// 工号
	private String userId;
	
	// 设备号
	private String deviceToken;
	
	// 短信开关
	private String smsStatus;

	// getter
	public Integer getId() {
		return id;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public String getUserId() {
		return userId;
	}

	// setter
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// getter
	public String getDeviceToken() {
		return deviceToken;
	}

	// setter
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	// getter
	public String getSmsStatus() {
		return smsStatus;
	}

	// setter
	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}
	
}
