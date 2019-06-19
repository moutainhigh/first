package com.deppon.dpm.module.common.shared.vo;

/**
 * 模块访问数据查询VO
 * 
 */
public class ModuleAccessVo {

	/**
	 * 查询开始时间
	 */
	private String beginDate;
	/**
	 * 查询结束时间
	 */
	private String endDate;
	/**
	 * 查询时间格式
	 */
	private String dateFormat;
	/**
	 * 模块类型
	 */
	private String monitorType;
	/**
	 * 查询类型
	 * 1:返回时间区间内的总人数、总次数
	 * 2:返回时间区间内的vp用户访问列表
	 * 3:返回时间区间内的vp闪退列表
	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

}
