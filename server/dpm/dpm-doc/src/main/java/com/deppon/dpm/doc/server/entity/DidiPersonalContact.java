package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;

public class DidiPersonalContact implements Serializable{
	
	private static final long serialVersionUID = -4248150475782303215L;

	private String userId;
	
	private String userTel;
	
	private String createTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
