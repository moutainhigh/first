package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 268101 时间实体类
 *
 */
public class TimeEntity implements Serializable,Comparable<TimeEntity> {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 8005661031928915336L;

	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * @return 开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime 开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return 结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime 结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	//时间对比
	public int compareTo(TimeEntity o) {
		return this.getStartTime().compareTo(o.getStartTime());
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 判断boolean
	 */
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
	
}
