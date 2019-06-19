package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author  部门实体类
 *
 */
public class DepartEntity implements Serializable {

	/**
	 *  序列号
	 */
	private static final long serialVersionUID = -7320962035633720976L;
	
	/**
	 * proName
	 */
	private String proName;
	/**
	 * proCode
	 */
	private String proCode;
	/**
	 * 部门
	 */
	private String department;
	//getter setter
	public String getProName() {
		return proName;
	}
	//getter setter
	public void setProName(String proName) {
		this.proName = proName;
	}
	//getter setter
	public String getProCode() {
		return proCode;
	}
	//getter setter
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	//getter setter
	public String getDepartment() {
		return department;
	}
	//getter setter
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
