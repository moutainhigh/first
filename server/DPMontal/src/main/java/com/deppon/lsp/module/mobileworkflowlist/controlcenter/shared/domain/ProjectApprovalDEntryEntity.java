package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 工程项目立项单-项目干系人实体类
 * @author 李清松
 * @date 2013-9-3 下午5:17:49
 * @since
 * @version
 */
public class ProjectApprovalDEntryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7236495296595781693L;

	//父ID
	private String parentId;
	
	//干系人姓名
	private String person;
	
	//部门名称
	private String orgName;
	
	//项目角色
	private String projectrole;
	
	//工作职责
	private String jobRespon;
	
	//联系电话
	private String telephoneNo;
	
	//邮箱
	private String email;

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the person
	 */
	public String getPerson() {
		if (person == null) {
			person = "";
		}
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(String person) {
		this.person = person;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		if (orgName == null) {
			orgName = "";
		}
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the projectrole
	 */
	public String getProjectrole() {
		if (projectrole == null) {
			projectrole = "";
		}
		return projectrole;
	}

	/**
	 * @param projectrole the projectrole to set
	 */
	public void setProjectrole(String projectrole) {
		this.projectrole = projectrole;
	}

	/**
	 * @return the jobRespon
	 */
	public String getJobRespon() {
		if (jobRespon == null){
			jobRespon = "";
		}
		return jobRespon;
	}

	/**
	 * @param jobRespon the jobRespon to set
	 */
	public void setJobRespon(String jobRespon) {
		this.jobRespon = jobRespon;
	}

	/**
	 * @return the telephoneNo
	 */
	public String getTelephoneNo() {
		if (telephoneNo == null) {
			telephoneNo = "";
		}
		return telephoneNo;
	}

	/**
	 * @param telephoneNo the telephoneNo to set
	 */
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		if (email == null) {
			email = "";
		}
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
