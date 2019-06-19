package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 财务档案借阅申请Bean
 * @author 高孟冉
 * @Date 2013-10-23 11:02:01
 */
public class ArchivesLendingApplyBean implements Serializable {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 流程序号，主键 
	*/
	private String busino;
	
	/** 
	* 流程实例ID 
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
	* 部门 
	*/
	private String department;
	
	/** 
	* 职位 
	*/
	private String position;
	
	/** 
	* 电子邮箱 
	*/
	private String email;
	
	/** 
	* 手机号码 
	*/
	private Long telphone;
	
	/** 
	* 档案所属财务部 
	*/
	private String financialDepartment;
	
	/** 
	* 档案所属财务部编码 
	*/
	private String financialDepartmentCode;
	
	/** 
	* 档案所属子公司 
	*/
	private String subCorporation;
	
	/** 
	* 档案所属子公司编码 
	*/
	private String subCorporationCode;
	
	/** 
	* 借阅性质 
	*/
	private String lendingNature;
	
	/** 
	* 借阅地点 
	*/
	private String lendingPlace;
	
	/** 
	* 档案分类 
	*/
	private String financialCategory;
	
	/** 
	* 借阅时间 
	*/
	private Date lendingTime;
	
	/** 
	* 归还时间 
	*/
	private Date returnTime;
	
	/** 
	* 档案类型 
	*/
	private String financialType;
	
	/** 
	* 档案明细 
	*/
	private String financialDetail;
	
	/** 
	* 借阅工作流编号 
	*/
	private Long lendingWorkflowNumber;
	
	/** 
	* 是否打印 
	*/
	private String isPrint;
	
	/** 
	* 申请事由 
	*/
	private String applyReasons;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务状态 
	*/
	private Long isseffective;
	
	/** 
	* 备用字段1 
	*/
	private String spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 数字字段（扩展） 
	*/
	private Long subnumber;
	
	
	/**
	* 获取 流程序号，主键.
	*
	* @return 流程序号，主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 流程序号，主键.
	*
	* @param 流程序号，主键.
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
	* 获取 部门.
	*
	* @return 部门.
	*/
	public String getDepartment() {
		return department;
	}

	/**
	* 设置 部门.
	*
	* @param 部门.
	*/
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	* 获取 职位.
	*
	* @return 职位.
	*/
	public String getPosition() {
		return position;
	}

	/**
	* 设置 职位.
	*
	* @param 职位.
	*/
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	* 获取 电子邮箱.
	*
	* @return 电子邮箱.
	*/
	public String getEmail() {
		return email;
	}

	/**
	* 设置 电子邮箱.
	*
	* @param 电子邮箱.
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	* 获取 手机号码.
	*
	* @return 手机号码.
	*/
	public Long getTelphone() {
		return telphone;
	}

	/**
	* 设置 手机号码.
	*
	* @param 手机号码.
	*/
	public void setTelphone(Long telphone) {
		this.telphone = telphone;
	}
	
	/**
	* 获取 档案所属财务部.
	*
	* @return 档案所属财务部.
	*/
	public String getFinancialDepartment() {
		return financialDepartment;
	}

	/**
	* 设置 档案所属财务部.
	*
	* @param 档案所属财务部.
	*/
	public void setFinancialDepartment(String financialDepartment) {
		this.financialDepartment = financialDepartment;
	}
	
	/**
	* 获取 档案所属财务部编码.
	*
	* @return 档案所属财务部编码.
	*/
	public String getFinancialDepartmentCode() {
		return financialDepartmentCode;
	}

	/**
	* 设置 档案所属财务部编码.
	*
	* @param 档案所属财务部编码.
	*/
	public void setFinancialDepartmentCode(String financialDepartmentCode) {
		this.financialDepartmentCode = financialDepartmentCode;
	}
	
	/**
	* 获取 档案所属子公司.
	*
	* @return 档案所属子公司.
	*/
	public String getSubCorporation() {
		return subCorporation;
	}

	/**
	* 设置 档案所属子公司.
	*
	* @param 档案所属子公司.
	*/
	public void setSubCorporation(String subCorporation) {
		this.subCorporation = subCorporation;
	}
	
	/**
	* 获取 档案所属子公司编码.
	*
	* @return 档案所属子公司编码.
	*/
	public String getSubCorporationCode() {
		return subCorporationCode;
	}
	
	/**
	* 设置 档案所属子公司编码.
	*
	* @param 档案所属子公司编码.
	*/
	public void setSubCorporationCode(String subCorporationCode) {
		this.subCorporationCode = subCorporationCode;
	}
	
	/**
	* 获取 借阅性质.
	*
	* @return 借阅性质.
	*/
	public String getLendingNature() {
		return lendingNature;
	}

	/**
	* 设置 借阅性质.
	*
	* @param 借阅性质.
	*/
	public void setLendingNature(String lendingNature) {
		this.lendingNature = lendingNature;
	}
	
	/**
	* 获取 档案分类.
	*
	* @return 档案分类.
	*/
	public String getFinancialCategory() {
		return financialCategory;
	}

	/**
	* 设置 档案分类.
	*
	* @param 档案分类.
	*/
	public void setFinancialCategory(String financialCategory) {
		this.financialCategory = financialCategory;
	}
	
	/**
	* 获取 借阅时间.
	*
	* @return 借阅时间.
	*/
	public Date getLendingTime() {
		return lendingTime;
	}

	/**
	* 设置 借阅时间.
	*
	* @param 借阅时间.
	*/
	public void setLendingTime(Date lendingTime) {
		this.lendingTime = lendingTime;
	}
	
	/**
	* 获取 归还时间.
	*
	* @return 归还时间.
	*/
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	* 设置 归还时间.
	*
	* @param 归还时间.
	*/
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	
	/**
	* 获取 档案类型.
	*
	* @return 档案类型.
	*/
	public String getFinancialType() {
		return financialType;
	}

	/**
	* 设置 档案类型.
	*
	* @param 档案类型.
	*/
	public void setFinancialType(String financialType) {
		this.financialType = financialType;
	}
	
	/**
	* 获取 档案明细.
	*
	* @return 档案明细.
	*/
	public String getFinancialDetail() {
		return financialDetail;
	}

	/**
	* 设置 档案明细.
	*
	* @param 档案明细.
	*/
	public void setFinancialDetail(String financialDetail) {
		this.financialDetail = financialDetail;
	}
	
	/**
	* 获取 借阅工作流编号.
	*
	* @return 借阅工作流编号.
	*/
	public Long getLendingWorkflowNumber() {
		return lendingWorkflowNumber;
	}

	/**
	* 设置 借阅工作流编号.
	*
	* @param 借阅工作流编号.
	*/
	public void setLendingWorkflowNumber(Long lendingWorkflowNumber) {
		this.lendingWorkflowNumber = lendingWorkflowNumber;
	}
	
	/**
	* 获取 是否打印.
	*
	* @return 是否打印.
	*/
	public String getIsPrint() {
		return isPrint;
	}

	/**
	* 设置 是否打印.
	*
	* @param 是否打印.
	*/
	public void setIsPrint(String isPrint) {
		this.isPrint = isPrint;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReasons() {
		return applyReasons;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setApplyReasons(String applyReasons) {
		this.applyReasons = applyReasons;
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
	* 获取 业务状态.
	*
	* @return 业务状态.
	*/
	public Long getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务状态.
	*
	* @param 业务状态.
	*/
	public void setIsseffective(Long isseffective) {
		this.isseffective = isseffective;
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
	* 获取 数字字段（扩展）.
	*
	* @return 数字字段（扩展）.
	*/
	public Long getSubnumber() {
		return subnumber;
	}

	/**
	* 设置 数字字段（扩展）.
	*
	* @param 数字字段（扩展）.
	*/
	public void setSubnumber(Long subnumber) {
		this.subnumber = subnumber;
	}
	
	/**
	* 获取 借阅地点
	*
	* @return 借阅地点.
	*/
	public String getLendingPlace() {
		return lendingPlace;
	}

	/**
	* 设置 借阅地点
	*
	* @param  借阅地点.
	*/
	public void setLendingPlace(String lendingPlace) {
		this.lendingPlace = lendingPlace;
	}
}
