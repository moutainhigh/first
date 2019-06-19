package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 用户功能开关实体
 */
public class UserFuncStatusEntity {

	// id
	private Integer id;
	
	// userId
	private String userId;
	
	// 设备号
	private String deviceToken;
	
	// 开关状态
	private Boolean exceptionMonitorStatus;
	
	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date updateTime;

	// getter
	public Integer getId() {
		return id;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public String getUserId() {
		return userId;
	}

	// setter
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// getter
	public Boolean getExceptionMonitorStatus() {
		return exceptionMonitorStatus;
	}

	// setter
	public void setExceptionMonitorStatus(Boolean exceptionMonitorStatus) {
		this.exceptionMonitorStatus = exceptionMonitorStatus;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	// setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	// getter
	public String getDeviceToken() {
		return deviceToken;
	}

	// setter
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	
}
