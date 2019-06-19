package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 实体合同借阅申请实体Bean
 * @author meng tianxiang
 * @Date 2014-04-08 08:47:01
 */
 
public class RealContractBorrowBean extends Entity {
	
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
	* 所属区域(旧表字段转义) 
	*/
	private String area;
	
	/** 
	* 合同编号(同旧表) 
	*/
	private String contractNum;
	
	/** 
	* 合同类别(同旧表) 
	*/
	private String contractType;
	
	/** 
	* 借阅天数(同旧表) 
	*/
	private String borrowDays;
	
	/** 
	* 开始时间(同旧表) 
	*/
	private String startDate;
	
	/** 
	* 结束时间(同旧表) 
	*/
	private String endDate;
	
	/** 
	* 合同密级（1：普通，2：机密，3：绝密） 
	*/
	private String contractDense;
	
	/** 
	* 签订部门(同旧表) 
	*/
	private String signDepartment;
	
	/** 
	* 客户名称(同旧表) 
	*/
	private String customerName;
	
	/** 
	* 档案管理系统工作流编号(同旧表仅迁移) 
	*/
	private String amssn;
	
	/** 
	* 档案管理系统申请类型(同旧表仅迁移) 
	*/
	private String amsApplyType;
	
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
	* 获取 所属区域(旧表字段转义).
	*
	* @return 所属区域(旧表字段转义).
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属区域(旧表字段转义).
	*
	* @param 所属区域(旧表字段转义).
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 合同编号(同旧表).
	*
	* @return 合同编号(同旧表).
	*/
	public String getContractNum() {
		return contractNum;
	}

	/**
	* 设置 合同编号(同旧表).
	*
	* @param 合同编号(同旧表).
	*/
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	
	/**
	* 获取 合同类别(同旧表).
	*
	* @return 合同类别(同旧表).
	*/
	public String getContractType() {
		return contractType;
	}

	/**
	* 设置 合同类别(同旧表).
	*
	* @param 合同类别(同旧表).
	*/
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	/**
	* 获取 借阅天数(同旧表).
	*
	* @return 借阅天数(同旧表).
	*/
	public String getBorrowDays() {
		return borrowDays;
	}

	/**
	* 设置 借阅天数(同旧表).
	*
	* @param 借阅天数(同旧表).
	*/
	public void setBorrowDays(String borrowDays) {
		this.borrowDays = borrowDays;
	}
	
	/**
	* 获取 开始时间(同旧表).
	*
	* @return 开始时间(同旧表).
	*/
	public String getStartDate() {
		return startDate;
	}

	/**
	* 设置 开始时间(同旧表).
	*
	* @param 开始时间(同旧表).
	*/
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	* 获取 结束时间(同旧表).
	*
	* @return 结束时间(同旧表).
	*/
	public String getEndDate() {
		return endDate;
	}

	/**
	* 设置 结束时间(同旧表).
	*
	* @param 结束时间(同旧表).
	*/
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	* 获取 合同密级（1：普通，2：机密，3：绝密）.
	*
	* @return 合同密级（1：普通，2：机密，3：绝密）.
	*/
	public String getContractDense() {
		return contractDense;
	}

	/**
	* 设置 合同密级（1：普通，2：机密，3：绝密）.
	*
	* @param 合同密级（1：普通，2：机密，3：绝密）.
	*/
	public void setContractDense(String contractDense) {
		this.contractDense = contractDense;
	}
	
	/**
	* 获取 签订部门(同旧表).
	*
	* @return 签订部门(同旧表).
	*/
	public String getSignDepartment() {
		return signDepartment;
	}

	/**
	* 设置 签订部门(同旧表).
	*
	* @param 签订部门(同旧表).
	*/
	public void setSignDepartment(String signDepartment) {
		this.signDepartment = signDepartment;
	}
	
	/**
	* 获取 客户名称(同旧表).
	*
	* @return 客户名称(同旧表).
	*/
	public String getCustomerName() {
		return customerName;
	}

	/**
	* 设置 客户名称(同旧表).
	*
	* @param 客户名称(同旧表).
	*/
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	* 获取 档案管理系统工作流编号(同旧表仅迁移).
	*
	* @return 档案管理系统工作流编号(同旧表仅迁移).
	*/
	public String getAmssn() {
		return amssn;
	}

	/**
	* 设置 档案管理系统工作流编号(同旧表仅迁移).
	*
	* @param 档案管理系统工作流编号(同旧表仅迁移).
	*/
	public void setAmssn(String amssn) {
		this.amssn = amssn;
	}
	
	/**
	* 获取 档案管理系统申请类型(同旧表仅迁移).
	*
	* @return 档案管理系统申请类型(同旧表仅迁移).
	*/
	public String getAmsApplyType() {
		return amsApplyType;
	}

	/**
	* 设置 档案管理系统申请类型(同旧表仅迁移).
	*
	* @param 档案管理系统申请类型(同旧表仅迁移).
	*/
	public void setAmsApplyType(String amsApplyType) {
		this.amsApplyType = amsApplyType;
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
	

}
