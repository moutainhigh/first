package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.AppraiseEntity;

public interface IAppraiseDao {
	/**
	 * 根据时间编号去更新上报事件的状态
	 * @param orderCode
	 * 			事件编号
	 * @return
	 * @throws Exception
	 */
	public int updateAppraiseStatus(AppraiseEntity appraiseEntity) throws Exception;
	
	/**
	 * PC端调用此接口推送待确认状态的数据
	 * @return
	 * @throws Exception
	 */
	public int insertAppraiseInfo(AppraiseEntity appraiseEntity) throws Exception;
	
	/**
	 * 插入监控数据
	 * @param appraiseEntity
	 * @return
	 * @throws Exception
	 */
	public int insertAppraiseMonitor(AppraiseEntity appraiseEntity) throws Exception;
	
	/**
	 * 查询待确认件数
	 * @param currentUserCode
	 * @return
	 * @throws Exception
	 */
	public int selectAppraiseCount(String currentUserCode) throws Exception;
}
