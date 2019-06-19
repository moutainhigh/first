package com.deppon.dpm.module.wfs.shared.domain.dwfs;

import java.io.Serializable;

public class TaxDwfsEntity  implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String signDepartment;
    private String isStampDuty;
    private String accountContractAmount;
    private String taxItem;
    private String taxRate;
    private String paymentAmount;
    private String taxMethod;
    private String busino;
	/**
	 * @return the signDepartment
	 */
	public String getSignDepartment() {
		return signDepartment;
	}
	/**
	 * @param signDepartment the signDepartment to set
	 */
	public void setSignDepartment(String signDepartment) {
		this.signDepartment = signDepartment;
	}
	/**
	 * @return the isStampDuty
	 */
	public String getIsStampDuty() {
		return isStampDuty;
	}
	/**
	 * @param isStampDuty the isStampDuty to set
	 */
	public void setIsStampDuty(String isStampDuty) {
		this.isStampDuty = isStampDuty;
	}
	/**
	 * @return the accountContractAmount
	 */
	public String getAccountContractAmount() {
		return accountContractAmount;
	}
	/**
	 * @param accountContractAmount the accountContractAmount to set
	 */
	public void setAccountContractAmount(String accountContractAmount) {
		this.accountContractAmount = accountContractAmount;
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
	 * @return the taxRate
	 */
	public String getTaxRate() {
		return taxRate;
	}
	/**
	 * @param taxRate the taxRate to set
	 */
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	/**
	 * @return the paymentAmount
	 */
	public String getPaymentAmount() {
		return paymentAmount;
	}
	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	/**
	 * @return the taxMethod
	 */
	public String getTaxMethod() {
		return taxMethod;
	}
	/**
	 * @param taxMethod the taxMethod to set
	 */
	public void setTaxMethod(String taxMethod) {
		this.taxMethod = taxMethod;
	}
	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
   
    
}
