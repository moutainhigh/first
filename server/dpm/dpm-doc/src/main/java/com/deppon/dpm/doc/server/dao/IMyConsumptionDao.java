package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.vo.DidiOrderVO;

/**
 * @Dexciption:TODO(我的消费DAO)
 * @InterfaceclassName:IMyconsumptionDao
 * @author: lvdf
 * @date:2018年3月19日09:05:12
 */
public interface IMyConsumptionDao {
	/**
	 * @param startDate
	 * @param endDate
	 * @param userId
	 * @return
	 */
	List<DidiOrderVO> myConsumptionByPersonal(String startDate,
			String endDate, String userId);
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param userId
	 * @return
	 */
	String queryTotalPriceById(String startDate, String endDate, String userId);
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param userId
	 * @return
	 */
	String queryNormalDistanceById(String startDate, String endDate,
			String userId);
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param userId
	 * @return
	 */
	String queryOrderCountById(String startDate, String endDate, String userId);
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param userId
	 * @return
	 */
	DidiOrderEntity queryTaxiDistribution(String startDate, String endDate,
			String userId);
	/**
	 * 
	 * @param userId
	 * @param year
	 * @param month
	 * @return
	 */
	List<DidiOrderEntity> queryCountAndPrice(String userId, String startDate, String endDate);

}