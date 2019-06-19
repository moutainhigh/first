package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IMyConsumptionDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IMyConsumptionService;
import com.deppon.dpm.doc.server.vo.DidiOrderVO;

/**
 * @Dexciption:TODO(我的消费Iservice实现类)
 * @className:MyconsumptionService
 * @author: lvdf
 * @date:2018年3月19日09:07:49
 */
public class MyConsumptionService implements IMyConsumptionService{
	
	/**
	 * 注入myConsumptionDao
	 */
	private IMyConsumptionDao  myConsumptionDao;
	
	public IMyConsumptionDao getMyConsumptionDao() {
		return myConsumptionDao;
	}

	public void setMyConsumptionDao(IMyConsumptionDao myConsumptionDao) {
		this.myConsumptionDao = myConsumptionDao;
	}

	/**
	 * @Desciption:TODO(根据员工号,年,月查询订单信息)
	 * @author: lvdf
	 * @date:2018年3月19日15:16:26
	 */
	@Override
	public List<DidiOrderVO> myConsumptionByPersonal(String startDate,
			String endDate, String userId) {
		return myConsumptionDao.myConsumptionByPersonal(startDate,endDate,userId);
	}
	
	/**
	 * @Desciption:TODO(根据员工号查询当月累计用车金额)
	 * @author:lvdf
	 * @date:2018年3月19日15:17:07
	 */
	@Override
	public String queryTotalPriceById(String startDate, String endDate,
			String userId) {
		return myConsumptionDao.queryTotalPriceById(startDate,endDate,userId);
	}
	
	/**
	 * @Desciption:TODO(根据员工号查询当月累计用车总公里数)
	 * @author: lvdf
	 * @date:2018年3月19日15:17:07
	 */
	@Override
	public String queryNormalDistanceById(String startDate, String endDate,
			String userId) {
		return myConsumptionDao.queryNormalDistanceById(startDate,endDate,userId);
	}
	/**
	 * @Desciption:TODO(根据员工号查询当月累计订单总数)
	 * @author: lvdf
	 * @date:2018年3月19日17:53:28
	 */
	@Override
	public String queryOrderCountById(String startDate, String endDate,
			String userId) {
		return myConsumptionDao.queryOrderCountById(startDate,endDate,userId);
	}
	/**
	 * @Desciption:TODO(根据员工号查询当月打车分布情况)
	 * @author: lvdf
	 * @date:2018年3月19日17:53:28
	 */
	@Override
	public DidiOrderEntity queryTaxiDistribution(String startDate,
			String endDate, String userId) {
		return myConsumptionDao.queryTaxiDistribution(startDate,endDate,userId);
	}

	/**
	 * 根据员工号查询当月每日有效订单数和钱数
	 */
	@Override
	public List<DidiOrderEntity> queryCountAndPrice(String userId, String startDate, String endDate) {
		return myConsumptionDao.queryCountAndPrice(userId,startDate,endDate);
	}
	/**
	 * 根据年月部门名称查询月累计金额
	 */
	@Override
	public String queryCountMoneyByDept(String deptName, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}