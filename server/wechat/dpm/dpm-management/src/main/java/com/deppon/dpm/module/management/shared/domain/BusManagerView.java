package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 268101 ccf 班车管理，路线调整，视图
 */
public class BusManagerView implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 线路id
	 */
	private long lineId;
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
	
    // get set
	public Date getStartDate() {
		return startDate;
	}
	// get set
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	// get set
	public String getStartTime() {
		return startTime;
	}
	// get set
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 起始名称
	 */
	private String stratName;
	/**
	 * 名称
	 */
	private String startName;
	// get set
	public String getStartName() {
		return startName;
	}
	// get set
	public void setStartName(String startName) {
		this.startName = startName;
	}

	/**
	 * 终点名称
	 */
	private String endName;
	/**
	 * 站点id
	 */
	private long siteId;
	// get set
	public long getLineId() {
		return lineId;
	}
	// get set
	public void setLineId(long lineId) {
		this.lineId = lineId;
	}
	// get set
	public String getLineName() {
		return lineName;
	}
	// get set
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	// get set
	public String getStratName() {
		return stratName;
	}
	// get set
	public void setStratName(String stratName) {
		this.stratName = stratName;
	}
	// get set
	public String getEndName() {
		return endName;
	}
	// get set
	public void setEndName(String endName) {
		this.endName = endName;
	}
	// get set
	public long getSiteId() {
		return siteId;
	}
	// get set
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

}
