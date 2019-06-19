package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
   * @ClassName: OAPersonelimPower 
   * @Description:TODO(人事授权申请实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:32:47 
   *
 */
public class OAPersonelimPower {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String applyname;

    private String impowerto;

    private Date impowerstarttime;

    private Date impowerendtime;

    private String reason;

    private String userid;

    private Object isauthorized;

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

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getImpowerto() {
        return impowerto;
    }

    public void setImpowerto(String impowerto) {
        this.impowerto = impowerto;
    }

    public Date getImpowerstarttime() {
        return impowerstarttime;
    }

    public void setImpowerstarttime(Date impowerstarttime) {
        this.impowerstarttime = impowerstarttime;
    }

    public Date getImpowerendtime() {
        return impowerendtime;
    }

    public void setImpowerendtime(Date impowerendtime) {
        this.impowerendtime = impowerendtime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Object getIsauthorized() {
        return isauthorized;
    }

    public void setIsauthorized(Object isauthorized) {
        this.isauthorized = isauthorized;
    }
}