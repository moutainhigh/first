package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;


public class ProFassAssessVo {
	private ProFasAssesEntity proFasAssesEntity; 
	private ProFasAssesEntryEntity[] proFasAssesEntryList;
	public ProFasAssesEntity getProFasAssesEntity() {
		return proFasAssesEntity;
	}
	public void setProFasAssesEntity(ProFasAssesEntity proFasAssesEntity) {
		this.proFasAssesEntity = proFasAssesEntity;
	}
	public ProFasAssesEntryEntity[] getProFasAssesEntryList() {
		if (proFasAssesEntryList == null){
			ProFasAssesEntryEntity temp = new ProFasAssesEntryEntity();
			proFasAssesEntryList = new ProFasAssesEntryEntity[1];
			proFasAssesEntryList[0] = temp;
		}
		return proFasAssesEntryList;
	}
	public void setProFasAssesEntryList(
			ProFasAssesEntryEntity[] proFasAssesEntryList) {
		this.proFasAssesEntryList = proFasAssesEntryList;
	}
}
