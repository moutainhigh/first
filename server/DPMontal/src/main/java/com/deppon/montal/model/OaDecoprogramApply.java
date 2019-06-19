/**
 * 
 */
package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;

/**
 * 
 * @yin 装修工程申请
 *
 */
public class OaDecoprogramApply {
	
	private BigDecimal processinstid;
	
	//申请人
	private String name;
	
	//申请人empid
	private BigDecimal empid;
	
	//新点开设工作流号
	private String newapplyno;
	
	//部门名称
	private String deptname;
	
	//部门经理
	private String deptmanager;
	
	//所属大区
	private String area;
	
	//所属区域
	private String enterprisedept;
	
	//所属区域orgcode
	private String enterprisedeptcode;
	
	//合同签订情况
	private String issignedpact;
	
	//图纸方案是否符合需求
	private String isrightdrawing;
	
	//入场日期
	private String admittancedate;
	
	//预算费用
	private BigDecimal budgetcost;
	
	//申请事由
	private String reason;
	
	//维修类型
	private String maintenancetype;

	public BigDecimal getProcessinstid() {
		return processinstid;
	}

	public void setProcessinstid(BigDecimal processinstid) {
		this.processinstid = processinstid;
	}

	public String getName() {
		return F_Constants.chageNull(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getEmpid() {
		return empid;
	}

	public void setEmpid(BigDecimal empid) {
		this.empid = empid;
	}

	public String getNewapplyno() {
		return F_Constants.chageNull(newapplyno);
	}

	public void setNewapplyno(String newapplyno) {
		this.newapplyno = newapplyno;
	}

	public String getDeptname() {
		return F_Constants.chageNull(deptname);
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptmanager() {
		return F_Constants.chageNull(deptmanager);
	}

	public void setDeptmanager(String deptmanager) {
		this.deptmanager = deptmanager;
	}

	public String getArea() {
		return F_Constants.chageNull(area);
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEnterprisedept() {
		return F_Constants.chageNull(enterprisedept);
	}

	public void setEnterprisedept(String enterprisedept) {
		this.enterprisedept = enterprisedept;
	}

	public String getEnterprisedeptcode() {
		return F_Constants.chageNull(enterprisedeptcode);
	}

	public void setEnterprisedeptcode(String enterprisedeptcode) {
		this.enterprisedeptcode = enterprisedeptcode;
	}

	public String getIssignedpact() {
		return F_Constants.chageNull(issignedpact);
	}

	public void setIssignedpact(String issignedpact) {
		this.issignedpact = issignedpact;
	}

	public String getIsrightdrawing() {
		return F_Constants.chageNull(isrightdrawing);
	}

	public void setIsrightdrawing(String isrightdrawing) {
		this.isrightdrawing = isrightdrawing;
	}

	public String getAdmittancedate() {
		return F_Constants.chageNull(admittancedate);
	}

	public void setAdmittancedate(String admittancedate) {
		this.admittancedate = admittancedate;
	}

	public BigDecimal getBudgetcost() {
		return budgetcost;
	}

	public void setBudgetcost(BigDecimal budgetcost) {
		this.budgetcost = budgetcost;
	}

	public String getReason() {
		return F_Constants.chageNull(reason);
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMaintenancetype() {
		return F_Constants.chageNull(maintenancetype);
	}

	public void setMaintenancetype(String maintenancetype) {
		this.maintenancetype = maintenancetype;
	}
	
	
	
}
