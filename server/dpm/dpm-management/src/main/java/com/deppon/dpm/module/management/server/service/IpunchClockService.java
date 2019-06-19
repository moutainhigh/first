package com.deppon.dpm.module.management.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.shared.domain.PunchClockEntity;


public interface IpunchClockService {
	/**
	 * 打卡考勤
	 * @author 276344
	 *
	 */
	public int syncRecord();
	/**
	 * 查询打卡记录
	 * @author 276344
	 * @param cardTime 
	 *
	 */
	public PunchClockEntity getPunchClockRecord(Map<String,Object> map);
	public int createRecord(Map<String,Object> map);
	public int updateRecord(Map<String, Object> map);
	public List<PunchClockEntity> getPunchClockRecordList(String userId);

}
