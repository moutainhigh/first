package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IReserveManageCancelDao;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 预订管理羽毛球和瑜伽室的取消预订和提前结束dao层实现类.
 * @author 曹嵩
 * <p>时间:2015.10.20</p>
 */
public class ReserveManageCancelDao extends iBatis3DaoImpl implements
		IReserveManageCancelDao {

	private String mappernamespace="com.deppon.dpm.module.management.server.dao.reserveManageCancel";
			
	@Override
	public int updateState(ReserveRecordEntity rre) {
		return this.getSqlSession().update(mappernamespace+".upStatus", rre);
	}

}
