package com.deppon.montal.model;

import java.sql.Clob;

/**
 * 板块实体
 */
public class MonthLayoutEntity {
	
	private int layoutId;
	private String layoutName;
	private int periodicalId;
	public int getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(int layoutId) {
		this.layoutId = layoutId;
	}
	public String getLayoutName() {
		return layoutName;
	}
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	public int getPeriodicalId() {
		return periodicalId;
	}
	public void setPeriodicalId(int periodicalId) {
		this.periodicalId = periodicalId;
	}
	
}
