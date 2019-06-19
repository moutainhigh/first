package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 业务考核实体Bean  考核方案申请
 * @author Work Flow System
 * @Date 2013-10-24 12:18:14
 */
 
public class AssessmentSchemeBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务表的编号 
	*/
	private String busino;
	
	/** 
	* 流程实例id 
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
	* 是否为绩效管理员:y——是，n——否 
	*/
	private String isPerformanceManager;
	
	/** 
	* 考核部门的标杆编码 
	*/
	private String oragnization;
	
	/** 
	* 考核部门的名称 
	*/
	private String oragnizationName;
	
	/** 
	* 所属事业部的标杆编码 
	*/
	private String area;
	
	/** 
	* 所属事业部的 
	*/
	private String areaName;
	
	/** 
	* 考核年份 
	*/
	private String yeartime;
	
	/** 
	* 考核季度 
	*/
	private String season;
	
	/** 
	* 所属部门性质的业务字典value值 
	*/
	private String orgType;
	
	/** 
	* 所属部门性质的业务字典的key值
	*/
	private String orgTypeName;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 业务状态,1表示存在，0逻辑删除 
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
	* 获取 业务表的编号.
	*
	* @return 业务表的编号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务表的编号.
	*
	* @param 业务表的编号.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例id.
	*
	* @return 流程实例id.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例id.
	*
	* @param 流程实例id.
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
	* 获取 是否为绩效管理员:y——是，n——否.
	*
	* @return 是否为绩效管理员:y——是，n——否.
	*/
	public String getIsPerformanceManager() {
		return isPerformanceManager;
	}

	/**
	* 设置 是否为绩效管理员:y——是，n——否.
	*
	* @param 是否为绩效管理员:y——是，n——否.
	*/
	public void setIsPerformanceManager(String isPerformanceManager) {
		this.isPerformanceManager = isPerformanceManager;
	}
	
	/**
	* 获取 考核部门的标杆编码.
	*
	* @return 考核部门的标杆编码.
	*/
	public String getOragnization() {
		return oragnization;
	}

	/**
	* 设置 考核部门的标杆编码.
	*
	* @param 考核部门的标杆编码.
	*/
	public void setOragnization(String oragnization) {
		this.oragnization = oragnization;
	}
	
	/**
	* 获取 考核部门的名称.
	*
	* @return 考核部门的名称.
	*/
	public String getOragnizationName() {
		return oragnizationName;
	}

	/**
	* 设置 考核部门的名称.
	*
	* @param 考核部门的名称.
	*/
	public void setOragnizationName(String oragnizationName) {
		this.oragnizationName = oragnizationName;
	}
	
	/**
	* 获取 所属事业部的标杆编码.
	*
	* @return 所属事业部的标杆编码.
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属事业部的标杆编码.
	*
	* @param 所属事业部的标杆编码.
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 所属事业部的.
	*
	* @return 所属事业部的.
	*/
	public String getAreaName() {
		return areaName;
	}

	/**
	* 设置 所属事业部的.
	*
	* @param 所属事业部的.
	*/
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	/**
	* 获取 考核年份.
	*
	* @return 考核年份.
	*/
	public String getYeartime() {
		return yeartime;
	}

	/**
	* 设置 考核年份.
	*
	* @param 考核年份.
	*/
	public void setYeartime(String yeartime) {
		this.yeartime = yeartime;
	}
	
	/**
	* 获取 考核季度.
	*
	* @return 考核季度.
	*/
	public String getSeason() {
		return season;
	}

	/**
	* 设置 考核季度.
	*
	* @param 考核季度.
	*/
	public void setSeason(String season) {
		this.season = season;
	}
	
	/**
	* 获取 所属部门性质.
	*
	* @return 所属部门性质.
	*/
	public String getOrgType() {
		return orgType;
	}

	/**
	* 设置 所属部门性质.
	*
	* @param 所属部门性质.
	*/
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	
	/**
	* 获取 所属部门名称.
	*
	* @return 所属部门名称.
	*/
	public String getOrgTypeName() {
		return orgTypeName;
	}

	/**
	* 设置 所属部门名称.
	*
	* @param 所属部门名称.
	*/
	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
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
	* 获取 业务状态,1表示存在，0逻辑删除.
	*
	* @return 业务状态,1表示存在，0逻辑删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务状态,1表示存在，0逻辑删除.
	*
	* @param 业务状态,1表示存在，0逻辑删除.
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
