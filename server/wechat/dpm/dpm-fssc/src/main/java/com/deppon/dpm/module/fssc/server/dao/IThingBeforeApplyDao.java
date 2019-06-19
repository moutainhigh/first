package com.deppon.dpm.module.fssc.server.dao;

import java.util.List;

import com.deppon.dpm.module.fssc.shared.domain.DetailInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.FlightOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.HotelOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;
import com.deppon.dpm.module.fssc.shared.domain.TheoneObjEntity;

/**
 * 事前申请单列表和详细信息DAO层接口
 * @author JFeng
 */
public interface IThingBeforeApplyDao {
	
	/**
	 * 1根据员工工号查询所有需要的数据信息
	 * @param applyEmpNo
	 */
	public List<TheoneObjEntity> queryAllInfo(String applyEmpNo);
	
	/**
	 * 2根据单据编号查询出事前申请单列表
	 * @param claimNo
	 */
	public List<PriorApplicationEntity> queryTravelAdvanceApply(String claimNo);
	
	/**
	 * 2根据单据编号查询出明细的详细信息
	 * @param claimNo
	 */
	public List<DetailInfoEntity> queryTravelApplyDetail(String claimNo);
	
	/**
	 * 2根据明细行id查询出所有的飞机订单信息
	 * @param claimLineId
	 */
	public List<FlightOrderInfoEntity> queryTravelFlightOrder(String claimLineId);
	
	/**
	 * 2根据明细行id查询出所有的酒店订单信息
	 * @param claimLineId
	 */
	public List<HotelOrderInfoEntity> queryTravelHotelOrder(String claimLineId);
	
}
