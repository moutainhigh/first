package com.deppon.dpm.store.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.store.server.dao.IStoreTaskDao;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class StoreTaskDao extends iBatis3DaoImpl implements IStoreTaskDao {

	private static final String NAME_SPACE = "com.deppon.dpm.store.server.dao.IStoreTaskDao.";

	/**
	 * @author XiaoTian
	 */
	@Override
	public StoreTask insertSelective(StoreTask record) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(NAME_SPACE + "insertSelective", record);
		return record;
	}

	
	// 根据任务id查询提交时间
	@Override
	public List<String> selectsublistvdef1(Integer taskid) {
		// 将查询出来的值赋给list
		@SuppressWarnings("unchecked")
		List<String> list = getSqlSession().selectList(NAME_SPACE + "selectsublistvdef1", taskid);
		// 非空判断
		if (list.size() != 0 && list != null) {
			// 如果不为空则返回list
			return list;
		} else {
			// 否则返回空
			return null;
		}
	}

	/**
	 * 按id查询创建人的员工号
	 * @author XiaoTian
	 * @param taskid
	 * @return
	 */
	@Override
	public StoreTask finecreatorcode(Integer taskid) {
		// TODO Auto-generated method stub
		return (StoreTask) this.getSqlSession().selectOne(NAME_SPACE + "finecreatorcode", taskid);
	}

	// 根据任务id查询任务子表中 总条数 ，已完成任务数量
	@Override
	public StoreTask selectsublistinfo(Integer taskid) {
		// 将查询出来的值赋给storeTask
		StoreTask storeTask = (StoreTask) getSqlSession().selectOne(NAME_SPACE + "selectsublistinfo", taskid);
		if (storeTask != null) {
			return storeTask;
		} else {
			return null;
		}
	}

	/**
	 * @author XiaoTian
	 */
	//修改主任务
	@Override
	public int taskUpdate(StoreTask storeTask) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(NAME_SPACE + "taskUpdate", storeTask);
	}
	
	/**
	 * @author XiaoTian
	 */
	//查询子任务是否进行考评
	@Override
	public int SublistCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlSession().selectOne(NAME_SPACE + "SublistCount", map);
	}
	
	/**
	 * @author XiaoTian
	 */
	@Override
	public List<String> SelectExeid(Integer taskid) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAME_SPACE + "SelectExeid", taskid);
	}

	/**
	 * @author XiaoTian
	 */
	@Override
	public int DeteleSublist(Integer taskid) {
		// TODO Auto-generated method stub
		return this.getSqlSession().delete(NAME_SPACE + "DeteleSublist", taskid);
	}

	/**
	 * @author XiaoTian
	 */
	@Override
	public int DeteleMark(List<String> list) {
		// TODO Auto-generated method stub
		return this.getSqlSession().delete(NAME_SPACE + "DeteleMark", list);
	}

	/**
	 *  @author XiaoTian
	 */
	@Override
	public int taskExist(Integer taskid) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlSession().selectOne(NAME_SPACE + "taskExist", taskid);
	}
}
