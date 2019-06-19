package com.deppon.wfs.workflow.domain;


import java.util.Date;
import java.util.List;


/**
 * 刻章申请实体
 * @author gaoyazhe
 * @Date 2014-06-07 15:11:34
 */
 
public class SealCarveApplyBean extends Entity {
	
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
	* 部门 
	*/
	private String deptName;
	
	/** 
	* 所属事业部 
	*/
	private String division;
	
	/** 
	* 所属事业部标杆编码 
	*/
	private String divisionSyscode;
	
	/** 
	* 所属公共事务组 
	*/
	private String affairsSection;
	
	/** 
	* 所属公共事务组标杆编码 
	*/
	private String affairsSectionSyscode;
	
	/** 
	* 印章类型 
	*/
	private String sealType;
	
	/** 
	* 印章类型 编码
	*/
	private String sealTypeCode;
	
	/** 
	* 所属财务部 
	*/
	private String financeDept;
	
	/** 
	* 所属财务部标杆编码 
	*/
	private String financeDeptSyscode;
	
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
	* 子表
	*/
	private List<SealCarveApplyDetailBean> sealCarveDetail;
	
	/** 
	* 所属子公司--迁移
	*/
	private String subcom;
	
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
	* 获取 部门.
	*
	* @return 部门.
	*/
	public String getDeptName() {
		return deptName;
	}

	/**
	* 设置 部门.
	*
	* @param 部门.
	*/
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	* 获取 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getDivision() {
		return division;
	}

	/**
	* 设置 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	* 获取 所属事业部标杆编码.
	*
	* @return 所属事业部标杆编码.
	*/
	public String getDivisionSyscode() {
		return divisionSyscode;
	}

	/**
	* 设置 所属事业部标杆编码.
	*
	* @param 所属事业部标杆编码.
	*/
	public void setDivisionSyscode(String divisionSyscode) {
		this.divisionSyscode = divisionSyscode;
	}
	
	/**
	* 获取 所属公共事务组.
	*
	* @return 所属公共事务组.
	*/
	public String getAffairsSection() {
		return affairsSection;
	}

	/**
	* 设置 所属公共事务组.
	*
	* @param 所属公共事务组.
	*/
	public void setAffairsSection(String affairsSection) {
		this.affairsSection = affairsSection;
	}
	
	/**
	* 获取 所属公共事务组标杆编码.
	*
	* @return 所属公共事务组标杆编码.
	*/
	public String getAffairsSectionSyscode() {
		return affairsSectionSyscode;
	}

	/**
	* 设置 所属公共事务组标杆编码.
	*
	* @param 所属公共事务组标杆编码.
	*/
	public void setAffairsSectionSyscode(String affairsSectionSyscode) {
		this.affairsSectionSyscode = affairsSectionSyscode;
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
	* 获取 所属财务部.
	*
	* @return 所属财务部.
	*/
	public String getFinanceDept() {
		return financeDept;
	}

	/**
	* 设置 所属财务部.
	*
	* @param 所属财务部.
	*/
	public void setFinanceDept(String financeDept) {
		this.financeDept = financeDept;
	}
	
	/**
	* 获取 所属财务部标杆编码.
	*
	* @return 所属财务部标杆编码.
	*/
	public String getFinanceDeptSyscode() {
		return financeDeptSyscode;
	}

	/**
	* 设置 所属财务部标杆编码.
	*
	* @param 所属财务部标杆编码.
	*/
	public void setFinanceDeptSyscode(String financeDeptSyscode) {
		this.financeDeptSyscode = financeDeptSyscode;
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
	* 获取 子表.
	*
	* @return 子表.
	*/
	public List<SealCarveApplyDetailBean> getSealCarveDetail() {
		return sealCarveDetail;
	}

	/**
	* 设置 子表.
	*
	* @param 子表.
	*/
	public void setSealCarveDetail(List<SealCarveApplyDetailBean> sealCarveDetail) {
		this.sealCarveDetail = sealCarveDetail;
	}

	/**
	* 获取 印章类型编码.
	*
	* @return 印章类型编码.
	*/
	public String getSealTypeCode() {
		return sealTypeCode;
	}

	/**
	* 设置 印章类型编码.
	*
	* @param 印章类型编码.
	*/
	public void setSealTypeCode(String sealTypeCode) {
		this.sealTypeCode = sealTypeCode;
	}

	/**
	* 获取 所属子公司--迁移.
	*
	* @return 所属子公司--迁移.
	*/
	public String getSubcom() {
		return subcom;
	}

	/**
	* 设置 所属子公司--迁移.
	*
	* @param 所属子公司--迁移.
	*/
	public void setSubcom(String subcom) {
		this.subcom = subcom;
	}

}
