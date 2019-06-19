package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;
/**
 * 
   * @ClassName: OABusinessBaddebtleaf 
   * @Description:TODO(业务类坏账申请实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:36:23 
   *
 */
public class OABusinessBaddebtleaf {
    private BigDecimal id;

    private String processinstid;

    private String responsibledept;

    private String indeptmoney;

    private String responsibleperson;

    private String deductionamount;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(String processinstid) {
        this.processinstid = processinstid;
    }

    public String getResponsibledept() {
        return F_Constants.chageNull(responsibledept);
    }

    public void setResponsibledept(String responsibledept) {
        this.responsibledept = responsibledept;
    }

    public String getIndeptmoney() {
        return F_Constants.chageNull(indeptmoney);
    }

    public void setIndeptmoney(String indeptmoney) {
        this.indeptmoney = indeptmoney;
    }

    public String getResponsibleperson() {
        return F_Constants.chageNull(responsibleperson);
    }

    public void setResponsibleperson(String responsibleperson) {
        this.responsibleperson = responsibleperson;
    }

    public String getDeductionamount() {
        return F_Constants.chageNull(deductionamount);
    }

    public void setDeductionamount(String deductionamount) {
        this.deductionamount = deductionamount;
    }
}