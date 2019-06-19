package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;


   /** 
   * @ClassName: TWFSexpensehk 
   * @Description:(付款申请（香港）/费用报销申请  实体类)
   * @TableName:T_WFS_EXPENSEHK
   * @author yin
   * @date 2013-7-15 下午2:46:07 
   * 
   */
public class TWFSexpensehk {
    private BigDecimal processinstid;

    private String proposer;

    private String userid;

    private String applydept;

    private String subcompany;

    private String payee;

    private String phoneno;

    private String bank;

    private String accounttype;

    private String province;

    private String city;

    private String subbranch;

    private String paymentmethod;

    private String bankno;

    private String invoicetitle;

    private String reason;

    private Date createdate;

    private String billtype;

    private String extra1;

    private String extra2;

    private BigDecimal extra3;
    
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

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getSubcompany() {
        return subcompany;
    }

    public void setSubcompany(String subcompany) {
        this.subcompany = subcompany;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
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

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno;
    }

    public String getInvoicetitle() {
        return invoicetitle;
    }

    public void setInvoicetitle(String invoicetitle) {
        this.invoicetitle = invoicetitle;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public BigDecimal getExtra3() {
        return extra3;
    }

    public void setExtra3(BigDecimal extra3) {
        this.extra3 = extra3;
    }
}