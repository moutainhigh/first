package com.deppon.dpm.module.management.shared.domain;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @description 项目基础信息实体类
 * @author: songzhaoliang
 */
public class BaseProjectInfo extends BaseEntity {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5245980567181818011L;
	// 项目id
	private String proid;
	// 项目名称
	private String proName;
	// 项目编号
	private String proNumber;
	// 项目创建时间
	private Date proCreateTime;
	// 项目创建人
	private String creator;
	// 项目状态״̬
	private String proState;
	// 项目经理
	private String proManager;
	// 项目所属部门ID
	private String proDepId;
	// 项目所属部门
	private String proDep;
	// 项目所属区域ID
	private String proAreaId;
	// 项目所属区域
	private String proArea;
	// 项目类型
	private String proType;
	// 项目分部工程
	private String proEngind;
	// 项目所在地
	private String proAdress;
	// 项目申请单id
	private String proOrderId;
	// 竣工时间
	private Date endTime;
	//项目状态״̬
	private String fprojectType;
	//简称
	private String fsimpleName;
	/**
	 * @return 项目id
	 */
	public String getProid() {
		return proid;
	}
	/**
	 * @param proid 项目id
	 */
	public void setProid(String proid) {
		this.proid = proid;
	}
	/**
	 * @return 项目名称
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName 项目名称
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return 项目编号
	 */
	public String getProNumber() {
		return proNumber;
	}
	/**
	 * @param proNumber 项目编号
	 */
	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}
	/**
	 * @return 项目创建时间
	 */
	public Date getProCreateTime() {
		return proCreateTime;
	}
	/**
	 * @param proCreateTime 项目创建时间
	 */
	public void setProCreateTime(Date proCreateTime) {
		this.proCreateTime = proCreateTime;
	}
	/**
	 * @return 项目创建人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator 项目创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return 项目状态
	 */
	public String getProState() {
		return proState;
	}
	/**
	 * @param proState 项目状态
	 */
	public void setProState(String proState) {
		this.proState = proState;
	}
	/**
	 * @return 项目经理
	 */
	public String getProManager() {
		return proManager;
	}
	/**
	 * @param proManager 项目经理
	 */
	public void setProManager(String proManager) {
		this.proManager = proManager;
	}
	/**
	 * @return 项目所属部门ID
	 */
	public String getProDepId() {
		return proDepId;
	}
	/**
	 * @param proDepId 项目所属部门ID
	 */
	public void setProDepId(String proDepId) {
		this.proDepId = proDepId;
	}
	/**
	 * @return 项目所属部门
	 */
	public String getProDep() {
		return proDep;
	}
	/**
	 * @param proDep 项目所属部门
	 */
	public void setProDep(String proDep) {
		this.proDep = proDep;
	}
	/**
	 * @return 项目申请单id
	 */
	public String getProAreaId() {
		return proAreaId;
	}
	/**
	 * @param proAreaId 项目申请单id
	 */
	public void setProAreaId(String proAreaId) {
		this.proAreaId = proAreaId;
	}
	/**
	 * @return 项目所属区域
	 */
	public String getProArea() {
		return proArea;
	}
	/**
	 * @param proArea 项目所属区域
	 */ 
	public void setProArea(String proArea) {
		this.proArea = proArea;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getProEngind() {
		return proEngind;
	}
	public void setProEngind(String proEngind) {
		this.proEngind = proEngind;
	}
	public String getProAdress() {
		return proAdress;
	}
	public void setProAdress(String proAdress) {
		this.proAdress = proAdress;
	}
	public String getProOrderId() {
		return proOrderId;
	}
	public void setProOrderId(String proOrderId) {
		this.proOrderId = proOrderId;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getFprojectType() {
		return fprojectType;
	}
	public void setFprojectType(String fprojectType) {
		this.fprojectType = fprojectType;
	}
	public String getFsimpleName() {
		return fsimpleName;
	}
	public void setFsimpleName(String fsimpleName) {
		this.fsimpleName = fsimpleName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	//组装
	public String toString() {
		return "BaseProjectInfo [proid=" + proid + ", proName=" + proName
				+ ", proNumber=" + proNumber + ", proCreateTime="
				+ proCreateTime + ", creator=" + creator + ", proState="
				+ proState + ", proManager=" + proManager + ", proDepId="
				+ proDepId + ", proDep=" + proDep + ", proAreaId=" + proAreaId
				+ ", proArea=" + proArea + ", proType=" + proType
				+ ", proEngind=" + proEngind + ", proAdress=" + proAdress
				+ ", proOrderId=" + proOrderId + ", endTime=" + endTime
				+ ", fprojectType=" + fprojectType + ", fsimpleName="
				+ fsimpleName + "]";
	}
	
	
   
}
