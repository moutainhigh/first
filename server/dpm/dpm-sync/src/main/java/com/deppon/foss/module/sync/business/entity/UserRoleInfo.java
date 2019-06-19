package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;
import java.util.List;


public class UserRoleInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orgBenchmarkCode;
	private String orgCode;
	private List<String> roleCode;
	private List<String> roleBseCode;
	
	public String getOrgBenchmarkCode() {
		return orgBenchmarkCode;
	}
	public void setOrgBenchmarkCode(String orgBenchmarkCode) {
		this.orgBenchmarkCode = orgBenchmarkCode;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public List<String> getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(List<String> roleCode) {
		this.roleCode = roleCode;
	}
	public List<String> getRoleBseCode() {
		return roleBseCode;
	}
	public void setRoleBseCode(List<String> roleBseCode) {
		this.roleBseCode = roleBseCode;
	}
	@Override
	public String toString() {
		String result = orgBenchmarkCode + ";" + orgCode + ";" + roleCode + ";" + roleBseCode;
		return result.replace("[", "").replace("]", "");
	}
}
