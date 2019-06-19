package com.deppon.dpm.module.wfs.shared.vo;

import java.util.List;


public class OaShowDate {
	/** 时间 */
	private String oaShowDate;
	private List<OaWorkItem>  otherList;
	/**
	 * @return the oaShowDate
	 */
	public String getOaShowDate() {
		return oaShowDate;
	}
	/**
	 * @param oaShowDate the oaShowDate to set
	 */
	public void setOaShowDate(String oaShowDate) {
		this.oaShowDate = oaShowDate;
	}
	/**
	 * @return the oaWorkItem
	 */
	/**
	 * @return the otherList
	 */
	public List<OaWorkItem> getOtherList() {
		return otherList;
	}
	/**
	 * @param otherList the otherList to set
	 */
	public void setOtherList(List<OaWorkItem> otherList) {
		this.otherList = otherList;
	}

	
	
}
