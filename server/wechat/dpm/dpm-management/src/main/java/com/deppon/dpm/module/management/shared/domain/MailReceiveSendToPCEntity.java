package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author 274858
 * 专门序列化数据到PC
 */
public class MailReceiveSendToPCEntity implements Serializable {

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 6979719568522228862L;
	
	
	private Long packagesId;// 主键ID(唯一)
	private String personName;// 员工姓名
	private String personCode;// 员工工号
	private int state;//状态
	/**
	 * @return 主键ID(唯一)
	 */
	public Long getPackagesId() {
		return packagesId;
	}
	/**
	 * @param packagesId 主键ID(唯一)
	 */
	public void setPackagesId(Long packagesId) {
		this.packagesId = packagesId;
	}
	/**
	 * @return 员工姓名
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName 员工姓名
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return  员工工号
	 */
	public String getPersonCode() {
		return personCode;
	}
	/**
	 * @param personCode  员工工号
	 */
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	/**
	 * @return 状态
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state 状态
	 */
	public void setState(int state) {
		this.state = state;
	}
	@Override
	//组装字符串
	public String toString() {
		return "MailReceiveSendToPCEntity [packagesId=" + packagesId
				+ ", personName=" + personName + ", personCode=" + personCode
				+ ", state=" + state + "]";
	}

	
	
}
