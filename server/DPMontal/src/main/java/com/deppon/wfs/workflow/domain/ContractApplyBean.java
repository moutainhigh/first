package com.deppon.wfs.workflow.domain;


import java.util.Date;

/**
 * 合同签订申请Bean
 * @author wuguiping
 * @Date 2014-01-14 17:07:58
 */
 
public class ContractApplyBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编码 
	*/
	private String busino;
	
	/** 
	* 工作流号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人 
	*/
	private String applyPersonName;
	
	/** 
	* 工号 
	*/
	private String applyPersonId;
	
	/** 
	* 经办部门 
	*/
	private String chargeinDepartment;
	
	/** 
	* 是否框架合同 
	*/
	private String isFrameContract;
	
	/** 
	* 所属事业部 
	*/
	private String subordinateDepartment;
	
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
	private String originalContractNumbers;
	
	/** 
	* 物品名称 
	*/
	private String itemName;
	
	/** 
	* 单价 
	*/
	private String unitPrice;
	
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
	private Date contractStartTime;
	
	/** 
	* 合同结束日期 
	*/
	private Date contractEndTime;
	
	/** 
	* 优先盖章方 
	*/
	private String seal;
	
	/** 
	* 数量 
	*/
	private String quantity;
	
	/** 
	* 是否主要 
	*/
	private String isMain;
	
	/** 
	* 流程名称 
	*/
	private String processinstname;
	
	/**
	 * 是否需要会签
	 */
	private String isAllSign;
	
	/**
	 * 会签部门
	 */
	private String signDepartment;
	
	/** 
	* 申请事由 
	*/
	private String reason;
	
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
	* 获取 经办部门.
	*
	* @return 经办部门.
	*/
	public String getChargeinDepartment() {
		return chargeinDepartment;
	}

	/**
	* 设置 经办部门.
	*
	* @param 经办部门.
	*/
	public void setChargeinDepartment(String chargeinDepartment) {
		this.chargeinDepartment = chargeinDepartment;
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
	public String getSubordinateDepartment() {
		return subordinateDepartment;
	}

	/**
	* 设置 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setSubordinateDepartment(String subordinateDepartment) {
		this.subordinateDepartment = subordinateDepartment;
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
	public String getOriginalContractNumbers() {
		return originalContractNumbers;
	}

	/**
	* 设置 原合同编号.
	*
	* @param 原合同编号.
	*/
	public void setOriginalContractNumbers(String originalContractNumbers) {
		this.originalContractNumbers = originalContractNumbers;
	}
	
	/**
	* 获取 物品名称.
	*
	* @return 物品名称.
	*/
	public String getItemName() {
		return itemName;
	}

	/**
	* 设置 物品名称.
	*
	* @param 物品名称.
	*/
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	* 获取 单价.
	*
	* @return 单价.
	*/
	public String getUnitPrice() {
		return unitPrice;
	}

	/**
	* 设置 单价.
	*
	* @param 单价.
	*/
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
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
	public Date getContractStartTime() {
		return contractStartTime;
	}

	/**
	* 设置 合同开始日期.
	*
	* @param 合同开始日期.
	*/
	public void setContractStartTime(Date contractStartTime) {
		this.contractStartTime = contractStartTime;
	}
	
	/**
	* 获取 合同结束日期.
	*
	* @return 合同结束日期.
	*/
	public Date getContractEndTime() {
		return contractEndTime;
	}

	/**
	* 设置 合同结束日期.
	*
	* @param 合同结束日期.
	*/
	public void setContractEndTime(Date contractEndTime) {
		this.contractEndTime = contractEndTime;
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
	* 获取 数量.
	*
	* @return 数量.
	*/
	public String getQuantity() {
		return quantity;
	}

	/**
	* 设置 数量.
	*
	* @param 数量.
	*/
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/**
	* 获取 是否主要.
	*
	* @return 是否主要.
	*/
	public String getIsMain() {
		return isMain;
	}

	/**
	* 设置 是否主要.
	*
	* @param 是否主要.
	*/
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	
	/**
	* 获取 流程名称.
	*
	* @return 流程名称.
	*/
	public String getProcessinstname() {
		return processinstname;
	}

	/**
	* 设置 流程名称.
	*
	* @param 流程名称.
	*/
	public void setProcessinstname(String processinstname) {
		this.processinstname = processinstname;
	}
	
	/**
	* 获取 是否需要会签.
	*
	* @return 是否需要会签.
	*/
	public String getIsAllSign() {
		return isAllSign;
	}

	/**
	* 设置是否需要会签.
	*
	* @param 是否需要会签.
	*/
	public void setIsAllSign(String isAllSign) {
		this.isAllSign = isAllSign;
	}

	/**
	* 获取 会签部门.
	*
	* @return 会签部门.
	*/
	public String getSignDepartment() {
		return signDepartment;
	}
	
	/**
	* 设置会签部门.
	*
	* @param 会签部门.
	*/
	public void setSignDepartment(String signDepartment) {
		this.signDepartment = signDepartment;
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
	

}
