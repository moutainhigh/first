package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OABorrowsealApply 
   * @Description:(借章申请实体类)
   * @TableName：OA_BORROWSEALAPPLY 
   * @author 廖建雄 
   * @date 2013-6-20 下午2:48:07 
   * 
   */
public class OABorrowsealApply {
    private BigDecimal processinstid;

    private String name;

    private String empcode;

    private String dept;

    private String area;
    private String area1;
    private String area2;

    private String sealname;

    private String sealtype;

    private String borrowdays;

    private String startdate;

    private String returndate;

    private String reason;

    private String amsapplytype;

    private String amssn;

    private String extend1;

    private String extend2;

    private String sealdept;

    private String sealtrustee;

    private String sealtypecode;

    private String sealtaketo;

    private String sealbrief;

    private String sealbrrowcounts;

    private String sealsequencecode;

    private String sealgeneralcode;

    private String sealarchivalcode;

    private String sealcode;

    private String sealasavedept;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getArea1() {
	return F_Constants.chageNull(area1);
    }
    
    public void setArea1(String area1) {
	this.area1 = area1;
    }
    public String getArea2() {
	return F_Constants.chageNull(area2);
    }
    
    public void setArea2(String area2) {
	this.area2 = area2;
    }

    public String getSealname() {
        return sealname;
    }

    public void setSealname(String sealname) {
        this.sealname = sealname;
    }

    public String getSealtype() {
        return sealtype;
    }

    public void setSealtype(String sealtype) {
        this.sealtype = sealtype;
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

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getSealdept() {
        return sealdept;
    }

    public void setSealdept(String sealdept) {
        this.sealdept = sealdept;
    }

    public String getSealtrustee() {
        return sealtrustee;
    }

    public void setSealtrustee(String sealtrustee) {
        this.sealtrustee = sealtrustee;
    }

    public String getSealtypecode() {
        return sealtypecode;
    }

    public void setSealtypecode(String sealtypecode) {
        this.sealtypecode = sealtypecode;
    }

    public String getSealtaketo() {
        return sealtaketo;
    }

    public void setSealtaketo(String sealtaketo) {
        this.sealtaketo = sealtaketo;
    }

    public String getSealbrief() {
        return F_Constants.chageNull(sealbrief);
    }

    public void setSealbrief(String sealbrief) {
        this.sealbrief = sealbrief;
    }

    public String getSealbrrowcounts() {
        return F_Constants.chageNull(sealbrrowcounts);
    }

    public void setSealbrrowcounts(String sealbrrowcounts) {
        this.sealbrrowcounts = sealbrrowcounts;
    }

    public String getSealsequencecode() {
        return sealsequencecode;
    }

    public void setSealsequencecode(String sealsequencecode) {
        this.sealsequencecode = sealsequencecode;
    }

    public String getSealgeneralcode() {
        return sealgeneralcode;
    }

    public void setSealgeneralcode(String sealgeneralcode) {
        this.sealgeneralcode = sealgeneralcode;
    }

    public String getSealarchivalcode() {
        return sealarchivalcode;
    }

    public void setSealarchivalcode(String sealarchivalcode) {
        this.sealarchivalcode = sealarchivalcode;
    }

    public String getSealcode() {
        return sealcode;
    }

    public void setSealcode(String sealcode) {
        this.sealcode = sealcode;
    }

    public String getSealasavedept() {
        return sealasavedept;
    }

    public void setSealasavedept(String sealasavedept) {
        this.sealasavedept = sealasavedept;
    }
    
}