package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 点击量保存表(开线建议表)
 * 
 * @author xieyidong
 * @date 2015-6-27 下午4:56:42
 * @since
 * @version
 */
public class BusOpenLineEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * id
	 */
	private int id;
	/*
	 * 站点Id
	 */
	private int siteId;
	/*
	 * 用户id
	 */
	private String userNo;
	/*
	 * 点击量
	 */
	private int hits;
	/*
	 * 创建时间
	 */
	private Date createDate;
	/*
	 * 创建人
	 */
	private String createBy;

	/**
	 * @return 主键id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            主键id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return 主键id
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId 站点Id
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return 用户
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo 用户
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return 点击
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * @param hits 点击
	 */
	public void setHits(int hits) {
		this.hits = hits;
	}

	/**
	 * @return 创建时间
	 */
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() 组装
	 */
	@Override
	public String toString() {
		return "BusOpenLine [id=" + id + ", siteId=" + siteId + ", userNo="
				+ userNo + ", hits=" + hits + ", createDate=" + createDate
				+ ", createBy=" + createBy + "]";
	}

}
