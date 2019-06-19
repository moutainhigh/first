package com.deppon.dpm.module.management.shared.domain;

import java.util.Date;
import java.util.List;

/**
 * 设备对应APP应用版本号信息
 * 
 */
public class ApplyDevice {

	/**
	 * 主键(自增长)
	 */
	private int appDeviceId;
	/**
	 * 设备号
	 */
	private String deviceToken;
	/**
	 * APP应用id
	 */
	private int applyStoreId;
	/**
	 * 设备对应的APP应用版本号
	 */
	private String versionType;
	/**
	 * APP的操作系统
	 */
	private String osType;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * List
	 */
	private List<Integer> appIdList;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getAppDeviceId() {
		return appDeviceId;
	}

	/**
	 * set
	 * 
	 * @param appDeviceId
	 */
	public void setAppDeviceId(int appDeviceId) {
		this.appDeviceId = appDeviceId;
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
	public int getApplyStoreId() {
		return applyStoreId;
	}

	/**
	 * set
	 * 
	 * @param applyStoreId
	 */
	public void setApplyStoreId(int applyStoreId) {
		this.applyStoreId = applyStoreId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getVersionType() {
		return versionType;
	}

	/**
	 * set
	 * 
	 * @param versionType
	 */
	public void setVersionType(String versionType) {
		this.versionType = versionType;
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
	public String getRemark() {
		return remark;
	}

	/**
	 * set
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * set
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<Integer> getAppIdList() {
		return appIdList;
	}

	/**
	 * set
	 * 
	 * @param appIdList
	 */
	public void setAppIdList(List<Integer> appIdList) {
		this.appIdList = appIdList;
	}

}
