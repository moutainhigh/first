package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 收发室消息通知表
 * 
 * @author ccf
 * @date 2015.11.14
 * 
 */
public class SendParcelNewsEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private int pushId;
	/**
	 * 用户工号
	 */
	private String userNo;
	/**
	 * 消息通知内容
	 */
	private String content;
	/**
	 * 包裹状态时间
	 */
	private String statusTime;

	/**
	 * 更新时间
	 */
	private String updateTime;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 包裹状态 库存中（0），已签收（1），已拒收（2），已注销（3） ,催领（4）
	 */
	private int status;
	/**
	 * 包裹状态 0==未发送 ；1==已发送
	 */
	private int mark;

	

	/**
	 * @return pushId
	 */
	public int getPushId() {
		return pushId;
	}

	/**
	 * @param pushId 主键id
	 */
	public void setPushId(int pushId) {
		this.pushId = pushId;
	}

	/**
	 * @return userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo 用户工号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content 内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return 包裹状态时间
	 */
	public String getStatusTime() {
		return statusTime;
	}

	/**
	 * @param statusTime 包裹状态时间
	 */
	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}

	/**
	 * @return 更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/** 
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return 创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime 创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 包裹状态
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status 包裹状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return 包裹状态
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * @param mark 包裹状态
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

}
