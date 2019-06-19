package com.deppon.wfs.workflow.domain;

import java.util.Date;

import com.deppon.montal.util.FormatUtil;

/**
 * 人员外请申请实体Bean
 * @author mengtianxiang
 * @Date 2014-01-15 19:58:32
 */
 
public class StaffOutsideBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编码 
	*/
	private String busino;
	
	/** 
	* 工作流序号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 是否有效 
	*/
	private String isseffective;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 备用字段1 
	*/
	private String spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 备用字段3 
	*/
	private Long spareField3;
	
	/** 
	* 职位(同旧表) 
	*/
	private String position;
	
	/** 
	* 所属部门(同旧表) 
	*/
	private String dept;
	
	/** 
	* 所属区域 
	*/
	private String area;
	
	/** 
	* 所属区域标杆编码(同旧表AREA) 
	*/
	private String areaSyscode;
	
	/** 
	* 外请类型(同旧表) 
	*/
	private String type;
	
	/** 
	* 外请开始时间(同旧表) 
	*/
	private Date startTime;
	
	/** 
	* 外请结束时间(同旧表) 
	*/
	private Date endTime;
	
	/** 
	* 外请天数(同旧表) 
	*/
	private String days;
	
	/** 
	* 外请人数(同旧表) 
	*/
	private String numberOfPeople;
	
	/** 
	* 人均费用 
	*/
	private String perCost;
	
	/** 
	* 预算总费用 
	*/
	private String totalCost;
	
	/** 
	* 计费方式(同旧表) 
	*/
	private String billingMethod;
	
	/** 
	* 计费方式编码 
	*/
	private String billingMethodCode;
	
	/** 
	* 工作流人员缺口(同旧表) 
	*/
	private String personnelGap;
	
	/** 
	* 外请类型编码 
	*/
	private String typeCode;
	
	/** 
	* 其他计费(新业务不需要,仅迁移) 
	*/
	private String billingInstructions;
	
	/** 
	* 增补员工作流号
	*/
	private String workflowNo;
	
	
	/**
	* 获取 业务编码.
	*
	* @return 业务编码.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务编码.
	*
	* @param 业务编码.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 工作流序号.
	*
	* @return 工作流序号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 工作流序号.
	*
	* @param 工作流序号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人.
	*
	* @return 申请人.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 申请人.
	*
	* @param 申请人.
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
	* 获取 是否有效.
	*
	* @return 是否有效.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 是否有效.
	*
	* @param 是否有效.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
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
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public String getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(String spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获取 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 设置 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获取 备用字段3.
	*
	* @return 备用字段3.
	*/
	public Long getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setSpareField3(Long spareField3) {
		this.spareField3 = spareField3;
	}
	
	/**
	* 获取 职位(同旧表).
	*
	* @return 职位(同旧表).
	*/
	public String getPosition() {
		return position;
	}

	/**
	* 设置 职位(同旧表).
	*
	* @param 职位(同旧表).
	*/
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	* 获取 所属部门(同旧表).
	*
	* @return 所属部门(同旧表).
	*/
	public String getDept() {
		return dept;
	}

	/**
	* 设置 所属部门(同旧表).
	*
	* @param 所属部门(同旧表).
	*/
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	/**
	* 获取 所属区域.
	*
	* @return 所属区域.
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属区域.
	*
	* @param 所属区域.
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 所属区域标杆编码(同旧表AREA).
	*
	* @return 所属区域标杆编码(同旧表AREA).
	*/
	public String getAreaSyscode() {
		return areaSyscode;
	}

	/**
	* 设置 所属区域标杆编码(同旧表AREA).
	*
	* @param 所属区域标杆编码(同旧表AREA).
	*/
	public void setAreaSyscode(String areaSyscode) {
		this.areaSyscode = areaSyscode;
	}
	
	/**
	* 获取 外请类型(同旧表).
	*
	* @return 外请类型(同旧表).
	*/
	public String getType() {
		return type;
	}

	/**
	* 设置 外请类型(同旧表).
	*
	* @param 外请类型(同旧表).
	*/
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	* 获取 外请开始时间(同旧表).
	*
	* @return 外请开始时间(同旧表).
	*/
	public Date getStartTime() {
		return startTime;
	}
	public String getStartTimeStr() {
		return FormatUtil.formatDate(startTime,"yyyy-MM-dd HH:mm:ss");
	}

	/**
	* 设置 外请开始时间(同旧表).
	*
	* @param 外请开始时间(同旧表).
	*/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	* 获取 外请结束时间(同旧表).
	*
	* @return 外请结束时间(同旧表).
	*/
	public Date getEndTime() {
		return endTime;
	}
	public String getEndTimeStr() {
		return FormatUtil.formatDate(endTime,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	* 设置 外请结束时间(同旧表).
	*
	* @param 外请结束时间(同旧表).
	*/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	* 获取 外请天数(同旧表).
	*
	* @return 外请天数(同旧表).
	*/
	public String getDays() {
		return days;
	}

	/**
	* 设置 外请天数(同旧表).
	*
	* @param 外请天数(同旧表).
	*/
	public void setDays(String days) {
		this.days = days;
	}
	
	/**
	* 获取 外请人数(同旧表).
	*
	* @return 外请人数(同旧表).
	*/
	public String getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	* 设置 外请人数(同旧表).
	*
	* @param 外请人数(同旧表).
	*/
	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
	/**
	* 获取 人均费用.
	*
	* @return 人均费用.
	*/
	public String getPerCost() {
		return perCost;
	}

	/**
	* 设置 人均费用.
	*
	* @param 人均费用.
	*/
	public void setPerCost(String perCost) {
		this.perCost = perCost;
	}
	
	/**
	* 获取 预算总费用.
	*
	* @return 预算总费用.
	*/
	public String getTotalCost() {
		return totalCost;
	}

	/**
	* 设置 预算总费用.
	*
	* @param 预算总费用.
	*/
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	/**
	* 获取 计费方式(同旧表).
	*
	* @return 计费方式(同旧表).
	*/
	public String getBillingMethod() {
		return billingMethod;
	}

	/**
	* 设置 计费方式(同旧表).
	*
	* @param 计费方式(同旧表).
	*/
	public void setBillingMethod(String billingMethod) {
		this.billingMethod = billingMethod;
	}
	
	/**
	* 获取 计费方式编码.
	*
	* @return 计费方式编码.
	*/
	public String getBillingMethodCode() {
		return billingMethodCode;
	}

	/**
	* 设置 计费方式编码.
	*
	* @param 计费方式编码.
	*/
	public void setBillingMethodCode(String billingMethodCode) {
		this.billingMethodCode = billingMethodCode;
	}
	
	/**
	* 获取 工作流人员缺口(同旧表).
	*
	* @return 工作流人员缺口(同旧表).
	*/
	public String getPersonnelGap() {
		return personnelGap;
	}

	/**
	* 设置 工作流人员缺口(同旧表).
	*
	* @param 工作流人员缺口(同旧表).
	*/
	public void setPersonnelGap(String personnelGap) {
		this.personnelGap = personnelGap;
	}
	
	/**
	* 获取 外请类型编码.
	*
	* @return 外请类型编码.
	*/
	public String getTypeCode() {
		return typeCode;
	}

	/**
	* 设置 外请类型编码.
	*
	* @param 外请类型编码.
	*/
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	/**
	* 获取 其他计费(新业务不需要,仅迁移).
	*
	* @return 其他计费(新业务不需要,仅迁移).
	*/
	public String getBillingInstructions() {
		return billingInstructions;
	}

	/**
	* 设置 其他计费(新业务不需要,仅迁移).
	*
	* @param 其他计费(新业务不需要,仅迁移).
	*/
	public void setBillingInstructions(String billingInstructions) {
		this.billingInstructions = billingInstructions;
	}
	
	/**
	* 获取 增补员工作流号.
	*
	* @return 增补员工作流号.
	*/
	public String getWorkflowNo() {
		return workflowNo;
	}

	/**
	* 设置 增补员工作流号.
	*
	* @param 增补员工作流号.
	*/
	public void setWorkflowNo(String workflowNo) {
		this.workflowNo = workflowNo;
	}
	

}
