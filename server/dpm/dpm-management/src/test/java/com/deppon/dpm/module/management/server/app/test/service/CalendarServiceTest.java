package com.deppon.dpm.module.management.server.app.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.app.test.BaseTestCase;
import com.deppon.dpm.module.management.server.service.impl.CalendarService;
import com.deppon.dpm.module.management.shared.domain.CalendarInfo;

public class CalendarServiceTest extends BaseTestCase {
	@Autowired
	private CalendarService calendarService;

	@Test
	public void test() {
		calendarService.getHost();
		calendarService.getJdbcTemplate();
		calendarService.getServerHostPort();
		calendarService.getTongxunLuService();
		calendarService.getUsrId();
		calendarService.getCalList();
	}
	
	@Test
	public void createAppointMentTest() throws Exception {
		String userId = "116250";
		CalendarInfo info = new CalendarInfo();
		info.setSubject("约会: e");
		info.setContent("测试");
		String begin = "2016-01-11 15:18:00";
		String end = "2016-01-11 15:18:00";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
		try {
			Date searchdtStart = df.parse(begin);
			Date searchdtEnd = df.parse(end);
			info.setStart(searchdtStart);
			info.setEnd(searchdtEnd);
			info.setLocation("测试地址");
			info.setReminderMinutesBeforeStart("0");
			calendarService.createAppointMent(userId, info);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getCalendarInfosTest() {
		String userId = "116250";
		// zzzzzz0$
		String password = "ltKUNIwDy7QfbLnwa2TD1g==";
		String begin = "2016-01-09";
		String end = "2016-01-12";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date searchdtStart = df.parse(begin);
			Date searchdtEnd = df.parse(end);
			String json = calendarService.getCalendarInfos(userId, password, searchdtStart, searchdtEnd);
			JSONObject jsonObject = JSONObject.parseObject(json);
			List calendarInfos = (List)jsonObject.get("data");
			if(null != calendarInfos && calendarInfos.size()>0){
				JSONObject a = (JSONObject)calendarInfos.get(0);
				String appointmentId = (String)a.get("appointmentId");
				
				CalendarInfo info = new CalendarInfo();
				info.setAppointmentId(appointmentId);
				info.setSubject("约会: 3");
				info.setContent("asdf");
				info.setStart(searchdtStart);
				info.setEnd(searchdtEnd);
				info.setLocation("y");
				calendarService.updateAppointment(userId, info);
				
				calendarService.cancelAppointment(userId, appointmentId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getCalendarCountTest() {
		String userId = "116250";
		// zzzzzz0$
		String password = "ltKUNIwDy7QfbLnwa2TD1g==";
		String begin = "2016-01-09";
		String end = "2016-01-12";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date searchdtStart = df.parse(begin);
			Date searchdtEnd = df.parse(end);
			calendarService.getCalendarCount(userId, password, searchdtStart, searchdtEnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
