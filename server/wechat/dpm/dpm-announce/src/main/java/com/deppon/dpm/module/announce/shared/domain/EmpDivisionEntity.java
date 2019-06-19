package com.deppon.dpm.module.announce.shared.domain;

import java.io.Serializable;
import java.util.Date;

public class EmpDivisionEntity implements Serializable{
	//序列化id
	private static final long serialVersionUID = 4174498066177043601L;
	//id
	private Integer id;
	//工号
	private String empCode;
	//更新时间
	private Date updateTime;
	//所在事业部
	private String division;
	//所在当前部门序列
	private String currentDeptSeq;
	//所在部门序列
	private String deptSeq;
	//getter
	public Integer getId() {
		return id;
	}
	//setter
	public void setId(Integer id) {
		this.id = id;
	}
	//getter
	public String getEmpCode() {
		return empCode;
	}
	//setter
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	//getter
	public Date getUpdateTime() {
		return updateTime;
	}
	//setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//getter
	public String getDivision() {
		return division;
	}
	//setter
	public void setDivision(String division) {
		this.division = division;
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
	public String getCurrentDeptSeq() {
		return currentDeptSeq;
	}
	public void setCurrentDeptSeq(String currentDeptSeq) {
		this.currentDeptSeq = currentDeptSeq;
	}
}
