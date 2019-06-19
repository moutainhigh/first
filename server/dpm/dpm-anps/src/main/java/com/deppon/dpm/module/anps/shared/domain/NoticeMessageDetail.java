package com.deppon.dpm.module.anps.shared.domain;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @date 2015-08-26
 * @author 231586 公告信息详情实体类
 * 
 */
public class NoticeMessageDetail {
	//公告id
	private Integer id;
	// 公告标题
	private String noticeTitle;
	// 公告内容
	private String noticeContent;
	// 公告图片
	private String noticePhoto;
	// 是否可以评论点赞 0 不可以 1 可以
	private Integer isPariseComment;
	
	// 公告发送时间
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 
	private Date createTime;			
	// 发送人所属事业群
	private String jobGroup;
	//接收对象
	private String reciveNames;
	// 发送人员工号
	private String sendUserId;
	// 点赞状态
	private Integer isPraise;
	// 发送人姓名或者组织
	private String userName;
	// 接收对象详情
	private String reciveUserDetail;
	// 收件人人员工号
	private String reciverUserId;
	// 接收对象
	private String reciverObject;
	// 已读数量
	private Integer readNum;
    // 未读数量
    private Integer noReadNum;
    // 未读数量
    private Integer praiseNum;
    //公文评论
    private List<NoticeComment> noticeComments;
    //附件名称
 	private String[] attachFileNames;
 	// 附件
 	private File file;
    // 公文是否被提醒发送 0 没有 1 已经提醒了
 	private Integer isSend;
 	// 接收对象人数
 	private Integer receiveSize;
    
 	
 	
	public String getReciveUserDetail() {
		return reciveUserDetail;
	}
	public void setReciveUserDetail(String reciveUserDetail) {
		this.reciveUserDetail = reciveUserDetail;
	}
	public Integer getReceiveSize() {
		return receiveSize;
	}
	public void setReceiveSize(Integer receiveSize) {
		this.receiveSize = receiveSize;
	}
	public String getReciverObject() {
		return reciverObject;
	}
	public void setReciverObject(String reciverObject) {
		this.reciverObject = reciverObject;
	}
	public Integer getIsSend() {
		return isSend;
	}
	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}
	public Integer getIsPariseComment() {
		return isPariseComment;
	}
	public void setIsPariseComment(Integer isPariseComment) {
		this.isPariseComment = isPariseComment;
	}
	public String getNoticePhoto() {
		return noticePhoto;
	}
	public void setNoticePhoto(String noticePhoto) {
		this.noticePhoto = noticePhoto;
	}
	public String getReciveNames() {
		return reciveNames;
	}
	public void setReciveNames(String reciveNames) {
		this.reciveNames = reciveNames;
	}
	public List<NoticeComment> getNoticeComments() {
		return noticeComments;
	}
	public void setNoticeComments(List<NoticeComment> noticeComments) {
		this.noticeComments = noticeComments;
	}
	public String[] getAttachFileNames() {
		return attachFileNames;
	}
	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getReciverUserId() {
		return reciverUserId;
	}
	public void setReciverUserId(String reciverUserId) {
		this.reciverUserId = reciverUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getReadNum() {
		return readNum;
	}
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
	public Integer getNoReadNum() {
		return noReadNum;
	}
	public void setNoReadNum(Integer noReadNum) {
		this.noReadNum = noReadNum;
	}
	public Integer getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}
	public Integer getIsPraise() {
		return isPraise;
	}
	public void setIsPraise(Integer isPraise) {
		this.isPraise = isPraise;
	}
	
}
