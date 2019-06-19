package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author 268101 ProNameEntity
 * 
 */
public class ProNameEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -3392537849363960624L;

	/**
	 * 用户id
	 */
	private String adminID;

	/**
	 * 用户姓名
	 */
	private String adminName;

	/**
	 * @return 用户id
	 */
	public String getAdminID() {
		return adminID;
	}

	/**
	 * @param adminID
	 *            用户id
	 */
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	/**
	 * @return 用户姓名
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName
	 *            用户姓名
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}
