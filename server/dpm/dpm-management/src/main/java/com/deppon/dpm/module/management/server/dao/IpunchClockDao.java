package com.deppon.dpm.module.management.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.shared.domain.PunchClockEntity;
/**
 * 打卡考勤
 * @author 500612
 *
 */
public interface IpunchClockDao {
	/**
	 * 打卡考勤导入
	 * @author 276344
	 *
	 */
	public int syncRecord();
	/**
	 * 查询打卡考勤
	 * @author 276344
	 * @param cardTime 
	 *
	 */
	public PunchClockEntity getPunchClockRecord(Map<String,Object> map);
	public int createRecord(Map<String,Object> map);
	public int updateRecord(Map<String, Object> map);
	public List<PunchClockEntity> getPunchClockRecordList(String userId);

}
