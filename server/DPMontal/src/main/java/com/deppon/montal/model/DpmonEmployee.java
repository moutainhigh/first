package com.deppon.montal.model;

import java.io.Serializable;

public class DpmonEmployee implements Serializable {

	private static final long serialVersionUID = 114154373681405691L;

	private int id;
	
	private String userId;
	
	private String userName;
	
	private String syscodes;

	public String getSyscodes() {
		return syscodes;
	}

	public void setSyscodes(String syscodes) {
		this.syscodes = syscodes;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
