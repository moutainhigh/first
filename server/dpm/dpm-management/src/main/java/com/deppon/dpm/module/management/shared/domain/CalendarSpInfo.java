package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 日程
 * 
 * @author 245968
 * 
 */
public class CalendarSpInfo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1984375907328519188L;
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 每条约会对应的id
	 */
	private String appointmentId;
	
	
	/**
	 * 主题
	 */
	private String subject = "";
	/**
	 * 接收或创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date calendarDate;
	/**
	 * 起始时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date start;
	/**
	 * 起始时间
	 */
	private String stoendDate;
	/**
	 * 结束时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date end;
	/**
	 * 地址
	 */
	private String location = "";
	
	
	public String getStoendDate() {
		return stoendDate;
	}
	public void setStoendDate(String stoendDate) {
		this.stoendDate = stoendDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getCalendarDate() {
		return calendarDate;
	}
	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

	
}
