package com.deppon.dpm.module.main.shared.domain;

import java.util.Date;

import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;

public class NoticeDetailEntity {

	//通知类型id
	private String type;
	//通知类型
	private String typeName;
	//通知类型
	private String noticeTypeId;
	//消息标题
	private String title;
	//消息详情
	private String content;
	//创建时间
	private String createTime;
	//每条通知的唯一id
	private String noticeId;
	//创建人姓名
	private String creatorName;
	//登录人工号
	private String userId;
	//已读/未读
	private String isread;
	//插入时间
	private Date insertTime;
	//更新时间
	private Date updateTime;
	//会议日期
	private String meetingDate;
	//会议时间
	private String meetingTime;
	//会议地点
	private String location;
	//id
	private int id;
	//新工作流实体
	private WorkflowListEntity newWorkflow;
	//老工作流实体
	private OaWorkItem oldWorkflow;
	
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getNoticeTypeId() {
		return noticeTypeId;
	}
	public void setNoticeTypeId(String noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "NoticeDetailEntity [type=" + type + ", typeName=" + typeName
				+ ", noticeTypeId=" + noticeTypeId + ", title=" + title
				+ ", content=" + content + ", createTime=" + createTime
				+ ", noticeId=" + noticeId + ", creatorName=" + creatorName
				+ ", userId=" + userId + ", isread=" + isread + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + ", meetingTime="
				+ meetingTime + ", location=" + location + ", id=" + id + "]";
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public WorkflowListEntity getNewWorkflow() {
		return newWorkflow;
	}
	public void setNewWorkflow(WorkflowListEntity newWorkflow) {
		this.newWorkflow = newWorkflow;
	}
	public OaWorkItem getOldWorkflow() {
		return oldWorkflow;
	}
	public void setOldWorkflow(OaWorkItem oldWorkflow) {
		this.oldWorkflow = oldWorkflow;
	}
	
}
