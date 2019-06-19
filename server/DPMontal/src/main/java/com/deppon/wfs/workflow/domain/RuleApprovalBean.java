package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 章程/决议审批申请
 * @author zhaohui
 * @Date 2014-01-08 18:34:07
 */
 
public class RuleApprovalBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* id 
	*/
	private String busino;
	
	/** 
	* 工作流号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人部门 
	*/
	private String department;
	
	/** 
	* 申请人岗位 
	*/
	private String post;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 创建时间 
	*/
	private Date creatTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务状态 
	*/
	private String isseffective;
	
	/** 
	* 备用字段1 
	*/
	private Long reserveOne;
	
	/** 
	* 备用字段2 
	*/
	private String reserveTwo;
	
	/** 
	* 备用字段3 
	*/
	private String reserveThree;
	
	
	/**
	* ��ȡ id.
	*
	* @return id.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* ���� id.
	*
	* @param id.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* ��ȡ 工作流号.
	*
	* @return 工作流号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* ���� 工作流号.
	*
	* @param 工作流号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* ��ȡ 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* ���� 申请人姓名.
	*
	* @param 申请人姓名.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* ��ȡ 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* ���� 申请人工号.
	*
	* @param 申请人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* ��ȡ 申请人部门.
	*
	* @return 申请人部门.
	*/
	public String getDepartment() {
		return department;
	}

	/**
	* ���� 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	* ��ȡ 申请人岗位.
	*
	* @return 申请人岗位.
	*/
	public String getPost() {
		return post;
	}

	/**
	* ���� 申请人岗位.
	*
	* @param 申请人岗位.
	*/
	public void setPost(String post) {
		this.post = post;
	}
	
	/**
	* ��ȡ 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	* ���� 申请事由.
	*
	* @param 申请事由.
	*/
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	/**
	* ��ȡ 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreatTime() {
		return creatTime;
	}

	/**
	* ���� 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	
	/**
	* ��ȡ 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* ���� 修改时间.
	*
	* @param 修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* ��ȡ 业务状态.
	*
	* @return 业务状态.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* ���� 业务状态.
	*
	* @param 业务状态.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* ��ȡ 备用字段1.
	*
	* @return 备用字段1.
	*/
	public Long getReserveOne() {
		return reserveOne;
	}

	/**
	* ���� 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setReserveOne(Long reserveOne) {
		this.reserveOne = reserveOne;
	}
	
	/**
	* ��ȡ 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getReserveTwo() {
		return reserveTwo;
	}

	/**
	* ���� 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}
	
	/**
	* ��ȡ 备用字段3.
	*
	* @return 备用字段3.
	*/
	public String getReserveThree() {
		return reserveThree;
	}

	/**
	* ���� 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}
	

}
