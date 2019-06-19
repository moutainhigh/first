package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预算数据申请_提交明细子表bean
 * @title: BudgeDataSubmitDetail 
 * @author： lihai
 * @date： 2014-6-7 下午01:44:30
 */
public class BudgeDataSubmitDetailBean extends Entity {


	/**
	* 
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
	private String submitDetailCostItem;
	
	/** 
	* 调整金额 
	*/
	private BigDecimal submitDetailMoney;
	
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
	 * @return the childrenBusino
	 */
	public String getChildrenBusino() {
		return childrenBusino;
	}

	/**
	 * @param childrenBusino the childrenBusino to set
	 */
	public void setChildrenBusino(String childrenBusino) {
		this.childrenBusino = childrenBusino;
	}

	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the submitDetailCostItem
	 */
	public String getSubmitDetailCostItem() {
		return submitDetailCostItem;
	}

	/**
	 * @param submitDetailCostItem the submitDetailCostItem to set
	 */
	public void setSubmitDetailCostItem(String submitDetailCostItem) {
		this.submitDetailCostItem = submitDetailCostItem;
	}

	/**
	 * @return the submitDetailMoney
	 */
	public BigDecimal getSubmitDetailMoney() {
		return submitDetailMoney;
	}

	/**
	 * @param submitDetailMoney the submitDetailMoney to set
	 */
	public void setSubmitDetailMoney(BigDecimal submitDetailMoney) {
		this.submitDetailMoney = submitDetailMoney;
	}

	/**
	 * @return the creatTime
	 */
	public Date getCreatTime() {
		return creatTime;
	}

	/**
	 * @param creatTime the creatTime to set
	 */
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the isseffective
	 */
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * @param isseffective the isseffective to set
	 */
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}

	/**
	 * @return the reserveOne
	 */
	public Long getReserveOne() {
		return reserveOne;
	}

	/**
	 * @param reserveOne the reserveOne to set
	 */
	public void setReserveOne(Long reserveOne) {
		this.reserveOne = reserveOne;
	}

	/**
	 * @return the reserveTwo
	 */
	public String getReserveTwo() {
		return reserveTwo;
	}

	/**
	 * @param reserveTwo the reserveTwo to set
	 */
	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}

	/**
	 * @return the reserveThree
	 */
	public String getReserveThree() {
		return reserveThree;
	}

	/**
	 * @param reserveThree the reserveThree to set
	 */
	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}
	
	
	
}
