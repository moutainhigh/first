package com.deppon.dpm.store.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.store.server.entity.StoreTask;

public interface IStoreTaskDao {

	StoreTask insertSelective(StoreTask record);
	
	// 根据任务id查询任务子表中 总条数 ，已完成任务数量
	StoreTask selectsublistinfo(Integer taskid);
	
	// 根据任务id查询提交时间
	List<String> selectsublistvdef1(Integer taskid);
	/**
	 * 按id查询创建人的员工号
	 * @author XiaoTian
	 * @param taskid
	 * @return
	 */
	StoreTask finecreatorcode(Integer taskid);
	/**
	 * 编辑任务
	 * 修改任务
	 * @author XiaoTian
	 * @param StoreTask 类
	 */
	int taskUpdate(StoreTask storeTask);
	/**
	 * 查询子任务是否进行考评
	 * 返回 int 有考评返回值大于 0 
	 */
	int SublistCount(Map<String, Object> map);
	/**
	 * 查询主任务下的子任务所有 exeid
	 */
	List<String> SelectExeid(Integer taskid);
	/**
	 * 删除所有子任务
	 */
	int DeteleSublist(Integer taskid);
	/**
	 * 删除所有子任务的模块
	 */
	int DeteleMark(List<String> list);
	/**
	 * 查询主任务是否存在
	 */
	int taskExist(Integer taskid);
	
}