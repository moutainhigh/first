/**   
 * @Title: FinalAccountLine.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 徐丁钉   
 * @date 2013-12-20 上午10:45:34  
 */
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.montal.util.FormatUtil;

/**
 * @ClassName: FinalAccountLine
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 徐丁钉
 * @date 2013-12-20 上午10:45:34
 * 
 */
public class FinalAccountLine {
	
	private String fseq;
	private String fId;
	private String fParentId;
	private String cfConstructareaId;// 施工区域ID
	private String cfConstructAreaName;// 施工区域名称
	private String cfUnitsId;// 单位ID
	private String cfUnitsName;// 单位名称
	private String cfQuantity;// 数量
	private String cfPricePeople;// 单价（人工费）
	private String cfPriceMaterial;// 单价（材料费用）
	private String cfDetailAmount;// 金额
	private String fPayNameId;// 费用名称ID
	private String fPayNamesName;// 费用名称NAME
	private String fSumPrice;// 总价
	private String fNewNum;// 新数量
	private String cfBudgetTypeId;// 预算项目类型ID
	private String cfBudgetTypeName;// 预算项目类型名称；

	/**
	 * @return the fseq
	 */
	public String getFseq() {
		return fseq;
	}

	/**
	 * @param fseq
	 *            the fseq to set
	 */
	public void setFseq(String fseq) {
		this.fseq = fseq;
	}

	/**
	 * @return the fId
	 */
	public String getfId() {
		return fId;
	}

	/**
	 * @param fId
	 *            the fId to set
	 */
	public void setfId(String fId) {
		this.fId = fId;
	}

	/**
	 * @return the fParentId
	 */
	public String getfParentId() {
		return fParentId;
	}

	/**
	 * @param fParentId
	 *            the fParentId to set
	 */
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}

	/**
	 * @return the cfConstructareaId
	 */
	public String getCfConstructareaId() {
		return cfConstructareaId;
	}

	/**
	 * @param cfConstructareaId
	 *            the cfConstructareaId to set
	 */
	public void setCfConstructareaId(String cfConstructareaId) {
		this.cfConstructareaId = cfConstructareaId;
	}

	/**
	 * @return the cfConstructareaName
	 */
	public String getCfConstructAreaName() {
		return cfConstructAreaName;
	}

	/**
	 * @param cfConstructareaName
	 *            the cfConstructareaName to set
	 */
	public void setCfConstructAreaName(String cfConstructAreaName) {
		this.cfConstructAreaName = cfConstructAreaName;
	}

	/**
	 * @return the cfUnitsId
	 */
	public String getCfUnitsId() {
		return cfUnitsId;
	}

	/**
	 * @param cfUnitsId
	 *            the cfUnitsId to set
	 */
	public void setCfUnitsId(String cfUnitsId) {
		this.cfUnitsId = cfUnitsId;
	}

	/**
	 * @return the cfUnitsName
	 */
	public String getCfUnitsName() {
		return cfUnitsName;
	}

	/**
	 * @param cfUnitsName
	 *            the cfUnitsName to set
	 */
	public void setCfUnitsName(String cfUnitsName) {
		this.cfUnitsName = cfUnitsName;
	}

	/**
	 * @return the cfQuantity
	 */
	public String getCfQuantity() {
		return cfQuantity;
	}

	/**
	 * @param cfQuantity
	 *            the cfQuantity to set
	 */
	public void setCfQuantity(String cfQuantity) {
		this.cfQuantity = cfQuantity;
	}

	/**
	 * @return the cfPricePeople
	 */
	public String getCfPricePeople() {
		return FormatUtil.formatDouble("###,###,###,###.000", cfPricePeople);
	}

	/**
	 * @param cfPricePeople
	 *            the cfPricePeople to set
	 */
	public void setCfPricePeople(String cfPricePeople) {
		this.cfPricePeople = cfPricePeople;
	}

	/**
	 * @return the cfPriceMaterial
	 */
	public String getCfPriceMaterial() {
		return FormatUtil.formatDouble("###,###,###,###.000", cfPriceMaterial);
	}

	/**
	 * @param cfPriceMaterial
	 *            the cfPriceMaterial to set
	 */
	public void setCfPriceMaterial(String cfPriceMaterial) {
		this.cfPriceMaterial = cfPriceMaterial;
	}

	/**
	 * @return the cfDetailAmount
	 */
	public String getCfDetailAmount() {
		return FormatUtil.formatDouble("###,###,###,###.00", cfDetailAmount);
	}

	/**
	 * @param cfDetailAmount
	 *            the cfDetailAmount to set
	 */
	public void setCfDetailAmount(String cfDetailAmount) {
		this.cfDetailAmount = cfDetailAmount;
	}

	/**
	 * @return the fPayNameId
	 */
	public String getfPayNameId() {
		return fPayNameId;
	}

	/**
	 * @param fPayNameId
	 *            the fPayNameId to set
	 */
	public void setfPayNameId(String fPayNameId) {
		this.fPayNameId = fPayNameId;
	}

	/**
	 * @return the fPayName
	 */
	public String getfPayNamesName() {
		return fPayNamesName;
	}

	/**
	 * @param fPayName
	 *            the fPayName to set
	 */
	public void setfPayNamesName(String fPayNamesName) {
		this.fPayNamesName = fPayNamesName;
	}

	/**
	 * @return the fSumPrice
	 */
	public String getfSumPrice() {
		return fSumPrice;
	}

	/**
	 * @param fSumPrice
	 *            the fSumPrice to set
	 */
	public void setfSumPrice(String fSumPrice) {
		this.fSumPrice = fSumPrice;
	}

	/**
	 * @return the fNewNum
	 */
	public String getfNewNum() {
		return fNewNum;
	}

	/**
	 * @param fNewNum
	 *            the fNewNum to set
	 */
	public void setfNewNum(String fNewNum) {
		this.fNewNum = fNewNum;
	}

	/**
	 * @return the cfBudgetTypeId
	 */
	public String getCfBudgetTypeId() {
		return cfBudgetTypeId;
	}

	/**
	 * @param cfBudgetTypeId
	 *            the cfBudgetTypeId to set
	 */
	public void setCfBudgetTypeId(String cfBudgetTypeId) {
		this.cfBudgetTypeId = cfBudgetTypeId;
	}

	/**
	 * @return the cfBudgetTypeName
	 */
	public String getCfBudgetTypeName() {
		return cfBudgetTypeName;
	}

	/**
	 * @param cfBudgetTypeName
	 *            the cfBudgetTypeName to set
	 */
	public void setCfBudgetTypeName(String cfBudgetTypeName) {
		this.cfBudgetTypeName = cfBudgetTypeName;
	}

}
