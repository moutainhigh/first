package com.deppon.dpm.module.vpp.shared.domain;

import java.io.File;


/**
 * 访客实体
 */
public class VisitorEntity {
	/**
	 * 访客单位
	 */
	private String company;
	/**
	 * 访客姓名
	 */
	private String visitorName;
	/**
	 * 访客性别 0男  1女
	 */
	private int visitorSex;
	/**
	 * 访客电话
	 */
	private String visitorTel;
	/**
	 * 证件类型 1：身份证、2：护照、3：军官证、4：驾驶证
	 */
	private String cardType;
	/**
	 * 证件号码
	 */
	private String cardNo;
	/**
	 * 访客email
	 */
	private String email;
	/**
	 * 到访日期
	 */
	private String visitorDate;
	/**
	 * 事由  1会议、 2来访、 3送货、 4培训、 5入职、 6面试、 0其他
	 */
	private String thing;
	/**
	 * 随行车辆
	 */
	private String carCode;
	/**
	 * 其他信息
	 */
	private String remark;
	/**
	 * 访客头像
	 */
	private File photo;
	
	
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the visitorName
	 */
	public String getVisitorName() {
		return visitorName;
	}
	/**
	 * @param visitorName the visitorName to set
	 */
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	/**
	 * @return the visitorSex
	 */
	public int getVisitorSex() {
		return visitorSex;
	}
	/**
	 * @param visitorSex the visitorSex to set
	 */
	public void setVisitorSex(int visitorSex) {
		this.visitorSex = visitorSex;
	}
	/**
	 * @return the visitorTel
	 */
	public String getVisitorTel() {
		return visitorTel;
	}
	/**
	 * @param visitorTel the visitorTel to set
	 */
	public void setVisitorTel(String visitorTel) {
		this.visitorTel = visitorTel;
	}
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the visitorDate
	 */
	public String getVisitorDate() {
		return visitorDate;
	}
	/**
	 * @param visitorDate the visitorDate to set
	 */
	public void setVisitorDate(String visitorDate) {
		this.visitorDate = visitorDate;
	}
	/**
	 * @return the thing
	 */
	public String getThing() {
		return thing;
	}
	/**
	 * @param thing the thing to set
	 */
	public void setThing(String thing) {
		this.thing = thing;
	}
	/**
	 * @return the carCode
	 */
	public String getCarCode() {
		return carCode;
	}
	/**
	 * @param carCode the carCode to set
	 */
	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the photo
	 */
	public File getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	
}
