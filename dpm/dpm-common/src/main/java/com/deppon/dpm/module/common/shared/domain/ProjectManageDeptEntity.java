package com.deppon.dpm.module.common.shared.domain;

/**
 * 工程管理部门实体
 *
 */
public class ProjectManageDeptEntity {

	// 部门编号
	private String orgcode;
	
	// 部门名称
	private String orgname;
	
	/*******分页参数********/
	// 当前页
	private int page;
	
	// 每页条数
	private int rows;
	
	// getter
	public int getPage() {
		return page;
	}

	// setter
	public void setPage(int page) {
		this.page = page;
	}

	// getter
	public int getRows() {
		return rows;
	}

	// setter
	public void setRows(int rows) {
		this.rows = rows;
	}

	// getter
	public String getOrgcode() {
		return orgcode;
	}

	// setter
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	// getter
	public String getOrgname() {
		return orgname;
	}

	// setter
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
}
