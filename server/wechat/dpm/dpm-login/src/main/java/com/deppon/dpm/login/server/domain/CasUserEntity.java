package com.deppon.dpm.login.server.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 单点验证用户实体
 */
public class CasUserEntity {

	/**
	 * 职员姓名
	 */
	private String empName;

	/**
	 * 登陆名-工号
	 */
	private String loginName;

	/**
	 * 工号
	 */
	private String empCode;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 部门标杆编码
	 */
	private String unifieldCode;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 角色集合
	 */
	private List<String> roleCodes = new ArrayList<String>();
	/**
	 * cookie
	 */
	private String cookie;
	/**
	 * sessionId
	 */
	private String casSessionId;
	/**
	 * 职位
	 */
	private String position;
	/**
	 * 是否返回
	 */
	private String isReturn;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * set
	 * 
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * set
	 * 
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * set
	 * 
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * set
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUnifieldCode() {
		return unifieldCode;
	}

	/**
	 * set
	 * 
	 * @param unifieldCode
	 */
	public void setUnifieldCode(String unifieldCode) {
		this.unifieldCode = unifieldCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * set
	 * 
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<String> getRoleCodes() {
		return roleCodes;
	}

	/**
	 * set
	 * 
	 * @param roleCodes
	 */
	public void setRoleCodes(List<String> roleCodes) {
		this.roleCodes = roleCodes;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * set
	 * 
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIsReturn() {
		return isReturn;
	}

	/**
	 * set
	 * 
	 * @param isReturn
	 */
	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * set
	 * 
	 * @param cookie
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCasSessionId() {
		return casSessionId;
	}

	/**
	 * set
	 * 
	 * @param casSessionId
	 */
	public void setCasSessionId(String casSessionId) {
		this.casSessionId = casSessionId;
	}
}
