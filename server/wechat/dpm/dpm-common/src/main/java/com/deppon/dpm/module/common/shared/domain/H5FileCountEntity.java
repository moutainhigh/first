package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 *H5资源文件对比的实体类（专为android使用） 
 */
public class H5FileCountEntity {
	// 应用编号
	private Integer applyCode;
	// 文件数量
	private Integer count;
	// 修改时间
	private Date updateTime;

	// getter
	public Integer getApplyCode() {
		return applyCode;
	}
	// setter
	public void setApplyCode(Integer applyCode) {
		this.applyCode = applyCode;
	}
	// getter
	public Integer getCount() {
		return count;
	}
	// setter
	public void setCount(Integer count) {
		this.count = count;
	}
	// getter
	public Date getUpdateTime() {
		return updateTime;
	}
	// setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	// constructor
	public H5FileCountEntity(Integer applyCode, Integer count, Date updateTime) {
		super();
		this.applyCode = applyCode;
		this.count = count;
		this.updateTime = updateTime;
	}
}
