package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;
/**
 * 
   * @ClassName: OADataRequireApply 
   * @Description:(数据需求审批流程) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:22:34 
   *
 */
public class OADataRequireApply {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String data;

    private String manager;

    private String datauser;

    private String purpose;

    private String reason;

    private String applyname;

    private String category;

    private String isprovide;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDatauser() {
        return datauser;
    }

    public void setDatauser(String datauser) {
        this.datauser = datauser;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsprovide() {
        return isprovide;
    }

    public void setIsprovide(String isprovide) {
        this.isprovide = isprovide;
    }
}