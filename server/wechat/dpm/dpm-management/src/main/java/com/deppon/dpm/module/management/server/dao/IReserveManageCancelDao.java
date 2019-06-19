package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;

/**
 * 预订管理羽毛球和瑜伽室的取消预订和提前结束dao层接口.
 * @author 曹嵩
 * <p>时间:2015.10.20</p>
 */
public interface IReserveManageCancelDao {

	/**
	 * 修改状态并且修改当前时间根据id.
	 * @param rre 实体类.
	 */
	public int updateState(ReserveRecordEntity rre);
}
