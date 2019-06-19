package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

public class BaseEntity {

	protected Date createTime;
	
	protected Date updateTime;
	
	public BaseEntity() {
		super();
	}

	public BaseEntity(Date createTime, Date updateTime) {
		super();
		this.createTime = createTime;
		this.updateTime = updateTime;
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
	
}
