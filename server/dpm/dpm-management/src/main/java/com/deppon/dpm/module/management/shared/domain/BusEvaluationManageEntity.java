package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 评价回复表（评价管理评价表）
  * @author xieyidong
 * @date 2015-6-27 下午4:55:55
 * @since
 * @version
 */
public class BusEvaluationManageEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private int id;
	/*
	 * 评价表Id
	 */
	private int retId;
	/*
	 * 用户工号
	 */
	private String userNo;
	/*
	 * 回复内容
	 */
	private String replyContent;
	/*
	 * 创建时间
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
	 * @return 主键id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id 主键id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return 主键id
	 */
	public int getRetId() {
		return retId;
	}

	/**
	 * @param retId 主键id
	 */
	public void setRetId(int retId) {
		this.retId = retId;
	}

	/**
	 * @return 用户工号
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo 用户工号
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

	/**
	 * @return 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return 删除标志
	 */
	public int getDelMark() {
		return delMark;
	}

	/**
	 * @param delMark 删除标志
	 */
	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
