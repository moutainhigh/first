package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OABankAccountOpencl 
   * @Description:(银行开户/销户申请实体类) 
   * @TableName:oa_bankaccountopencl
   * @author yinrongping
   * @date 2013-8-20 下午2:38:14 
   * 
   */
public class OABankAccountOpencl {
	
    private BigDecimal processinstid;

    private String applytype;

    private String accounttype;

    private String accountingdept;

    private String accountopenname;

    private String accounts;

    private String bankname;

    private String reason;

    private String name;

    private BigDecimal empid;

    private String accountingname;
    
    private String orgname;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getAccountingdept() {
        return accountingdept;
    }

    public void setAccountingdept(String accountingdept) {
        this.accountingdept = accountingdept;
    }

    public String getAccountopenname() {
        return accountopenname;
    }

    public void setAccountopenname(String accountopenname) {
        this.accountopenname = accountopenname;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getAccountingname() {
        return accountingname;
    }

    public void setAccountingname(String accountingname) {
        this.accountingname = accountingname;
    }

	public String getOrgname() {
		return orgname;
	}
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
    
}