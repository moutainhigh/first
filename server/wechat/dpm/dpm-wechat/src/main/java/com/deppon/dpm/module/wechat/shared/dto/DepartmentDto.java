package com.deppon.dpm.module.wechat.shared.dto;
/**
 * 写入数据库对应的实体
 * @author 276344
 *
 */
public class DepartmentDto {
	//部门id
	private String orgId;
	//部门名称
	private String orgName;
	//父部门id
	private String parentOrgid;
	//父部门中的次序值 order值大的排序靠前
	private String order;
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getParentOrgid() {
		return parentOrgid;
	}
	public void setParentOrgid(String parentOrgid) {
		this.parentOrgid = parentOrgid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
}
