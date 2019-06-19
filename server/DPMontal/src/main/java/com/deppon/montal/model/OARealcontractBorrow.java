package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OARealcontractBorrow 
   * @Description:(实体合同借阅实体类)
   * @TableName:OA_REALCONTRACTBORROW
   * @author 廖建雄 
   * @date 2013-5-14 上午9:06:56 
   * 
   */
public class OARealcontractBorrow {
    private BigDecimal processinstid;

    private String name;

    private String empcode;

    private String reson;

    private String area;

    private String contractnum;

    private String contracttype;

    private String borrowdays;

    private String startdate;

    private String enddate;

    private String contractdense;

    private String amssn;

    private String amsapplytype;

    private String extend1;

    private String extend2;

    private String signdepartment;

    private String customername;

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

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getReson() {
        return F_Constants.chageNull(reson);
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getContractnum() {
        return contractnum;
    }

    public void setContractnum(String contractnum) {
        this.contractnum = contractnum;
    }

    public String getContracttype() {
        return contracttype;
    }

    public void setContracttype(String contracttype) {
        this.contracttype = contracttype;
    }

    public String getBorrowdays() {
        return borrowdays;
    }

    public void setBorrowdays(String borrowdays) {
        this.borrowdays = borrowdays;
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

    public String getContractdense() {
        return contractdense;
    }

    public void setContractdense(String contractdense) {
        this.contractdense = contractdense;
    }

    public String getAmssn() {
        return amssn;
    }

    public void setAmssn(String amssn) {
        this.amssn = amssn;
    }

    public String getAmsapplytype() {
        return amsapplytype;
    }

    public void setAmsapplytype(String amsapplytype) {
        this.amsapplytype = amsapplytype;
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

    public String getSigndepartment() {
        return signdepartment;
    }

    public void setSigndepartment(String signdepartment) {
        this.signdepartment = signdepartment;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }
}