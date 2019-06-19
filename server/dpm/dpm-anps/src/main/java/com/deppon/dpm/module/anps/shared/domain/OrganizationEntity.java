package com.deppon.dpm.module.anps.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 *  组织机构实体类 + 组织人数
 * @author 276344
 *
 */
public class OrganizationEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4409637740522012381L;
	/**
	 * 该组织人数
	 */
	private Integer empNum;
	/**
	 * 组织编码
	 */
	private String orgCode;
	/**
	 * 组织等级
	 */
	private int orgLevel;
	/**
	 * 组织地址
	 */
	private String orgAddr;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 管理员id
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
	 * 组织区域
	 */
	private String area;
	/**
	 * remark
	 */
	private String remark;
	/**
	 * app系统编码
	 */
	private String appSysCode;
	/**
	 * 父组织id
	 */
	private int parentId;
	private String finaSysCode;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最近更新时间
	 */
	private Date lastUpdateTime;
	/**
	 * 组织id
	 */
	private int orgId;
	/**
	 * 组织姓名
	 */
	private String orgName;
	/**
	 * 起始
	 */
	private int start;
	/**
	 * 条数
	 */
	private int limit;
	/**
	 * 组织序列
	 */
	private String deptSeq;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getStart() {
		return start;
	}

	/**
	 * set
	 * 
	 * @param start
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * set
	 * 
	 * @param limit
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * toString
	 */
	public String toString() {
		return JSON.toJSONString(this);
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
	 * get
	 * 
	 * @return
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * set
	 * 
	 * @param parentId
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
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
	 * get
	 * 
	 * @return
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * set
	 * 
	 * @param lastUpdateTime
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDeptSeq() {
		return deptSeq;
	}

	public void setDeptSeq(String deptSeq) {
		this.deptSeq = deptSeq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getEmpNum() {
		return empNum;
	}

	public void setEmpNum(Integer empNum) {
		this.empNum = empNum;
	}

}
