package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 建议站点表和开线建议表联合查询后的实体类
 * @author 曹嵩
 * @date 2015.7.1
 */
public class BusOpenLineAndNewsSiteEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 站点名称
	 */
	private String siteName;
	
	/**
	 * 站点是否开通   0:表示未开通，1:表示已开通
	 */
	private int isAct;
	
	/**
	 * 员工工号
	 */
	private String userNo;
	
	/**
	 * 点击量
	 */
	private int hits;
	
	/**
	 * 站点id(bus_open_line表的ID)
	 */
	private int siteId;
	
	/**
	 * 站点ID(bus_news_site)
	 */
	private int id;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 创建时间的String类型
	 */
	private String strDate;

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
	 * @return 站点是否开通   0:表示未开通，1:表示已开通
	 */
	public int getIsAct() {
		return isAct;
	}

	/**
	 * @param isAct 站点是否开通   0:表示未开通，1:表示已开通
	 */
	public void setIsAct(int isAct) {
		this.isAct = isAct;
	}

	/**
	 * @return 员工工号
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo 员工工号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return 点击量
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * @param hits 点击量
	 */
	public void setHits(int hits) {
		this.hits = hits;
	}

	/**
	 * @return 站点id(bus_open_line表的ID)
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId 站点id(bus_open_line表的ID)
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	

}
