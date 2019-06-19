package com.deppon.dpm.module.management.server.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.shared.domain.TimeEntity;

/**
 * 
 * @author 王亚男
 *
 */
public interface IReserveSubmitSerivce {

	/**
	 * 获取指定日期  所有已经预定时间
	 * @param date
	 * @return
	 */
	public List<TimeEntity> getDayTimeList(Date date,int playRoomId);
	
	/**
	 * 添加记录
	 * @param entity
	 * @return
	 */
	public boolean addReserveEntity(ReserveRecordEntity entity);
	
	/**
	 * 判断该记录是否可以添加  可以添加返回true  否 - false
	 * @param entity
	 * @return
	 * @throws ParseException 
	 */
	public boolean isCanAdd(ReserveRecordEntity entity) throws ParseException;
	
	public boolean isCanAddList(List<TimeEntity> list,int playRoomId) throws ParseException;
	
	/**
	 * 普通用户预定场地时长 判断   规则不能超过2小时
	 * 超过2小时 返回false   2小时内返回 true
	 * @param userNo 预订人工号
	 * @param siteMark 场地类型
	 * @return
	 */
	public boolean canBeReserve(ReserveRecordEntity entity);
	
	/**
	 * 
	 * @param list timeList
	 * @param userNo 用户工号
	 * @param siteMark 场地标记
	 * @return
	 */
	public boolean canBeReserveList(List<TimeEntity> list,String userNo,int siteMark);
	
	/**
	 * 获取指定时间段内 记录信息
	 * @param fromTime
	 * @param toTime
	 * @return
	 */
	public List<ReserveRecordEntity> getReserveRecordList(String fromTime,String toTime);
	
	
}
