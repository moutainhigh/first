package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 *<pre>
 *功能:工程项目预算调整单-分录实体类
 *作者：蒋小洋
 *日期：2013-12-12下午2:33:25
 *</pre>
 */
public class ProjectBudgeEntries extends BaseEntity{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1836827891098746164L;

	/**
	 * 单据分录序列号
	 */
	private Long seq;
	
	/**
	 * 分录主键FID
	 */
	private String fid;
	
	/**
	 * 分录对应外键
	 */
	private String parentId;
	
	/**
	 * 预算项目名称
	 */
	private String budgetProjectName;
	
	/**
	 * 预算类型
	 */
	private String budtupeId;
	
	/**
	 * 供应商
	 */
	private String supplierId;
	
	/**
	 * 单位
	 */
	private String unitsId;
	
	/**
	 * 单价（人工费）
	 */
	private BigDecimal costOfLabor;
	
	/**
	 * 单价（材料费/机械费）
	 */
	private BigDecimal materialCost;
	
	/**
	 * 合计金额
	 */
	private BigDecimal totalAmount;
	
	/**
	 * 是否甲供
	 */
	private BigDecimal giveA;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 施工区域
	 */
	private String conAreaId;
	
	/**
	 * 数量
	 */
	private BigDecimal quanTity;
	
	/**
	 * isNew
	 */
	private Long isNew;
	
	/**
	 * noContractPrice
	 */
	private BigDecimal noContractPrice;
	
	//预算项目名称
	private String projectName;
	//预算项目类型
	private String budtupe;
	//施工区域
	private String conArea;
	//供应商
	private String supplier;
	//单位
	private String units;
	//是否甲供
	private String give;
	//增项时间
	private Date cfIncreasetime;
	//将BigDecimal转换为String类型。
	/**
	 * 单价（人工费）
	 */
	private String costOfLaborDto;
	
	/**
	 * 单价（材料费/机械费）
	 */
	private String materialCostDto;
	
	/**
	 * 合计金额
	 */
	private String totalAmountDto;
	
	/**
	 * 是否甲供
	 */
	private String giveADto;
	/**
	 * 数量
	 */
	private String quanTityDto;
	
	public String getCostOfLaborDto() {
		return costOfLaborDto;
	}

	public void setCostOfLaborDto(String costOfLaborDto) {
		this.costOfLaborDto = costOfLaborDto;
	}

	public String getMaterialCostDto() {
		return materialCostDto;
	}

	public void setMaterialCostDto(String materialCostDto) {
		this.materialCostDto = materialCostDto;
	}

	public String getTotalAmountDto() {
		return totalAmountDto;
	}

	public void setTotalAmountDto(String totalAmountDto) {
		this.totalAmountDto = totalAmountDto;
	}

	public String getGiveADto() {
		return giveADto;
	}

	public void setGiveADto(String giveADto) {
		this.giveADto = giveADto;
	}

	public String getQuanTityDto() {
		return quanTityDto;
	}

	public void setQuanTityDto(String quanTityDto) {
		this.quanTityDto = quanTityDto;
	}

	public String getGive() {
		return give;
	}

	public void setGive(String give) {
		this.give = give;
	}

	/**
	 * @return the projectName
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

	public String getBudtupe() {
		return budtupe;
	}

	public void setBudtupe(String budtupe) {
		this.budtupe = budtupe;
	}

	public String getConArea() {
		return conArea;
	}

	public void setConArea(String conArea) {
		this.conArea = conArea;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * @return  the seq
	 */
	public Long getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(Long seq) {
		this.seq = seq;
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
	 * @return  the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return  the budgetProjectName
	 */
	public String getBudgetProjectName() {
		return budgetProjectName;
	}

	/**
	 * @param budgetProjectName the budgetProjectName to set
	 */
	public void setBudgetProjectName(String budgetProjectName) {
		this.budgetProjectName = budgetProjectName;
	}

	/**
	 * @return  the budtupeId
	 */
	public String getBudtupeId() {
		return budtupeId;
	}

	/**
	 * @param budtupeId the budtupeId to set
	 */
	public void setBudtupeId(String budtupeId) {
		this.budtupeId = budtupeId;
	}

	/**
	 * @return  the supplierId
	 */
	public String getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return  the unitsId
	 */
	public String getUnitsId() {
		return unitsId;
	}

	/**
	 * @param unitsId the unitsId to set
	 */
	public void setUnitsId(String unitsId) {
		this.unitsId = unitsId;
	}

	/**
	 * @return  the costOfLabor
	 */
	public BigDecimal getCostOfLabor() {
		return costOfLabor;
	}

	/**
	 * @param costOfLabor the costOfLabor to set
	 */
	public void setCostOfLabor(BigDecimal costOfLabor) {
		this.costOfLabor = costOfLabor;
	}

	/**
	 * @return  the materialCost
	 */
	public BigDecimal getMaterialCost() {
		return materialCost;
	}

	/**
	 * @param materialCost the materialCost to set
	 */
	public void setMaterialCost(BigDecimal materialCost) {
		this.materialCost = materialCost;
	}

	/**
	 * @return  the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return  the giveA
	 */
	public BigDecimal getGiveA() {
		return giveA;
	}

	/**
	 * @param giveA the giveA to set
	 */
	public void setGiveA(BigDecimal giveA) {
		this.giveA = giveA;
	}

	/**
	 * @return  the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return  the conAreaId
	 */
	public String getConAreaId() {
		return conAreaId;
	}

	/**
	 * @param conAreaId the conAreaId to set
	 */
	public void setConAreaId(String conAreaId) {
		this.conAreaId = conAreaId;
	}

	/**
	 * @return  the quanTity
	 */
	public BigDecimal getQuanTity() {
		return quanTity;
	}

	/**
	 * @param quanTity the quanTity to set
	 */
	public void setQuanTity(BigDecimal quanTity) {
		this.quanTity = quanTity;
	}

	/**
	 * @return  the isNew
	 */
	public Long getIsNew() {
		return isNew;
	}

	/**
	 * @param isNew the isNew to set
	 */
	public void setIsNew(Long isNew) {
		this.isNew = isNew;
	}

	/**
	 * @return the noContractPrice
	 */
	public BigDecimal getNoContractPrice() {
		return noContractPrice;
	}

	/**
	 * @param noContractPrice the noContractPrice to set
	 */
	public void setNoContractPrice(BigDecimal noContractPrice) {
		this.noContractPrice = noContractPrice;
	}

	public Date getCfIncreasetime() {
		return cfIncreasetime;
	}

	public void setCfIncreasetime(Date cfIncreasetime) {
		this.cfIncreasetime = cfIncreasetime;
	}
	
}
