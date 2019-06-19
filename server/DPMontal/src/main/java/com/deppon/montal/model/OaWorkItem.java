/**
 * 
 */
package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

/**
 * @yin 代办工作流
 *
 */
public class OaWorkItem {

	/**流程号*/
	private BigDecimal processinstid;
	
	/**流程名称*/
	private String processinstname;
	
	/**申请时间*/
	private Date createtime;
	
	private String appler;
	
	private String department;
	
	/**类别*/
	private String flowtype;
	
	/**
	 * 来源
	 */
	private String syscode;
	
	/**工作项ID**/
	private BigDecimal workitemid;
	
	/**业务编号*/
	private String busino;
	
	//当前活动定义ID
	private String activitydefid;
	
	//当前活动ID
	private BigDecimal activityinstid;

	public BigDecimal getActivityinstid() {
	
		return activityinstid;
	}

	public void setActivityinstid(BigDecimal activityinstid) {
	
		this.activityinstid = activityinstid;
	}

	public BigDecimal getProcessinstid() {
		return processinstid;
	}

	public void setProcessinstid(BigDecimal processinstid) {
		this.processinstid = processinstid;
	}

	public String getProcessinstname() {
		return F_Constants.chageNull(processinstname);
	}

	public void setProcessinstname(String processinstname) {
		this.processinstname = processinstname;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getFlowtype() {
		return F_Constants.chageNull(flowtype);
	}

	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	public String getAppler() {
		return appler;
	}

	public void setAppler(String appler) {
		this.appler = appler;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSyscode() {
	
		return syscode;
	}

	public void setSyscode(String syscode) {
	
		this.syscode = syscode;
	}

	public BigDecimal getWorkitemid() {
	
		return workitemid;
	}

	public void setWorkitemid(BigDecimal workitemid) {
	
		this.workitemid = workitemid;
	}

	public String getBusino() {
	
		return busino;
	}

	public void setBusino(String busino) {
	
		this.busino = busino;
	}

	public String getActivitydefid() {
	
		return activitydefid;
	}

	public void setActivitydefid(String activitydefid) {
	
		this.activitydefid = activitydefid;
	}
	
}
