package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: TheaterOrderWrappers
 * @Description: 桌面终端返回实体
 * @author 123240
 * @date 2015-4-1 下午1:51:51
 */
// 2015-09-17 231586改
public class TheaterOrderWrappers implements Serializable {
	private static final long serialVersionUID = 1L;
	// 事件/问题编码
	private String orderCode;
	// 操作人
	private String dealUsercode;
	// 转现场时间
	/*
	 * @JSONField(format = "yyyy-MM-dd HH:mm:ss") private Date theaterTime;
	 */
	private String theaterTime;
	// 状态
	private String statusCode;
	// 问题类型code
	private String faultCode;
	// 事件类型
	private String faultName;
	// 类型描述code
	private String faultSubcode;
	// 类型描述
	private String faultDesc;
	// 详细类别Code
	private String modulCode;
	// 详细类别
	private String faultModul ;
	// 所属子模块
	private String subsystem;
	// 是否有效
	private String isavilabled;
	// 上报人工号
	private String reporterCode;
	// 上报人姓名
	private String reporterName;
	// 上报时间
	/*
	 * @JSONField(format = "yyyy-MM-dd HH:mm:ss") private Date reporterTime;
	 */
	private String reporterTime;
	// 上报人联系电话（可直接拨打）
	private String mobileNumber;
	// 上报人详细位置
	private String detailAddress;
	// 上报人所属部门
	private String deptName;
	// 上报人职位
	private String position;
	// 问题描述
	private String orderDetail;
	// 附件
	private List<Attachment> attachments;
	// 事件类型单个附件 
	private Attachment attachment;
	// 附件地址
	private List<Map<String, String>> attPath;
	// 事件类型附件地址
	private List<Map<String, String>> faultAttPath;
	// 处理意见
	private String dealadvice;
	// 未解决原因
	private String failResaon;
	/**
	 * 附件URL
	 */
	// private String attachmentUrl;
	/**
	 * 附件数据存储名称
	 */
	// private String attachmentNewName;
	/**
	 * 附件原文件名称
	 */
	// private String attachmentOldName;
	// 原因分析
	private String resionAnalyse;
	// 解决方案
	private String solution;
	// 挂起备注
	private String hangupText;
	// 转二线备注
	private String twohandleText;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * set
	 * 
	 * @param orderCode
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDealUsercode() {
		return dealUsercode;
	}

	/**
	 * set
	 * 
	 * @param dealUsercode
	 */
	public void setDealUsercode(String dealUsercode) {
		this.dealUsercode = dealUsercode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTheaterTime() {
		return theaterTime;
	}

	/**
	 * set
	 * 
	 * @param theaterTime
	 */
	public void setTheaterTime(String theaterTime) {
		this.theaterTime = theaterTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * set
	 * 
	 * @param statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFaultCode() {
		return faultCode;
	}

	/**
	 * set
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getReporterCode() {
		return reporterCode;
	}

	/**
	 * set
	 * 
	 * @param reporterCode
	 */
	public void setReporterCode(String reporterCode) {
		this.reporterCode = reporterCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getReporterName() {
		return reporterName;
	}

	/**
	 * set
	 * 
	 * @param reporterName
	 */
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getReporterTime() {
		return reporterTime;
	}

	/**
	 * set
	 * 
	 * @param reporterTime
	 */
	public void setReporterTime(String reporterTime) {
		this.reporterTime = reporterTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * set
	 * 
	 * @param mobileNumber
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDetailAddress() {
		return detailAddress;
	}

	/**
	 * set
	 * 
	 * @param detailAddress
	 */
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * set
	 * 
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * set
	 * 
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOrderDetail() {
		return orderDetail;
	}

	/**
	 * set
	 * 
	 * @param orderDetail
	 */
	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * set
	 * 
	 * @param attachments
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getResionAnalyse() {
		return resionAnalyse;
	}

	/**
	 * set
	 * 
	 * @param resionAnalyse
	 */
	public void setResionAnalyse(String resionAnalyse) {
		this.resionAnalyse = resionAnalyse;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * set
	 * 
	 * @param solution
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHangupText() {
		return hangupText;
	}

	/**
	 * set
	 * 
	 * @param hangupText
	 */
	public void setHangupText(String hangupText) {
		this.hangupText = hangupText;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTwohandleText() {
		return twohandleText;
	}

	/**
	 * set
	 * 
	 * @param twohandleText
	 */
	public void setTwohandleText(String twohandleText) {
		this.twohandleText = twohandleText;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDealadvice() {
		return dealadvice;
	}

	/**
	 * set
	 * 
	 * @param dealadvice
	 */
	public void setDealadvice(String dealadvice) {
		this.dealadvice = dealadvice;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFailResaon() {
		return failResaon;
	}

	/**
	 * set
	 * 
	 * @param failResaon
	 */
	public void setFailResaon(String failResaon) {
		this.failResaon = failResaon;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<Map<String, String>> getAttPath() {
		return attPath;
	}

	/**
	 * set
	 * 
	 * @param attPath
	 */
	public void setAttPath(List<Map<String, String>> attPath) {
		this.attPath = attPath;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFaultName() {
		return faultName;
	}

	/**
	 * set
	 * 
	 * @param faultName
	 */
	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	public String getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	public String getFaultDesc() {
		return faultDesc;
	}

	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	public String getModulCode() {
		return modulCode;
	}

	public void setModulCode(String modulCode) {
		this.modulCode = modulCode;
	}

	public String getFaultModul() {
		return faultModul;
	}

	public void setFaultModul(String faultModul) {
		this.faultModul = faultModul;
	}

	public String getFaultSubcode() {
		return faultSubcode;
	}

	public void setFaultSubcode(String faultSubcode) {
		this.faultSubcode = faultSubcode;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public List<Map<String, String>> getFaultAttPath() {
		return faultAttPath;
	}

	public void setFaultAttPath(List<Map<String, String>> faultAttPath) {
		this.faultAttPath = faultAttPath;
	}

	public String getIsavilabled() {
		return isavilabled;
	}

	public void setIsavilabled(String isavilabled) {
		this.isavilabled = isavilabled;
	}

}
