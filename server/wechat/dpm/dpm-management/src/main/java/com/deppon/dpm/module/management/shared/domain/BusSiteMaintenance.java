package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 上班站点维护实体类
 * 
 * @author 曹嵩
 * @date 2015.6.16
 * 
 */
public class BusSiteMaintenance implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 上班站点维护ID
	 */
	private int goWorkSiteId;
	/**
	 * 上班站点名称
	 */
	private String goWorkSiteName;
	/**
	 * 上班站点地址
	 */
	private String goWorkSiteAddress;
	/**
	 * 上班站点是否开通 0:已开通1:未开通(默认为未开通)
	 */
	private int goWorkSiteIsOpen;
	/**
	 * 下班站点是否开通 0:已开通1:未开通(默认为未开通)
	 */
	private int afterWorkSiteIsOpen;

	/**
	 * @return 上班站点维护ID
	 */
	public int getGoWorkSiteId() {
		return goWorkSiteId;
	}

	/**
	 * @param goWorkSiteId
	 *            上班站点维护ID
	 */
	public void setGoWorkSiteId(int goWorkSiteId) {
		this.goWorkSiteId = goWorkSiteId;
	}

	/**
	 * @return 上班站点名称
	 */
	public String getGoWorkSiteName() {
		return goWorkSiteName;
	}

	/**
	 * @param goWorkSiteName
	 *            上班站点名称
	 */
	public void setGoWorkSiteName(String goWorkSiteName) {
		this.goWorkSiteName = goWorkSiteName;
	}

	/**
	 * @return 上班站点地址
	 */
	public String getGoWorkSiteAddress() {
		return goWorkSiteAddress;
	}

	/**
	 * @param goWorkSiteAddress
	 *            上班站点地址
	 */
	public void setGoWorkSiteAddress(String goWorkSiteAddress) {
		this.goWorkSiteAddress = goWorkSiteAddress;
	}

	/**
	 * @return 上班站点是否开通 0:已开通1:未开通(默认为未开通)
	 */
	public int getGoWorkSiteIsOpen() {
		return goWorkSiteIsOpen;
	}

	/**
	 * @param goWorkSiteIsOpen
	 *            上班站点是否开通 0:已开通1:未开通(默认为未开通)
	 */
	public void setGoWorkSiteIsOpen(int goWorkSiteIsOpen) {
		this.goWorkSiteIsOpen = goWorkSiteIsOpen;
	}

	/**
	 * @return 下班站点是否开通 0:已开通1:未开通(默认为未开通)
	 */
	public int getAfterWorkSiteIsOpen() {
		return afterWorkSiteIsOpen;
	}

	/**
	 * @param afterWorkSiteIsOpen
	 *            下班站点是否开通 0:已开通1:未开通(默认为未开通)
	 */
	public void setAfterWorkSiteIsOpen(int afterWorkSiteIsOpen) {
		this.afterWorkSiteIsOpen = afterWorkSiteIsOpen;
	}

}
