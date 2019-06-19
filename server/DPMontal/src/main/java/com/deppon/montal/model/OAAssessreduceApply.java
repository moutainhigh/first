package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OAAssessreduceApply 
   * @Description:(考核特批减免申请实体类) 
   * @TableName:OA_ASSESSREDUCEAPPLY
   * @author 廖建雄 
   * @date 2013-7-15 下午2:42:11 
   * 
   */
public class OAAssessreduceApply {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String reason;

    private String category;

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

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}