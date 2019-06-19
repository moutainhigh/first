package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

public class ProcCountEntity implements Serializable {

	/**
	 * <p>
	 * Field serialVersionUID: 序列号id
	 * </p>
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * Field scopeId: 打分项id
	 * </p>
	 */
	private String scopeId;
	/**
	 * <p>
	 * Field countScopeId: 扣分项总数
	 * </p>
	 */
	private int countScopeId;
	/**
	 * <p>
	 * Field countStore: 门店总数
	 * </p>
	 */
	private int countStore;
	/**
	 * <p>
	 * Field proType: 功能栏代码值
	 * </p>
	 */
	private String proType;

	public String getScopeId() {
		return scopeId;
	}

	public void setScopeId(String scopeId) {
		this.scopeId = scopeId;
	}

	public int getCountScopeId() {
		return countScopeId;
	}

	public void setCountScopeId(int countScopeId) {
		this.countScopeId = countScopeId;
	}

	public int getCountStore() {
		return countStore;
	}

	public void setCountStore(int countStore) {
		this.countStore = countStore;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	@Override
	public String toString() {
		return "ProcCountEntity [scopeId=" + scopeId + ", countScopeId="
				+ countScopeId + ", countStore=" + countStore + ", proType="
				+ proType + "]";
	}

	
}
