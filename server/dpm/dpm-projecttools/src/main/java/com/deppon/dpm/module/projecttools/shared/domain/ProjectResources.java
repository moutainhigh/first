package com.deppon.dpm.module.projecttools.shared.domain;

import java.math.BigDecimal;

public class ProjectResources {

	private String empRole;//人员构成 2
	private String bandCnt;//各 band 人数 1
	private int manDay;//人天数 3
	private BigDecimal rolePrice;//角色成本 6
	private BigDecimal unitPrice;//合同单价 4
	private BigDecimal packPrice;//打包费用 8
	private String costSummary;//成本说明 5
	private BigDecimal allProce;//总金额 7
	private String cflag;//哪方公司
	/**
	 * @return the empRole
	 */
	public String getEmpRole() {
		return empRole;
	}
	/**
	 * @param empRole the empRole to set
	 */
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	/**
	 * @return the bandCnt
	 */
	public String getBandCnt() {
		return bandCnt;
	}
	/**
	 * @param bandCnt the bandCnt to set
	 */
	public void setBandCnt(String bandCnt) {
		this.bandCnt = bandCnt;
	}
	/**
	 * @return the manDay
	 */
	public int getManDay() {
		return manDay;
	}
	/**
	 * @param manDay the manDay to set
	 */
	public void setManDay(int manDay) {
		this.manDay = manDay;
	}
	/**
	 * @return the rolePrice
	 */
	public BigDecimal getRolePrice() {
		return rolePrice;
	}
	/**
	 * @param rolePrice the rolePrice to set
	 */
	public void setRolePrice(BigDecimal rolePrice) {
		this.rolePrice = rolePrice;
	}
	/**
	 * @return the unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the packPrice
	 */
	public BigDecimal getPackPrice() {
		return packPrice;
	}
	/**
	 * @param packPrice the packPrice to set
	 */
	public void setPackPrice(BigDecimal packPrice) {
		this.packPrice = packPrice;
	}
	/**
	 * @return the costSummary
	 */
	public String getCostSummary() {
		return costSummary;
	}
	/**
	 * @param costSummary the costSummary to set
	 */
	public void setCostSummary(String costSummary) {
		this.costSummary = costSummary;
	}
	/**
	 * @return the allProce
	 */
	public BigDecimal getAllProce() {
		return allProce;
	}
	/**
	 * @param allProce the allProce to set
	 */
	public void setAllProce(BigDecimal allProce) {
		this.allProce = allProce;
	}
	/**
	 * @return the cflag
	 */
	public String getCflag() {
		return cflag;
	}
	/**
	 * @param cflag the cflag to set
	 */
	public void setCflag(String cflag) {
		this.cflag = cflag;
	}
	
	
	
}
