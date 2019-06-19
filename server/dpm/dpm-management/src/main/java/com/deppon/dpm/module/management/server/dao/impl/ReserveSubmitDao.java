package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IReserveSubmitDao;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.shared.domain.TimeEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * @author 王亚男
 * 场地预定
 */
public class ReserveSubmitDao extends iBatis3DaoImpl implements IReserveSubmitDao {

	private String mapperNameSpace="com.deppon.dpm.module.management.server.dao.reserveSubmit";

	/**
	 * 获取所有已经预定的时间
	 * @param String 预定日期
	 * @param siteMark 预定类型标准
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TimeEntity> getListTimeEntity(String date,int playRoomId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("date", date);
		params.put("playRoomId", playRoomId);
		return this.getSqlSession().selectList(mapperNameSpace+".getReserveTimeList",params);
	}

	/**
	 * 添加预定信息
	 * @param entity
	 * @return
	 */
	public int insertReserveEntity(ReserveRecordEntity entity) {
		return this.getSqlSession().insert(mapperNameSpace+".insertEntity", entity);
	}

	/**
	 * 获取用户预定某类场地的时间信息
	 * @param date
	 * @param siteMark
	 * @param userNo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TimeEntity> getListTimeByUserNo(String date, String userNo,
			int siteMark) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("date", date);
		params.put("userNo", userNo);
		params.put("siteMark", siteMark);
		return this.getSqlSession().selectList(mapperNameSpace+".selectTimeList",params);
	}

	/**
	 * 获取指定时间段内 记录信息
	 * @param fromTime
	 * @param toTime
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ReserveRecordEntity> getRecordAll(String fromTime, String toTime) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("fromTime", fromTime);
		map.put("toTime", toTime);
		return this.getSqlSession().selectList(mapperNameSpace+".getRecordList", map);
	}

}
