package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 268101 ProcHistorySubmitEntity 实体
 * 
 */
public class ProcHistorySubmitEntity implements Serializable {

	/**
	 * <p>
	 * Field serialVersionUID: 序列号id
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	// id
	private String id;
	// 工号
	private String userNo;
	// 营业部名称
	private String storeName;
	// 时间
	private Date createDate;
	// 是否提交
	private String isSubmit;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            主键id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 工号
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo
	 *            工号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return 营业部名称
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName
	 *            营业部名称
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @return 时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return 是否提交
	 */
	public String getIsSubmit() {
		return isSubmit;
	}

	/**
	 * @param isSubmit
	 *            是否提交
	 */
	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// 构造方法
	@Override
	public String toString() {
		return "ProcHistorySubmitEntity [id=" + id + ", userNo=" + userNo
				+ ", storeName=" + storeName + ", createDate=" + createDate
				+ ", isSubmit=" + isSubmit + "]";
	}

}
