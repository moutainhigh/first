package com.deppon.dpm.module.management.shared.domain;

/**
 * @author ccf
 * 
 *         QueryTheaterInfoRequset 实体
 */
public class QueryTheaterInfoRequset {
	/**
	 * 分页
	 */
	private int limit;
	/**
	 * start 开始
	 */
	private int start;
	/**
	 * taskType
	 */
	private int taskType;
	/**
	 * dealUserCode
	 */
	private String dealUserCode;

	/**
	 * @return 分页
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            分页
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return 开始
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            开始
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return taskType
	 */
	public int getTaskType() {
		return taskType;
	}

	/**
	 * @param taskType
	 *            taskType
	 */
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public String getDealUserCode() {
		return dealUserCode;
	}

	public void setDealUserCode(String dealUserCode) {
		this.dealUserCode = dealUserCode;
	}

}
