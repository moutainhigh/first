package com.deppon.dpm.module.wfs.shared.vo;

import java.util.Date;

/**
 * 工作流数据监控
 */
public class WfsMonitorVo {

	/** id */
	private int id;
	//审批人
	private String userId;
	//工作流流程定义id
	private String workflowname;
	//类型   0 移动端查看工作流  1 审批工作流  
	private String type;
	//请求相应开始时间
	private Date begindate;
	//请求相应结束时间
	private Date enddate;
	private String bdateStr;
	private String edateStr;
	//审批是否成功  0失败 1成功
	private String issuccess;
	// workitemid 工作流号
	private String remark;
	private String remark2;
	//错误信息
	private String errorInfo;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the workflowname
	 */
	public String getWorkflowname() {
		return workflowname;
	}
	/**
	 * @param workflowname the workflowname to set
	 */
	public void setWorkflowname(String workflowname) {
		this.workflowname = workflowname;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the begindate
	 */
	public Date getBegindate() {
		return begindate;
	}
	/**
	 * @param begindate the begindate to set
	 */
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	/**
	 * @return the enddate
	 */
	public Date getEnddate() {
		return enddate;
	}
	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	/**
	 * @return the bdateStr
	 */
	public String getBdateStr() {
		return bdateStr;
	}
	/**
	 * @param bdateStr the bdateStr to set
	 */
	public void setBdateStr(String bdateStr) {
		this.bdateStr = bdateStr;
	}
	/**
	 * @return the edateStr
	 */
	public String getEdateStr() {
		return edateStr;
	}
	/**
	 * @param edateStr the edateStr to set
	 */
	public void setEdateStr(String edateStr) {
		this.edateStr = edateStr;
	}
	/**
	 * @return the issuccess
	 */
	public String getIssuccess() {
		return issuccess;
	}
	/**
	 * @param issuccess the issuccess to set
	 */
	public void setIssuccess(String issuccess) {
		this.issuccess = issuccess;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the remark2
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * @param remark2 the remark2 to set
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	/**
	 * @return the errorInfo
	 */
	public String getErrorInfo() {
		return errorInfo;
	}
	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
}