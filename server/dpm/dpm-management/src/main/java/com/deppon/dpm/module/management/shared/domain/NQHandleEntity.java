package com.deppon.dpm.module.management.shared.domain;

/**
 * 常见问题对接人实体
 * @author 491275
 *
 */
public class NQHandleEntity {
	
	private int id;
	/**
	 * 姓名
	 */
	private String empName;
	/**
	 * 工号
	 */
	private String empCode;
	/**
	 * 内容
	 */
	private String Content;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	

}
