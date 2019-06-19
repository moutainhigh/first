package com.deppon.dpm.store.server.dao;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.store.server.entity.StoreTaskSublist;
/**
 * 
 * @author XiaoTian
 *
 */
public interface IStoreTaskSublistDao {
	/**
	 * 批量插入子任务
	 * 添加子任务
	 * @param storeTaskSublists
	 * @return
	 */
	List<StoreTaskSublist> insertSelectives(List<StoreTaskSublist> storeTaskSublists);
	/**
	 * 修改子任务任务表信息
	 */
	int updateByPrimaryKeySelective(StoreTaskSublist record);
	/**
	 * 查询榜单需要营业部信息
	 */
	List<StoreTaskSublist> finelistdept(String taskid);
}