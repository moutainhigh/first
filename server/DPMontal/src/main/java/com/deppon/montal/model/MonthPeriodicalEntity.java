package com.deppon.montal.model;

import java.sql.Clob;

/**
 * 月报实体
 * @author 130346
 *
 */
public class MonthPeriodicalEntity {
	/**
	 * id
	 */
	private int periodicalId;
	private String periodicalNo;
	private int typeId;
	private String publicationDate;
	private String publicStatus;
	private String picture;
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getPeriodicalId() {
		return periodicalId;
	}
	public void setPeriodicalId(int periodicalId) {
		this.periodicalId = periodicalId;
	}
	public String getPeriodicalNo() {
		return periodicalNo;
	}
	public void setPeriodicalNo(String periodicalNo) {
		this.periodicalNo = periodicalNo;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getPublicStatus() {
		return publicStatus;
	}
	public void setPublicStatus(String publicStatus) {
		this.publicStatus = publicStatus;
	}
	
}
