package com.deppon.dpm.module.wfs.shared.domain.dppm;


/**
 * 
 * 变更审核实体类
 * @author 150970
 * @date 2014年11月25日 上午10:00:30
 * @since
 * @version
 */
public class ChangeCheckEntity extends ChangeEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目ID
	 */
	private Integer projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目类型
	 */
	private Integer projectType;
	/**
	 * 项目状态
	 */
	private Integer projectStatus;
	/**
	 * 项目经理
	 */
	private String pmId1Name;
	/**
	 * 项目发起人
	 */
	private String initiatorName;
	/**
	 * 版本号
	 */
	private String ghVersion;
	/**
	 * 所属系统
	 */
	private Integer subsys;
	/**
	 * 所属系统描述
	 */
	private String sysLabel;
	/**
	 * 流程实例ID
	 */
    private Long[] processIds;
    /**
	 * 是否同意
	 */
    private Integer isAgree;
    /**
	 * 审批意见
	 */
    private String approveOpinion;
    /**
	 * 工作项ID
	 */
    private Long workItemId;
    /**
	 * 活动节点ID
	 */
    private String activityDefId;
    /**
     * 审批实体
     */
    private ApprovelEntity approvelEntity;
    
    
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
	 * @return  the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return  the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return  the projectType
	 */
	public Integer getProjectType() {
		return projectType;
	}

	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	/**
	 * @return  the projectStatus
	 */
	public Integer getProjectStatus() {
		return projectStatus;
	}

	/**
	 * @param projectStatus the projectStatus to set
	 */
	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	/**
	 * @return  the pmId1Name
	 */
	public String getPmId1Name() {
		return pmId1Name;
	}

	/**
	 * @param pmId1Name the pmId1Name to set
	 */
	public void setPmId1Name(String pmId1Name) {
		this.pmId1Name = pmId1Name;
	}

	/**
	 * @return  the initiatorName
	 */
	public String getInitiatorName() {
		return initiatorName;
	}

	/**
	 * @param initiatorName the initiatorName to set
	 */
	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	/**
	 * @return  the ghVersion
	 */
	public String getGhVersion() {
		return ghVersion;
	}

	/**
	 * @param ghVersion the ghVersion to set
	 */
	public void setGhVersion(String ghVersion) {
		this.ghVersion = ghVersion;
	}

	/**
	 * @return  the subsys
	 */
	public Integer getSubsys() {
		return subsys;
	}

	/**
	 * @param subsys the subsys to set
	 */
	public void setSubsys(Integer subsys) {
		this.subsys = subsys;
	}

	/**
	 * @return  the sysLabel
	 */
	public String getSysLabel() {
		return sysLabel;
	}

	/**
	 * @param sysLabel the sysLabel to set
	 */
	public void setSysLabel(String sysLabel) {
		this.sysLabel = sysLabel;
	}

	/**
	 * @return  the processIds
	 */
	public Long[] getProcessIds() {
		return processIds;
	}

	/**
	 * @param processIds the processIds to set
	 */
	public void setProcessIds(Long[] processIds) {
		this.processIds = processIds;
	}

	/**
	 * @return  the isAgree
	 */
	public Integer getIsAgree() {
		return isAgree;
	}

	/**
	 * @param isAgree the isAgree to set
	 */
	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}

	/**
	 * @return  the approveOpinion
	 */
	public String getApproveOpinion() {
		return approveOpinion;
	}

	/**
	 * @param approveOpinion the approveOpinion to set
	 */
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	/**
	 * @return  the workItemId
	 */
	public Long getWorkItemId() {
		return workItemId;
	}

	/**
	 * @param workItemId the workItemId to set
	 */
	public void setWorkItemId(Long workItemId) {
		this.workItemId = workItemId;
	}

	/**
	 * @return  the activityDefId
	 */
	public String getActivityDefId() {
		return activityDefId;
	}

	/**
	 * @param activityDefId the activityDefId to set
	 */
	public void setActivityDefId(String activityDefId) {
		this.activityDefId = activityDefId;
	}
}
