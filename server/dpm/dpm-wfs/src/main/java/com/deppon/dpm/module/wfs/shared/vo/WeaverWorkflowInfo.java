package com.deppon.dpm.module.wfs.shared.vo;

public class WeaverWorkflowInfo {
	//工作流详情
	private String workflowInfo;
	//工号
	private String userId;
	//请求ID
	private int requestId;
	//审批意见
	private String remark;
	//审批类型字段 ：submit  提交  reject 退回
	private String submitType;
	//版本号
	private String version;
	/**
	 * get
	 * @return
	 */
	public String getWorkflowInfo() {
		return workflowInfo;
	}
	/**
	 * set
	 * @param workflowInfo
	 */
	public void setWorkflowInfo(String workflowInfo) {
		this.workflowInfo = workflowInfo;
	}
	/**
	 * get
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * set
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * get
	 * @return
	 */
	public int getRequestId() {
		return requestId;
	}
	/**
	 * set
	 * @param requestId
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	/**
	 * get
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * set
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * get
	 * @return
	 */
	public String getSubmitType() {
		return submitType;
	}
	/**
	 * set
	 * @param submitType
	 */
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
