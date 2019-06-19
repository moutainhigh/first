package com.deppon.montal.model;

import java.math.BigDecimal;
/**
 * 
   * @ClassName: OABaddebtChild 
   * @Description:TODO(非业务类坏账申请详情实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:38:32 
   *
 */
public class OABaddebtChild {
    private BigDecimal id;

    private BigDecimal processinstid;

    private String responsibilitydept;

    private BigDecimal todeptaccount;

    private String responsibilityperson;

    private BigDecimal personwithhold;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getResponsibilitydept() {
        return responsibilitydept;
    }

    public void setResponsibilitydept(String responsibilitydept) {
        this.responsibilitydept = responsibilitydept;
    }

    public String getTodeptaccount() {
        return todeptaccount+"";
    }

    public void setTodeptaccount(BigDecimal todeptaccount) {
        this.todeptaccount = todeptaccount;
    }

    public String getResponsibilityperson() {
        return responsibilityperson;
    }

    public void setResponsibilityperson(String responsibilityperson) {
        this.responsibilityperson = responsibilityperson;
    }

    public String getPersonwithhold() {
        return personwithhold+"";
    }

    public void setPersonwithhold(BigDecimal personwithhold) {
        this.personwithhold = personwithhold;
    }
}