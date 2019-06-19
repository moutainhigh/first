package com.deppon.dpm.module.management.shared.domain;

public class CalendarConfigEntity {
	
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 日期
	 */
	private String calDate;
	/**
	 * 是否休
	 */
	private String isrest;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 部门类型（职能）
	 */
	private String deptZn;
	/**
	 * 部门类型（营运）
	 */
	private String deptYy;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalDate() {
		return calDate;
	}

	public void setCalDate(String calDate) {
		this.calDate = calDate;
	}

	public String getIsrest() {
		return isrest;
	}

	public void setIsrest(String isrest) {
		this.isrest = isrest;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDeptZn() {
		return deptZn;
	}

	public void setDeptZn(String deptZn) {
		this.deptZn = deptZn;
	}

	public String getDeptYy() {
		return deptYy;
	}

	public void setDeptYy(String deptYy) {
		this.deptYy = deptYy;
	}

	
	

}
