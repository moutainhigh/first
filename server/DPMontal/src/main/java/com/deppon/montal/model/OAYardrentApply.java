package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;


   /** 
   * @ClassName: OAYardrentApply 
   * @Description:(场地租赁实体类)
   * @TableName:OA_YARDRENTAPPLY 
   * @author 廖建雄 
   * @date 2013-6-20 上午9:15:37 
   * 
   */
public class OAYardrentApply {
    private BigDecimal processinstid;

    private String empid;

    private String empcode;

    private String signtype;

    private String oldcontarctnum;

    private String name;

    private String area;

    private String childcompany;

    private String rentname;

    private String leasename;

    private String leasedept;

    private String leasecreage;

    private String startdate;

    private String enddate;

    private String yearrental;

    private String paytype;

    private String rentfreebgdate;

    private String rentfreeenddate;

    private String reason;

    private String financedept;

    private Date allagreetime;

    private String matterTeam;

    private String projectid;

    private String projectname;

    private String leasetype;
    
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

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getOldcontarctnum() {
        return oldcontarctnum;
    }

    public void setOldcontarctnum(String oldcontarctnum) {
        this.oldcontarctnum = oldcontarctnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getChildcompany() {
        return childcompany;
    }

    public void setChildcompany(String childcompany) {
        this.childcompany = childcompany;
    }

    public String getRentname() {
        return rentname;
    }

    public void setRentname(String rentname) {
        this.rentname = rentname;
    }

    public String getLeasename() {
        return leasename;
    }

    public void setLeasename(String leasename) {
        this.leasename = leasename;
    }

    public String getLeasedept() {
        return leasedept;
    }

    public void setLeasedept(String leasedept) {
        this.leasedept = leasedept;
    }

    public String getLeasecreage() {
        return leasecreage;
    }

    public void setLeasecreage(String leasecreage) {
        this.leasecreage = leasecreage;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getYearrental() {
        return yearrental;
    }

    public void setYearrental(String yearrental) {
        this.yearrental = yearrental;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getRentfreebgdate() {
        return rentfreebgdate;
    }

    public void setRentfreebgdate(String rentfreebgdate) {
        this.rentfreebgdate = rentfreebgdate;
    }

    public String getRentfreeenddate() {
        return rentfreeenddate;
    }

    public void setRentfreeenddate(String rentfreeenddate) {
        this.rentfreeenddate = rentfreeenddate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFinancedept() {
        return financedept;
    }

    public void setFinancedept(String financedept) {
        this.financedept = financedept;
    }

    public Date getAllagreetime() {
        return allagreetime;
    }

    public void setAllagreetime(Date allagreetime) {
        this.allagreetime = allagreetime;
    }

    public String getMatterTeam() {
        return matterTeam;
    }

    public void setMatterTeam(String matterTeam) {
        this.matterTeam = matterTeam;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getLeasetype() {
        return leasetype;
    }

    public void setLeasetype(String leasetype) {
        this.leasetype = leasetype;
    }
}