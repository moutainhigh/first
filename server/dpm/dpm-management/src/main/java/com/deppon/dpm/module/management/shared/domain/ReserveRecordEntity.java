package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 预定房间记录信息 (包括房间信息 和 时间段信息)
 * @author 王亚男
 *
 */
public class ReserveRecordEntity implements Serializable,Comparable<ReserveRecordEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7482625840582448360L;

	public ReserveRecordEntity() {
	}
	
	//PlayRoomId
	private int playRoomId;
	//预定类型标志  	0-羽毛球室 	1-瑜伽室
	private int siteMark;	
	//预定类型名称
	private String siteName;
	//区域Code
	private String areaCode;
	//区域名称
	private String areaName;
	//房间code (场地编号)
	private String roomCode;
	//房间名字 (场地编号)
	private String roomName;
	//排序 ()
	private int orderNum;
	
	//Manage_date ID 预定时间管理信息表ID
	private int id;
	//预定人
	private String userName;
	//预定人工号
	private String userNo;
	//最高领导人工号
	private String mostUserNo;
	//最高领导人
	private String mostUser;
	//预订人电话
	private String userphone;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//记录创建时间
	private Date createTime;
	//记录修改时间
	private Date updateTime;
	//状态   0-预定  1-取消预定  2-提前结束
	private int status;
	//修改状态人工号
	private String statusUserNo;
	//开始时间
	private String startTimeStr;
	//结束时间
	private String endTimeStr;
    //年月日
	private String dateStr;
    //时间list
	private List<ReserveRecordEntity> dateList;
	//搜索时间
	private String searchTime;
	//getter setter
	public int getPlayRoomId() {
		return playRoomId;
	}
	public String getSearchTime() {
		return searchTime;
	}
	//getter setter
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	//getter setter
	public void setPlayRoomId(int playRoomId) {
		this.playRoomId = playRoomId;
	}
	//getter setter
	public int getSiteMark() {
		return siteMark;
	}
	//getter setter
	public void setSiteMark(int siteMark) {
		this.siteMark = siteMark;
	}
	//getter setter
	public String getSiteName() {
		return siteName;
	}
	//getter setter
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	//getter setter
	public String getAreaCode() {
		return areaCode;
	}
	//getter setter
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	//getter setter
	public String getAreaName() {
		return areaName;
	}
	//getter setter
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	//getter setter
	public String getRoomCode() {
		return roomCode;
	}
	//getter setter
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	//getter setter
	public String getRoomName() {
		return roomName;
	}
	//getter setter
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	//getter setter
	public int getOrderNum() {
		return orderNum;
	}
	//getter setter
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	//getter setter
	public int getId() {
		return id;
	}
	//getter setter
	public void setId(int id) {
		this.id = id;
	}
	//getter setter
	public String getUserName() {
		return userName;
	}
	//getter setter
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//getter setter
	public String getUserNo() {
		return userNo;
	}
	//getter setter
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	//getter setter
	public String getMostUserNo() {
		return mostUserNo;
	}
	//getter setter
	public void setMostUserNo(String mostUserNo) {
		this.mostUserNo = mostUserNo;
	}
	//getter setter
	public String getMostUser() {
		return mostUser;
	}
	//getter setter
	public void setMostUser(String mostUser) {
		this.mostUser = mostUser;
	}
	//getter setter
	public String getUserphone() {
		return userphone;
	}
	//getter setter
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	//getter setter
	public Date getStartTime() {
		return startTime;
	}
	//getter setter
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	//getter setter
	public Date getEndTime() {
		return endTime;
	}
	//getter setter
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	//getter setter
	public Date getCreateTime() {
		return createTime;
	}
	//getter setter
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//getter setter
	public Date getUpdateTime() {
		return updateTime;
	}
	//getter setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//getter setter
	public int getStatus() {
		return status;
	}
	//getter setter
	public void setStatus(int status) {
		this.status = status;
	}
	//getter setter
	public String getStatusUserNo() {
		return statusUserNo;
	}
	//getter setter
	public void setStatusUserNo(String statusUserNo) {
		this.statusUserNo = statusUserNo;
	}
	//getter setter
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}
	//getter setter
	public String getEndTimeStr() {
		return endTimeStr;
	}
	//getter setter
	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
	//getter setter
	public String getDateStr() {
		return dateStr;
	}
	//getter setter
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	//getter setter
	public List<ReserveRecordEntity> getDateList() {
		return dateList;
	}
	//getter setter
	public void setDateList(List<ReserveRecordEntity> dateList) {
		this.dateList = dateList;
	}


	/**
	 * 重写toString
	 */
	public String toString() {
		return "ReserveRecordEntity [playRoomId=" + playRoomId + ", siteMark="
				+ siteMark + ", siteName=" + siteName + ", areaCode="
				+ areaCode + ", areaName=" + areaName + ", roomCode="
				+ roomCode + ", roomName=" + roomName + ", orderNum="
				+ orderNum + ", id=" + id + ", userName=" + userName
				+ ", userNo=" + userNo + ", mostUserNo=" + mostUserNo
				+ ", mostUser=" + mostUser + ", userphone=" + userphone
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", status=" + status + ", statusUserNo=" + statusUserNo
				+ ", startTimeStr=" + startTimeStr + ", endTimeStr="
				+ endTimeStr + ", dateStr=" + dateStr + ", dateList="
				+ dateList + "]";
	}
	/* 
	 * 对该对象进行排序
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ReserveRecordEntity newBean) {
		
		return this.orderNum-newBean.orderNum;
	}
	
	/**
	 * 重写hashCode
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + orderNum;
		
		return result;
	}

	/**
	 * 重写equals
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return true;
	}

	
	
	
}
