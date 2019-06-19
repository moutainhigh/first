package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 存储请求盘点资产列表的开始时间和结束时间.
 * 
 * @author 233357
 * @date:2015/03/23
 */
public class MonitorCountInfoEntity extends BaseEntity{

	private static final long serialVersionUID = 5593062800407120896L;
	
	/**
	 * 访问人的工号
	 */
	private String userId;

	/**
	 * 访问开始时间
	 */
	private Date startTime ;
	
	/**
	 * 访问结束时间
	 */
	private Date endTime;
	

	/**
	 * 统计的类型(1是固定资产列表，2是扫一扫,3固定资产提交,4固定资产暂存,5IT上报历史,6提交IT上报,7扫一扫
	 * 8回退,9确认扫描)
	 * 
	 */
	private int type;

	/**
	 * 标识
	 */
	private String identifier; 
	
	/**
	 * 校验次数
	 */
	private String checkUum;
	
	/**
	 * 职位级别（B5,B6,B7,B8,B9）
	 */
	private String jobLevel;  
	/**
	 * 职位名称  （快递员、派件员、销售专员、外场、车队 等等） 
	 */
	private String jobName;	
	/**
	 *   职位分组 （1管理族群     2非管理族群）
	 */
	private String jobGroups;
	
	/**
	 * 部门性质 （职能、非职能）
	 */
	private String jobNature;
	
	/**
	 * @return the jobNature
	 */
	public String getJobNature() {
		return jobNature;
	}

	/**
	 * @param jobNature the jobNature to set
	 */
	public void setJobNature(String jobNature) {
		this.jobNature = jobNature;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the checkUum
	 */
	public String getCheckUum() {
		return checkUum;
	}

	/**
	 * @param checkUum the checkUum to set
	 */
	public void setCheckUum(String checkUum) {
		this.checkUum = checkUum;
	}

	/**
	 * @return the jobLevel
	 */
	public String getJobLevel() {
		return jobLevel;
	}

	/**
	 * @param jobLevel the jobLevel to set
	 */
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the jobGroups
	 */
	public String getJobGroups() {
		return jobGroups;
	}

	/**
	 * @param jobGroups the jobGroups to set
	 */
	public void setJobGroups(String jobGroups) {
		this.jobGroups = jobGroups;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
