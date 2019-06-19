/**
 * 
 */
package com.deppon.dpm.module.wfs.shared.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.dpm.module.wfs.shared.domain.NwfsPicPathEntity;

/**
 * @yin 代办工作流
 * 
 */
@SuppressWarnings("deprecation")
public class OaWorkItem {

	/** 流程号 */
	private BigDecimal processinstid;

	/** 流程名称 */
	private String processinstname;

	/** 申请时间 */
	@JSONField(format = "yyyy-MM-dd")
	private Date createtime;
	//流向下个审批人的时间
	/** 申请时间 */
	@JSONField(format = "yyyy-MM-dd")
	private Date starttime;
	private String appler;
	
	private String applerid;

	private String department;

	/** 类别 */
	private String flowtype;

	/**
	 * 来源
	 */
	private String syscode;

	/** 工作项ID **/
	private BigDecimal workitemid;

	/** 业务编号 */
	private String busino;

	// 当前活动定义ID
	private String activitydefid;

	// 当前活动ID
	private BigDecimal activityinstid;

	@SuppressWarnings("unused")
	private String showDate;

	@SuppressWarnings("unused")
	private String showTime;
	private String jspname;
	/*** 是否代理审批*/
	private String agentStatus;
	
	private List<OaWorkItem> otherList;
	
	//工作流状态（新工作流，老工作流）
	private String status;
	//头像地址
	private List<NwfsPicPathEntity> picPaths;
	
	public String getShowDate() {
		int year = Calendar.YEAR;
		int month = Calendar.MONTH;
		int day = Calendar.DAY_OF_MONTH;
		if (createtime.getYear() == year && createtime.getMonth() == month) {
			if (day - createtime.getDay() == 0) {
				return "今天";
			} else if (day - createtime.getDay() == 1) {
				return "昨天";
			}
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(createtime);
	}

	public String getShowTime() {
		return new SimpleDateFormat("HH:mm:ss").format(createtime);
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	
	/**
	 * @return the otherList
	 */
	public List<OaWorkItem> getOtherList() {
		return otherList;
	}

	/**
	 * @param otherList the otherList to set
	 */
	public void setOtherList(List<OaWorkItem> otherList) {
		this.otherList = otherList;
	}

	/**
	 * @return the processinstid
	 */
	public BigDecimal getProcessinstid() {
		return processinstid;
	}

	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(BigDecimal processinstid) {
		this.processinstid = processinstid;
	}

	/**
	 * @return the processinstname
	 */
	public String getProcessinstname() {
		return processinstname;
	}

	/**
	 * @param processinstname the processinstname to set
	 */
	public void setProcessinstname(String processinstname) {
		this.processinstname = processinstname;
	}

	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return the appler
	 */
	public String getAppler() {
		return appler;
	}

	/**
	 * @param appler the appler to set
	 */
	public void setAppler(String appler) {
		this.appler = appler;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the flowtype
	 */
	public String getFlowtype() {
		return flowtype;
	}

	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	/**
	 * @return the syscode
	 */
	public String getSyscode() {
		return syscode;
	}

	/**
	 * @param syscode the syscode to set
	 */
	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}

	/**
	 * @return the workitemid
	 */
	public BigDecimal getWorkitemid() {
		return workitemid;
	}

	/**
	 * @param workitemid the workitemid to set
	 */
	public void setWorkitemid(BigDecimal workitemid) {
		this.workitemid = workitemid;
	}

	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the activitydefid
	 */
	public String getActivitydefid() {
		return activitydefid;
	}

	/**
	 * @param activitydefid the activitydefid to set
	 */
	public void setActivitydefid(String activitydefid) {
		this.activitydefid = activitydefid;
	}

	/**
	 * @return the activityinstid
	 */
	public BigDecimal getActivityinstid() {
		return activityinstid;
	}

	/**
	 * @param activityinstid the activityinstid to set
	 */
	public void setActivityinstid(BigDecimal activityinstid) {
		this.activityinstid = activityinstid;
	}

	/**
	 * @return the jspname
	 */
	public String getJspname() {
		return jspname;
	}

	/**
	 * @param jspname the jspname to set
	 */
	public void setJspname(String jspname) {
		this.jspname = jspname;
	}

	/**
	 * @return the agentStatus
	 */
	public String getAgentStatus() {
		return agentStatus;
	}

	/**
	 * @param agentStatus the agentStatus to set
	 */
	public void setAgentStatus(String agentStatus) {
		this.agentStatus = agentStatus;
	}

	/**
	 * @return the starttime
	 */
	public Date getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<NwfsPicPathEntity> getPicPaths() {
		return picPaths;
	}

	public void setPicPaths(List<NwfsPicPathEntity> picPaths) {
		this.picPaths = picPaths;
	}

	public String getApplerid() {
		return applerid;
	}

	public void setApplerid(String applerid) {
		this.applerid = applerid;
	}

}
