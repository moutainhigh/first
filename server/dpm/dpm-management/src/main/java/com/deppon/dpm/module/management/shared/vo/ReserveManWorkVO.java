package com.deppon.dpm.module.management.shared.vo;

import java.io.Serializable;
import java.util.Date;

public class ReserveManWorkVO implements Serializable {	
	private static final long serialVersionUID = 1L;
	/**前台要显示文本字段   开始***/
	private int id;
	
	private int playRoomId;
	//房间code
	private String roomCode;
	//房间名称
	private String roomName;
	//区域code
	private String areaCode;
	//区域名称
	private String areaName;	
	/** 
	* @Fields reserveTime 预订时间
	*/ 
	private String reserveTime;
	/**前台要显示文本字段   结束***/
	/**查询条件或查询字段  开始*****************/
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//在场地的实际时间
	private String siteName;
	//编号
	private int orderNum;
	//工号
	private String userNo;
	//状态位
	private int status;	
	/** 
	* @Fields limitDayNum 是否查询当天，例如：0表示查询当天，1表示查询近两天, 2表示查询近三天
	*/ 
	private int limitDayNum;
	private int siteMark;
	/**查询条件或查询字段  结束*****************/
	public int getId() {
		return id;
	}
	//get set
	public void setId(int id) {
		this.id = id;
	}
	//get set
	public int getPlayRoomId() {
		return playRoomId;
	}
	//get set
	public void setPlayRoomId(int playRoomId) {
		this.playRoomId = playRoomId;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	//get set
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	//get set
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	//get set
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	//get set
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public int getOrderNum() {
		return orderNum;
	}
	//get set
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	//get set
	public int getStatus() {
		return status;
	}
	//get set
	public void setStatus(int status) {
		this.status = status;
	}
	//get set
	public int getLimitDayNum() {
		return limitDayNum;
	}
	//get set
	public void setLimitDayNum(int limitDayNum) {
		this.limitDayNum = limitDayNum;
	}
	//get set
	public int getSiteMark() {
		return siteMark;
	}
	//get set
	public void setSiteMark(int siteMark) {
		this.siteMark = siteMark;
	}
	//get set
	public ReserveManWorkVO() {
		super();
	}	
}
