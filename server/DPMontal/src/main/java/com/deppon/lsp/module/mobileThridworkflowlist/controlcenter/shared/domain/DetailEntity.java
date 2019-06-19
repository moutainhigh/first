package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 *<pre>
 *功能:工程项目预算明细分录实体类
 *作者：蒋小洋
 *日期：2013-12-20下午2:41:53
 *</pre>
 */
public class DetailEntity extends BaseEntity{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5088773231010432768L;
	
	/**
	 * 分录序列号
	 */
	private Long seq;
	
	/**
	 * 主键FID
	 */
	private String fid;
	
	/**
	 * 外键
	 */
	private String parentId;

	/**
	 * 预算项目名称
	 */
	private String budProNameId;

	/**
	 * 预算项目类型
	 */
	private String budgetType;

	/**
	 * 单位
	 */
	private String unitId;

	/**
	 * 单价（人工费）
	 */
	private BigDecimal unitPricePe;

	/**
	 * 供应商
	 */
	private String supplierId;

	/**
	 * 单价（材料费/机械费）
	 */
	private BigDecimal unitPriceMe;

	/**
	 * 备注
	 */
	private String comment;

	/**
	 * 是否甲供
	 */
	private Long whetherFor;

	/**
	 * 是否应付单
	 */
	private Long proShow;

	/**
	 * 施工区域
	 */
	private String conareaId;
	
	/**
	 * 合计金额
	 */
	private BigDecimal price;
	
	/**
	 * 数量
	 */
	private BigDecimal amount;
	
	/**
	 * 是否新增
	 */
	private Long isNew;
	/**
	 * 是否增项
	 */
	private Long cfIsincrease;
	
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
	//供应商
	private String cfSupplierIdAsName;
	
	//增项时间
	private Date cfIncreasetime;
	
	//将BigDecimal转换为String类型。
	/**
	 * 单价（人工费）
	 */
	private String unitPricePeDto;
	/**
	 * 单价（材料费/机械费）
	 */
	private String unitPriceMeDto;
	/**
	 * 合计金额
	 */
	private String priceDto;
	
	/**
	 * 数量
	 */
	private String amountDto;
	
	
	public Long getCfIsincrease() {
		return cfIsincrease;
	}

	public void setCfIsincrease(Long cfIsincrease) {
		this.cfIsincrease = cfIsincrease;
	}

	public String getCfSupplierIdAsName() {
		return cfSupplierIdAsName;
	}

	public void setCfSupplierIdAsName(String cfSupplierIdAsName) {
		this.cfSupplierIdAsName = cfSupplierIdAsName;
	}

	public String getUnitPricePeDto() {
		return unitPricePeDto;
	}

	public void setUnitPricePeDto(String unitPricePeDto) {
		this.unitPricePeDto = unitPricePeDto;
	}

	public String getUnitPriceMeDto() {
		return unitPriceMeDto;
	}

	public void setUnitPriceMeDto(String unitPriceMeDto) {
		this.unitPriceMeDto = unitPriceMeDto;
	}

	public String getPriceDto() {
		return priceDto;
	}

	public void setPriceDto(String priceDto) {
		this.priceDto = priceDto;
	}

	public String getAmountDto() {
		return amountDto;
	}

	public void setAmountDto(String amountDto) {
		this.amountDto = amountDto;
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
	 * @return  the budtupe
	 */
	public String getBudtupe() {
		return budtupe;
	}

	/**
	 * @param budtupe the budtupe to set
	 */
	public void setBudtupe(String budtupe) {
		this.budtupe = budtupe;
	}

	/**
	 * @return  the conArea
	 */
	public String getConArea() {
		return conArea;
	}

	/**
	 * @param conArea the conArea to set
	 */
	public void setConArea(String conArea) {
		this.conArea = conArea;
	}

	/**
	 * @return  the supplier
	 */
	public String getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return  the units
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * @return  the give
	 */
	public String getGive() {
		return give;
	}

	/**
	 * @param give the give to set
	 */
	public void setGive(String give) {
		this.give = give;
	}

	/**
	 * noContractPrice
	 */
	private BigDecimal noContractPrice;

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
	 * @return  the budProNameId
	 */
	public String getBudProNameId() {
		return budProNameId;
	}

	/**
	 * @param budProNameId the budProNameId to set
	 */
	public void setBudProNameId(String budProNameId) {
		this.budProNameId = budProNameId;
	}

	/**
	 * @return  the budgetType
	 */
	public String getBudgetType() {
		return budgetType;
	}

	/**
	 * @param budgetType the budgetType to set
	 */
	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}

	/**
	 * @return  the unitId
	 */
	public String getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return  the unitPricePe
	 */
	public BigDecimal getUnitPricePe() {
		return unitPricePe;
	}

	/**
	 * @param unitPricePe the unitPricePe to set
	 */
	public void setUnitPricePe(BigDecimal unitPricePe) {
		this.unitPricePe = unitPricePe;
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
	 * @return  the unitPriceMe
	 */
	public BigDecimal getUnitPriceMe() {
		return unitPriceMe;
	}

	/**
	 * @param unitPriceMe the unitPriceMe to set
	 */
	public void setUnitPriceMe(BigDecimal unitPriceMe) {
		this.unitPriceMe = unitPriceMe;
	}

	/**
	 * @return  the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return  the whetherFor
	 */
	public Long getWhetherFor() {
		return whetherFor;
	}

	/**
	 * @param whetherFor the whetherFor to set
	 */
	public void setWhetherFor(Long whetherFor) {
		this.whetherFor = whetherFor;
	}

	/**
	 * @return  the proShow
	 */
	public Long getProShow() {
		return proShow;
	}

	/**
	 * @param proShow the proShow to set
	 */
	public void setProShow(Long proShow) {
		this.proShow = proShow;
	}

	/**
	 * @return  the conareaId
	 */
	public String getConareaId() {
		return conareaId;
	}

	/**
	 * @param conareaId the conareaId to set
	 */
	public void setConareaId(String conareaId) {
		this.conareaId = conareaId;
	}

	/**
	 * @return  the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return  the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
