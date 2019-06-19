package com.deppon.dpm.module.wfs.shared.domain;

import java.util.Date;

public class NWorkflowInfoEntity {
	//主键
	private int id;
    //工作流id
	private String workflowId;
	//工作流名
	private String workflowName;
	//工作流状态（打开，关闭）
	private String workflowStatus;
	//创建时间
	private Date createTime;
	//跳转详情页面路径
	private String workflowPage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getWorkflowStatus() {
		return workflowStatus;
	}

	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWorkflowPage() {
		return workflowPage;
	}

	public void setWorkflowPage(String workflowPage) {
		this.workflowPage = workflowPage;
	}

	@Override
	public String toString() {
		return "NWorkflowInfoEntity [id=" + id + ", workflowId=" + workflowId
				+ ", workflowName=" + workflowName + ", workflowStatus="
				+ workflowStatus + ", createTime=" + createTime
				+ ", workflowPage=" + workflowPage + "]";
	}
	
}
