package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 拼车广告表
 * 
 * @author 293888
 * 
 */
public class ServeNoticeInfo implements Serializable {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private int id;
	/**
	 * 工号
	 */
	private String userNo;
	/**
	 * 图片
	 */
	private String noticeImg;
	/**
	 * 地址
	 */
	private String noticeUrl;
	/**
	 * 启用状态类型 0：未启用 1：启用
	 */
	private int activeType;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 排序在首页广告栏显示的顺序，从0开始
	 */
	private int noticeSort;
	/**
	 * 标志位
	 */
	private String mark;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * 主键
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	/**
	 * 图片
	 * 
	 * @return
	 */
	public String getNoticeImg() {
		return noticeImg;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}

	/**
	 * 地址
	 * 
	 * @return
	 */
	public String getNoticeUrl() {
		return noticeUrl;
	}

	public void setNoticeUrl(String noticeUrl) {
		this.noticeUrl = noticeUrl;
	}

	/**
	 * 是否启用
	 * 
	 * @return
	 */
	public int getActiveType() {
		return activeType;
	}

	public void setActiveType(int activeType) {
		this.activeType = activeType;
	}

	/**
	 * 创建时间
	 * 
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 更新时间
	 * 
	 * @return
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 排序
	 * 
	 * @return
	 */
	public int getNoticeSort() {
		return noticeSort;
	}

	public void setNoticeSort(int noticeSort) {
		this.noticeSort = noticeSort;
	}

}
