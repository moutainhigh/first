package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ClassName: BusNewsSiteEntity
 * </p>
 * <p>
 * Description: 班车建议站点实体类
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-6-27
 * </p>
 */
public class BusNewsSiteEntity implements Serializable {

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
	 * Field siteName: 站点名称
	 * </p>
	 */
	private String siteName;
	/**
	 * <p>
	 * Field address: 地址
	 * </p>
	 */
	private String address;
	/**
	 * <p>
	 * Field isAct: 站点是否启用标志位，0未启用，1启用
	 * </p>
	 */
	private int isAct;
	/**
	 * <p>
	 * Field createDate: 创建时间
	 * </p>
	 */
	private Date createDate;
	/**
	 * <p>
	 * Field remark: 备注
	 * </p>
	 */
	private String remark;

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

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsAct() {
		return isAct;
	}

	public void setIsAct(int isAct) {
		this.isAct = isAct;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
