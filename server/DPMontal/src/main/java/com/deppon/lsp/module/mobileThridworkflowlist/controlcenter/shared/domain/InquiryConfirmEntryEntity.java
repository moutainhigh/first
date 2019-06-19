package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class InquiryConfirmEntryEntity extends BaseEntity {

	/**
	 * 版本：lsp第四阶段 
	 * 作者：jiangfeng
	 * 时间：2014-2-28 上午10:51:24
	 * 描述：
	 * 更新记录：
	 */
	private static final long serialVersionUID = -3803620498643537572L;
	
	/**
	 * 单据parentId
	 */
	private String fParentID;
	
	/**
	 * 单据Id
	 */
	private String fid;
	
	/**
	 * 单据分录seq
	 */
	private String seq;
	
	/**
	 * 分录子分录Id
	 */
	private String dEntrys;
	
	/**
	 * 物品编码Id
	 */
	private String cFMaterialNumberID;
	
	/**
	 * 物品编码Number
	 */
	private String cFMaterialNumber;
	
	/**
	 * 物品编码名称
	 */
	private String cFMaterialName;
	
	/**
	 * 物品类型
	 */
	private String cFMeterialType;
	
	/**
	 * 数量
	 */
	private String cFMeterialNum;
	
	/**
	 * 物品规格
	 */
	private String cFMeterialStandard;
	
	/**
	 * 计量单位
	 */
	private String cFBaseUnit;
	
	/**
	 * 是否含运费
	 */
	private String cFContainFreight;
	
	/**
	 * 开票类型Id
	 */
	private String cFInvoiceTypeID;
	
	/**
	 * 开票类型Name
	 */
	private String cFInvoiceTypeName;
	
	/**
	 * 供货时效(天)
	 */
	private String cFSupplyExpire;
	
	/**
	 * 备注
	 */
	private String cFRemark;
	
	/**
	 * 是否含税
	 */
	private String cFContainTax;

	/**
	 * @return the fParentID
	 */
	public String getfParentID() {
		return fParentID;
	}

	/**
	 * @param fParentID the fParentID to set
	 */
	public void setfParentID(String fParentID) {
		this.fParentID = fParentID;
	}

	/**
	 * @return the fid
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
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return the dEntrys
	 */
	public String getdEntrys() {
		return dEntrys;
	}

	/**
	 * @param dEntrys the dEntrys to set
	 */
	public void setdEntrys(String dEntrys) {
		this.dEntrys = dEntrys;
	}

	/**
	 * @return the cFMaterialNumberID
	 */
	public String getcFMaterialNumberID() {
		return cFMaterialNumberID;
	}

	/**
	 * @param cFMaterialNumberID the cFMaterialNumberID to set
	 */
	public void setcFMaterialNumberID(String cFMaterialNumberID) {
		this.cFMaterialNumberID = cFMaterialNumberID;
	}

	/**
	 * @return the cFMaterialName
	 */
	public String getcFMaterialName() {
		return cFMaterialName;
	}

	/**
	 * @param cFMaterialName the cFMaterialName to set
	 */
	public void setcFMaterialName(String cFMaterialName) {
		this.cFMaterialName = cFMaterialName;
	}
	
	
	/**
	 * @return the cFMaterialNumber
	 */
	public String getcFMaterialNumber() {
		return cFMaterialNumber;
	}

	/**
	 * @param cFMaterialNumber the cFMaterialNumber to set
	 */
	public void setcFMaterialNumber(String cFMaterialNumber) {
		this.cFMaterialNumber = cFMaterialNumber;
	}

	/**
	 * @return the cFMeterialType
	 */
	public String getcFMeterialType() {
		return cFMeterialType;
	}

	/**
	 * @param cFMeterialType the cFMeterialType to set
	 */
	public void setcFMeterialType(String cFMeterialType) {
		this.cFMeterialType = cFMeterialType;
	}

	/**
	 * @return the cFMeterialNum
	 */
	public String getcFMeterialNum() {
		return cFMeterialNum;
	}

	/**
	 * @param cFMeterialNum the cFMeterialNum to set
	 */
	public void setcFMeterialNum(String cFMeterialNum) {
		this.cFMeterialNum = cFMeterialNum;
	}

	/**
	 * @return the cFMeterialStandard
	 */
	public String getcFMeterialStandard() {
		return cFMeterialStandard;
	}

	/**
	 * @param cFMeterialStandard the cFMeterialStandard to set
	 */
	public void setcFMeterialStandard(String cFMeterialStandard) {
		this.cFMeterialStandard = cFMeterialStandard;
	}

	/**
	 * @return the cFBaseUnit
	 */
	public String getcFBaseUnit() {
		return cFBaseUnit;
	}

	/**
	 * @param cFBaseUnit the cFBaseUnit to set
	 */
	public void setcFBaseUnit(String cFBaseUnit) {
		this.cFBaseUnit = cFBaseUnit;
	}

	/**
	 * @return the cFContainFreight
	 */
	public String getcFContainFreight() {
		return cFContainFreight;
	}

	/**
	 * @param cFContainFreight the cFContainFreight to set
	 */
	public void setcFContainFreight(String cFContainFreight) {
		this.cFContainFreight = cFContainFreight;
	}

	/**
	 * @return the cFInvoiceTypeID
	 */
	public String getcFInvoiceTypeID() {
		return cFInvoiceTypeID;
	}

	/**
	 * @param cFInvoiceTypeID the cFInvoiceTypeID to set
	 */
	public void setcFInvoiceTypeID(String cFInvoiceTypeID) {
		this.cFInvoiceTypeID = cFInvoiceTypeID;
	}

	/**
	 * @return the cFInvoiceTypeName
	 */
	public String getcFInvoiceTypeName() {
		return cFInvoiceTypeName;
	}

	/**
	 * @param cFInvoiceTypeName the cFInvoiceTypeName to set
	 */
	public void setcFInvoiceTypeName(String cFInvoiceTypeName) {
		this.cFInvoiceTypeName = cFInvoiceTypeName;
	}

	/**
	 * @return the cFSupplyExpire
	 */
	public String getcFSupplyExpire() {
		return cFSupplyExpire;
	}

	/**
	 * @param cFSupplyExpire the cFSupplyExpire to set
	 */
	public void setcFSupplyExpire(String cFSupplyExpire) {
		this.cFSupplyExpire = cFSupplyExpire;
	}

	/**
	 * @return the cFRemark
	 */
	public String getcFRemark() {
		return cFRemark;
	}

	/**
	 * @param cFRemark the cFRemark to set
	 */
	public void setcFRemark(String cFRemark) {
		this.cFRemark = cFRemark;
	}

	/**
	 * @return the cFContainTax
	 */
	public String getcFContainTax() {
		return cFContainTax;
	}

	/**
	 * @param cFContainTax the cFContainTax to set
	 */
	public void setcFContainTax(String cFContainTax) {
		this.cFContainTax = cFContainTax;
	}
	
	
}
