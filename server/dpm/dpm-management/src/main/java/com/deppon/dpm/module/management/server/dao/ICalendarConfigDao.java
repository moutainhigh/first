package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.CalendarConfigEntity;

public interface ICalendarConfigDao {
	
	/**
	 * 查询某月日程排班
	 * @param caldate
	 * @return
	 */
	public List<CalendarConfigEntity> getSchedule(String caldate);
	/**
	 * 修改某日排班
	 * @param caldate
	 * @param isrest
	 * @return
	 */
	public int updateSchedule(String caldate, String isrest);
	/**
	 * 添加排班
	 * @param caldate
	 * @return
	 */
	public int addSchedule(String caldate);

}
