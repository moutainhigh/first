package com.deppon.dpm.module.announce.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class NormalQuestionHandleEntity extends BaseEntity {
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
	/**
	 * 头像地址
	 */
	private String pictPath;
	/**
	 * 姓别
	 */
	private String gender;
	/**
	 * get
	 * @return
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * set
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * get
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * set
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * get
	 * @return
	 */
	public String getContent() {
		return Content;
	}
	/**
	 * set
	 * @param content
	 */
	public void setContent(String content) {
		Content = content;
	}
	/**
	 * get
	 * @return
	 */
	public String getPictPath() {
		return pictPath;
	}
	/**
	 * set
	 * @param pictPath
	 */
	public void setPictPath(String pictPath) {
		this.pictPath = pictPath;
	}
	/**
	 * get
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * set
	 * @return
	 */
	public String getGender() {
		return gender;
	}

}
