package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.dpm.module.projecttools.shared.domain.FileEntity;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 项目实体类
 * @author 150970
 * @date 2014年10月23日 下午1:57:18
 * @since
 * @version
 */
public class ProjectEntity extends BaseEntity {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 自增ID
	 */
	private Integer aiId;
	/**
	 * 项目ID
	 */
	private Integer projectId;
	/**
	 * 项目编码
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目简称
	 */
	private String shortName;
	/**
	 * 项目状态
	 */
	private String projectStatus;
	/**
	 * 项目审批状态
	 */
	private Integer eaStatus;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 项目级别
	 */
	private String projectLevel;
	/**
	 * 所属系统
	 */
	private String subsys;
	/**
	 * 承接部门
	 */
	private String overtake;
	/**
	 * 是否涉及战略指标
	 */
	private Integer strategic;
	/**
	 * 立项时间
	 */
	private Date createTime;
	/**
	 * 结项时间
	 */
	private Date finishTime;
	/**
	 * 项目发起人
	 */
	private String initiator;
	/**
	 * 发起人部门
	 */
	private String initiatorDept;
	/**
	 * 项目功能点
	 */
	private Integer funcCnt;
	/**
	 * 项目实施方式
	 */
	private String implentments;
	/**
	 * 开发方式
	 */
	private String devModels;
	/**
	 * 咨询公司
	 */
	private String consultancy;
	/**
	 * 项目编码
	 */
	private String code;
	/**
	 * 子项目管理经理
	 */
	private String subPmId;
	/**
	 * IT子项目启动时间
	 */
	private Date subLaunchtime;
	/**
	 * 项目经理（甲方）
	 */
	private String pmId1;
	/**
	 * 项目经理（乙方）
	 */
	private String pmId2;
	/**
	 * 工作量
	 */
	private Integer workload;
	/**
	 * 项目简介
	 */
	private String projectProfile;
	/**
	 * 项目总成本
	 */
	private int totalCosts;
	/**
	 * 是否有效
	 */
	private Integer deleted;
	/**
	 * 项目创建者工号
	 */
	private String creator;
	/**
	 * 项目当前审批人工号
	 */
	private String currenEa;
	/**
	 * 当前状态
	 */
	private Integer currentStatus;
	/**
	 * 所属系统描述
	 */
	private String sysLabel;
	/**
	 * 项目类型描述
	 */
	private String projectTypeLabel;
	/**
	 * 项目级别描述
	 */
	private String projectLevelLabel;
	/**
	 * 项目状态描述
	 */
	private String projectStatusLabel;
	/**
	 * 版本号
	 */
	private String ghVersion;
	/**
	 * 发起人姓名
	 */
	private String initiatorName;
	/**
	 * 项目经理姓名
	 */
	private String pmId1Name;
	/**
	 * 项目经理姓名
	 */
	private String managerName;
	/**
	 * 承接部门名称
	 */
	private String overtakeName;
	/**
	 * 结项，落地
	 */
	private String submitType;
	/**
	 * 结项时间
	 */
	private String closingTime;
	/**
	 * 是否通过 
	 */
	private String isPass;
	
	/**是否涉及UI*/
	private String needUi;
	/**是否移动化*/
	private String needMobile;
	/**
	 * 年份
	 */
	private Integer ghYear;
	//附件
	private List<FileEntity> fileList;
	//审批
	private ApprovelEntity approvelEntity;
	// 项目审批是否结束
	private int wfsIsOver;
	//下一审批人信息
	private String nextEmpCode;
	
	/**
	 * needUi
	 * 2016-1-27
	 * @return
	 */
	public String getNeedUi() {
        return needUi;
    }
	/**
	 * needUi
	 * 2016-1-27
	 * @param needUi
	 */
    public void setNeedUi(String needUi) {
        this.needUi = needUi;
    }
    /**
     * needMobile
     * 2016-1-27
     * @return
     */
    public String getNeedMobile() {
        return needMobile;
    }
    /**
     * needMobile
     * 2016-1-27
     * @param needMobile
     */
    public void setNeedMobile(String needMobile) {
        this.needMobile = needMobile;
    }
    /**
	 * @return the initiatorDept
	 */
	public String getInitiatorDept() {
		return initiatorDept;
	}
	/**
	 * @param initiatorDept
	 */
	public void setInitiatorDept(String initiatorDept) {
		this.initiatorDept = initiatorDept;
	}
	/**
	 * @return the nextEmpCode
	 */
	public String getNextEmpCode() {
		return nextEmpCode;
	}
	/**
	 * @param nextEmpCode
	 */
	public void setNextEmpCode(String nextEmpCode) {
		this.nextEmpCode = nextEmpCode;
	}
	/**
	 * @return the wfsIsOver
	 */
	public int getWfsIsOver() {
		return wfsIsOver;
	}
	/**
	 * @param wfsIsOver
	 */
	public void setWfsIsOver(int wfsIsOver) {
		this.wfsIsOver = wfsIsOver;
	}
	/**
	 * jsonString
	 */
	@JSONField(serialize=false)
	private String jsonString;
	
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
	public List<FileEntity> getFileList() {
		return fileList;
	}
	/**
	 * @param fileList
	 */
	public void setFileList(List<FileEntity> fileList) {
		this.fileList = fileList;
	}
	/**
	 * @return  the ghYear
	 */
	public Integer getGhYear() {
		return ghYear;
	}
	/**
	 * @param ghYear the ghYear to set
	 */
	public void setGhYear(Integer ghYear) {
		this.ghYear = ghYear;
	}
	/**
	 * @return  the jsonString
	 */
	public String getJsonString() {
		return jsonString;
	}
	/**
	 * @param jsonString the jsonString to set
	 */
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	/**
	 * @return  the aiId
	 */
	public Integer getAiId() {
		return aiId;
	}
	/**
	 * @param aiId the aiId to set
	 */
	public void setAiId(Integer aiId) {
		this.aiId = aiId;
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
	 * @return  the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}
	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
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
	 * @return  the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	/**
	 * @return the projectStatus
	 */
	public String getProjectStatus() {
		return projectStatus;
	}
	/**
	 * @param projectStatus
	 */
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	/**
	 * @return  the eaStatus
	 */
	public Integer getEaStatus() {
		return eaStatus;
	}
	/**
	 * @param eaStatus the eaStatus to set
	 */
	public void setEaStatus(Integer eaStatus) {
		this.eaStatus = eaStatus;
	}
	
	/**
	 * @return  the overtake
	 */
	public String getOvertake() {
		return overtake;
	}
	/**
	 * @param overtake the overtake to set
	 */
	public void setOvertake(String overtake) {
		this.overtake = overtake;
	}
	/**
	 * @return  the strategic
	 */
	public Integer getStrategic() {
		return strategic;
	}
	/**
	 * @param strategic the strategic to set
	 */
	public void setStrategic(Integer strategic) {
		this.strategic = strategic;
	}
	/**
	 * @return  the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return  the finishTime
	 */
	public Date getFinishTime() {
		return finishTime;
	}
	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	/**
	 * @return  the initiator
	 */
	public String getInitiator() {
		return initiator;
	}
	/**
	 * @param initiator the initiator to set
	 */
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	/**
	 * @return  the funcCnt
	 */
	public Integer getFuncCnt() {
		return funcCnt;
	}
	/**
	 * @param funcCnt the funcCnt to set
	 */
	public void setFuncCnt(Integer funcCnt) {
		this.funcCnt = funcCnt;
	}
	
	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * @param projectType
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * @return the projectLevel
	 */
	public String getProjectLevel() {
		return projectLevel;
	}
	/**
	 * @param projectLevel
	 */
	public void setProjectLevel(String projectLevel) {
		this.projectLevel = projectLevel;
	}
	/**
	 * @return the subsys
	 */
	public String getSubsys() {
		return subsys;
	}
	/**
	 * @param subsys
	 */
	public void setSubsys(String subsys) {
		this.subsys = subsys;
	}
	/**
	 * @return the implentments
	 */
	public String getImplentments() {
		return implentments;
	}
	/**
	 * @param implentments
	 */
	public void setImplentments(String implentments) {
		this.implentments = implentments;
	}
	/**
	 * @return the devModels
	 */
	public String getDevModels() {
		return devModels;
	}
	/**
	 * @param devModels
	 */
	public void setDevModels(String devModels) {
		this.devModels = devModels;
	}
	/**
	 * @return  the consultancy
	 */
	public String getConsultancy() {
		return consultancy;
	}
	/**
	 * @param consultancy the consultancy to set
	 */
	public void setConsultancy(String consultancy) {
		this.consultancy = consultancy;
	}
	/**
	 * @return  the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return  the subPmId
	 */
	public String getSubPmId() {
		return subPmId;
	}
	/**
	 * @param subPmId the subPmId to set
	 */
	public void setSubPmId(String subPmId) {
		this.subPmId = subPmId;
	}
	/**
	 * @return  the subLaunchtime
	 */
	public Date getSubLaunchtime() {
		return subLaunchtime;
	}
	/**
	 * @param subLaunchtime the subLaunchtime to set
	 */
	public void setSubLaunchtime(Date subLaunchtime) {
		this.subLaunchtime = subLaunchtime;
	}
	/**
	 * @return  the pmId1
	 */
	public String getPmId1() {
		return pmId1;
	}
	/**
	 * @param pmId1 the pmId1 to set
	 */
	public void setPmId1(String pmId1) {
		this.pmId1 = pmId1;
	}
	/**
	 * @return  the pmId2
	 */
	public String getPmId2() {
		return pmId2;
	}
	/**
	 * @param pmId2 the pmId2 to set
	 */
	public void setPmId2(String pmId2) {
		this.pmId2 = pmId2;
	}
	/**
	 * @return  the workload
	 */
	public Integer getWorkload() {
		return workload;
	}
	/**
	 * @param workload the workload to set
	 */
	public void setWorkload(Integer workload) {
		this.workload = workload;
	}
	/**
	 * @return  the projectProfile
	 */
	public String getProjectProfile() {
		return projectProfile;
	}
	/**
	 * @param projectProfile the projectProfile to set
	 */
	public void setProjectProfile(String projectProfile) {
		this.projectProfile = projectProfile;
	}
	/**
	 * @return  the totalCosts
	 */
	public int getTotalCosts() {
		return totalCosts;
	}
	/**
	 * @param totalCosts the totalCosts to set
	 */
	public void setTotalCosts(int totalCosts) {
		this.totalCosts = totalCosts;
	}
	/**
	 * @return  the deleted
	 */
	public Integer getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return  the creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return  the currenEa
	 */
	public String getCurrenEa() {
		return currenEa;
	}
	/**
	 * @param currenEa the currenEa to set
	 */
	public void setCurrenEa(String currenEa) {
		this.currenEa = currenEa;
	}
	/**
	 * @return  the currentStatus
	 */
	public Integer getCurrentStatus() {
		return currentStatus;
	}
	/**
	 * @param currentStatus the currentStatus to set
	 */
	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
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
	 * @return  the projectTypeLabel
	 */
	public String getProjectTypeLabel() {
		return projectTypeLabel;
	}
	/**
	 * @param projectTypeLabel the projectTypeLabel to set
	 */
	public void setProjectTypeLabel(String projectTypeLabel) {
		this.projectTypeLabel = projectTypeLabel;
	}
	/**
	 * @return  the projectLevelLabel
	 */
	public String getProjectLevelLabel() {
		return projectLevelLabel;
	}
	/**
	 * @param projectLevelLabel the projectLevelLabel to set
	 */
	public void setProjectLevelLabel(String projectLevelLabel) {
		this.projectLevelLabel = projectLevelLabel;
	}
	/**
	 * @return  the projectStatusLabel
	 */
	public String getProjectStatusLabel() {
		return projectStatusLabel;
	}
	/**
	 * @param projectStatusLabel the projectStatusLabel to set
	 */
	public void setProjectStatusLabel(String projectStatusLabel) {
		this.projectStatusLabel = projectStatusLabel;
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
	 * @return  the managerName
	 */
	public String getManagerName() {
		return managerName;
	}
	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * @return  the overtakeName
	 */
	public String getOvertakeName() {
		return overtakeName;
	}
	/**
	 * @param overtakeName the overtakeName to set
	 */
	public void setOvertakeName(String overtakeName) {
		this.overtakeName = overtakeName;
	}
	/**
	 * @return  the submitType
	 */
	public String getSubmitType() {
		return submitType;
	}
	/**
	 * @param submitType the submitType to set
	 */
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	/**
	 * @return  the closingTime
	 */
	public String getClosingTime() {
		return closingTime;
	}
	/**
	 * @param closingTime the closingTime to set
	 */
	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}
	/**
	 * @return  the isPass
	 */
	public String getIsPass() {
		return isPass;
	}
	/**
	 * @param isPass the isPass to set
	 */
	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}
}
