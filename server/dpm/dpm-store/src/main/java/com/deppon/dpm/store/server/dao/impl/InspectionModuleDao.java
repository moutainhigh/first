package com.deppon.dpm.store.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import com.deppon.dpm.store.server.dao.IInspectionModuleDao;
import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class InspectionModuleDao extends iBatis3DaoImpl implements IInspectionModuleDao {
	
	//巡检模块打分mapper名称空间
	private static final String NAME_SPACE_ONE = "com.deppon.dpm.store.server.dao.IStoreMarkDao.";
	
	//子任务mapper名称空间
	private static final String NAME_SPACE_TWO = "com.deppon.dpm.store.server.dao.IStoreTaskSublistDao.";
	
	//主任务mapper名称空间
	private static final String NAME_SPACE_THREE ="com.deppon.dpm.store.server.dao.IStoreTaskDao.";
	
	/**
	 * 根据子任务的执行id查询巡检模块
	 * @author lvdefu
	 * @date   2018年5月31日11:41:24
	 * @param  exeid
	 * @return List<StoreMod>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreMark> queryModule(Long exeid) {
		List<StoreMark> list=getSqlSession().selectList(NAME_SPACE_ONE+"queryModule", exeid);
		if(list.size()!=0 && list!=null){
			return list;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据执行ID查询巡检模块
	 * @author lvdefu
	 * @date   2018年6月5日17:25:25
	 * @param  exeid
	 * @return List<StoreMod>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreMark> queryModByExeid(Long exeid) {
		List<StoreMark> list = getSqlSession().selectList(NAME_SPACE_ONE+"queryModule", exeid);
		//判断返回null还是list
		if(list!=null && list.size()!=0){
			return list;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据主任务ID查询子任务实体
	 * @author lvdefu
	 * @date   2018年5月31日11:45:13
	 * @param  taskId
	 * @return ArrayList<StoreTaskSublist>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreTaskSublist> querySubtasks(Integer taskId) {
		//调用数据库
		List<StoreTaskSublist> list =  getSqlSession().selectList(NAME_SPACE_TWO+"querySubtasks", taskId);
		//判断返回
		if(list!=null && list.size()!=0){
			//返回list
			return list;
		}else{
			//返回null
			return null;
		}
	}

	
	
	/**
	 * 根据主任务Id查询子任务,根据执行人分组
	 * @param taskId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreTaskSublist> querySubtasksGroup(Integer taskId) {
		List<StoreTaskSublist> list = getSqlSession().selectList(NAME_SPACE_TWO+"querySubtasksGroup", taskId);
		if(list!=null && list.size()!=0){
			return list;
		}else{
			return null;
		}
	}
	/**
	 * 根据执行人Id查询子任务
	 * @param exeerId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreTaskSublist> querySubtasksByExeerId(String exeerId,Integer taskId) {
		HashMap map = new HashMap();
		//放入参数
		map.put("exeerId", exeerId);
		//放入参数
		map.put("taskId",taskId);
		List<StoreTaskSublist> list = getSqlSession().selectList(NAME_SPACE_TWO+"querySubtasksByExeerId", map);
		//判断返回空还是list
		if(list!=null && list.size()!=0){
			return list;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据执行id查询主任务id
	 * @author lvdefu
	 * @date   2018年6月19日10:09:52
	 * @param  exeid
	 * @return String
	 */
	@Override
	public String queryTaskidByExeid(Long exeid) {
		return (String) getSqlSession().selectOne(NAME_SPACE_TWO+"queryTaskidByExeid", exeid);
	}

	/**
	 * 查询主任务
	 * @author lvdefu
	 * @date   2018年6月19日10:09:30
	 * @param  taskId
	 * @return StoreTask
	 */
	@Override
	public StoreTask querTask(Integer taskId) {
		return (StoreTask) getSqlSession().selectOne(NAME_SPACE_THREE+"queryTaskByTaskid", taskId);
	}
}
