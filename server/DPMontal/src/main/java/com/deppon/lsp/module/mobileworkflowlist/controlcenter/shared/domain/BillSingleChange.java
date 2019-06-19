/**   
* @Title: BillSingleChange.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐丁钉   
* @date 2013-11-2 下午4:39:12  
*/
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.montal.util.FormatUtil;

/** 
 * @ClassName: BillSingleChange 
 * @Description: TODO(工程量单变更单) 
 * @author 徐丁钉
 * @date 2013-11-2 下午4:39:12 
 *  
 */
public class BillSingleChange extends BaseEntity{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	//创建者；
	private String fCreatorId;
	//创建时间；
	private Date fCreateTime;
	//最后修改人
	private String fLastUpDateUserId;  
	//最后修改时间
	private Date fLastUpDateTime;
	//控制单元；
	private String fControlUnitId;
	//变更编号；
	private String fNumber;           
	//业务发生日期；
	private Date fBizDate;
	//经手人
	private String fHandlerId;
	//参考消息
	private String fDescription;
	//是否曾经生效；
	private int fHaseffected;
	//审核人；
	private String fAuditorId;
	//原始单据ID
	private String fSourceBillId; 
	//来源功能；
	private String fSourceFunction;
	
	//
	private String fId;       
	//是否生成凭证；
	private int fFivouchered;
	//项目编号
	private String cfProNumberId;
	private String cfProNumber;
	//项目名称ID
	private String cfProName;        
	//原量单编号
	private String cfOriginalNumbers; 
	
	//项目状态
	private String cfProState;         
	//申请变更人ID
	private String cfVariationPersoni; 
	
	private String cfVariationPerson; 
	//变更日期
	private Date cfVariationTime;    
	//变更原因
	private String cfVariationReasonId; 
	private String cfVariationReasonName; 
	//单据状态
	private String fState;            
	private Date cfAuditTime;      
	//创建部门
	private String cfCreateOrgUnitId;  
	private String cfCreateOrgUnitName;  
	//具体描述
	private String fRepresent;
	//项目状态；
	private String fProType;
	
	/*************************************getter/setter******************************************************/
	
	
	/**
	 * @return the fCreatorId
	 */
	public String getfCreatorId() {
		return fCreatorId;
	}
	/**
	 * @param fCreatorId the fCreatorId to set
	 */
	public void setfCreatorId(String fCreatorId) {
		this.fCreatorId = fCreatorId;
	}
	/**
	 * @return the fCreateTime
	 */
	public Date getfCreateTime() {
		return fCreateTime;
	}
	/**
	 * @param fCreateTime the fCreateTime to set
	 */
	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
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
	 * @return the fLastUpDateTime
	 */
	public Date getfLastUpDateTime() {
		return fLastUpDateTime;
	}
	/**
	 * @param fLastUpDateTime the fLastUpDateTime to set
	 */
	public void setfLastUpDateTime(Date fLastUpDateTime) {
		this.fLastUpDateTime = fLastUpDateTime;
	}
	/**
	 * @return the fControlUnitId
	 */
	public String getfControlUnitId() {
		return fControlUnitId;
	}
	/**
	 * @param fControlUnitId the fControlUnitId to set
	 */
	public void setfControlUnitId(String fControlUnitId) {
		this.fControlUnitId = fControlUnitId;
	}
	/**
	 * @return the fNumber
	 */
	public String getfNumber() {
		if (fNumber == null) {
			fNumber = "";
		}
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
	public int getfHaseffected() {
		return fHaseffected;
	}
	/**
	 * @param fHaseffected the fHaseffected to set
	 */
	public void setfHaseffected(int fHaseffected) {
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
	 * @return the fSourceBillId
	 */
	public String getfSourceBillId() {
		return fSourceBillId;
	}
	/**
	 * @param fSourceBillId the fSourceBillId to set
	 */
	public void setfSourceBillId(String fSourceBillId) {
		this.fSourceBillId = fSourceBillId;
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
	 * @return the fFivouchered
	 */
	public int getfFivouchered() {
		return fFivouchered;
	}
	/**
	 * @param fFivouchered the fFivouchered to set
	 */
	public void setfFivouchered(int fFivouchered) {
		this.fFivouchered = fFivouchered;
	}
	/**
	 * @return the cfProNumberId
	 */
	public String getCfProNumberId() {
		if (cfProNumberId == null) {
			cfProNumberId = "";
		}
		return cfProNumberId;
	}
	/**
	 * @param cfProNumberId the cfProNumberId to set
	 */
	public void setCfProNumberId(String cfProNumberId) {
		this.cfProNumberId = cfProNumberId;
	}
	/**
	 * @return the cfProName
	 */
	public String getCfProName() {
		if (cfProName == null) {
			cfProName = "";
		}
		return cfProName;
	}
	/**
	 * @param cfProName the cfProName to set
	 */
	public void setCfProName(String cfProName) {
		this.cfProName = cfProName;
	}
	/**
	 * @return the cfOriginalNumbers
	 */
	public String getCfOriginalNumbers() {
		if (cfOriginalNumbers == null) {
			cfOriginalNumbers = "";
		}
		return cfOriginalNumbers;
	}
	/**
	 * @param cfOriginalNumbers the cfOriginalNumbers to set
	 */
	public void setCfOriginalNumbers(String cfOriginalNumbers) {
		this.cfOriginalNumbers = cfOriginalNumbers;
	}
	/**
	 * @return the cfProState
	 */
	public String getCfProState() {
		if (cfProState == null) {
			cfProState = "";
		}
		return cfProState;
	}
	/**
	 * @param cfProState the cfProState to set
	 */
	public void setCfProState(String cfProState) {
		this.cfProState = cfProState;
	}
	/**
	 * @return the cfVariationPersoni
	 */
	public String getCfVariationPersoni() {
		return cfVariationPersoni;
	}
	/**
	 * @param cfVariationPersoni the cfVariationPersoni to set
	 */
	public void setCfVariationPersoni(String cfVariationPersoni) {
		this.cfVariationPersoni = cfVariationPersoni;
	}
	/**
	 * @return the cfVariationPerson
	 */
	public String getCfVariationPerson() {
		if (cfVariationPerson == null) {
			cfVariationPerson = "";
		}
		return cfVariationPerson;
	}
	/**
	 * @param cfVariationPerson the cfVariationPerson to set
	 */
	public void setCfVariationPerson(String cfVariationPerson) {
		this.cfVariationPerson = cfVariationPerson;
	}
	/**
	 * @return the cfVariationTime
	 */
	public Date getCfVariationTime() {
		return cfVariationTime;
	}
	
	public String getCfVariationTimeStr() {
		return FormatUtil.formatDate(cfVariationTime,"yyyy-MM-dd");
	}
	/**
	 * @param cfVariationTime the cfVariationTime to set
	 */
	public void setCfVariationTime(Date cfVariationTime) {
		this.cfVariationTime = cfVariationTime;
	}
	/**
	 * @return the cfVariationReasonId
	 */
	public String getCfVariationReasonId() {
		return cfVariationReasonId;
	}
	/**
	 * @param cfVariationReasonId the cfVariationReasonId to set
	 */
	public void setCfVariationReasonId(String cfVariationReasonId) {
		this.cfVariationReasonId = cfVariationReasonId;
	}
	/**
	 * @return the fState
	 */
	public String getfState() {
		if (fState == null) {
			fState = "";
		}
		return fState;
	}
	/**
	 * @param fState the fState to set
	 */
	public void setfState(String fState) {
		this.fState = fState;
	}
	/**
	 * @return the cfAuditTime
	 */
	public Date getCfAuditTime() {
		return cfAuditTime;
	}
	/**
	 * @param cfAuditTime the cfAuditTime to set
	 */
	public void setCfAuditTime(Date cfAuditTime) {
		this.cfAuditTime = cfAuditTime;
	}
	/**
	 * @return the cfCreateOrgUnitId
	 */
	public String getCfCreateOrgUnitId() {
		return cfCreateOrgUnitId;
	}
	/**
	 * @param cfCreateOrgUnitId the cfCreateOrgUnitId to set
	 */
	public void setCfCreateOrgUnitId(String cfCreateOrgUnitId) {
		this.cfCreateOrgUnitId = cfCreateOrgUnitId;
	}
	/**
	 * @return the cfCreateOrgUnitName
	 */
	public String getCfCreateOrgUnitName() {
		if (cfCreateOrgUnitName == null) {
			cfCreateOrgUnitName = "";
		}
		return cfCreateOrgUnitName;
	}
	/**
	 * @param cfCreateOrgUnitName the cfCreateOrgUnitName to set
	 */
	public void setCfCreateOrgUnitName(String cfCreateOrgUnitName) {
		this.cfCreateOrgUnitName = cfCreateOrgUnitName;
	}
	/**
	 * @return the fRepresent
	 */
	public String getfRepresent() {
		if (fRepresent == null) {
			fRepresent = "";
		}
		return fRepresent;
	}
	/**
	 * @param fRepresent the fRepresent to set
	 */
	public void setfRepresent(String fRepresent) {
		this.fRepresent = fRepresent;
	}
	/**
	 * @return the cfProNumber
	 */
	public String getCfProNumber() {
		if (cfProNumber == null) {
			cfProNumber = "";
		}
		return cfProNumber;
	}
	/**
	 * @param cfProNumber the cfProNumber to set
	 */
	public void setCfProNumber(String cfProNumber) {
		this.cfProNumber = cfProNumber;
	}
	/**
	 * @return the fProType
	 */
	public String getfProType() {
		if (fProType == null) {
			fProType = "";
		}
		return fProType;
	}
	/**
	 * @param fProType the fProType to set
	 */
	public void setfProType(String fProType) {
		this.fProType = fProType;
	}
	/**
	 * @return the cfVariationReasonName
	 */
	public String getCfVariationReasonName() {
		if (cfVariationReasonName == null) {
			cfVariationReasonName = "";
		}
		return cfVariationReasonName;
	}
	/**
	 * @param cfVariationReasonName the cfVariationReasonName to set
	 */
	public void setCfVariationReasonName(String cfVariationReasonName) {
		this.cfVariationReasonName = cfVariationReasonName;
	}
	
	
}
