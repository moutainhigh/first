package com.deppon.dpm.store.server.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.store.server.dao.IUpdateListDao;
import com.deppon.dpm.store.server.entity.StoreLike;
import com.deppon.dpm.store.server.entity.StoreList;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class UpdateListDao extends iBatis3DaoImpl implements IUpdateListDao{
	/**
	 * 名称空间
	 */
	private static final String NAME_SPACE="com.deppon.dpm.store.server.dao.IUpdateListDao.";
	/**
	 * 根据最新更新时间查询榜单数据
	 * @author lvdefu
	 * @date   2018年7月7日14:43:01
	 * @param  null
	 * @return ArrayList<StoreList>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<StoreList> queryStoreListByTs() {
		return (ArrayList<StoreList>) getSqlSession().selectList(NAME_SPACE+"queryStoreListByTs");
	}
	/**
	 * 根据执行id查询子任务
	 * @author lvdefu
	 * @date   2018年6月12日14:11:55
	 * @param  exeid
	 * @return StoreTaskSublist
	 */
	@Override
	public StoreTaskSublist querySubTaskByExeid(Long exeid) {
		return (StoreTaskSublist) getSqlSession().selectOne(NAME_SPACE+"querySubTaskByExeid", exeid);
	}
	/**
	 * 查询主任务
	 * @author lvdefu
	 * @date   2018年6月19日10:16:10
	 * @param  taskid
	 * @return StoreTask
	 */
	@Override
	public StoreTask queryTask(Integer taskid) {
		return (StoreTask) getSqlSession().selectOne(NAME_SPACE+"queryTask", taskid);
	}
	/**
	 * 批量插入到榜单
	 * @author lvdefu
	 * @date   2018年6月19日10:17:16
	 * @param  list
	 * @return 
	 */
	@Override
	public void insertStoreListAll(ArrayList<StoreList> list) {
		getSqlSession().insert(NAME_SPACE+"insertStoreListAll", list);
	}
	/**
	 * 根据执行id,查询到所有子任务
	 * @author lvdefu
	 * @date   2018年6月19日10:17:37
	 * @param  exeid
	 * @return List<StoreTaskSublist>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreTaskSublist> querySubTaskAllByExeid(Long exeid) {
		return getSqlSession().selectList(NAME_SPACE+"querySubTaskAllByExeid", exeid);
	}
	/**
	 * @
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreTaskSublist>  querySubTask(String deptNum, Integer taskid) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("deptnum", deptNum);
		map.put("taskid", taskid);
		return  getSqlSession().selectList(NAME_SPACE+"querySubTaskDeptTaskid", map);
	}
	/**
	 * @author lvdefu
	 * @date   2018年6月19日10:15:06
	 * @param  list
	 * @return
	 * 批量插入点赞表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insertStoreLikeAll(ArrayList<StoreLike> list) {
		getSqlSession().insert(NAME_SPACE+"insertStoreLikeAll", list);
	}
	/**
	 * 根据营业部编号,查询点赞表
	 * @author lvdefu
	 * @date   2018年6月19日10:18:29
	 * @param  deptnum
	 * @return StoreLike
	 */
	@Override
	public StoreLike selectStoreLike(String deptnum) {
		return (StoreLike) getSqlSession().selectOne(NAME_SPACE+"selectStoreLike", deptnum);
	}
	/**
	 * 根据营业部编号,查询最新一期榜单的排名
	 */
	@Override
	public String queryRanking(String deptnum) {
		return  (String) getSqlSession().selectOne(NAME_SPACE+"queryRanking", deptnum);
	}

	
}
