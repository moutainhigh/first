package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 用户绑定mac信息实体
 */
public class EmpBindMacEntity {

	// id
	private Integer id;
	
	// 工号
	private String empCode;
	
	// 操作系统
	private String osType;
	
	// 手机mac
	private String phoneMac;
	
	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date updateTime;
	
	// 构造器
	public EmpBindMacEntity() {
		super();
	}
	
	public EmpBindMacEntity(String osType, String phoneMac) {
		super();
		this.osType = osType;
		this.phoneMac = phoneMac;
	}

	// getter
	public Integer getId() {
		return id;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public String getEmpCode() {
		return empCode;
	}

	// setter
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	// getter
	public String getOsType() {
		return osType;
	}

	// setter
	public void setOsType(String osType) {
		this.osType = osType;
	}

	// getter
	public String getPhoneMac() {
		return phoneMac;
	}

	// setter
	public void setPhoneMac(String phoneMac) {
		this.phoneMac = phoneMac;
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
	
}
