package com.deppon.dpm.store.server.dao;

import java.util.List;

import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;


public interface IInspectionModuleDao {
	
	/**
	 * 根据主任务id查询子任务
	 * @author lvdefu
	 * @date   2018年5月31日11:41:11
	 * @param  taskId
	 * @return ArrayList<StoreTaskSublist>
	 */
	List<StoreTaskSublist> querySubtasks(Integer taskId);
	/**
	 * 根据子任务的执行id查询巡检模块
	 * @author lvdefu
	 * @date   2018年5月31日11:41:24
	 * @param  exeid
	 * @return List<StoreMod>
	 */
	List<StoreMark> queryModule(Long exeid);
	/**
	 * 根据主任务Id查询子任务,根据执行人分组
	 * @param taskId
	 * @return
	 */
	List<StoreTaskSublist> querySubtasksGroup(Integer taskId);
	/**
	 * 根据执行人Id,主任务ID查询子任务
	 * @param exeerId
	 * @param taskId
	 * @return
	 */
	List<StoreTaskSublist> querySubtasksByExeerId(String exeerId, Integer taskId);
	/**
	 * 根据执行ID查询巡检模块
	 * @author lvdefu
	 * @date   2018年6月5日17:25:25
	 * @param  exeid
	 * @return List<StoreMod>
	 */
	List<StoreMark> queryModByExeid(Long exeid);
	/**
	 * 查询主任务
	 * @param taskId
	 * @return
	 */
	StoreTask querTask(Integer taskId);
	/**
	 * 根据执行id查询主任务id
	 * @param exeid
	 * @return
	 */
	String queryTaskidByExeid(Long exeid);

}
