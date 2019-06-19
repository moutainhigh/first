package com.deppon.dpm.store.server.dao;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.store.server.entity.StoreLike;
import com.deppon.dpm.store.server.entity.StoreList;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;

public interface IUpdateListDao {
	/**
	 * 根据最新更新时间查询榜单数据
	 * @author lvdefu
	 * @date   2018年7月7日14:43:01
	 * @param  null
	 * @return ArrayList<StoreList>
	 */
	ArrayList<StoreList> queryStoreListByTs();
	/**
	 * 根据执行id查询子任务
	 * @author lvdefu
	 * @date   2018年6月12日14:11:55
	 * @param  exeid
	 * @return StoreTaskSublist
	 */
	StoreTaskSublist querySubTaskByExeid(Long exeid);
	/**
	 * 查询主任务
	 * @param taskid
	 * @return
	 */
	StoreTask queryTask(Integer taskid);
	/**
	 * 批量插入到榜单
	 * @param listNew
	 */
	void insertStoreListAll(ArrayList<StoreList> listNew);
	/**
	 * 根据执行id,查询到所有子任务
	 * @param exeid
	 * @return
	 */
	List<StoreTaskSublist> querySubTaskAllByExeid(Long exeid);
	/**
	 * 
	 * @param deptNum
	 * @param taskid
	 * @return 
	 */
	List<StoreTaskSublist> querySubTask(String deptNum, Integer taskid);
	/**
	 * 批量插入点赞
	 * @param listStLike
	 */
	void insertStoreLikeAll(ArrayList<StoreLike> listStLike);
	/**
	 * 根据营业部编号,查询点赞表
	 * @param deptnum
	 * @return
	 */
	StoreLike selectStoreLike(String deptnum);
	/**
	 * 根据营业部编号,查询最新一期榜单的排名
	 * @param deptnum
	 * @return
	 */
	String queryRanking(String deptnum);
	

}
