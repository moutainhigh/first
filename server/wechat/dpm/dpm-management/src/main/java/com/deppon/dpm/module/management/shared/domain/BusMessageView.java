package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 268101
 * 线路详细信息视图
 */
public class BusMessageView implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 线路id
	 */
	private int lineId;
	/**
	 * 线路名称
	 */
	private String lineName;
	
	/**
	 * 起始时间
	 */
	private Date startDate;
	/**
	 * 时间
	 */
	private String startTime;
	/**
	 * 站点id
	 */
	private int siteId;
	/**
	 * 站点名称
	 */
	private String siteName;
	/**
	 * 站点顺序
	 */
	private int siteSort;
	/**
	 * 站点是否启用标志位，0未启用，1启用
	 */
	private int isAct;
	/**
	 * 站点信息表主键id
	 */
	private int pkySiteId;
	/**
	 * 线路站点表主键id
	 */
	private int lineSiteId;
	/**
	 * 是否是起始站点标志位
	 */
	private int isStart;
	/**
	 * 是否是终点站点标志位
	 */
	private int isEnd;
	/**
	 * @return 是否是起始站点标志位
	 */
	public int getIsStart() {
		return isStart;
	}
	/**
	 * @param isStart 是否是起始站点标志位
	 */
	public void setIsStart(int isStart) {
		this.isStart = isStart;
	}
	/**
	 * @return 是否是终点站点标志位
	 */
	public int getIsEnd() {
		return isEnd;
	}
	/**
	 * @param isEnd 是否是终点站点标志位
	 */
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}
	/**
	 * @return 线路站点表主键id
	 */
	public int getLineSiteId() {
		return lineSiteId;
	}
	/**
	 * @param lineSiteId 线路站点表主键id
	 */
	public void setLineSiteId(int lineSiteId) {
		this.lineSiteId = lineSiteId;
	}
	/**
	 * @return 站点信息表主键id
	 */
	public int getPkySiteId() {
		return pkySiteId;
	}
	/**
	 * @param pkySiteId 站点信息表主键id
	 */
	public void setPkySiteId(int pkySiteId) {
		this.pkySiteId = pkySiteId;
	}
	/**
	 * @return 线路名称
	 */
	public String getLineName() {
		return lineName;
	}
	/**
	 * @param lineName 线路名称
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	/**
	 * @return 起始时间
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate 起始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return 时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime 时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
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
	 * @return 线路id
	 */
	public int getLineId() {
		return lineId;
	}
	/**
	 * @param lineId 线路id
	 */
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	/**
	 * @return 站点id
	 */
	public int getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId 站点id
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return 站点顺序
	 */
	public int getSiteSort() {
		return siteSort;
	}
	/**
	 * @param siteSort 站点顺序
	 */
	public void setSiteSort(int siteSort) {
		this.siteSort = siteSort;
	}
	/**
	 * @return 站点是否启用标志位，0未启用，1启用
	 */
	public int getIsAct() {
		return isAct;
	}
	/**
	 * @param isAct 站点是否启用标志位，0未启用，1启用
	 */
	public void setIsAct(int isAct) {
		this.isAct = isAct;
	}
	
	
	
	

}
