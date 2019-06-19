package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

public class DidiBankCardVO implements Serializable{

	
	private static final long serialVersionUID = -8275329220305975540L;
	
	/**
	 * 构造方法
	 */
	public DidiBankCardVO(){
		super();
	}
	
	//主键
	private Integer id;
	//用户工号
	private String userId;
	//用户
	private String cardHolder;
	//银行卡号
	private String bankCardNumber;
	//部门
	private String userDept;
	//部门bain吗
	private String deptCode;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the cardHolder
	 */
	public String getCardHolder() {
		return cardHolder;
	}

	/**
	 * @param cardHolder the cardHolder to set
	 */
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	/**
	 * @return the bankCardNumber
	 */
	public String getBankCardNumber() {
		return bankCardNumber;
	}

	/**
	 * @param bankCardNumber the bankCardNumber to set
	 */
	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	/**
	 * @return the userDept
	 */
	public String getUserDept() {
		return userDept;
	}

	/**
	 * @param userDept the userDept to set
	 */
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	/**
	 * @return the deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * @param deptCode the deptCode to set
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getCardHolder() {
//		return cardHolder;
//	}
//
//	public void setCardHolder(String cardHolder) {
//		this.cardHolder = cardHolder;
//	}
//
//	public String getBankCardNumber() {
//		return bankCardNumber;
//	}
//
//	public void setBankCardNumber(String bankCardNumber) {
//		this.bankCardNumber = bankCardNumber;
//	}
//
//	public String getUserDept() {
//		return userDept;
//	}
//
//	public void setUserDept(String userDept) {
//		this.userDept = userDept;
//	}
//
//	public String getDeptCode() {
//		return deptCode;
//	}
//
//	public void setDeptCode(String deptCode) {
//		this.deptCode = deptCode;
//	}


}
