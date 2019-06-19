package com.deppon.dpm.module.anps.shared.domain;

import java.util.List;

import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
/**
 * 接收对象结果集
 * @author 276344
 *
 */
public class ReceiveObjectResult {
	/**
	 * 组织员工数
	 */
	private Integer empNum;

	/**
	 * 员工信息
	 */
	private List<EmployeeVO> emps;
	/**
	 * 组织信息
	 */
	private List<OrganizationEntity> orgs;
	/**
	 * 岗位信息
	 */
	private List<NoticeJobEntity> jobs;

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
	
	public Integer getEmpNum() {
		return empNum;
	}

	public void setEmpNum(Integer empNum) {
		this.empNum = empNum;
	}

	public List<NoticeJobEntity> getJobs() {
		return jobs;
	}

	public void setJobs(List<NoticeJobEntity> jobs) {
		this.jobs = jobs;
	}

}
