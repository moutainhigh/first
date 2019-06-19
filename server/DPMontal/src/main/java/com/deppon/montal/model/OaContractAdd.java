package com.deppon.montal.model;

import java.math.BigDecimal;

/**
 * @author helingbo
 * 月结客户签订实体
 */

public class OaContractAdd {
	private BigDecimal processinstid;//工作流编号
	private String applypersoncode;//申请人工号
	private String applypersonname;//申请人姓名
	private String divisioncode;//所属事业部
	private String applypersondept;//所属部门
	private String applytype;//申请类型
	private String overrange;//超系统额定
	private String contractnumber;//合同序号
	private String subsidiary;//所属子公司
	private String contractstartdate;//合同起始日期
	private String contractenddate;//合同到期日期
	private String customercode;//客户编码
	private String customername;//客户名称
	private String amountofconsignment;//近三月发货金额
	private String customerallname;//客户全称
	private String nodesectiontype;//结款方式
	private String balanceaccount;//结算限额
	private String settleaccountsdate;//结款日期
	private String freightdiscount;//运费折扣
	private String preferentialtype;//优惠类型
	private String generationratediscount;//代收费率折扣
	private String chargeratediscount;//保价费率折扣
	private String cargofeediscount;//接货费折扣
	private String deliveryfeediscount;//送货费折扣
	private String protocolcontactname;//协议联系人
	private String contactphone;//联系人手机
	private String contacttel;//联系人电话
	private String discount;//折扣
	private String modifycontracttype;//合同修改类型
	private String oldcontractnumber;//原合同序号
	private String newbalanceaccount;//新结算限额
	private String newfreightdiscount;//新运费折扣
	private String newpreferentialtype;//新优惠类型
	private String newgenerationratediscount;//新代收费率折扣
	private String newchargeratediscount;//新保价费率折扣
	private String newcargofeediscount;//新接货费折扣
	private String newdeliveryfeediscount;//新送货费折扣
	private String contrctascriptiondept;//合同归属部门
	private String applybondingdept;//申请绑定部门
	private String ascriptiondept;//现有归属部门
	private String applyrenewaldept;//申请变更部门
	private String applyreason;//申请事由
	public BigDecimal getProcessinstid() {
		return processinstid;
	}
	public void setProcessinstid(BigDecimal processinstid) {
		this.processinstid = processinstid;
	}
	public String getApplypersoncode() {
		return applypersoncode;
	}
	public void setApplypersoncode(String applypersoncode) {
		this.applypersoncode = applypersoncode;
	}
	public String getApplypersonname() {
		return applypersonname;
	}
	public void setApplypersonname(String applypersonname) {
		this.applypersonname = applypersonname;
	}
	public String getDivisioncode() {
		return divisioncode;
	}
	public void setDivisioncode(String divisioncode) {
		this.divisioncode = divisioncode;
	}
	public String getApplypersondept() {
		return applypersondept;
	}
	public void setApplypersondept(String applypersondept) {
		this.applypersondept = applypersondept;
	}
	public String getApplytype() {
		return applytype;
	}
	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}
	public String getOverrange() {
		return overrange;
	}
	public void setOverrange(String overrange) {
		this.overrange = overrange;
	}
	public String getContractnumber() {
		return contractnumber;
	}
	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}
	public String getSubsidiary() {
		return subsidiary;
	}
	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}
	public String getContractstartdate() {
		return contractstartdate;
	}
	public void setContractstartdate(String contractstartdate) {
		this.contractstartdate = contractstartdate;
	}
	public String getContractenddate() {
		return contractenddate;
	}
	public void setContractenddate(String contractenddate) {
		this.contractenddate = contractenddate;
	}
	public String getCustomercode() {
		return customercode;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getAmountofconsignment() {
		return amountofconsignment;
	}
	public void setAmountofconsignment(String amountofconsignment) {
		this.amountofconsignment = amountofconsignment;
	}
	public String getCustomerallname() {
		return customerallname;
	}
	public void setCustomerallname(String customerallname) {
		this.customerallname = customerallname;
	}
	public String getNodesectiontype() {
		return nodesectiontype;
	}
	public void setNodesectiontype(String nodesectiontype) {
		this.nodesectiontype = nodesectiontype;
	}
	public String getBalanceaccount() {
		return balanceaccount;
	}
	public void setBalanceaccount(String balanceaccount) {
		this.balanceaccount = balanceaccount;
	}
	public String getSettleaccountsdate() {
		return settleaccountsdate;
	}
	public void setSettleaccountsdate(String settleaccountsdate) {
		this.settleaccountsdate = settleaccountsdate;
	}
	public String getFreightdiscount() {
		return freightdiscount;
	}
	public void setFreightdiscount(String freightdiscount) {
		this.freightdiscount = freightdiscount;
	}
	public String getPreferentialtype() {
		return preferentialtype;
	}
	public void setPreferentialtype(String preferentialtype) {
		this.preferentialtype = preferentialtype;
	}
	public String getGenerationratediscount() {
		return generationratediscount;
	}
	public void setGenerationratediscount(String generationratediscount) {
		this.generationratediscount = generationratediscount;
	}
	public String getChargeratediscount() {
		return chargeratediscount;
	}
	public void setChargeratediscount(String chargeratediscount) {
		this.chargeratediscount = chargeratediscount;
	}
	public String getCargofeediscount() {
		return cargofeediscount;
	}
	public void setCargofeediscount(String cargofeediscount) {
		this.cargofeediscount = cargofeediscount;
	}
	public String getDeliveryfeediscount() {
		return deliveryfeediscount;
	}
	public void setDeliveryfeediscount(String deliveryfeediscount) {
		this.deliveryfeediscount = deliveryfeediscount;
	}
	public String getProtocolcontactname() {
		return protocolcontactname;
	}
	public void setProtocolcontactname(String protocolcontactname) {
		this.protocolcontactname = protocolcontactname;
	}
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	public String getContacttel() {
		return contacttel;
	}
	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getModifycontracttype() {
		return modifycontracttype;
	}
	public void setModifycontracttype(String modifycontracttype) {
		this.modifycontracttype = modifycontracttype;
	}
	public String getOldcontractnumber() {
		return oldcontractnumber;
	}
	public void setOldcontractnumber(String oldcontractnumber) {
		this.oldcontractnumber = oldcontractnumber;
	}
	public String getNewbalanceaccount() {
		return newbalanceaccount;
	}
	public void setNewbalanceaccount(String newbalanceaccount) {
		this.newbalanceaccount = newbalanceaccount;
	}
	public String getNewfreightdiscount() {
		return newfreightdiscount;
	}
	public void setNewfreightdiscount(String newfreightdiscount) {
		this.newfreightdiscount = newfreightdiscount;
	}
	public String getNewpreferentialtype() {
		return newpreferentialtype;
	}
	public void setNewpreferentialtype(String newpreferentialtype) {
		this.newpreferentialtype = newpreferentialtype;
	}
	public String getNewgenerationratediscount() {
		return newgenerationratediscount;
	}
	public void setNewgenerationratediscount(String newgenerationratediscount) {
		this.newgenerationratediscount = newgenerationratediscount;
	}
	public String getNewchargeratediscount() {
		return newchargeratediscount;
	}
	public void setNewchargeratediscount(String newchargeratediscount) {
		this.newchargeratediscount = newchargeratediscount;
	}
	public String getNewcargofeediscount() {
		return newcargofeediscount;
	}
	public void setNewcargofeediscount(String newcargofeediscount) {
		this.newcargofeediscount = newcargofeediscount;
	}
	public String getNewdeliveryfeediscount() {
		return newdeliveryfeediscount;
	}
	public void setNewdeliveryfeediscount(String newdeliveryfeediscount) {
		this.newdeliveryfeediscount = newdeliveryfeediscount;
	}
	public String getContrctascriptiondept() {
		return contrctascriptiondept;
	}
	public void setContrctascriptiondept(String contrctascriptiondept) {
		this.contrctascriptiondept = contrctascriptiondept;
	}
	public String getApplybondingdept() {
		return applybondingdept;
	}
	public void setApplybondingdept(String applybondingdept) {
		this.applybondingdept = applybondingdept;
	}
	public String getAscriptiondept() {
		return ascriptiondept;
	}
	public void setAscriptiondept(String ascriptiondept) {
		this.ascriptiondept = ascriptiondept;
	}
	public String getApplyrenewaldept() {
		return applyrenewaldept;
	}
	public void setApplyrenewaldept(String applyrenewaldept) {
		this.applyrenewaldept = applyrenewaldept;
	}
	public String getApplyreason() {
		return applyreason;
	}
	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
	}
	
}
