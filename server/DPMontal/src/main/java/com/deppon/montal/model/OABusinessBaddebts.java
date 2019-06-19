package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.util.Base64DecodeParse;
/**
 * 
   * @ClassName: OABusinessBaddebts 
   * @Description:(业务类坏账申请实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:35:43 
   *
 */
public class OABusinessBaddebts {
    private BigDecimal processinstid;

    private String applycode;

    private String applydept;

    private String applydate;

    private String reason;

    private String customercode;

    private String customername;

    private String badamount;

    private String discription;

    private String errorcode;

    private String balancemethod;

    private String applyname;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplycode() {
        return applycode;
    }

    public void setApplycode(String applycode) {
        this.applycode = applycode;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getBadamount() {
        return badamount;
    }

    public void setBadamount(String badamount) {
        this.badamount = badamount;
    }

    public String getDiscription() {
        return Base64DecodeParse.Base64Decode(discription);
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getErrorcode() {
        return Base64DecodeParse.Base64Decode(errorcode);
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getBalancemethod() {
        return F_Constants.chageNull(balancemethod);
    }

    public void setBalancemethod(String balancemethod) {
        this.balancemethod = balancemethod;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }
}