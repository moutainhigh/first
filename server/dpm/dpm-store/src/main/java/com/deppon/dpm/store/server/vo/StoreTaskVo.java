package com.deppon.dpm.store.server.vo;

import java.math.BigDecimal;

/**
 * 
 * @author XiaoTian
 *
 */
public class StoreTaskVo {
	
	//执行人
	private String exeer;
	//执行人id
	private String exeerid;
	//营业部名称
	private String orgname;
	//营业部编号	
	private String orgcode;
	//营业部负责人名称
	private String empname;
	//营业部负责人id
	private String empcode;
	
	//是否选中
	private boolean isselect;
	//级别
	private String jobname;
	/**
	 * 
	 * @return
	 */
	public String getExeer() {
		return exeer;
	}
	/**
	 * 
	 * @param exeer
	 */
	public void setExeer(String exeer) {
		this.exeer = exeer;
	}
	/**
	 * 
	 * @return
	 */
	public String getExeerid() {
		return exeerid;
	}
	/**
	 * 
	 * @param exeerid
	 */
	public void setExeerid(String exeerid) {
		this.exeerid = exeerid;
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
	public boolean isIsselect() {
		return isselect;
	}
	/**
	 * 
	 * @param isselect
	 */
	public void setIsselect(boolean isselect) {
		this.isselect = isselect;
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
}