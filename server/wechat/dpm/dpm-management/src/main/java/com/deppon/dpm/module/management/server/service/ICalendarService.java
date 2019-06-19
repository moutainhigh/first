package com.deppon.dpm.module.management.server.service;

import java.util.Date;

import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.shared.domain.CalendarInfo;

/**
 * 日程service
 * 
 * @author 245968
 * 
 */
public interface ICalendarService {
	/**
	 * 创建日程信息
	 * 
	 * @param calendarInfo
	 */
	public void createCalendarInfo(CalendarInfo calendarInfo);

	/**
	 * 获取日程信息
	 * 
	 * @param userId
	 * @param password
	 * @param searchdtStart
	 * @param searchdtEnd
	 * @return
	 */
	public String getCalendarInfos(String userId, String password,
			Date searchdtStart, Date searchdtEnd);

	/**
	 * 获取日程数量
	 * 
	 * @param userId
	 * @param password
	 * @param searchdtStart
	 * @param searchdtEnd
	 * @return
	 */
	public String getCalendarCount(String userId, String password,
			Date searchdtStart, Date searchdtEnd);

	/**
	 * 删除日程
	 * 
	 * @param id
	 */
	public void deleteCalendarInfo(int id);

	/**
	 * 更新日程信息
	 * 
	 * @param calendarInfo
	 */
	public void updateCalendarInfo(CalendarInfo calendarInfo);

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	public CalendarInfo find(int id);

	/**
	 * 新增、更改邮箱信息
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public String insertOrUpdateEmail(String userId, String password);

	/**
	 * 创建会议
	 * 
	 * @param userId
	 * @param calendarInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Object> createAppointMent(String userId,
			CalendarInfo calendarInfo) throws Exception;

	/**
	 * 取消会议
	 * 
	 * @param userId
	 * @param appointmentId
	 * @throws Exception
	 */
	public void cancelAppointment(String userId, String appointmentId)
			throws Exception;

	/**
	 * 更新约会
	 * 
	 * @param userId
	 * @param info
	 * @throws Exception
	 */
	public void updateAppointment(String userId, CalendarInfo info)
			throws Exception;
}
