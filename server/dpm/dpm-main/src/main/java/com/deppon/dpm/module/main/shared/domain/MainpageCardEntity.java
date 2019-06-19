package com.deppon.dpm.module.main.shared.domain;

import java.util.Date;

/**
 * 首页卡片
 * @author 491275
 *
 */
public class MainpageCardEntity {
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 卡片编号
	 */
	private String cardNum;
	/**
	 * 卡片名
	 */
	private String cardName;
	/**
	 * 开关
	 */
	private String status;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "MainpageCardEntity [id=" + id + ", cardNum=" + cardNum
				+ ", cardName=" + cardName + ", status=" + status
				+ ", updateTime=" + updateTime + "]";
	}

}
