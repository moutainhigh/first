package com.deppon.dpm.module.wechat.shared.domain;

public class WechatUserInfoEntity {
	/**
	 * 姓名  必传项
	 */
	String userid;
	/**
	 * 帐号（工号）  必传项
	 */
	String name;
	/**
	 * 手机号 （mobile/email二者不能同时为空）
	 */
	String mobile;
	/**
	 * 邮箱
	 */
	String email;
	/**
	 * 成员所属部门id列表,不超过20个  必传项
	 */
	String department;
	/**
	 * 职位信息
	 */
	String position;
	/**
	 * 性别
	 */
	String gender;
	/**
	 * 是否是领导
	 */
	String isleader;
	/**
	 * 部门内的排序值，默认为0。数量必须和department一致，数值越大排序越前面。有效的值范围是[0, 2^32)  非必传项
	 */
	String order;
	/**
	 * 英文名 (非必传项)
	 */
	String english_name;
	/**
	 * 座机号码
	 */
	String telephone;
	/**
	 * 启用/禁用成员。1表示启用成员，0表示禁用成员
	 */
	String enable;
	/**
	 * 成员头像的mediaid，通过多媒体接口上传图片获得的mediaid
	 */
	String avatar_mediaid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIsleader() {
		return isleader;
	}
	public void setIsleader(String isleader) {
		this.isleader = isleader;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getEnglish_name() {
		return english_name;
	}
	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getAvatar_mediaid() {
		return avatar_mediaid;
	}
	public void setAvatar_mediaid(String avatar_mediaid) {
		this.avatar_mediaid = avatar_mediaid;
	}
	
	
	
	
}
