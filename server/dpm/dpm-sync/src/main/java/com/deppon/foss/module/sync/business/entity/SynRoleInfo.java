package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;
import java.util.Date;


public class SynRoleInfo implements Serializable{

    private final static long serialVersionUID = 11082011L;
    private String id;
    private String roleId;
    private String roleName;
    private String roleBasCode;
    private String roleEnCode;
    private String roleType;
    private String changeType;
    private String changeDate;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String value) {
        this.roleId = value;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String value) {
        this.roleName = value;
    }

    public String getRoleBasCode() {
        return roleBasCode;
    }

    public void setRoleBasCode(String value) {
        this.roleBasCode = value;
    }

    public String getRoleEnCode() {
        return roleEnCode;
    }

    public void setRoleEnCode(String value) {
        this.roleEnCode = value;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String value) {
        this.roleType = value;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String value) {
        this.changeType = value;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String value) {
        this.changeDate = value;
    }

}
