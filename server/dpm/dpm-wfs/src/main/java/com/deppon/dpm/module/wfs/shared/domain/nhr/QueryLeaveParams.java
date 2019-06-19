package com.deppon.dpm.module.wfs.shared.domain.nhr;

import java.io.Serializable;

public class QueryLeaveParams implements Serializable {
	private static final long serialVersionUID = 214030343632678379L;
	//工作流号
	private String workFlowNum;
	// 审批人工号
	private String empCode;
	// 审批人名称
	private String empName;
	//工作流类型
	private String workFlowType;
    //流程实例ID  新增
  	private String wfinstanceid;
  	//模板编码 132 收入证明申请  新增
  	private String tpno;
  	//是否提成制考核人员  新增
  	private String ishavecommission;
  	//部门类型  新增
  	private String depttype;
  	//当前流程制 ID  新增
  	private String wfState;
  	//流程当前工作项ID  新增
  	private String workitemid;
  	//查询是写入固定值  新增
  	private String type;
	/**
	 * @return the workFlowNum
	 */
	public String getWorkFlowNum() {
		return workFlowNum;
	}
	/**
	 * @param workFlowNum the workFlowNum to set
	 */
	public void setWorkFlowNum(String workFlowNum) {
		this.workFlowNum = workFlowNum;
	}
	/**
	 * @return the empCode
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the workFlowType
	 */
	public String getWorkFlowType() {
		return workFlowType;
	}
	/**
	 * @param workFlowType the workFlowType to set
	 */
	public void setWorkFlowType(String workFlowType) {
		this.workFlowType = workFlowType;
	}
	public String getWfinstanceid() {
		return wfinstanceid;
	}
	public void setWfinstanceid(String wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}
	public String getTpno() {
		return tpno;
	}
	public void setTpno(String tpno) {
		this.tpno = tpno;
	}
	public String getIshavecommission() {
		return ishavecommission;
	}
	public void setIshavecommission(String ishavecommission) {
		this.ishavecommission = ishavecommission;
	}
	public String getDepttype() {
		return depttype;
	}
	public void setDepttype(String depttype) {
		this.depttype = depttype;
	}
	public String getWfState() {
		return wfState;
	}
	public void setWfState(String wfState) {
		this.wfState = wfState;
	}
	public String getWorkitemid() {
		return workitemid;
	}
	public void setWorkitemid(String workitemid) {
		this.workitemid = workitemid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
