package com.deppon.dpm.tongxunlu.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 由于阿狸JSON的局限性，另用一个类封装参数
 * 
 * @author 231586
 * @date 2015-09-15
 */
public class BootyEntity extends BaseEntity {

	private static final long serialVersionUID = -4996763498105205322L;
	// 工号
	private String userId;
	// 姓名
	private String name;
	// 头像
	private String headImage;
	// 电话
	private String telNumber;
	// 组织
	private String orgName;
	// 性别
	private String gender;

	// get
	public String getUserId() {
		return userId;
	}

	// set
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// get
	public String getName() {
		return name;
	}

	// set
	public void setName(String name) {
		this.name = name;
	}

	// get
	public String getHeadImage() {
		return headImage;
	}

	// set
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	// get
	public String getTelNumber() {
		return telNumber;
	}

	// set
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	// get
	public String getOrgName() {
		return orgName;
	}

	// set
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	// get
	public String getGender() {
		return gender;
	}

	// set
	public void setGender(String gender) {
		this.gender = gender;
	}

	public BootyEntity() {
		super();
	}

	// Constructor
	public BootyEntity(String userId, String name, String headImage,
			String telNumber, String orgName, String gender) {
		super();
		this.userId = userId;
		this.name = name;
		this.headImage = headImage;
		this.telNumber = telNumber;
		this.orgName = orgName;
		this.gender = gender;
	}

}
