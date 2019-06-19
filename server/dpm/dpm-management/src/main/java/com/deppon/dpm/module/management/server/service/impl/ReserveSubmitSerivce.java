package com.deppon.dpm.module.management.server.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.deppon.ar.bamp.common.util.DateUtil;
import com.deppon.dpm.module.management.server.dao.IReserveSubmitDao;
import com.deppon.dpm.module.management.server.service.IReserveSubmitSerivce;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.shared.domain.TimeEntity;
import com.deppon.dpm.module.management.util.Constants;

public class ReserveSubmitSerivce implements IReserveSubmitSerivce {
	
	private IReserveSubmitDao reserveSubmitDao;

	/**
	 * 获取指定日期  所有已经预定时间
	 * @param date
	 * @return
	 */
	public List<TimeEntity> getDayTimeList(Date date,int playRoomId) {
		String dateStr = DateUtil.getFormatDateTime(date, "yyyy-MM-dd");
		return this.reserveSubmitDao.getListTimeEntity(dateStr,playRoomId);
	}

	/**
	 * 添加记录
	 * @param entity
	 * @return
	 */
	public boolean addReserveEntity(ReserveRecordEntity entity) {
		int num = this.reserveSubmitDao.insertReserveEntity(entity);
		if(num >0){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取指定时间段内 记录信息
	 * @param fromTime
	 * @param toTime
	 * @return
	 */
	public List<ReserveRecordEntity> getReserveRecordList(String fromTime,
			String toTime) {
		return this.reserveSubmitDao.getRecordAll(fromTime, toTime);
	}

	
	/**
	 * 判断该记录是否可以添加  可以添加返回true  否 - false
	 * @param entity
	 * @return
	 * @throws ParseException 
	 */
	public boolean isCanAdd(ReserveRecordEntity entity) throws ParseException {
		Date start = entity.getStartTime();
		Date end = entity.getEndTime();
		/*int siteMark = entity.getSiteMark();
		String dateStr = DateUtil.getFormatDateTime(start, "yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);*/
		List<TimeEntity> listTime = this.getDayTimeList(start,entity.getPlayRoomId());
		return timeJudge(start,end,listTime);
	}


	/**
	 * 判断该时间段内是否可以添加  可以添加返回true  否 - false
	 */
	public boolean isCanAddList(List<TimeEntity> list,int playRoomId) throws ParseException {
		Date start = list.get(0).getStartTime();
		List<TimeEntity> listTime = this.getDayTimeList(start,playRoomId);
		for(TimeEntity timeEntity : list){
			if(!timeJudge(timeEntity.getStartTime(), timeEntity.getEndTime(), listTime)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断 startTime 到 endTime 是否可用
	 * @param startTime
	 * @param endTime
	 * @param list
	 * @return 不可用  返回 false  可用  返回true
	 */
	public static boolean timeJudge(Date startTime,Date endTime,List<TimeEntity> list){
		Long start = startTime.getTime();
		Long end = endTime.getTime(); 
		//遍历list
		for(TimeEntity time : list){
			Long listStart = time.getStartTime().getTime();
			Long listEnd = time.getEndTime().getTime();
			//开始时间比较
			if(startTime.getTime() != listStart){
				if(start > listStart && start < listEnd){
					return false;
				}
			}else{
				return false;
			}
			//结束时间比较
			if(endTime.getTime() != listEnd){
				if(end > listStart && end < listEnd){
					return false;
				}
			}else{
				return false;
			}
			
		}
		return true;
	}
	
	/**
	 * 普通用户预定场地时长 判断   规则不能超过2小时
	 * 超过2小时 返回false   2小时内返回 true
	 * @return
	 */
	public boolean canBeReserve(ReserveRecordEntity entity) {
		//格式化日期
		String date = DateUtil.getFormatDateTime(entity.getStartTime(), "yyyy-MM-dd");
		//获取该用户timeList
		List<TimeEntity> list = this.reserveSubmitDao.getListTimeByUserNo(date, entity.getUserNo(), entity.getSiteMark());
		Long twoHour = Constants.CONSTANT_TWO_HOUR;
		Long hasHour = 0L;
		//将用户今天预定的所有时间相加
		for(TimeEntity time : list){
			hasHour = time.getEndTime().getTime()-time.getStartTime().getTime() + hasHour;
		}
		//加上现在预定的时间
		hasHour += entity.getEndTime().getTime() - entity.getStartTime().getTime();
		//判断是否超过两小时
		if(hasHour <= twoHour ){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param list timeList
	 * @param userNo 用户工号
	 * @param siteMark 场地标记
	 * @return
	 */
	public boolean canBeReserveList(List<TimeEntity> list, String userNo,
			int siteMark) {
		//判断list是否有意义
		if(list!=null && list.size() > 0 ){
			//有意义
			//格式化时间
			String date = DateUtil.getFormatDateTime(list.get(0).getStartTime(), "yyyy-MM-dd");
			//得到用户在date预定的所有时间
			List<TimeEntity> listTime = this.reserveSubmitDao.getListTimeByUserNo(date, userNo, siteMark);
			Long twoHour = Constants.CONSTANT_TWO_HOUR;
			//预定时间
			Long hasHour = 0L;
			//遍历相加时间
			for(TimeEntity time : list){
				hasHour = time.getEndTime().getTime()-time.getStartTime().getTime() + hasHour;
			}
			//遍历相加时间
			for(TimeEntity time : listTime){
				hasHour = time.getEndTime().getTime()-time.getStartTime().getTime() + hasHour;
			}
			//判断是否超过2小时
			if(hasHour <= twoHour ){
				return true;
			}
			return false;
		}
		
		return false;
	}



	
	public IReserveSubmitDao getReserveSubmitDao() {
		return reserveSubmitDao;
	}

	public void setReserveSubmitDao(IReserveSubmitDao reserveSubmitDao) {
		this.reserveSubmitDao = reserveSubmitDao;
	}


	


	
	

}
