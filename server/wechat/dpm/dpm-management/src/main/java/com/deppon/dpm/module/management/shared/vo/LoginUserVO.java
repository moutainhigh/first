package com.deppon.dpm.module.management.shared.vo;

import java.io.Serializable;

/**
 * 登陆用户信息
 * @author 王亚男
 *
 */
public class LoginUserVO implements Serializable {

	/**
	 * 可根据需要扩展字段
	 */
	private static final long serialVersionUID = -4804741712525716034L;
	
	//用户工号
	private String empcode;
	//用户姓名
	private String empname;
	//用户性别  f / m
	private String gender;
	//电话  测试 数据库 一般为空
	private String tel;
	//手机号 或  座机
	private String mobileno;
	//get set
	public String getEmpcode() {
		return empcode;
	}
	//get set
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	//get set
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	//get set
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//get set
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	//get set
	public String getMobileno() {
		return mobileno;
	}
	//get set
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
}
