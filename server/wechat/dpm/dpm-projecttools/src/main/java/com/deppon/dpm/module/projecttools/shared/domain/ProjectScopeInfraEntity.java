package com.deppon.dpm.module.projecttools.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 项目范围（基础设施）
 * @author 150970
 * @date 2015年1月5日 下午12:14:52
 * @since
 * @version
 */
public class ProjectScopeInfraEntity extends BaseEntity {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_pm_project_scope_infra.AI_ID
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    private Integer aiId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_pm_project_scope_infra.project_code
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    private String projectCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_pm_project_scope_infra.infrastructure
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    private String infrastructure;
    
    private String projectCode2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dotp_pm_project_scope_infra.infrastructure
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    private String infrastructure2;
    
    

    public String getProjectCode2() {
		return projectCode2;
	}

	public void setProjectCode2(String projectCode2) {
		this.projectCode2 = projectCode2;
	}

	public String getInfrastructure2() {
		return infrastructure2;
	}

	public void setInfrastructure2(String infrastructure2) {
		this.infrastructure2 = infrastructure2;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_pm_project_scope_infra.AI_ID
     *
     * @return the value of dotp_pm_project_scope_infra.AI_ID
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    public Integer getAiId() {
        return aiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_pm_project_scope_infra.AI_ID
     *
     * @param aiId the value for dotp_pm_project_scope_infra.AI_ID
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    public void setAiId(Integer aiId) {
        this.aiId = aiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_pm_project_scope_infra.project_code
     *
     * @return the value of dotp_pm_project_scope_infra.project_code
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_pm_project_scope_infra.project_code
     *
     * @param projectCode the value for dotp_pm_project_scope_infra.project_code
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_pm_project_scope_infra.infrastructure
     *
     * @return the value of dotp_pm_project_scope_infra.infrastructure
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    public String getInfrastructure() {
        return infrastructure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_pm_project_scope_infra.infrastructure
     *
     * @param infrastructure the value for dotp_pm_project_scope_infra.infrastructure
     *
     * @mbggenerated Thu Nov 13 22:49:59 CST 2014
     */
    public void setInfrastructure(String infrastructure) {
        this.infrastructure = infrastructure;
    }
}