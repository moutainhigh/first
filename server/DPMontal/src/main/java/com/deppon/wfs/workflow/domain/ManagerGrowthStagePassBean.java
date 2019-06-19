package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 管理人员转正成长期实体Bean
 * @author Zhao Hui
 * @Date 2013-11-15 18:57:17
 */
 
public class ManagerGrowthStagePassBean extends Entity {
	
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
	private String applyDepartment;
	
	/** 
	* 所属区域 
	*/
	private String belongArea;
	
	/** 
	* 所属区域标杆编码 
	*/
	private String areaFinasyscode;
	
	/** 
	* 申请类别 
	*/
	private String applyType;
	
	/** 
	* 转正类别 
	*/
	private String positiveType;
	
	/** 
	* 成长期通过类别 
	*/
	private String growthStageType;
	
	/** 
	* 岗位 
	*/
	private String post;
	
	/** 
	* 考核等级 
	*/
	private String assessGrade;
	
	/** 
	* 任命日期 
	*/
	private Date appointDate;
	
	/** 
	* 转正工作流号 
	*/
	private Long positiveProcessinstid;
	
	/** 
	* 转正日期 
	*/
	private Date positiveDate;
	
	/** 
	* 是否谈判工资 
	*/
	private String ifNegotiateSalary;
	
	/** 
	* 谈判工资金额 
	*/
	private BigDecimal negotiateSalary;
	
	/** 
	* 生效日期 
	*/
	private Date efficientDate;
	
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
	* 备用字段一 
	*/
	private Long reserveOne;
	
	/** 
	* 备用字段二 
	*/
	private String reserveTwo;
	
	/** 
	* 备用字段三 
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
	public String getApplyDepartment() {
		return applyDepartment;
	}

	/**
	* 设置 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	
	/**
	* 获取 所属区域.
	*
	* @return 所属区域.
	*/
	public String getBelongArea() {
		return belongArea;
	}

	/**
	* 设置 所属区域.
	*
	* @param 所属区域.
	*/
	public void setBelongArea(String belongArea) {
		this.belongArea = belongArea;
	}
	
	/**
	* 获取 所属区域标杆编码.
	*
	* @return 所属区域标杆编码.
	*/
	public String getAreaFinasyscode() {
		return areaFinasyscode;
	}

	/**
	* 设置 所属区域标杆编码.
	*
	* @param 所属区域标杆编码.
	*/
	public void setAreaFinasyscode(String areaFinasyscode) {
		this.areaFinasyscode = areaFinasyscode;
	}
	
	/**
	* 获取 申请类别.
	*
	* @return 申请类别.
	*/
	public String getApplyType() {
		return applyType;
	}

	/**
	* 设置 申请类别.
	*
	* @param 申请类别.
	*/
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	
	/**
	* 获取 转正类别.
	*
	* @return 转正类别.
	*/
	public String getPositiveType() {
		return positiveType;
	}

	/**
	* 设置 转正类别.
	*
	* @param 转正类别.
	*/
	public void setPositiveType(String positiveType) {
		this.positiveType = positiveType;
	}
	
	/**
	* 获取 成长期通过类别.
	*
	* @return 成长期通过类别.
	*/
	public String getGrowthStageType() {
		return growthStageType;
	}

	/**
	* 设置 成长期通过类别.
	*
	* @param 成长期通过类别.
	*/
	public void setGrowthStageType(String growthStageType) {
		this.growthStageType = growthStageType;
	}
	
	/**
	* 获取 岗位.
	*
	* @return 岗位.
	*/
	public String getPost() {
		return post;
	}

	/**
	* 设置 岗位.
	*
	* @param 岗位.
	*/
	public void setPost(String post) {
		this.post = post;
	}
	
	/**
	* 获取 考核等级.
	*
	* @return 考核等级.
	*/
	public String getAssessGrade() {
		return assessGrade;
	}

	/**
	* 设置 考核等级.
	*
	* @param 考核等级.
	*/
	public void setAssessGrade(String assessGrade) {
		this.assessGrade = assessGrade;
	}
	
	/**
	* 获取 任命日期.
	*
	* @return 任命日期.
	*/
	public Date getAppointDate() {
		return appointDate;
	}

	/**
	* 设置 任命日期.
	*
	* @param 任命日期.
	*/
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	
	/**
	* 获取 转正工作流号.
	*
	* @return 转正工作流号.
	*/
	public Long getPositiveProcessinstid() {
		return positiveProcessinstid;
	}

	/**
	* 设置 转正工作流号.
	*
	* @param 转正工作流号.
	*/
	public void setPositiveProcessinstid(Long positiveProcessinstid) {
		this.positiveProcessinstid = positiveProcessinstid;
	}
	
	/**
	* 获取 转正日期.
	*
	* @return 转正日期.
	*/
	public Date getPositiveDate() {
		return positiveDate;
	}

	/**
	* 设置 转正日期.
	*
	* @param 转正日期.
	*/
	public void setPositiveDate(Date positiveDate) {
		this.positiveDate = positiveDate;
	}
	
	/**
	* 获取 是否谈判工资.
	*
	* @return 是否谈判工资.
	*/
	public String getIfNegotiateSalary() {
		return ifNegotiateSalary;
	}

	/**
	* 设置 是否谈判工资.
	*
	* @param 是否谈判工资.
	*/
	public void setIfNegotiateSalary(String ifNegotiateSalary) {
		this.ifNegotiateSalary = ifNegotiateSalary;
	}
	
	/**
	* 获取 谈判工资金额.
	*
	* @return 谈判工资金额.
	*/
	public BigDecimal getNegotiateSalary() {
		return negotiateSalary;
	}

	/**
	* 设置 谈判工资金额.
	*
	* @param 谈判工资金额.
	*/
	public void setNegotiateSalary(BigDecimal negotiateSalary) {
		this.negotiateSalary = negotiateSalary;
	}
	
	/**
	* 获取 生效日期.
	*
	* @return 生效日期.
	*/
	public Date getEfficientDate() {
		return efficientDate;
	}

	/**
	* 设置 生效日期.
	*
	* @param 生效日期.
	*/
	public void setEfficientDate(Date efficientDate) {
		this.efficientDate = efficientDate;
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
	* 获取 备用字段一.
	*
	* @return 备用字段一.
	*/
	public Long getReserveOne() {
		return reserveOne;
	}

	/**
	* 设置 备用字段一.
	*
	* @param 备用字段一.
	*/
	public void setReserveOne(Long reserveOne) {
		this.reserveOne = reserveOne;
	}
	
	/**
	* 获取 备用字段二.
	*
	* @return 备用字段二.
	*/
	public String getReserveTwo() {
		return reserveTwo;
	}

	/**
	* 设置 备用字段二.
	*
	* @param 备用字段二.
	*/
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}
	
	/**
	* 获取 备用字段三.
	*
	* @return 备用字段三.
	*/
	public String getReserveThree() {
		return reserveThree;
	}

	/**
	* 设置  备用字段三.
	*
	* @param 备用字段三.
	*/
	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}
	

}
