package com.deppon.dpm.module.management.shared.domain;
/**
 * 年度总结实体
 * @author 276344
 *
 */
public class YearSummaryEntity {
	/**
	 * 工号
	 */
	private String empCode; 
	/**
	 * 姓名
	 */
	private String empName;
	/**
	 * 第一次登录移动办公时间
	 */
	private String  firstLoginTime;
	/**
	 * 2017年访问移动办公次数
	 */
	private int loginNum;
	/**
	 * 2017年访问移动办公次数超越了全国xx%同事
	 */
	private float loginOrder;
	/**
	 * 2017访问最高的时间段
	 */
	private String  visitorTime;
	/**
	 * 2017访问最高的时间段的访问次数
	 */
	private int visitorNum;
	/**
	 * 这一时间段有多少同事同在
	 */
	private int visitorPersonNum;
	/**
	 * 访问量第一的应用名
	 * @return
	 */
	private String firstApp;
	/**
	 * 访问量第一的应用次数
	 */
	private int firstAppuserTime;
	/**
	 * 访问量第二的应用名
	 * @return
	 */
	private String secondApp;
	/**
	 * 访问量第二的应用次数
	 */
	private int secondAppuserTime;
	/**
	 * 访问量第三的应用名
	 * @return
	 */
	private String thirdApp;
	/**
	 * 访问量第三的应用次数
	 */
	private int thirdAppUserTime;
	/**
	 * 访问量第四的应用名
	 * @return
	 */
	private String fouthApp;
	/**
	 * 访问量第四的应用次数
	 */
	private int fouthAppUserTime;
	/**
	 * 访问量第五的应用名'
	 * @return
	 */
	private String fifthApp;
	/**
	 * 访问量第五的应用次数
	 */
	private int fifthAppUserTime;
	/**
	 * 2017最常访问应用排名数
	 */
	private int userOrder;
	/**
	 * 2017最常访问应用超越了xx%同事
	 */
	private float personNum;
	/**
	 * 入职时间
	 */
	private String comeCompanyTime;
	/**
	 * 离职时间
	 */
	private String leaveCompanyTime;
	/**
	 * 入职日期
	 */
	private String indate;
	/**
	 * 入职到2017-12-31共多少天
	 */
	private int comCompanyDay;
	/**
	 * 入职部门
	 */
	private String comCompanyDepartment;
	/**
	 * 入职岗位
	 */
	private String comCompanyJob;
	
	/**
	 * 2017标签
	 */
	private String tag;
	/**
	 * 2017标签描述
	 */
	private String tagDescription;
	/**
	 * 头像路径
	 */
	private String picPath;
	/**
	 * 头像路径
	 */
	private Long inTime;
	/**
	 * 入职时间
	 */
	private String hiredate;
	/**
	 * 打卡时长
	 */
	private Double punchClockTime;
	/**
	 * 最早一次打卡时间
	 */
	private String firstPunchClockDate;
	/**
	 * 最晚一次打卡时间
	 */
	private String lastPunchClockDate;
	/**
	 * 模块访问次数
	 */
	private int appVisitedNum;
	/**
	 * 欢行因公用车次数
	 */
	private int taxiNumber;
	/**
	 * 用车次数同层级排名
	 */
	private int taxiRanking;
	/**
	 * 超越同层级百分比
	 */
	private String taxiRankingPercent;
	/**
	 * 工作流审批条数
	 */
	private int workflowNum;
	/**
	 * 超越百分比
	 */
	private String workflowRanking;
	/**
	 * 岗位层级
	 */
	private String joblevel;
	
	private int id;
	
	
	
	
	public Long getInTime() {
		return inTime;
	}
	public void setInTime(Long inTime) {
		this.inTime = inTime;
	}
	public String getLeaveCompanyTime() {
		return leaveCompanyTime;
	}
	public void setLeaveCompanyTime(String leaveCompanyTime) {
		this.leaveCompanyTime = leaveCompanyTime;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getFirstLoginTime() {
		return firstLoginTime;
	}
	public void setFirstLoginTime(String firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	public int getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}
	public float getLoginOrder() {
		return loginOrder;
	}
	public void setLoginOrder(float loginOrder) {
		this.loginOrder = loginOrder;
	}
	public String getVisitorTime() {
		return visitorTime;
	}
	public void setVisitorTime(String visitorTime) {
		this.visitorTime = visitorTime;
	}
	public int getVisitorNum() {
		return visitorNum;
	}
	public void setVisitorNum(int visitorNum) {
		this.visitorNum = visitorNum;
	}
	public int getVisitorPersonNum() {
		return visitorPersonNum;
	}
	public void setVisitorPersonNum(int visitorPersonNum) {
		this.visitorPersonNum = visitorPersonNum;
	}
	public String getFirstApp() {
		return firstApp;
	}
	public void setFirstApp(String firstApp) {
		this.firstApp = firstApp;
	}
	public int getFirstAppuserTime() {
		return firstAppuserTime;
	}
	public void setFirstAppuserTime(int firstAppuserTime) {
		this.firstAppuserTime = firstAppuserTime;
	}
	public String getSecondApp() {
		return secondApp;
	}
	public void setSecondApp(String secondApp) {
		this.secondApp = secondApp;
	}
	public int getSecondAppuserTime() {
		return secondAppuserTime;
	}
	public void setSecondAppuserTime(int secondAppuserTime) {
		this.secondAppuserTime = secondAppuserTime;
	}
	public String getThirdApp() {
		return thirdApp;
	}
	public void setThirdApp(String thirdApp) {
		this.thirdApp = thirdApp;
	}
	public int getThirdAppUserTime() {
		return thirdAppUserTime;
	}
	public void setThirdAppUserTime(int thirdAppUserTime) {
		this.thirdAppUserTime = thirdAppUserTime;
	}
	public String getFouthApp() {
		return fouthApp;
	}
	public void setFouthApp(String fouthApp) {
		this.fouthApp = fouthApp;
	}
	public int getFouthAppUserTime() {
		return fouthAppUserTime;
	}
	public void setFouthAppUserTime(int fouthAppUserTime) {
		this.fouthAppUserTime = fouthAppUserTime;
	}
	public String getFifthApp() {
		return fifthApp;
	}
	public void setFifthApp(String fifthApp) {
		this.fifthApp = fifthApp;
	}
	public int getFifthAppUserTime() {
		return fifthAppUserTime;
	}
	public void setFifthAppUserTime(int fifthAppUserTime) {
		this.fifthAppUserTime = fifthAppUserTime;
	}
	public int getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(int userOrder) {
		this.userOrder = userOrder;
	}
	
	public float getPersonNum() {
		return personNum;
	}
	public void setPersonNum(float personNum) {
		this.personNum = personNum;
	}
	public String getComeCompanyTime() {
		return comeCompanyTime;
	}
	public void setComeCompanyTime(String comeCompanyTime) {
		this.comeCompanyTime = comeCompanyTime;
	}
	public int getComCompanyDay() {
		return comCompanyDay;
	}
	public void setComCompanyDay(int comCompanyDay) {
		this.comCompanyDay = comCompanyDay;
	}
	public String getComCompanyDepartment() {
		return comCompanyDepartment;
	}
	public void setComCompanyDepartment(String comCompanyDepartment) {
		this.comCompanyDepartment = comCompanyDepartment;
	}
	public String getComCompanyJob() {
		return comCompanyJob;
	}
	public void setComCompanyJob(String comCompanyJob) {
		this.comCompanyJob = comCompanyJob;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTagDescription() {
		return tagDescription;
	}
	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getFirstPunchClockDate() {
		return firstPunchClockDate;
	}
	public void setFirstPunchClockDate(String firstPunchClockDate) {
		this.firstPunchClockDate = firstPunchClockDate;
	}
	public String getLastPunchClockDate() {
		return lastPunchClockDate;
	}
	public void setLastPunchClockDate(String lastPunchClockDate) {
		this.lastPunchClockDate = lastPunchClockDate;
	}
	public int getTaxiNumber() {
		return taxiNumber;
	}
	public void setTaxiNumber(int taxiNumber) {
		this.taxiNumber = taxiNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPunchClockTime() {
		return punchClockTime;
	}
	public void setPunchClockTime(Double punchClockTime) {
		this.punchClockTime = punchClockTime;
	}
	public int getAppVisitedNum() {
		return appVisitedNum;
	}
	public void setAppVisitedNum(int appVisitedNum) {
		this.appVisitedNum = appVisitedNum;
	}
	public int getTaxiRanking() {
		return taxiRanking;
	}
	public void setTaxiRanking(int taxiRanking) {
		this.taxiRanking = taxiRanking;
	}
	public String getJoblevel() {
		return joblevel;
	}
	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}
	public String getTaxiRankingPercent() {
		return taxiRankingPercent;
	}
	public void setTaxiRankingPercent(String taxiRankingPercent) {
		this.taxiRankingPercent = taxiRankingPercent;
	}
	public int getWorkflowNum() {
		return workflowNum;
	}
	public void setWorkflowNum(int workflowNum) {
		this.workflowNum = workflowNum;
	}
	public String getWorkflowRanking() {
		return workflowRanking;
	}
	public void setWorkflowRanking(String workflowRanking) {
		this.workflowRanking = workflowRanking;
	}

	
	
}
