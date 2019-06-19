package com.deppon.dpm.module.fssc.server.dao;

import com.deppon.dpm.module.fssc.shared.domain.DetailInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.FlightOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.HotelOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;

/**
 * 操作事前申请单的保存和更新
 * date 2015-6-2
 * @author 曹嵩
 *
 */
public interface IPriorApplicationDao {

	/**
	 * 保存事前申请单
	 * @return
	 */
	public int savePriorApplication(PriorApplicationEntity pae);
	
	/**
	 * 更新事前申请单
	 * @param pae 
	 * @return
	 */
	public int updatePriorApplicationEntity(PriorApplicationEntity pae);
	
	/**
	 * 保存明细信息
	 * @param detail
	 * @return
	 */
	public int saveDetailInfoEntity(DetailInfoEntity detail);
	
	/**
	 * 保存航班信息
	 * @param flight
	 * @return
	 */
	public int saveFlightOrderInfoEntity(FlightOrderInfoEntity flight);
	
	/**
	 * 更新航班信息订单状态
	 * @param flight
	 * @return
	 */
	public int updateFlightOrderInfoEntityByOrderState(FlightOrderInfoEntity flight);
	
	/**
	 * 保存酒店信息
	 * @param hotel
	 * @return
	 */
	public int saveHotelOrderInfoEntity(HotelOrderInfoEntity hotel);
	
	/**
	 * 更新酒店信息订单状态
	 * @param hotel
	 * @return
	 */
	public int updateHotelOrderInfoEntityByOrderState(HotelOrderInfoEntity hotel);
	
}
