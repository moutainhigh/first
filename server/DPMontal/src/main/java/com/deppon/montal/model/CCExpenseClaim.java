package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: CCExpenseClaim 
   * @Description:TODO(通用费用实体类)
   * @TableName: CC_EXPENSECLAIM
   * @author 廖建雄 
   * @date 2013-4-27 上午9:49:26 
   * 
   */
public class CCExpenseClaim {
    private BigDecimal processinstid;

    private String billid;

    private String billname;

    private String applydate;

    private String applypersonnumber;

    private String applypersonname;

    private String applydept;

    private String applycompany;

    private String applytype;

    private String position;

    private String paytype;

    private String payee;

    private String province;

    private String city;

    private String bank;

    private String branchbank;

    private String banknumber;

    private String attachmentnum;

    private String amount;

    private String amountapproved;

    private String amountbalance;

    private String loanamount;

    private String discription;

    private String creator;

    private String creattime;

    private String lastupdateuser;

    private String lastupdatetime;

    private String auditor;

    private String auditdate;

    private String billstate;

    private String isloanbill;

    private String amountused;

    private String loanbillnumber;

    private String payeeproperty;

    private String lastremitdate;

    private String invoicetitle;

    private String purpose;

    private String fivouchered;

    private String billtype;

    private String phonenumber;
    
    private String currentnode;//当前节点
    
    public String getCurrentnode() {

		return currentnode;
	}
    
    public void setCurrentnode(String currentnode) {

		this.currentnode = currentnode;
	}
    
    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getBillname() {
        return billname;
    }

    public void setBillname(String billname) {
        this.billname = billname;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getApplypersonnumber() {
        return applypersonnumber;
    }

    public void setApplypersonnumber(String applypersonnumber) {
        this.applypersonnumber = applypersonnumber;
    }

    public String getApplypersonname() {
        return applypersonname;
    }

    public void setApplypersonname(String applypersonname) {
        this.applypersonname = applypersonname;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getApplycompany() {
        return applycompany;
    }

    public void setApplycompany(String applycompany) {
        this.applycompany = applycompany;
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranchbank() {
        return branchbank;
    }

    public void setBranchbank(String branchbank) {
        this.branchbank = branchbank;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getAttachmentnum() {
        return attachmentnum;
    }

    public void setAttachmentnum(String attachmentnum) {
        this.attachmentnum = attachmentnum;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountapproved() {
        return amountapproved;
    }

    public void setAmountapproved(String amountapproved) {
        this.amountapproved = amountapproved;
    }

    public String getAmountbalance() {
        return amountbalance;
    }

    public void setAmountbalance(String amountbalance) {
        this.amountbalance = amountbalance;
    }

    public String getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(String loanamount) {
        this.loanamount = loanamount;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getLastupdateuser() {
        return lastupdateuser;
    }

    public void setLastupdateuser(String lastupdateuser) {
        this.lastupdateuser = lastupdateuser;
    }

    public String getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(String lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(String auditdate) {
        this.auditdate = auditdate;
    }

    public String getBillstate() {
        return billstate;
    }

    public void setBillstate(String billstate) {
        this.billstate = billstate;
    }

    public String getIsloanbill() {
        return isloanbill;
    }

    public void setIsloanbill(String isloanbill) {
        this.isloanbill = isloanbill;
    }

    public String getAmountused() {
        return amountused;
    }

    public void setAmountused(String amountused) {
        this.amountused = amountused;
    }

    public String getLoanbillnumber() {
        return loanbillnumber;
    }

    public void setLoanbillnumber(String loanbillnumber) {
        this.loanbillnumber = loanbillnumber;
    }

    public String getPayeeproperty() {
        return payeeproperty;
    }

    public void setPayeeproperty(String payeeproperty) {
        this.payeeproperty = payeeproperty;
    }

    public String getLastremitdate() {
        return lastremitdate;
    }

    public void setLastremitdate(String lastremitdate) {
        this.lastremitdate = lastremitdate;
    }

    public String getInvoicetitle() {
        return invoicetitle;
    }

    public void setInvoicetitle(String invoicetitle) {
        this.invoicetitle = invoicetitle;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getFivouchered() {
        return fivouchered;
    }

    public void setFivouchered(String fivouchered) {
        this.fivouchered = fivouchered;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}