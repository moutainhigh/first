package com.deppon.dpm.module.wfs.shared.vo;

import java.util.ArrayList;
import java.util.List;
/**
 * 工作流列表 封装VO 
 * @author gcl
 */
public class WorkFlowItem {
    //当天工作流列表
	private List<OaWorkItem> todayList = new ArrayList<OaWorkItem>();
	//昨天工作流列表
	private List<OaWorkItem> yesterdayList = new ArrayList<OaWorkItem>();
	//更早工作流列表
	private List<OaWorkItem> otherList = new ArrayList<OaWorkItem>();
	/**
	 * @return the todayList
	 */
	public List<OaWorkItem> getTodayList() {
		return todayList;
	}
	/**
	 * @param todayList the todayList to set
	 */
	public void setTodayList(List<OaWorkItem> todayList) {
		this.todayList = todayList;
	}
	/**
	 * @return the yesterdayList
	 */
	public List<OaWorkItem> getYesterdayList() {
		return yesterdayList;
	}
	/**
	 * @param yesterdayList the yesterdayList to set
	 */
	public void setYesterdayList(List<OaWorkItem> yesterdayList) {
		this.yesterdayList = yesterdayList;
	}
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
