package com.deppon.dpm.module.wfs.shared.domain;

public class WorkflowPageInfo {
	//工作流id
	private String workflowId;
	//工作流名称
	private String workflowName;
	//工作流状态 开启 或 隐藏
	private String workflowStatus;
	//跳转页面名称
	private String workflowPage;
	
	/**
	 * get
	 * @return
	 */
	public String getWorkflowPage() {
		return workflowPage;
	}
	/**
	 * set
	 * @param workflowPage
	 */
	public void setWorkflowPage(String workflowPage) {
		this.workflowPage = workflowPage;
	}
	/**
	 * get
	 * @return
	 */
	public String getWorkflowId() {
		return workflowId;
	}
	/**
	 * set
	 * @param workflowId
	 */
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	/**
	 * get
	 * @return
	 */
	public String getWorkflowName() {
		return workflowName;
	}
	/**
	 * set
	 * @param workflowName
	 */
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	/**
	 * get
	 * @return
	 */
	public String getWorkflowStatus() {
		return workflowStatus;
	}
	/**
	 * set
	 * @param workflowStatus
	 */
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	
}
