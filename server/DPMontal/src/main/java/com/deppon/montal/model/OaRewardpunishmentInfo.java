package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;

public class OaRewardpunishmentInfo {
    private BigDecimal id;

    private BigDecimal processinstid;

    private String rewardpunishmenttype;

    private String disposetarget;

    private String money;

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

    public String getRewardpunishmenttype() {
        return F_Constants.chageNull(rewardpunishmenttype);
    }

    public void setRewardpunishmenttype(String rewardpunishmenttype) {
        this.rewardpunishmenttype = rewardpunishmenttype;
    }

    public String getDisposetarget() {
        return F_Constants.chageNull(disposetarget);
    }

    public void setDisposetarget(String disposetarget) {
        this.disposetarget = disposetarget;
    }

    public String getMoney() {
        return F_Constants.chageNull(money);
    }

    public void setMoney(String money) {
        this.money = money;
    }
}