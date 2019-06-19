package com.deppon.dpm.module.management.shared.domain;

import java.util.Date;

public class NoticeCenterEntity {

	//通知类型id
	private String type;
	//通知类型
	private String typeName;
	//未读消息数
	private int count;
	//发布人/起草人
	private String userId;
	//消息标题
	private String title;
	//创建时间
	private Date createTime;
	
	private int id;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "NoticeCenterEntity [type=" + type + ", typeName=" + typeName
				+ ", count=" + count + ", userId=" + userId + ", title="
				+ title + ", createTime=" + createTime + "]";
	}
	
}
