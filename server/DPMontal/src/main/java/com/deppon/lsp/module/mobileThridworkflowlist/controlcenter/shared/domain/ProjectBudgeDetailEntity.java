package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 *<pre>
 *功能:工程项目预算明细实体类
 *作者：蒋小洋
 *日期：2013-12-20下午2:13:19
 *</pre>
 */
public class ProjectBudgeDetailEntity extends BaseEntity{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 8205244299312922589L;

	/**
	 * 创建者
	 */
	private String creatorId;
	/**
	 * 项目类型
	 */
	private String cfprojectType;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后修改者
	 */
	private String lastUpdateUserId;
	
	/**
	 * 最后修改时间
	 */
	private Date lastUpdateTime;
	
	/**
	 * 控制单元
	 */
	private String controlunitId;
	
	/**
	 * 单据编号
	 */
	private String number;
	
	/**
	 * 业务日期
	 */
	private Date bizDate;
	
	/**
	 * 经手人
	 */
	private String handlerId;
	
	/**
	 * 参考信息
	 */
	private String description;
	
	/**
	 * 是否曾经生效
	 */
	private Long hasEffected;
	
	/**
	 * 审核人
	 */
	private String auditorId;
	
	/**
	 * 原始单据ID
	 */
	private String sourceBillid;
	
	/**
	 * 来源功能
	 */
	private String sourceFunction;
	
	/**
	 * 主键FID
	 */
	private String fid;
	
	/**
	 * 是否生成凭证
	 */
	private Long fivouchered;
	
	/**
	 * 工程项目编号
	 */
	private String projectNumberId;
	
	/**
	 * 工程项目名称
	 */
	private String projectName;
	
	/**
	 * 所属事业部
	 */
	private String divisionId;
	
	/**
	 * 版本号
	 */
	private String versionNumber;
	
	/**
	 * 单据状态
	 */
	private String state;
	
	/**
	 * 项目状态
	 */
	private String projectState;
	
	/**
	 * 创建部门
	 */
	private String createorgId;
	
	/**
	 * 模板
	 */
	private String templateId;
	
	/**
	 * 分部工程ID
	 */
	private String enginDivisionsId;
	
	/**
	 * 存在前面版本ID
	 */
	private String beforeId;
	
	/**
	 * 项目竣工时间
	 */
	private Date proFinishTime;
	
	/**
	 * 税率
	 */
	private BigDecimal taxationRatio;
	
	/**
	 * 税金
	 */
	private BigDecimal expenseTaxation;
	
	/**
	 * 含税总金额
	 */
	private BigDecimal amountIncludeTaxation;
	
	/**
	 * 总金额
	 */
	private BigDecimal totalPrice;
	
	//网点非网点
	private String projectModel;
	//所属事业部
	private String department;
	//申请部门
	private String creatorg;
	//申请人
	private String creator;
	//工程项目编号
	private String projectNumber;
	//项目状态
	private String projectType;
	//模版
	private String ma;
	//分部工程
	private String enginDivisions;
	
	//优惠金额
	private BigDecimal discount;
	
	//将BigDecimal转换为String类型。
	/**
	 * 税率
	 */
	private String taxationRatioDto;
	/**
	 * 税金
	 */
	private String expenseTaxationDto;
	
	/**
	 * 含税总金额
	 */
	private String amountIncludeTaxationDto;
	
	
	
	/**
	 * 总金额
	 */
	private String totalPriceDto;
	//优惠金额
    private String discountDto;
    
    private String cfSupplierIdAsName;
	
	/**
	 * @return the cfSupplierIdAsName
	 */
	public String getCfSupplierIdAsName() {
		return cfSupplierIdAsName;
	}

	public String getCfprojectType() {
		return cfprojectType;
	}

	public void setCfprojectType(String cfprojectType) {
		this.cfprojectType = cfprojectType;
	}

	/**
	 * @param cfSupplierIdAsName the cfSupplierIdAsName to set
	 */
	public void setCfSupplierIdAsName(String cfSupplierIdAsName) {
		this.cfSupplierIdAsName = cfSupplierIdAsName;
	}

	public String getTaxationRatioDto() {
		return taxationRatioDto;
	}

	public void setTaxationRatioDto(String taxationRatioDto) {
		this.taxationRatioDto = taxationRatioDto;
	}

	public String getExpenseTaxationDto() {
		return expenseTaxationDto;
	}

	public void setExpenseTaxationDto(String expenseTaxationDto) {
		this.expenseTaxationDto = expenseTaxationDto;
	}

	public String getAmountIncludeTaxationDto() {
		return amountIncludeTaxationDto;
	}

	public void setAmountIncludeTaxationDto(String amountIncludeTaxationDto) {
		this.amountIncludeTaxationDto = amountIncludeTaxationDto;
	}

	public String getTotalPriceDto() {
		return totalPriceDto;
	}

	public void setTotalPriceDto(String totalPriceDto) {
		this.totalPriceDto = totalPriceDto;
	}

	public String getDiscountDto() {
		return discountDto;
	}

	public void setDiscountDto(String discountDto) {
		this.discountDto = discountDto;
	}
	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * @return  the enginDivisions
	 */
	public String getEnginDivisions() {
		return enginDivisions;
	}

	/**
	 * @param enginDivisions the enginDivisions to set
	 */
	public void setEnginDivisions(String enginDivisions) {
		this.enginDivisions = enginDivisions;
	}

	/**
	 * @return  the ma
	 */
	public String getMa() {
		return ma;
	}

	/**
	 * @param ma the ma to set
	 */
	public void setMa(String ma) {
		this.ma = ma;
	}

	/**
	 * @return  the projectType
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * @return  the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return  the creatorg
	 */
	public String getCreatorg() {
		return creatorg;
	}

	/**
	 * @param creatorg the creatorg to set
	 */
	public void setCreatorg(String creatorg) {
		this.creatorg = creatorg;
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
	 * @return  the projectNumber
	 */
	public String getProjectNumber() {
		return projectNumber;
	}

	/**
	 * @param projectNumber the projectNumber to set
	 */
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	/**
	 * @return  the projectModel
	 */
	public String getProjectModel() {
		return projectModel;
	}

	/**
	 * @param projectModel the projectModel to set
	 */
	public void setProjectModel(String projectModel) {
		this.projectModel = projectModel;
	}

	/**
	 * @return  the creatorId
	 */
	public String getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
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
	 * @return  the lastUpdateUserId
	 */
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	/**
	 * @param lastUpdateUserId the lastUpdateUserId to set
	 */
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	/**
	 * @return  the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return  the controlunitId
	 */
	public String getControlunitId() {
		return controlunitId;
	}

	/**
	 * @param controlunitId the controlunitId to set
	 */
	public void setControlunitId(String controlunitId) {
		this.controlunitId = controlunitId;
	}

	/**
	 * @return  the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return  the bizDate
	 */
	public Date getBizDate() {
		return bizDate;
	}

	/**
	 * @param bizDate the bizDate to set
	 */
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

	/**
	 * @return  the handlerId
	 */
	public String getHandlerId() {
		return handlerId;
	}

	/**
	 * @param handlerId the handlerId to set
	 */
	public void setHandlerId(String handlerId) {
		this.handlerId = handlerId;
	}

	/**
	 * @return  the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return  the hasEffected
	 */
	public Long getHasEffected() {
		return hasEffected;
	}

	/**
	 * @param hasEffected the hasEffected to set
	 */
	public void setHasEffected(Long hasEffected) {
		this.hasEffected = hasEffected;
	}

	/**
	 * @return  the auditorId
	 */
	public String getAuditorId() {
		return auditorId;
	}

	/**
	 * @param auditorId the auditorId to set
	 */
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	/**
	 * @return  the sourceBillid
	 */
	public String getSourceBillid() {
		return sourceBillid;
	}

	/**
	 * @param sourceBillid the sourceBillid to set
	 */
	public void setSourceBillid(String sourceBillid) {
		this.sourceBillid = sourceBillid;
	}

	/**
	 * @return  the sourceFunction
	 */
	public String getSourceFunction() {
		return sourceFunction;
	}

	/**
	 * @param sourceFunction the sourceFunction to set
	 */
	public void setSourceFunction(String sourceFunction) {
		this.sourceFunction = sourceFunction;
	}

	/**
	 * @return  the fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return  the fivouchered
	 */
	public Long getFivouchered() {
		return fivouchered;
	}

	/**
	 * @param fivouchered the fivouchered to set
	 */
	public void setFivouchered(Long fivouchered) {
		this.fivouchered = fivouchered;
	}

	/**
	 * @return  the projectNumberId
	 */
	public String getProjectNumberId() {
		return projectNumberId;
	}

	/**
	 * @param projectNumberId the projectNumberId to set
	 */
	public void setProjectNumberId(String projectNumberId) {
		this.projectNumberId = projectNumberId;
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
	 * @return  the divisionId
	 */
	public String getDivisionId() {
		return divisionId;
	}

	/**
	 * @param divisionId the divisionId to set
	 */
	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	/**
	 * @return  the versionNumber
	 */
	public String getVersionNumber() {
		return versionNumber;
	}

	/**
	 * @param versionNumber the versionNumber to set
	 */
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	/**
	 * @return  the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return  the projectState
	 */
	public String getProjectState() {
		return projectState;
	}

	/**
	 * @param projectState the projectState to set
	 */
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	/**
	 * @return  the createorgId
	 */
	public String getCreateorgId() {
		return createorgId;
	}

	/**
	 * @param createorgId the createorgId to set
	 */
	public void setCreateorgId(String createorgId) {
		this.createorgId = createorgId;
	}

	/**
	 * @return  the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return  the enginDivisionsId
	 */
	public String getEnginDivisionsId() {
		return enginDivisionsId;
	}

	/**
	 * @param enginDivisionsId the enginDivisionsId to set
	 */
	public void setEnginDivisionsId(String enginDivisionsId) {
		this.enginDivisionsId = enginDivisionsId;
	}

	/**
	 * @return  the beforeId
	 */
	public String getBeforeId() {
		return beforeId;
	}

	/**
	 * @param beforeId the beforeId to set
	 */
	public void setBeforeId(String beforeId) {
		this.beforeId = beforeId;
	}

	/**
	 * @return  the proFinishTime
	 */
	public Date getProFinishTime() {
		return proFinishTime;
	}

	/**
	 * @param proFinishTime the proFinishTime to set
	 */
	public void setProFinishTime(Date proFinishTime) {
		this.proFinishTime = proFinishTime;
	}

	/**
	 * @return  the taxationRatio
	 */
	public BigDecimal getTaxationRatio() {
		return taxationRatio;
	}

	/**
	 * @param taxationRatio the taxationRatio to set
	 */
	public void setTaxationRatio(BigDecimal taxationRatio) {
		this.taxationRatio = taxationRatio;
	}

	/**
	 * @return  the expenseTaxation
	 */
	public BigDecimal getExpenseTaxation() {
		return expenseTaxation;
	}

	/**
	 * @param expenseTaxation the expenseTaxation to set
	 */
	public void setExpenseTaxation(BigDecimal expenseTaxation) {
		this.expenseTaxation = expenseTaxation;
	}

	/**
	 * @return  the amountIncludeTaxation
	 */
	public BigDecimal getAmountIncludeTaxation() {
		return amountIncludeTaxation;
	}

	/**
	 * @param amountIncludeTaxation the amountIncludeTaxation to set
	 */
	public void setAmountIncludeTaxation(BigDecimal amountIncludeTaxation) {
		this.amountIncludeTaxation = amountIncludeTaxation;
	}

	/**
	 * @return  the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
