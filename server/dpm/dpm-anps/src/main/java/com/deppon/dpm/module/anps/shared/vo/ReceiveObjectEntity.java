package com.deppon.dpm.module.anps.shared.vo;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

public class ReceiveObjectEntity {
	/**
	 * 员工信息
	 */
	private List<EmployeeVO> emps;
	/**
	 * 组织信息
	 */
	private List<OrganizationVO> orgs;

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
}
