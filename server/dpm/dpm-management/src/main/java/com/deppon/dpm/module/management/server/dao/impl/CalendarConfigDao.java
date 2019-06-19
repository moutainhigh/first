package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.ICalendarConfigDao;
import com.deppon.dpm.module.management.shared.domain.CalendarConfigEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class CalendarConfigDao  extends iBatis3DaoImpl implements ICalendarConfigDao{
	
	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.calendar.";
	
	/**
	 * 查询某月日程排班
	 * @param caldate
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CalendarConfigEntity> getSchedule(String caldate){
		
		return getSqlSession().selectList(NAME_SPACE + "getSchedule", caldate + "-%");
	}
	
	/**
	 * 修改某日排班
	 * @param caldate
	 * @param isrest
	 * @return
	 */
	public int updateSchedule(String caldate, String isrest){
		Map<String,String> map = new HashMap<String,String>();
		map.put("caldate", caldate);
		map.put("isrest", isrest);
		return getSqlSession().update(NAME_SPACE + "updateSchedule", map);
	}
	/**
	 * 添加排班
	 * @param caldate
	 * @return
	 */
	public int addSchedule(String caldate){
		return getSqlSession().insert(NAME_SPACE + "addSchedule", caldate);
	}

}
