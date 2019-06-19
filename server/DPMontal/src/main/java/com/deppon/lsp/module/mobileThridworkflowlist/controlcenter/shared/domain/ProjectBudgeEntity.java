package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 *<pre>
 *功能:项目预算主表实体类
 *作者：蒋小洋
 *日期：2013-12-12下午1:53:36
 *</pre>
 */
public class ProjectBudgeEntity extends BaseEntity{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3257415060176604899L;

	/**
	 * 创建者
	 */
	private String creatorId;
	
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
	private String projectNumberid;
	
	/**
	 * 模版
	 */
	private String maid;
	
	/**
	 * 所属事业部
	 */
	private String departmentId;
	
	/**
	 * 工程项目名称
	 */
	private String projectName;
	
	/**
	 * 调整金额
	 */
	private BigDecimal adjustAmount;
	
	/**
	 * 调正前汇总金额
	 */
	private BigDecimal budgetCollect;
	
	/**
	 * 调整后汇总金额
	 */
	private BigDecimal budgetCollected;
	
	/**
	 * 项目状态
	 */
	private String projectStype;
	
	/**
	 * 变更原因
	 */
	private String changereasonId;
	
	/**
	 * 单据状态
	 */
	private String state;
	
	/**
	 * 创建部门
	 */
	private String creatorgId;
	
	/**
	 * 预算明细调整单
	 */
	private String detailBudgetNumbe;
	
	/**
	 * 存前面版本ID
	 */
	private String beforeId;
	
	/**
	 * 税率
	 */
	private BigDecimal taxAtionratio;
	
	/**
	 * 税金
	 */
	private BigDecimal expenseTaxation;
	
	/**
	 * 含税总金额
	 */
	private BigDecimal amountIncludeRaxation;
	
	//工程调整单编号
	private String projectNumber;
	//所属事业部
	private String department;
	//申请部门
	private String creatorg;
	//申请人
	private String creator;
	//预算明细编号
	private String detailBudget;
	//变更原因
	private String changereason;
	//模版
	private String ma;
	//项目状态
	private String projectState;
	//网点非网点
	private String projectModel;
	//优惠金额
	private BigDecimal discount;
	
	//将BigDecimal转换为String类型。
	/**
	 * 调整金额
	 */
	private String adjustAmountDto;
	/**
	 * 调正前汇总金额
	 */
	private String budgetCollectDto;
	
	/**
	 * 调整后汇总金额
	 */
	private String budgetCollectedDto;
	/**
	 * 税率
	 */
	private String taxAtionratioDto;
	
	/**
	 * 税金
	 */
	private String expenseTaxationDto;
	
	/**
	 * 含税总金额
	 */
	private String amountIncludeRaxationDto;
	//优惠金额
	private String discountDto;
	//供应商
	private String cfSupplierIdAsName;
	

	public String getCfSupplierIdAsName() {
		return cfSupplierIdAsName;
	}

	public void setCfSupplierIdAsName(String cfSupplierIdAsName) {
		this.cfSupplierIdAsName = cfSupplierIdAsName;
	}

	public String getAdjustAmountDto() {
		return adjustAmountDto;
	}

	public void setAdjustAmountDto(String adjustAmountDto) {
		this.adjustAmountDto = adjustAmountDto;
	}

	public String getBudgetCollectDto() {
		return budgetCollectDto;
	}

	public void setBudgetCollectDto(String budgetCollectDto) {
		this.budgetCollectDto = budgetCollectDto;
	}

	public String getBudgetCollectedDto() {
		return budgetCollectedDto;
	}

	public void setBudgetCollectedDto(String budgetCollectedDto) {
		this.budgetCollectedDto = budgetCollectedDto;
	}

	public String getTaxAtionratioDto() {
		return taxAtionratioDto;
	}

	public void setTaxAtionratioDto(String taxAtionratioDto) {
		this.taxAtionratioDto = taxAtionratioDto;
	}

	public String getExpenseTaxationDto() {
		return expenseTaxationDto;
	}

	public void setExpenseTaxationDto(String expenseTaxationDto) {
		this.expenseTaxationDto = expenseTaxationDto;
	}

	public String getAmountIncludeRaxationDto() {
		return amountIncludeRaxationDto;
	}

	public void setAmountIncludeRaxationDto(String amountIncludeRaxationDto) {
		this.amountIncludeRaxationDto = amountIncludeRaxationDto;
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

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getProjectState() {
		return projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	public String getChangereason() {
		return changereason;
	}

	public void setChangereason(String changereason) {
		this.changereason = changereason;
	}

	public String getDetailBudget() {
		return detailBudget;
	}

	public void setDetailBudget(String detailBudget) {
		this.detailBudget = detailBudget;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCreatorg() {
		return creatorg;
	}

	public void setCreatorg(String creatorg) {
		this.creatorg = creatorg;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
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
	 * @return  the projectNumberid
	 */
	public String getProjectNumberid() {
		return projectNumberid;
	}

	/**
	 * @param projectNumberid the projectNumberid to set
	 */
	public void setProjectNumberid(String projectNumberid) {
		this.projectNumberid = projectNumberid;
	}

	/**
	 * @return  the maid
	 */
	public String getMaid() {
		return maid;
	}

	/**
	 * @param maid the maid to set
	 */
	public void setMaid(String maid) {
		this.maid = maid;
	}

	/**
	 * @return  the departmentId
	 */
	public String getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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
	 * @return  the adjustAmount
	 */
	public BigDecimal getAdjustAmount() {
		return adjustAmount;
	}

	/**
	 * @param adjustAmount the adjustAmount to set
	 */
	public void setAdjustAmount(BigDecimal adjustAmount) {
		this.adjustAmount = adjustAmount;
	}

	/**
	 * @return  the budgetCollect
	 */
	public BigDecimal getBudgetCollect() {
		return budgetCollect;
	}

	/**
	 * @param budgetCollect the budgetCollect to set
	 */
	public void setBudgetCollect(BigDecimal budgetCollect) {
		this.budgetCollect = budgetCollect;
	}

	/**
	 * @return  the budgetCollected
	 */
	public BigDecimal getBudgetCollected() {
		return budgetCollected;
	}

	/**
	 * @param budgetCollected the budgetCollected to set
	 */
	public void setBudgetCollected(BigDecimal budgetCollected) {
		this.budgetCollected = budgetCollected;
	}

	/**
	 * @return  the projectStype
	 */
	public String getProjectStype() {
		return projectStype;
	}

	/**
	 * @param projectStype the projectStype to set
	 */
	public void setProjectStype(String projectStype) {
		this.projectStype = projectStype;
	}

	/**
	 * @return  the changereasonId
	 */
	public String getChangereasonId() {
		return changereasonId;
	}

	/**
	 * @param changereasonId the changereasonId to set
	 */
	public void setChangereasonId(String changereasonId) {
		this.changereasonId = changereasonId;
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
	 * @return  the creatorgId
	 */
	public String getCreatorgId() {
		return creatorgId;
	}

	/**
	 * @param creatorgId the creatorgId to set
	 */
	public void setCreatorgId(String creatorgId) {
		this.creatorgId = creatorgId;
	}

	/**
	 * @return  the detailBudgetNumbe
	 */
	public String getDetailBudgetNumbe() {
		return detailBudgetNumbe;
	}

	/**
	 * @param detailBudgetNumbe the detailBudgetNumbe to set
	 */
	public void setDetailBudgetNumbe(String detailBudgetNumbe) {
		this.detailBudgetNumbe = detailBudgetNumbe;
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
	 * @return  the taxAtionratio
	 */
	public BigDecimal getTaxAtionratio() {
		return taxAtionratio;
	}

	/**
	 * @param taxAtionratio the taxAtionratio to set
	 */
	public void setTaxAtionratio(BigDecimal taxAtionratio) {
		this.taxAtionratio = taxAtionratio;
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
	 * @return  the amountIncludeRaxation
	 */
	public BigDecimal getAmountIncludeRaxation() {
		return amountIncludeRaxation;
	}

	/**
	 * @param amountIncludeRaxation the amountIncludeRaxation to set
	 */
	public void setAmountIncludeRaxation(BigDecimal amountIncludeRaxation) {
		this.amountIncludeRaxation = amountIncludeRaxation;
	}
	
}
