package com.deppon.dpm.module.management.shared.domain;
/**
 * 应用权限实体
 * @author 276344
 *
 */
public class AppPermissionEntity {
	/**
	 * 应用id 根商店appid对应
	 */
	private int appid;
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
	
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
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
