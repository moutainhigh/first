package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 建议回复表（评价管理建议表）
 * @author xieyidong
 * @date 2015-6-27 下午4:55:07
 * @since
 * @version
 */
public class BusEvaluationAdviceEntity implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private int id;
	/*
	 * 开线建议表Id
	 */
	private int openId;
	/*
	 * 用户工号Id
	 */
	private String userNo;
	/*
	 * 回复内容
	 */
	private String replyContent;
	/*
	 * 时间
	 */

	private Date createDate;
	/*
	 * 创建人
	 */
	private String createBy;
	/*
	 * 删除标志
	 */
	private int delMark;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return 开线建议表Id
	 */
	public int getOpenId() {
		return openId;
	}
	/**
	 * @param openId 开线建议表Id
	 */
	public void setOpenId(int openId) {
		this.openId = openId;
	}
	/**
	 * @return 用户工号Id
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo 用户工号Id
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return 回复内容
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * @param replyContent 回复内容
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public int getDelMark() {
		return delMark;
	}
	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}
	@Override
	//组装
	public String toString() {
		return "BusEvaluationAdviceEntity [id=" + id + ", openId=" + openId
				+ ", userNo=" + userNo + ", replyContent=" + replyContent
				+ ", createDate=" + createDate + ", createBy=" + createBy
				+ ", delMark=" + delMark + "]";
	}


}
