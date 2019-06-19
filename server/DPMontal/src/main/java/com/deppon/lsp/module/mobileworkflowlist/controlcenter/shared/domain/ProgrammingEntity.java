package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;


import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 工程规划单实体
 * @author 徐丁丁
 * @date 2013-10-25 下午3:42:11
 * @since
 * @version
 */
public class ProgrammingEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//创建人；
	private String fCreateId;
	//创建时间；
	private Date fCreateDate;
	//最后修改时间；
	private Date fLastUpDateUserTime;
	//最后修改人；
	private String fLastUpDateUserId;
	// 控制单元FCONTROLUNITID
	private String fControlUniteID;
	//单据编号；FNUMBER
	private String fNumber;
	//业务日期；FBIZDATE
	private Date fBizDate;
	//经手人；FHANDLERID
	private String fHandlerId;
	//参考信息；FDESCRIPTION
	private String fDescription;
	//是否曾经生效：FHASEFFECTED
	private String fHaseffected;
	//FAUDITORID审核人；
	private String fAuditorId;
	//原始单据ID FSOURCEBILLID
	private String fSourCebillId;
	//来源功能；FSOURCEFUNCTION
	private String fSourceFunction;
	//ID;
	private String fId;
	//FFIVOUCHERED 是否生成凭证；
	private String fFivouChered;
	//计划编制业务部门；FPLANDEPARTMENTID
	private String fPlandePartmentId;
	//计划编制人；FFORMATIONPEOPLEID
	private String fFormationPeopleId;
	//单据状态；FSTATE
	private String fState;
	//创建部门；FCREATEORGID
	private String fCreateOrgId;
	//甲供材料模板；FTEMPLATEMATERIALS
	private String fTemplateMaterials;
	
	private String fTemplateMaterialsName;
	//计划年份；FPLANYEAR
	private Date fPlanYear;
	//版本号；FVERSIONSNUMBER
	private String fVersionSnumber;
	//项目类型；FPROJECTTYPE
	private String fProjectTypeId;
	private String fProjectTypeName;
	//是否补录单据；CFISRECORDDATA
	private String cfIsrecordData;
	
	private String fFormationPeopleName;
	
	private String fPlanDepartmentName;
	
	private String fCreateorgName;

	/**
	 * @return the fCreateId
	 */
	public String getfCreateId() {
		return fCreateId;
	}

	/**
	 * @param fCreateId the fCreateId to set
	 */
	public void setfCreateId(String fCreateId) {
		this.fCreateId = fCreateId;
	}

	/**
	 * @return the fCreateDate
	 */
	public Date getfCreateDate() {
		return fCreateDate;
	}

	/**
	 * @param fCreateDate the fCreateDate to set
	 */
	public void setfCreateDate(Date fCreateDate) {
		this.fCreateDate = fCreateDate;
	}

	/**
	 * @return the fLastUpDateUserTime
	 */
	public Date getfLastUpDateUserTime() {
		return fLastUpDateUserTime;
	}

	/**
	 * @param fLastUpDateUserTime the fLastUpDateUserTime to set
	 */
	public void setfLastUpDateUserTime(Date fLastUpDateUserTime) {
		this.fLastUpDateUserTime = fLastUpDateUserTime;
	}

	/**
	 * @return the fLastUpDateUserId
	 */
	public String getfLastUpDateUserId() {
		return fLastUpDateUserId;
	}

	/**
	 * @param fLastUpDateUserId the fLastUpDateUserId to set
	 */
	public void setfLastUpDateUserId(String fLastUpDateUserId) {
		this.fLastUpDateUserId = fLastUpDateUserId;
	}

	/**
	 * @return the fControlUniteID
	 */
	public String getfControlUniteID() {
		return fControlUniteID;
	}

	/**
	 * @param fControlUniteID the fControlUniteID to set
	 */
	public void setfControlUniteID(String fControlUniteID) {
		this.fControlUniteID = fControlUniteID;
	}

	/**
	 * @return the fNumber
	 */
	public String getfNumber() {
		return fNumber;
	}

	/**
	 * @param fNumber the fNumber to set
	 */
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	/**
	 * @return the fBizDate
	 */
	public Date getfBizDate() {
		return fBizDate;
	}

	/**
	 * @param fBizDate the fBizDate to set
	 */
	public void setfBizDate(Date fBizDate) {
		this.fBizDate = fBizDate;
	}

	/**
	 * @return the fHandlerId
	 */
	public String getfHandlerId() {
		return fHandlerId;
	}

	/**
	 * @param fHandlerId the fHandlerId to set
	 */
	public void setfHandlerId(String fHandlerId) {
		this.fHandlerId = fHandlerId;
	}

	/**
	 * @return the fDescription
	 */
	public String getfDescription() {
		return fDescription;
	}

	/**
	 * @param fDescription the fDescription to set
	 */
	public void setfDescription(String fDescription) {
		this.fDescription = fDescription;
	}

	/**
	 * @return the fHaseffected
	 */
	public String getfHaseffected() {
		return fHaseffected;
	}

	/**
	 * @param fHaseffected the fHaseffected to set
	 */
	public void setfHaseffected(String fHaseffected) {
		this.fHaseffected = fHaseffected;
	}

	/**
	 * @return the fAuditorId
	 */
	public String getfAuditorId() {
		return fAuditorId;
	}

	/**
	 * @param fAuditorId the fAuditorId to set
	 */
	public void setfAuditorId(String fAuditorId) {
		this.fAuditorId = fAuditorId;
	}

	/**
	 * @return the fSourCebillId
	 */
	public String getfSourCebillId() {
		return fSourCebillId;
	}

	/**
	 * @param fSourCebillId the fSourCebillId to set
	 */
	public void setfSourCebillId(String fSourCebillId) {
		this.fSourCebillId = fSourCebillId;
	}

	/**
	 * @return the fSourceFunction
	 */
	public String getfSourceFunction() {
		return fSourceFunction;
	}

	/**
	 * @param fSourceFunction the fSourceFunction to set
	 */
	public void setfSourceFunction(String fSourceFunction) {
		this.fSourceFunction = fSourceFunction;
	}

	/**
	 * @return the fId
	 */
	public String getfId() {
		return fId;
	}

	/**
	 * @param fId the fId to set
	 */
	public void setfId(String fId) {
		this.fId = fId;
	}

	/**
	 * @return the fFivouChered
	 */
	public String getfFivouChered() {
		return fFivouChered;
	}

	/**
	 * @param fFivouChered the fFivouChered to set
	 */
	public void setfFivouChered(String fFivouChered) {
		this.fFivouChered = fFivouChered;
	}

	/**
	 * @return the fPlandePartmentId
	 */
	public String getfPlandePartmentId() {
		return fPlandePartmentId;
	}

	/**
	 * @param fPlandePartmentId the fPlandePartmentId to set
	 */
	public void setfPlandePartmentId(String fPlandePartmentId) {
		this.fPlandePartmentId = fPlandePartmentId;
	}

	/**
	 * @return the fFormationPeopleId
	 */
	public String getfFormationPeopleId() {
		return fFormationPeopleId;
	}

	/**
	 * @param fFormationPeopleId the fFormationPeopleId to set
	 */
	public void setfFormationPeopleId(String fFormationPeopleId) {
		this.fFormationPeopleId = fFormationPeopleId;
	}

	/**
	 * @return the fState
	 */
	public String getfState() {
		return fState;
	}

	/**
	 * @param fState the fState to set
	 */
	public void setfState(String fState) {
		this.fState = fState;
	}

	/**
	 * @return the fCreateOrgId
	 */
	public String getfCreateOrgId() {
		return fCreateOrgId;
	}

	/**
	 * @param fCreateOrgId the fCreateOrgId to set
	 */
	public void setfCreateOrgId(String fCreateOrgId) {
		this.fCreateOrgId = fCreateOrgId;
	}

	/**
	 * @return the fTemplateMaterials
	 */
	public String getfTemplateMaterials() {
		return fTemplateMaterials;
	}

	/**
	 * @param fTemplateMaterials the fTemplateMaterials to set
	 */
	public void setfTemplateMaterials(String fTemplateMaterials) {
		this.fTemplateMaterials = fTemplateMaterials;
	}

	/**
	 * @return the fTemplateMaterialsName
	 */
	public String getfTemplateMaterialsName() {
		return fTemplateMaterialsName;
	}

	/**
	 * @param fTemplateMaterialsName the fTemplateMaterialsName to set
	 */
	public void setfTemplateMaterialsName(String fTemplateMaterialsName) {
		this.fTemplateMaterialsName = fTemplateMaterialsName;
	}

	/**
	 * @return the fPlanYear
	 */
	public Date getfPlanYear() {
		return fPlanYear;
	}

	/**
	 * @param fPlanYear the fPlanYear to set
	 */
	public void setfPlanYear(Date fPlanYear) {
		this.fPlanYear = fPlanYear;
	}

	/**
	 * @return the fVersionSnumber
	 */
	public String getfVersionSnumber() {
		return fVersionSnumber;
	}

	/**
	 * @param fVersionSnumber the fVersionSnumber to set
	 */
	public void setfVersionSnumber(String fVersionSnumber) {
		this.fVersionSnumber = fVersionSnumber;
	}

	/**
	 * @return the fProjectTypeId
	 */
	public String getfProjectTypeId() {
		return fProjectTypeId;
	}

	/**
	 * @param fProjectTypeId the fProjectTypeId to set
	 */
	public void setfProjectTypeId(String fProjectTypeId) {
		this.fProjectTypeId = fProjectTypeId;
	}

	/**
	 * @return the fProjectTypeName
	 */
	public String getfProjectTypeName() {
		return fProjectTypeName;
	}

	/**
	 * @param fProjectTypeName the fProjectTypeName to set
	 */
	public void setfProjectTypeName(String fProjectTypeName) {
		this.fProjectTypeName = fProjectTypeName;
	}

	/**
	 * @return the cfIsrecordData
	 */
	public String getCfIsrecordData() {
		return cfIsrecordData;
	}

	/**
	 * @param cfIsrecordData the cfIsrecordData to set
	 */
	public void setCfIsrecordData(String cfIsrecordData) {
		this.cfIsrecordData = cfIsrecordData;
	}

	/**
	 * @return the fFormationPeopleName
	 */
	public String getfFormationPeopleName() {
		return fFormationPeopleName;
	}

	/**
	 * @param fFormationPeopleName the fFormationPeopleName to set
	 */
	public void setfFormationPeopleName(String fFormationPeopleName) {
		this.fFormationPeopleName = fFormationPeopleName;
	}

	/**
	 * @return the fPlanDepartmentName
	 */
	public String getfPlanDepartmentName() {
		return fPlanDepartmentName;
	}

	/**
	 * @param fPlanDepartmentName the fPlanDepartmentName to set
	 */
	public void setfPlanDepartmentName(String fPlanDepartmentName) {
		this.fPlanDepartmentName = fPlanDepartmentName;
	}

	/**
	 * @return the fCreateorgName
	 */
	public String getfCreateorgName() {
		return fCreateorgName;
	}

	/**
	 * @param fCreateorgName the fCreateorgName to set
	 */
	public void setfCreateorgName(String fCreateorgName) {
		this.fCreateorgName = fCreateorgName;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
