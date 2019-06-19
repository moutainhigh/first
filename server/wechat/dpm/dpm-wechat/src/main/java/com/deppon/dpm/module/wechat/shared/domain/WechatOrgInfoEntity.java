package com.deppon.dpm.module.wechat.shared.domain;

public class WechatOrgInfoEntity {
	/**
	 * 部门id
	 */
	int orgid;
	/**
	 * 父部门id
	 */
	int parentOrgid;
	/**
	 * 部门编码
	 */
	String orgCode;
	/**
	 * 部门名称
	 */
	String orgName;
	/**
	 * 部门等级
	 */
	String orgLevel;
	/**
	 * 部门创建时间
	 */
	String createTime;
	/**
	 * 部门最后一次修改时间
	 */
	String lastUpdateDate;
	
	/**
	 * get
	 * @return
	 */
	public int getOrgid() {
		return orgid;
	}
	/**
	 * set
	 * @param orgid
	 */
	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}
	/**
	 * get
	 * @return
	 */
	public int getParentOrgid() {
		return parentOrgid;
	}
	/**
	 * set
	 * @param parentOrgid
	 */
	public void setParentOrgid(int parentOrgid) {
		this.parentOrgid = parentOrgid;
	}
	/**
	 * get
	 * @return
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * set
	 * @param orgCode
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * get
	 * @return
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * set
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * get
	 * @return
	 */
	public String getOrgLevel() {
		return orgLevel;
	}
	/**
	 * set
	 * @param orgLevel
	 */
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	/**
	 * get
	 * @return
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * set
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * get
	 * @return
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * set
	 * @param lastUpdateDate
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
}
