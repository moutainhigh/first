package com.deppon.dpm.module.announce.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * announce log实体类
 * 
 * @author 231586
 * 
 */
public class AnnounceLogEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 请求参数
	 */
	private String requestparam;
	/**
	 * 
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRequestparam() {
		return requestparam;
	}

	/**
	 * set
	 * 
	 * @param requestparam
	 */
	public void setRequestparam(String requestparam) {
		this.requestparam = requestparam;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * set
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * set
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
