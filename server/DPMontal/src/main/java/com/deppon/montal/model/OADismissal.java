package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OADismissal 
   * @Description:(免职申请实体类)
   * @TableName: OA_DISMISSAL 
   * @author 廖建雄 
   * @date 2013-6-20 下午2:51:58 
   * 
   */
public class OADismissal {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String remark;

    private String dismissaltype;

    private String manname;

    private BigDecimal manid;

    private String mandept;

    private String mandeptid;

    private String manpost;

    private String personnel;

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

    public String getRemark() {
        return F_Constants.chageNull(remark);
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDismissaltype() {
        return dismissaltype;
    }

    public void setDismissaltype(String dismissaltype) {
        this.dismissaltype = dismissaltype;
    }

    public String getManname() {
        return manname;
    }

    public void setManname(String manname) {
        this.manname = manname;
    }

    public BigDecimal getManid() {
        return manid;
    }

    public void setManid(BigDecimal manid) {
        this.manid = manid;
    }

    public String getMandept() {
        return mandept;
    }

    public void setMandept(String mandept) {
        this.mandept = mandept;
    }

    public String getMandeptid() {
        return mandeptid;
    }

    public void setMandeptid(String mandeptid) {
        this.mandeptid = mandeptid;
    }

    public String getManpost() {
        return manpost;
    }

    public void setManpost(String manpost) {
        this.manpost = manpost;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }
}