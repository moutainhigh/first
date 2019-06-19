package com.deppon.dpm.module.anps.shared.domain;

import java.util.Date;

public class NoticeComment {
	// 公文id
	private Integer noticeId;
	// 公文评论 内容
	private String conTent;
	// 公文评论 shi间
	private Date createTime;
	// 公文评论 shi间
	private String listTime;
	// 评论人工号
	private String commentEmployId;
	// 回复对象工号
	private String toCommentEmployId;
	// 评论类型 0:评论  1：回复
	private Integer commentType;
    
	
	
	public String getListTime() {
		return listTime;
	}

	public void setListTime(String listTime) {
		this.listTime = listTime;
	}

	public String getToCommentEmployId() {
		return toCommentEmployId;
	}

	public void setToCommentEmployId(String toCommentEmployId) {
		this.toCommentEmployId = toCommentEmployId;
	}

	public Integer getCommentType() {
		return commentType;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCommentEmployId() {
		return commentEmployId;
	}

	public void setCommentEmployId(String commentEmployId) {
		this.commentEmployId = commentEmployId;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getConTent() {
		return conTent;
	}

	public void setConTent(String conTent) {
		this.conTent = conTent;
	}

}
