package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.AppraiseEntity;
import com.deppon.foss.framework.exception.BusinessException;

public interface IAppraiseDao {
	/**
	 * 根据时间编号去更新上报事件的状态
	 * @param orderCode
	 * 			事件编号
	 * @return
	 * @throws BusinessException
	 */
	public int updateAppraiseStatus(AppraiseEntity appraiseEntity) throws BusinessException;
	
	/**
	 * PC端调用此接口推送待确认状态的数据
	 * @return
	 * @throws BusinessException
	 */
	public int insertAppraiseInfo(AppraiseEntity appraiseEntity) throws BusinessException;
	
	/**
	 * 插入监控数据
	 * @param appraiseEntity
	 * @return
	 * @throws BusinessException
	 */
	public int insertAppraiseMonitor(AppraiseEntity appraiseEntity) throws BusinessException;
	
	/**
	 * 查询待确认件数
	 * @param currentUserCode
	 * @return
	 * @throws BusinessException
	 */
	public int selectAppraiseCount(String currentUserCode) throws BusinessException;
}
