package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.doc.server.dao.IMyConsumptionDao;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.vo.DidiOrderVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * className:MyconsumptionDao
 * @Desciption:TODO(IMyconsumptionDao实现类)
 * @author 吕德富
 * @date:2018年3月19日09:11:28
 */
public class MyConsumptionDao extends iBatis3DaoImpl implements IMyConsumptionDao{
	
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiOrderDao.";
	
	/**
	 * @Desciption:TODO(根据员工号,年,月查询订单信息)
	 * @author: lvdf
	 * @date:2018年3月19日15:16:26
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderVO> myConsumptionByPersonal(String startDate,
			String endDate, String userId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("userId", userId);//员工号
		List<DidiOrderVO>  list=getSqlSession().selectList(NAME_SPACE+"myConsumptionByPersonal", map);
		if(list.size()!=0 && list!=null ){
			return list;
		}else{
			return null;
		}
	}
	/**
	 * @Desciption:TODO(根据员工号查询当月累计用车金额)
	 * @author: lvdf
	 * @date:2018年3月19日15:18:35
	 */
	@Override
	public String queryTotalPriceById(String startDate, String endDate,
			String userId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("userId", userId);//员工号;
		return (String) getSqlSession().selectOne(NAME_SPACE+"queryTotalPriceById", map);
	}
	/**
	 * @Desciption:TODO(根据员工号查询当月累计用车总公里数)
	 * @author: lvdf
	 * @date:2018年3月19日15:18:35
	 */
	@Override
	public String queryNormalDistanceById(String startDate, String endDate,
			String userId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("userId", userId);//员工号;
		return (String) getSqlSession().selectOne(NAME_SPACE+"queryNormalDistanceById", map);
	}
	/**
	 * @Desciption:TODO(根据员工号查询当月累计用车总订单数)
	 * @author: lvdf
	 * @date:2018年3月19日15:18:35
	 */
	@Override
	public String queryOrderCountById(String startDate, String endDate,
			String userId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("userId", userId);//员工号;
		return (String) getSqlSession().selectOne(NAME_SPACE+"queryOrderCountById", map);
		
	}
	/**
	 * @Desciption:TODO(根据员工号查询当月打车分布)
	 * @author: lvdf
	 * @date:2018年3月19日19:18:35
	 */
	@Override
	public DidiOrderEntity queryTaxiDistribution(String startDate,
			String endDate, String userId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("userId", userId);//员工号;
		return (DidiOrderEntity) getSqlSession().selectOne(NAME_SPACE+"queryTaxiDistribution", map);
	}
	/**
	 * @Desciption:TODO(根据员工号查询当月每日有效订单数和钱数)
	 * @author: lvdf
	 * @date:2018年3月19日19:18:35
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DidiOrderEntity> queryCountAndPrice(String userId, String startDate, String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//将参数放入map
		map.put("startDate", startDate);//起始日期
		map.put("endDate", endDate);//结束日期
		map.put("userId", userId);//员工号;
		List<DidiOrderEntity> list = getSqlSession().selectList(NAME_SPACE+"queryCountAndPrice", map);
		if(list.size()!=0 && list!=null){
			return list;
		}else{
			return null;
		}
		
	}
	
}