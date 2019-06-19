package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 保存人员地点实体
 * @author 袁中华
 * @date 2015.7.14
 *  关联 proc_user_address表
 */
public class ProcAddressEntity implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id 主键ID
	 */
	private String id;

	/**
	 * 用户工号
	 */
	private String userNo ;

	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * proAdress 地址
	 */
	private String proAdress ;

	/**
	 * proType 功能栏代码值
	 */
	private String proType;

	/**
	 * createDate 创建时间
	 */
	private Date createDate;
	/**
	 * stringDate  转类型
	 */
	private String stringDate;
	/**
	 * 标识
	 */
	private String	isSubmit;
	private String proName;
	/**
	 * 经纬度
	 */
//	private String streetAddress;
//	
//	public String getStreetAddress() {
//		return streetAddress;
//	}
//	public void setStreetAddress(String streetAddress) {
//		this.streetAddress = streetAddress;
//	}
	public String getStringDate() {
		return stringDate;
	}
	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getIsSubmit() {
		return isSubmit;
	}
	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserno() {
		return userNo;
	}
	public void setUserno(String userno) {
		this.userNo = userno;
	}
	public String getProAdress() {
		return proAdress;
	}
	public void setProAdress(String proAdress) {
		this.proAdress = proAdress;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
