package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OAManagerProcess 
   * @Description:(流程新建/变更/废除实体类) 
   * @TableName:OA_MANAGERPROCESS
   * @author 廖建雄 
   * @date 2013-8-20 下午2:40:45 
   * 
   */
public class OAManagerProcess {
    private BigDecimal processinstid;

    private String applyname;

    private String applydeptname;

    private String applyuserid;

    private String applyprocessname;

    private String versionno;

    private String applytype;

    private String applyreason;

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

    public String getApplydeptname() {
        return applydeptname;
    }

    public void setApplydeptname(String applydeptname) {
        this.applydeptname = applydeptname;
    }

    public String getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(String applyuserid) {
        this.applyuserid = applyuserid;
    }

    public String getApplyprocessname() {
        return applyprocessname;
    }

    public void setApplyprocessname(String applyprocessname) {
        this.applyprocessname = applyprocessname;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno;
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }
}