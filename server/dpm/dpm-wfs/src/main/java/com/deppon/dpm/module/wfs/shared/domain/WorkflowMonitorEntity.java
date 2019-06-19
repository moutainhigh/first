package com.deppon.dpm.module.wfs.shared.domain;

import java.util.Date;

public class WorkflowMonitorEntity {
	
	//唯一主键
	private int id;
	//工号
	private String empCode;
	//员工等级
	private String jobLevel;
	//工作流号
	private int workflowId;
	//状态（成功1、失败0）
	private int isSuccess;
	//异常信息
	private String errorInfo;
	//泛微接口时长
	private String methodtimeCops;
	//DPM接口时长
	private String methodtimeTotal;
	//接口名
	private String interfaceName;
	//泛微接口返回数组长度
	private int resultLength;
	//创建时间
	private Date createTime;
	
	//工作流名称
	private String workflowName;
	//所属系统
	private String sysCode;
	//审批选项
	private String approvalOption;
	//退回节点
	private String rejectNode;
	//返回结果
	private String result;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
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
	public String getMethodtimeCops() {
		return methodtimeCops;
	}
	public void setMethodtimeCops(String methodtimeCops) {
		this.methodtimeCops = methodtimeCops;
	}
	public String getMethodtimeTotal() {
		return methodtimeTotal;
	}
	public void setMethodtimeTotal(String methodtimeTotal) {
		this.methodtimeTotal = methodtimeTotal;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
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
	public int getResultLength() {
		return resultLength;
	}
	public void setResultLength(int resultLength) {
		this.resultLength = resultLength;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "WorkflowMonitorEntity [id=" + id + ", empCode=" + empCode
				+ ", jobLevel=" + jobLevel + ", workflowId=" + workflowId
				+ ", isSuccess=" + isSuccess + ", errorInfo=" + errorInfo
				+ ", methodtimeCops=" + methodtimeCops + ", methodtimeTotal="
				+ methodtimeTotal + ", interfaceName=" + interfaceName
				+ ", resultLength=" + resultLength + ", createTime="
				+ createTime + "]";
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getApprovalOption() {
		return approvalOption;
	}
	public void setApprovalOption(String approvalOption) {
		this.approvalOption = approvalOption;
	}
	public String getRejectNode() {
		return rejectNode;
	}
	public void setRejectNode(String rejectNode) {
		this.rejectNode = rejectNode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
