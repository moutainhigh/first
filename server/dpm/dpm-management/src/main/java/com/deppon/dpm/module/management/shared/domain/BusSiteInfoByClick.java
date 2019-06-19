package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 班车点击站点显示详情实体类
 * @author 曹嵩
 * @date 2015.6.24
 *
 */
public class BusSiteInfoByClick implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 站点编号id
	 */
	private int id ;
	
	/**
	 * 站点名称
	 */
	private String siteName;
	
	/**
	 * 站点地址
	 */
	private String address;
	
	/**
	 * 途径时间String类型
	 */
	private String routeTimestr;
	
	/**
	 * 途径时间
	 */
	private Date routeTime;
	
	/**
	 * 页面传过来的当前时间类型(AM:上班 PM:下班)
	 */
	private String timeType;
	
	/**
	 * 起始时间String类型
	 */
	private String startDatestr;
	
	/**
	 * 起始时间
	 */
	private Date startDate;
	
	/**
	 * 线路编号
	 */
	private int lineId;
	
	/**
	 * 线路名称
	 */
	private String lineName;
	
	/**
	 * 起点站名称
	 */
	private String startName;
	
	/**
	 * 终点站名称
	 */
	private String endName;
	
	/**
	 * 站点id
	 */
	private int siteId;
	
	/**
	 * 供应商
	 */
	private String applyName;
	
	/**
	 * 联系人
	 */
	private String userName;
	
	/**
	 * 联系电话
	 */
	private String tel;
	
	/**
	 * 存储线路详细信息
	 */
	private String lineInfo;
	
	/**
	 * @return 存储线路详细信息
	 */
	public String getLineInfo() {
		return lineInfo;
	}
	/**
	 * @param lineInfo 存储线路详细信息
	 */
	public void setLineInfo(String lineInfo) {
		this.lineInfo = lineInfo;
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
	 * @return 站点地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 站点地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return 页面传过来的当前时间类型(AM:上班 PM:下班)
	 */
	public String getTimeType() {
		return timeType;
	}

	/**
	 * @param timeType 页面传过来的当前时间类型(AM:上班 PM:下班)
	 */
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	/**
	 * @return 起始时间String类型
	 */
	public String getStartDatestr() {
		return startDatestr;
	}

	/**
	 * @param startDatestr 起始时间String类型
	 */
	public void setStartDatestr(String startDatestr) {
		this.startDatestr = startDatestr;
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
	 * @return 线路编号
	 */
	public int getLineId() {
		return lineId;
	}

	/**
	 * @param lineId 线路编号
	 */
	public void setLineId(int lineId) {
		this.lineId = lineId;
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
	 * @return 起点名称
	 */
	public String getStartName() {
		return startName;
	}

	/**
	 * @param startName 起点名称
	 */
	public void setStartName(String startName) {
		this.startName = startName;
	}

	/**
	 * @return 终点名称
	 */
	public String getEndName() {
		return endName;
	}

	/**
	 * @param endName 终点名称
	 */
	public void setEndName(String endName) {
		this.endName = endName;
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

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return 途径时间str
	 */
	public String getRouteTimestr() {
		return routeTimestr;
	}

	/**
	 * @param routeTimestr 途径时间str
	 */
	public void setRouteTimestr(String routeTimestr) {
		this.routeTimestr = routeTimestr;
	}

	/**
	 * @return 途径时间
	 */
	public Date getRouteTime() {
		return routeTime;
	}

	/**
	 * @param routeTime 途径时间
	 */
	public void setRouteTime(Date routeTime) {
		this.routeTime = routeTime;
	}

}
