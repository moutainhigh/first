package com.deppon.dpm.module.projecttools.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 年度规划项目信息 研发型实体类
 * @author 150970
 * @date 2014年10月23日 下午1:57:18
 * @since
 * @version
 */
public class AnnualPlanExtra1 extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
    private Integer aiId;
    /**
     * 项目编号
     */
    private Integer projectId;
    /**
     * 项目功能点
     */
    private Integer funcCnt;
    /**
     * 开发平台
     */
    private Integer platforms;
    private String platformname;
    /**
     * 开发技术
     */
    private String technology;
    /**
     * 实现方式
     */
    private Integer implentments;
    /**
     * 实现方式
     */
    private String implentName;
    /**
     * 用户需求开始时间
     */
    private String userneedFromTime;
    /**
     * 用户需求结束时间
     */

    private String userneedEndTime;
    /**
     * 系统需求开始时间
     */
    private String sysneedFromTime;
    /**
     * 系统需求结束时间
     */
    private String sysneedEndTime;
    /**
     * 开发开始时间
     */
    private String devFromTime;
    /**
     * 开发结束时间
     */
    private String devEndTime;
    /**
     * 测试开始时间
     */
    private String testFromTime;
    /**
     * 测试结束时间
     */
    private String testEndTime;
    /**
     * 上线时间
     */
    private String onlineTime;
    /**
     * 上线前推广开始时间
     */
    private String spreadFromTime;
    /**
     * 上线前推广结束时间
     */
    private String spreadEndTime;
	/**
	 * @return the aiId
	 */
	public Integer getAiId() {
		return aiId;
	}
	/**
	 * @return the platformname
	 */
	public String getPlatformname() {
		return platformname;
	}
	/**
	 * @param platformname
	 */
	public void setPlatformname(String platformname) {
		this.platformname = platformname;
	}
	/**
	 * @param aiId
	 */
	public void setAiId(Integer aiId) {
		this.aiId = aiId;
	}
	/**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the funcCnt
	 */
	public Integer getFuncCnt() {
		return funcCnt;
	}
	/**
	 * @param funcCnt
	 */
	public void setFuncCnt(Integer funcCnt) {
		this.funcCnt = funcCnt;
	}
	/**
	 * @return the platforms
	 */
	public Integer getPlatforms() {
		return platforms;
	}
	/**
	 * @param platforms
	 */
	public void setPlatforms(Integer platforms) {
		this.platforms = platforms;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @param technology
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	/**
	 * @return the implentments
	 */
	public Integer getImplentments() {
		return implentments;
	}
	/**
	 * @param implentments
	 */
	public void setImplentments(Integer implentments) {
		this.implentments = implentments;
	}
	/**
	 * @return the implentName
	 */
	public String getImplentName() {
		return implentName;
	}
	/**
	 * @param implentName
	 */
	public void setImplentName(String implentName) {
		this.implentName = implentName;
	}
	/**
	 * @return the userneedFromTime
	 */
	public String getUserneedFromTime() {
		return userneedFromTime;
	}
	/**
	 * @param userneedFromTime
	 */
	public void setUserneedFromTime(String userneedFromTime) {
		this.userneedFromTime = userneedFromTime;
	}
	/**
	 * @return the userneedEndTime
	 */
	public String getUserneedEndTime() {
		return userneedEndTime;
	}
	/**
	 * @param userneedEndTime
	 */
	public void setUserneedEndTime(String userneedEndTime) {
		this.userneedEndTime = userneedEndTime;
	}
	/**
	 * @return the sysneedFromTime
	 */
	public String getSysneedFromTime() {
		return sysneedFromTime;
	}
	/**
	 * @param sysneedFromTime
	 */
	public void setSysneedFromTime(String sysneedFromTime) {
		this.sysneedFromTime = sysneedFromTime;
	}
	/**
	 * @return the sysneedEndTime
	 */
	public String getSysneedEndTime() {
		return sysneedEndTime;
	}
	/**
	 * @param sysneedEndTime
	 */
	public void setSysneedEndTime(String sysneedEndTime) {
		this.sysneedEndTime = sysneedEndTime;
	}
	/**
	 * @return the devFromTime
	 */
	public String getDevFromTime() {
		return devFromTime;
	}
	/**
	 * @param devFromTime
	 */
	public void setDevFromTime(String devFromTime) {
		this.devFromTime = devFromTime;
	}
	/**
	 * @return the devEndTime
	 */
	public String getDevEndTime() {
		return devEndTime;
	}
	/**
	 * @param devEndTime
	 */
	public void setDevEndTime(String devEndTime) {
		this.devEndTime = devEndTime;
	}
	/**
	 * @return the testFromTime
	 */
	public String getTestFromTime() {
		return testFromTime;
	}
	/**
	 * @param testFromTime
	 */
	public void setTestFromTime(String testFromTime) {
		this.testFromTime = testFromTime;
	}
	/**
	 * @return the testEndTime
	 */
	public String getTestEndTime() {
		return testEndTime;
	}
	/**
	 * @param testEndTime
	 */
	public void setTestEndTime(String testEndTime) {
		this.testEndTime = testEndTime;
	}
	/**
	 * @return the onlineTime
	 */
	public String getOnlineTime() {
		return onlineTime;
	}
	/**
	 * @param onlineTime
	 */
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	/**
	 * @return the spreadFromTime
	 */
	public String getSpreadFromTime() {
		return spreadFromTime;
	}
	/**
	 * @param spreadFromTime
	 */
	public void setSpreadFromTime(String spreadFromTime) {
		this.spreadFromTime = spreadFromTime;
	}
	/**
	 * @return the spreadEndTime
	 */
	public String getSpreadEndTime() {
		return spreadEndTime;
	}
	/**
	 * @param spreadEndTime
	 */
	public void setSpreadEndTime(String spreadEndTime) {
		this.spreadEndTime = spreadEndTime;
	}

}
