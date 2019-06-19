package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DepartAPPEntity 实体类
 * 
 */
public class DepartAPPEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 2257143010847209058L;

	/**
	 * proName
	 */
	private String proName;
	/**
	 * proCodeList
	 */
	private List<String> proCodeList = new ArrayList<String>();
	/**
	 * 部门名称
	 */
	private String department;

	/**
	 * @return proName
	 */
	public String getProName() {
		return proName;
	}

	/**
	 * @param proName
	 *            proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}

	/**
	 * @return proCodeList
	 */
	public List<String> getProCodeList() {
		return proCodeList;
	}

	/**
	 * @param proCodeList
	 *            proCodeList
	 */
	public void setProCodeList(List<String> proCodeList) {
		this.proCodeList = proCodeList;
	}

	/**
	 * @return 部门名称
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            部门名称
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

}
