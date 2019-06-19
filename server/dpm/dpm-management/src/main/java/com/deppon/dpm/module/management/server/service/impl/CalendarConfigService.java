package com.deppon.dpm.module.management.server.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.management.server.dao.ICalendarConfigDao;
import com.deppon.dpm.module.management.server.service.ICalendarConfigService;
import com.deppon.dpm.module.management.shared.domain.CalendarConfigEntity;

public class CalendarConfigService implements ICalendarConfigService{
	
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(CalendarConfigService.class);
	/**
	 * set injection
	 */
	private ICalendarConfigDao calendarConfigDao;
	
	/**
	 * 查询某月日程排班
	 * @param caldate
	 * @return
	 */
	public List<CalendarConfigEntity> getSchedule(String caldate){
		return calendarConfigDao.getSchedule(caldate);
	}
	
	/**
	 * 修改排班
	 * @param caldate
	 * @param isrest
	 * @return
	 */
	public int updateSchedule(CalendarConfigEntity calendar){
		int num = 0;
		if(calendar.getIsrest().equals("0")){
			num = calendarConfigDao.updateSchedule(calendar.getCalDate(),calendar.getIsrest());
		}else if(calendar.getIsrest().equals("1")){
			num = calendarConfigDao.updateSchedule(calendar.getCalDate(),calendar.getIsrest());
			if(num == 0){
				num = calendarConfigDao.addSchedule(calendar.getCalDate());
			}
		}
		return num;
	}

	public ICalendarConfigDao getCalendarConfigDao() {
		return calendarConfigDao;
	}

	public void setCalendarConfigDao(ICalendarConfigDao calendarConfigDao) {
		this.calendarConfigDao = calendarConfigDao;
	}

	
}
