/**
 * Project Name:dpm-tongxunlu
 * File Name:OrganizationEntity.java
 * Package Name:com.deppon.dpm.tongxunlu.shared.domain
 * Date:2014-8-8上午10:58:46
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

/**
 * 组织机构Entity ClassName:OrganizationEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date: 2014-8-8 上午10:58:46 <br/>
 * 
 * @author 157229-zxy
 * @version
 * @since JDK 1.6
 */
public class OrganizationEntity {
	/**
	 * 组织id
	 */
	private int orgId;
	/**
	 * 组织编码
	 */
	private String orgCode;
	/**
	 * 组织姓名
	 */
	private String orgName;
	/**
	 * 组织等级
	 */
	private int orgLevel;
	/**
	 * 父组织id
	 */
	private int parentOrgId;
	/**
	 * 组织地址
	 */
	private String orgAddr;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 管理者工号
	 */
	private String managerId;
	/**
	 * 联系电话
	 */
	private String linkTel;
	/**
	 * 组织邮箱
	 */
	private String email;
	/**
	 * 区域
	 */
	private String area;
	private String remark;
	/**
	 * app系统编码
	 */
	private String appSysCode;
	/**
	 * 父组织编码
	 */
	private String parentCompCode;
	/**
	 * 组织特征
	 */
	private String orgProperty;
	private String finaSysCode;
	/**
	 * 组织序列关系
	 */
	private String deptSeq;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 上次更新时间
	 */
	private Date lastUpdate;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getOrgId() {
		return orgId;
	}

	/**
	 * set
	 * 
	 * @param orgId
	 */
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * set
	 * 
	 * @param orgCode
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * set
	 * 
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getOrgLevel() {
		return orgLevel;
	}

	/**
	 * set
	 * 
	 * @param orgLevel
	 */
	public void setOrgLevel(int orgLevel) {
		this.orgLevel = orgLevel;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getParentOrgId() {
		return parentOrgId;
	}

	/**
	 * set
	 * 
	 * @param parentOrgId
	 */
	public void setParentOrgId(int parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrgAddr() {
		return orgAddr;
	}

	/**
	 * set
	 * 
	 * @param orgAddr
	 */
	public void setOrgAddr(String orgAddr) {
		this.orgAddr = orgAddr;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * set
	 * 
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getManagerId() {
		return managerId;
	}

	/**
	 * set
	 * 
	 * @param managerId
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLinkTel() {
		return linkTel;
	}

	/**
	 * set
	 * 
	 * @param linkTel
	 */
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getArea() {
		return area;
	}

	/**
	 * set
	 * 
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * set
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getParentCompCode() {
		return parentCompCode;
	}

	/**
	 * set
	 * 
	 * @param parentCompCode
	 */
	public void setParentCompCode(String parentCompCode) {
		this.parentCompCode = parentCompCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrgProperty() {
		return orgProperty;
	}

	/**
	 * set
	 * 
	 * @param orgProperty
	 */
	public void setOrgProperty(String orgProperty) {
		this.orgProperty = orgProperty;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFinaSysCode() {
		return finaSysCode;
	}

	/**
	 * set
	 * 
	 * @param finaSysCode
	 */
	public void setFinaSysCode(String finaSysCode) {
		this.finaSysCode = finaSysCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * set
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * ge
	 * 
	 * @rteturn
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * set
	 * 
	 * @param lastUpdate
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppSysCode() {
		return appSysCode;
	}

	/**
	 * set
	 * 
	 * @param appSysCode
	 */
	public void setAppSysCode(String appSysCode) {
		this.appSysCode = appSysCode;
	}

	/**
	 * getter
	 * @return
	 */
	public String getDeptSeq() {
		return deptSeq;
	}

	/**
	 * setter
	 * @param deptSeq
	 */
	public void setDeptSeq(String deptSeq) {
		this.deptSeq = deptSeq;
	}

}
