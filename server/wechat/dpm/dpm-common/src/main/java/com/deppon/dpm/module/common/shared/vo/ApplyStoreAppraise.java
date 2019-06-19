package com.deppon.dpm.module.common.shared.vo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 应用商店评论实体
 */
public class ApplyStoreAppraise {

	/**
	 * 主键(自增长)
	 */
	private int id;

	/**
	 * APP应用id
	 */
	private int appId;

	/**
	 * 评论人工号
	 */
	private String empcode;

	/**
	 * 评论人别名
	 */
	private String alias;

	/**
	 * 评论内容
	 */
	private String comment;

	/**
	 * APP应用评论星级,默认5星
	 */
	private int appStars;

	/**
	 * 评论状态，0：显示，1：不显示
	 */
	private int status;

	/**
	 * APP的操作系统
	 */
	private String osType;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * set
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getAppId() {
		return appId;
	}

	/**
	 * set
	 * 
	 * @param appid
	 */
	public void setAppId(int appId) {
		this.appId = appId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpcode() {
		return empcode;
	}

	/**
	 * set
	 * 
	 * @param empcode
	 */
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * set
	 * 
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * set
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getAppStars() {
		return appStars;
	}

	/**
	 * set
	 * 
	 * @param appStars
	 */
	public void setAppStars(int appStars) {
		this.appStars = appStars;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * set
	 * 
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
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
