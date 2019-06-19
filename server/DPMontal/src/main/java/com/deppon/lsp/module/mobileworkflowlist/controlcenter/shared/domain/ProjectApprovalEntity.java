package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

// TODO: Auto-generated Javadoc
/**
 * 工程项目立项单实体类.
 *
 * @author 李清松
 * @date 2013-9-3 下午5:17:49
 * @since
 * @version
 */
public class ProjectApprovalEntity extends BaseEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -593098083021454672L;
	//项目编号
	/** The number. */
	private String number;
	//项目名称
	/** The name. */
	private String name;
	//项目状态
	/** The projectstatus. */
	private String projectstatus;
	//所属事业部
	/** The division. */
	private String division;
	//项目类型
	/** The projecttpye. */
	private String projecttpye;
	//单据状态
	/** The state. */
	private String state;
	//申请时间
	/** The proapplitime. */
	private Date proapplitime;
	//项目地点
	/** The projectseat. */
	private String projectseat;
	//申请部门
	/** The createorg. */
	private String createorg;
	//总工程编号
	/** The totalprojectno. */
	private String totalprojectno;
	//预计开始时间
	/** The projectexpstart. */
	private Date projectexpstart;
	//预计结束时间
	/** The projectexpend. */
	private Date projectexpend;
	//项目经理
	/** The projectmanager. */
	private String projectmanager;
	//是否需要复原
	/** The needrecovery. */
	private int needrecovery;
	//概算金额
	/** The budgetamount. */
	private BigDecimal budgetamount; 
	//是否做办公深化设计
	/** The wheneeddesign. */
	private int wheneeddesign;
	//内部审计
	/** The internalaudit. */
	private int internalaudit;
	//外部审计
	/** The exteraudit. */
	private int exteraudit;
	//工程管理服务外包
	/** The promanaout. */
	private int promanaout;
	//消防报批
	/** The fireapproval. */
	private int fireapproval;
	//是否甲供
	/** The whetherfor. */
	private int whetherfor;
	//设计外包
	/** The designout. */
	private int designout;
	//施工外包
	/** The constout. */
	private int constout;
	//招牌报批
	/** The signsapproval. */
	private int signsapproval;
	//报建
	/** The build. */
	private int build;
	//非网点分类
	/** The notpointtype. */
	private String notpointtype;
	//分部工程
	/** The engindivision. */
	private String engindivision;
	//项目级别
	/** The projectlevel. */
	private String projectlevel;
	//备注
	/** The remarks. */
	private String remarks;
	//是否拆分项目
	/** The is whe pro. */
	private int isWhePro;
	//审核人
	/** The auditor. */
	private String auditor;
	//业务日期
	/** The biz date. */
	private Date bizDate;
	//项目编号
	/** The projec number. */
	private String projecNumber;
	
	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		if (number == null) {
			number = "";
		}
		return number;
	}
	
	/**
	 * Sets the number.
	 *
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		if (name == null) {
			name = "";
		}
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the projectstatus.
	 *
	 * @return the projectstatus
	 */
	public String getProjectstatus() {
		if (projectstatus == null) {
			projectstatus = "";
		}
		return projectstatus;
	}
	
	/**
	 * Sets the projectstatus.
	 *
	 * @param projectstatus the projectstatus to set
	 */
	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}
	
	/**
	 * Gets the division.
	 *
	 * @return the division
	 */
	public String getDivision() {
		if (division == null) {
			division = "";
		}
		return division;
	}
	
	/**
	 * Sets the division.
	 *
	 * @param division the new division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Gets the projecttpye.
	 *
	 * @return the projecttpye
	 */
	public String getProjecttpye() {
		if (projecttpye == null){
			projecttpye = "";
		}
		return projecttpye;
	}
	
	/**
	 * Sets the projecttpye.
	 *
	 * @param projecttpye the projecttpye to set
	 */
	public void setProjecttpye(String projecttpye) {
		this.projecttpye = projecttpye;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		if (state == null) {
			state = "";
		}
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the proapplitime.
	 *
	 * @return the proapplitime
	 */
	public Date getProapplitime() {
		return proapplitime;
	}
	
	/**
	 * Gets the proapplitime str.
	 *
	 * @return the proapplitime str
	 */
	public String getProapplitimeStr() {
		return FormatUtil.formatDate(proapplitime,"yyyy-MM-dd");
	}
	
	/**
	 * Sets the proapplitime.
	 *
	 * @param proapplitime the proapplitime to set
	 */
	public void setProapplitime(Date proapplitime) {
		this.proapplitime = proapplitime;
	}
	
	/**
	 * Gets the projectseat.
	 *
	 * @return the projectseat
	 */
	public String getProjectseat() {
		if (projectseat == null) {
			projectseat = "";
		}
		return projectseat;
	}
	
	/**
	 * Sets the projectseat.
	 *
	 * @param projectseat the projectseat to set
	 */
	public void setProjectseat(String projectseat) {
		this.projectseat = projectseat;
	}
	
	/**
	 * Gets the createorg.
	 *
	 * @return the createorg
	 */
	public String getCreateorg() {
		if (createorg == null) {
			createorg = "";
		}
		return createorg;
	}
	
	/**
	 * Sets the createorg.
	 *
	 * @param createorg the createorg to set
	 */
	public void setCreateorg(String createorg) {
		this.createorg = createorg;
	}
	
	/**
	 * Gets the totalprojectno.
	 *
	 * @return the totalprojectno
	 */
	public String getTotalprojectno() {
		return totalprojectno == null ? "":totalprojectno;
	}
	
	/**
	 * Sets the totalprojectno.
	 *
	 * @param totalprojectno the totalprojectno to set
	 */
	public void setTotalprojectno(String totalprojectno) {
		this.totalprojectno = totalprojectno;
	}
	
	/**
	 * Gets the projectexpstart.
	 *
	 * @return the projectexpstart
	 */
	public Date getProjectexpstart() {
		return projectexpstart;
	}
	
	/**
	 * Gets the projectexpstart str.
	 *
	 * @return the projectexpstart str
	 */
	public String getProjectexpstartStr() {
		return FormatUtil.formatDate(projectexpstart,"yyyy-MM-dd");
	}
	
	/**
	 * Sets the projectexpstart.
	 *
	 * @param projectexpstart the projectexpstart to set
	 */
	public void setProjectexpstart(Date projectexpstart) {
		this.projectexpstart = projectexpstart;
	}
	
	/**
	 * Gets the projectexpend.
	 *
	 * @return the projectexpend
	 */
	public Date getProjectexpend() {
		return projectexpend;
	}
	
	/**
	 * Gets the projectexpend str.
	 *
	 * @return the projectexpend str
	 */
	public String getProjectexpendStr() {
		return FormatUtil.formatDate(projectexpend,"yyyy-MM-dd");
	}
	
	/**
	 * Sets the projectexpend.
	 *
	 * @param projectexpend the projectexpend to set
	 */
	public void setProjectexpend(Date projectexpend) {
		this.projectexpend = projectexpend;
	}
	
	/**
	 * Gets the projectmanager.
	 *
	 * @return the projectmanager
	 */
	public String getProjectmanager() {
		if (projectmanager == null) {
			projectmanager = "";
		}
		return projectmanager;
	}
	
	/**
	 * Sets the projectmanager.
	 *
	 * @param projectmanager the projectmanager to set
	 */
	public void setProjectmanager(String projectmanager) {
		this.projectmanager = projectmanager;
	}
	
	/**
	 * Gets the needrecovery.
	 *
	 * @return the needrecovery
	 */
	public int getNeedrecovery() {
		return needrecovery;
	}
	
	/**
	 * Sets the needrecovery.
	 *
	 * @param needrecovery the needrecovery to set
	 */
	public void setNeedrecovery(int needrecovery) {
		this.needrecovery = needrecovery;
	}
	
	/**
	 * Gets the budgetamount.
	 *
	 * @return the budgetamount
	 */
	public BigDecimal getBudgetamount() {
		return budgetamount;
	}
	
	/**
	 * Gets the budgetamount str.
	 *
	 * @return the budgetamount str
	 */
	public String getBudgetamountStr() {
		if (budgetamount == null) return "";
		return budgetamount + "";
	}
	
	/**
	 * Sets the budgetamount.
	 *
	 * @param budgetamount the budgetamount to set
	 */
	public void setBudgetamount(BigDecimal budgetamount) {
		this.budgetamount = budgetamount;
	}
	
	/**
	 * Gets the wheneeddesign.
	 *
	 * @return the wheneeddesign
	 */
	public int getWheneeddesign() {
		return wheneeddesign;
	}
	
	/**
	 * Sets the wheneeddesign.
	 *
	 * @param wheneeddesign the wheneeddesign to set
	 */
	public void setWheneeddesign(int wheneeddesign) {
		this.wheneeddesign = wheneeddesign;
	}
	
	/**
	 * Gets the internalaudit.
	 *
	 * @return the internalaudit
	 */
	public int getInternalaudit() {
		return internalaudit;
	}
	
	/**
	 * Sets the internalaudit.
	 *
	 * @param internalaudit the internalaudit to set
	 */
	public void setInternalaudit(int internalaudit) {
		this.internalaudit = internalaudit;
	}
	
	/**
	 * Gets the exteraudit.
	 *
	 * @return the exteraudit
	 */
	public int getExteraudit() {
		return exteraudit;
	}
	
	/**
	 * Sets the exteraudit.
	 *
	 * @param exteraudit the exteraudit to set
	 */
	public void setExteraudit(int exteraudit) {
		this.exteraudit = exteraudit;
	}
	
	/**
	 * Gets the promanaout.
	 *
	 * @return the promanaout
	 */
	public int getPromanaout() {
		return promanaout;
	}
	
	/**
	 * Sets the promanaout.
	 *
	 * @param promanaout the promanaout to set
	 */
	public void setPromanaout(int promanaout) {
		this.promanaout = promanaout;
	}
	
	/**
	 * Gets the fireapproval.
	 *
	 * @return the fireapproval
	 */
	public int getFireapproval() {
		return fireapproval;
	}
	
	/**
	 * Sets the fireapproval.
	 *
	 * @param fireapproval the fireapproval to set
	 */
	public void setFireapproval(int fireapproval) {
		this.fireapproval = fireapproval;
	}
	
	/**
	 * Gets the whetherfor.
	 *
	 * @return the whetherfor
	 */
	public int getWhetherfor() {
		return whetherfor;
	}
	
	/**
	 * Sets the whetherfor.
	 *
	 * @param whetherfor the whetherfor to set
	 */
	public void setWhetherfor(int whetherfor) {
		this.whetherfor = whetherfor;
	}
	
	/**
	 * Gets the designout.
	 *
	 * @return the designout
	 */
	public int getDesignout() {
		return designout;
	}
	
	/**
	 * Sets the designout.
	 *
	 * @param designout the designout to set
	 */
	public void setDesignout(int designout) {
		this.designout = designout;
	}
	
	/**
	 * Gets the constout.
	 *
	 * @return the constout
	 */
	public int getConstout() {
		return constout;
	}
	
	/**
	 * Sets the constout.
	 *
	 * @param constout the constout to set
	 */
	public void setConstout(int constout) {
		this.constout = constout;
	}
	
	/**
	 * Gets the signsapproval.
	 *
	 * @return the signsapproval
	 */
	public int getSignsapproval() {
		return signsapproval;
	}
	
	/**
	 * Sets the signsapproval.
	 *
	 * @param signsapproval the signsapproval to set
	 */
	public void setSignsapproval(int signsapproval) {
		this.signsapproval = signsapproval;
	}
	
	/**
	 * Gets the builds the.
	 *
	 * @return the build
	 */
	public int getBuild() {
		return build;
	}
	
	/**
	 * Sets the builds the.
	 *
	 * @param build the build to set
	 */
	public void setBuild(int build) {
		this.build = build;
	}
	
	/**
	 * Gets the notpointtype.
	 *
	 * @return the notpointtype
	 */
	public String getNotpointtype() {
		return notpointtype == null ? "" : notpointtype;
	}
	
	/**
	 * Sets the notpointtype.
	 *
	 * @param notpointtype the notpointtype to set
	 */
	public void setNotpointtype(String notpointtype) {
		this.notpointtype = notpointtype;
	}
	
	/**
	 * Gets the engindivision.
	 *
	 * @return the engindivision
	 */
	public String getEngindivision() {
		return engindivision == null ? "" :engindivision;
	}
	
	/**
	 * Sets the engindivision.
	 *
	 * @param engindivision the engindivision to set
	 */
	public void setEngindivision(String engindivision) {
		this.engindivision = engindivision;
	}
	
	/**
	 * Gets the projectlevel.
	 *
	 * @return the projectlevel
	 */
	public String getProjectlevel() {
		return projectlevel == null ? "" :  projectlevel;
	}
	
	/**
	 * Sets the projectlevel.
	 *
	 * @param projectlevel the projectlevel to set
	 */
	public void setProjectlevel(String projectlevel) {
		this.projectlevel = projectlevel;
	}
	
	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		if (remarks == null) {
			remarks = "";
		}
		return remarks;
	}
	
	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * Gets the checks if is whe pro.
	 *
	 * @return the checks if is whe pro
	 */
	public int getIsWhePro() {
		return isWhePro;
	}
	
	/**
	 * Sets the checks if is whe pro.
	 *
	 * @param isWhePro the new checks if is whe pro
	 */
	public void setIsWhePro(int isWhePro) {
		this.isWhePro = isWhePro;
	}
	
	/**
	 * Gets the auditor.
	 *
	 * @return the auditor
	 */
	public String getAuditor() {
		return auditor;
	}
	
	/**
	 * Sets the auditor.
	 *
	 * @param auditor the new auditor
	 */
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	
	/**
	 * Gets the biz date.
	 *
	 * @return the biz date
	 */
	public Date getBizDate() {
		return bizDate;
	}
	
	/**
	 * Sets the biz date.
	 *
	 * @param bizDate the new biz date
	 */
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}
	
	/**
	 * Gets the projec number.
	 *
	 * @return the projec number
	 */
	public String getProjecNumber() {
		return projecNumber;
	}
	
	/**
	 * Sets the projec number.
	 *
	 * @param projecNumber the new projec number
	 */
	public void setProjecNumber(String projecNumber) {
		this.projecNumber = projecNumber;
	}
}