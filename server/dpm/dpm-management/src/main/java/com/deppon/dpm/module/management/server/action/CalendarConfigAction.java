package com.deppon.dpm.module.management.server.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.ICalendarConfigService;
import com.deppon.dpm.module.management.shared.domain.CalendarConfigEntity;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

public class CalendarConfigAction extends BaseAction{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9659283775248775L;
	/**
	 * log
	 */
	private static final Logger logger = Logger.getLogger(CalendarAction.class);
	
	/**
	 * set injection
	 */
	private ICalendarConfigService calendarConfigService;
	
    private String caldate;
	
	private CalendarConfigEntity calendar;
	
	/**
	 * 查询某月日程排班(后台)
	 */
	@CookieNotCheckedRequired
	public void getSchedule(){
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			List<CalendarConfigEntity> calendar = calendarConfigService.getSchedule(caldate);
			// 提示信息
			result.setData(calendar);
			// errorMessage
			result.setErrorMessage("成功");
			result.setErrorCode(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage(e.getMessage());
		}
		writeToPage(result);
	}
	
	/**
	 * 修改排班(后台)
	 */
	@CookieNotCheckedRequired
	public void updateSchedule(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 结果集定义
		Result<Object> result = new Result<Object>();
		try {
			int num = calendarConfigService.updateSchedule(calendar);
			// 提示信息
			result.setData(num);
			// errorMessage
			result.setErrorMessage("成功");
			result.setErrorCode(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(1);
			// errorMessage
			result.setErrorMessage(e.getMessage());
		}
		writeToPage(result);
	}

	public ICalendarConfigService getCalendarConfigService() {
		return calendarConfigService;
	}

	public void setCalendarConfigService(
			ICalendarConfigService calendarConfigService) {
		this.calendarConfigService = calendarConfigService;
	}

	public String getCaldate() {
		return caldate;
	}

	public void setCaldate(String caldate) {
		this.caldate = caldate;
	}

	public CalendarConfigEntity getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarConfigEntity calendar) {
		this.calendar = calendar;
	}
	
	

}
