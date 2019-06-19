package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 保存5分实体
 * @author 袁中华
 * @date 2015.7.14
 *  关联 proc_user_score表
 */
public class ProcScoringEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id  主键ID
	 */
	private String id;
	/**
	 * userAddressld 人员地点ID
	 */
	private String userAddressid;
	/**
	 * scopeld 打分项ID
	 */
	private String scopeid;
	/**
	 * scope 分数
	 */
	private int scope;
	/**
	 * createDate 创建时间
	 */
	private Date createDate;
	/**
	 * String    转化时间
	 */
	private String date;
	
	
	/**
	 * 名称
	 */
	private String scopeName;
	
	/**
	 * @return 名称
	 */
	public String getScopeName() {
		return scopeName;
	}
	/**
	 * @param scopeName 名称
	 */
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	/**
	 * @return 转化时间
	 */
	public String getDate() {
		return date;
	}
	/** 
	 * @param date 转化时间
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return 主键id
	 */
	public String  getId() {
		return id;
	}
	/**
	 * @param id 主键id
	 */
	public void setId(String  id) {
		this.id = id;
	}

	/**
	 * @return 人员地点ID
	 */
	public String getUserAddressid() {
		return userAddressid;
	}
	/**
	 * @param userAddressid 人员地点ID
	 */
	public void setUserAddressid(String userAddressid) {
		this.userAddressid = userAddressid;
	}
	
	/**
	 * @return 打分项ID
	 */
	public String getScopeid() {
		return scopeid;
	}
	/**
	 * @param scopeid 打分项ID
	 */
	public void setScopeid(String scopeid) {
		this.scopeid = scopeid;
	}
	/**
	 * @return 分数
	 */
	public int getScope() {
		return scope;
	}
	/**
	 * @param scope 分数
	 */
	public void setScope(int scope) {
		this.scope = scope;
	}
	/**
	 * @return  创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate  创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



}
