package com.deppon.dpm.module.management.shared.vo;

import java.io.Serializable;

/**
 * @author 268101 员工表
 *
 */
public class EmpVO implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields empId 员工表主键ID
	*/ 
	private Integer empId=0;
	/** 
	* @Fields empCode 员工工号
	*/ 
	private String empCode="";
	/** 
	* @Fields empName 员工名称
	*/ 
	private String empName="";
	
	/** 
	* @Fields orgName 部门名称
	*/ 
	private String orgName;
	
	/** 
	* @Fields mobileno 手机号
	*/ 
	private String mobileno;
	
	//get set 
	public String getOrgName() {
		return orgName;
	}
	//get set 
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	//get set 
	public Integer getEmpId() {
		return empId;
	}
	//get set 
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	//get set 
	public String getEmpCode() {
		return empCode;
	}
	//get set 
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	//get set 
	public String getEmpName() {
		return empName;
	}
	//get set 
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	//构造方法
	public EmpVO(String empCode, String empName) {
		this.empCode = empCode;
		this.empName = empName;
	}
	
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	//构造方法
	public EmpVO() {		
	}	
		
}
