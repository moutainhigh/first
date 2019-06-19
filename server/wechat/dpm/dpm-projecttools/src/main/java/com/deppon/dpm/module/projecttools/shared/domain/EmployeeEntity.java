package com.deppon.dpm.module.projecttools.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 人员信息实体
 * @author 106140
 * @date 2014-10-23 下午1:57:04
 * @since
 * @version
 */
@SuppressWarnings("serial")
public class EmployeeEntity extends BaseEntity{
	
	/**
	 * 姓名
	 */
	private String contactOrderBy;
	
	/**
	 * 所属部门id
	 */
	private String deptId;
	
	/**
	 * 用户工号
	 */
	private String contactEmployeeCode;
	
	/**
	 * 用户状态
	 */
	private String contactStatus;
	
	/**
	 * 所属部门标杆编码
	 */
	private String deptBenchmarkCode;
	/**
	 * 所属部门名称
	 */
	private String deptName;
	
	/**
	 * 后加字段
	 * 区分内、外部人员：1为外部人员，默认为null为内部人员
	 */
	private Integer active;
	//邮箱
	private String contactEmail;
	
	

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the contactOrderBy
	 */
	public String getContactOrderBy() {
		return contactOrderBy;
	}

	/**
	 * @param contactOrderBy
	 */
	public void setContactOrderBy(String contactOrderBy) {
		this.contactOrderBy = contactOrderBy;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the contactEmployeeCode
	 */
	public String getContactEmployeeCode() {
		return contactEmployeeCode;
	}

	/**
	 * @param contactEmployeeCode
	 */
	public void setContactEmployeeCode(String contactEmployeeCode) {
		this.contactEmployeeCode = contactEmployeeCode;
	}

	/**
	 * @return the contactStatus
	 */
	public String getContactStatus() {
		return contactStatus;
	}

	/**
	 * @param contactStatus
	 */
	public void setContactStatus(String contactStatus) {
		this.contactStatus = contactStatus;
	}

	/**
	 * @return the deptBenchmarkCode
	 */
	public String getDeptBenchmarkCode() {
		return deptBenchmarkCode;
	}

	/**
	 * @param deptBenchmarkCode
	 */
	public void setDeptBenchmarkCode(String deptBenchmarkCode) {
		this.deptBenchmarkCode = deptBenchmarkCode;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the active
	 */
	public Integer getActive() {
		return active;
	}

	/**
	 * @param active
	 */
	public void setActive(Integer active) {
		this.active = active;
	} 

	
}
