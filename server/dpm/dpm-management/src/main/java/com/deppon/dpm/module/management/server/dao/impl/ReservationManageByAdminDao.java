package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IReservationManageByAdminDao;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 管理员查询已预订信息dao层实现类.
 * @author 曹嵩
 * <p>2015.10.21</p>
 */
public class ReservationManageByAdminDao extends iBatis3DaoImpl implements
		IReservationManageByAdminDao {
	//命名的工作空间
	private static final String mappernamespace="com.deppon.dpm.module.management.server.dao.reserveManageCancel"; 
	/**
	 * 查询已预订信息
	 * @return 已经预定的信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReserveRecordEntity> getReservationManagList(
			ReserveRecordEntity rre) {
		return this.getSqlSession().selectList(mappernamespace+".getReservationManagList", rre);
	}

}
