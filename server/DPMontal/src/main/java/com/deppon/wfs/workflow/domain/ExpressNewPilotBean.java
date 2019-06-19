package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @title: ExpressNewPilotBean 
 * @description： 快递新增试点网点申请Bean
 * @author： wuyaqing
 * @date： 2013年11月13日 下午2:11:55
 */
/**
 * 命名空间
 */
public class ExpressNewPilotBean implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -8119555283989105153L;

	/**
	 * 主键ID
	 */
    private String busino;
	/**
	 * 流程实例ID
	 */
	private Long processinstid;
	/**
	 * 申请人姓名
	 */
	private String applyPersonName;
	/**
	 * 申请人工号
	 */
	private String applyPersonId;
	/**
	 * 所属部门
	 */
	private String appDept;
	/**
	 * 所属部门标杆编码
	 */
	private String appFinasysCode;
	/**
	 * 部门性质
	 */
	private String deptNature;
	/**
	 * 现部门名称
	 */
	private String nowDeptName;
	/**
	 * 现部门名称标杆编码
	 */
	private String nowDeptCode;
	/**
	 * 点部经理姓名
	 */
	private String pointManager;
	/**
	 * 点部经理工号
	 */
	private String pointManaCode;
	/**
	 * 所属子公司
	 */
	private String subCom;
	/**
	 * 所属事业部
	 */
	private String division;
	/**
	 * 所属人事部
	 */
	private String personnelDept;
	/**
	 * 所属人事部编码
	 */
	private String personnelDeptCode;
	/**
	 * 所属快递大区/分部
	 */
	private String expressRegional;
	/**
	 * 所属快递大区/分部编码
	 */
	private String expressRegionalCode;
	/**
	 * 所属快递点部
	 */
	private String expressPointOf;
	/**
	 * 所属快递点部编码
	 */
	private String expressPointOfCode;
	/**
	 * 所属公共事务组
	 */
	private String affairsGroup;
	/**
	 * 所属公共事务组编码
	 */
	private String affairsGroupCode;
	/**
	 * 所属外场
	 */
	private String outField;
	/**
	 * 所属外场编码
	 */
	private String outFieldCode;
	/**
	 * 所属车队
	 */
	private String carTeam;
	/**
	 * 所属车队编码
	 */
	private String carTeamCode;
	/**
	 * 门店合同面积
	 */
	private BigDecimal storesContractArea;
	/**
	 * 快递货区面积
	 */
	private BigDecimal expressCargoArea;
	/**
	 * 当前点部快递员总数
	 */
	private Long currentTotalNum;
	/**
	 * 点部快递员本月日均操作票数
	 */
	private Long avgDailyOperatNum;
	/**
	 * 部门开业时间
	 */
	private Date deptOpeningTime;
	/**
	 * 申请事由
	 */
	private String applyReason;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 业务状态，是否有效（1-有效 0-无效）
	 */
	private String isEffective;
	/**
	 * 备注1
	 */
	private Long reserve1;
	/**
	 * 备注2
	 */
	private String reserve2;
	/**
	 * 备注3
	 */
	private String reserve3;
	
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
	 * @return the processInstID
	 */
	public Long getProcessinstid() {
		return processinstid;
	}
	/**
	 * @param processInstID the processInstID to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}
	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}
	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	 * @return the appDept
	 */
	public String getAppDept() {
		return appDept;
	}
	/**
	 * @param appDept the appDept to set
	 */
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}
	/**
	 * @return the appFinasysCode
	 */
	public String getAppFinasysCode() {
		return appFinasysCode;
	}
	/**
	 * @param appFinasysCode the appFinasysCode to set
	 */
	public void setAppFinasysCode(String appFinasysCode) {
		this.appFinasysCode = appFinasysCode;
	}
	/**
	 * @return the deptNature
	 */
	public String getDeptNature() {
		return deptNature;
	}
	/**
	 * @param deptNature the deptNature to set
	 */
	public void setDeptNature(String deptNature) {
		this.deptNature = deptNature;
	}
	/**
	 * @return the nowDeptName
	 */
	public String getNowDeptName() {
		return nowDeptName;
	}
	/**
	 * @param nowDeptName the nowDeptName to set
	 */
	public void setNowDeptName(String nowDeptName) {
		this.nowDeptName = nowDeptName;
	}
	/**
	 * @return the nowDeptCode
	 */
	public String getNowDeptCode() {
		return nowDeptCode;
	}
	/**
	 * @param nowDeptCode the nowDeptCode to set
	 */
	public void setNowDeptCode(String nowDeptCode) {
		this.nowDeptCode = nowDeptCode;
	}
	/**
	 * @return the pointManager
	 */
	public String getPointManager() {
		return pointManager;
	}
	/**
	 * @param pointManager the pointManager to set
	 */
	public void setPointManager(String pointManager) {
		this.pointManager = pointManager;
	}
	/**
	 * @return the pointManaCode
	 */
	public String getPointManaCode() {
		return pointManaCode;
	}
	/**
	 * @param pointManaCode the pointManaCode to set
	 */
	public void setPointManaCode(String pointManaCode) {
		this.pointManaCode = pointManaCode;
	}
	/**
	 * @return the subCom
	 */
	public String getSubCom() {
		return subCom;
	}
	/**
	 * @param subCom the subCom to set
	 */
	public void setSubCom(String subCom) {
		this.subCom = subCom;
	}
	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}
	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	/**
	 * @return the personnelDept
	 */
	public String getPersonnelDept() {
		return personnelDept;
	}
	/**
	 * @param personnelDept the personnelDept to set
	 */
	public void setPersonnelDept(String personnelDept) {
		this.personnelDept = personnelDept;
	}
	/**
	 * @return the personnelDeptCode
	 */
	public String getPersonnelDeptCode() {
		return personnelDeptCode;
	}
	/**
	 * @param personnelDeptCode the personnelDeptCode to set
	 */
	public void setPersonnelDeptCode(String personnelDeptCode) {
		this.personnelDeptCode = personnelDeptCode;
	}
	/**
	 * @return the expressRegional
	 */
	public String getExpressRegional() {
		return expressRegional;
	}
	/**
	 * @param expressRegional the expressRegional to set
	 */
	public void setExpressRegional(String expressRegional) {
		this.expressRegional = expressRegional;
	}
	/**
	 * @return the expressRegionalCode
	 */
	public String getExpressRegionalCode() {
		return expressRegionalCode;
	}
	/**
	 * @param expressRegionalCode the expressRegionalCode to set
	 */
	public void setExpressRegionalCode(String expressRegionalCode) {
		this.expressRegionalCode = expressRegionalCode;
	}
	/**
	 * @return the expressPointOf
	 */
	public String getExpressPointOf() {
		return expressPointOf;
	}
	/**
	 * @param expressPointOf the expressPointOf to set
	 */
	public void setExpressPointOf(String expressPointOf) {
		this.expressPointOf = expressPointOf;
	}
	/**
	 * @return the expressPointOfCode
	 */
	public String getExpressPointOfCode() {
		return expressPointOfCode;
	}
	/**
	 * @param expressPointOfCode the expressPointOfCode to set
	 */
	public void setExpressPointOfCode(String expressPointOfCode) {
		this.expressPointOfCode = expressPointOfCode;
	}
	/**
	 * @return the affairsGroup
	 */
	public String getAffairsGroup() {
		return affairsGroup;
	}
	/**
	 * @param affairsGroup the affairsGroup to set
	 */
	public void setAffairsGroup(String affairsGroup) {
		this.affairsGroup = affairsGroup;
	}
	/**
	 * @return the affairsGroupCode
	 */
	public String getAffairsGroupCode() {
		return affairsGroupCode;
	}
	/**
	 * @param affairsGroupCode the affairsGroupCode to set
	 */
	public void setAffairsGroupCode(String affairsGroupCode) {
		this.affairsGroupCode = affairsGroupCode;
	}
	/**
	 * @return the outField
	 */
	public String getOutField() {
		return outField;
	}
	/**
	 * @param outField the outField to set
	 */
	public void setOutField(String outField) {
		this.outField = outField;
	}
	/**
	 * @return the outFieldCode
	 */
	public String getOutFieldCode() {
		return outFieldCode;
	}
	/**
	 * @param outFieldCode the outFieldCode to set
	 */
	public void setOutFieldCode(String outFieldCode) {
		this.outFieldCode = outFieldCode;
	}
	/**
	 * @return the carTeam
	 */
	public String getCarTeam() {
		return carTeam;
	}
	/**
	 * @param carTeam the carTeam to set
	 */
	public void setCarTeam(String carTeam) {
		this.carTeam = carTeam;
	}
	/**
	 * @return the carTeamCode
	 */
	public String getCarTeamCode() {
		return carTeamCode;
	}
	/**
	 * @param carTeamCode the carTeamCode to set
	 */
	public void setCarTeamCode(String carTeamCode) {
		this.carTeamCode = carTeamCode;
	}
	/**
	 * @return the storesContractArea
	 */
	public BigDecimal getStoresContractArea() {
		return storesContractArea;
	}
	/**
	 * @param storesContractArea the storesContractArea to set
	 */
	public void setStoresContractArea(BigDecimal storesContractArea) {
		this.storesContractArea = storesContractArea;
	}
	/**
	 * @return the expressCargoArea
	 */
	public BigDecimal getExpressCargoArea() {
		return expressCargoArea;
	}
	/**
	 * @param expressCargoArea the expressCargoArea to set
	 */
	public void setExpressCargoArea(BigDecimal expressCargoArea) {
		this.expressCargoArea = expressCargoArea;
	}
	/**
	 * @return the currentTotalNum
	 */
	public Long getCurrentTotalNum() {
		return currentTotalNum;
	}
	/**
	 * @param currentTotalNum the currentTotalNum to set
	 */
	public void setCurrentTotalNum(Long currentTotalNum) {
		this.currentTotalNum = currentTotalNum;
	}
	/**
	 * @return the avgDailyOperatNum
	 */
	public Long getAvgDailyOperatNum() {
		return avgDailyOperatNum;
	}
	/**
	 * @param avgDailyOperatNum the avgDailyOperatNum to set
	 */
	public void setAvgDailyOperatNum(Long avgDailyOperatNum) {
		this.avgDailyOperatNum = avgDailyOperatNum;
	}
	/**
	 * @return the deptOpeningTime
	 */
	public Date getDeptOpeningTime() {
		return deptOpeningTime;
	}
	/**
	 * @param deptOpeningTime the deptOpeningTime to set
	 */
	public void setDeptOpeningTime(Date deptOpeningTime) {
		this.deptOpeningTime = deptOpeningTime;
	}
	/**
	 * @return the applyReason
	 */
	public String getApplyReason() {
		return applyReason;
	}
	/**
	 * @param applyReason the applyReason to set
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the isEffective
	 */
	public String getIsEffective() {
		return isEffective;
	}
	/**
	 * @param isEffective the isEffective to set
	 */
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	/**
	 * @return the reserve1
	 */
	public Long getReserve1() {
		return reserve1;
	}
	/**
	 * @param reserve1 the reserve1 to set
	 */
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}
	/**
	 * @return the reserve2
	 */
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * @param reserve2 the reserve2 to set
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	/**
	 * @return the reserve3
	 */
	public String getReserve3() {
		return reserve3;
	}
	/**
	 * @param reserve3 the reserve3 to set
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	
}