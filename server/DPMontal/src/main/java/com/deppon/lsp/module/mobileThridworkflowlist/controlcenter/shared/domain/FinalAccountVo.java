package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.List;

/**
 * 
 * @author 150973
 * @describe 决算申请单实体VO封装
 */
public class FinalAccountVo {


	/**
	 * 决算申请单主体实体
	 */
	private FinalAccountEntity finalAccountEntity;
	/**
	 * 决算申请单分录实体
	 */
	private List<FinalAccountEntriesEntity> faEntriesList;
	/**
	 * @return the finalAccountEntity
	 */
	public FinalAccountEntity getFinalAccountEntity() {
		return finalAccountEntity;
	}
	/**
	 * @param finalAccountEntity the finalAccountEntity to set
	 */
	public void setFinalAccountEntity(FinalAccountEntity finalAccountEntity) {
		this.finalAccountEntity = finalAccountEntity;
	}
	/**
	 * @return the faEntriesList
	 */
	public List<FinalAccountEntriesEntity> getFaEntriesList() {
		return faEntriesList;
	}
	/**
	 * @param faEntriesList the faEntriesList to set
	 */
	public void setFaEntriesList(List<FinalAccountEntriesEntity> faEntriesList) {
		this.faEntriesList = faEntriesList;
	}

}
