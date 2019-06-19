package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 领导访问情况查询的实体类
 */
public class DataMonitorForTongjiEntity {
	// id
	private Integer id;
	// 工号
	private String empCode;
	// 设备类型
	private String osType;
	// 监控号
	private Integer monitorType;
	// 访问时间
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date accessTime;
	// 起始时间
	private Date startTime;
	// 结束时间
	private Date endTime;
	// 工作等级
	private String joblevel;
	// 姓名
	private String empName;
	// 模块名称
	private String moduleName;

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
	public Integer getMonitorType() {
		return monitorType;
	}
	// setter
	public void setMonitorType(Integer monitorType) {
		this.monitorType = monitorType;
	}
	// getter
	public Date getAccessTime() {
		return accessTime;
	}
	// setter
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	// getter
	public Date getStartTime() {
		return startTime;
	}
	// setter
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	// getter
	public Date getEndTime() {
		return endTime;
	}
	// setter
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	// getter
	public String getJoblevel() {
		return joblevel;
	}
	// setter
	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}
	// getter
	public String getEmpName() {
		return empName;
	}
	// setter
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	// getter
	public String getModuleName() {
		return moduleName;
	}
	// setter
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
}
