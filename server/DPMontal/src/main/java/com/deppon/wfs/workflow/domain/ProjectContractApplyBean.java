package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目类合同申请Bean
 * @author Work Flow System
 * @Date 2014-01-15 16:32:13
 */
 
public class ProjectContractApplyBean implements Serializable {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编号 
	*/
	private String busino;
	
	/** 
	* 工作流号 
	*/
	private Long processinstid;
	
	/** 
	* 是否PMO跟踪项目 
	*/
	private String isPmcProject;
	
	/** 
	* 经办部门 
	*/
	private String chargeIndDept;
	
	/** 
	* 起草人 
	*/
	private String applyPersonName;
	
	/** 
	* 起草人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 是否框架合同 
	*/
	private String isFrameContract;
	
	/** 
	* 所属事业部 
	*/
	private String subOrdInateDept;
	
	/** 
	* 所属财务部 
	*/
	private String financeDept;
	
	/** 
	* 签订类型 
	*/
	private String signType;
	
	/** 
	* 合同类型 
	*/
	private String contractType;
	
	/** 
	* 原合同编号 
	*/
	private String originalContractNo;
	
	/** 
	* 合同名称 
	*/
	private String contractName;
	
	/** 
	* 合同金额 
	*/
	private String contractAmount;
	
	/** 
	* 签约对方单位 
	*/
	private String signingEachOtherUnit;
	
	/** 
	* 签约我方单位 
	*/
	private String signingOurUnit;
	
	/** 
	* 合同开始日期 
	*/
	private Date contractStarttime;
	
	/** 
	* 合同结束日期 
	*/
	private Date contractEndtime;
	
	/** 
	* 优先盖章方 
	*/
	private String seal;
	
	/** 
	* 申请事由 
	*/
	private String reason;
	/**
	 * 是否会签
	 */
	private String isCountersign;
	/**
	 * 会签部门
	 */
	private String countersignDept;
	/**
	 * 会签部门标杆编码
	 */
	private String countersignDeptCode;
	
	/** 
	* 1：有效  0：无效 
	*/
	private String isSeffective;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 备用字段 
	*/
	private String spareField1;
	
	/** 
	* 备用字段 
	*/
	private String spareField2;
	
	
	/**
	* 获取 业务编号.
	*
	* @return 业务编号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务编号.
	*
	* @param 业务编号.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	public String getIsCountersign() {
		return isCountersign;
	}

	public void setIsCountersign(String isCountersign) {
		this.isCountersign = isCountersign;
	}

	public String getCountersignDept() {
		return countersignDept;
	}

	public void setCountersignDept(String countersignDept) {
		this.countersignDept = countersignDept;
	}

	public String getCountersignDeptCode() {
		return countersignDeptCode;
	}

	public void setCountersignDeptCode(String countersignDeptCode) {
		this.countersignDeptCode = countersignDeptCode;
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
	* 获取 是否PMO跟踪项目.
	*
	* @return 是否PMO跟踪项目.
	*/
	public String getIsPmcProject() {
		return isPmcProject;
	}

	/**
	* 设置 是否PMO跟踪项目.
	*
	* @param 是否PMO跟踪项目.
	*/
	public void setIsPmcProject(String isPmcProject) {
		this.isPmcProject = isPmcProject;
	}
	
	/**
	* 获取 经办部门.
	*
	* @return 经办部门.
	*/
	public String getChargeIndDept() {
		return chargeIndDept;
	}

	/**
	* 设置 经办部门.
	*
	* @param 经办部门.
	*/
	public void setChargeIndDept(String chargeIndDept) {
		this.chargeIndDept = chargeIndDept;
	}
	
	/**
	* 获取 起草人.
	*
	* @return 起草人.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 起草人.
	*
	* @param 起草人.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 起草人工号.
	*
	* @return 起草人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 设置 起草人工号.
	*
	* @param 起草人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 是否框架合同.
	*
	* @return 是否框架合同.
	*/
	public String getIsFrameContract() {
		return isFrameContract;
	}

	/**
	* 设置 是否框架合同.
	*
	* @param 是否框架合同.
	*/
	public void setIsFrameContract(String isFrameContract) {
		this.isFrameContract = isFrameContract;
	}
	
	/**
	* 获取 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getSubOrdInateDept() {
		return subOrdInateDept;
	}

	/**
	* 设置 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setSubOrdInateDept(String subOrdInateDept) {
		this.subOrdInateDept = subOrdInateDept;
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
	* 获取 签订类型.
	*
	* @return 签订类型.
	*/
	public String getSignType() {
		return signType;
	}

	/**
	* 设置 签订类型.
	*
	* @param 签订类型.
	*/
	public void setSignType(String signType) {
		this.signType = signType;
	}
	
	/**
	* 获取 合同类型.
	*
	* @return 合同类型.
	*/
	public String getContractType() {
		return contractType;
	}

	/**
	* 设置 合同类型.
	*
	* @param 合同类型.
	*/
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	/**
	* 获取 原合同编号.
	*
	* @return 原合同编号.
	*/
	public String getOriginalContractNo() {
		return originalContractNo;
	}

	/**
	* 设置 原合同编号.
	*
	* @param 原合同编号.
	*/
	public void setOriginalContractNo(String originalContractNo) {
		this.originalContractNo = originalContractNo;
	}
	
	/**
	* 获取 合同名称.
	*
	* @return 合同名称.
	*/
	public String getContractName() {
		return contractName;
	}

	/**
	* 设置 合同名称.
	*
	* @param 合同名称.
	*/
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	
	/**
	* 获取 合同金额.
	*
	* @return 合同金额.
	*/
	public String getContractAmount() {
		return contractAmount;
	}

	/**
	* 设置 合同金额.
	*
	* @param 合同金额.
	*/
	public void setContractAmount(String contractAmount) {
		this.contractAmount = contractAmount;
	}
	
	/**
	* 获取 签约对方单位.
	*
	* @return 签约对方单位.
	*/
	public String getSigningEachOtherUnit() {
		return signingEachOtherUnit;
	}

	/**
	* 设置 签约对方单位.
	*
	* @param 签约对方单位.
	*/
	public void setSigningEachOtherUnit(String signingEachOtherUnit) {
		this.signingEachOtherUnit = signingEachOtherUnit;
	}
	
	/**
	* 获取 签约我方单位.
	*
	* @return 签约我方单位.
	*/
	public String getSigningOurUnit() {
		return signingOurUnit;
	}

	/**
	* 设置 签约我方单位.
	*
	* @param 签约我方单位.
	*/
	public void setSigningOurUnit(String signingOurUnit) {
		this.signingOurUnit = signingOurUnit;
	}
	
	/**
	* 获取 合同开始日期.
	*
	* @return 合同开始日期.
	*/
	public Date getContractStarttime() {
		return contractStarttime;
	}

	/**
	* 设置 合同开始日期.
	*
	* @param 合同开始日期.
	*/
	public void setContractStarttime(Date contractStarttime) {
		this.contractStarttime = contractStarttime;
	}
	
	/**
	* 获取 合同结束日期.
	*
	* @return 合同结束日期.
	*/
	public Date getContractEndtime() {
		return contractEndtime;
	}

	/**
	* 设置 合同结束日期.
	*
	* @param 合同结束日期.
	*/
	public void setContractEndtime(Date contractEndtime) {
		this.contractEndtime = contractEndtime;
	}
	
	/**
	* 获取 优先盖章方.
	*
	* @return 优先盖章方.
	*/
	public String getSeal() {
		return seal;
	}

	/**
	* 设置 优先盖章方.
	*
	* @param 优先盖章方.
	*/
	public void setSeal(String seal) {
		this.seal = seal;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getReason() {
		return reason;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	* 获取 1：有效  0：无效.
	*
	* @return 1：有效  0：无效.
	*/
	public String getIsSeffective() {
		return isSeffective;
	}

	/**
	* 设置 1：有效  0：无效.
	*
	* @param 1：有效  0：无效.
	*/
	public void setIsSeffective(String isSeffective) {
		this.isSeffective = isSeffective;
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
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField1(String spareField1) {
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
	

}
