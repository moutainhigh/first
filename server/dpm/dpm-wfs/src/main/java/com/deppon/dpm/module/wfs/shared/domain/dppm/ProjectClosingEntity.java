package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.util.Date;
import java.util.List;

import com.deppon.bpms.module.shared.domain.ApprovalInfo;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 项目结项实体类
 * 
 * @author 106140
 * @date 2014-11-2 下午2:51:41
 * @since
 * @version
 */
public class ProjectClosingEntity extends BaseEntity {

	private static final long serialVersionUID = 1490325816387916228L;

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
	 * 项目管理
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
	 * 承接部门编码
	 */
	private String undertakeDeptCode;
	/**
	 * 是否系统验收
	 */
	private String isSysCheck;
	/**
	 * 是否系统验收
	 */
	private int isSysCheckInt;
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

	// 申请原因
	private String applyReason;
	// 项目经理工号
	private String managerCode;
	// 项目编号
	private String proCode;
	// 开始时间
	private Date startTime;
	// 结束时间
	private Date endTime;
	// 工作流项id
	private Long workItemId;
	// 活动实例id
	private String activityDefId;
	/**
	 * 验收类型
	 */
	private String checkType;
	/**
	 * 是否通过
	 */
	private String isPass;
	//附件列表
	private List<FileUploadEntity> fileList;
	/**
	 * 审批列表
	 */
	private List<ApprovalInfo> approvalInfoList;
	//审批实体
	private ApprovelEntity approvelEntity;
	//指标相关信息
	private List<ClosingIndexEntity> closingIndexList;
	//验收类型
	private List<ClosingCheckTypeEntity> closingCheckTypeList;
	//是否结项通过
	private ClosingIsPassEntity closingIsPassEntity;
	//验收组织
	private ClosingOrgInfoEntity closingOrgInfoEntity;
	//是否失败
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
	 * @param fileList
	 */
	public void setFileList(List<FileUploadEntity> fileList) {
		this.fileList = fileList;
	}

	/**
	 * @return the approvelEntity
	 */
	public ApprovelEntity getApprovelEntity() {
		return approvelEntity;
	}

	/**
	 * @param approvelEntity
	 */
	public void setApprovelEntity(ApprovelEntity approvelEntity) {
		this.approvelEntity = approvelEntity;
	}

	/**
	 * @return the fileList
	 */
	public List<FileUploadEntity> getFileList() {
		return fileList;
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
	 * @return the closingOrgInfoEntity
	 */
	public ClosingOrgInfoEntity getClosingOrgInfoEntity() {
		return closingOrgInfoEntity;
	}

	/**
	 * @param closingOrgInfoEntity
	 */
	public void setClosingOrgInfoEntity(ClosingOrgInfoEntity closingOrgInfoEntity) {
		this.closingOrgInfoEntity = closingOrgInfoEntity;
	}

	/**
	 * @return the closingIsPassEntity
	 */
	public ClosingIsPassEntity getClosingIsPassEntity() {
		return closingIsPassEntity;
	}

	/**
	 * @param closingIsPassEntity
	 */
	public void setClosingIsPassEntity(ClosingIsPassEntity closingIsPassEntity) {
		this.closingIsPassEntity = closingIsPassEntity;
	}

	/**
	 * @return the closingCheckTypeList
	 */
	public List<ClosingCheckTypeEntity> getClosingCheckTypeList() {
		return closingCheckTypeList;
	}

	/**
	 * @param closingCheckTypeList
	 */
	public void setClosingCheckTypeList(
			List<ClosingCheckTypeEntity> closingCheckTypeList) {
		this.closingCheckTypeList = closingCheckTypeList;
	}

	/**
	 * @return the closingIndexList
	 */
	public List<ClosingIndexEntity> getClosingIndexList() {
		return closingIndexList;
	}

	/**
	 * @param closingIndexList
	 */
	public void setClosingIndexList(List<ClosingIndexEntity> closingIndexList) {
		this.closingIndexList = closingIndexList;
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
	 * @date 2015-1-9 下午3:48:41
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
	 * @date 2015-1-9 下午3:48:43
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
	 * @date 2015-1-9 下午3:48:46
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
	 * @date 2015-1-9 下午3:48:47
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
	 * @date 2015-1-9 下午3:48:49
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
	 * @date 2015-1-9 下午3:48:51
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
	 * @date 2015-1-9 下午3:48:52
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
	 * @date 2015-1-9 下午3:48:54
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
	 * @date 2015-1-9 下午3:48:57
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
	 * @date 2015-1-9 下午3:48:59
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
	 * @date 2015-1-9 下午3:49:01
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
	 * @date 2015-1-9 下午3:49:05
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
	 * @date 2015-1-9 下午3:49:07
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
	 * @date 2015-1-9 下午3:49:15
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
	 * @date 2015-1-9 下午3:49:17
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
	 * @date 2015-1-9 下午3:49:20
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
	 * @date 2015-1-9 下午3:49:23
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
	 * @date 2015-1-9 下午3:49:26
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
	 * @date 2015-1-9 下午3:49:29
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
	 * @date 2015-1-9 下午3:49:32
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
	 * @date 2015-1-9 下午3:49:36
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
	 * @date 2015-1-9 下午3:49:38
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
	 * @date 2015-1-9 下午3:49:40
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
	 * @date 2015-1-9 下午3:49:42
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
	 * @date 2015-1-9 下午3:49:44
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
	 * @date 2015-1-9 下午3:49:46
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
	 * @date 2015-1-9 下午3:49:49
	 * @return
	 * @see
	 */
	public String getIsSysCheck() {
		return isSysCheck;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:49:51
	 * @param isSysCheck
	 * @see
	 */
	public void setIsSysCheck(String isSysCheck) {
		this.isSysCheck = isSysCheck;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:49:53
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
	 * @date 2015-1-9 下午3:49:55
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
	 * @date 2015-1-9 下午3:49:57
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
	 * @date 2015-1-9 下午3:50:00
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
	 * @date 2015-1-9 下午3:50:02
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
	 * @date 2015-1-9 下午3:50:05
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
	 * @date 2015-1-9 下午3:50:06
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
	 * @date 2015-1-9 下午3:50:08
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
	 * @date 2015-1-9 下午3:50:10
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
	 * @date 2015-1-9 下午3:50:12
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
	 * @date 2015-1-9 下午3:50:14
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
	 * @date 2015-1-9 下午3:50:16
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
	 * @date 2015-1-9 下午3:50:19
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
	 * @date 2015-1-9 下午3:50:22
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
	 * @date 2015-1-9 下午3:50:24
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
	 * @date 2015-1-9 下午3:50:27
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
	 * @date 2015-1-9 下午3:50:29
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
	 * @date 2015-1-9 下午3:50:31
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
	 * @date 2015-1-9 下午3:50:33
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
	 * @date 2015-1-9 下午3:50:34
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
	 * @date 2015-1-9 下午3:50:55
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
	 * @date 2015-1-9 下午3:50:57
	 * @param undertakeDeptCode
	 * @see
	 */
	public void setUndertakeDeptCode(String undertakeDeptCode) {
		this.undertakeDeptCode = undertakeDeptCode;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:51:04
	 * @return
	 * @see
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:51:07
	 * @param checkType
	 * @see
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:51:14
	 * @return
	 * @see
	 */
	public int getIsSysCheckInt() {
		return isSysCheckInt;
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午3:51:16
	 * @param isSysCheckInt
	 * @see
	 */
	public void setIsSysCheckInt(int isSysCheckInt) {
		this.isSysCheckInt = isSysCheckInt;
	}

	/**
	 * @return the isPass
	 */
	public String getIsPass() {
		return isPass;
	}

	/**
	 * @param isPass
	 *            the isPass to set
	 */
	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

}
