package com.deppon.dpm.tongxunlu.shared.vo;
/**
 * 查询智能门店所有人员信息  映射
 * @author RY
 *
 */
public class DeptMappingVO {
	//id
	private Integer id;
	//人员等级
	private String psnlevel;
	//员工号
	private String empcode;
	//姓名
	private String empname;
	//工作名称
	private String jobname;
	//seq
	private String deptseq;
	//上一级组织id
	private String parentorgid;
	//组织名称
	private String orgid;
	//组织号
	private String orgcode;
	//组织名称
	private String orgname;
	//头像
	private String picpath;
	//性别
	private String sex;
	
	/**
	 * 
	 * @return
	 */
	public String getPsnlevel() {
		return psnlevel;
	}
	/**
	 * 
	 * @param psnlevel
	 */
	public void setPsnlevel(String psnlevel) {
		this.psnlevel = psnlevel;
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
	public String getDeptseq() {
		return deptseq;
	}
	/**
	 * 
	 * @param deptseq
	 */
	public void setDeptseq(String deptseq) {
		this.deptseq = deptseq;
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
	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public String getPicpath() {
		return picpath;
	}
	/**
	 * 
	 * @param picpath
	 */
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}


}
