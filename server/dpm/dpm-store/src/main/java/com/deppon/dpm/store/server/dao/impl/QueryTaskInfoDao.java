package com.deppon.dpm.store.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.store.server.dao.IQueryTaskInfoDao;
import com.deppon.dpm.store.server.entity.QueryAppraisal;
import com.deppon.dpm.store.server.entity.QueryModInfo;
import com.deppon.dpm.store.server.entity.QueryTaskInfo;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * @date 2018年6月4日19:22:53
 * @author RY
 *
 */
public class QueryTaskInfoDao extends iBatis3DaoImpl implements
		IQueryTaskInfoDao {
	//定义name_spase
	private static final String NAME_SPACE = "com.deppon.dpm.store.server.dao.IQueryTaskInfoDao.";

	/**
	 * 根据执行id 查询考评结果相关信息
	 */
	@Override
	public QueryTaskInfo queryAppraisalByExeid(Long exeid) {
		// 根据执行id 查询考评结果相关信息
		return (QueryTaskInfo) this.getSqlSession().selectOne(
				NAME_SPACE + "queryAppraisalByExeid", exeid);
	}

	/**
	 * 根据执行id 查询考评详情
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QueryAppraisal> queryAppraisal(Long exeid) {
		// 根据执行id 查询考评详情
		List<QueryAppraisal> list = this.getSqlSession().selectList(
				NAME_SPACE + "queryAppraisal", exeid);
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
	 * 添加反馈
	 */
	@Override
	public int insertFeedback(Long exeid, String feedbackinfo, String picpath) {
		// 将传值封装成map
		Map<String, Object> map = new HashMap<String, Object>();
		// 存储数据
		map.put("exeid", exeid);
		// 存储数据
		map.put("feedbackinfo", feedbackinfo);
		// 如果图片不为空则存储
		if (picpath != null) {
			// 存储数据
			map.put("picpath", picpath);
		}
		// 返回
		return (int) this.getSqlSession().insert(NAME_SPACE + "insertFeedback",
				map);
	}

	/**
	 * 查询反馈
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<QueryAppraisal> queryFeedback(Long exeid) {
		// 根据执行id 查询考评详情
		List<QueryAppraisal> list = this.getSqlSession().selectList(
				NAME_SPACE + "queryFeedback", exeid);
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
	 * 添加反馈后 修改任务子表状态为已完成，提交时间为当前时间
	 */
	@Override
	public Integer updatesublist(Long exeid,String submittime) {
		// 将传值封装成map
				Map<String, Object> map = new HashMap<String, Object>();
				// 存储数据
				map.put("exeid", exeid);
				// 存储数据
				map.put("submittime", submittime);
				//调用方法
		this.getSqlSession().update(NAME_SPACE + "updatesublist", map);
		//返回0
		return 0;
	}

	/**
	 * 根据执行id查询所有主任务下的所有子任务的任务状态和主任务id
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<StoreTaskSublist> queryAllTaskStatusByexeid(Long exeid) {
		List<StoreTaskSublist> list = this.getSqlSession().selectList(
				NAME_SPACE + "queryAllTaskStatusByexeid", exeid);
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
	 * 当子任务都已反馈，根据主任务id来修改主任务状态为已完成，完成时间为当前时间
	 */
	@Override
	public Integer updatetask(Integer taskid, String finishtime) {
		// 将传值封装成map
		Map<String, Object> map = new HashMap<String, Object>();
		// 存储数据
		map.put("taskid", taskid);
		// 存储数据
		map.put("finishtime", finishtime);
		//调用方法
		this.getSqlSession().update(NAME_SPACE + "updatetask", map);
		//返回0
		return 0;
	}
	/**
	 * 添加模块分类表
	 */
	@Override
	public Integer insertsecondmod(String firstmodid, String secondmodname,
			String secondremarks) {
		// 将传值封装成map
		Map<String, String> map = new HashMap<String, String>();
		// 存储数据
		map.put("firstmodid",firstmodid);
		// 存储数据
		map.put("secondmodname", secondmodname);
		//存储数据
		map.put("secondremarks", secondremarks);
		//调用方法
		this.getSqlSession().update(NAME_SPACE + "insertsecondmod", map);
		//返回0
		return 0;
	}
	/**
	 * 添加模块 
	 */
	@Override
	public Integer insertfirstmod(String firstmodid, String firstmodname,
			String firstremarks) {
		// 将传值封装成map
		Map<String, String> map = new HashMap<String, String>();
		// 存储数据
		map.put("firstmodid",firstmodid);
		// 存储数据
		map.put("firstmodname", firstmodname);
		//存储数据
		map.put("firstremarks", firstremarks);
		//调用方法
		this.getSqlSession().update(NAME_SPACE + "insertfirstmod", map);
		//返回0
		return 0;
	}
	/**
	 * 查询所有模块信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QueryModInfo> queryAllModInfo() {
		// 查询所有模块信息
		return this.getSqlSession().selectList(NAME_SPACE + "queryAllModInfo");
	}
	/**
	 * 查询模块表的一级模块名称
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QueryModInfo> queryfirstmodname() {
		// 查询模块表的一级模块名称
		return this.getSqlSession().selectList(NAME_SPACE + "queryfirstmodname");
	}
	/**
	 * 根据执行id查询营业部负责人工号
	 */
	@Override
	public String querydeptapidByExeid(Long exeid) {
		// 根据执行id查询营业部负责人工号
		return (String) this.getSqlSession().selectOne(NAME_SPACE + "querydeptapidByExeid",exeid);
	}
	/**
	 * 根据传递查询条件(我创建已完成未完成我执行)查询任务信息  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QueryTaskInfo> selcetTaskByQueryCondition(Map<String, Object> map) {
		return this.getSqlSession().selectList(NAME_SPACE + "selcetTaskByQueryCondition",map);
	}
}
