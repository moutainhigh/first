package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 薪酬福利发放申请实体Bean
 * @author 关波
 * @Date 2014-05-29 22:02:10
 */
 
public class WelfarePaymentBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务 编号 
	*/
	private String busino;
	
	/** 
	* 流程实例号 
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
	private String userDept;
	
	/** 
	* 申请时间 
	*/
	private String applyDate;
	
	/** 
	* 申请发放薪资年份 
	*/
	private String earningsYear;
	
	/** 
	* 申请发放薪资月份 
	*/
	private String earningsMonth;
	
	/** 
	* 申请发放工资类型 
	*/
	private String wagesType;
	
	/**
	 * 申请发放工资类型名称
	 */
	private String wagesTypeName;
	
	/** 
	* 申请发放总笔数 
	*/
	private BigDecimal totalFrequency;
	
	/** 
	* 申请发放总金额 
	*/
	private String applyAmount;
	
	/** 
	* 基本工资合计金额 
	*/
	private String basicWagesAmount;
	
	/** 
	* 业务费合计金额 
	*/
	private String operationCostAmount;
	
	/** 
	* 亲情扣款合计金额 
	*/
	private String familyDeductionAmount;
	
	/** 
	* 代还个人借款合计金额 
	*/
	private String personalLoanAmount;
	
	/** 
	* 人均工资水平 
	*/
	private String wageLevel;
	
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
	* 业务数据状态，1代表正在用，0代表逻辑删除 
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
	* 获取 业务 编号.
	*
	* @return 业务 编号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置业务 编号.
	*
	* @param 业务 编号.
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
	* 设置流程实例号.
	*
	* @param 流程实例号.
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
	* 设置申请人姓名.
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
	* 设置申请人工号.
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
	public String getUserDept() {
		return userDept;
	}

	/**
	* 设置申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	
	/**
	* 获取 申请时间.
	*
	* @return 申请时间.
	*/
	public String getApplyDate() {
		return applyDate;
	}

	/**
	* 设置申请时间.
	*
	* @param 申请时间.
	*/
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	
	/**
	* 获取 申请发放薪资年份.
	*
	* @return 申请发放薪资年份.
	*/
	public String getEarningsYear() {
		if (earningsYear == null) {
			earningsYear = "";
		}
		return earningsYear;
	}

	/**
	* 设置申请发放薪资年份.
	*
	* @param 申请发放薪资年份.
	*/
	public void setEarningsYear(String earningsYear) {
		this.earningsYear = earningsYear;
	}
	
	/**
	* 获取 申请发放薪资月份.
	*
	* @return 申请发放薪资月份.
	*/
	public String getEarningsMonth() {
		if (earningsMonth == null) {
			earningsMonth = "";
		}
		return earningsMonth;
	}

	/**
	* 设置申请发放薪资月份.
	*
	* @param 申请发放薪资月份.
	*/
	public void setEarningsMonth(String earningsMonth) {
		this.earningsMonth = earningsMonth;
	}
	
	/**
	* 获取 申请发放工资类型.
	*
	* @return 申请发放工资类型.
	*/
	public String getWagesType() {
		return wagesType;
	}
	
	public String getWagesTypeName() {
		if (wagesTypeName == null) {
			wagesTypeName = "";
		}
		return wagesTypeName;
	}

	public void setWagesTypeName(String wagesTypeName) {
		this.wagesTypeName = wagesTypeName;
	}

	/**
	* 设置申请发放工资类型.
	*
	* @param 申请发放工资类型.
	*/
	public void setWagesType(String wagesType) {
		this.wagesType = wagesType;
		this.wagesTypeName = this.wagesType;
	}
	
	/**
	* 获取 申请发放总笔数.
	*
	* @return 申请发放总笔数.
	*/
	public BigDecimal getTotalFrequency() {
		return totalFrequency;
	}
	public String getTotalFrequencyStr() {
		if (totalFrequency == null) {
			return "";
		}
		return "" + totalFrequency;
	}
	/**
	* 设置申请发放总笔数.
	*
	* @param 申请发放总笔数.
	*/
	public void setTotalFrequency(BigDecimal totalFrequency) {
		this.totalFrequency = totalFrequency;
	}
	
	/**
	* 获取 申请发放总金额.
	*
	* @return 申请发放总金额.
	*/
	public String getApplyAmount() {
		if (applyAmount == null) {
			applyAmount = "";
		}
		return applyAmount;
	}

	/**
	* 设置申请发放总金额.
	*
	* @param 申请发放总金额.
	*/
	public void setApplyAmount(String applyAmount) {
		this.applyAmount = applyAmount;
	}
	
	/**
	* 获取 基本工资合计金额.
	*
	* @return 基本工资合计金额.
	*/
	public String getBasicWagesAmount() {
		if (basicWagesAmount == null) {
			basicWagesAmount = "";
		}
		return basicWagesAmount;
	}

	/**
	* 设置基本工资合计金额.
	*
	* @param 基本工资合计金额.
	*/
	public void setBasicWagesAmount(String basicWagesAmount) {
		this.basicWagesAmount = basicWagesAmount;
	}
	
	/**
	* 获取 业务费合计金额.
	*
	* @return 业务费合计金额.
	*/
	public String getOperationCostAmount() {
		if (operationCostAmount == null) {
			operationCostAmount = "";
		}
		return operationCostAmount;
	}

	/**
	* 设置业务费合计金额.
	*
	* @param 业务费合计金额.
	*/
	public void setOperationCostAmount(String operationCostAmount) {
		this.operationCostAmount = operationCostAmount;
	}
	
	/**
	* 获取 亲情扣款合计金额.
	*
	* @return 亲情扣款合计金额.
	*/
	public String getFamilyDeductionAmount() {
		if (familyDeductionAmount == null) {
			familyDeductionAmount = "";
		}
		return familyDeductionAmount;
	}

	/**
	* 设置亲情扣款合计金额.
	*
	* @param 亲情扣款合计金额.
	*/
	public void setFamilyDeductionAmount(String familyDeductionAmount) {
		this.familyDeductionAmount = familyDeductionAmount;
	}
	
	/**
	* 获取 代还个人借款合计金额.
	*
	* @return 代还个人借款合计金额.
	*/
	public String getPersonalLoanAmount() {
		if (personalLoanAmount == null) {
			personalLoanAmount = "";
		}
		return personalLoanAmount;
	}

	/**
	* 设置代还个人借款合计金额.
	*
	* @param 代还个人借款合计金额.
	*/
	public void setPersonalLoanAmount(String personalLoanAmount) {
		this.personalLoanAmount = personalLoanAmount;
	}
	
	/**
	* 获取 人均工资水平.
	*
	* @return 人均工资水平.
	*/
	public String getWageLevel() {
		if (wageLevel == null) {
			wageLevel = "";
		}
		return wageLevel;
	}

	/**
	* 设置人均工资水平.
	*
	* @param 人均工资水平.
	*/
	public void setWageLevel(String wageLevel) {
		this.wageLevel = wageLevel;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReason() {
		if (applyReason == null) {
			applyReason = "";
		}
		return applyReason;
	}

	/**
	* 设置申请事由.
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
	* 设置业务数据修改时间.
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
	* 设置业务数据创建时间.
	*
	* @param 业务数据创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 业务数据状态，1代表正在用，0代表逻辑删除.
	*
	* @return 业务数据状态，1代表正在用，0代表逻辑删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置业务数据状态，1代表正在用，0代表逻辑删除.
	*
	* @param 业务数据状态，1代表正在用，0代表逻辑删除.
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
	* 设置备用字段.
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
	* 设置备用字段.
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
	* 设置备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
	

}
