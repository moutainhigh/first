package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 王亚男
 * 工程维修实体类
 */
public class ProcMaintainEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -207790705874837839L;
	
	private int id;
	//员工工号
	private String userNo;
	//员工姓名
	private String userName;
	//申请单号 (在PC端和APP端 参照的 唯一标识,由PC端生成)
	private String bill;
	//项目名称
	private String proName;
	//项目编码
	private String proCode;
	//所属工程部
	private String department;
	//所属工程部ID
	private String adminID;
	//所属工程部Name
	private String adminName;
	
	//审批标识位  	-1==退回		0==审核中		1===已审核 	2===暂存 
	private int approvalMark;
	//	1 == 自行维修   	0==非自行维修
	private int self;
	//申请事由
	private String applyReason;
	
	//创建时间
	private String createDateStr;
	//修改时间
	private String updateDateStr;
	
	//创建时间
	private Date createDate;
	//修改时间
	private Date updateDate;
	
	//图片1
	private String imgOne;
	//图片2
	private String imgTwo;
	//图片3
	private String imgThree;
	//图片4
	private String imgFour;
	//图片5
	private String imgFive;
	
	//备注
	private String remark;
	
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

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * getter
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter
	 * @return
	 */
	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * getter
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * getter
	 * @return
	 */
	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	/**
	 * getter
	 * @return
	 */
	public String getProName() {
		return proName;
	}

	/**
	 * setter
	 * @param proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
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
	public String getDepartment() {
		return department;
	}

	/**
	 * setter
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * getter
	 * @return
	 */
	public int getApprovalMark() {
		return approvalMark;
	}

	/**
	 * setter
	 * @param approvalMark
	 */
	public void setApprovalMark(int approvalMark) {
		this.approvalMark = approvalMark;
	}

	/**
	 * getter
	 * @return
	 */
	public int getSelf() {
		return self;
	}

	/**
	 * setter
	 * @param self
	 */
	public void setSelf(int self) {
		this.self = self;
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

	public String getImgOne() {
		return imgOne;
	}

	/**
	 * setter
	 * @param imgOne
	 */
	public void setImgOne(String imgOne) {
		this.imgOne = imgOne;
	}

	/**
	 * getter
	 * @return
	 */
	public String getImgTwo() {
		return imgTwo;
	}

	/**
	 * setter
	 * @param imgTwo
	 */
	public void setImgTwo(String imgTwo) {
		this.imgTwo = imgTwo;
	}

	/**
	 * getter
	 * @return
	 */
	public String getImgThree() {
		return imgThree;
	}

	/**
	 * setter
	 * @param imgThree
	 */
	public void setImgThree(String imgThree) {
		this.imgThree = imgThree;
	}

	/**
	 * getter
	 * @return
	 */
	public String getImgFour() {
		return imgFour;
	}

	/**
	 * setter
	 * @param imgFour
	 */
	public void setImgFour(String imgFour) {
		this.imgFour = imgFour;
	}

	/**
	 * getter
	 * @return
	 */
	public String getImgFive() {
		return imgFive;
	}

	/**
	 * setter
	 * @param imgFive
	 */
	public void setImgFive(String imgFive) {
		this.imgFive = imgFive;
	}

	/**
	 * getter
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * setter
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * getter
	 * @return
	 */
	public String getCreateDateStr() {
		return createDateStr;
	}

	/**
	 * setter
	 * @param createDateStr
	 */
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	/**
	 * getter
	 * @return
	 */
	public String getUpdateDateStr() {
		return updateDateStr;
	}

	/**
	 * setter
	 * @param updateDateStr
	 */
	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

	/**
	 * getter
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * setter
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * getter
	 * @return
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * setter
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
