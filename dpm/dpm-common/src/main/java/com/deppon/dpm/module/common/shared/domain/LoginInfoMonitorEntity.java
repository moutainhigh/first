package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

public class LoginInfoMonitorEntity {
	
	private Integer id;
	
	private String userId;
	
	private String location;
	
	private String osType;
	
	private String deviceToken;
	
	private String appVersion;
	
	private String phoneModel;
	
	private String osVersion;
	
	private String phoneMac;
	
	private Date loginTime;
	
	private Date createTime;
	
	private String accessIp;
	
	public String getAccessIp() {
		return accessIp;
	}

	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getPhoneMac() {
		return phoneMac;
	}

	public void setPhoneMac(String phoneMac) {
		this.phoneMac = phoneMac;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "LoginInfoMonitorEntity [userId=" + userId + ", location="
				+ location + ", osType=" + osType + ", deviceToken="
				+ deviceToken + ", appVersion=" + appVersion + ", phoneModel="
				+ phoneModel + ", osVersion=" + osVersion + ", phoneMac="
				+ phoneMac + ", loginTime=" + loginTime + ", accessIp=" + accessIp + "]";
	}
}
