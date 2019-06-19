package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 延伸类
 * 
 * @author 231586
 * 
 */
public class EmpExtensionEntity {
	/**
	 * id
	 */
	private int id;
	/**
	 * 工号
	 */
	private String empCode;
	/**
	 * 设备号
	 */
	private String deviceToken;
	/**
	 * 状态
	 */
	private String empStatus;
	/**
	 * 更新时间
	 */
	private String updateTime;
	/**
	 * 登录时间
	 */
	private Date loginTime;
	/**
	 * 是否踢出人
	 */
	private String isKickOff;
	/**
	 * 设备类型
	 */
	private String osType;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 地址
	 */
	private String location;
	/**
	 * 个人头像
	 */
	private String pictPath;
	
	/**
	 * 手机机型
	 */
	private String phoneModel;
	/**
	 * 操作系统版本号
	 */
	private String osVersion;
	/**
	 * 手机mac地址
	 */
	private String phoneMac;
	/**
	 * 应用版本号
	 */
	private String appVersion;
	
	/**
	 * geetter
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * setter
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * set
	 * 
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * set
	 * 
	 * @param deviceToken
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpStatus() {
		return empStatus;
	}

	/**
	 * set
	 * 
	 * @param empStatus
	 */
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * set
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIsKickOff() {
		return isKickOff;
	}

	/**
	 * set
	 * 
	 * @param isKickOff
	 */
	public void setIsKickOff(String isKickOff) {
		this.isKickOff = isKickOff;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * set
	 * 
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * set
	 * 
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * set
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPictPath() {
		return pictPath;
	}

	/**
	 * set
	 * 
	 * @param pictPath
	 */
	public void setPictPath(String pictPath) {
		this.pictPath = pictPath;
	}
	
	/**
	 * get
	 * @return
	 */
	public String getPhoneModel() {
		return phoneModel;
	}
	
	/**
	 * set
	 * @param phoneModel
	 */
	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}
	/**
	 * get
	 * @return
	 */
	public String getOsVersion() {
		return osVersion;
	}
	/**
	 * set
	 * @param osVersion
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	/**
	 * get
	 * @return
	 */
	public String getPhoneMac() {
		return phoneMac;
	}
	/**
	 * set
	 * @param phoneMac
	 */
	public void setPhoneMac(String phoneMac) {
		this.phoneMac = phoneMac;
	}
	
	/**
	 * getter
	 * @return
	 */
	public String getAppVersion() {
		return appVersion;
	}
	
	/**
	 * setter
	 * @param appVersion
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	/**
	 * getter
	 * @return
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	
	/**
	 * setter
	 * @param loginTime
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * Constructor
	 * 
	 * @param empCode
	 * @param deviceToken
	 * @param empStatus
	 * @param updateTime
	 * @param isKickOff
	 * @param osType
	 * @param longitude
	 * @param latitude
	 * @param location
	 */
	public EmpExtensionEntity(String empCode, String deviceToken,
			String empStatus, String updateTime, String isKickOff,
			String osType, String longitude, String latitude, String location) {
		super();
		this.empCode = empCode;
		this.deviceToken = deviceToken;
		this.empStatus = empStatus;
		this.updateTime = updateTime;
		this.isKickOff = isKickOff;
		this.osType = osType;
		this.longitude = longitude;
		this.latitude = latitude;
		this.location = location;
	}

	/**
	 * Constructor
	 * 
	 * @param updateTime
	 * @param location
	 */
	public EmpExtensionEntity(String updateTime, String location) {
		super();
		this.updateTime = updateTime;
		this.location = location;
	}
	
	/**
	 * Constructor
	 * 
	 * @param osType
	 * @param longitude
	 * @param latitude
	 * @param location
	 * @param phoneModel
	 * @param osVersion
	 * @param phoneMac
	 */
	public EmpExtensionEntity(String osType, String longitude, String latitude, String location, 
			String phoneModel, String osVersion, String phoneMac, String appVersion) {
		super();
		this.osType = osType;
		this.longitude = longitude;
		this.latitude = latitude;
		this.location = location;
		this.phoneModel = phoneModel;
		this.osVersion = osVersion;
		this.phoneMac = phoneMac;
		this.appVersion = appVersion;
	}

	/**
	 * Constructor
	 */
	public EmpExtensionEntity() {
	}
}
