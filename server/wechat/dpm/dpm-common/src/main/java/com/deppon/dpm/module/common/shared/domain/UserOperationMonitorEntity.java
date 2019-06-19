package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

public class UserOperationMonitorEntity {

	// id
	private Integer id;
	
	// userId
	private String userId;
	
	// 操作轨迹
	private String operation;
	
	// 手机类型
	private String osType;
	
	// 应用版本
	private String appVersion;
	
	// 设备号
	private String deviceToken;
	
	// 手机型号
	private String phoneModel;
	
	// 手机系统版本
	private String osVersion;
	
	// mac地址
	private String phoneMac;
	
	// 创建时间
	private Date createTime;
	
	/********分页及时间条件参数********/
	// page
	private Integer page = 0;
	
	private Integer rows = 10;
	
	// 查询起始时间
	private Date startTime;
	
	// 结束时间
	private Date endTime;
	
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "UserOperationMonitorEntity [userId=" + userId + ", operation="
				+ operation + ", osType=" + osType + ", appVersion="
				+ appVersion + ", deviceToken=" + deviceToken + ", phoneModel="
				+ phoneModel + ", osVersion=" + osVersion + ", phoneMac="
				+ phoneMac + "]";
	}
	
}
