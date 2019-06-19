package com.deppon.fssc.module.claimsupport.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;


/**
 *<pre>
 *功能:报账单明细公共Entity
 *作者：刘崇丛
 *日期：2013-3-25上午9:30:10
 *</pre>
 */
public class ClaimLineBaseEntity extends BaseEntity implements Serializable{
	
	//序列化
	private static final long serialVersionUID = 666251795359709115L;
	
	/**
	 * 报账单行ID
	 */
	private String claimLineId;
	/**
	 * 报账单ID
	 */
	private String claimId;
	/**
	 * 费用类型编码
	 */
	private String scNo;
	/**
	 * 费用类型
	 */
	private String scName;
	/**
	 * 费用承担部门编码
	 */
	private String costCenterNo;
	/**
	 * 费用承担部门名称
	 */
	private String costCenterName;
	/**
	 * 费用承担部门属性ID
	 */
	private String costCenterProid;
	/**
	 * 员工工号
	 */
	private String empCode;
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 员工所在部门标杆编码
	 */
	private String empDeptStandcode;
	/**
	 * 员工所在部门
	 */
	private String empDept;
	/**
	 * 员工所属子公司编码
	 */
	private String empCompCode;
	/**
	 * 员工所属子公司
	 */
	private String empComp;
	/**
	 * 费用期间
	 */
	private String costPeriod;
	/**
	 * 报账金额/借款金额/实发小计
	 */
	private BigDecimal actualAmount;
	/**
	 * 本位币金额(报账/借款/实发小计)
	 */
	private BigDecimal actualAmountStd;
	/**
	 * 核定金额
	 */
	private BigDecimal retifyAmount;
	/**
	 * 核定本位币金额
	 */
	private BigDecimal retifyAmountStd;
	/**
	 * 付款金额
	 */
	private BigDecimal payAmount;
	/**
	 * 付款本位币金额
	 */
	private BigDecimal payAmountStd;
	/**
	 * 预计金额
	 */
	private BigDecimal planAmount;
	/**
	 * 预计本位币金额
	 */
	private BigDecimal planAmountStd;
	/**
	 * 票据张数
	 */
	private int invoiceCount;
	/**
	 * 费用说明
	 */
	private String costExplain;
	/**
	 * 审核会计已修改
	 */
	private String accountModify;
	/**
	 * 业务代码
	 */
	private String bizCode;
	/**
	 * 汇款编号(税金)
	 */
	private String remitNo;
	/**
	 * 业务发生日期
	 */
	private Date bizOccurDate;
	/**
	 * 预算项目编码
	 */
	private String budgetProjectCode;
	/**
	 * 供应商编码
	 */
	private String supplierCode;
	/**
	 * 供应商名称
	 */
	private String supplierName;
	/**
	 * 客户编码
	 */
	private String clientCode;
	/**
	 * 客户名称
	 */
	private String clientName;
	/**
	 * 是否必须查看
	 */
	private String isSelect;
	
	/**
	 * 业务性质
	 */
	private String projectNature;
	
	/**
	 * 业务结束日期
	 */
	private Date bizEndDate;
	
    //是否增值税专用发票
    private String comisVatInvoices;
    //增值税发票号码
    private String cominVatNum;
    //不含税金额
    private String comtaxFreePrice;
    //税额
    private String comtaxPrice;
	
    
    /**入预付总期间数*/
	private BigDecimal accruedCount;
	
	/**入预付开始期间*/
	private String accruedPriod;
	
	/**入预付总金额*/
	private BigDecimal accruedMoney;
	
	/**入当前期间的摊销总金额*/
	private BigDecimal amorttizationMoney;
    
	/**
	 * 应付单号
	 * */
	private String billNumber;
	//日期(税金专用)
	private Date taxCostDate;

	//发票类型(税金专用)
	private String taxInvoiceType;
	
	
	public Date getTaxCostDate() {
		return taxCostDate;
	}
	public void setTaxCostDate(Date taxCostDate) {
		this.taxCostDate = taxCostDate;
	}
	public String getTaxInvoiceType() {
		return taxInvoiceType;
	}
	public void setTaxInvoiceType(String taxInvoiceType) {
		this.taxInvoiceType = taxInvoiceType;
	}
	/**
	/**
	 * 获取报账单行ID
	 * @return claimLineId 报账单行ID
	 */
	public String getClaimLineId() {
		return claimLineId;
	}
	/**
	 * 设置报账单行ID
	 * @param claimLineId 报账单行ID
	 */
	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}
	/**
	 * 获取报账单ID
	 * @return claimId 报账单ID
	 */
	public String getClaimId() {
		return claimId;
	}
	/**
	 * 设置报账单ID
	 * @param claimId 报账单ID
	 */
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	/**
	 * 获取费用类型编码
	 * @return scNo 费用类型编码
	 */
	public String getScNo() {
		return scNo;
	}
	/**
	 * 设置费用类型编码
	 * @param scNo 费用类型编码
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	/**
	 * 获取费用类型
	 * @return scName 费用类型
	 */
	public String getScName() {
		return scName;
	}
	/**
	 * 设置费用类型
	 * @param scName 费用类型
	 */
	public void setScName(String scName) {
		this.scName = scName;
	}
	/**
	 * 获取费用承担部门编码
	 * @return costCenterNo 费用承担部门编码
	 */
	public String getCostCenterNo() {
		return costCenterNo;
	}
	/**
	 * 设置费用承担部门编码
	 * @param costCenterNo 费用承担部门编码
	 */
	public void setCostCenterNo(String costCenterNo) {
		this.costCenterNo = costCenterNo;
	}
	/**
	 * 获取费用承担部门名称
	 * @return costCenterName 费用承担部门名称
	 */
	public String getCostCenterName() {
		return costCenterName;
	}
	/**
	 * 设置费用承担部门名称
	 * @param costCenterName 费用承担部门名称
	 */
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}
	/**
	 * 获取员工工号
	 * @return empCode 员工工号
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * 设置员工工号
	 * @param empCode 员工工号
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * 获取员工姓名
	 * @return empName 员工姓名
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * 设置员工姓名
	 * @param empName 员工姓名
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * 获取员工所在部门标杆编码
	 * @return empDeptStandcode 员工所在部门标杆编码
	 */
	public String getEmpDeptStandcode() {
		return empDeptStandcode;
	}
	/**
	 * 设置员工所在部门标杆编码
	 * @param empDeptStandcode 员工所在部门标杆编码
	 */
	public void setEmpDeptStandcode(String empDeptStandcode) {
		this.empDeptStandcode = empDeptStandcode;
	}
	/**
	 * 获取员工所在部门
	 * @return empDept 员工所在部门
	 */
	public String getEmpDept() {
		return empDept;
	}
	/**
	 * 设置员工所在部门
	 * @param empDept 员工所在部门
	 */
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	/**
	 * 获取员工所属子公司编码
	 * @return empCompCode 员工所属子公司编码
	 */
	public String getEmpCompCode() {
		return empCompCode;
	}
	/**
	 * 设置员工所属子公司编码
	 * @param empCompCode 员工所属子公司编码
	 */
	public void setEmpCompCode(String empCompCode) {
		this.empCompCode = empCompCode;
	}
	/**
	 * 获取员工所属子公司
	 * @return empComp 员工所属子公司
	 */
	public String getEmpComp() {
		return empComp;
	}
	/**
	 * 设置员工所属子公司
	 * @param empComp 员工所属子公司
	 */
	public void setEmpComp(String empComp) {
		this.empComp = empComp;
	}
	/**
	 * 获取费用期间
	 * @return costPeriod 费用期间
	 */
	public String getCostPeriod() {
		return costPeriod;
	}
	/**
	 * 设置费用期间
	 * @param costPeriod 费用期间
	 */
	public void setCostPeriod(String costPeriod) {
		this.costPeriod = costPeriod;
	}
	/**
	 * 获取报账金额借款金额实发小计
	 * @return actualAmount 报账金额借款金额实发小计
	 */
	public BigDecimal getActualAmount() {
		return actualAmount;
	}
	/**
	 * 设置报账金额借款金额实发小计
	 * @param actualAmount 报账金额借款金额实发小计
	 */
	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}
	/**
	 * 获取核定金额
	 * @return retifyAmount 核定金额
	 */
	public BigDecimal getRetifyAmount() {
		return retifyAmount;
	}
	/**
	 * 设置核定金额
	 * @param retifyAmount 核定金额
	 */
	public void setRetifyAmount(BigDecimal retifyAmount) {
		this.retifyAmount = retifyAmount;
	}
	/**
	 * 获取核定本位币金额
	 * @return retifyAmountStd 核定本位币金额
	 */
	public BigDecimal getRetifyAmountStd() {
		return retifyAmountStd;
	}
	/**
	 * 设置核定本位币金额
	 * @param retifyAmountStd 核定本位币金额
	 */
	public void setRetifyAmountStd(BigDecimal retifyAmountStd) {
		this.retifyAmountStd = retifyAmountStd;
	}
	/**
	 * 获取付款金额
	 * @return payAmount 付款金额
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	/**
	 * 设置付款金额
	 * @param payAmount 付款金额
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	/**
	 * 获取预计金额
	 * @return planAmount 预计金额
	 */
	public BigDecimal getPlanAmount() {
		return planAmount;
	}
	/**
	 * 设置预计金额
	 * @param planAmount 预计金额
	 */
	public void setPlanAmount(BigDecimal planAmount) {
		this.planAmount = planAmount;
	}
	/**
	 * 获取预计本位币金额
	 * @return planAmountStd 预计本位币金额
	 */
	public BigDecimal getPlanAmountStd() {
		return planAmountStd;
	}
	/**
	 * 设置预计本位币金额
	 * @param planAmountStd 预计本位币金额
	 */
	public void setPlanAmountStd(BigDecimal planAmountStd) {
		this.planAmountStd = planAmountStd;
	}
	/**
	 * 获取票据张数
	 * @return invoiceCount 票据张数
	 */
	public int getInvoiceCount() {
		return invoiceCount;
	}
	/**
	 * 设置票据张数
	 * @param invoiceCount 票据张数
	 */
	public void setInvoiceCount(int invoiceCount) {
		this.invoiceCount = invoiceCount;
	}
	/**
	 * 获取费用说明
	 * @return costExplain 费用说明
	 */
	public String getCostExplain() {
		return costExplain;
	}
	/**
	 * 设置费用说明
	 * @param costExplain 费用说明
	 */
	public void setCostExplain(String costExplain) {
		this.costExplain = costExplain;
	}
	/**
	 * 获取审核会计已修改
	 * @return accountModify 审核会计已修改
	 */
	public String getAccountModify() {
		return accountModify;
	}
	/**
	 * 设置审核会计已修改
	 * @param accountModify 审核会计已修改
	 */
	public void setAccountModify(String accountModify) {
		this.accountModify = accountModify;
	}
	/**
	 * 获取业务代码
	 * @return bizCode 业务代码
	 */
	public String getBizCode() {
		return bizCode;
	}
	/**
	 * 设置业务代码
	 * @param bizCode 业务代码
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	/**
	 * 获取汇款编号(税金)
	 * @return remitNo 汇款编号(税金)
	 */
	public String getRemitNo() {
		return remitNo;
	}
	/**
	 * 设置汇款编号(税金)
	 * @param remitNo 汇款编号(税金)
	 */
	public void setRemitNo(String remitNo) {
		this.remitNo = remitNo;
	}
	/**
	 * 获取业务发生日期
	 * @return bizOccurDate 业务发生日期
	 */
	public Date getBizOccurDate() {
		return bizOccurDate;
	}
	/**
	 * 设置业务发生日期
	 * @param bizOccurDate 业务发生日期
	 */
	public void setBizOccurDate(Date bizOccurDate) {
		this.bizOccurDate = bizOccurDate;
	}
	/**
	 * 获取本位币金额(报账借款实发小计)
	 * @return actualAmountStd 本位币金额(报账借款实发小计)
	 */
	public BigDecimal getActualAmountStd() {
		return actualAmountStd;
	}
	/**
	 * 设置本位币金额(报账借款实发小计)
	 * @param actualAmountStd 本位币金额(报账借款实发小计)
	 */
	public void setActualAmountStd(BigDecimal actualAmountStd) {
		this.actualAmountStd = actualAmountStd;
	}
	/**
	 * 获取付款本位币金额
	 * @return payAmountStd 付款本位币金额
	 */
	public BigDecimal getPayAmountStd() {
		return payAmountStd;
	}
	/**
	 * 设置付款本位币金额
	 * @param payAmountStd 付款本位币金额
	 */
	public void setPayAmountStd(BigDecimal payAmountStd) {
		this.payAmountStd = payAmountStd;
	}
	/**
	 * 获取预算项目编码
	 * @return budgetProjectCode 预算项目编码
	 */
	public String getBudgetProjectCode() {
		return budgetProjectCode;
	}
	/**
	 * 设置预算项目编码
	 * @param budgetProjectCode 预算项目编码
	 */
	public void setBudgetProjectCode(String budgetProjectCode) {
		this.budgetProjectCode = budgetProjectCode;
	}
	/**
	 * 获取供应商编码
	 * @return supplierCode 供应商编码
	 */
	public String getSupplierCode() {
		return supplierCode;
	}
	/**
	 * 设置供应商编码
	 * @param supplierCode 供应商编码
	 */
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	/**
	 * 获取供应商名称
	 * @return supplierName 供应商名称
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 * 设置供应商名称
	 * @param supplierName 供应商名称
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * 获取客户编码
	 * @return clientCode 客户编码
	 */
	public String getClientCode() {
		return clientCode;
	}
	/**
	 * 设置客户编码
	 * @param clientCode 客户编码
	 */
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	/**
	 * 获取客户名称
	 * @return clientName 客户名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置客户名称
	 * @param clientName 客户名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取费用承担部门属性ID
	 * @return costCenterProid 费用承担部门属性ID
	 */
	public String getCostCenterProid() {
		return costCenterProid;
	}
	/**
	 * 设置费用承担部门属性ID
	 * @param costCenterProid 费用承担部门属性ID
	 */
	public void setCostCenterProid(String costCenterProid) {
		this.costCenterProid = costCenterProid;
	}
	/**
	 * 获取是否必须查看字段
	 */
	public String getIsSelect() {
		return isSelect;
	}
	/**
	 *设置是否必须查看字段
	 */
	public void setIsSelect(String isSelect) {
		this.isSelect = isSelect;
	}
	public String getProjectNature() {
		return projectNature;
	}
	public void setProjectNature(String projectNature) {
		this.projectNature = projectNature;
	}
	public Date getBizEndDate() {
		return bizEndDate;
	}
	public void setBizEndDate(Date bizEndDate) {
		this.bizEndDate = bizEndDate;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getComisVatInvoices() {
		return comisVatInvoices;
	}
	public void setComisVatInvoices(String comisVatInvoices) {
		this.comisVatInvoices = comisVatInvoices;
	}
	public String getCominVatNum() {
		return cominVatNum;
	}
	public void setCominVatNum(String cominVatNum) {
		this.cominVatNum = cominVatNum;
	}
	public String getComtaxFreePrice() {
		return comtaxFreePrice;
	}
	public void setComtaxFreePrice(String comtaxFreePrice) {
		this.comtaxFreePrice = comtaxFreePrice;
	}
	public String getComtaxPrice() {
		return comtaxPrice;
	}
	public void setComtaxPrice(String comtaxPrice) {
		this.comtaxPrice = comtaxPrice;
	}
	/**
	 * 入预付总期间数
	 * @return the accruedCount
	 */
	public BigDecimal getAccruedCount() {
		return accruedCount;
	}
	public void setAccruedCount(BigDecimal accruedCount) {
		this.accruedCount = accruedCount;
	}
	/**
	 * 入预付开始期间
	 * @return the accruedPriod
	 */
	public String getAccruedPriod() {
		return accruedPriod;
	}
	/**
	 * @param accruedPriod the accruedPriod to set
	 */
	public void setAccruedPriod(String accruedPriod) {
		this.accruedPriod = accruedPriod;
	}
	/**
	 * 入预付总金额
	 * @return the accruedMoney
	 */
	public BigDecimal getAccruedMoney() {
		return accruedMoney;
	}
	/**
	 * @param accruedMoney the accruedMoney to set
	 */
	public void setAccruedMoney(BigDecimal accruedMoney) {
		this.accruedMoney = accruedMoney;
	}
	/**
	 * 入当前期间摊销费用（用于摘要取值）
	 * @return the amorttizationMoney
	 */
	public BigDecimal getAmorttizationMoney() {
		return amorttizationMoney;
	}
	/**
	 * 入当前期间摊销费用（用于摘要取值）
	 * @param amorttizationMoney the amorttizationMoney to set
	 */
	public void setAmorttizationMoney(BigDecimal amorttizationMoney) {
		this.amorttizationMoney = amorttizationMoney;
	}
	
	
}
