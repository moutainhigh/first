package com.deppon.dpm.module.wfs.shared.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 新老工作流列表，按时间分，VO封装
 * @author 491275
 *
 */
public class WorkFlowDateList {
	
	//当天工作流列表
	private List<Object> todayList = new ArrayList<Object>();
	//昨天工作流列表
	private List<Object> yesterdayList = new ArrayList<Object>();
	//更早工作流列表
	private List<Object> otherList = new ArrayList<Object>();
	
	public List<Object> getTodayList() {
		return todayList;
	}
	public void setTodayList(List<Object> todayList) {
		this.todayList = todayList;
	}
	public List<Object> getYesterdayList() {
		return yesterdayList;
	}
	public void setYesterdayList(List<Object> yesterdayList) {
		this.yesterdayList = yesterdayList;
	}
	public List<Object> getOtherList() {
		return otherList;
	}
	public void setOtherList(List<Object> otherList) {
		this.otherList = otherList;
	}
	@Override
	public String toString() {
		return "WorkFlowDateList [todayList=" + todayList + ", yesterdayList="
				+ yesterdayList + ", otherList=" + otherList + "]";
	}
}
