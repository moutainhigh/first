package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @description 项目基础信息实体类
 * @author: songzhaoliang
 */
public class BaseProjectInfo extends BaseEntity {

	/**
	 * 
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
	// 项目状态
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
	//项目状态
	private String fprojectType;
	//简称
	private String fsimpleName;
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proid属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProid() {
		return proid;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proid的值
	 *
	 */
	public void setProid(String proid) {
		this.proid = proid;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proName属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProName() {
		return proName;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proName的值
	 *
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proNumber属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProNumber() {
		if (proNumber == null) {
			proNumber = "";
		}
		return proNumber;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proNumber的值
	 *
	 */
	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proCreateTime属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public Date getProCreateTime() {
		return proCreateTime;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proCreateTime的值
	 *
	 */
	public void setProCreateTime(Date proCreateTime) {
		this.proCreateTime = proCreateTime;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 creator属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getCreator() {
		return creator;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 creator的值
	 *
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proState属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProState() {
		return proState;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proState的值
	 *
	 */
	public void setProState(String proState) {
		this.proState = proState;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proManager属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProManager() {
		return proManager;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proManager的值
	 *
	 */
	public void setProManager(String proManager) {
		this.proManager = proManager;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proDepId属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProDepId() {
		return proDepId;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proDepId的值
	 *
	 */
	public void setProDepId(String proDepId) {
		this.proDepId = proDepId;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proDep属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProDep() {
		return proDep;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proDep的值
	 *
	 */
	public void setProDep(String proDep) {
		this.proDep = proDep;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proAreaId属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProAreaId() {
		return proAreaId;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proAreaId的值
	 *
	 */
	public void setProAreaId(String proAreaId) {
		this.proAreaId = proAreaId;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proArea属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProArea() {
		return proArea;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proArea的值
	 *
	 */
	public void setProArea(String proArea) {
		this.proArea = proArea;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proType属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProType() {
		return proType;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proType的值
	 *
	 */
	public void setProType(String proType) {
		this.proType = proType;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proEngind属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProEngind() {
		return proEngind;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proEngind的值
	 *
	 */
	public void setProEngind(String proEngind) {
		this.proEngind = proEngind;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proAdress属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProAdress() {
		return proAdress;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proAdress的值
	 *
	 */
	public void setProAdress(String proAdress) {
		this.proAdress = proAdress;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 proOrderId属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getProOrderId() {
		return proOrderId;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 proOrderId的值
	 *
	 */
	public void setProOrderId(String proOrderId) {
		this.proOrderId = proOrderId;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 endTime属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public Date getEndTime() {
		return endTime;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 endTime的值
	 *
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 fprojectType属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getFprojectType() {
		return fprojectType;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 fprojectType的值
	 *
	 */
	public void setFprojectType(String fprojectType) {
		this.fprojectType = fprojectType;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 fsimpleName属性的值
	 *
	 * @date 2014-4-22 上午9:54:57
	 */
	
	public String getFsimpleName() {
		return fsimpleName;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午9:54:57
	 *
	 * @param  设置属性 fsimpleName的值
	 *
	 */
	public void setFsimpleName(String fsimpleName) {
		this.fsimpleName = fsimpleName;
	}
	
   
}
