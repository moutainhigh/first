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

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 验收组织信息
 * @author 106140
 * @date 2014-11-3 下午2:48:24
 * @since
 * @version
 */
public class ClosingOrgInfoEntity extends BaseEntity {
	  /**
	   * 业务编号
	   */
	  private String busino;
	  /**
	   * 验收模块
	   */
	  private String checkModule;
	  /**
	   * 验收类型
	   */
	  private String checkType;
	  /**
	   * 负责人姓名
	   */
	  private String managerName;
	  /**
	   * 负责人code
	   */
	  private String managerCode;
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:39
	 * @return
	 * @see
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:41
	 * @param busino
	 * @see
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:43
	 * @return
	 * @see
	 */
	public String getCheckModule() {
		return checkModule;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:45
	 * @param checkModule
	 * @see
	 */
	public void setCheckModule(String checkModule) {
		this.checkModule = checkModule;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:48
	 * @return
	 * @see
	 */
	public String getCheckType() {
		return checkType;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:53
	 * @param checkType
	 * @see
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:55
	 * @return
	 * @see
	 */
	public String getManagerName() {
		return managerName;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:01:58
	 * @param managerName
	 * @see
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:02:00
	 * @return
	 * @see
	 */
	public String getManagerCode() {
		return managerCode;
	}
	/**
	 * 
	 * @author 106140
	 * @date 2015-1-9 下午4:02:01
	 * @param managerCode
	 * @see
	 */
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}
	
}
