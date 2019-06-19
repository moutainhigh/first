package com.deppon.dpm.module.wechat.shared.dto;

import java.util.Date;

public class UserDto {
	//员工id
	private String userId;
	//员工姓名
	private String name;
	//所属部门
	private String department;
	//创建时间
	private Date createTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", department="
				+ department + ", createTime=" + createTime + "]";
	}

    

}
