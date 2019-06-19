package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
* @ClassName: OccupyBudgetRquestEntity 
* @Description: TODO(预算占用请求参数) 
* @author 287306
* @date 2017-11-21 下午8:55:42 
*  
*/
public class OccupyBudgetRquestEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//打车id
	private String businessId;
	//打车人工号
	private String empCode;
	//打车金额
	private BigDecimal amount;
	//订单开始时间
	private Date businessStartTime;
	
	/**
	 * 构造方法
	 */
	public OccupyBudgetRquestEntity(){
		super();
	}
	
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getBusinessStartTime() {
		return businessStartTime;
	}
	public void setBusinessStartTime(Date businessStartTime) {
		this.businessStartTime = businessStartTime;
	}

}
