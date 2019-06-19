package com.deppon.montal.model;

import java.math.BigDecimal;
/**
 * 
   * @ClassName: OAKouhuoApply 
   * @Description:TODO(扣货申请实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:40:57 
   *
 */
public class OAKouhuoApply {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String kouhuodanhao;

    private BigDecimal insuredamout;

    private BigDecimal collectionamout;

    private String goodsdetaininorgcode;

    private String goodsdetaininorgname;

    private String whyapply;

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

    public String getKouhuodanhao() {
        return kouhuodanhao;
    }

    public void setKouhuodanhao(String kouhuodanhao) {
        this.kouhuodanhao = kouhuodanhao;
    }

    public BigDecimal getInsuredamout() {
        return insuredamout;
    }

    public void setInsuredamout(BigDecimal insuredamout) {
        this.insuredamout = insuredamout;
    }

    public BigDecimal getCollectionamout() {
        return collectionamout;
    }

    public void setCollectionamout(BigDecimal collectionamout) {
        this.collectionamout = collectionamout;
    }

    public String getGoodsdetaininorgcode() {
        return goodsdetaininorgcode;
    }

    public void setGoodsdetaininorgcode(String goodsdetaininorgcode) {
        this.goodsdetaininorgcode = goodsdetaininorgcode;
    }

    public String getGoodsdetaininorgname() {
        return goodsdetaininorgname;
    }

    public void setGoodsdetaininorgname(String goodsdetaininorgname) {
        this.goodsdetaininorgname = goodsdetaininorgname;
    }

    public String getWhyapply() {
        return whyapply;
    }

    public void setWhyapply(String whyapply) {
        this.whyapply = whyapply;
    }
}