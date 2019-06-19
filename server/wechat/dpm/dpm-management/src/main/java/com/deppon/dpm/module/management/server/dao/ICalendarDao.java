package com.deppon.dpm.module.management.server.dao;

import java.util.Date;
import java.util.List;

import com.deppon.dpm.module.management.shared.domain.CalendarInfo;

/**
 * 日程dao层
 * 
 * @author 245968
 * 
 */
public interface ICalendarDao {
	/**
	 * 日程存储
	 * 
	 * @param list
	 * @param email
	 */
	public void storageCalendarInfo(List<CalendarInfo> list, String email);

	/**
	 * 日程创建
	 * 
	 * @param calendarInfo
	 */
	@Deprecated
	public void createCalendarInfo(CalendarInfo calendarInfo);

	/**
	 * 日程获取
	 * 
	 * @param userId
	 * @param searchdtStart
	 * @param searchdtEnd
	 * @return
	 */
	@Deprecated
	public List<CalendarInfo> getCalendarInfoFromDb(String userId,
			Date searchdtStart, Date searchdtEnd);

	/**
	 * 日程删除
	 * 
	 * @param id
	 */
	@Deprecated
	public void deleteCalendarInfo(int id);

	/**
	 * 日程更新
	 * 
	 * @param calendarInfo
	 */
	@Deprecated
	public void updateCalendarInfo(CalendarInfo calendarInfo);

	/**
	 * 日程获取
	 * 
	 * @param id
	 * @return
	 */
	@Deprecated
	public CalendarInfo find(int id);

}
