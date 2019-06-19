package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 节点与产品调整实体Bean
 * @author zhaohui
 * @Date 2014-01-14 09:56:49
 */
 
public class ProductAdjustmentBean extends Entity {
	
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
	* 所属事业部 
	*/
	private String businessDept;
	
	/** 
	* 申请类别-卡航/城运 
	*/
	private String applyTypeCar;
	
	/** 
	* 申请类型-开通/取消 
	*/
	private String applyTypeOpen;
	
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
	* 获取 id.
	*
	* @return id.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 id.
	*
	* @param id.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 工作流号.
	*
	* @return 工作流号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 工作流号.
	*
	* @param 工作流号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 申请人姓名.
	*
	* @param 申请人姓名.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 设置 申请人工号.
	*
	* @param 申请人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 申请人部门.
	*
	* @return 申请人部门.
	*/
	public String getDepartment() {
		return department;
	}

	/**
	* 设置 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	* 获取 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getBusinessDept() {
		return businessDept;
	}

	/**
	* 设置 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setBusinessDept(String businessDept) {
		this.businessDept = businessDept;
	}
	
	/**
	* 获取 申请类别-卡航/城运.
	*
	* @return 申请类别-卡航/城运.
	*/
	public String getApplyTypeCar() {
		return applyTypeCar;
	}

	/**
	* 设置 申请类别-卡航/城运.
	*
	* @param 申请类别-卡航/城运.
	*/
	public void setApplyTypeCar(String applyTypeCar) {
		this.applyTypeCar = applyTypeCar;
	}
	
	/**
	* 获取 申请类型-开通/取消.
	*
	* @return 申请类型-开通/取消.
	*/
	public String getApplyTypeOpen() {
		return applyTypeOpen;
	}

	/**
	* 设置 申请类型-开通/取消.
	*
	* @param 申请类型-开通/取消.
	*/
	public void setApplyTypeOpen(String applyTypeOpen) {
		this.applyTypeOpen = applyTypeOpen;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	/**
	* 获取 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreatTime() {
		return creatTime;
	}

	/**
	* 设置 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	
	/**
	* 获取 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 设置 修改时间.
	*
	* @param 修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获取 业务状态.
	*
	* @return 业务状态.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务状态.
	*
	* @param 业务状态.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public Long getReserveOne() {
		return reserveOne;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setReserveOne(Long reserveOne) {
		this.reserveOne = reserveOne;
	}
	
	/**
	* 获取 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getReserveTwo() {
		return reserveTwo;
	}

	/**
	* 设置 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}
	
	/**
	* 获取 备用字段3.
	*
	* @return 备用字段3.
	*/
	public String getReserveThree() {
		return reserveThree;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}
	

}
