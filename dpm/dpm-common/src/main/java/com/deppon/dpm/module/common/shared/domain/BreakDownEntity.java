package com.deppon.dpm.module.common.shared.domain;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 应用崩溃信息实体类
 *
 */
public class BreakDownEntity implements Serializable{

	private static final long serialVersionUID = -5445506940954355687L;
	//工号
	private String empCode;
	//设备类型
	private String osType;
	//系统版本号
	private String version;
	//发生时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date occurTime;
	//原因
	private String reason;

	//getter
	public String getEmpCode() {
		return empCode;
	}
	
	//setter
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	//getter
	public String getOsType() {
		return osType;
	}
	
	//setter
	public void setOsType(String osType) {
		this.osType = osType;
	}
	
	//getter
	public String getVersion() {
		return version;
	}

	//setter
	public void setVersion(String version) {
		this.version = version;
	}
	
	//getter
	public Date getOccurTime() {
		return occurTime;
	}

	//setter
	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	//getter
	public String getReason() {
		return reason;
	}

	//setter
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
