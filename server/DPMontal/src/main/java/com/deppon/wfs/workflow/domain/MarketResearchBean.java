package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 市场调研实体Bean
 * @author Work Flow System
 * @Date 2014-01-06 22:08:20
 */
 
public class MarketResearchBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务表编号主键 
	*/
	private String busino;
	
	/** 
	* 流程实例号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人流工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人部门 
	*/
	private String applyPersonDept;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 是否外包 
	*/
	private String outSourcing;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 业务状态 
	*/
	private String isseffective;
	
	/** 
	* 备用字段 
	*/
	private Long spareField1;
	
	/** 
	* 备用字段 
	*/
	private String spareField2;
	
	/** 
	* 备用字段 
	*/
	private String spareField3;
	
	
	/**
	* 获取 业务表编号主键.
	*
	* @return 业务表编号主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务表编号主键.
	*
	* @param 业务表编号主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例号.
	*
	* @return 流程实例号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例号.
	*
	* @param 流程实例号.
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
	* 获取 申请人流工号.
	*
	* @return 申请人流工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 设置 申请人流工号.
	*
	* @param 申请人流工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 申请人部门.
	*
	* @return 申请人部门.
	*/
	public String getApplyPersonDept() {
		return applyPersonDept;
	}

	/**
	* 设置 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setApplyPersonDept(String applyPersonDept) {
		this.applyPersonDept = applyPersonDept;
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
	* 获取 是否外包.
	*
	* @return 是否外包.
	*/
	public String getOutSourcing() {
		return outSourcing;
	}

	/**
	* 设置 是否外包.
	*
	* @param 是否外包.
	*/
	public void setOutSourcing(String outSourcing) {
		this.outSourcing = outSourcing;
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
	* 获取 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 设置 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
	

}
