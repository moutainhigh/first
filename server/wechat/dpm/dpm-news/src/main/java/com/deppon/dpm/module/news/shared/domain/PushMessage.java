package com.deppon.dpm.module.news.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 推送消息实体类
 * 
 * @author 245968
 * 
 */
public class PushMessage {
	/**
	 * 消息唯一id
	 */
	private String uuid;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 推送时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date pushTime;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * set
	 * 
	 * @param uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * set
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getPushTime() {
		return pushTime;
	}

	/**
	 * set
	 * 
	 * @param pushTime
	 */
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}

}
