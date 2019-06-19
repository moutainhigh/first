package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OALicenseCanceledInfo 
   * @Description:(分公司证照注销业务实体类) 
   * @TableName:OA_LICENSECANCELL
   * @author 廖建雄 
   * @date 2013-8-20 下午2:23:09 
   * 
   */
public class OALicenseCanceledInfo {
    private BigDecimal processinstid;

    private String name;

    private String orgname;

    private String licensename;

    private String reason;

    private String cancellaging;

    private String orgcode;

    private BigDecimal empid;

    private String financedep;

    private String subcompany;

    private String canceltype;

    private String matterteam;

    private String appuser;

    private String handleUser;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getLicensename() {
        return licensename;
    }

    public void setLicensename(String licensename) {
        this.licensename = licensename;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCancellaging() {
        return cancellaging;
    }

    public void setCancellaging(String cancellaging) {
        this.cancellaging = cancellaging;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getFinancedep() {
        return financedep;
    }

    public void setFinancedep(String financedep) {
        this.financedep = financedep;
    }

    public String getSubcompany() {
        return subcompany;
    }

    public void setSubcompany(String subcompany) {
        this.subcompany = subcompany;
    }

    public String getCanceltype() {
        return canceltype;
    }

    public void setCanceltype(String canceltype) {
        this.canceltype = canceltype;
    }

    public String getMatterteam() {
        return matterteam;
    }

    public void setMatterteam(String matterteam) {
        this.matterteam = matterteam;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getHandleUser() {
        return handleUser;
    }

    public void setHandleUser(String handleUser) {
        this.handleUser = handleUser;
    }
}