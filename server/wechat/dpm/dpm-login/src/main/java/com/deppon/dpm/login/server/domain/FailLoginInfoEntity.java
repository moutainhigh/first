package com.deppon.dpm.login.server.domain;

import java.util.Date;

/**
 *登录用户名密码验证失败记录实体 
 *
 */
public class FailLoginInfoEntity {
	//工号
	private String empCode;
	//最后一次登录失败的时间
	private Date lastErrorLoginTime;
	//错误次数
	private int errorCount;
	//被锁定时间
	private Date lockedTime;
	//更新时间
	private Date updateTime;

	//getter
	public String getEmpCode() {
		return empCode;
	}

	//setter
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	//getter
	public int getErrorCount() {
		return errorCount;
	}

	//setter
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	//getter
	public Date getLastErrorLoginTime() {
		return lastErrorLoginTime;
	}
	
	//setter
	public void setLastErrorLoginTime(Date lastErrorLoginTime) {
		this.lastErrorLoginTime = lastErrorLoginTime;
	}

	//getter
	public Date getLockedTime() {
		return lockedTime;
	}

	//setter
	public void setLockedTime(Date lockedTime) {
		this.lockedTime = lockedTime;
	}

	//getter
	public Date getUpdateTime() {
		return updateTime;
	}

	//setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
