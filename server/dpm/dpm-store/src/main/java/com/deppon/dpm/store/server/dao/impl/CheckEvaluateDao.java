package com.deppon.dpm.store.server.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.store.server.dao.ICheckEvaluateDao;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class CheckEvaluateDao extends iBatis3DaoImpl implements ICheckEvaluateDao{

	//主任务mapper名称空间
	private static final String NAME_SPACE_ONE = "com.deppon.dpm.store.server.dao.IStoreTaskDao.";
	
	//子任务mapper名称空间
	private static final String NAME_SPACE_TWO = "com.deppon.dpm.store.server.dao.IStoreTaskSublistDao.";
	
	/**
	 * 根据主任务ID查询主任务
	 * @author lvdefu
	 * @date   2018年6月4日19:34:22
	 * @param  taskid
	 * @return StoreTask
	 */
	@Override
	public StoreTask queryTaskByTaskid(Integer taskid) {
		return  (StoreTask) getSqlSession().selectOne(NAME_SPACE_ONE+"queryTaskByTaskid", taskid);
	}
	/**
	 * 据营业部ID数组查询子任务
	 * @@author lvdefu
	 * @date    2018年6月6日14:34:43
	 * @param   listBusiness
	 * @return  List<StoreTaskSublist>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreTaskSublist> querySubTasksByArray(ArrayList<String> listBusiness,String userId,String deptName) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("listBusiness", listBusiness);
		map.put("userId", userId);
		map.put("deptName", deptName);
		List<StoreTaskSublist> list = getSqlSession().selectList(NAME_SPACE_TWO+"querySubTasksByArray", map);
		
		if(list!=null && list.size()!=0){
			return list;
		 }else{
			return null;
		 }
	}

}
