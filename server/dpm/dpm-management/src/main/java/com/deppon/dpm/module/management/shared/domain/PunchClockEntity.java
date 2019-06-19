package com.deppon.dpm.module.management.shared.domain;

import java.util.Date;

/**
 * 考勤记录表
 * 
 * @author 500612
 *
 */
public class PunchClockEntity {

	/**
	 * 主键
	 * 
	 */

	private int id;
	/**
	 * 打卡人工号
	 */
	private String empCode;

	/**
	 * 上班打卡时间
	 */
	private String goWorkTime;
	/**
	 * 下班打卡时间
	 */
	private String offWorkTime;

	/**
	 * 显示日期
	 */
	private String clockTime;

	/**
	 * 上班打卡表情
	 */
	private String goMoodScore;
	/**
	 * 下班打卡表情
	 */
	private String offMoodScore;
	   
	private Date createTime;
	
	private Date updateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getGoWorkTime() {
		return goWorkTime;
	}
	public void setGoWorkTime(String goWorkTime) {
		this.goWorkTime = goWorkTime;
	}
	public String getOffWorkTime() {
		return offWorkTime;
	}
	public void setOffWorkTime(String offWorkTime) {
		this.offWorkTime = offWorkTime;
	}
	public String getClockTime() {
		return clockTime;
	}
	public void setClockTime(String clockTime) {
		this.clockTime = clockTime;
	}
	public String getGoMoodScore() {
		return goMoodScore;
	}
	public void setGoMoodScore(String goMoodScore) {
		this.goMoodScore = goMoodScore;
	}
	public String getOffMoodScore() {
		return offMoodScore;
	}
	public void setOffMoodScore(String offMoodScore) {
		this.offMoodScore = offMoodScore;
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
