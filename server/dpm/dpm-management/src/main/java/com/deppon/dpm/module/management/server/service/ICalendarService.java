package com.deppon.dpm.module.management.server.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
	 * 获取日程信息 首页--设置里面
	 * 
	 * @param userId
	 * @param password
	 * @param searchdtStart
	 * @param searchdtEnd
	 * @return
	 */
	public String getCalendarInfosThree(String userId, String password,
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
	public Result<Object> createAppointMent(String userId,CalendarInfo calendarInfo);
	
	/**
	 * 创建会议  新版 区分会议和日程
	 * 
	 * @param userId
	 * @param calendarInfo
	 * @return
	 * @throws Exception
	 */
	public Result<Object> createAppointMeeting(String userId,CalendarInfo calendarInfo, String meetingType);

	/**
	 * 取消会议
	 * 
	 * @param userId
	 * @param appointmentId
	 * @throws Exception
	 */
	public void cancelAppointment(String userId, String appointmentId);

	/**
	 * 更新约会
	 * 
	 * @param userId
	 * @param info
	 * @throws Exception
	 */
	public void updateAppointment(String userId, CalendarInfo info);
	
	/**
	 * 参加会议
	 * @param userId
	 * @param appointmentId
	 */
	public void createAccept(String userId, String appointmentId);
	
	/**
	 * 拒绝参加会议
	 * @param userId
	 * @param appointmentId
	 */
	public void createDecline(String userId, String appointmentId);
	
	/**
	 * 暂定会议
	 * @param userId
	 * @param appointmentId
	 */
	public void createAcceptTentative(String userId, String appointmentId);

	/**
	 * 获取日程跟约会通知
	 * 
	 * @param userId
	 * @param info
	 * @throws Exception
	 */
	public List<CalendarInfo> getNoticeCalendarInfos(String userId, String password,
			Date searchdtStart, Date searchdtEnd);
	/**
	 * 获取日程跟约会通知根据创建时间排序
	 * 
	 * @param userId
	 * @param info
	 * @throws Exception
	 */
	List<CalendarInfo> getNoticeCalendarInfosOrderByCTime(String userId,
			String password, Date searchdtStart, Date searchdtEnd);
	
	/**
	 * 获取日程排班信息
	 * @param map
	 * @return
	 */
	public String getCalendarPlan(Map<String, String> map);

}
