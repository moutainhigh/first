package com.deppon.dpm.module.wfs.shared.domain;

import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;


/**
 * <p>ClassName: 信息推送实体</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-8-11</p>
 */
public class TPushInfo {
	/**
	 * 推送内容
	 */
	private String content;

	/**
	 * 推送标题
	 */
	private String title;

	/**
	 * 推送的工号
	 */
	private String pushUserId;

	/**
	 * 推送类型，0表示我的工资条，1表示HR自助，2表示系统通知
	 */
	private int type;

	/**
	 * 是否是消息中心 0 是 1不是
	 */
	private int isTextNews;

	/**
	 * 是否显示小红点 0显示 1 不显示
	 */
	private int isActive;
	/**
	 * 任务编号
	 */
	private String taskId;

	/**
	 * 超链接
	 */
	private String link;

	public NewsCenterEntity getCenterEntity() {
		NewsCenterEntity newsCenterEntity = new NewsCenterEntity(taskId, type,
				isActive, isTextNews, link, title);
		return newsCenterEntity;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pushUserId
	 */
	public String getPushUserId() {
		return pushUserId;
	}

	/**
	 * @param pushUserId the pushUserId to set
	 */
	public void setPushUserId(String pushUserId) {
		this.pushUserId = pushUserId;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the isTextNews
	 */
	public int getIsTextNews() {
		return isTextNews;
	}

	/**
	 * @param isTextNews the isTextNews to set
	 */
	public void setIsTextNews(int isTextNews) {
		this.isTextNews = isTextNews;
	}

	/**
	 * @return the isActive
	 */
	public int getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
}
