package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 收发室实体类
 * @author 274858
 *
 */
public class MailReceiveSendFunctionEntity implements Serializable{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = -9044054257071854355L;
	
	
	/*
	 *  packagesId         Long          主键ID(唯一)

     enterTime 		String        入库时间

     personName  	String        员工姓名

     personCode		String        员工工号
	 */
	
	private Long packagesId;// 主键ID(唯一)
	private String personName;// 员工姓名
	private String personCode;// 员工工号
	private String enterTime;//时间
	private int state;//状态
	private int postStatus;//代理状态
	private int parcelState;// 包裹状态
	private String userNo;//工号
	private String userName;//姓名
	private int status;//pc返回值
	private String message;//消息
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
	 * @return  员工姓名
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName  员工姓名
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return 员工工号
	 */
	public String getPersonCode() {
		return personCode;
	}
	/**
	 * @param personCode 员工工号
	 */
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	/**
	 * @return 时间
	 */
	public String getEnterTime() {
		return enterTime;
	}
	/**
	 * @param enterTime 时间
	 */
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
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
	/**
	 * @return 代理状态
	 */
	public int getPostStatus() {
		return postStatus;
	}
	/**
	 * @param postStatus 代理状态
	 */
	public void setPostStatus(int postStatus) {
		this.postStatus = postStatus;
	}
	public int getParcelState() {
		return parcelState;
	}
	public void setParcelState(int parcelState) {
		this.parcelState = parcelState;
	}
	/**
	 * @return 用户工号
	 */
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 组装字符串
	 */
	@Override
	public String toString() {
		return "MailReceiveSendFunctionEntity [packagesId=" + packagesId
				+ ", personName=" + personName + ", personCode=" + personCode
				+ ", enterTime=" + enterTime + ", state=" + state
				+ ", postStatus=" + postStatus + ", parcelState=" + parcelState
				+ ", userNo=" + userNo + ", userName=" + userName + ", status="
				+ status + ", message=" + message + "]";
	}
	
	
	
	
	
	

}
