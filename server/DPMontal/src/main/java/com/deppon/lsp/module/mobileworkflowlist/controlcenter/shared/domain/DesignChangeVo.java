package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 设计变更单Vo
 * @author jiafangyao
 *
 */
public class DesignChangeVo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8281781526797266662L;
	/**
	 * 项目编码ID
	 */
	private String projectNumId;

	/**
	 * 项目编码
	 */
	private String projectNumber;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 原始单据ID
	 */
	private String sourceBillId;

	/**
	 * 原始单据号
	 */
	private String sourceBillNumber;
	/**
	 * 单据状态值
	 */
	private String state;

	/**
	 * 单据状态名称
	 */
	private String stateName;

	/**
	 * 创建部门ID
	 */
	private String creatorGid;
	/**
	 * 创建部门名称
	 */
	private String creatorGName;
	/**
	 * 变更发起人ID
	 */
	private String changeSponsorId;
	/**
	 * 变更发起人姓名
	 */
	private String changeSponsorName;
	/**
	 * 变更原因ID
	 */
	private String reasonChangeId;

	/**
	 * 变更原因描述
	 */
	private String reasonChangeDesc;
	/**
	 * 设计总面积
	 */
	private Double desiginArea;
	/**
	 * 变更前概算费用
	 */
	private Double changeEstimateCost;
	/**
	 * 设计部门ID
	 */
	private String designDempId;

	/**
	 * 设计部门名称
	 */
	private String designDempName;
	/**
	 * 施工负责部门Id
	 */
	private String constructDepartm;

	/**
	 * 施工负责部门名称
	 */
	private String constructDepartmName;
	/**
	 * 变更概算费用
	 */
	private Double changeCost;
	/**
	 * 变更类型ID
	 */
	private String change;

	/**
	 * 变更类型名称
	 */
	private String changeName;

	/**
	 * 变更后设计难度
	 */
	private String changeDesignDifficulty;

	/**
	 * 具体描述
	 */
	private String specificDescribe;
	/**
	 * 创建者姓名
	 */
	private String createName;
	/**
	 * 最后控制单无
	 */
	private String controlUnitId;
	/**
	 * 单据编号
	 */
	private String number;
	/**
	 * 业务日期
	 */
	private Date bizDate;
	/**
	 * 经手人ID
	 */
	private String handlerId;

	/**
	 * 参考信息
	 */
	private String description;
	/**
	 * 是否曾经生效
	 */
	private Integer hasefFected;
	/**
	 * 审核人ID
	 */
	private String auditorId;
	/**
	 * 审核人姓名
	 */
	private String auditorName;

	/**
	 * 来源功能
	 */
	private String sourceFunction;

	/**
	 * 是否生成凭证
	 */
	private Integer fivouchered;

	/**
	 * 原设计单编号
	 */
	private String initialDesignNumber;

	/**
	 * 审核时间
	 */
	private Date auditTime;

	/**
	 * 版本号
	 */
	private String fersion;

	private String hsefFected;

	private String designDepId;
	
	/**
	 * 是否含土建
	 */
	private String cfIsContain;
	/**
	 * 分部工程
	 */
	private String cfEnginDivitionIDAsName;
	
	/**
	 * 勘测人员
	 */
	private String fsurveyorsID;
	/**
	 * 勘测时间
	 */
	private Date fsurveyTime;
	/**
	 * 基本面积
	 */
	private Double fbasicArea;
	
	

	public String getCfIsContain() {
		return cfIsContain;
	}

	public void setCfIsContain(String cfIsContain) {
		this.cfIsContain = cfIsContain;
	}

	public String getCfEnginDivitionIDAsName() {
		return cfEnginDivitionIDAsName;
	}

	public void setCfEnginDivitionIDAsName(String cfEnginDivitionIDAsName) {
		this.cfEnginDivitionIDAsName = cfEnginDivitionIDAsName;
	}

	public String getFsurveyorsID() {
		return fsurveyorsID;
	}

	public void setFsurveyorsID(String fsurveyorsID) {
		this.fsurveyorsID = fsurveyorsID;
	}

	public Date getFsurveyTime() {
		return fsurveyTime;
	}

	public void setFsurveyTime(Date fsurveyTime) {
		this.fsurveyTime = fsurveyTime;
	}

	public Double getFbasicArea() {
		return fbasicArea;
	}

	public void setFbasicArea(Double fbasicArea) {
		this.fbasicArea = fbasicArea;
	}

	public String getProjectNumId() {
		return projectNumId;
	}

	public void setProjectNumId(String projectNumId) {
		this.projectNumId = projectNumId;
	}

	public String getProjectName() {
		if (projectName == null) {
			return "";
		}
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSourceBillId() {
		return sourceBillId;
	}

	public void setSourceBillId(String sourceBillId) {
		this.sourceBillId = sourceBillId;
	}

	public String getState() {
		if (state == null) {
			return "";
		}
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateName() {
		if (stateName == null ) {
			stateName = "";
		}
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCreatorGid() {
		return creatorGid;
	}

	public void setCreatorGid(String creatorGid) {
		this.creatorGid = creatorGid;
	}

	public String getCreatorGName() {
		if (creatorGName == null){
			return "";
		}
		return creatorGName;
	}

	public void setCreatorGName(String creatorGName) {
		this.creatorGName = creatorGName;
	}

	public String getChangeSponsorId() {
		return changeSponsorId;
	}

	public void setChangeSponsorId(String changeSponsorId) {
		this.changeSponsorId = changeSponsorId;
	}

	public String getChangeSponsorName() {
		if (changeSponsorName == null) {
			return "";
		}
		return changeSponsorName;
	}

	public void setChangeSponsorName(String changeSponsorName) {
		this.changeSponsorName = changeSponsorName;
	}

	public String getReasonChangeId() {
		return reasonChangeId;
	}

	public void setReasonChangeId(String reasonChangeId) {
		this.reasonChangeId = reasonChangeId;
	}

	public String getReasonChangeDesc() {
		if (reasonChangeDesc == null) {
			return "";
		}
		return reasonChangeDesc;
	}

	public void setReasonChangeDesc(String reasonChangeDesc) {
		this.reasonChangeDesc = reasonChangeDesc;
	}

	public Double getDesiginArea() {
		return desiginArea;
	}

	public String getDesiginAreaStr(){
		if (desiginArea == null) {
			return "";
		}else {
			return ("" + desiginArea);
		}
	}
	
	public void setDesiginArea(Double desiginArea) {
		this.desiginArea = desiginArea;
	}

	public Double getChangeEstimateCost() {
		return changeEstimateCost;
	}
	
	public String getChangeEstimateCostStr() {
		if (changeEstimateCost == null) {
			return "";
		}else {
			return ("" + changeEstimateCost);
		}
	}

	public void setChangeEstimateCost(Double changeEstimateCost) {
		this.changeEstimateCost = changeEstimateCost;
	}

	public String getDesignDempId() {
		return designDempId;
	}

	public void setDesignDempId(String designDempId) {
		this.designDempId = designDempId;
	}

	public String getDesignDempName() {
		if (designDempName == null) {
			return "";
		}
		return designDempName;
	}

	public void setDesignDempName(String designDempName) {
		this.designDempName = designDempName;
	}

	public String getConstructDepartm() {
		return constructDepartm;
	}

	public void setConstructDepartm(String constructDepartm) {
		this.constructDepartm = constructDepartm;
	}

	public String getConstructDepartmName() {
		if (constructDepartmName == null) {
			constructDepartmName = "";
		}
		return constructDepartmName;
	}

	public void setConstructDepartmName(String constructDepartmName) {
		this.constructDepartmName = constructDepartmName;
	}

	public Double getChangeCost() {
		return changeCost;
	}

	public String getChangeCostStr() {
		if (changeCost == null) {
			return "";
		}
		return ("" + changeCost);
	}
	
	public void setChangeCost(Double changeCost) {
		this.changeCost = changeCost;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getChangeName() {
		if (changeName == null) {
			changeName = "";
		}
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getChangeDesignDifficulty() {
		if (changeDesignDifficulty == null ) {
			changeDesignDifficulty = "";
		}
		return changeDesignDifficulty;
	}

	public void setChangeDesignDifficulty(String changeDesignDifficulty) {
		this.changeDesignDifficulty = changeDesignDifficulty;
	}

	public String getSpecificDescribe() {
		if (specificDescribe == null) {
			specificDescribe = "";
		}
		return specificDescribe;
	}

	public void setSpecificDescribe(String specificDescribe) {
		this.specificDescribe = specificDescribe;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getControlUnitId() {
		return controlUnitId;
	}

	public void setControlUnitId(String controlUnitId) {
		this.controlUnitId = controlUnitId;
	}

	public String getNumber() {
		if (number == null) {
			number = "";
		}
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getBizDate() {
		return bizDate;
	}

	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

	public String getHandlerId() {
		return handlerId;
	}

	public void setHandlerId(String handlerId) {
		this.handlerId = handlerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHasefFected() {
		return hasefFected;
	}

	public void setHasefFected(Integer hasefFected) {
		this.hasefFected = hasefFected;
	}

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public String getSourceFunction() {
		return sourceFunction;
	}

	public void setSourceFunction(String sourceFunction) {
		this.sourceFunction = sourceFunction;
	}

	public Integer getFivouchered() {
		return fivouchered;
	}

	public void setFivouchered(Integer fivouchered) {
		this.fivouchered = fivouchered;
	}

	public String getInitialDesignNumber() {
		return initialDesignNumber;
	}

	public void setInitialDesignNumber(String initialDesignNumber) {
		this.initialDesignNumber = initialDesignNumber;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getFersion() {
		return fersion;
	}

	public void setFersion(String fersion) {
		this.fersion = fersion;
	}

	public String getHsefFected() {
		return hsefFected;
	}

	public void setHsefFected(String hsefFected) {
		this.hsefFected = hsefFected;
	}

	public String getDesignDepId() {
		return designDepId;
	}

	public void setDesignDepId(String designDepId) {
		this.designDepId = designDepId;
	}

	public String getProjectNumber() {
		if (projectNumber == null) {
			return "";
		}
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getSourceBillNumber() {
		if (sourceBillNumber == null) {
			return null;
		}
		return sourceBillNumber;
	}

	public void setSourceBillNumber(String sourceBillNumber) {
		this.sourceBillNumber = sourceBillNumber;
	}

}