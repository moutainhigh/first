package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * <p>
 * ClassName: BusUserEntity
 * </p>
 * <p>
 * Description: 用户表实体类
 * </p>
 * <p>
 * Author: 268101
 * </p>
 * <p>
 * Date: 2015-6-29
 * </p>
 */
public class BusUserEntity implements Serializable {

	/**
	 * <p>
	 * Field serialVersionUID: 序列号
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * Field empId: 主键id
	 * </p>
	 */
	private int empId;

	/**
	 * <p>
	 * Field userNo: 用户工号
	 * </p>
	 */
	private String userNo;
	/**
	 * <p>
	 * Field empName: 用户姓名
	 * </p>
	 */
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
