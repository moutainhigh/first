package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;


/**
 * 管理员查询已预订信息dao层接口.
 * @author 曹嵩
 * <p>2015.10.21</p>
 */
public interface IReservationManageByAdminDao {

	/**
	 * 查询已预订信息
	 * @return 已经预定的信息
	 */
	public List<ReserveRecordEntity> getReservationManagList(ReserveRecordEntity rre);
}
