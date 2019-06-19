package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;
import java.util.List;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 
 * 定标变更单表头实体
 * 
 * @author wangmingzhao
 * @date 2014-2-25 上午11:35:51
 * @since
 * @version
 */
public class CalibrateBillChangeEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -291009772023357197L;
	/**
	 * @param单据编号
	 */
	private String fnumber;
	/**
	 * @param定标单号
	 */
	private String calibrateNumber;
	/**
	 * 定标单ID
	 */
	private String calibrateNumberId;
	/**
	 * @paramRFQ单号
	 */
	private String rfqNumber;
	/**
	 * 单据状态
	 */
	private String billState;
	/**
	 * 执行小组名
	 */
	private String nameList;
	/**
	 * 执行小组名人员list
	 */
	private List<String> personList;
	/**
	 * 版本号
	 */
	private String editionNumber;
	/**
	 * 需求评委名称
	 */
	private String needPersonName;
	/**
	 * 需求评委编码
	 */
	private String needPersonCode;
	/**
	 * 需求评委ID
	 */
	private String needPersonId;
	/**
	 * 需求评委意见
	 */
	private String needSuggest;
	/**
	 * 专业评委名称
	 */
	private String specialtyPersonName;
	/**
	 * 专业评委编码
	 */
	private String specialtyPersonCode;
	/**
	 * 专业评委Id
	 */
	private String specialtyPersonId;
	/**
	 * 专业评委意见
	 */
	private String specialtySuggest;
	/**
	 * 采购评委名称
	 */
	private String purchasePersonName;
	/**
	 * 采购评委编码
	 */
	private String purchasePersonCode;
	/**
	 * 采购评委Id
	 */
	private String purchasePersonId;
	/**
	 * 采购评委意见
	 */
	private String purchaseSuggest;
	/**
	 * 定标结果
	 */
	private String calibrateRest;
	/**
	 * 标的物金额
	 */
	private double destAmount;
	/**
	 * 业务日期
	 */
	private Date bizDate;
	/**
	 * 审核时间
	 */
	private Date auditTime;
	/**
	 * 审核人ID
	 */
	private String auditorId;
	/**
	 *
	 * @return the fnumber
	 *
	 */
	public String getFnumber() {
		return fnumber;
	}
	/**
	 *
	 * @param fnumber the fnumber to set
	 *
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	
	/**
	 *
	 * @return the calibrateNumber
	 *
	 */
	public String getCalibrateNumber() {
		return calibrateNumber;
	}
	/**
	 *
	 * @param calibrateNumber the calibrateNumber to set
	 *
	 */
	public void setCalibrateNumber(String calibrateNumber) {
		this.calibrateNumber = calibrateNumber;
	}
	/**
	 *
	 * @return the rfqNumber
	 *
	 */
	public String getRfqNumber() {
		return rfqNumber;
	}
	/**
	 *
	 * @param rfqNumber the rfqNumber to set
	 *
	 */
	public void setRfqNumber(String rfqNumber) {
		this.rfqNumber = rfqNumber;
	}
	/**
	 *
	 * @return the billState
	 *
	 */
	public String getBillState() {
		return billState;
	}
	/**
	 *
	 * @param billState the billState to set
	 *
	 */
	public void setBillState(String billState) {
		this.billState = billState;
	}
	/**
	 *
	 * @return the nameList
	 *
	 */
	public String getNameList() {
		return nameList;
	}
	/**
	 *
	 * @param nameList the nameList to set
	 *
	 */
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}
	/**
	 *
	 * @return the editionNumber
	 *
	 */
	public String getEditionNumber() {
		return editionNumber;
	}
	/**
	 *
	 * @param editionNumber the editionNumber to set
	 *
	 */
	public void setEditionNumber(String editionNumber) {
		this.editionNumber = editionNumber;
	}
	/**
	 *
	 * @return the needPersonName
	 *
	 */
	public String getNeedPersonName() {
		return needPersonName;
	}
	/**
	 *
	 * @param needPersonName the needPersonName to set
	 *
	 */
	public void setNeedPersonName(String needPersonName) {
		this.needPersonName = needPersonName;
	}
	/**
	 *
	 * @return the needSuggest
	 *
	 */
	public String getNeedSuggest() {
		return needSuggest;
	}
	/**
	 *
	 * @param needSuggest the needSuggest to set
	 *
	 */
	public void setNeedSuggest(String needSuggest) {
		this.needSuggest = needSuggest;
	}
	/**
	 *
	 * @return the specialtyPersonName
	 *
	 */
	public String getSpecialtyPersonName() {
		return specialtyPersonName;
	}
	/**
	 *
	 * @param specialtyPersonName the specialtyPersonName to set
	 *
	 */
	public void setSpecialtyPersonName(String specialtyPersonName) {
		this.specialtyPersonName = specialtyPersonName;
	}
	/**
	 *
	 * @return the specialtySuggest
	 *
	 */
	public String getSpecialtySuggest() {
		return specialtySuggest;
	}
	/**
	 *
	 * @param specialtySuggest the specialtySuggest to set
	 *
	 */
	public void setSpecialtySuggest(String specialtySuggest) {
		this.specialtySuggest = specialtySuggest;
	}
	/**
	 *
	 * @return the purchasePersonName
	 *
	 */
	public String getPurchasePersonName() {
		return purchasePersonName;
	}
	/**
	 *
	 * @param purchasePersonName the purchasePersonName to set
	 *
	 */
	public void setPurchasePersonName(String purchasePersonName) {
		this.purchasePersonName = purchasePersonName;
	}
	/**
	 *
	 * @return the purchaseSuggest
	 *
	 */
	public String getPurchaseSuggest() {
		return purchaseSuggest;
	}
	/**
	 *
	 * @param purchaseSuggest the purchaseSuggest to set
	 *
	 */
	public void setPurchaseSuggest(String purchaseSuggest) {
		this.purchaseSuggest = purchaseSuggest;
	}
	/**
	 *
	 * @return the calibrateRest
	 *
	 */
	public String getCalibrateRest() {
		return calibrateRest;
	}
	/**
	 *
	 * @param calibrateRest the calibrateRest to set
	 *
	 */
	public void setCalibrateRest(String calibrateRest) {
		this.calibrateRest = calibrateRest;
	}
	/**
	 *
	 * @return the destAmount
	 *
	 */
	public double getDestAmount() {
		return destAmount;
	}
	/**
	 *
	 * @param destAmount the destAmount to set
	 *
	 */
	public void setDestAmount(double destAmount) {
		this.destAmount = destAmount;
	}
	/**
	 *
	 * @return the bizDate
	 *
	 */
	public Date getBizDate() {
		return bizDate;
	}
	/**
	 *
	 * @param bizDate the bizDate to set
	 *
	 */
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 *
	 * @return the auditorId
	 *
	 */
	public String getAuditorId() {
		return auditorId;
	}
	/**
	 *
	 * @param auditorId the auditorId to set
	 *
	 */
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	/**
	 *
	 * @return the personList
	 *
	 */
	public List<String> getPersonList() {
		return personList;
	}
	/**
	 *
	 * @param personList the personList to set
	 *
	 */
	public void setPersonList(List<String> personList) {
		this.personList = personList;
	}
	/**
	 *
	 * @return the needPersonCode
	 *
	 */
	public String getNeedPersonCode() {
		return needPersonCode;
	}
	/**
	 *
	 * @param needPersonCode the needPersonCode to set
	 *
	 */
	public void setNeedPersonCode(String needPersonCode) {
		this.needPersonCode = needPersonCode;
	}
	/**
	 *
	 * @return the specialtyPersonCode
	 *
	 */
	public String getSpecialtyPersonCode() {
		return specialtyPersonCode;
	}
	/**
	 *
	 * @param specialtyPersonCode the specialtyPersonCode to set
	 *
	 */
	public void setSpecialtyPersonCode(String specialtyPersonCode) {
		this.specialtyPersonCode = specialtyPersonCode;
	}
	/**
	 *
	 * @return the purchasePersonCode
	 *
	 */
	public String getPurchasePersonCode() {
		return purchasePersonCode;
	}
	/**
	 *
	 * @param purchasePersonCode the purchasePersonCode to set
	 *
	 */
	public void setPurchasePersonCode(String purchasePersonCode) {
		this.purchasePersonCode = purchasePersonCode;
	}
	/**
	 *
	 * @return the auditTime
	 *
	 */
	public Date getAuditTime() {
		return auditTime;
	}
	/**
	 *
	 * @param auditTime the auditTime to set
	 *
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 *
	 * @return the calibrateNumberId
	 *
	 */
	public String getCalibrateNumberId() {
		return calibrateNumberId;
	}
	/**
	 *
	 * @param calibrateNumberId the calibrateNumberId to set
	 *
	 */
	public void setCalibrateNumberId(String calibrateNumberId) {
		this.calibrateNumberId = calibrateNumberId;
	}
	/**
	 *
	 * @return the needPersonId
	 *
	 */
	public String getNeedPersonId() {
		return needPersonId;
	}
	/**
	 *
	 * @param needPersonId the needPersonId to set
	 *
	 */
	public void setNeedPersonId(String needPersonId) {
		this.needPersonId = needPersonId;
	}
	/**
	 *
	 * @return the specialtyPersonId
	 *
	 */
	public String getSpecialtyPersonId() {
		return specialtyPersonId;
	}
	/**
	 *
	 * @param specialtyPersonId the specialtyPersonId to set
	 *
	 */
	public void setSpecialtyPersonId(String specialtyPersonId) {
		this.specialtyPersonId = specialtyPersonId;
	}
	/**
	 *
	 * @return the purchasePersonId
	 *
	 */
	public String getPurchasePersonId() {
		return purchasePersonId;
	}
	/**
	 *
	 * @param purchasePersonId the purchasePersonId to set
	 *
	 */
	public void setPurchasePersonId(String purchasePersonId) {
		this.purchasePersonId = purchasePersonId;
	}
	
	
	
}
