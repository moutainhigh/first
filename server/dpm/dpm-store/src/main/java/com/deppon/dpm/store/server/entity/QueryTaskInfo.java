package com.deppon.dpm.store.server.entity;

import java.math.BigDecimal;

/**
 * 任务详情实体类
 * @author RY
 *
 */
public class QueryTaskInfo {
	//任务id
	private Integer taskid;
	//任务名称
	private String taskname;
	//任务截止日期
	private String endtime;
	//任务开始时间
	private String starttime;
	//任务创建人
	private String taskcreator;
	//任务子表中  总条数
	private int denominator;
	//任务子表 已完成任务数量
	private int numerator;
	//总动态表数
	private int num;
	//逾期时间
	private String overdueTime;
	//头像名称
	private String pictpath;
	//部门名称
	private String orgname;
	//职位
	private String jobname;
	//子任务结束时间
	private String sublistendtime;
	//执行人id
	private String exeerid;
	//执行人名称
	private String exeer;
	//营业部名称
	private String deptname;
	//分数
	private BigDecimal testgrade;
	//任务状态
	private String taskstatus;
	//是否逾期
	private String isoverdue;
	//是否有人反馈或考评 0为未反馈和考评 大于0则有人反馈或考评
	private int isedit;
	
	/**
	 * 
	 * @return
	 */
	public String getIsoverdue() {
		return isoverdue;
	}
	/**
	 * 
	 * @param isoverdue
	 */
	public void setIsoverdue(String isoverdue) {
		this.isoverdue = isoverdue;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptname() {
		return deptname;
	}
	/**
	 * 
	 * @param deptname
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	/**
	 * 
	 * @return
	 */
	public BigDecimal getTestgrade() {
		return testgrade;
	}
	/**
	 * 
	 * @param testgrade
	 */
	public void setTestgrade(BigDecimal testgrade) {
		this.testgrade = testgrade;
	}
	/**
	 * 
	 * @return
	 */
	public String getTaskstatus() {
		return taskstatus;
	}
	/**
	 * 
	 * @param taskstatus
	 */
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	/**
	 * 
	 * @return
	 */
	public String getExeerid() {
		return exeerid;
	}
	/**
	 * 
	 * @param exeerid
	 */
	public void setExeerid(String exeerid) {
		this.exeerid = exeerid;
	}
	/**
	 * 
	 * @return
	 */
	public String getExeer() {
		return exeer;
	}
	/**
	 * 
	 * @param exeer
	 */
	public void setExeer(String exeer) {
		this.exeer = exeer;
	}
	/**
	 * 
	 * @return
	 */
	public String getSublistendtime() {
		return sublistendtime;
	}
	/**
	 * 
	 * @param sublistendtime
	 */
	public void setSublistendtime(String sublistendtime) {
		this.sublistendtime = sublistendtime;
	}
	/**
	 * 
	 * @return
	 */
	public String getPictpath() {
		return pictpath;
	}
	/**
	 * 
	 * @param pictpath
	 */
	public void setPictpath(String pictpath) {
		this.pictpath = pictpath;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrgname() {
		return orgname;
	}
	/**
	 * 
	 * @param orgname
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	/**
	 * 
	 * @return
	 */
	public String getJobname() {
		return jobname;
	}
	/**
	 * 
	 * @param jobname
	 */
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getTaskid() {
		return taskid;
	}
	/**
	 * 
	 * @param taskid
	 */
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	/**
	 * 
	 * @return
	 */
	public String getOverdueTime() {
		return overdueTime; 
	}
	/**
	 * 
	 * @param overdueTime
	 */
	public void setOverdueTime(String overdueTime) {
		this.overdueTime = overdueTime;
	}
	/**
	 * 
	 * @return
	 */
	public String getTaskname() {
		return taskname;
	}
	/**
	 * 
	 * @param taskname
	 */
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	/**
	 * 
	 * @return
	 */
	public String getEndtime() {
		return endtime;
	}
	/**
	 * 
	 * @param endtime
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	/**
	 * 
	 * @return
	 */
	public String getStarttime() {
		return starttime;
	}
	/**
	 * 
	 * @param starttime
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	/**
	 * 
	 * @return
	 */
	public String getTaskcreator() {
		return taskcreator;
	}
	/**
	 * 
	 * @param taskcreator
	 */
	public void setTaskcreator(String taskcreator) {
		this.taskcreator = taskcreator;
	}
	/**
	 * 
	 * @return
	 */
	public int getDenominator() {
		return denominator;
	}
	/**
	 * 
	 * @param denominator
	 */
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	/**
	 * 
	 * @return
	 */
	public int getNumerator() {
		return numerator;
	}
	/**
	 * 
	 * @param numerator
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	/**
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}
	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * 
	 * @return
	 */
	public int getIsedit() {
		return isedit;
	}
	/**
	 * 
	 * @param isedit
	 */
	public void setIsedit(int isedit) {
		this.isedit = isedit;
	}
}
