package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class ProjectPlannintLineEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fId;
	//单据分录序列号；FSEQ
	private long fSeq;
	//FPARENTID
	private String fParentId;
	//所属工程部；FDEPARTMENTID
	private String fDepartmentID;
	//所属工程部；FDEPARTMENTID
	private String fDepartmentName;
	//1月数量；
	private String fJanuary;
	//2月数量；
	private String fFebruary;
	//3月数量；
	private String fMarch;
	//4月数量；
	private String fApril;
	//5月数量；
	private String fMay;
	//6月数量；
	private String fJune;
	//7月数量；
	private String fJuly;
	//8月数量；
	private String fAugust;
	//9月数量；
	private String fSeptember;
	//10月数量；
	private String fOctober;
	//11月数量；
	private String fNovember;
	//12月数量；
	private String fDecember;
	//备注；FCOMMENT
	private String  fComment;
	//施工类型；CFCONSTRUCTTYPEID
	private String cfConstructTypeId;
	//施工类型；CFCONSTRUCTTYPEID
	private String cfConstructTypeName;
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
	 * @return the fSeq
	 */
	public long getfSeq() {
		return fSeq;
	}
	/**
	 * @param fSeq the fSeq to set
	 */
	public void setfSeq(long fSeq) {
		this.fSeq = fSeq;
	}
	/**
	 * @return the fParentId
	 */
	public String getfParentId() {
		return fParentId;
	}
	/**
	 * @param fParentId the fParentId to set
	 */
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}
	/**
	 * @return the fDepartmentID
	 */
	public String getfDepartmentID() {
		return fDepartmentID;
	}
	/**
	 * @param fDepartmentID the fDepartmentID to set
	 */
	public void setfDepartmentID(String fDepartmentID) {
		this.fDepartmentID = fDepartmentID;
	}
	/**
	 * @return the fDepartmentName
	 */
	public String getfDepartmentName() {
		return fDepartmentName;
	}
	/**
	 * @param fDepartmentName the fDepartmentName to set
	 */
	public void setfDepartmentName(String fDepartmentName) {
		this.fDepartmentName = fDepartmentName;
	}
	/**
	 * @return the fJanuary
	 */
	public String getfJanuary() {
		return fJanuary;
	}
	/**
	 * @param fJanuary the fJanuary to set
	 */
	public void setfJanuary(String fJanuary) {
		this.fJanuary = fJanuary;
	}
	/**
	 * @return the fFebruary
	 */
	public String getfFebruary() {
		return fFebruary;
	}
	/**
	 * @param fFebruary the fFebruary to set
	 */
	public void setfFebruary(String fFebruary) {
		this.fFebruary = fFebruary;
	}
	/**
	 * @return the fMarch
	 */
	public String getfMarch() {
		return fMarch;
	}
	/**
	 * @param fMarch the fMarch to set
	 */
	public void setfMarch(String fMarch) {
		this.fMarch = fMarch;
	}
	/**
	 * @return the fApril
	 */
	public String getfApril() {
		return fApril;
	}
	/**
	 * @param fApril the fApril to set
	 */
	public void setfApril(String fApril) {
		this.fApril = fApril;
	}
	/**
	 * @return the fMay
	 */
	public String getfMay() {
		return fMay;
	}
	/**
	 * @param fMay the fMay to set
	 */
	public void setfMay(String fMay) {
		this.fMay = fMay;
	}
	/**
	 * @return the fJune
	 */
	public String getfJune() {
		return fJune;
	}
	/**
	 * @param fJune the fJune to set
	 */
	public void setfJune(String fJune) {
		this.fJune = fJune;
	}
	/**
	 * @return the fJuly
	 */
	public String getfJuly() {
		return fJuly;
	}
	/**
	 * @param fJuly the fJuly to set
	 */
	public void setfJuly(String fJuly) {
		this.fJuly = fJuly;
	}
	/**
	 * @return the fAugust
	 */
	public String getfAugust() {
		return fAugust;
	}
	/**
	 * @param fAugust the fAugust to set
	 */
	public void setfAugust(String fAugust) {
		this.fAugust = fAugust;
	}
	/**
	 * @return the fSeptember
	 */
	public String getfSeptember() {
		return fSeptember;
	}
	/**
	 * @param fSeptember the fSeptember to set
	 */
	public void setfSeptember(String fSeptember) {
		this.fSeptember = fSeptember;
	}
	/**
	 * @return the fOctober
	 */
	public String getfOctober() {
		return fOctober;
	}
	/**
	 * @param fOctober the fOctober to set
	 */
	public void setfOctober(String fOctober) {
		this.fOctober = fOctober;
	}
	/**
	 * @return the fNovember
	 */
	public String getfNovember() {
		return fNovember;
	}
	/**
	 * @param fNovember the fNovember to set
	 */
	public void setfNovember(String fNovember) {
		this.fNovember = fNovember;
	}
	/**
	 * @return the fDecember
	 */
	public String getfDecember() {
		return fDecember;
	}
	/**
	 * @param fDecember the fDecember to set
	 */
	public void setfDecember(String fDecember) {
		this.fDecember = fDecember;
	}
	/**
	 * @return the fComment
	 */
	public String getfComment() {
		return fComment;
	}
	/**
	 * @param fComment the fComment to set
	 */
	public void setfComment(String fComment) {
		this.fComment = fComment;
	}
	/**
	 * @return the cfConstructTypeId
	 */
	public String getCfConstructTypeId() {
		return cfConstructTypeId;
	}
	/**
	 * @param cfConstructTypeId the cfConstructTypeId to set
	 */
	public void setCfConstructTypeId(String cfConstructTypeId) {
		this.cfConstructTypeId = cfConstructTypeId;
	}
	/**
	 * @return the cfConstructTypeName
	 */
	public String getCfConstructTypeName() {
		return cfConstructTypeName;
	}
	/**
	 * @param cfConstructTypeName the cfConstructTypeName to set
	 */
	public void setCfConstructTypeName(String cfConstructTypeName) {
		this.cfConstructTypeName = cfConstructTypeName;
	}
	
}
