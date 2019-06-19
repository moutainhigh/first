package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 借章申请实体bean
 * @author lihai
 * @Date 2014-04-09 11:09:24
 */
 
public class BorrowSealApplyBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务单号 
	*/
	private String busino;
	
	/** 
	* 流程实例ID 
	*/
	private Long processinstid;
	
	/** 
	* 姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 工号 
	*/
	private String applyPersonId;
	
	/** 
	* 部门 
	*/
	private String dept;
	
	/** 
	* 所属区域(1：华东，2：广州，3：深圳，4：华中，5：华北) 
	*/
	private String area;
	
	/** 
	* 印章名称 
	*/
	private String sealName;
	
	/** 
	* 印章类型 
	*/
	private String sealType;
	
	/** 
	* 借阅天数 
	*/
	private String borrowDays;
	
	/** 
	* 借阅开始时间 
	*/
	private String startDate;
	
	/** 
	* 归还时间 
	*/
	private String returnDate;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 档案管理系统申请类型  
	*/
	private String amsApplyType;
	
	/** 
	* 档案管理系统工作流编号 
	*/
	private String amssn;
	
	/** 
	* 章所属部门 
	*/
	private String sealDept;
	
	/** 
	* （保管人） 
	*/
	private String sealTrustee;
	
	/** 
	* 印章类型，财务章：2，法务章：3 
	*/
	private String sealTypeCode;
	
	/** 
	* 带章去处 
	*/
	private String sealTaketo;
	
	/** 
	* 章简要说明(印章财务部)
	*/
	private String sealBrief;
	
	/** 
	* 借阅份数 
	*/
	private String sealBrrowCounts;
	
	/** 
	* 用章序号 
	*/
	private String sealSequenceCode;
	
	/** 
	* 全宗号 
	*/
	private String sealGeneralCode;
	
	/** 
	* 档号 
	*/
	private String sealArchivalCode;
	
	/** 
	* 印章编号 
	*/
	private String sealCode;
	
	/** 
	* 用章保管部门 
	*/
	private String sealAsaveDept;
	
	/** 
	* 是否有效 
	*/
	private String isseffective;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 预留字段1 
	*/
	private String sparefield1;
	
	/** 
	* 预留字段2 
	*/
	private String sparefield2;
	
	/** 
	* 预留字段3 
	*/
	private Long sparefield3;
	
	
	/**
	* 获取 业务单号.
	*
	* @return 业务单号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务单号.
	*
	* @param 业务单号.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例ID.
	*
	* @return 流程实例ID.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例ID.
	*
	* @param 流程实例ID.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 姓名.
	*
	* @return 姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 姓名.
	*
	* @param 姓名.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 工号.
	*
	* @return 工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 设置 工号.
	*
	* @param 工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 部门.
	*
	* @return 部门.
	*/
	public String getDept() {
		return dept;
	}

	/**
	* 设置 部门.
	*
	* @param 部门.
	*/
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	/**
	* 获取 所属区域(1：华东，2：广州，3：深圳，4：华中，5：华北).
	*
	* @return 所属区域(1：华东，2：广州，3：深圳，4：华中，5：华北).
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属区域(1：华东，2：广州，3：深圳，4：华中，5：华北).
	*
	* @param 所属区域(1：华东，2：广州，3：深圳，4：华中，5：华北).
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 印章名称.
	*
	* @return 印章名称.
	*/
	public String getSealName() {
		return sealName;
	}

	/**
	* 设置 印章名称.
	*
	* @param 印章名称.
	*/
	public void setSealName(String sealName) {
		this.sealName = sealName;
	}
	
	/**
	* 获取 印章类型.
	*
	* @return 印章类型.
	*/
	public String getSealType() {
		return sealType;
	}

	/**
	* 设置 印章类型.
	*
	* @param 印章类型.
	*/
	public void setSealType(String sealType) {
		this.sealType = sealType;
	}
	
	/**
	* 获取 借阅天数.
	*
	* @return 借阅天数.
	*/
	public String getBorrowDays() {
		return borrowDays;
	}

	/**
	* 设置 借阅天数.
	*
	* @param 借阅天数.
	*/
	public void setBorrowDays(String borrowDays) {
		this.borrowDays = borrowDays;
	}
	
	/**
	* 获取 借阅开始时间.
	*
	* @return 借阅开始时间.
	*/
	public String getStartDate() {
		return startDate;
	}

	/**
	* 设置 借阅开始时间.
	*
	* @param 借阅开始时间.
	*/
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	* 获取 归还时间.
	*
	* @return 归还时间.
	*/
	public String getReturnDate() {
		return returnDate;
	}

	/**
	* 设置 归还时间.
	*
	* @param 归还时间.
	*/
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
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
	* 获取 档案管理系统申请类型 .
	*
	* @return 档案管理系统申请类型 .
	*/
	public String getAmsApplyType() {
		return amsApplyType;
	}

	/**
	* 设置 档案管理系统申请类型 .
	*
	* @param 档案管理系统申请类型 .
	*/
	public void setAmsApplyType(String amsApplyType) {
		this.amsApplyType = amsApplyType;
	}
	
	/**
	* 获取 档案管理系统工作流编号.
	*
	* @return 档案管理系统工作流编号.
	*/
	public String getAmssn() {
		return amssn;
	}

	/**
	* 设置 档案管理系统工作流编号.
	*
	* @param 档案管理系统工作流编号.
	*/
	public void setAmssn(String amssn) {
		this.amssn = amssn;
	}
	
	/**
	* 获取 章所属部门.
	*
	* @return 章所属部门.
	*/
	public String getSealDept() {
		return sealDept;
	}

	/**
	* 设置 章所属部门.
	*
	* @param 章所属部门.
	*/
	public void setSealDept(String sealDept) {
		this.sealDept = sealDept;
	}
	
	/**
	* 获取 章类型编码.
	*
	* @return 章类型编码.
	*/
	public String getSealTrustee() {
		return sealTrustee;
	}

	/**
	* 设置 章类型编码.
	*
	* @param 章类型编码.
	*/
	public void setSealTrustee(String sealTrustee) {
		this.sealTrustee = sealTrustee;
	}
	
	/**
	* 获取 印章类型，财务章：2，法务章：3.
	*
	* @return 印章类型，财务章：2，法务章：3.
	*/
	public String getSealTypeCode() {
		return sealTypeCode;
	}

	/**
	* 设置 印章类型，财务章：2，法务章：3.
	*
	* @param 印章类型，财务章：2，法务章：3.
	*/
	public void setSealTypeCode(String sealTypeCode) {
		this.sealTypeCode = sealTypeCode;
	}
	
	/**
	* 获取 带章去处.
	*
	* @return 带章去处.
	*/
	public String getSealTaketo() {
		return sealTaketo;
	}

	/**
	* 设置 带章去处.
	*
	* @param 带章去处.
	*/
	public void setSealTaketo(String sealTaketo) {
		this.sealTaketo = sealTaketo;
	}
	
	/**
	* 获取 章简要说明.
	*
	* @return 章简要说明.
	*/
	public String getSealBrief() {
		return sealBrief;
	}

	/**
	* 设置 章简要说明.
	*
	* @param 章简要说明.
	*/
	public void setSealBrief(String sealBrief) {
		this.sealBrief = sealBrief;
	}
	
	/**
	* 获取 借阅份数.
	*
	* @return 借阅份数.
	*/
	public String getSealBrrowCounts() {
		return sealBrrowCounts;
	}

	/**
	* 设置 借阅份数.
	*
	* @param 借阅份数.
	*/
	public void setSealBrrowCounts(String sealBrrowCounts) {
		this.sealBrrowCounts = sealBrrowCounts;
	}
	
	/**
	* 获取 用章序号.
	*
	* @return 用章序号.
	*/
	public String getSealSequenceCode() {
		return sealSequenceCode;
	}

	/**
	* 设置 用章序号.
	*
	* @param 用章序号.
	*/
	public void setSealSequenceCode(String sealSequenceCode) {
		this.sealSequenceCode = sealSequenceCode;
	}
	
	/**
	* 获取 全宗号.
	*
	* @return 全宗号.
	*/
	public String getSealGeneralCode() {
		return sealGeneralCode;
	}

	/**
	* 设置 全宗号.
	*
	* @param 全宗号.
	*/
	public void setSealGeneralCode(String sealGeneralCode) {
		this.sealGeneralCode = sealGeneralCode;
	}
	
	/**
	* 获取 档号.
	*
	* @return 档号.
	*/
	public String getSealArchivalCode() {
		return sealArchivalCode;
	}

	/**
	* 设置 档号.
	*
	* @param 档号.
	*/
	public void setSealArchivalCode(String sealArchivalCode) {
		this.sealArchivalCode = sealArchivalCode;
	}
	
	/**
	* 获取 印章编号.
	*
	* @return 印章编号.
	*/
	public String getSealCode() {
		return sealCode;
	}

	/**
	* 设置 印章编号.
	*
	* @param 印章编号.
	*/
	public void setSealCode(String sealCode) {
		this.sealCode = sealCode;
	}
	
	/**
	* 获取 用章保管部门.
	*
	* @return 用章保管部门.
	*/
	public String getSealAsaveDept() {
		return sealAsaveDept;
	}

	/**
	* 设置 用章保管部门.
	*
	* @param 用章保管部门.
	*/
	public void setSealAsaveDept(String sealAsaveDept) {
		this.sealAsaveDept = sealAsaveDept;
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
	* 获取 预留字段1.
	*
	* @return 预留字段1.
	*/
	public String getSparefield1() {
		return sparefield1;
	}

	/**
	* 设置 预留字段1.
	*
	* @param 预留字段1.
	*/
	public void setSparefield1(String sparefield1) {
		this.sparefield1 = sparefield1;
	}
	
	/**
	* 获取 预留字段2.
	*
	* @return 预留字段2.
	*/
	public String getSparefield2() {
		return sparefield2;
	}

	/**
	* 设置 预留字段2.
	*
	* @param 预留字段2.
	*/
	public void setSparefield2(String sparefield2) {
		this.sparefield2 = sparefield2;
	}
	
	/**
	* 获取 预留字段3.
	*
	* @return 预留字段3.
	*/
	public Long getSparefield3() {
		return sparefield3;
	}

	/**
	* 设置 预留字段3.
	*
	* @param 预留字段3.
	*/
	public void setSparefield3(Long sparefield3) {
		this.sparefield3 = sparefield3;
	}
	

}
