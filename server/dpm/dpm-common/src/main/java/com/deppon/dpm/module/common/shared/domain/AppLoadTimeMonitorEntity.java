package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

public class AppLoadTimeMonitorEntity extends PhoneInfoBaseEntity{

	private Integer id;
	
	private String userId;
	
	// 应用id
	private Integer appId;
	
	// 加载时长（毫秒）
	private Integer loadTime;
	
	public AppLoadTimeMonitorEntity() {
		super();
	}
	
	public AppLoadTimeMonitorEntity(String userId, Integer appId, Integer loadTime,
			String deviceToken, String osType, String osVersion, String phoneModel, 
			String appVersion, Date createTime, Date updateTime) {
		super(deviceToken, osType, osVersion, phoneModel, appVersion, createTime, updateTime);
		this.userId = userId;
		this.appId = appId;
		this.loadTime = loadTime;
	}

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

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(Integer loadTime) {
		this.loadTime = loadTime;
	}

	@Override
	public String toString() {
		return "AppLoadTimeMonitorEntity [userId=" + userId + ", appId="
				+ appId + ", loadTime=" + loadTime + ", deviceToken="
				+ deviceToken + ", osType=" + osType + ", osVersion="
				+ osVersion + ", phoneModel=" + phoneModel + ", appVersion="
				+ appVersion + "]";
	}

}
