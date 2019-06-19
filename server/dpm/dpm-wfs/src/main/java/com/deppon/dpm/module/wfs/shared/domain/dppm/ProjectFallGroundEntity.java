package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.util.Date;
import java.util.List;

import com.deppon.bpms.module.shared.domain.ApprovalInfo;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 项目落地实体类
 * 
 * @author 106140
 * @date 2014-11-2 下午2:51:41
 * @since
 * @version
 */
public class ProjectFallGroundEntity extends BaseEntity {

	private static final long serialVersionUID = 3312321911175601066L;
	/**
	 * 业务编号
	 */
	private String busino;
	/**
	 * 工作流号
	 * 
	 */
	private Long processintId;
	/**
	 * 申请工号
	 */
	private String applyCode;
	/**
	 * 申请姓名
	 */
	private String applyName;
	/**
	 * 项目编码
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 项目级别
	 */
	private String projectLevel;
	/**
	 * 项目经理
	 */
	private String projectManager;
	/**
	 * 申请日期
	 */
	private Date applyDate;
	/**
	 * 审批状态
	 */
	private String appcondition;
	/**
	 * 验收状态
	 */
	private String checkCondition;
	/**
	 * 承接部门
	 */
	private String undertakeDept;
	/**
	 * 结项时间
	 */
	private Date closingDate;
	/**
	 * 结项状态
	 */
	private String closingStatus;
	/**
	 * 结项是否通过
	 */
	private String closingIsPass;
	/**
	 * 备注一
	 */
	private String spareOne;
	/**
	 * 备注二
	 */
	private int spareTwo;
	/**
	 * 备注三
	 */
	private String spareThree;

	/**
	 * 申请原因
	 */
	private String applyReason;
	/**
	 * 项目经理工号
	 */
	private String managerCode;
	/**
	 * 项目编号
	 */
	private String proCode;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 工作流项id
	 */
	private Long workItemId;

	/**
	 * 活动实例id
	 */
	private String activityDefId;
	/**
	 * 承接部门编码
	 */
	private String undertakeDeptCode;
	/**
	 * 附件
	 */
	private List<FileUploadEntity> fileList;
	/**
	 * 审批实体
	 */
	private ApprovelEntity approvelEntity;
	/**
	 * 审批信息List
	 */
	private List<ApprovalInfo> approvalInfoList;
	//错误日志
	private String error;
	//审批人
	private String empName;
	

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the approvalInfoList
	 */
	public List<ApprovalInfo> getApprovalInfoList() {
		return approvalInfoList;
	}

	/**
	 * @param approvalInfoList
	 */
	public void setApprovalInfoList(List<ApprovalInfo> approvalInfoList) {
		this.approvalInfoList = approvalInfoList;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:03
	 * @return
	 * @see
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:05
	 * @param busino
	 * @see
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:07
	 * @return
	 * @see
	 */
	public Long getProcessintId() {
		return processintId;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:10
	 * @param processintId
	 * @see
	 */
	public void setProcessintId(Long processintId) {
		this.processintId = processintId;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:12
	 * @return
	 * @see
	 */
	public String getApplyCode() {
		return applyCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:14
	 * @param applyCode
	 * @see
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:15
	 * @return
	 * @see
	 */
	public String getApplyName() {
		return applyName;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:17
	 * @param applyName
	 * @see
	 */
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:19
	 * @return
	 * @see
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:21
	 * @param projectCode
	 * @see
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:23
	 * @return
	 * @see
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:25
	 * @param projectName
	 * @see
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:27
	 * @return
	 * @see
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:30
	 * @param projectType
	 * @see
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:32
	 * @return
	 * @see
	 */
	public String getProjectLevel() {
		return projectLevel;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:35
	 * @param projectLevel
	 * @see
	 */
	public void setProjectLevel(String projectLevel) {
		this.projectLevel = projectLevel;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:38
	 * @return
	 * @see
	 */
	public String getProjectManager() {
		return projectManager;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:40
	 * @param projectManager
	 * @see
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:42
	 * @return
	 * @see
	 */
	public Date getApplyDate() {
		return applyDate;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:44
	 * @param applyDate
	 * @see
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:46
	 * @return
	 * @see
	 */
	public String getAppcondition() {
		return appcondition;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:49
	 * @param appcondition
	 * @see
	 */
	public void setAppcondition(String appcondition) {
		this.appcondition = appcondition;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:51
	 * @return
	 * @see
	 */
	public String getCheckCondition() {
		return checkCondition;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:53
	 * @param checkCondition
	 * @see
	 */
	public void setCheckCondition(String checkCondition) {
		this.checkCondition = checkCondition;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:55
	 * @return
	 * @see
	 */
	public String getUndertakeDept() {
		return undertakeDept;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:57
	 * @param undertakeDept
	 * @see
	 */
	public void setUndertakeDept(String undertakeDept) {
		this.undertakeDept = undertakeDept;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:52:59
	 * @return
	 * @see
	 */
	public Date getClosingDate() {
		return closingDate;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:02
	 * @param closingDate
	 * @see
	 */
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:04
	 * @return
	 * @see
	 */
	public String getClosingStatus() {
		return closingStatus;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:06
	 * @param closingStatus
	 * @see
	 */
	public void setClosingStatus(String closingStatus) {
		this.closingStatus = closingStatus;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:08
	 * @return
	 * @see
	 */
	public String getClosingIsPass() {
		return closingIsPass;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:11
	 * @param closingIsPass
	 * @see
	 */
	public void setClosingIsPass(String closingIsPass) {
		this.closingIsPass = closingIsPass;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:13
	 * @return
	 * @see
	 */
	public String getSpareOne() {
		return spareOne;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:16
	 * @param spareOne
	 * @see
	 */
	public void setSpareOne(String spareOne) {
		this.spareOne = spareOne;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:18
	 * @return
	 * @see
	 */
	public int getSpareTwo() {
		return spareTwo;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:22
	 * @param spareTwo
	 * @see
	 */
	public void setSpareTwo(int spareTwo) {
		this.spareTwo = spareTwo;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:24
	 * @return
	 * @see
	 */
	public String getSpareThree() {
		return spareThree;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:26
	 * @param spareThree
	 * @see
	 */
	public void setSpareThree(String spareThree) {
		this.spareThree = spareThree;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:29
	 * @return
	 * @see
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:31
	 * @param applyReason
	 * @see
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:33
	 * @return
	 * @see
	 */
	public String getManagerCode() {
		return managerCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:34
	 * @param managerCode
	 * @see
	 */
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:36
	 * @return
	 * @see
	 */
	public String getProCode() {
		return proCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:38
	 * @param proCode
	 * @see
	 */
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:41
	 * @return
	 * @see
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:42
	 * @param startTime
	 * @see
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:44
	 * @return
	 * @see
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:46
	 * @param endTime
	 * @see
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:48
	 * @return
	 * @see
	 */
	public Long getWorkItemId() {
		return workItemId;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:50
	 * @param workItemId
	 * @see
	 */
	public void setWorkItemId(Long workItemId) {
		this.workItemId = workItemId;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:52
	 * @return
	 * @see
	 */
	public String getActivityDefId() {
		return activityDefId;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:55
	 * @param activityDefId
	 * @see
	 */
	public void setActivityDefId(String activityDefId) {
		this.activityDefId = activityDefId;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:57
	 * @return
	 * @see
	 */
	public String getUndertakeDeptCode() {
		return undertakeDeptCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:53:59
	 * @param undertakeDeptCode
	 * @see
	 */
	public void setUndertakeDeptCode(String undertakeDeptCode) {
		this.undertakeDeptCode = undertakeDeptCode;
	}

	

	/**
	 * @return the fileList
	 */
	public List<FileUploadEntity> getFileList() {
		return fileList;
	}

	/**
	 * @param fileList
	 */
	public void setFileList(List<FileUploadEntity> fileList) {
		this.fileList = fileList;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:54:06
	 * @return
	 * @see
	 */
	public ApprovelEntity getApprovelEntity() {
		return approvelEntity;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:54:09
	 * @param approvelEntity
	 * @see
	 */
	public void setApprovelEntity(ApprovelEntity approvelEntity) {
		this.approvelEntity = approvelEntity;
	}

}
