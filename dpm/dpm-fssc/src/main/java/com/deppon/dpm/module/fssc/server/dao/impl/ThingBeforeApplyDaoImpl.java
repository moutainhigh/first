package com.deppon.dpm.module.fssc.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.fssc.server.dao.IThingBeforeApplyDao;
import com.deppon.dpm.module.fssc.shared.domain.DetailInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.FlightOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.HotelOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;
import com.deppon.dpm.module.fssc.shared.domain.TheoneObjEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * DAO代码的实现
 * @author JFeng
 */
public class ThingBeforeApplyDaoImpl extends iBatis3DaoImpl implements
		IThingBeforeApplyDao {
	//赵配置文件的路径
	static String mapperNameSpace = "com.deppon.dpm.module.fssc.server.dao.stocktask";

	/**
	 * 1查询事前申请单列表信息
	 */
	public List<TheoneObjEntity> queryAllInfo(String applyEmpNo) {
		//返回列表信息
		return this.getSqlSession().selectList(mapperNameSpace+".queryAllInfo",applyEmpNo);
	}
	
	/**
	 * 2根据事前申请单编号查询出事前申请单信息
	 */
	public List<PriorApplicationEntity> queryTravelAdvanceApply(String claimNo) {
		//返回事前申请单信息
		return getSqlSession().selectList(mapperNameSpace+".queryTravelAdvanceApply",claimNo);
	}

	/**
	 * 2根据单据编号查询出所有明细信息
	 */
	public List<DetailInfoEntity> queryTravelApplyDetail(String claimNo) {
		//返回明细信息
		return this.getSqlSession().selectList(mapperNameSpace+".queryTravelApplyDetail",claimNo);
	}

	/**
	 * 2根据明细行id查询航班订单列表
	 */
	
	public List<FlightOrderInfoEntity> queryTravelFlightOrder(String claimLineId) {
		//返回数据
		return getSqlSession().selectList(mapperNameSpace+".queryFlightOrderInfo",claimLineId);
	}

	/**
	 * 2根据明细行id查询酒店订单列表
	 */
	public List<HotelOrderInfoEntity> queryTravelHotelOrder(String claimLineId) {
		//返回数据
		return getSqlSession().selectList(mapperNameSpace+".queryHotelOrderInfo",claimLineId);
	}

}
