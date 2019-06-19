package com.deppon.dpm.module.management.shared.domain;

public class InformationSort {

	/**
	 * 1--新闻动态<br>
	 * 2--高管随笔<br>
	 * 3--任免公告<br>
	 * 4--违纪<br>
	 * 5--早安快递<br>
	 * 6--营业部晨会<br>
	 */
	// * 7--外场晨会<br>
	private int infoId;

	private String cnName;

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

}
