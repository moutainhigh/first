package com.deppon.dpm.module.wfs.shared.domain;

import java.io.Serializable;


public class TaxInfoEntity  implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    //是否需要缴纳印花税
    private String stampDuty;
    //会计核定合同金额
    private String contractAmount;
    //税目
    private String taxItemName;
    //税率
    private String taxRate;
    //缴纳金额
    private String paymentAmount;
    //申报部门
    private String declareDepartmentName;
    //缴税方式
    private String paymentMethod;
    //工作流节点ID
    private String activitydefid;
    //工作流节点的业务ID
    private String busino;
    //工作流业务定义ID
    private String flowtype;
    //工作流程ID
    private String processinstid;
	/**
	 * @return the stampDuty
	 */
	public String getStampDuty() {
		return stampDuty;
	}
	/**
	 * @param stampDuty the stampDuty to set
	 */
	public void setStampDuty(String stampDuty) {
		this.stampDuty = stampDuty;
	}
	/**
	 * @return the contractAmount
	 */
	public String getContractAmount() {
		return contractAmount;
	}
	/**
	 * @param contractAmount the contractAmount to set
	 */
	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}
	/**
	 * @return the taxItemName
	 */
	public String getTaxItemName() {
		return taxItemName;
	}
	/**
	 * @param taxItemName the taxItemName to set
	 */
	public void setTaxItemName(String taxItemName) {
		this.taxItemName = taxItemName;
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
	 * @return the declareDepartmentName
	 */
	public String getDeclareDepartmentName() {
		return declareDepartmentName;
	}
	/**
	 * @param declareDepartmentName the declareDepartmentName to set
	 */
	public void setDeclareDepartmentName(String declareDepartmentName) {
		this.declareDepartmentName = declareDepartmentName;
	}
	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * @return the activitydefid
	 */
	public String getActivitydefid() {
		return activitydefid;
	}
	/**
	 * @param activitydefid the activitydefid to set
	 */
	public void setActivitydefid(String activitydefid) {
		this.activitydefid = activitydefid;
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
	/**
	 * @return the flowtype
	 */
	public String getFlowtype() {
		return flowtype;
	}
	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}
	/**
	 * @return the processinstid
	 */
	public String getProcessinstid() {
		return processinstid;
	}
	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(String processinstid) {
		this.processinstid = processinstid;
	}
}
