package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * PC 推送包裹录入信息
 * @author 王亚男
 *
 */
public class ParcelDataEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1978735353725693718L;
	
	//主键ID(唯一)
	private Long packagesId;
	//入库时间
	private String enterTime;
	//员工姓名
	private String personName;
	//员工工号
	private String personCode;
	//联系电话
	private String tellphone;
	//包裹流水号('0001'四位编码，每天重置)
	private String packageNum;
	//包裹类型(实体)
	private PackageEntity packagesType;
	//快递公司(实体)
	private PackageEntity packagesCompany;
	//签收地点（实体）
	private PackageEntity packagesReceiveplace;
	
	/*//---
	//包裹类型Code
	private Long packageTypeCode;
	//包裹类型
	private String packageType;
	//签收地点Code
	private Long addressCode;
	//签收地点
	private String addressName;
	//快递公司code
	private Long companyCode;
	//快递公司名称
	private String companyName;
	*/
	
	public Long getPackagesId() {
		return packagesId;
	}
	public void setPackagesId(Long packagesId) {
		this.packagesId = packagesId;
	}
	public String getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	public String getTellphone() {
		return tellphone;
	}
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	public String getPackageNum() {
		return packageNum;
	}
	public void setPackageNum(String packageNum) {
		this.packageNum = packageNum;
	}
	public PackageEntity getPackagesType() {
		return packagesType;
	}
	public void setPackagesType(PackageEntity packagesType) {
		this.packagesType = packagesType;
	}
	public PackageEntity getPackagesCompany() {
		return packagesCompany;
	}
	public void setPackagesCompany(PackageEntity packagesCompany) {
		this.packagesCompany = packagesCompany;
	}
	public PackageEntity getPackagesReceiveplace() {
		return packagesReceiveplace;
	}
	public void setPackagesReceiveplace(PackageEntity packagesReceiveplace) {
		this.packagesReceiveplace = packagesReceiveplace;
	}
	public Long getPackageTypeCode() {
		return this.packagesType.getTypeId();
	}
	/*public void setPackageTypeCode(Long packageTypeCode) {
		this.packageTypeCode = packageTypeCode;
	}
	public String getPackageType() {
		return this.packagesType.getName();
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public Long getAddressCode() {
		return this.packagesReceiveplace.getTypeId();
	}
	public void setAddressCode(Long addressCode) {
		this.addressCode = addressCode;
	}
	public String getAddressName() {
		return this.packagesReceiveplace.getName();
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public Long getCompanyCode() {
		return this.packagesCompany.getTypeId();
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return this.packagesCompany.getName();
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}*/
	
	
}
