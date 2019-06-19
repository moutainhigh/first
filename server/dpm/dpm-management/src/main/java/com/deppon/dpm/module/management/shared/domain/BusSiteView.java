package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 站点视图
 * @author 曹嵩
 * @date 2015.6.18
 *  
 */
public class BusSiteView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 站点ID
	 */
	private int siteId;
	/**
	 * 上下班站点路线ID
	 */
	private int id;
	/**
	 * 站点名称
	 */
	private String siteName;
	/**
	 * 是否上班路线 0:上班状态1:下班状态
	 */
	private int isGoWork;
	/**
	 * 是否开通 0:未开通1:已开通
	 */
	private int isAct;
	
	/**
	 * 显示的时间String类型
	 */
	private String timeStr;
	
	/**
	 * 显示的时间
	 */
	private Date timeDate;
	
	
	/**
	 * @return 显示的时间String类型
	 */
	public String getTimeStr() {
		return timeStr;
	}
	/**
	 * @param timeStr 显示的时间String类型
	 */
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	/**
	 * @return  显示的时间
	 */
	public Date getTimeDate() {
		return timeDate;
	}
	/**
	 * @param timeDate 显示的时间
	 */
	public void setTimeDate(Date timeDate) {
		this.timeDate = timeDate;
	}
	/**
	 * @return 站点ID
	 */
	public int getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId 站点ID
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return 主键id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 主键id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return 站点名称
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * @param siteName 站点名称
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * @return 是否上班路线 0:上班状态1:下班状态
	 */
	public int getIsGoWork() {
		return isGoWork;
	}
	/**
	 * @param isGoWork 是否上班路线 0:上班状态1:下班状态
	 */
	public void setIsGoWork(int isGoWork) {
		this.isGoWork = isGoWork;
	}
	/**
	 * @return 标志位
	 */
	public int getIsAct() {
		return isAct;
	}
	/**
	 * @param isAct  标志位
	 */
	public void setIsAct(int isAct) {
		this.isAct = isAct;
	}

}
