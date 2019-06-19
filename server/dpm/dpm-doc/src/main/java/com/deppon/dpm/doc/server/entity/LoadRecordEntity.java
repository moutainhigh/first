package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;

public class LoadRecordEntity implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 工号
	 */
	private String userId;
	/**
	 * 设备号
	 */
	private String deviceId;
	/**
	 * 登陆时间
	 */
	private String loginTime;
	/**
	 * 不一致项  1=工号  2=设备号  0=一致   4=新增
	 */
	private int distinct;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public int getDistinct() {
		return distinct;
	}

	public void setDistinct(int distinct) {
		this.distinct = distinct;
	}
	
	

}
