package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

/**
 * 
 * yin 签订合同申请
 *
 */
public class OaContractApply {
    private BigDecimal processinstid;

    private String proposer;

    private String userid;

    private String chargeindepartment;

    private String signtype;

    private String originalcontractnumbers;

    private String contracttype;

    private String subordinatedepartment;

    private String financedept;

    private String itemname;

    private String quantity;

    private String unitprice;

    private String ismain;

    private BigDecimal isframecontract;

    private String contractname;

    private String contractamount;

    private String signingeachotherunit;

    private String signingourunit;

    private Date contractstarttime;

    private Date contractendtime;

    private String reason;

    private String processinstname;
    
    private String seal;
    
    public String getSeal() {

		return seal;
	}
    
    public void setSeal(String seal) {

		this.seal = seal;
	}

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getProposer() {
        return F_Constants.chageNull(proposer);
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getUserid() {
        return F_Constants.chageNull(userid);
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getChargeindepartment() {
        return F_Constants.chageNull(chargeindepartment);
    }

    public void setChargeindepartment(String chargeindepartment) {
        this.chargeindepartment = chargeindepartment;
    }

    public String getSigntype() {
        return F_Constants.chageNull(signtype);
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getOriginalcontractnumbers() {
        return F_Constants.chageNull(originalcontractnumbers);
    }

    public void setOriginalcontractnumbers(String originalcontractnumbers) {
        this.originalcontractnumbers = originalcontractnumbers;
    }

    public String getContracttype() {
        return F_Constants.chageNull(contracttype);
    }

    public void setContracttype(String contracttype) {
        this.contracttype = contracttype;
    }

    public String getSubordinatedepartment() {
        return F_Constants.chageNull(subordinatedepartment);
    }

    public void setSubordinatedepartment(String subordinatedepartment) {
        this.subordinatedepartment = subordinatedepartment;
    }

    public String getFinancedept() {
        return F_Constants.chageNull(financedept);
    }

    public void setFinancedept(String financedept) {
        this.financedept = financedept;
    }

    public String getItemname() {
        return F_Constants.chageNull(itemname);
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getQuantity() {
        return F_Constants.chageNull(quantity);
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitprice() {
        return F_Constants.chageNull(unitprice);
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getIsmain() {
        return F_Constants.chageNull(ismain);
    }

    public void setIsmain(String ismain) {
        this.ismain = ismain;
    }

    public BigDecimal getIsframecontract() {
        return isframecontract;
    }

    public void setIsframecontract(BigDecimal isframecontract) {
        this.isframecontract = isframecontract;
    }

    public String getContractname() {
        return F_Constants.chageNull(contractname);
    }

    public void setContractname(String contractname) {
        this.contractname = contractname;
    }

    public String getContractamount() {
        return F_Constants.chageNull(contractamount);
    }

    public void setContractamount(String contractamount) {
        this.contractamount = contractamount;
    }

    public String getSigningeachotherunit() {
        return F_Constants.chageNull(signingeachotherunit);
    }

    public void setSigningeachotherunit(String signingeachotherunit) {
        this.signingeachotherunit = signingeachotherunit;
    }

    public String getSigningourunit() {
        return F_Constants.chageNull(signingourunit);
    }

    public void setSigningourunit(String signingourunit) {
        this.signingourunit = signingourunit;
    }

    public Date getContractstarttime() {
        return contractstarttime;
    }

    public void setContractstarttime(Date contractstarttime) {
        this.contractstarttime = contractstarttime;
    }

    public Date getContractendtime() {
        return contractendtime;
    }

    public void setContractendtime(Date contractendtime) {
        this.contractendtime = contractendtime;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProcessinstname() {
        return F_Constants.chageNull(processinstname);
    }

    public void setProcessinstname(String processinstname) {
        this.processinstname = processinstname;
    }
}