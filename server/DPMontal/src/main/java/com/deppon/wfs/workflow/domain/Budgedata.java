package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
 
/**
* @title: Budgedata  
* @description：预算数据申请 实体类
* @author： 赵慧
* @date： 2013-10-15 上午11:33:34
*/
public class Budgedata extends Entity{
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* id 
	*/
	private String busino;
	
	/** 
	* 工作流号 
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
	* 工作流类型 (全部) 
	*/
	private String workflowType;
	
	/** 
	* 预算部门 (全部) 
	*/
	private String department;
	
	/** 
	* 预算部门标杆编码 (全部) 
	*/
	private String departmentSyscode;
	
	/** 
	* 部门性质 (全部) 
	*/
	private String departmentProperty;
		
	/** 
	* (新所属营运本部)所属办公室(全部) 
	*/
	private String belongOffice;
	
	/** 
	* (新所属营运本部标杆编码)所属办公室标杆编码(全部) 
	*/
	private String belongOfficeSyscode;
	
	/** 
	* 预算年份 (全部) 
	*/
	private String budgetYear;
	
	/** 
	* 申请事由 (全部) 
	*/
	private String applyReason;
	
	/** 
	* 创建时间 
	*/
	private Date creatTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务状态 
	*/
	private String isseffective;
	
	/** 
	* 备用字段一 
	*/
	private Long reserveOne;
	
	/** 
	* 备用字段二 
	*/
	private String reserveTwo;
	
	/** 
	* 备用字段三 
	*/
	private String reserveThree;
	
	/** 
	* 调整方式(调整：总成本不变/新增) 
	*/
	private String adjustmentType;
	
	/** 
	* 调整成本项(调整：总成本不变) 
	*/
	private String adjustmentCostItem;
	
	/** 
	* 是否年度预算(申请) 
	*/
	private String ifYearlyBudget;
	
	/** 
	* 调减年度利润影响值(调整：总成本不变) 
	*/
	private BigDecimal profitEffectMinus;
	
	/**
	* 调增年度利润影响值(调整：总成本不变/新增) 
	*/
	private BigDecimal profitEffectAdd;
	/**
	* 调增成本项(调整：总成本不变/新增)
	*/
	private String addCostItem;
	/**
	* 调减成本项(调整：总成本不变)
	*/
	private String minusCostItem;
	
	/**
	* 子表
	*/
	private List<BudgeDataChildrenBean> budgeDataChildren;

	private List<BudgeDataChildrenMinusBean> budgeDataChildrenMinus;
	
	private List<BudgeDataSubmitDetailBean> budgeDataSubmitDetail;
	
//	private List
	/** 老数据兼容 */
	/**
	 * (无)部门分类 (申请、调整)	
	 */
	private String departmentSort;
	/**
	 * (无)预算季度 (申请)
	 */
	private String budgetQuarter;
	/**
	 * (子表)预算月份 (调整)
	 */
	private String budgetMonth;
	/**
	 * (子表)预算金额 (调整)
	 */
	private BigDecimal budgetMoney;
	/**
	 * (子表)调整后金额 (调整)
	 */
	private BigDecimal adjustiveMoney;
	/**
	 * (无)费用类型 (调整)
	 */
	private String chargeType;
	/**
	 * (无)调整幅度 (调整)
	 */
	private BigDecimal adjustiveExtent;

	/**
	* 获取 id.
	*
	* @return id.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 id.
	*
	* @param id.
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
	* 获取 工作流类型 (全部).
	*
	* @return 工作流类型 (全部).
	*/
	public String getWorkflowType() {
		return workflowType;
	}

	/**
	* 设置 工作流类型 (全部).
	*
	* @param 工作流类型 (全部).
	*/
	public void setWorkflowType(String workflowType) {
		this.workflowType = workflowType;
	}
	
	/**
	* 获取 预算部门 (全部).
	*
	* @return 预算部门 (全部).
	*/
	public String getDepartment() {
		return department;
	}

	/**
	* 设置 预算部门 (全部).
	*
	* @param 预算部门 (全部).
	*/
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	* 获取 预算部门标杆编码 (全部).
	*
	* @return 预算部门标杆编码 (全部).
	*/
	public String getDepartmentSyscode() {
		return departmentSyscode;
	}

	/**
	* 设置 预算部门标杆编码 (全部).
	*
	* @param 预算部门标杆编码 (全部).
	*/
	public void setDepartmentSyscode(String departmentSyscode) {
		this.departmentSyscode = departmentSyscode;
	}
	
	/**
	* 获取 部门性质 (全部).
	*
	* @return 部门性质 (全部).
	*/
	public String getDepartmentProperty() {
		return departmentProperty;
	}

	/**
	* 设置 部门性质 (全部).
	*
	* @param 部门性质 (全部).
	*/
	public void setDepartmentProperty(String departmentProperty) {
		this.departmentProperty = departmentProperty;
	}
	
	/**
	* 获取 (新所属营运本部)所属办公室(全部).
	*
	* @return (新所属营运本部)所属办公室(全部).
	*/
	public String getBelongOffice() {
		return belongOffice;
	}

	/**
	* 设置 (新所属营运本部)所属办公室(全部).
	*
	* @param (新所属营运本部)所属办公室(全部).
	*/
	public void setBelongOffice(String belongOffice) {
		this.belongOffice = belongOffice;
	}
	
	/**
	* 获取 (新所属营运本部标杆编码)所属办公室标杆编码(全部).
	*
	* @return (新所属营运本部标杆编码)所属办公室标杆编码(全部).
	*/
	public String getBelongOfficeSyscode() {
		return belongOfficeSyscode;
	}

	/**
	* 设置 (新所属营运本部标杆编码)所属办公室标杆编码(全部).
	*
	* @param (新所属营运本部标杆编码)所属办公室标杆编码(全部).
	*/
	public void setBelongOfficeSyscode(String belongOfficeSyscode) {
		this.belongOfficeSyscode = belongOfficeSyscode;
	}
	
	/**
	* 获取 预算年份 (全部).
	*
	* @return 预算年份 (全部).
	*/
	public String getBudgetYear() {
		return budgetYear;
	}

	/**
	* 设置 预算年份 (全部).
	*
	* @param 预算年份 (全部).
	*/
	public void setBudgetYear(String budgetYear) {
		this.budgetYear = budgetYear;
	}
	
	/**
	* 获取 申请事由 (全部).
	*
	* @return 申请事由 (全部).
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	* 设置 申请事由 (全部).
	*
	* @param 申请事由 (全部).
	*/
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	/**
	* 获取 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreatTime() {
		return creatTime;
	}

	/**
	* 设置 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
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
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务状态.
	*
	* @param 业务状态.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段一.
	*
	* @return 备用字段一.
	*/
	public Long getReserveOne() {
		return reserveOne;
	}

	/**
	* 设置 备用字段一.
	*
	* @param 备用字段一.
	*/
	public void setReserveOne(Long reserveOne) {
		this.reserveOne = reserveOne;
	}
	
	/**
	* 获取 备用字段二.
	*
	* @return 备用字段二.
	*/
	public String getReserveTwo() {
		return reserveTwo;
	}

	/**
	* 设置 备用字段二.
	*
	* @param 备用字段二.
	*/
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}
	
	/**
	* 获取 备用字段三.
	*
	* @return 备用字段三.
	*/
	public String getReserveThree() {
		return reserveThree;
	}

	/**
	* 设置 备用字段三.
	*
	* @param 备用字段三.
	*/
	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}
	
	/**
	* 获取 调整方式(调整：总成本不变/新增).
	*
	* @return 调整方式(调整：总成本不变/新增).
	*/
	public String getAdjustmentType() {
		return adjustmentType;
	}

	/**
	* 设置 调整方式(调整：总成本不变/新增).
	*
	* @param 调整方式(调整：总成本不变/新增).
	*/
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	
	/**
	* 获取 调整成本项(调整：总成本不变).
	*
	* @return 调整成本项(调整：总成本不变).
	*/
	public String getAdjustmentCostItem() {
		return adjustmentCostItem;
	}

	/**
	* 设置 调整成本项(调整：总成本不变).
	*
	* @param 调整成本项(调整：总成本不变).
	*/
	public void setAdjustmentCostItem(String adjustmentCostItem) {
		this.adjustmentCostItem = adjustmentCostItem;
	}
	
	/**
	* 获取 是否年度预算(申请).
	*
	* @return 是否年度预算(申请).
	*/
	public String getIfYearlyBudget() {
		return ifYearlyBudget;
	}

	/**
	* 设置 是否年度预算(申请).
	*
	* @param 是否年度预算(申请).
	*/
	public void setIfYearlyBudget(String ifYearlyBudget) {
		this.ifYearlyBudget = ifYearlyBudget;
	}

	public BigDecimal getProfitEffectMinus() {
		return profitEffectMinus;
	}

	public void setProfitEffectMinus(BigDecimal profitEffectMinus) {
		this.profitEffectMinus = profitEffectMinus;
	}

	public BigDecimal getProfitEffectAdd() {
		return profitEffectAdd;
	}

	public void setProfitEffectAdd(BigDecimal profitEffectAdd) {
		this.profitEffectAdd = profitEffectAdd;
	}

	public String getAddCostItem() {
		return addCostItem;
	}

	public void setAddCostItem(String addCostItem) {
		this.addCostItem = addCostItem;
	}

	public String getMinusCostItem() {
		return minusCostItem;
	}

	public void setMinusCostItem(String minusCostItem) {
		this.minusCostItem = minusCostItem;
	}
	public List<BudgeDataChildrenBean> getBudgeDataChildren() {
		return budgeDataChildren;
	}

	public void setBudgeDataChildren(
			List<BudgeDataChildrenBean> budgeDataChildren) {
		this.budgeDataChildren = budgeDataChildren;
	}
	
	public List<BudgeDataChildrenMinusBean> getBudgeDataChildrenMinus() {
		return budgeDataChildrenMinus;
	}

	public void setBudgeDataChildrenMinus(
			List<BudgeDataChildrenMinusBean> budgeDataChildrenMinus) {
		this.budgeDataChildrenMinus = budgeDataChildrenMinus;
	}
	

	/**
	 * @return the budgeDataSubmitDetail
	 */
	public List<BudgeDataSubmitDetailBean> getBudgeDataSubmitDetail() {
		return budgeDataSubmitDetail;
	}

	/**
	 * @param budgeDataSubmitDetail the budgeDataSubmitDetail to set
	 */
	public void setBudgeDataSubmitDetail(
			List<BudgeDataSubmitDetailBean> budgeDataSubmitDetail) {
		this.budgeDataSubmitDetail = budgeDataSubmitDetail;
	}

	public String getDepartmentSort() {
		return departmentSort;
	}

	public void setDepartmentSort(String departmentSort) {
		this.departmentSort = departmentSort;
	}

	public String getBudgetQuarter() {
		return budgetQuarter;
	}

	public void setBudgetQuarter(String budgetQuarter) {
		this.budgetQuarter = budgetQuarter;
	}

	public String getBudgetMonth() {
		return budgetMonth;
	}

	public void setBudgetMonth(String budgetMonth) {
		this.budgetMonth = budgetMonth;
	}

	public BigDecimal getBudgetMoney() {
		return budgetMoney;
	}

	public void setBudgetMoney(BigDecimal budgetMoney) {
		this.budgetMoney = budgetMoney;
	}

	public BigDecimal getAdjustiveMoney() {
		return adjustiveMoney;
	}

	public void setAdjustiveMoney(BigDecimal adjustiveMoney) {
		this.adjustiveMoney = adjustiveMoney;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public BigDecimal getAdjustiveExtent() {
		return adjustiveExtent;
	}

	public void setAdjustiveExtent(BigDecimal adjustiveExtent) {
		this.adjustiveExtent = adjustiveExtent;
	}
	
}
