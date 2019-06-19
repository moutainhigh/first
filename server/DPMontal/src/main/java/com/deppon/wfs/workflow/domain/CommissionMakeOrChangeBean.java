package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 营运提成单项奖设立于调整业务实体bean
 * @author guanbo
 * @Date 2014-03-25 14:18:49
 */
 
public class CommissionMakeOrChangeBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务表主键 
	*/
	private String busino;
	
	/** 
	* 流程实例号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 部门名称 
	*/
	private String dept;
	
	/** 
	* 部门标杆编码 
	*/
	private String deptCode;
	
	/** 
	* 经营本部，业务字典WFS_HEADQUARTERS 
	*/
	private String operationDepartment;
	
	/** 
	* 申请类别，业务字典WFS_APPLYTYPE_COMMOSSIONMAKERORCHANGE 
	*/
	private String applyType;
	
	/** 
	* 是否涉及薪资调整，业务字典 WFS_RELATE_SALARY
	*/
	private String relateSalary;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 业务数据修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务数据创建时间 
	*/
	private Date createTime;
	
	/** 
	* 业务数据使用状态，1表示使用，0表示逻辑删除 
	*/
	private String isseffective;
	
	/** 
	* 备用字段1 
	*/
	private Long spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 备用字段3 
	*/
	private String spareField3;
	
	/** 
	* 相关业务部门名称 
	*/
	private String relateBusinessDept;
	
	/** 
	* 相关业务部门标杆编码 
	*/
	private String relateBusinessDeptCode;
	
	
	/**
	* 获取 业务表主键.
	*
	* @return 业务表主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务表主键.
	*
	* @param 业务表主键.
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
	* 获取 部门名称.
	*
	* @return 部门名称.
	*/
	public String getDept() {
		return dept;
	}

	/**
	* 设置 部门名称.
	*
	* @param 部门名称.
	*/
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	/**
	* 获取 部门标杆编码.
	*
	* @return 部门标杆编码.
	*/
	public String getDeptCode() {
		return deptCode;
	}

	/**
	* 设置 部门标杆编码.
	*
	* @param 部门标杆编码.
	*/
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	/**
	* 获取 经营本部，业务字典WFS_HEADQUARTERS.
	*
	* @return 经营本部，业务字典WFS_HEADQUARTERS.
	*/
	public String getOperationDepartment() {
		return operationDepartment;
	}

	/**
	* 设置 经营本部，业务字典WFS_HEADQUARTERS.
	*
	* @param 经营本部，业务字典WFS_HEADQUARTERS.
	*/
	public void setOperationDepartment(String operationDepartment) {
		this.operationDepartment = operationDepartment;
	}
	
	/**
	* 获取 申请类别，业务字典WFS_APPLYTYPE_COMMOSSIONMAKERORCHANGE.
	*
	* @return 申请类别，业务字典WFS_APPLYTYPE_COMMOSSIONMAKERORCHANGE.
	*/
	public String getApplyType() {
		return applyType;
	}

	/**
	* 设置 申请类别，业务字典WFS_APPLYTYPE_COMMOSSIONMAKERORCHANGE.
	*
	* @param 申请类别，业务字典WFS_APPLYTYPE_COMMOSSIONMAKERORCHANGE.
	*/
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	
	/**
	* 获取 是否涉及薪资调整.
	*
	* @return 是否涉及薪资调整.
	*/
	public String getRelateSalary() {
		return relateSalary;
	}

	/**
	* 设置 是否涉及薪资调整.
	*
	* @param 是否涉及薪资调整.
	*/
	public void setRelateSalary(String relateSalary) {
		this.relateSalary = relateSalary;
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
	* 获取 业务数据修改时间.
	*
	* @return 业务数据修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 设置 业务数据修改时间.
	*
	* @param 业务数据修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获取 业务数据创建时间.
	*
	* @return 业务数据创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 设置 业务数据创建时间.
	*
	* @param 业务数据创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 业务数据使用状态，1表示使用，0表示逻辑删除.
	*
	* @return 业务数据使用状态，1表示使用，0表示逻辑删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务数据使用状态，1表示使用，0表示逻辑删除.
	*
	* @param 业务数据使用状态，1表示使用，0表示逻辑删除.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(Long spareField1) {
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
	public String getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
	
	/**
	* 获取 相关业务部门名称.
	*
	* @return 相关业务部门名称.
	*/
	public String getRelateBusinessDept() {
		return relateBusinessDept;
	}

	/**
	* 设置 相关业务部门名称.
	*
	* @param 相关业务部门名称.
	*/
	public void setRelateBusinessDept(String relateBusinessDept) {
		this.relateBusinessDept = relateBusinessDept;
	}
	
	/**
	* 获取 相关业务部门标杆编码.
	*
	* @return 相关业务部门标杆编码.
	*/
	public String getRelateBusinessDeptCode() {
		return relateBusinessDeptCode;
	}

	/**
	* 设置 相关业务部门标杆编码.
	*
	* @param 相关业务部门标杆编码.
	*/
	public void setRelateBusinessDeptCode(String relateBusinessDeptCode) {
		this.relateBusinessDeptCode = relateBusinessDeptCode;
	}
	

}
