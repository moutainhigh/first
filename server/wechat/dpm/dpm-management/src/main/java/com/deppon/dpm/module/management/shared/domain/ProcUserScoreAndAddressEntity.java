package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 提交显示所有0分项实体类.
 * 
 * @author 曹嵩
 * 2015.7.29
 */
public class ProcUserScoreAndAddressEntity implements Serializable {

	/**
	 * 序号.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 编号.
	 */
	private String id;

	/**
	 * 功能栏代码值.
	 */
	private String proType;

	/**
	 * 功能栏名称.
	 */
	private String proName;

	/**
	 * 人员打分ID.
	 */
	private String userAddressid;

	/**
	 * 打分项id.
	 */
	private String scopeid;

	/**
	 * 分数.
	 */
	private int scope;

	/**
	 * 备注.
	 */
	private String reMark;

	/**
	 * 打分项名称.
	 */
	private String scopeName;

	/**
	 * 员工工号.
	 */
	private String userNo;

	/**
	 * 地址.
	 */
	private String proAdress;

	/**
	 * 得到检查的门店总数.
	 */
	private int countStore;

	/**
	 * 得到这一项门店不合格总数.
	 */
	private int countScopeId;
	
	/**
	 * 打分项名称.
	 */
	private String arrScopeName[];

	/**
	 * 打分项code.
	 */
	private String arrScopeCode[];
	
	/**
	 * 门店不合格总数.
	 */
	private Integer arrcountScopeId[];


	/**
	 * @return  门店不合格总数.
	 */
	public Integer[] getArrcountScopeId() {
		return arrcountScopeId;
	}

	/**
	 * @param arrcountScopeId  门店不合格总数.
	 */
	public void setArrcountScopeId(Integer[] arrcountScopeId) {
		this.arrcountScopeId = arrcountScopeId;
	}

	/**
	 * @return 打分项名称
	 */
	public String[] getArrScopeName() {
		return arrScopeName;
	}

	/**
	 * @param arrScopeName 打分项名称
	 */
	public void setArrScopeName(String[] arrScopeName) {
		this.arrScopeName = arrScopeName;
	}

	public String[] getArrScopeCode() {
		return arrScopeCode;
	}

	public void setArrScopeCode(String[] arrScopeCode) {
		this.arrScopeCode = arrScopeCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 功能栏代码值.
	 */
	public String getProType() {
		return proType;
	}

	/**
	 * @param proType 功能栏代码值.
	 */
	public void setProType(String proType) {
		this.proType = proType;
	}

	/**
	 * @return 功能栏名称.
	 */
	public String getProName() {
		return proName;
	}

	/**
	 * @param proName 功能栏名称.
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}

	/**
	 * @return 人员打分ID.
	 */
	public String getUserAddressid() {
		return userAddressid;
	}

	/**
	 * @param userAddressid 人员打分ID.
	 */
	public void setUserAddressid(String userAddressid) {
		this.userAddressid = userAddressid;
	}

	/**
	 * @return 打分项id.
	 */
	public String getScopeid() {
		return scopeid;
	}

	/**
	 * @param scopeid 打分项id.
	 */
	public void setScopeid(String scopeid) {
		this.scopeid = scopeid;
	}

	/**
	 * @return 分数.
	 */
	public int getScope() {
		return scope;
	}

	/**
	 * @param scope 分数.
	 */
	public void setScope(int scope) {
		this.scope = scope;
	}

	/**
	 * @return 备注.
	 */
	public String getReMark() {
		return reMark;
	}

	/**
	 * @param reMark 备注.
	 */
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}

	/**
	 * @return 打分项名称.
	 */
	public String getScopeName() {
		return scopeName;
	}

	/**
	 * @param scopeName 打分项名称.
	 */
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	/**
	 * @return 员工工号.
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo 员工工号.
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return 地址
	 */
	public String getProAdress() {
		return proAdress;
	}

	/**
	 * @param proAdress 地址
	 */
	public void setProAdress(String proAdress) {
		this.proAdress = proAdress;
	}

	/**
	 * @return 得到检查的门店总数.
	 */
	public int getCountStore() {
		return countStore;
	}

	/**
	 * @param countStore 得到检查的门店总数.
	 */
	public void setCountStore(int countStore) {
		this.countStore = countStore;
	}

	/**
	 * @return 得到这一项门店不合格总数.
	 */
	public int getCountScopeId() {
		return countScopeId;
	}

	/**
	 * @param countScopeId 得到这一项门店不合格总数.
	 */
	public void setCountScopeId(int countScopeId) {
		this.countScopeId = countScopeId;
	}

}
