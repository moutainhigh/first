package com.deppon.dpm.module.anps.shared.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @date 2015-08-26
 * @author 231586 公文信息实体类
 * 
 */
public class NoticeMessage {
	//id
	private Integer noticeId;	
	// 接收对象id
	private String reciverUserId;
	// 接收对象id
	private String sendUserId;
	// 公文标题
	private String noticeTitle;
	// 公文标题
	private String noticeContent;
	// 发送人姓名
	private String userName;
	// 重要等级
	private String level;	
	// 发件人头像
	private String headPath;
	//信息接收时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 
	private Date createTime;	
	// 是否已读0：未读，1：已读
	private Integer isread;
	// 是否发布0：未点赞，1：已点赞
	private Integer isPraise;
	// 已读数量
	private Integer readNum;
    // weidu数量
    private Integer noReadNum;
    //显示时间
  	private String listTime;
  	//
  	private Integer receiveSize;
	
  	
  	
	public String getReciverUserId() {
		return reciverUserId;
	}
	public void setReciverUserId(String reciverUserId) {
		this.reciverUserId = reciverUserId;
	}
	public Integer getReceiveSize() {
		return receiveSize;
	}
	public void setReceiveSize(Integer receiveSize) {
		this.receiveSize = receiveSize;
	}
	public String getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getListTime() {
		return listTime;
	}
	public void setListTime(String listTime) {
		this.listTime = listTime;
	}
	public Integer getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}	
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	} 
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getIsread() {
		return isread;
	}
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	public Integer getIsPraise() {
		return isPraise;
	}
	public void setIsPraise(Integer isPraise) {
		this.isPraise = isPraise;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Integer getReadNum() {
		return readNum;
	}
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
	public int getNoReadNum() {
		return noReadNum;
	}
	public void setNoReadNum(Integer noReadNum) {
		this.noReadNum = noReadNum;
	}
	
	
}
