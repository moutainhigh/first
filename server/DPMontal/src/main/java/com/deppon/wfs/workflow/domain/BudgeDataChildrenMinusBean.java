package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预算申请子表实体Bean
 * @author 赵慧
 * @Date 2014-01-18 13:47:54
 */
 
public class BudgeDataChildrenMinusBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* id 
	*/
	private String childrenBusino;
	
	/** 
	* id 父表 
	*/
	private String busino;
	
	/** 
	* 调增成本项/调减成本项 
	*/
	private String childrenAdjustmentCostItemMinus;
	
	/** 
	* 调增科目/调减科目 
	*/
	private String adjustmentSubjectMinus;
	
	/** 
	* 调增部门/调减部门 
	*/
	private String adjustmentDeptMinus;
	
	/** 
	* 调整月份 
	*/
	private String adjustmentMonthMinus;
	
	/** 
	* 调整金额 
	*/
	private BigDecimal adjustmentMoneyMinus;
	
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
	* 备用字段1 
	*/
	private Long reserveOne;
	
	/** 
	* 备用字段2 
	*/
	private String reserveTwo;
	
	/** 
	* 备用字段3 
	*/
	private String reserveThree;
	
	
	/**
	* 获取 id.
	*
	* @return id.
	*/
	public String getChildrenBusino() {
		return childrenBusino;
	}

	/**
	* 设置 id.
	*
	* @param id.
	*/
	public void setChildrenBusino(String childrenBusino) {
		this.childrenBusino = childrenBusino;
	}
	
	/**
	* 获取 id 父表.
	*
	* @return id 父表.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 id 父表.
	*
	* @param id 父表.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 调增成本项/调减成本项.
	*
	* @return 调增成本项/调减成本项.
	*/
	public String getChildrenAdjustmentCostItemMinus() {
		return childrenAdjustmentCostItemMinus;
	}

	/**
	* 设置 调增成本项/调减成本项.
	*
	* @param 调增成本项/调减成本项.
	*/
	public void setChildrenAdjustmentCostItemMinus(String childrenAdjustmentCostItemMinus) {
		this.childrenAdjustmentCostItemMinus = childrenAdjustmentCostItemMinus;
	}
	
	/**
	* 获取 调增科目/调减科目.
	*
	* @return 调增科目/调减科目.
	*/
	public String getAdjustmentSubjectMinus() {
		return adjustmentSubjectMinus;
	}

	/**
	* 设置 调增科目/调减科目.
	*
	* @param 调增科目/调减科目.
	*/
	public void setAdjustmentSubjectMinus(String adjustmentSubjectMinus) {
		this.adjustmentSubjectMinus = adjustmentSubjectMinus;
	}
	
	/**
	* 获取 调增部门/调减部门.
	*
	* @return 调增部门/调减部门.
	*/
	public String getAdjustmentDeptMinus() {
		return adjustmentDeptMinus;
	}

	/**
	* 设置 调增部门/调减部门.
	*
	* @param 调增部门/调减部门.
	*/
	public void setAdjustmentDeptMinus(String adjustmentDeptMinus) {
		this.adjustmentDeptMinus = adjustmentDeptMinus;
	}
	
	/**
	* 获取 调整月份.
	*
	* @return 调整月份.
	*/
	public String getAdjustmentMonthMinus() {
		return adjustmentMonthMinus;
	}

	/**
	* 设置 调整月份.
	*
	* @param 调整月份.
	*/
	public void setAdjustmentMonthMinus(String adjustmentMonthMinus) {
		this.adjustmentMonthMinus = adjustmentMonthMinus;
	}
	
	/**
	* 获取 调整金额.
	*
	* @return 调整金额.
	*/
	public BigDecimal getAdjustmentMoneyMinus() {
		return adjustmentMoneyMinus;
	}

	/**
	* 设置 调整金额.
	*
	* @param 调整金额.
	*/
	public void setAdjustmentMoneyMinus(BigDecimal adjustmentMoneyMinus) {
		this.adjustmentMoneyMinus = adjustmentMoneyMinus;
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
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public Long getReserveOne() {
		return reserveOne;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setReserveOne(Long reserveOne) {
		this.reserveOne = reserveOne;
	}
	
	/**
	* 获取 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getReserveTwo() {
		return reserveTwo;
	}

	/**
	* 设置 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}
	
	/**
	* 获取 备用字段3.
	*
	* @return 备用字段3.
	*/
	public String getReserveThree() {
		return reserveThree;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}
	

}
