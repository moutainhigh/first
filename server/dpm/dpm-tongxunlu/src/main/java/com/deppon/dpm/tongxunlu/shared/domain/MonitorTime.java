package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

/**
 * 数据监控实体
 * 监控模块访问时长
 *
 */
public class MonitorTime {

	/**
	 * 用户工号
	 */
	private String empCode;
	/**
	 * 数据监控类型
	 */
	private String monitorType;
	/**
	 * 访问总时长
	 */
	private String totalDuration;
	/**
	 * 访问开始时间
	 */
	private Date beginTime;
	/**
	 * 访问结束时间
	 */
	private Date endTime;
	/**
	 * APP的操作系统
	 */
	private String osType;
	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * set
	 * 
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMonitorType() {
		return monitorType;
	}

	/**
	 * set
	 * 
	 * @param monitorType
	 */
	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTotalDuration() {
		return totalDuration;
	}

	/**
	 * set
	 * 
	 * @param totalDuration
	 */
	public void setTotalDuration(String totalDuration) {
		this.totalDuration = totalDuration;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * set
	 * 
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * get
	 * @return
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * set
	 * @param beginTime
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * get
	 * @return
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * set
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
