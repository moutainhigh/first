package com.deppon.dpm.module.management.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 应用评论实体类
 * 
 * @author 491275
 *
 */
public class AppCommentEntity {
	
	/**
	 * 评论id（主键）
	 */
	private int commentId;
	/**
	 * 对应应用id
	 */
	private int appId;
	/**
	 * 评论人id
	 */
	private String empCode;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 得分
	 */
	private int score;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 评论回复内容
	 */
	private String replyContent;
	/**
	 * 评论回复人
	 */
	private String replyEmpCode;
	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}	
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyEmpCode() {
		return replyEmpCode;
	}
	public void setReplyEmpCode(String replyEmpCode) {
		this.replyEmpCode = replyEmpCode;
	}	
	@Override
	public String toString() {
		return "AppCommentEntity [commentId=" + commentId + ", appId=" + appId
				+ ", empCode=" + empCode + ", content=" + content + ", score="
				+ score + ", createTime=" + createTime + ", status=" + status
				+ ", replyContent=" + replyContent + ", replyEmpCode="
				+ replyEmpCode + "]";
	}
}
