package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 上班班车实体类
 * @author 曹嵩
 * @date 2015.6.16
 *
 */
public class BusGoWork implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 上班编号
	 */
	private int goWorkId;
	/**
	 * 上班时间
	 */
	private Date goWorkTime;
	/**
	 * 上班起始站点
	 */
	private String goWorkStartStation;
	/**
	 * 上班终点站点
	 */
	private String goWorkEndStation;
	/**
	 * 上班途径站
	 */
	private String goWorkWayStation;
	/**
	 * 上班供应商
	 */
	private String goWorkSupplier;
	/**
	 * 上班联系人
	 */
	private String goWorkContacts;
	/**
	 * 是否删除   0:未删除1:已删除(默认为未删除)
	 */
	private int goWorkDel;

	/**
	 * @return 上班编号
	 */
	public int getGoWorkId() {
		return goWorkId;
	}

	/**
	 * @param goWorkId 上班编号
	 */
	public void setGoWorkId(int goWorkId) {
		this.goWorkId = goWorkId;
	}

	/** 
	 * @return 上班时间
	 */
	public Date getGoWorkTime() {
		return goWorkTime;
	}

	/**
	 * @param goWorkTime 上班时间
	 */
	public void setGoWorkTime(Date goWorkTime) {
		this.goWorkTime = goWorkTime;
	}

	/**
	 * @return 上班起始站点
	 */
	public String getGoWorkStartStation() {
		return goWorkStartStation;
	}

	/**
	 * @param goWorkStartStation 上班起始站点
	 */
	public void setGoWorkStartStation(String goWorkStartStation) {
		this.goWorkStartStation = goWorkStartStation;
	}

	/**
	 * @return 上班终点站点
	 */
	public String getGoWorkEndStation() {
		return goWorkEndStation;
	}

	/**
	 * @param goWorkEndStation 上班终点站点
	 */
	public void setGoWorkEndStation(String goWorkEndStation) {
		this.goWorkEndStation = goWorkEndStation;
	}

	/**
	 * @return 上班途径站
	 */
	public String getGoWorkWayStation() {
		return goWorkWayStation;
	}

	/**
	 * @param goWorkWayStation 上班途径站
	 */
	public void setGoWorkWayStation(String goWorkWayStation) {
		this.goWorkWayStation = goWorkWayStation;
	}

	/**
	 * @return  上班供应商
	 */
	public String getGoWorkSupplier() {
		return goWorkSupplier;
	}

	/**
	 * @param goWorkSupplier  上班供应商
	 */
	public void setGoWorkSupplier(String goWorkSupplier) {
		this.goWorkSupplier = goWorkSupplier;
	}

	public String getGoWorkContacts() {
		return goWorkContacts;
	}

	public void setGoWorkContacts(String goWorkContacts) {
		this.goWorkContacts = goWorkContacts;
	}

	/**
	 * @return 是否删除   0:未删除1:已删除(默认为未删除)
	 */
	public int getGoWorkDel() {
		return goWorkDel;
	}

	/**
	 * @param goWorkDel 是否删除   0:未删除1:已删除(默认为未删除)
	 */
	public void setGoWorkDel(int goWorkDel) {
		this.goWorkDel = goWorkDel;
	}

}
