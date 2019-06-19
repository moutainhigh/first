package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 包裹录入信息
 * @author 王亚男
 *
 */
public class ParcelEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6253616700282507759L;

	private int id;
	//包裹类型Code
	private Long packageTypeCode;
	//包裹类型
	private String packageType;
	//用户工号
	private String userNo;
	//用户姓名
	private String userName;
	//签收地点Code
	private Long addressCode;
	//签收地点
	private String addressName;
	//入库时间
	private String arriveDate;
	//包裹编码-包裹流水号('0001'四位编码，每天重置)
	private String parcelMark;
	//快递公司名称Code
	private Long companyCode;
	//快递公司名称
	private String companyName;
	//联系人电话号码
	private String tellPhone;
	//领取时间
	private String toReceiveDate;
	//包裹状态
	private int parcelState;
	//包裹唯一标示
	private Long packageId;
	//领取状态
	private int postStatus;
	//更新时间（状态更新时间）
	private String updateTime;
	//创建时间
	private String createTime;
	
	//代领取人姓名
	private String forUserName;
	//代领取人工号
	private String forUserNo;
	
	//getter setter
	public String getForUserName() {
		return forUserName;
	}
	//getter setter
	public void setForUserName(String forUserName) {
		this.forUserName = forUserName;
	}
	//getter setter
	public String getForUserNo() {
		return forUserNo;
	}
	//getter setter
	public void setForUserNo(String forUserNo) {
		this.forUserNo = forUserNo;
	}
	//getter setter
	public String getCreateTime() {
		return createTime;
	}
	//getter setter
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	//getter setter
	public int getId() {
		return id;
	}
	//getter setter
	public void setId(int id) {
		this.id = id;
	}
	//getter setter
	public Long getPackageTypeCode() {
		return packageTypeCode;
	}
	//getter setter
	public void setPackageTypeCode(Long packageTypeCode) {
		this.packageTypeCode = packageTypeCode;
	}
	//getter setter
	public String getPackageType() {
		return packageType;
	}
	//getter setter
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	//getter setter
	public String getUserNo() {
		return userNo;
	}
	//getter setter
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	//getter setter
	public String getUserName() {
		return userName;
	}
	//getter setter
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//getter setter
	public Long getAddressCode() {
		return addressCode;
	}
	//getter setter
	public void setAddressCode(Long addressCode) {
		this.addressCode = addressCode;
	}
	//getter setter
	public String getAddressName() {
		return addressName;
	}
	//getter setter
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	//getter setter
	public String getArriveDate() {
		return arriveDate;
	}
	//getter setter
	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}
	//getter setter
	public String getParcelMark() {
		return parcelMark;
	}
	//getter setter
	public void setParcelMark(String parcelMark) {
		this.parcelMark = parcelMark;
	}
	//getter setter
	public Long getCompanyCode() {
		return companyCode;
	}
	//getter setter
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	//getter setter
	public String getCompanyName() {
		return companyName;
	}
	//getter setter
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	//getter setter
	public String getTellPhone() {
		return tellPhone;
	}
	//getter setter
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}
	//getter setter
	public String getToReceiveDate() {
		return toReceiveDate;
	}
	//getter setter
	public void setToReceiveDate(String toReceiveDate) {
		this.toReceiveDate = toReceiveDate;
	}
	//getter setter
	public int getParcelState() {
		return parcelState;
	}
	//getter setter
	public void setParcelState(int parcelState) {
		this.parcelState = parcelState;
	}
	//getter setter
	public Long getPackageId() {
		return packageId;
	}
	//getter setter
	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}
	//getter setter
	public int getPostStatus() {
		return postStatus;
	}
	//getter setter
	public void setPostStatus(int postStatus) {
		this.postStatus = postStatus;
	}
	//getter setter
	public String getUpdateTime() {
		return updateTime;
	}
	//getter setter
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
