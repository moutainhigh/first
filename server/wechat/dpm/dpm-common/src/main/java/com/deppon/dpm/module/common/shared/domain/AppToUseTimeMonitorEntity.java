package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

public class AppToUseTimeMonitorEntity {

	// id
	private Integer id;
	
	// 工号
	private String userId;
	
	// 使用的开始时间
	private Date startTime;
	
	// 使用结束的时间
	private Date endTime;
	
	// 设备号
	private String deviceToken;
	
	// 手机系统iphone/android
	private String osType;
	
	// 机型
	private String phoneModel;
	
	// 应用版本号
	private String appVersion;
	
	// 手机系统版本号
	private String osVersion;
	
	// 请求监控的时间
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AppToUseTimeMonitorEntity [userId=" + userId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", deviceToken="
				+ deviceToken + ", osType=" + osType + ", phoneModel="
				+ phoneModel + ", appVersion=" + appVersion + ", osVersion="
				+ osVersion + "]";
	}

}
