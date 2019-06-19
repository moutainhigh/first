package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.util.Date;

import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanEntity;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 变更实体类
 * @author 150970
 * @date 2014年11月25日 上午9:59:50
 * @since
 * @version
 */
public class ChangeEntity extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 变更单ID
	 */
	private Integer changeId;
	/**
	 * 变更状态
	 */
	private Integer changeState;
	/**
	 * 变更类型
	 */
    private Integer changeType;
    /**
	 * 工作流号
	 */
    private Long processId;
    /**
	 * 变更单号
	 */
    private String changeCode;
    /**
	 * 变更原因 
	 */
    private String changeReason;
    /**
	 * 创建人
	 */
    private String createEmpName;
    /**
	 * 创建人工号
	 */
    private String createEmpCode;
    /**
	 * 变更审核人
	 */
    private String changeReviewer;
    /**
	 * 审批状态
	 */
    private Integer auditState;
    /**
	 * 创建时间
	 */
    private Date createTime;
    /**
	 * 是否有效
	 */
    private Integer isdelete;
    /**
	 * 变更后关联ID
	 */
    private Integer newAiId;
    /**
	 * 变更前关联ID
	 */
    private Integer oldAiId;
    /**
	 * 变更类型描述
	 */
    private String changeTypeLabel;
    /**
	 * 审批状态描述
	 */
    private String auditStateLabel;
    /**
	 * 项目实体
	 */
    private ProjectEntity projectEntity;
    /**
	 * 年度规划实体
	 */
    private AnnualPlanEntity annualPlanEntity;
    
	/**
	 * @return  the changeId
	 */
	public Integer getChangeId() {
		return changeId;
	}
	/**
	 * @param changeId the changeId to set
	 */
	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}
	/**
	 * @return  the changeState
	 */
	public Integer getChangeState() {
		return changeState;
	}
	/**
	 * @param changeState the changeState to set
	 */
	public void setChangeState(Integer changeState) {
		this.changeState = changeState;
	}
	/**
	 * @return  the changeType
	 */
	public Integer getChangeType() {
		return changeType;
	}
	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}
	/**
	 * @return  the processId
	 */
	public Long getProcessId() {
		return processId;
	}
	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(Long processId) {
		this.processId = processId;
	}
	/**
	 * @return  the changeCode
	 */
	public String getChangeCode() {
		return changeCode;
	}
	/**
	 * @param changeCode the changeCode to set
	 */
	public void setChangeCode(String changeCode) {
		this.changeCode = changeCode;
	}
	/**
	 * @return  the changeReason
	 */
	public String getChangeReason() {
		return changeReason;
	}
	/**
	 * @param changeReason the changeReason to set
	 */
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	/**
	 * @return  the createEmpName
	 */
	public String getCreateEmpName() {
		return createEmpName;
	}
	/**
	 * @param createEmpName the createEmpName to set
	 */
	public void setCreateEmpName(String createEmpName) {
		this.createEmpName = createEmpName;
	}
	/**
	 * @return  the createEmpCode
	 */
	public String getCreateEmpCode() {
		return createEmpCode;
	}
	/**
	 * @param createEmpCode the createEmpCode to set
	 */
	public void setCreateEmpCode(String createEmpCode) {
		this.createEmpCode = createEmpCode;
	}
	/**
	 * @return  the changeReviewer
	 */
	public String getChangeReviewer() {
		return changeReviewer;
	}
	/**
	 * @param changeReviewer the changeReviewer to set
	 */
	public void setChangeReviewer(String changeReviewer) {
		this.changeReviewer = changeReviewer;
	}
	/**
	 * @return  the auditState
	 */
	public Integer getAuditState() {
		return auditState;
	}
	/**
	 * @param auditState the auditState to set
	 */
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
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
	 * @return  the isdelete
	 */
	public Integer getIsdelete() {
		return isdelete;
	}
	/**
	 * @param isdelete the isdelete to set
	 */
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	/**
	 * @return  the newAiId
	 */
	public Integer getNewAiId() {
		return newAiId;
	}
	/**
	 * @param newAiId the newAiId to set
	 */
	public void setNewAiId(Integer newAiId) {
		this.newAiId = newAiId;
	}
	/**
	 * @return  the oldAiId
	 */
	public Integer getOldAiId() {
		return oldAiId;
	}
	/**
	 * @param oldAiId the oldAiId to set
	 */
	public void setOldAiId(Integer oldAiId) {
		this.oldAiId = oldAiId;
	}
	/**
	 * @return  the changeTypeLabel
	 */
	public String getChangeTypeLabel() {
		return changeTypeLabel;
	}
	/**
	 * @param changeTypeLabel the changeTypeLabel to set
	 */
	public void setChangeTypeLabel(String changeTypeLabel) {
		this.changeTypeLabel = changeTypeLabel;
	}
	/**
	 * @return  the auditStateLabel
	 */
	public String getAuditStateLabel() {
		return auditStateLabel;
	}
	/**
	 * @param auditStateLabel the auditStateLabel to set
	 */
	public void setAuditStateLabel(String auditStateLabel) {
		this.auditStateLabel = auditStateLabel;
	}
	/**
	 * @return  the projectEntity
	 */
	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}
	/**
	 * @param projectEntity the projectEntity to set
	 */
	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}
	/**
	 * @return  the annualPlanEntity
	 */
	public AnnualPlanEntity getAnnualPlanEntity() {
		return annualPlanEntity;
	}
	/**
	 * @param annualPlanEntity the annualPlanEntity to set
	 */
	public void setAnnualPlanEntity(AnnualPlanEntity annualPlanEntity) {
		this.annualPlanEntity = annualPlanEntity;
	}
    
}
