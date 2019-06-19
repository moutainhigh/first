/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */ 
package com.deppon.dpm.module.projecttools.shared.domain;

import java.io.Serializable;

/**
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:150976,date:2014-11-25 下午12:32:10,content:TODO </p>
 * @since
 * 项目名称：
 * 类描述：  
 * 创建人：张怡君
 * 创建时间：2014-11-25 下午12:32:10
 * 修改人：张怡君  
 * 修改时间：2014-11-25 下午12:32:10
 * 修改备注：  
 * @version V1.0   
 * @Copyright 2014 德邦物流 Inc. All rights reserved.  
 */
public class UserDemandInfoEntity implements Serializable {

	private static final long serialVersionUID = -700986043533299911L;
	
	//表id
	private long demandId;
	//需求编号
	private String demandCode;
	//需求类别(1:需求规划, 2:IT内部需求)
	private int demandCategory;
	private String demandCategoryVal;
	//是否是bi需求(1:是, 0:否)
	private int demandIsbi;
	private String demandIsbiVal;
	//需求名称
	private String demandName;
	//需求描述
	private String demandDesc;
	//需求提出人工号
	private String demandProEmpcode;
	//需求提出人姓名
	private String demandProEmpname;
	//需求提出部门标杆编码
	private String demandProDeptcode;
	//需求提出部门名称
	private String demandProDeptname;
	//需求所属模块
	private String demandModule;
	//需求对应副总所属系统
	private String demandDeputySys;
	//需求经办分析组标杆编码
	private String demandPassDoDeptcode;
	//需求经办分析组名称
	private String demandPassDoDeptName;
	//经办小组负责人工号
	private String demandPassDoEmpcode;
	//经办小组负责人姓名
	private String demandPassDoEmpname;
	//IT内部需求-所属系统名称
	private String itSysname;
	//IT内部需求-需求类型（1：日常需求， 2：配合项目需求， 3：项目主需求）
	private int itDemandType;
	private String itDemandTypeVal;
	//IT内部需求-涉及项目名称
	private String itProjectName;
	//IT内部需求-需求成效类型
	private String itEffiectType;
	//IT内部需求-需求功能描述
	private String itFuncDesc;
	//IT内部需求-摘要
	private String itSummary;
	//IT内部需求-用户需求说明书实际输出时间
	private String itUserInOutDate;
	//IT内部需求-关联主需求编号
	private String itSysDemandCode;
	//IT内部需求-需求提交至系统分析组时间
	private String itSubtoPassDodate;
	//需求规划-需求紧急程度
	private String dmghUrgentCase;
	//需求规划-需求功能点
	private String dmghFuncPoint;
	//需求规划-业务价值区间
	private String dmghBusPriceInterval;
	//需求规划-业务价值评估
	private String dmghBusPriceEvaluate;
	//需求规划-期望完成时间
	private String dmghHopeFinishDate;
	//需求规划BI需求-功能模块
	private String biFuncModule;
	//需求规划BI需求-变更内容
	private String biChangeContent;
	//需求规划BI需求-是否涉及流程变更
	private String biProcessChange;
	//需求规划BI需求-是否涉及其他系统变更
	private String biOtherSysChange;
	//需求规划BI需求-优先级评估
	private String biEvaluateLevel;
	//需求规划非BI需求-涉及的流程
	private String nbiProcessName;
	//需求规划非BI需求-功能使用率
	private String nbiFuncUseRate;
	//是否解决
	private String demandIsSolve;
	//工作流号
	private String wfsCode;
	//工作流业务编号
	private String bizCode;
	//需求创建时间
	private String demandCreateDate;
	private String processsupport;
	
	
	//需求状态
	private String demandstate;
	//主需求经办人
	private String nextDealEmpname;
	//主需求报告人
	private String reportEmpname;
	//主需求经办小组负责人
	private String nextDealLeader;
	//主需求最近一次更新时间
	private String lastChangeDate;
	
	//实际需求提出人工号
	private String shijidemandempcode;
	//实际需求提出人名字
    private String shijidemandname;
     
    //IT系统分析组名称
    private String itAnalysisDeptname;
    //IT系统分析组编码
    private String itAnalysisDeptcode;
    
    //新增责任部门访问人数
    private String dmResDeptVisits;
    
	/**
	 * demandId <p>getter method</p>
	 * @author 150976
	 * @return  the demandId
	 */
	public long getDemandId() {
		return demandId;
	}
	/**
	 * demandId <p>setter method</p>
	 * @author 150976
	 * @param demandId the demandId to set
	 */
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	/**
	 * demandCode <p>getter method</p>
	 * @author 150976
	 * @return  the demandCode
	 */
	public String getDemandCode() {
		return demandCode;
	}
	/**
	 * demandCode <p>setter method</p>
	 * @author 150976
	 * @param demandCode the demandCode to set
	 */
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}
	/**
	 * demandCategory <p>getter method</p>
	 * @author 150976
	 * @return  the demandCategory
	 */
	public int getDemandCategory() {
		return demandCategory;
	}
	/**
	 * demandCategory <p>setter method</p>
	 * @author 150976
	 * @param demandCategory the demandCategory to set
	 */
	public void setDemandCategory(int demandCategory) {
		this.demandCategory = demandCategory;
	}
	/**
	 * demandCategoryVal <p>getter method</p>
	 * @author 150976
	 * @return  the demandCategoryVal
	 */
	public String getDemandCategoryVal() {
		return demandCategoryVal;
	}
	/**
	 * demandCategoryVal <p>setter method</p>
	 * @author 150976
	 * @param demandCategoryVal the demandCategoryVal to set
	 */
	public void setDemandCategoryVal(String demandCategoryVal) {
		this.demandCategoryVal = demandCategoryVal;
	}
	/**
	 * demandIsbi <p>getter method</p>
	 * @author 150976
	 * @return  the demandIsbi
	 */
	public int getDemandIsbi() {
		return demandIsbi;
	}
	/**
	 * demandIsbi <p>setter method</p>
	 * @author 150976
	 * @param demandIsbi the demandIsbi to set
	 */
	public void setDemandIsbi(int demandIsbi) {
		this.demandIsbi = demandIsbi;
	}
	/**
	 * demandIsbiVal <p>getter method</p>
	 * @author 150976
	 * @return  the demandIsbiVal
	 */
	public String getDemandIsbiVal() {
		return demandIsbiVal;
	}
	/**
	 * demandIsbiVal <p>setter method</p>
	 * @author 150976
	 * @param demandIsbiVal the demandIsbiVal to set
	 */
	public void setDemandIsbiVal(String demandIsbiVal) {
		this.demandIsbiVal = demandIsbiVal;
	}
	/**
	 * demandName <p>getter method</p>
	 * @author 150976
	 * @return  the demandName
	 */
	public String getDemandName() {
		return demandName;
	}
	/**
	 * demandName <p>setter method</p>
	 * @author 150976
	 * @param demandName the demandName to set
	 */
	public void setDemandName(String demandName) {
		this.demandName = demandName;
	}
	/**
	 * demandDesc <p>getter method</p>
	 * @author 150976
	 * @return  the demandDesc
	 */
	public String getDemandDesc() {
		return demandDesc;
	}
	/**
	 * demandDesc <p>setter method</p>
	 * @author 150976
	 * @param demandDesc the demandDesc to set
	 */
	public void setDemandDesc(String demandDesc) {
		this.demandDesc = demandDesc;
	}
	/**
	 * demandProEmpcode <p>getter method</p>
	 * @author 150976
	 * @return  the demandProEmpcode
	 */
	public String getDemandProEmpcode() {
		return demandProEmpcode;
	}
	/**
	 * demandProEmpcode <p>setter method</p>
	 * @author 150976
	 * @param demandProEmpcode the demandProEmpcode to set
	 */
	public void setDemandProEmpcode(String demandProEmpcode) {
		this.demandProEmpcode = demandProEmpcode;
	}
	/**
	 * demandProEmpname <p>getter method</p>
	 * @author 150976
	 * @return  the demandProEmpname
	 */
	public String getDemandProEmpname() {
		return demandProEmpname;
	}
	/**
	 * demandProEmpname <p>setter method</p>
	 * @author 150976
	 * @param demandProEmpname the demandProEmpname to set
	 */
	public void setDemandProEmpname(String demandProEmpname) {
		this.demandProEmpname = demandProEmpname;
	}
	/**
	 * demandProDeptcode <p>getter method</p>
	 * @author 150976
	 * @return  the demandProDeptcode
	 */
	public String getDemandProDeptcode() {
		return demandProDeptcode;
	}
	/**
	 * demandProDeptcode <p>setter method</p>
	 * @author 150976
	 * @param demandProDeptcode the demandProDeptcode to set
	 */
	public void setDemandProDeptcode(String demandProDeptcode) {
		this.demandProDeptcode = demandProDeptcode;
	}
	/**
	 * demandProDeptname <p>getter method</p>
	 * @author 150976
	 * @return  the demandProDeptname
	 */
	public String getDemandProDeptname() {
		return demandProDeptname;
	}
	/**
	 * demandProDeptname <p>setter method</p>
	 * @author 150976
	 * @param demandProDeptname the demandProDeptname to set
	 */
	public void setDemandProDeptname(String demandProDeptname) {
		this.demandProDeptname = demandProDeptname;
	}
	/**
	 * demandModule <p>getter method</p>
	 * @author 150976
	 * @return  the demandModule
	 */
	public String getDemandModule() {
		return demandModule;
	}
	/**
	 * demandModule <p>setter method</p>
	 * @author 150976
	 * @param demandModule the demandModule to set
	 */
	public void setDemandModule(String demandModule) {
		this.demandModule = demandModule;
	}
	/**
	 * demandDeputySys <p>getter method</p>
	 * @author 150976
	 * @return  the demandDeputySys
	 */
	public String getDemandDeputySys() {
		return demandDeputySys;
	}
	/**
	 * demandDeputySys <p>setter method</p>
	 * @author 150976
	 * @param demandDeputySys the demandDeputySys to set
	 */
	public void setDemandDeputySys(String demandDeputySys) {
		this.demandDeputySys = demandDeputySys;
	}
	/**
	 * demandPassDoDeptcode <p>getter method</p>
	 * @author 150976
	 * @return  the demandPassDoDeptcode
	 */
	public String getDemandPassDoDeptcode() {
		return demandPassDoDeptcode;
	}
	/**
	 * demandPassDoDeptcode <p>setter method</p>
	 * @author 150976
	 * @param demandPassDoDeptcode the demandPassDoDeptcode to set
	 */
	public void setDemandPassDoDeptcode(String demandPassDoDeptcode) {
		this.demandPassDoDeptcode = demandPassDoDeptcode;
	}
	/**
	 * demandPassDoDeptName <p>getter method</p>
	 * @author 150976
	 * @return  the demandPassDoDeptName
	 */
	public String getDemandPassDoDeptName() {
		return demandPassDoDeptName;
	}
	/**
	 * demandPassDoDeptName <p>setter method</p>
	 * @author 150976
	 * @param demandPassDoDeptName the demandPassDoDeptName to set
	 */
	public void setDemandPassDoDeptName(String demandPassDoDeptName) {
		this.demandPassDoDeptName = demandPassDoDeptName;
	}
	/**
	 * demandPassDoEmpcode <p>getter method</p>
	 * @author 150976
	 * @return  the demandPassDoEmpcode
	 */
	public String getDemandPassDoEmpcode() {
		return demandPassDoEmpcode;
	}
	/**
	 * demandPassDoEmpcode <p>setter method</p>
	 * @author 150976
	 * @param demandPassDoEmpcode the demandPassDoEmpcode to set
	 */
	public void setDemandPassDoEmpcode(String demandPassDoEmpcode) {
		this.demandPassDoEmpcode = demandPassDoEmpcode;
	}
	/**
	 * demandPassDoEmpname <p>getter method</p>
	 * @author 150976
	 * @return  the demandPassDoEmpname
	 */
	public String getDemandPassDoEmpname() {
		return demandPassDoEmpname;
	}
	/**
	 * demandPassDoEmpname <p>setter method</p>
	 * @author 150976
	 * @param demandPassDoEmpname the demandPassDoEmpname to set
	 */
	public void setDemandPassDoEmpname(String demandPassDoEmpname) {
		this.demandPassDoEmpname = demandPassDoEmpname;
	}
	/**
	 * itSysname <p>getter method</p>
	 * @author 150976
	 * @return  the itSysname
	 */
	public String getItSysname() {
		return itSysname;
	}
	/**
	 * itSysname <p>setter method</p>
	 * @author 150976
	 * @param itSysname the itSysname to set
	 */
	public void setItSysname(String itSysname) {
		this.itSysname = itSysname;
	}
	/**
	 * itDemandType <p>getter method</p>
	 * @author 150976
	 * @return  the itDemandType
	 */
	public int getItDemandType() {
		return itDemandType;
	}
	/**
	 * itDemandType <p>setter method</p>
	 * @author 150976
	 * @param itDemandType the itDemandType to set
	 */
	public void setItDemandType(int itDemandType) {
		this.itDemandType = itDemandType;
	}
	/**
	 * itDemandTypeVal <p>getter method</p>
	 * @author 150976
	 * @return  the itDemandTypeVal
	 */
	public String getItDemandTypeVal() {
		return itDemandTypeVal;
	}
	/**
	 * itDemandTypeVal <p>setter method</p>
	 * @author 150976
	 * @param itDemandTypeVal the itDemandTypeVal to set
	 */
	public void setItDemandTypeVal(String itDemandTypeVal) {
		this.itDemandTypeVal = itDemandTypeVal;
	}
	/**
	 * itProjectName <p>getter method</p>
	 * @author 150976
	 * @return  the itProjectName
	 */
	public String getItProjectName() {
		return itProjectName;
	}
	/**
	 * itProjectName <p>setter method</p>
	 * @author 150976
	 * @param itProjectName the itProjectName to set
	 */
	public void setItProjectName(String itProjectName) {
		this.itProjectName = itProjectName;
	}
	/**
	 * itEffiectType <p>getter method</p>
	 * @author 150976
	 * @return  the itEffiectType
	 */
	public String getItEffiectType() {
		return itEffiectType;
	}
	/**
	 * itEffiectType <p>setter method</p>
	 * @author 150976
	 * @param itEffiectType the itEffiectType to set
	 */
	public void setItEffiectType(String itEffiectType) {
		this.itEffiectType = itEffiectType;
	}
	/**
	 * itFuncDesc <p>getter method</p>
	 * @author 150976
	 * @return  the itFuncDesc
	 */
	public String getItFuncDesc() {
		return itFuncDesc;
	}
	/**
	 * itFuncDesc <p>setter method</p>
	 * @author 150976
	 * @param itFuncDesc the itFuncDesc to set
	 */
	public void setItFuncDesc(String itFuncDesc) {
		this.itFuncDesc = itFuncDesc;
	}
	/**
	 * itSummary <p>getter method</p>
	 * @author 150976
	 * @return  the itSummary
	 */
	public String getItSummary() {
		return itSummary;
	}
	/**
	 * itSummary <p>setter method</p>
	 * @author 150976
	 * @param itSummary the itSummary to set
	 */
	public void setItSummary(String itSummary) {
		this.itSummary = itSummary;
	}
	/**
	 * itUserInOutDate <p>getter method</p>
	 * @author 150976
	 * @return  the itUserInOutDate
	 */
	public String getItUserInOutDate() {
		return itUserInOutDate;
	}
	/**
	 * itUserInOutDate <p>setter method</p>
	 * @author 150976
	 * @param itUserInOutDate the itUserInOutDate to set
	 */
	public void setItUserInOutDate(String itUserInOutDate) {
		this.itUserInOutDate = itUserInOutDate;
	}
	/**
	 * itSysDemandCode <p>getter method</p>
	 * @author 150976
	 * @return  the itSysDemandCode
	 */
	public String getItSysDemandCode() {
		return itSysDemandCode;
	}
	/**
	 * itSysDemandCode <p>setter method</p>
	 * @author 150976
	 * @param itSysDemandCode the itSysDemandCode to set
	 */
	public void setItSysDemandCode(String itSysDemandCode) {
		this.itSysDemandCode = itSysDemandCode;
	}
	/**
	 * itSubtoPassDodate <p>getter method</p>
	 * @author 150976
	 * @return  the itSubtoPassDodate
	 */
	public String getItSubtoPassDodate() {
		return itSubtoPassDodate;
	}
	/**
	 * itSubtoPassDodate <p>setter method</p>
	 * @author 150976
	 * @param itSubtoPassDodate the itSubtoPassDodate to set
	 */
	public void setItSubtoPassDodate(String itSubtoPassDodate) {
		this.itSubtoPassDodate = itSubtoPassDodate;
	}
	/**
	 * dmghUrgentCase <p>getter method</p>
	 * @author 150976
	 * @return  the dmghUrgentCase
	 */
	public String getDmghUrgentCase() {
		return dmghUrgentCase;
	}
	/**
	 * dmghUrgentCase <p>setter method</p>
	 * @author 150976
	 * @param dmghUrgentCase the dmghUrgentCase to set
	 */
	public void setDmghUrgentCase(String dmghUrgentCase) {
		this.dmghUrgentCase = dmghUrgentCase;
	}
	/**
	 * dmghFuncPoint <p>getter method</p>
	 * @author 150976
	 * @return  the dmghFuncPoint
	 */
	public String getDmghFuncPoint() {
		return dmghFuncPoint;
	}
	/**
	 * dmghFuncPoint <p>setter method</p>
	 * @author 150976
	 * @param dmghFuncPoint the dmghFuncPoint to set
	 */
	public void setDmghFuncPoint(String dmghFuncPoint) {
		this.dmghFuncPoint = dmghFuncPoint;
	}
	/**
	 * dmghBusPriceInterval <p>getter method</p>
	 * @author 150976
	 * @return  the dmghBusPriceInterval
	 */
	public String getDmghBusPriceInterval() {
		return dmghBusPriceInterval;
	}
	/**
	 * dmghBusPriceInterval <p>setter method</p>
	 * @author 150976
	 * @param dmghBusPriceInterval the dmghBusPriceInterval to set
	 */
	public void setDmghBusPriceInterval(String dmghBusPriceInterval) {
		this.dmghBusPriceInterval = dmghBusPriceInterval;
	}
	/**
	 * dmghBusPriceEvaluate <p>getter method</p>
	 * @author 150976
	 * @return  the dmghBusPriceEvaluate
	 */
	public String getDmghBusPriceEvaluate() {
		return dmghBusPriceEvaluate;
	}
	/**
	 * dmghBusPriceEvaluate <p>setter method</p>
	 * @author 150976
	 * @param dmghBusPriceEvaluate the dmghBusPriceEvaluate to set
	 */
	public void setDmghBusPriceEvaluate(String dmghBusPriceEvaluate) {
		this.dmghBusPriceEvaluate = dmghBusPriceEvaluate;
	}
	/**
	 * dmghHopeFinishDate <p>getter method</p>
	 * @author 150976
	 * @return  the dmghHopeFinishDate
	 */
	public String getDmghHopeFinishDate() {
		return dmghHopeFinishDate;
	}
	/**
	 * dmghHopeFinishDate <p>setter method</p>
	 * @author 150976
	 * @param dmghHopeFinishDate the dmghHopeFinishDate to set
	 */
	public void setDmghHopeFinishDate(String dmghHopeFinishDate) {
		this.dmghHopeFinishDate = dmghHopeFinishDate;
	}
	/**
	 * biFuncModule <p>getter method</p>
	 * @author 150976
	 * @return  the biFuncModule
	 */
	public String getBiFuncModule() {
		return biFuncModule;
	}
	/**
	 * biFuncModule <p>setter method</p>
	 * @author 150976
	 * @param biFuncModule the biFuncModule to set
	 */
	public void setBiFuncModule(String biFuncModule) {
		this.biFuncModule = biFuncModule;
	}
	/**
	 * biChangeContent <p>getter method</p>
	 * @author 150976
	 * @return  the biChangeContent
	 */
	public String getBiChangeContent() {
		return biChangeContent;
	}
	/**
	 * biChangeContent <p>setter method</p>
	 * @author 150976
	 * @param biChangeContent the biChangeContent to set
	 */
	public void setBiChangeContent(String biChangeContent) {
		this.biChangeContent = biChangeContent;
	}
	/**
	 * biProcessChange <p>getter method</p>
	 * @author 150976
	 * @return  the biProcessChange
	 */
	public String getBiProcessChange() {
		return biProcessChange;
	}
	/**
	 * biProcessChange <p>setter method</p>
	 * @author 150976
	 * @param biProcessChange the biProcessChange to set
	 */
	public void setBiProcessChange(String biProcessChange) {
		this.biProcessChange = biProcessChange;
	}
	/**
	 * biOtherSysChange <p>getter method</p>
	 * @author 150976
	 * @return  the biOtherSysChange
	 */
	public String getBiOtherSysChange() {
		return biOtherSysChange;
	}
	/**
	 * biOtherSysChange <p>setter method</p>
	 * @author 150976
	 * @param biOtherSysChange the biOtherSysChange to set
	 */
	public void setBiOtherSysChange(String biOtherSysChange) {
		this.biOtherSysChange = biOtherSysChange;
	}
	/**
	 * biEvaluateLevel <p>getter method</p>
	 * @author 150976
	 * @return  the biEvaluateLevel
	 */
	public String getBiEvaluateLevel() {
		return biEvaluateLevel;
	}
	/**
	 * biEvaluateLevel <p>setter method</p>
	 * @author 150976
	 * @param biEvaluateLevel the biEvaluateLevel to set
	 */
	public void setBiEvaluateLevel(String biEvaluateLevel) {
		this.biEvaluateLevel = biEvaluateLevel;
	}
	/**
	 * nbiProcessName <p>getter method</p>
	 * @author 150976
	 * @return  the nbiProcessName
	 */
	public String getNbiProcessName() {
		return nbiProcessName;
	}
	/**
	 * nbiProcessName <p>setter method</p>
	 * @author 150976
	 * @param nbiProcessName the nbiProcessName to set
	 */
	public void setNbiProcessName(String nbiProcessName) {
		this.nbiProcessName = nbiProcessName;
	}
	/**
	 * nbiFuncUseRate <p>getter method</p>
	 * @author 150976
	 * @return  the nbiFuncUseRate
	 */
	public String getNbiFuncUseRate() {
		return nbiFuncUseRate;
	}
	/**
	 * nbiFuncUseRate <p>setter method</p>
	 * @author 150976
	 * @param nbiFuncUseRate the nbiFuncUseRate to set
	 */
	public void setNbiFuncUseRate(String nbiFuncUseRate) {
		this.nbiFuncUseRate = nbiFuncUseRate;
	}
	/**
	 * demandIsSolve <p>getter method</p>
	 * @author 150976
	 * @return  the demandIsSolve
	 */
	public String getDemandIsSolve() {
		return demandIsSolve;
	}
	/**
	 * demandIsSolve <p>setter method</p>
	 * @author 150976
	 * @param demandIsSolve the demandIsSolve to set
	 */
	public void setDemandIsSolve(String demandIsSolve) {
		this.demandIsSolve = demandIsSolve;
	}
	/**
	 * wfsCode <p>getter method</p>
	 * @author 150976
	 * @return  the wfsCode
	 */
	public String getWfsCode() {
		return wfsCode;
	}
	/**
	 * wfsCode <p>setter method</p>
	 * @author 150976
	 * @param wfsCode the wfsCode to set
	 */
	public void setWfsCode(String wfsCode) {
		this.wfsCode = wfsCode;
	}
	/**
	 * bizCode <p>getter method</p>
	 * @author 150976
	 * @return  the bizCode
	 */
	public String getBizCode() {
		return bizCode;
	}
	/**
	 * bizCode <p>setter method</p>
	 * @author 150976
	 * @param bizCode the bizCode to set
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	/**
	 * demandCreateDate <p>getter method</p>
	 * @author 150976
	 * @return  the demandCreateDate
	 */
	public String getDemandCreateDate() {
		return demandCreateDate;
	}
	/**
	 * demandCreateDate <p>setter method</p>
	 * @author 150976
	 * @param demandCreateDate the demandCreateDate to set
	 */
	public void setDemandCreateDate(String demandCreateDate) {
		this.demandCreateDate = demandCreateDate;
	}
	/**
	 * demandstate <p>getter method</p>
	 * @author 150976
	 * @return  the demandstate
	 */
	public String getDemandstate() {
		return demandstate;
	}
	/**
	 * demandstate <p>setter method</p>
	 * @author 150976
	 * @param demandstate the demandstate to set
	 */
	public void setDemandstate(String demandstate) {
		this.demandstate = demandstate;
	}
	/**
	 * nextDealEmpname <p>getter method</p>
	 * @author 150976
	 * @return  the nextDealEmpname
	 */
	public String getNextDealEmpname() {
		return nextDealEmpname;
	}
	/**
	 * nextDealEmpname <p>setter method</p>
	 * @author 150976
	 * @param nextDealEmpname the nextDealEmpname to set
	 */
	public void setNextDealEmpname(String nextDealEmpname) {
		this.nextDealEmpname = nextDealEmpname;
	}
	/**
	 * reportEmpname <p>getter method</p>
	 * @author 150976
	 * @return  the reportEmpname
	 */
	public String getReportEmpname() {
		return reportEmpname;
	}
	/**
	 * reportEmpname <p>setter method</p>
	 * @author 150976
	 * @param reportEmpname the reportEmpname to set
	 */
	public void setReportEmpname(String reportEmpname) {
		this.reportEmpname = reportEmpname;
	}
	/**
	 * nextDealLeader <p>getter method</p>
	 * @author 150976
	 * @return  the nextDealLeader
	 */
	public String getNextDealLeader() {
		return nextDealLeader;
	}
	/**
	 * nextDealLeader <p>setter method</p>
	 * @author 150976
	 * @param nextDealLeader the nextDealLeader to set
	 */
	public void setNextDealLeader(String nextDealLeader) {
		this.nextDealLeader = nextDealLeader;
	}
	/**
	 * lastChangeDate <p>getter method</p>
	 * @author 150976
	 * @return  the lastChangeDate
	 */
	public String getLastChangeDate() {
		return lastChangeDate;
	}
	/**
	 * lastChangeDate <p>setter method</p>
	 * @author 150976
	 * @param lastChangeDate the lastChangeDate to set
	 */
	public void setLastChangeDate(String lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}
	/**
	 * shijidemandempcode <p>getter method</p>
	 * @author 150976
	 * @return  the shijidemandempcode
	 */
	public String getShijidemandempcode() {
		return shijidemandempcode;
	}
	/**
	 * shijidemandempcode <p>setter method</p>
	 * @author 150976
	 * @param shijidemandempcode the shijidemandempcode to set
	 */
	public void setShijidemandempcode(String shijidemandempcode) {
		this.shijidemandempcode = shijidemandempcode;
	}
	/**
	 * shijidemandname <p>getter method</p>
	 * @author 150976
	 * @return  the shijidemandname
	 */
	public String getShijidemandname() {
		return shijidemandname;
	}
	/**
	 * shijidemandname <p>setter method</p>
	 * @author 150976
	 * @param shijidemandname the shijidemandname to set
	 */
	public void setShijidemandname(String shijidemandname) {
		this.shijidemandname = shijidemandname;
	}
	/**
	 * itAnalysisDeptname <p>getter method</p>
	 * @author 150976
	 * @return  the itAnalysisDeptname
	 */
	public String getItAnalysisDeptname() {
		return itAnalysisDeptname;
	}
	/**
	 * itAnalysisDeptname <p>setter method</p>
	 * @author 150976
	 * @param itAnalysisDeptname the itAnalysisDeptname to set
	 */
	public void setItAnalysisDeptname(String itAnalysisDeptname) {
		this.itAnalysisDeptname = itAnalysisDeptname;
	}
	/**
	 * itAnalysisDeptcode <p>getter method</p>
	 * @author 150976
	 * @return  the itAnalysisDeptcode
	 */
	public String getItAnalysisDeptcode() {
		return itAnalysisDeptcode;
	}
	/**
	 * itAnalysisDeptcode <p>setter method</p>
	 * @author 150976
	 * @param itAnalysisDeptcode the itAnalysisDeptcode to set
	 */
	public void setItAnalysisDeptcode(String itAnalysisDeptcode) {
		this.itAnalysisDeptcode = itAnalysisDeptcode;
	}
	public String getProcesssupport() {
		return processsupport;
	}
	public void setProcesssupport(String processsupport) {
		this.processsupport = processsupport;
	}
	public String getDmResDeptVisits() {
		return dmResDeptVisits;
	}
	public void setDmResDeptVisits(String dmResDeptVisits) {
		this.dmResDeptVisits = dmResDeptVisits;
	}

}
