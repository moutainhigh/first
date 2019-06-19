package com.deppon.dpm.module.main.shared.domain;

import java.util.Date;


public class NoticeCenterEntity {
     
	//每条通知的唯一id
	private String noticeId;
	//通知类型id
	private String type;
	//通知类型
	private String typeName;
	//开关状态
	private String status;
	//未读消息数
	private int count;
	//发布人/起草人
	private String userId;
	//名
	private String userName;
	//消息标题
	private String title;
	//消息标题
	private String content;
	//创建时间
	private String createTime;
	//是否置顶
	private String isTop;
	//应用于通知中心首页，去除已读的通知的判断
	private boolean getoff;
	
	private int id;
	
	//创建时间
	private Date createTimeSort;
	
	
	
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
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
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	@Override
	public String toString() {
		return "NoticeCenterEntity [type=" + type + ", typeName=" + typeName
				+ ", status=" + status + ", count=" + count + ", userId="
				+ userId + ", userName=" + userName + ", title=" + title
				+ ", content=" + content + ", createTime=" + createTime
				+ ", isTop=" + isTop + ", id=" + id + "]";
	}
	public boolean isGetoff() {
		return getoff;
	}
	public void setGetoff(boolean getoff) {
		this.getoff = getoff;
	}
	public Date getCreateTimeSort() {
		return createTimeSort;
	}
	public void setCreateTimeSort(Date createTimeSort) {
		this.createTimeSort = createTimeSort;
	}
	
}
