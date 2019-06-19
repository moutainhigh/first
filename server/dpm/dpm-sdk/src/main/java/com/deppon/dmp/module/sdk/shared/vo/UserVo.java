package com.deppon.dmp.module.sdk.shared.vo;

import java.io.Serializable;
import java.util.List;

import com.deppon.dmp.module.sdk.shared.domain.UserEntity;

public class UserVo implements Serializable {
	
	private static final long serialVersionUID = -7737582127921138892L;

	private UserEntity entity;
	
	private List<UserEntity> userList;

	public UserEntity getEntity() {
		return entity;
	}

	public void setEntity(UserEntity entity) {
		this.entity = entity;
	}

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

}
