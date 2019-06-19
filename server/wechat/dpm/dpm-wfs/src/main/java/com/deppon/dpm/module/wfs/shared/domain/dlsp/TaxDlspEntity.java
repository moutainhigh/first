package com.deppon.dpm.module.wfs.shared.domain.dlsp;

import java.io.Serializable;

public class TaxDlspEntity  implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //是否印花税
    private String isPayTax;
    //会计核定合同金额
    private String contactAmount;
    //税目选择
    private String taxItem;
    //税率
    private String rate;
    //缴纳金额
    private String payAmount;
    //申报部门所属子公司
    private String applyDept;
    //缴纳方式
    private String taxType;
	/**
	 * @return the isPayTax
	 */
	public String getIsPayTax() {
		return isPayTax;
	}
	/**
	 * @param isPayTax the isPayTax to set
	 */
	public void setIsPayTax(String isPayTax) {
		this.isPayTax = isPayTax;
	}
	/**
	 * @return the contactAmount
	 */
	public String getContactAmount() {
		return contactAmount;
	}
	/**
	 * @param contactAmount the contactAmount to set
	 */
	public void setContactAmount(String contactAmount) {
		this.contactAmount = contactAmount;
	}
	/**
	 * @return the taxItem
	 */
	public String getTaxItem() {
		return taxItem;
	}
	/**
	 * @param taxItem the taxItem to set
	 */
	public void setTaxItem(String taxItem) {
		this.taxItem = taxItem;
	}
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the payAmount
	 */
	public String getPayAmount() {
		return payAmount;
	}
	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	/**
	 * @return the applyDept
	 */
	public String getApplyDept() {
		return applyDept;
	}
	/**
	 * @param applyDept the applyDept to set
	 */
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}
	/**
	 * @return the taxType
	 */
	public String getTaxType() {
		return taxType;
	}
	/**
	 * @param taxType the taxType to set
	 */
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
   
    
}
