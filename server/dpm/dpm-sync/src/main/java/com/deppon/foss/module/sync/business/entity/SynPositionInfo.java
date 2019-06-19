package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;
import java.util.Date;


public class SynPositionInfo implements Serializable{

    private final static long serialVersionUID = 11082011L;
    protected String id;
    protected String positionChangeId;
    protected String positionCode;
    protected String positionName;
    protected String lastModifyTime;
    protected String status;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getPositionChangeId() {
        return positionChangeId;
    }

    public void setPositionChangeId(String value) {
        this.positionChangeId = value;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String value) {
        this.positionCode = value;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String value) {
        this.positionName = value;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String value) {
        this.lastModifyTime = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

}
