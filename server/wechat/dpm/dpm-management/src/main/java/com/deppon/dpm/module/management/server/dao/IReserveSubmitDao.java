package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.shared.domain.TimeEntity;

public interface IReserveSubmitDao {
	
	/**
	 * 获取所有已经预定的时间
	 * @param String 预定日期
	 * @param siteMark 预定类型标准
	 * @return
	 */
	public List<TimeEntity> getListTimeEntity(String date,int playRoomId);
	
	/**
	 * 添加预定信息
	 * @param entity
	 * @return
	 */
	public int insertReserveEntity(ReserveRecordEntity entity);
	
	/**
	 * 获取用户预定某类场地的时间信息
	 * @param date
	 * @param siteMark
	 * @param userNo
	 * @return
	 */
	public List<TimeEntity> getListTimeByUserNo(String date,String userNo,int siteMark);
	
	/**
	 * 获取指定时间段内 记录信息
	 * @param fromTime
	 * @param toTime
	 * @return
	 */
	public List<ReserveRecordEntity> getRecordAll(String fromTime,String toTime);
	
}
