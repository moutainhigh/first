package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IReservationManageByAdminDao;
import com.deppon.dpm.module.management.server.service.IReservationManageByAdminService;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;

/**
 * 管理员查询已预订信息service层实现类.
 * @author 曹嵩
 * <p>2015.10.21</p>
 */
public class ReservationManageByAdminService implements
		IReservationManageByAdminService {
	
	/**
	 * 日志.
	 */
	private static Logger logger = LoggerFactory.getLogger(ReservationManageByAdminService.class);
	
	/**
	 * reservationManageByAdminDao 注入
	 */
	private IReservationManageByAdminDao reservationManageByAdminDao;

	/**
	 * @return reservationManageByAdminDao注入
	 */
	public IReservationManageByAdminDao getReservationManageByAdminDao() {
		return reservationManageByAdminDao;
	}

	/**
	 * @param reservationManageByAdminDao reservationManageByAdminDao注入
	 */
	public void setReservationManageByAdminDao(
			IReservationManageByAdminDao reservationManageByAdminDao) {
		this.reservationManageByAdminDao = reservationManageByAdminDao;
	}

	/**
	 * 查询所有的已预订信息.
	 * @param areaName 楼层区域名称
	 * @param siteMark 预定类型标志（0羽毛球室，1瑜伽室）
	 */
	public Map<String, Object> getReservationManagList(String areaName, int siteMark,String searchTime) {
        //时间格式转换
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		logger.info("进入管理员查询已预订信息service方法getReservationManagList");
		logger.info("areaName:"+areaName+",siteMark:"+siteMark);
		//new 一个新对象
		ReserveRecordEntity rre = new ReserveRecordEntity();
		// 用来组装一个list
		List<ReserveRecordEntity> newList = new ArrayList<ReserveRecordEntity>();
		
		Map<String, Object> mapList = new HashMap<String, Object>();
		try {
			 // 将楼层区域名称保存在实体类中
			rre.setAreaName(areaName);
			// 将预定类型标志保存在实体类中
			rre.setSiteMark(siteMark); 
			rre.setSearchTime(searchTime);
			// 根据楼层区域的名称和预订类型标志得到预订所有的信息.
			List<ReserveRecordEntity> list = reservationManageByAdminDao.getReservationManagList(rre);
			//循环塞入数据
			for (ReserveRecordEntity re : list) {
				//塞入数据
				re.setStartTimeStr(sdf.format(re.getStartTime()));
				re.setEndTimeStr(sdf.format(re.getEndTime()));
				//塞入数据
				newList.add(re);
			}
			//put 数据
			mapList.put("ReserveRecordList", newList);
			// put 数据
			mapList.put("resultFlag",true);
		} catch (Exception e) {
			logger.info("getReservationManagList方法出现异常--cs");
			//抛出异常
			e.printStackTrace();
		}
		//返回数据
		return mapList;
	}
	

}
