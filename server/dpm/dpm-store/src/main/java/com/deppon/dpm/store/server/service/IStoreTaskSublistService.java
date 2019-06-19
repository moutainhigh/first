package com.deppon.dpm.store.server.service;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.store.server.entity.StoreTaskSublist;
/**
 * 任务子表
 * @author XiaoTian
 *
 */
public interface IStoreTaskSublistService {
	/**
	 * 批量插入子任务
	 * 添加子任务
	 * @param record
	 * @return
	 */
	List<StoreTaskSublist> insertSelectives(ArrayList<StoreTaskSublist> record);
	/**
	 * 修改子任务任务表信息
	 */
	int updateByPrimaryKeySelective(StoreTaskSublist record);
}
