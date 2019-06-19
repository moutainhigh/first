package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class InquiryConfirmEntryDEntity extends BaseEntity {

	/**
	 * 版本：lsp第四阶段 
	 * 作者：jiangfeng
	 * 时间：2014-3-3 下午6:22:52
	 * 描述：
	 * 更新记录：
	 */
	private static final long serialVersionUID = -9154383939244261915L;
	
	/**
	 * 父分录Id
	 */
	private String fParentID;
	
	/**
	 * 子分录Id
	 */
	private String fid;
	
	/**
	 * 子分录seq
	 */
	
	private String seq;
	/**
	 * 供应商编码Id
	 */
	private String cFSupplierNumberID;
	
	/**
	 *供应商编码 
	 */
	private String cFSupplierNumber;
	
	/**
	 * 供应商名称
	 */
	private String cFSupplierName;
	
	/**
	 * 单价
	 */
	private String cFPrice;
	
	/**
	 * 报价总额
	 */
	private String cFQuoteAmount;
	
	/**
	 * 配额类型
	 */
	private String cFQuotaType;
	
	/**
	 * 配额
	 */
	private String cFQuota;
	
	/**
	 * 配额说明
	 */
	private String cFQuotaExplain;

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
	 * @return the cFSupplierNumberID
	 */
	public String getcFSupplierNumberID() {
		return cFSupplierNumberID;
	}

	/**
	 * @param cFSupplierNumberID the cFSupplierNumberID to set
	 */
	public void setcFSupplierNumberID(String cFSupplierNumberID) {
		this.cFSupplierNumberID = cFSupplierNumberID;
	}

	/**
	 * @return the cFSupplierName
	 */
	public String getcFSupplierName() {
		return cFSupplierName;
	}

	/**
	 * @param cFSupplierName the cFSupplierName to set
	 */
	public void setcFSupplierName(String cFSupplierName) {
		this.cFSupplierName = cFSupplierName;
	}

	/**
	 * @return the cFPrice
	 */
	public String getcFPrice() {
		return cFPrice;
	}

	/**
	 * @param cFPrice the cFPrice to set
	 */
	public void setcFPrice(String cFPrice) {
		this.cFPrice = cFPrice;
	}

	/**
	 * @return the cFQuoteAmount
	 */
	public String getcFQuoteAmount() {
		return cFQuoteAmount;
	}

	/**
	 * @param cFQuoteAmount the cFQuoteAmount to set
	 */
	public void setcFQuoteAmount(String cFQuoteAmount) {
		this.cFQuoteAmount = cFQuoteAmount;
	}

	/**
	 * @return the cFQuotaType
	 */
	public String getcFQuotaType() {
		String type = "";
		if("10".equals(cFQuotaType)){
			type = "文本";
		}
		if("20".equals(cFQuotaType)){
			type = "数字";
		}
		if("30".equals(cFQuotaType)){
			type = "    ";
		}
		return type;
	}

	/**
	 * @param cFQuotaType the cFQuotaType to set
	 */
	public void setcFQuotaType(String cFQuotaType) {
		this.cFQuotaType = cFQuotaType;
	}

	/**
	 * @return the cFQuota
	 */
	public String getcFQuota() {
		return cFQuota;
	}

	/**
	 * @param cFQuota the cFQuota to set
	 */
	public void setcFQuota(String cFQuota) {
		this.cFQuota = cFQuota;
	}

	/**
	 * @return the cFQuotaExplain
	 */
	public String getcFQuotaExplain() {
		return cFQuotaExplain;
	}

	/**
	 * @param cFQuotaExplain the cFQuotaExplain to set
	 */
	public void setcFQuotaExplain(String cFQuotaExplain) {
		this.cFQuotaExplain = cFQuotaExplain;
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
	 * @return the cFSupplierNumber
	 */
	public String getcFSupplierNumber() {
		return cFSupplierNumber;
	}

	/**
	 * @param cFSupplierNumber the cFSupplierNumber to set
	 */
	public void setcFSupplierNumber(String cFSupplierNumber) {
		this.cFSupplierNumber = cFSupplierNumber;
	}
	
	
}
