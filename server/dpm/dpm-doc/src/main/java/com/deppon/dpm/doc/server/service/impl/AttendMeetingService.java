package com.deppon.dpm.doc.server.service.impl;

import com.deppon.dpm.doc.server.dao.IAttendMeetingDao;
import com.deppon.dpm.doc.server.service.IAttendMeetingService;

public class AttendMeetingService implements IAttendMeetingService{
	
	//参加会议DAO
	private IAttendMeetingDao attendMeetingDao;

	public IAttendMeetingDao getAttendMeetingDao() {
		return attendMeetingDao;
	}

	public void setAttendMeetingDao(IAttendMeetingDao attendMeetingDao) {
		this.attendMeetingDao = attendMeetingDao;
	}
}
