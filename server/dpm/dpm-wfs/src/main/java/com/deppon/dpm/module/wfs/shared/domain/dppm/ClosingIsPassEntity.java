/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */ 
package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 项目结项是否通过
 * @author 106140
 * @date 2014-11-3 下午2:48:24
 * @since
 * @version
 */
public class ClosingIsPassEntity extends BaseEntity {
	private static final long serialVersionUID = -2638414034167644704L;
	/**
	   * '业务编号',
	   */
	  private String busino; 
	  /**
	   * '结项是否通过',
	   */
	  private String ispass; 
	  /**
	   * '结项时间',
	   */
	  private Date closingdate; 
	  private String closingDate;
	  /**
	   * '不通过原因'
	   */
	  private String notpassreason;
	  
	
	/**
	 * @return the closingDate
	 */
	public String getClosingDate() {
		return closingDate;
	}
	/**
	 * @param closingDate
	 */
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	/**
	 * @return  the busino
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * @return  the ispass
	 */
	public String getIspass() {
		return ispass;
	}
	/**
	 * @param ispass the ispass to set
	 */
	public void setIspass(String ispass) {
		this.ispass = ispass;
	}
	/**
	 * @return  the closingdate
	 */
	public Date getClosingdate() {
		return closingdate;
	}
	/**
	 * @param closingdate the closingdate to set
	 */
	public void setClosingdate(Date closingdate) {
		this.closingdate = closingdate;
	}
	/**
	 * @return  the notpassreason
	 */
	public String getNotpassreason() {
		return notpassreason;
	}
	/**
	 * @param notpassreason the notpassreason to set
	 */
	public void setNotpassreason(String notpassreason) {
		this.notpassreason = notpassreason;
	}
	  
	  
}
