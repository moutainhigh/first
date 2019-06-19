package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IAppraiseDao;
import com.deppon.dpm.module.management.shared.domain.AppraiseEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @author 268101
 * 
 * IAppraiseDao 的实现
 */
public class AppraiseDao extends iBatis3DaoImpl implements IAppraiseDao {
	String nameSpace = "com.deppon.dpm.module.management.server.dao.report";

	/**
	 * 根据时间编号去更新上报事件的状态
	 * @param orderCode
	 * 			事件编号
	 * @return
	 * @throws BusinessException
	 */
	public int updateAppraiseStatus(AppraiseEntity appraiseEntity)
			throws BusinessException {
		return this.getSqlSession().update(nameSpace + ".updateAppraise",
				appraiseEntity);
	}

	/**
	 * PC端调用此接口推送待确认状态的数据
	 * @return
	 * @throws BusinessException
	 */
	public int insertAppraiseInfo(AppraiseEntity appraiseEntity)
			throws BusinessException {
		return this.getSqlSession().insert(nameSpace + ".insertAppraise",
				appraiseEntity);
	}

	/**
	 * 插入监控数据
	 * @param appraiseEntity
	 * @return
	 * @throws BusinessException
	 */
	public int insertAppraiseMonitor(AppraiseEntity appraiseEntity)
			throws BusinessException {
		return this.getSqlSession().insert(nameSpace + ".insertMonitorData",
				appraiseEntity);
	}

	/**
	 * 查询待确认件数
	 * @param currentUserCode
	 * @return
	 * @throws BusinessException
	 */
	public int selectAppraiseCount(String currentUserCode) throws BusinessException {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlSession().selectOne(nameSpace + ".selectAppraiseCount", currentUserCode);
	}
}
