package com.deppon.dpm.tongxunlu.shared.domain;
/**
 * 智慧门店查询所有相关部门信息
 * @author RY
 *
 */
public class SelectAllDeptEntity {
	//员工工号
	private String empcode;
	//员工名称
	private String empname;
	//工作等级
	private String joblevel;
	//工作名称
	private String jobname;
	//组织id
	private String orgid;
	//父id
	private String parentorgid;
	//组织编号
	private String orgcode;
	//组织名称
	private String orgname;
	//头像
	private String pictpath;
	/**
	 * 
	 * @return
	 */
	public String getPictpath() {
		return pictpath;
	}
	/**
	 * 
	 * @param pictpath
	 */
	public void setPictpath(String pictpath) {
		this.pictpath = pictpath;
	}
	/**
	 * 
	 * @return
	 */
	public String getEmpcode() {
		return empcode;
	}
	/**
	 * 
	 * @param empcode
	 */
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	/**
	 * 
	 * @return
	 */
	public String getEmpname() {
		return empname;
	}
	/**
	 * 
	 * @param empname
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	/**
	 * 
	 * @return
	 */
	public String getJoblevel() {
		return joblevel;
	}
	/**
	 * 
	 * @param joblevel
	 */
	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}
	/**
	 * 
	 * @return
	 */
	public String getJobname() {
		return jobname;
	}
	/**
	 * 
	 * @param jobname
	 */
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrgid() {
		return orgid;
	}
	/**
	 * 
	 * @param orgid
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	/**
	 * 
	 * @return
	 */
	public String getParentorgid() {
		return parentorgid;
	}
	/**
	 * 
	 * @param parentorgid
	 */
	public void setParentorgid(String parentorgid) {
		this.parentorgid = parentorgid;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrgcode() {
		return orgcode;
	}
	/**
	 * 
	 * @param orgcode
	 */
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrgname() {
		return orgname;
	}
	/**
	 * 
	 * @param orgname
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
}
