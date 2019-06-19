package com.deppon.dpm.module.management.shared.domain;
/**
 * 应用权限实体
 * @author 276344
 *
 */
public class LocationPermissionEntity {	
	/**
	 * 有权限的组织id
	 */
	private int orgid;
	/**
	 * 有权限的工号id
	 */
	private String userid;
	/**
	 * 有权限的层级 
	 */
	private String level;
	
	
	public int getOrgid() {
		return orgid;
	}
	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
}
