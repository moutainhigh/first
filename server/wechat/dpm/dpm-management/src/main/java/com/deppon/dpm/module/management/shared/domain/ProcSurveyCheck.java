package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 工程勘测检查
 * @author 293888
 *
 */
/**
 * @author 293888
 * 
 */
public class ProcSurveyCheck implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private int id;
	/**
	 * 项目名称
	 */
	private String checkName;
	/**
	 * 项目编码
	 */
	private String checkCode;
	/**
	 * 工号
	 */
	private String checkUserNo;
	/**
	 * 单号
	 */
	private String checkNo;
	/**
	 * 勘测状态 0未勘测 1勘测中 1已勘测
	 */
	private int checkState;
	/**
	 * 是否有效 0有效1无效
	 */
	private String checkMark;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建人
	 */
	private String createUserNo;
	/**
	 * 修改时间
	 */
	private Date updateDate;
	/**
	 * 修改人
	 */
	private String updateUserNo;

	/**
	 * 项目状态
	 */
	private String procStatus;

	/**
	 * 负责人工号
	 */
	private String principalUserNo;

	/**
	 * 负责人姓名
	 */
	private String principalName;

	/**
	 * 主键ID
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 项目名称
	 * 
	 * @return
	 */
	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	/**
	 * 项目编码
	 * 
	 * @return
	 */
	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	/**
	 * 工号
	 * 
	 * @return
	 */
	public String getCheckUserNo() {
		return checkUserNo;
	}

	public void setCheckUserNo(String checkUserNo) {
		this.checkUserNo = checkUserNo;
	}

	/**
	 * 单号
	 * 
	 * @return
	 */
	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	/**
	 * 勘测状态
	 * 
	 * @return
	 */
	public int getCheckState() {
		return checkState;
	}

	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}

	/**
	 * 是否有效
	 * 
	 * @return
	 */
	public String getCheckMark() {
		return checkMark;
	}

	public void setCheckMark(String checkMark) {
		this.checkMark = checkMark;
	}

	/**
	 * 创建时间
	 * 
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 创建人
	 * 
	 * @return
	 */
	public String getCreateUserNo() {
		return createUserNo;
	}

	public void setCreateUserNo(String createUserNo) {
		this.createUserNo = createUserNo;
	}

	/**
	 * 修改时间
	 * 
	 * @return
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 修改人
	 * 
	 * @return
	 */
	public String getUpdateUserNo() {
		return updateUserNo;
	}

	public void setUpdateUserNo(String updateUserNo) {
		this.updateUserNo = updateUserNo;
	}

	/**
	 * 项目状态
	 * @return
	 */
	public String getProcStatus() {
		return procStatus;
	}

	public void setProcStatus(String procStatus) {
		this.procStatus = procStatus;
	}
	/**
	 * 负责人工号
	 * @return
	 */
	public String getPrincipalUserNo() {
		return principalUserNo;
	}

	public void setPrincipalUserNo(String principalUserNo) {
		this.principalUserNo = principalUserNo;
	}
	/**
	 * 负责人姓名
	 * @return
	 */
	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

}
