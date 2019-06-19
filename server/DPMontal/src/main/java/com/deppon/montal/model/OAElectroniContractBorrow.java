package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
/**
 * 
   * @ClassName: OAElectroniCcontractBorrow 
   * @Description:TODO(电子合同借阅实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:40:25 
   *
 */
public class OAElectroniContractBorrow {
    private BigDecimal processinstid;

    private String name;

    private String empcode;

    private String reason;

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
    
    public static final Map<String, String> BORROW_CONTRACT_DENSE = new HashMap<String, String>(){{
 	   put("1", "普通");
 	   put("2", "机密");
 	   put("3", "绝密");
    }};

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
}