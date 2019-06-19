package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 下班班车实体类
 * @author 曹嵩
 * @date 2015.6.16
 *
 */
public class BusAfterWork implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 下班编号
	 */
	private int afterWorkId;
	/**
	 * 下班时间
	 */
	private Date afterWorkTime;
	/**
	 * 下班起始站
	 */
	private String afterWorkStartStation;
	/**
	 * 下班终点站
	 */
	private String afterWorkEndStation;
	/**
	 * 下班途径站
	 */
	private String afterWorkWayStation;
	/**
	 * 下班供应商
	 */
	private String afterWorkSupplier;
	/**
	 * 下班联系人
	 */
	private String afterWorkContacts;
	/**
	 * 是否删除  0:未删除1:已删除(默认为未删除)
	 */
	private int afterWorkDel;

	/**
	 * @return 下班编号
	 */
	public int getAfterWorkId() {
		return afterWorkId;
	}

	/**
	 * @param afterWorkId 下班编号
	 */
	public void setAfterWorkId(int afterWorkId) {
		this.afterWorkId = afterWorkId;
	}

	/**
	 * @return 下班时间
	 */
	public Date getAfterWorkTime() {
		return afterWorkTime;
	}

	/**
	 * @param afterWorkTime 下班时间
	 */
	public void setAfterWorkTime(Date afterWorkTime) {
		this.afterWorkTime = afterWorkTime;
	}

	/**
	 * @return 下班途径站
	 */
	public String getAfterWorkStartStation() {
		return afterWorkStartStation;
	}

	/**
	 * @param afterWorkStartStation 下班途径站
	 */
	public void setAfterWorkStartStation(String afterWorkStartStation) {
		this.afterWorkStartStation = afterWorkStartStation;
	}

	/**
	 * @return 下班终点站
	 */
	public String getAfterWorkEndStation() {
		return afterWorkEndStation;
	}

	/**
	 * @param afterWorkEndStation 下班终点站
	 */
	public void setAfterWorkEndStation(String afterWorkEndStation) {
		this.afterWorkEndStation = afterWorkEndStation;
	}

	/**
	 * @return 下班途径站
	 */
	public String getAfterWorkWayStation() {
		return afterWorkWayStation;
	}

	/**
	 * @param afterWorkWayStation 下班途径站
	 */
	public void setAfterWorkWayStation(String afterWorkWayStation) {
		this.afterWorkWayStation = afterWorkWayStation;
	}

	public String getAfterWorkSupplier() {
		return afterWorkSupplier;
	}

	public void setAfterWorkSupplier(String afterWorkSupplier) {
		this.afterWorkSupplier = afterWorkSupplier;
	}

	public String getAfterWorkContacts() {
		return afterWorkContacts;
	}

	public void setAfterWorkContacts(String afterWorkContacts) {
		this.afterWorkContacts = afterWorkContacts;
	}

	public int getAfterWorkDel() {
		return afterWorkDel;
	}

	public void setAfterWorkDel(int afterWorkDel) {
		this.afterWorkDel = afterWorkDel;
	}

}
