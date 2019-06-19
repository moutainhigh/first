package com.deppon.dpm.module.projecttools.shared.domain;

import java.io.Serializable;

/**
 * <p>ClassName: 项目列表信息</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-7-29</p>
 */
public class ProjectInfo implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	//项目编码
	private String projectCode;
	
	//项目名称
	private String projectname;
	
	//发起人
	private String faperson;
	
	//项目经理
	private String mangerperson;
	
	//项目所属系统
	private String subsys;
	
	//项目百分比
	private String projectschedule;
	
	//项目状态
	private String projectstatue;
	
	//本周状态
	private String bweek;
	
	//上周状态
	private String lastweek;
	
	//项目收藏
	private int isLoving;
	
	//承接部门
	private String overtaken;

	/**
	 * projectCode
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * projectname
	 * @return the projectname
	 */
	public String getProjectname() {
		return projectname;
	}

	/**
	 * @param projectname the projectname to set
	 */
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	/**
	 * faperson
	 * @return the faperson
	 */
	public String getFaperson() {
		return faperson;
	}

	/**
	 * @param faperson the faperson to set
	 */
	public void setFaperson(String faperson) {
		this.faperson = faperson;
	}

	/**
	 * mangerperson
	 * @return the mangerperson
	 */
	public String getMangerperson() {
		return mangerperson;
	}

	/**
	 * @param mangerperson the mangerperson to set
	 */
	public void setMangerperson(String mangerperson) {
		this.mangerperson = mangerperson;
	}

	/**
	 * subsys
	 * @return the subsys
	 */
	public String getSubsys() {
		return subsys;
	}

	/**
	 * @param subsys the subsys to set
	 */
	public void setSubsys(String subsys) {
		this.subsys = subsys;
	}

	/**
	 * projectschedule
	 * @return the projectschedule
	 */
	public String getProjectschedule() {
		return projectschedule;
	}

	/**
	 * @param projectschedule the projectschedule to set
	 */
	public void setProjectschedule(String projectschedule) {
		this.projectschedule = projectschedule;
	}

	/**
	 * projectstatue
	 * @return the projectstatue
	 */
	public String getProjectstatue() {
		return projectstatue;
	}

	/**
	 * @param projectstatue the projectstatue to set
	 */
	public void setProjectstatue(String projectstatue) {
		this.projectstatue = projectstatue;
	}

	/**
	 * bweek
	 * @return the bweek
	 */
	public String getBweek() {
		return bweek;
	}

	/**
	 * @param bweek the bweek to set
	 */
	public void setBweek(String bweek) {
		this.bweek = bweek;
	}

	/**
	 * lastweek
	 * @return the lastweek
	 */
	public String getLastweek() {
		return lastweek;
	}

	/**
	 * @param lastweek the lastweek to set
	 */
	public void setLastweek(String lastweek) {
		this.lastweek = lastweek;
	}

	/**
	 * isLoving
	 * @return the isLoving
	 */
	public int getIsLoving() {
		return isLoving;
	}

	/**
	 * @param isLoving the isLoving to set
	 */
	public void setIsLoving(int isLoving) {
		this.isLoving = isLoving;
	}

	/**
	 * overtaken
	 * @return the overtaken
	 */
	public String getOvertaken() {
		return overtaken;
	}

	/**
	 * @param overtaken the overtaken to set
	 */
	public void setOvertaken(String overtaken) {
		this.overtaken = overtaken;
	}

	/**
	 * serialversionuid
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
