package com.deppon.dpm.module.wfs.shared.domain;

import java.util.Date;

public class BandApproveEntity {
	//主键
	private int id;
    //lsp工作流id
	private String workflowId;
	//lsp工作流名
	private String workflowName;
	//工作流状态（打开，关闭）
	private String workflowStatus;
	//创建时间
	private Date createTime;
	//系统编码
	private String syscode;
	//领导等级
	private String jobLevel;

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

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	@Override
	public String toString() {
		return "BandApproveEntity [id=" + id + ", workflowId=" + workflowId
				+ ", workflowName=" + workflowName + ", workflowStatus="
				+ workflowStatus + ", createTime=" + createTime + ", syscode=" + syscode
				+ ", jobLevel=" + jobLevel + "]";
	}
	
}
