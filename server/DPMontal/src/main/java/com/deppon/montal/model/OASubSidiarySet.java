package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OASubSidiarySet 
   * @Description:(子公司设立及变更申请实体类) 
   * @TabelName:OA_SUBSIDIARYSET
   * @author 廖建雄 
   * @date 2013-7-15 下午2:53:05 
   * 
   */
public class OASubSidiarySet {
    private BigDecimal processinstid;

    private String type;

    private String localoffice;

    private String reason;

    private BigDecimal empid;

    private String name;

    private String financedep;

    private String area;

    private String beforeupdate;

    private String afterupdate;

    private String matterteam;

    private String subcompany;

    private String compensation;

    private String updatetype;

    private String userid;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocaloffice() {
        return localoffice;
    }

    public void setLocaloffice(String localoffice) {
        this.localoffice = localoffice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFinancedep() {
        return financedep;
    }

    public void setFinancedep(String financedep) {
        this.financedep = financedep;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBeforeupdate() {
        return beforeupdate;
    }

    public void setBeforeupdate(String beforeupdate) {
        this.beforeupdate = beforeupdate;
    }

    public String getAfterupdate() {
        return afterupdate;
    }

    public void setAfterupdate(String afterupdate) {
        this.afterupdate = afterupdate;
    }

    public String getMatterteam() {
        return matterteam;
    }

    public void setMatterteam(String matterteam) {
        this.matterteam = matterteam;
    }

    public String getSubcompany() {
        return subcompany;
    }

    public void setSubcompany(String subcompany) {
        this.subcompany = subcompany;
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public String getUpdatetype() {
        return updatetype;
    }

    public void setUpdatetype(String updatetype) {
        this.updatetype = updatetype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}