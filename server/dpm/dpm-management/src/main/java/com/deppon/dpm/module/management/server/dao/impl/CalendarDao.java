package com.deppon.dpm.module.management.server.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.ICalendarDao;
import com.deppon.dpm.module.management.shared.domain.CalendarInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 日程dao层
 * 
 * @author 245968
 * 
 */
public class CalendarDao extends iBatis3DaoImpl implements ICalendarDao {

	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.calendar.";

	/**
	 * 存储从邮箱拿到的日程数据
	 */
	@Override
	public void storageCalendarInfo(List<CalendarInfo> list, String email) {
		/**
		 * 遍历集合，存储日程 为何不用list插入，ibatis在list插入较多数据量时会有失败
		 */
		for (CalendarInfo calendarInfo : list) {
			calendarInfo.setDisplayTo(email);
			getSqlSession().insert(NAME_SPACE + "storageEmailInfo",
					calendarInfo);
		}

	}

	/**
	 * 日程创建
	 * 
	 * @param calendarInfo
	 */
	public void createCalendarInfo(CalendarInfo calendarInfo) {
		getSqlSession().selectList(NAME_SPACE + "insert", calendarInfo);
	}

	/**
	 * 日程获取
	 * 
	 * @param userId
	 * @param searchdtStart
	 * @param searchdtEnd
	 * @return
	 */
	public List<CalendarInfo> getCalendarInfoFromDb(String userId,
			Date searchdtStart, Date searchdtEnd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("searchdtStart", searchdtStart);
		map.put("searchdtEnd", searchdtEnd);
		return getSqlSession().selectList(NAME_SPACE + "select", map);
	}

	/**
	 * 日程删除
	 * 
	 * @param id
	 */
	@Override
	@Deprecated
	public void deleteCalendarInfo(int id) {
		getSqlSession().delete(NAME_SPACE + "delete", id);
	}

	/**
	 * 日程更新
	 * 
	 * @param calendarInfo
	 */
	@Override
	@Deprecated
	public void updateCalendarInfo(CalendarInfo calendarInfo) {
		getSqlSession().update(NAME_SPACE + "update", calendarInfo);
	}

	/**
	 * 日程获取
	 * 
	 * @param id
	 * @return
	 */
	@Override
	@Deprecated
	public CalendarInfo find(int id) {
		return (CalendarInfo) getSqlSession()
				.selectOne(NAME_SPACE + "find", id);
	}

}
