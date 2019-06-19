package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

public class JPushRegistBindEntity {
	
	private String registId;

	private String userId;
	
	private String tag;
	
	private Date createTime;
	
	private Date updateTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegistId() {
		return registId;
	}

	public void setRegistId(String registId) {
		this.registId = registId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "JPushRegistBindEntity [registId=" + registId + ", userId="
				+ userId + ", tag=" + tag + "]";
	}
	
}
