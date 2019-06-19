package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 手机信息映射实体
 */
public class PhoneInfoBaseEntity extends BaseEntity{
	
	// 设备号
	protected String deviceToken;

	// 操作类型  android/iphone
	protected String osType;
	
	// 操作系统版本
	protected String osVersion;
	
	// 机型
	protected String phoneModel;

	// 应用版本号
	protected String appVersion;
	
	public PhoneInfoBaseEntity() {
		super();
	}

	public PhoneInfoBaseEntity(String deviceToken, String osType,
			String osVersion, String phoneModel, String appVersion,
			Date createTime, Date updateTime) {
		super(createTime, updateTime);
		this.deviceToken = deviceToken;
		this.osType = osType;
		this.osVersion = osVersion;
		this.phoneModel = phoneModel;
		this.appVersion = appVersion;
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

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
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
	
}
