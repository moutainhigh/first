package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: CCOnbusiness 
   * @Description:TODO(出差申请)
   * @TableName: CC_ONBUSINESS
   * @author 廖建雄 
   * @date 2013-4-27 上午9:59:31 
   * 
   */
public class CCOnbusiness {
    private BigDecimal processinstid;

    private String billid;

    private String applydate;

    private String applypersonnumber;

    private String applypersonname;

    private String applydept;

    private String applycompany;

    private String applytype;

    private String position;

    private String associate;

    private String tatal;

    private String computeamount;

    private String phonenumber;

    private String handoverperson;

    private String costdept;

    private String costcompany;

    private String creattime;

    private String lastupdateuser;

    private String auditor;

    private String auditdate;

    private String billtype;

    private String applyreason;

    private String creator;

    private String onbusinessdate;

    private String onbusinessplace;

    private String empid;

    private String deadline;

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

    public String getAssociate() {
        return F_Constants.chageNull(associate);
    }

    public void setAssociate(String associate) {
        this.associate = associate;
    }

    public String getTatal() {
        return tatal;
    }

    public void setTatal(String tatal) {
        this.tatal = tatal;
    }

    public String getComputeamount() {
        return computeamount;
    }

    public void setComputeamount(String computeamount) {
        this.computeamount = computeamount;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getHandoverperson() {
        return handoverperson;
    }

    public void setHandoverperson(String handoverperson) {
        this.handoverperson = handoverperson;
    }

    public String getCostdept() {
        return costdept;
    }

    public void setCostdept(String costdept) {
        this.costdept = costdept;
    }

    public String getCostcompany() {
        return costcompany;
    }

    public void setCostcompany(String costcompany) {
        this.costcompany = costcompany;
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

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOnbusinessdate() {
        return onbusinessdate;
    }

    public void setOnbusinessdate(String onbusinessdate) {
        this.onbusinessdate = onbusinessdate;
    }

    public String getOnbusinessplace() {
        return onbusinessplace;
    }

    public void setOnbusinessplace(String onbusinessplace) {
        this.onbusinessplace = onbusinessplace;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}