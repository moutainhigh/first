package com.deppon.dpm.module.wfs.shared.domain;

import java.util.Date;

public class WorkflowLevelMonitorEntity {
	
	//唯一主键
	private int id;
	//工号
	private String userId;
	//员工等级
	private String jobLevel;
	//工作流号
	private int workflowId;
	//工作流名称
	private String workflowName;
	//审批选项
	private String approvalOption;
	//状态（成功1、失败0）
	private int isSuccess;
	//返回结果
	private String result;
	//异常信息
	private String errorInfo;
	//创建时间
	private Date createTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public int getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}
	public int getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "WorkflowMonitorEntity [id=" + id + ", userId=" + userId
				+ ", jobLevel=" + jobLevel + ", workflowId=" + workflowId
				+ ", isSuccess=" + isSuccess + ", errorInfo=" + errorInfo
				+ ", workflowName=" + workflowName  + ", approvalOption=" + approvalOption
				+ ", result=" + result + ", createTime=" + createTime + "]";
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getApprovalOption() {
		return approvalOption;
	}
	public void setApprovalOption(String approvalOption) {
		this.approvalOption = approvalOption;
	}
	
}
