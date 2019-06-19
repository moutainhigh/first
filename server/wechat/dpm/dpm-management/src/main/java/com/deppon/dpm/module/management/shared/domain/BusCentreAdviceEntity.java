package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ClassName: BusCentreAdviceEntity
 * </p>
 * <p>
 * Description: 评价表和建议表中间表实体类
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-6-29
 * </p>
 */
public class BusCentreAdviceEntity implements Serializable {

	/**
	 * <p>
	 * Field serialVersionUID: 序列号
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * Field id: 主键id
	 * </p>
	 */
	private int id;
	/**
	 * <p>
	 * Field userNo: 用户工号
	 * </p>
	 */
	private String userNo;
	/**
	 * <p>
	 * Field centreMark: 标志位 (0 代表评价表1建议表)
	 * </p>
	 */
	private int centreMark;
	/**
	 * <p>
	 * Field centreId: 评价表和中间表id
	 * </p>
	 */
	private int centreId;
	/**
	 * <p>
	 * Field createDate: 创建时间
	 * </p>
	 */
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getCentreMark() {
		return centreMark;
	}

	public void setCentreMark(int centreMark) {
		this.centreMark = centreMark;
	}

	public int getCentreId() {
		return centreId;
	}

	public void setCentreId(int centreId) {
		this.centreId = centreId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
