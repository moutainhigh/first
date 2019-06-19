package com.deppon.dpm.module.wfs.shared.domain;

import java.util.Date;

public class WorkflowNewMonitorEntity {

	// 唯一主键
	private int id;
	// 工号
	private String userId;
	// 员工等级
	private String jobLevel;
	// 订单编号
	private String workflowId;
	// 工作流号
	private String requestId;
	// 工作流名称
	private String workflowName;
	// 所属系统
	private String sysCode;
	// 新/老工作流
	private String status;
	// 审批操作
	private String approvalOption;
	// 审批意见
	private String remark;
	// 返回结果error失败 、success成功
	private String result;
	// 状态（成功1、失败0）
	private int isSuccess;
	// 返回前端的数据
	private String data;
	// 异常信息
	private String errorInfo;
	// 接口名
	private String interfaceName;
	// 退回节点
	private String rejectNode;
	// DPM接口时长
	private String methodTime;
	// 附件ID
	private String fileDocId;
	// 附件名称
	private String fileName;
	// 附件地址
	private String filePath;
	// 附件打开次数
	private int fileOpenCount;
	// 设备类型
	private String ui_type;
	// 创建时间
	private Date createTime;
	// 备用字段1
	private String remark1;
	// 备用字段2
	private String remark2;
	// 备用字段3
	private String remark3;

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

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovalOption() {
		return approvalOption;
	}

	public void setApprovalOption(String approvalOption) {
		this.approvalOption = approvalOption;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getRejectNode() {
		return rejectNode;
	}

	public void setRejectNode(String rejectNode) {
		this.rejectNode = rejectNode;
	}

	public String getMethodTime() {
		return methodTime;
	}

	public void setMethodTime(String methodTime) {
		this.methodTime = methodTime;
	}

	public String getFileDocId() {
		return fileDocId;
	}

	public void setFileDocId(String fileDocId) {
		this.fileDocId = fileDocId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileOpenCount() {
		return fileOpenCount;
	}

	public void setFileOpenCount(int fileOpenCount) {
		this.fileOpenCount = fileOpenCount;
	}

	public String getUi_type() {
		return ui_type;
	}

	public void setUi_type(String ui_type) {
		this.ui_type = ui_type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

}
