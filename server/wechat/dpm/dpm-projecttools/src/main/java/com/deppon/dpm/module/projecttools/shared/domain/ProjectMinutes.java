package com.deppon.dpm.module.projecttools.shared.domain;

import java.util.List;

/**
 * <p>ClassName: 项目管理工具里程碑会议纪要实体类</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-9-14</p>
 */
public class ProjectMinutes {
	//查询ID
	private String msId;
	
	//会议主题(里程碑名称)
	private String msName;
	
	//会议时间
	private String minutesTime;
	
	//会议地点
	private String minutesLocation;
	
	//主持人
	private String minutesModerator;
	
	//记录员
	private String minutesRecorder;
	
	//参会人
	private String minutesParticipants;
	
	//会议内容
	private String minutesContent;
	
	//会议总结
	private String minutesSummary;
	
	//会议纪要代办事项
	private List<ProjectMinutesBack> projectMinutesBacks;

	/**
	 * msId
	 * @return the msId
	 */
	public String getMsId() {
		return msId;
	}

	/**
	 * @param msId the msId to set
	 */
	public void setMsId(String msId) {
		this.msId = msId;
	}

	/**
	 * msName
	 * @return the msName
	 */
	public String getMsName() {
		return msName;
	}

	/**
	 * @param msName the msName to set
	 */
	public void setMsName(String msName) {
		this.msName = msName;
	}

	/**
	 * minutesTime
	 * @return the minutesTime
	 */
	public String getMinutesTime() {
		return minutesTime;
	}

	/**
	 * @param minutesTime the minutesTime to set
	 */
	public void setMinutesTime(String minutesTime) {
		this.minutesTime = minutesTime;
	}

	/**
	 * minutesLocation
	 * @return the minutesLocation
	 */
	public String getMinutesLocation() {
		return minutesLocation;
	}

	/**
	 * @param minutesLocation the minutesLocation to set
	 */
	public void setMinutesLocation(String minutesLocation) {
		this.minutesLocation = minutesLocation;
	}

	/**
	 * minutesModerator
	 * @return the minutesModerator
	 */
	public String getMinutesModerator() {
		return minutesModerator;
	}

	/**
	 * @param minutesModerator the minutesModerator to set
	 */
	public void setMinutesModerator(String minutesModerator) {
		this.minutesModerator = minutesModerator;
	}

	/**
	 * minutesRecorder
	 * @return the minutesRecorder
	 */
	public String getMinutesRecorder() {
		return minutesRecorder;
	}

	/**
	 * @param minutesRecorder the minutesRecorder to set
	 */
	public void setMinutesRecorder(String minutesRecorder) {
		this.minutesRecorder = minutesRecorder;
	}

	/**
	 * minutesParticipants
	 * @return the minutesParticipants
	 */
	public String getMinutesParticipants() {
		return minutesParticipants;
	}

	/**
	 * @param minutesParticipants the minutesParticipants to set
	 */
	public void setMinutesParticipants(String minutesParticipants) {
		this.minutesParticipants = minutesParticipants;
	}

	/**
	 * minutesContent
	 * @return the minutesContent
	 */
	public String getMinutesContent() {
		return minutesContent;
	}

	/**
	 * @param minutesContent the minutesContent to set
	 */
	public void setMinutesContent(String minutesContent) {
		this.minutesContent = minutesContent;
	}

	/**
	 * minutesSummary
	 * @return the minutesSummary
	 */
	public String getMinutesSummary() {
		return minutesSummary;
	}

	/**
	 * @param minutesSummary the minutesSummary to set
	 */
	public void setMinutesSummary(String minutesSummary) {
		this.minutesSummary = minutesSummary;
	}

	/**
	 * projectMinutesBacks
	 * @return the projectMinutesBacks
	 */
	public List<ProjectMinutesBack> getProjectMinutesBacks() {
		return projectMinutesBacks;
	}

	/**
	 * @param projectMinutesBacks the projectMinutesBacks to set
	 */
	public void setProjectMinutesBacks(List<ProjectMinutesBack> projectMinutesBacks) {
		this.projectMinutesBacks = projectMinutesBacks;
	}
}
