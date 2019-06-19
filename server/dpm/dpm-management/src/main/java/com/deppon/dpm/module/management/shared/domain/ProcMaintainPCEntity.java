package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 工程维修提交  TO PC端
 * @author 王亚男
 *
 */
public class ProcMaintainPCEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2350670053472969459L;
	
	/**
	 * 员工工号
	 */
	private String userNo;
	/**
	 * 项目编号
	 */
	private String proCode;
	/**
	 * 附件
	 */
	private List<String> attachments;
	/**
	 * 申请事由
	 */
	private String applyReason;	
	/**
	 * 申请单单号  PC 和  APP 链接唯一标识
	 */
	private String bill;
	/**
	 * 所属工程部ID
	 */
	private String adminID;
	/**
	 * 所属工程部名字
	 */
	private String adminName;
	
	// 是否为监控   1:是   0：否
	private String fisNOtMonitor;
	
	/**
	 * get
	 * @return
	 */
	public String getFisNOtMonitor() {
		return fisNOtMonitor;
	}

	/**
	 * set
	 * @param fisNOtMonitor
	 */
	public void setFisNOtMonitor(String fisNOtMonitor) {
		this.fisNOtMonitor = fisNOtMonitor;
	}

	/**
	 * getter
	 * @return
	 */
	public String getAdminName() {
		return adminName;
	}
	
	/**
	 * setter
	 * @param adminName
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * getter
	 * @return
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * setter
	 * @param userNo
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * getter
	 * @return
	 */
	public String getProCode() {
		return proCode;
	}
	/**
	 * setter
	 * @param proCode
	 */
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	/**
	 * getter
	 * @return
	 */
	public List<String> getAttachments() {
		return attachments;
	}
	/**
	 * setter
	 * @param attachments
	 */
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	/**
	 * getter
	 * @return
	 */
	public String getApplyReason() {
		return applyReason;
	}
	/**
	 * setter
	 * @param applyReason
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	/**
	 * getter
	 * @return
	 */
	public String getBill() {
		return bill;
	}
	/**
	 * setter
	 * @param bill
	 */
	public void setBill(String bill) {
		this.bill = bill;
	}
	/**
	 * getter
	 * @return
	 */
	public String getAdminID() {
		return adminID;
	}
	/**
	 * setter
	 * @param adminID
	 */
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}	
	
	
}
