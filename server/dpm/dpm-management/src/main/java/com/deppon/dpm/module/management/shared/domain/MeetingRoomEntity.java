package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;                                                                             

/**
 * 会议室预定实体
 * @author 491275
 *
 */
public class MeetingRoomEntity implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 会议室预定id
	 */
	private BigDecimal bookId;
	/**
	 * 会议室预订人姓名
	 */
	private String orderUserName;
	/**
	 * 会议室预订人工号
	 */
	private String orderUserId;
	/**
	 * 会议室id
	 */
	private String meetingRoomId;
	/**
	 * 会议室名称
	 */
	private String meetingRoomName;
	/**
	 * 会议室状态
	 */
	private String status;
	/**
	 * 会议室地址
	 */
	private String areaName;
	/**
	 * 会议室容纳人数
	 */
	private String volume;
	/**
	 * 会议室预定日期
	 */
	private String meetingDate;
	/**
	 * 会议室预订人工号
	 */
	private String mobileLoginCode;
	/**
	 * 设备
	 */
	private String equipment;
	/**
	 * 使用说明
	 */
	private String usedCase;
	/**
	 * 已预订时间
	 */
	private String orderTime;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 会议状态
	 */
	private String meetingBookStatus;
	/**
	 * 最高参会人工号
	 */
	private String highLoginId;
	/**
	 * 参会ceo工号
	 */
	private String ceoLoginId;
	/**
	 * 参会ceo人员信息
	 */
	private String allCeo;
	/**
	 * 最高参会人信息
	 */
	private String allHigh;
	/**
	 * 会议备注
	 */
	private String motif;
	/**
	 * 是否副总参会  0否1是
	 */
	private String ceoAttend;
	/**
	 * 参会人数
	 */
	private Long quantity;
	/**
	 * 会议主题
	 */
	private String putreOuest;
	
	
	public BigDecimal getBookId() {
		return bookId;
	}
	public void setBookId(BigDecimal bookId) {
		this.bookId = bookId;
	}
	public String getOrderUserName() {
		return orderUserName;
	}
	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}
	public String getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}
	public String getMeetingRoomId() {
		return meetingRoomId;
	}
	public void setMeetingRoomId(String meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}
	public String getMeetingRoomName() {
		return meetingRoomName;
	}
	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getUsedCase() {
		return usedCase;
	}
	public void setUsedCase(String usedCase) {
		this.usedCase = usedCase;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMeetingBookStatus() {
		return meetingBookStatus;
	}
	public void setMeetingBookStatus(String meetingBookStatus) {
		this.meetingBookStatus = meetingBookStatus;
	}
	public String getHighLoginId() {
		return highLoginId;
	}
	public void setHighLoginId(String highLoginId) {
		this.highLoginId = highLoginId;
	}
	public String getCeoLoginId() {
		return ceoLoginId;
	}
	public void setCeoLoginId(String ceoLoginId) {
		this.ceoLoginId = ceoLoginId;
	}
	public String getAllCeo() {
		return allCeo;
	}
	public void setAllCeo(String allCeo) {
		this.allCeo = allCeo;
	}
	public String getAllHigh() {
		return allHigh;
	}
	public void setAllHigh(String allHigh) {
		this.allHigh = allHigh;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getCeoAttend() {
		return ceoAttend;
	}
	public void setCeoAttend(String ceoAttend) {
		this.ceoAttend = ceoAttend;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getPutreOuest() {
		return putreOuest;
	}
	public void setPutreOuest(String putreOuest) {
		this.putreOuest = putreOuest;
	}
	public String getMobileLoginCode() {
		return mobileLoginCode;
	}
	public void setMobileLoginCode(String mobileLoginCode) {
		this.mobileLoginCode = mobileLoginCode;
	}
	
}
