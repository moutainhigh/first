package com.deppon.dpm.module.fssc.server.dao.impl;

import com.deppon.dpm.module.fssc.server.dao.IPriorApplicationDao;
import com.deppon.dpm.module.fssc.shared.domain.DetailInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.FlightOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.HotelOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 数据库sql语句的方法
 * @author Administrator
 *
 */
public class PriorApplicationDao extends iBatis3DaoImpl implements IPriorApplicationDao {
	/**
	 * 保存事前申请单
	 * @return
	 */
	@Override
	public int savePriorApplication(PriorApplicationEntity pae) {
		return this.getSqlSession().insert("com.deppon.dpm.module.fssc.server.dao.priorapplication.insertPriorApplicationEntity",pae);
	}
	/**
	 * 保存明细信息
	 * @param detail
	 * @return
	 */
	@Override
	public int saveDetailInfoEntity(DetailInfoEntity detail) {
		return this.getSqlSession().insert("com.deppon.dpm.module.fssc.server.dao.priorapplication.insertDetailInfoEntity",detail);
	}
	/**
	 * 保存航班信息
	 * @param flight
	 * @return
	 */
	@Override
	public int saveFlightOrderInfoEntity(FlightOrderInfoEntity flight) {
		return this.getSqlSession().insert("com.deppon.dpm.module.fssc.server.dao.priorapplication.insertFlightOrderInfoEntity",flight);
	}
	/**
	 * 保存酒店信息
	 * @param hotel
	 * @return
	 */
	@Override
	public int saveHotelOrderInfoEntity(HotelOrderInfoEntity hotel) {
		return this.getSqlSession().insert("com.deppon.dpm.module.fssc.server.dao.priorapplication.insertHotelOrderInfoEntity",hotel);
	}
	/**
	 * 更新航班信息订单状态
	 * @param flight
	 * @return
	 */
	@Override
	public int updateFlightOrderInfoEntityByOrderState(
			FlightOrderInfoEntity flight) {
		return this.getSqlSession().update("com.deppon.dpm.module.fssc.server.dao.priorapplication.updateFlightOrderInfoEntityByOrderState", flight);
	}
	/**
	 * 更新酒店信息订单状态
	 * @param hotel
	 * @return
	 */
	@Override
	public int updateHotelOrderInfoEntityByOrderState(HotelOrderInfoEntity hotel) {
		return this.getSqlSession().update("com.deppon.dpm.module.fssc.server.dao.priorapplication.updateHotelOrderInfoEntityByOrderState",hotel);
	}
	
	@Override
	public int updatePriorApplicationEntity(PriorApplicationEntity pae) {
		return this.getSqlSession().update("com.deppon.dpm.module.fssc.server.dao.priorapplication.updatePriorApplicationEntity",pae);
	}

}
