package com.deppon.dpm.module.anps.shared.domain;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 公文搜索结果集
 * @author 276344
 *
 */
public class NoticeSearchResult {
	/**
	 * 员工信息
	 */
	private List<EmployeeVO> emps;
	/**
	 * 组织信息
	 */
	private List<OrganizationEntity> orgs;

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
	public List<OrganizationEntity> getOrgs() {
		return orgs;
	}

	/**
	 * set
	 * 
	 * @param orgs
	 */
	public void setOrgs(List<OrganizationEntity> orgs) {
		this.orgs = orgs;
	}
	
}
