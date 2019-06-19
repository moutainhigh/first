package com.deppon.dpm.module.management.shared.vo;

import java.io.Serializable;

/**
 * @author 268101 包裹信息列表
 *
 */
public class ParcelListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields id 包裹表信息主键(用于记录)
	*/ 
	private int id;
	/** 
	* @Fields packageId 包裹ID
	*/ 
	private int packageId;	
	/** 
	* @Fields packageTypeCode 包裹类型编码
	*/ 
	private int packageTypeCode;
	/** 
	* @Fields packageType 包裹类型
	*/ 
	private String packageType;
	/** 
	* @Fields userNo 签收人工号
	*/ 
	private String userNo; 
	/** 
	* @Fields userName 签收人
	*/ 
	private String  userName; 
	/** 
	* @Fields receiveDate 签收时间
	*/ 
	private String  receiveDate; 
	/** 
	* @Fields parcelState 包裹状态(库存中（0），已签收（1），已拒收（2），已注销（3） ,催领（4）)
	*/ 
	private int  parcelState; 
	/** 
	* @Fields postStatus 代理标识(0:自己领取；1：代理)
	*/ 
	private int postStatus;
	//构造方法
	public ParcelListVO() {
	}
	//构造方法
	public ParcelListVO(String userNo) {
		super();
		this.userNo = userNo;
	}
	//get set 
	public int getId() {
		return id;
	}
	//get set 
	public void setId(int id) {
		this.id = id;
	}
	//get set 
	public int getPackageId() {
		return packageId;
	}
	//get set 
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getPackageTypeCode() {
		return packageTypeCode;
	}
	public void setPackageTypeCode(int packageTypeCode) {
		this.packageTypeCode = packageTypeCode;
	}
	//get set 
	public String getPackageType() {
		return packageType;
	}
	//get set 
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	//get set 
	public String getUserName() {
		return userName;
	}
	//get set 
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	//get set 
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public int getParcelState() {
		return parcelState;
	}
	//get set 
	public void setParcelState(int parcelState) {
		this.parcelState = parcelState;
	}
	public int getPostStatus() {
		return postStatus;
	}
	//get set 
	public void setPostStatus(int postStatus) {
		this.postStatus = postStatus;
	}	
}
