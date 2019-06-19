package com.deppon.dpm.module.projecttools.shared.domain;

import java.util.Date;

/**
 * <p>ClassName: 会议纪要代办事项</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢s</p>
 * <p>Date: 2015-9-15</p>
 */
public class ProjectMinutesBack {
	//责任人
	private String backlogDutyman;
	
	//代办内容描述
	private String backlogContent;
	
	//完成时间
	private Date finisheTime;

	/**
	 * backlogDutyman
	 * @return the backlogDutyman
	 */
	public String getBacklogDutyman() {
		return backlogDutyman;
	}

	/**
	 * @param backlogDutyman the backlogDutyman to set
	 */
	public void setBacklogDutyman(String backlogDutyman) {
		this.backlogDutyman = backlogDutyman;
	}

	/**
	 * backlogContent
	 * @return the backlogContent
	 */
	public String getBacklogContent() {
		return backlogContent;
	}

	/**
	 * @param backlogContent the backlogContent to set
	 */
	public void setBacklogContent(String backlogContent) {
		this.backlogContent = backlogContent;
	}

	/**
	 * finisheTime
	 * @return the finisheTime
	 */
	public Date getFinisheTime() {
		return finisheTime;
	}

	/**
	 * @param finisheTime the finisheTime to set
	 */
	public void setFinisheTime(Date finisheTime) {
		this.finisheTime = finisheTime;
	}
	
}
