package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OALicenseLendRead 
   * @Description:(证照借阅申请（新）实体类) 
   * @TableName:OA_LOANCERTIFICATE
   * @author 廖建雄 
   * @date 2013-8-20 下午2:30:24 
   * 
   */
public class OALicenseLendRead {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String appliermanagerlevel;

    private String licensename;

    private String help;

    private Date backdate;

    private String whyapply;

    private String username;

    private String lendingdepart;

    private String licensetype;

    private Date lendingdate;

    private String lendinguserid;

    private String amsapplytype;

    private String amssn;

    private String extend1;

    private String extend2;

    private String area;
    

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppliermanagerlevel() {
        return appliermanagerlevel;
    }

    public void setAppliermanagerlevel(String appliermanagerlevel) {
        this.appliermanagerlevel = appliermanagerlevel;
    }

    public String getLicensename() {
        return licensename;
    }

    public void setLicensename(String licensename) {
        this.licensename = licensename;
    }

    public String getHelp() {
        return F_Constants.chageNull(help);
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getBackdate() {
        return F_Constants.getDateyyyyMMdd(backdate);
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    public String getWhyapply() {
        return F_Constants.chageNull(whyapply);
    }

    public void setWhyapply(String whyapply) {
        this.whyapply = whyapply;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLendingdepart() {
        return lendingdepart;
    }

    public void setLendingdepart(String lendingdepart) {
        this.lendingdepart = lendingdepart;
    }

    public String getLicensetype() {
        return F_Constants.chageNull(licensetype);
    }

    public void setLicensetype(String licensetype) {
        this.licensetype = licensetype;
    }

    public String getLendingdate() {
        return F_Constants.getDateyyyyMMdd(lendingdate);
    }

    public void setLendingdate(Date lendingdate) {
        this.lendingdate = lendingdate;
    }

    public String getLendinguserid() {
        return lendinguserid;
    }

    public void setLendinguserid(String lendinguserid) {
        this.lendinguserid = lendinguserid;
    }

    public String getAmsapplytype() {
        return amsapplytype;
    }

    public void setAmsapplytype(String amsapplytype) {
        this.amsapplytype = amsapplytype;
    }

    public String getAmssn() {
        return amssn;
    }

    public void setAmssn(String amssn) {
        this.amssn = amssn;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getArea() {
        return F_Constants.chageNull(area);
    }

    public void setArea(String area) {
        this.area = area;
    }
}