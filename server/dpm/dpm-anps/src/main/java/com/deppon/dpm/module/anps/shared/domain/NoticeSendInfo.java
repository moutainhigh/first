package com.deppon.dpm.module.anps.shared.domain;

import java.util.List;

/**
 * @date 2015-08-26
 * @author 231586 公告信息发送实体类
 * 
 */
public class NoticeSendInfo {
	
	// 公告标题
	private String noticeTitle;
	// 公告内容
	private String noticeContent;
	// 公告内容
	private String noticeLevel;
	// 发送人员工号
	private String sendUserID;
	// 发送人
	private String userName;	
	// 收件人人员工号
	private List<String> reciverUserId;
	// 是否可以点赞 0：不可以 1：可以
	private Integer isPariseComment;			
 	// 附件
 	private String[] files;
 	
 	
 	
 	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Integer getIsPariseComment() {
		return isPariseComment;
	}
	public void setIsPariseComment(Integer isPariseComment) {
		this.isPariseComment = isPariseComment;
	}
	public String getNoticeLevel() {
		return noticeLevel;
	}
	public void setNoticeLevel(String noticeLevel) {
		this.noticeLevel = noticeLevel;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getSendUserID() {
		return sendUserID;
	}
	public void setSendUserID(String sendUserID) {
		this.sendUserID = sendUserID;
	}	
	public List<String> getReciverUserId() {
		return reciverUserId;
	}
	public void setReciverUserId(List<String> reciverUserId) {
		this.reciverUserId = reciverUserId;
	}

	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	
    	
	
}
