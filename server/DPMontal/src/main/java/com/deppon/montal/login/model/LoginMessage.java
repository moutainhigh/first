package com.deppon.montal.login.model;

import java.util.Date;
/**
 * 
* @title: LoginMessage 
* @description：登陆信息记录实体
* @author： 何玲菠
* @date： 2014-2-18 下午5:04:04
 */
public class LoginMessage {
	/**
	 * id
	 */
	long id ;
	/**
	 * 工号
	 */
	String userId;
	/**
	 * 姓名
	 */
	String userName;
	/**
	 * 登陆时间
	 */
	Date loginDate;
	
	public LoginMessage(long id , String userId , String userName , Date loginDate){
		this.id = id ;
		this.userId = userId;
		this.userName = userName;
		this.loginDate = loginDate;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the loginDate
	 */
	public Date getLoginDate() {
		return loginDate;
	}
	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}	
}
