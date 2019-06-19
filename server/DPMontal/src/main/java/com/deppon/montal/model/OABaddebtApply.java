package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
   * @ClassName: OABaddebtApply 
   * @Description:TODO(非业务类坏账申请实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:38:10 
   *
 */
public class OABaddebtApply {
    private BigDecimal processinstid;

    private String applyname;

    private String applypersoncode;

    private String applydeptment;

    private Date applydate;

    private String baddebttype;

    private String depositcode;

    private String acceptdeposit;

    private Date begindate;

    private Date maturedate;

    private String deposittype;

    private String debitcode;

    private String debitname;

    private String customername;

    private String mishapcode;

    private BigDecimal baddebtmoney;

    private String baddebtreason;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getApplypersoncode() {
        return applypersoncode;
    }

    public void setApplypersoncode(String applypersoncode) {
        this.applypersoncode = applypersoncode;
    }

    public String getApplydeptment() {
        return applydeptment;
    }

    public void setApplydeptment(String applydeptment) {
        this.applydeptment = applydeptment;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getBaddebttype() {
        return baddebttype;
    }

    public void setBaddebttype(String baddebttype) {
        this.baddebttype = baddebttype;
    }

    public String getDepositcode() {
        return depositcode;
    }

    public void setDepositcode(String depositcode) {
        this.depositcode = depositcode;
    }

    public String getAcceptdeposit() {
        return acceptdeposit;
    }

    public void setAcceptdeposit(String acceptdeposit) {
        this.acceptdeposit = acceptdeposit;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getMaturedate() {
        return maturedate;
    }

    public void setMaturedate(Date maturedate) {
        this.maturedate = maturedate;
    }

    public String getDeposittype() {
        return deposittype;
    }

    public void setDeposittype(String deposittype) {
        this.deposittype = deposittype;
    }

    public String getDebitcode() {
        return debitcode;
    }

    public void setDebitcode(String debitcode) {
        this.debitcode = debitcode;
    }

    public String getDebitname() {
        return debitname;
    }

    public void setDebitname(String debitname) {
        this.debitname = debitname;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getMishapcode() {
        return mishapcode;
    }

    public void setMishapcode(String mishapcode) {
        this.mishapcode = mishapcode;
    }

    public BigDecimal getBaddebtmoney() {
        return baddebtmoney;
    }

    public void setBaddebtmoney(BigDecimal baddebtmoney) {
        this.baddebtmoney = baddebtmoney;
    }

    public String getBaddebtreason() {
        return baddebtreason;
    }

    public void setBaddebtreason(String baddebtreason) {
        this.baddebtreason = baddebtreason;
    }
}