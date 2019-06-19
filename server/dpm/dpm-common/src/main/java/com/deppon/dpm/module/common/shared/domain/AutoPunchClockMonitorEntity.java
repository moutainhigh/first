package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 自动打卡监控实体
 */
public class AutoPunchClockMonitorEntity {

	// id
	private Integer id;
	
	// 工号
	private String empCode;
	
	// 打卡状态  0：失败  1：成功
	private Boolean status;
	
	// 错误信息
	private String errorMsg;
	
	// 手机系统
	private String osType;
	
	// 机型
	private String phoneModel;
	
	// 系统版本
	private String osVersion;
	
	// 应用版本
	private String appVersion;
	
	// 经度
	private String longitude;
	
	// 纬度
	private String Latitude;
	
	// 是否在范围内
	private Boolean within;
	
	// 是否是自动打卡
	private Boolean auto;
	
	// 网络 3g 4g wifi
	private String network;
	
	private String ip;
	
	// 创建时间
	private Date createTime;
	
	/*****分页属性******/
	private int page;
	
	private int rows;
	
	// getter
	public int getPage() {
		return page;
	}

	// setter
	public void setPage(int page) {
		this.page = page;
	}

	// getter
	public int getRows() {
		return rows;
	}

	// setter
	public void setRows(int rows) {
		this.rows = rows;
	}
	/***************/

	// getter
	public Integer getId() {
		return id;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public String getEmpCode() {
		return empCode;
	}

	// setter
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	// getter
	public Boolean getStatus() {
		return status;
	}

	// setter
	public void setStatus(Boolean status) {
		this.status = status;
	}

	// getter
	public String getErrorMsg() {
		return errorMsg;
	}

	// setter
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	// getter
	public Date getCreateTime() {
		return createTime;
	}

	// setter
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// getter
	public String getOsType() {
		return osType;
	}

	// setter
	public void setOsType(String osType) {
		this.osType = osType;
	}

	// getter
	public String getPhoneModel() {
		return phoneModel;
	}

	// setter
	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	// getter
	public String getOsVersion() {
		return osVersion;
	}

	// setter
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	// getter
	public String getAppVersion() {
		return appVersion;
	}

	// setter
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	// getter
	public String getLongitude() {
		return longitude;
	}

	// setter
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	// getter
	public String getLatitude() {
		return Latitude;
	}

	// setter
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	// getter
	public Boolean getWithin() {
		return within;
	}

	// setter
	public void setWithin(Boolean within) {
		this.within = within;
	}

	// getter 
	public Boolean getAuto() {
		return auto;
	}

	// setter
	public void setAuto(Boolean auto) {
		this.auto = auto;
	}
	
	// getter
	public String getNetwork() {
		return network;
	}

	// setter
	public void setNetwork(String network) {
		this.network = network;
	}

	// getter
	public String getIp() {
		return ip;
	}

	// setter
	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "AutoPunchClockMonitorEntity [empCode=" + empCode + ", status="
				+ status + ", errorMsg=" + errorMsg + ", osType=" + osType
				+ ", phoneModel=" + phoneModel + ", osVersion=" + osVersion
				+ ", appVersion=" + appVersion + ", longitude=" + longitude
				+ ", Latitude=" + Latitude + ", within=" + within + ", auto="
				+ auto + ", network=" + network + ", ip=" + ip + "]";
	}

}
