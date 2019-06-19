package com.deppon.dpm.module.projecttools.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 项目组织
 * @author 150970
 * @date 2015年1月5日 下午12:15:22
 * @since
 * @version
 */
public class ProjectOrgEntity extends BaseEntity {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private Integer aiId;

   /**
    * 项目编号
    */
    private String projectCode;

   /**
    * 执行团队名称, 为NULL表示个人而非团队
    */
    private String teamName;

   /**
    * 角色名称
    */
    private String roleName;

    /**
     * 工号(内部) 或 姓名(外部)
     */
    private String userCode;
    /**
     * 姓名
     */
    private String userName;

    /**
     * 
     */
    private String company;
    /**
     * 所属系统
     */
    private String subsys;
    /**
     * 所属部门
     */
    private String department;
    /**
     * 岗位
     */
    private String job;
    /**
     * 职等
     */
    private String jobLevel;

    /**
     * 计划入场时间
     */
    private Date joinTime;

    /**
     * 计划离场时间
     */
    private Date leaveTime;

    /**
     * 工作职责
     */
    private String duty;

    /**
     * 掌握技能
     */
    private String skills;

    /**
     * 0 外部人员, 1 内部员工, 101 项目发起人 102 甲方项目经理 100 乙方项目经理
     */
    private int internal;

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @return the subsys
	 */
	public String getSubsys() {
		return subsys;
	}

	/**
	 * @param subsys
	 */
	public void setSubsys(String subsys) {
		this.subsys = subsys;
	}

	/**
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the jobLevel
	 */
	public String getJobLevel() {
		return jobLevel;
	}

	/**
	 * @param jobLevel
	 */
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the aiId
	 */
	public Integer getAiId() {
		return aiId;
	}

	/**
	 * @param aiId
	 */
	public void setAiId(Integer aiId) {
		this.aiId = aiId;
	}

	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the joinTime
	 */
	public Date getJoinTime() {
		return joinTime;
	}

	/**
	 * @param joinTime
	 */
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	/**
	 * @return the leaveTime
	 */
	public Date getLeaveTime() {
		return leaveTime;
	}

	/**
	 * @param leaveTime
	 */
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	/**
	 * @return the duty
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * @param duty
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * @return the internal
	 */
	public int getInternal() {
		return internal;
	}

	/**
	 * @param internal
	 */
	public void setInternal(int internal) {
		this.internal = internal;
	}

   
}