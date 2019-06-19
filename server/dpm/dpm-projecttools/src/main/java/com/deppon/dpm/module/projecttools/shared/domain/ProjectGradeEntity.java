package com.deppon.dpm.module.projecttools.shared.domain;

import java.util.Date;

/**
* @title: ProjectGradeEntity 
* @description：任务附件实体类
* @date： 2015年9月25日 
*/
public class ProjectGradeEntity {
	/**
	 * 项目编号
	 */
	private Integer projectId;
	/**
	 * id
	 */
	private String proGradeId;
	/**
	 * 模板ID
	 */
	private String templateId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目简码
	 */
	private String projectJm;
	/**
	 * 项目类型
	 */
	private String projectType;
	/**
	 * 项目级别
	 */
	private String projectLevel;
	/**
	 * 评级阶段
	 */
	private String gradePhase;
	/**
	 * 评级时间
	 */
	private Date gradeTime;
	/**
	 * 评级季度
	 */
	private String gradeQuarter;
	/**
	 * 等级
	 */
	private String plevel;
	/**
	 * 总分
	 */
	private double totalScroe;
	/**
	 * 基础分
	 */
	private double baseScore;
	/**
	 * 扣分
	 */
	private double delScore;
	/**
	 * 加分
	 */
	private double addScore;
	/**
	 * @return the proGradeId
	 */
	public String getProGradeId() {
		return proGradeId;
	}
	/**
	 * @param proGradeId
	 */
	public void setProGradeId(String proGradeId) {
		this.proGradeId = proGradeId;
	}
	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * @param templateId
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	/**
	 * @return the plevel
	 */
	public String getPlevel() {
		return plevel;
	}
	/**
	 * @param plevel
	 */
	public void setPlevel(String plevel) {
		this.plevel = plevel;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectJm
	 */
	public String getProjectJm() {
		return projectJm;
	}
	/**
	 * @param projectJm
	 */
	public void setProjectJm(String projectJm) {
		this.projectJm = projectJm;
	}
	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * @param projectType
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * @return the projectLevel
	 */
	public String getProjectLevel() {
		return projectLevel;
	}
	/**
	 * @param projectLevel
	 */
	public void setProjectLevel(String projectLevel) {
		this.projectLevel = projectLevel;
	}
	/**
	 * @return the gradePhase
	 */
	public String getGradePhase() {
		return gradePhase;
	}
	/**
	 * @param gradePhase
	 */
	public void setGradePhase(String gradePhase) {
		this.gradePhase = gradePhase;
	}
	/**
	 * @return the gradeTime
	 */
	public Date getGradeTime() {
		return gradeTime;
	}
	/**
	 * @param gradeTime
	 */
	public void setGradeTime(Date gradeTime) {
		this.gradeTime = gradeTime;
	}
	/**
	 * @return the gradeQuarter
	 */
	public String getGradeQuarter() {
		return gradeQuarter;
	}
	/**
	 * @param gradeQuarter
	 */
	public void setGradeQuarter(String gradeQuarter) {
		this.gradeQuarter = gradeQuarter;
	}
	/**
	 * @return the totalScroe
	 */
	public double getTotalScroe() {
		return totalScroe;
	}
	/**
	 * @param totalScroe
	 */
	public void setTotalScroe(double totalScroe) {
		this.totalScroe = totalScroe;
	}
	/**
	 * @return the baseScore
	 */
	public double getBaseScore() {
		return baseScore;
	}
	/**
	 * @param baseScore
	 */
	public void setBaseScore(double baseScore) {
		this.baseScore = baseScore;
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
	 * @return the delScore
	 */
	public double getDelScore() {
		return delScore;
	}
	/**
	 * @param delScore
	 */
	public void setDelScore(double delScore) {
		this.delScore = delScore;
	}
	/**
	 * @return the addScore
	 */
	public double getAddScore() {
		return addScore;
	}
	/**
	 * @param addScore
	 */
	public void setAddScore(double addScore) {
		this.addScore = addScore;
	}
	
	
}
