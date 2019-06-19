package com.deppon.dpm.tongxunlu.shared.vo;

import java.util.List;

/**
 * 搜索结果展示类
 */
public class SearchResult {
	/**
	 * 员工信息
	 */
	private List<EmployeeVO> emps;
	/**
	 * 组织信息
	 */
	private List<OrganizationVO> orgs;
	/**
	 * 父组织信息
	 */
	private List<OrganizationVO> parentOrgs;

	/**
	 * get
	 * 
	 * @return
	 */
	public List<EmployeeVO> getEmps() {
		return emps;
	}

	/**
	 * set
	 * 
	 * @param emps
	 */
	public void setEmps(List<EmployeeVO> emps) {
		this.emps = emps;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<OrganizationVO> getOrgs() {
		return orgs;
	}

	/**
	 * set
	 * 
	 * @param orgs
	 */
	public void setOrgs(List<OrganizationVO> orgs) {
		this.orgs = orgs;
	}

	public List<OrganizationVO> getParentOrgs() {
		return parentOrgs;
	}

	public void setParentOrgs(List<OrganizationVO> parentOrgs) {
		this.parentOrgs = parentOrgs;
	}
}
