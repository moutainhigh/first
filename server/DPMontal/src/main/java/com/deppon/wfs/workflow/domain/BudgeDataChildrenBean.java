package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预算申请子表实体Bean
 * @author 赵慧
 * @Date 2014-01-18 13:47:54
 */
 
public class BudgeDataChildrenBean extends Entity {
	
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
	private String childrenAdjustmentCostItem;
	
	/** 
	* 调增科目/调减科目 
	*/
	private String adjustmentSubject;
	
	/** 
	* 调增部门/调减部门 
	*/
	private String adjustmentDept;
	
	/** 
	* 调整月份 
	*/
	private String adjustmentMonth;
	
	/** 
	* 调整金额 
	*/
	private BigDecimal adjustmentMoney;
	
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
	public String getChildrenAdjustmentCostItem() {
		return childrenAdjustmentCostItem;
	}

	/**
	* 设置 调增成本项/调减成本项.
	*
	* @param 调增成本项/调减成本项.
	*/
	public void setChildrenAdjustmentCostItem(String childrenAdjustmentCostItem) {
		this.childrenAdjustmentCostItem = childrenAdjustmentCostItem;
	}
	
	/**
	* 获取 调增科目/调减科目.
	*
	* @return 调增科目/调减科目.
	*/
	public String getAdjustmentSubject() {
		return adjustmentSubject;
	}

	/**
	* 设置 调增科目/调减科目.
	*
	* @param 调增科目/调减科目.
	*/
	public void setAdjustmentSubject(String adjustmentSubject) {
		this.adjustmentSubject = adjustmentSubject;
	}
	
	/**
	* 获取 调增部门/调减部门.
	*
	* @return 调增部门/调减部门.
	*/
	public String getAdjustmentDept() {
		return adjustmentDept;
	}

	/**
	* 设置 调增部门/调减部门.
	*
	* @param 调增部门/调减部门.
	*/
	public void setAdjustmentDept(String adjustmentDept) {
		this.adjustmentDept = adjustmentDept;
	}
	
	/**
	* 获取 调整月份.
	*
	* @return 调整月份.
	*/
	public String getAdjustmentMonth() {
		return adjustmentMonth;
	}

	/**
	* 设置 调整月份.
	*
	* @param 调整月份.
	*/
	public void setAdjustmentMonth(String adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}
	
	/**
	* 获取 调整金额.
	*
	* @return 调整金额.
	*/
	public BigDecimal getAdjustmentMoney() {
		return adjustmentMoney;
	}

	/**
	* 设置 调整金额.
	*
	* @param 调整金额.
	*/
	public void setAdjustmentMoney(BigDecimal adjustmentMoney) {
		this.adjustmentMoney = adjustmentMoney;
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
