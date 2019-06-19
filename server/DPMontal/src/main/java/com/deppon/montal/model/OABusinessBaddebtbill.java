package com.deppon.montal.model;

import java.math.BigDecimal;
/**
 * 
   * @ClassName: OABusinessBaddebtbill 
   * @Description:TODO(业务类坏账申请实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:36:09 
   *
 */
public class OABusinessBaddebtbill {
    private BigDecimal id;

    private String processinstid;

    private String businessnumber;

    private String noverification;

    private String businessdate;

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

    public String getBusinessnumber() {
        return businessnumber;
    }

    public void setBusinessnumber(String businessnumber) {
        this.businessnumber = businessnumber;
    }

    public String getNoverification() {
        return noverification;
    }

    public void setNoverification(String noverification) {
        this.noverification = noverification;
    }

    public String getBusinessdate() {
        return businessdate;
    }

    public void setBusinessdate(String businessdate) {
        this.businessdate = businessdate;
    }
}