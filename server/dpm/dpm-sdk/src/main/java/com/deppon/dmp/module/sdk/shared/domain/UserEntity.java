package com.deppon.dmp.module.sdk.shared.domain;

import java.io.Serializable;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 2942952228584484194L;

	private long id;
	
	private String userId;
	
	private String token;
	
	private String deviceType;
	
	private String sysCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSysCode() {
		return sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(this == o)
			return true;
		if(this.getClass() != o.getClass())
			return false;
		UserEntity user = (UserEntity) o;
		return user.getUserId().equals(this.getUserId());
	}
	
	@Override
	public int hashCode() {
		return this.getUserId().hashCode();
	}
	
}
