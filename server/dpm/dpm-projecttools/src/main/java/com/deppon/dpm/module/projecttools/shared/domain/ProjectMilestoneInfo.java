package com.deppon.dpm.module.projecttools.shared.domain;

/**
 * <p>ClassName: 项目里程碑信息</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-7-30</p>
 */
public class ProjectMilestoneInfo {
	//会议纪要ID
	private int mid;
	
	//项目ID
	private String projectcode;
	
	//项目名称
	private String projectname;
	//里程碑名称
	private String msname;
	// 时间
	private String timepoint;
	//里程碑描述
	private String mssummary;
	private String projectprofile;
	
	//判断里程碑节点是否有会议纪要
	private String ismsId;
	//是否为 关键点 1, 默认为 里程碑 0
	private int iskey;
	//立项时间
	private String createtime;
	//结项时间
	private String finishtim;

	/**
	 * @return the iskey
	 */
	public int getIskey() {
		return iskey;
	}

	/**
	 * @param iskey
	 */
	public void setIskey(int iskey) {
		this.iskey = iskey;
	}

	/**
	 * mid
	 * @return the mid
	 */
	public int getMid() {
		return mid;
	}

	/**
	 * @param mid the mid to set
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}

	/**
	 * projectcode
	 * @return the projectcode
	 */
	public String getProjectcode() {
		return projectcode;
	}

	/**
	 * @param projectcode the projectcode to set
	 */
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
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
	 * msname
	 * @return the msname
	 */
	public String getMsname() {
		return msname;
	}

	/**
	 * @param msname the msname to set
	 */
	public void setMsname(String msname) {
		this.msname = msname;
	}

	/**
	 * timepoint
	 * @return the timepoint
	 */
	public String getTimepoint() {
		return timepoint;
	}

	/**
	 * @param timepoint the timepoint to set
	 */
	public void setTimepoint(String timepoint) {
		this.timepoint = timepoint;
	}

	/**
	 * mssummary
	 * @return the mssummary
	 */
	public String getMssummary() {
		return mssummary;
	}

	/**
	 * @param mssummary the mssummary to set
	 */
	public void setMssummary(String mssummary) {
		this.mssummary = mssummary;
	}

	/**
	 * projectprofile
	 * @return the projectprofile
	 */
	public String getProjectprofile() {
		return projectprofile;
	}

	/**
	 * @param projectprofile the projectprofile to set
	 */
	public void setProjectprofile(String projectprofile) {
		this.projectprofile = projectprofile;
	}

	/**
	 * ismsId
	 * @return the ismsId
	 */
	public String getIsmsId() {
		return ismsId;
	}

	/**
	 * @param ismsId the ismsId to set
	 */
	public void setIsmsId(String ismsId) {
		this.ismsId = ismsId;
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return the finishtim
	 */
	public String getFinishtim() {
		return finishtim;
	}

	/**
	 * @param finishtim the finishtim to set
	 */
	public void setFinishtim(String finishtim) {
		this.finishtim = finishtim;
	}
	
}
