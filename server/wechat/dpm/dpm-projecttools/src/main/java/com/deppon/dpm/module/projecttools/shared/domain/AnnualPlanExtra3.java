package com.deppon.dpm.module.projecttools.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 项目信息实体类
 * @author 150970
 * @date 2014年10月23日 下午1:57:18
 * @since
 * @version
 */
public class AnnualPlanExtra3 extends BaseEntity {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.AI_ID
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private Integer aiId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.project_id
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private Integer projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.implentments
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private Integer implentments;
    private String implentName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.sysneed_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private String sysneedFromTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.sysneed_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private String sysneedEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.apply_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private String applyFromTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.apply_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private String applyEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.test_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private String testFromTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.test_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private String testEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_gh_project_extra3.online_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    private String onlineTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.AI_ID
     *
     * @return the value of dotp_gh_project_extra3.AI_ID
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public Integer getAiId() {
        return aiId;
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
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.AI_ID
     *
     * @param aiId the value for dotp_gh_project_extra3.AI_ID
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setAiId(Integer aiId) {
        this.aiId = aiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.project_id
     *
     * @return the value of dotp_gh_project_extra3.project_id
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.project_id
     *
     * @param projectId the value for dotp_gh_project_extra3.project_id
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.implentments
     *
     * @return the value of dotp_gh_project_extra3.implentments
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public Integer getImplentments() {
        return implentments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.implentments
     *
     * @param implentments the value for dotp_gh_project_extra3.implentments
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setImplentments(Integer implentments) {
        this.implentments = implentments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.sysneed_from_time
     *
     * @return the value of dotp_gh_project_extra3.sysneed_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public String getSysneedFromTime() {
        return sysneedFromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.sysneed_from_time
     *
     * @param sysneedFromTime the value for dotp_gh_project_extra3.sysneed_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setSysneedFromTime(String sysneedFromTime) {
        this.sysneedFromTime = sysneedFromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.sysneed_end_time
     *
     * @return the value of dotp_gh_project_extra3.sysneed_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public String getSysneedEndTime() {
        return sysneedEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.sysneed_end_time
     *
     * @param sysneedEndTime the value for dotp_gh_project_extra3.sysneed_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setSysneedEndTime(String sysneedEndTime) {
        this.sysneedEndTime = sysneedEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.apply_from_time
     *
     * @return the value of dotp_gh_project_extra3.apply_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public String getApplyFromTime() {
        return applyFromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.apply_from_time
     *
     * @param applyFromTime the value for dotp_gh_project_extra3.apply_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setApplyFromTime(String applyFromTime) {
        this.applyFromTime = applyFromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.apply_end_time
     *
     * @return the value of dotp_gh_project_extra3.apply_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public String getApplyEndTime() {
        return applyEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.apply_end_time
     *
     * @param applyEndTime the value for dotp_gh_project_extra3.apply_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setApplyEndTime(String applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.test_from_time
     *
     * @return the value of dotp_gh_project_extra3.test_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public String getTestFromTime() {
        return testFromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.test_from_time
     *
     * @param testFromTime the value for dotp_gh_project_extra3.test_from_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setTestFromTime(String testFromTime) {
        this.testFromTime = testFromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.test_end_time
     *
     * @return the value of dotp_gh_project_extra3.test_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public String getTestEndTime() {
        return testEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.test_end_time
     *
     * @param testEndTime the value for dotp_gh_project_extra3.test_end_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setTestEndTime(String testEndTime) {
        this.testEndTime = testEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_gh_project_extra3.online_time
     *
     * @return the value of dotp_gh_project_extra3.online_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public String getOnlineTime() {
        return onlineTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_gh_project_extra3.online_time
     *
     * @param onlineTime the value for dotp_gh_project_extra3.online_time
     *
     * @mbggenerated Wed Nov 12 11:49:04 CST 2014
     */
    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }
}
