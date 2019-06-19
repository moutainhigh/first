package com.deppon.dpm.module.management.server.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IProcRecordDao;
import com.deppon.dpm.module.management.shared.domain.ProcCheckPCEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckTaskEntity;
import com.deppon.dpm.module.management.shared.domain.TaskCheckEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ProcRecordDao extends iBatis3DaoImpl implements IProcRecordDao {

	private String mapperNameSpace="com.deppon.dpm.module.management.server.dao.procCheckRecord";
	
	/**
	 * 分页查询task数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProcCheckTaskEntity> getTaskList(int pageNum, int pageSize,String deptName,String userId) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("pageStart", pageNum*pageSize);
		params.put("pageSize", pageSize);
		params.put("deptName", deptName);
		params.put("userNo", userId);
		return this.getSqlSession().selectList(mapperNameSpace+".getList",params) ;
	}

	/**
	 * 推送任务总数
	 * @return
	 */
	@Override
	public int getCount(String deptName,String userId) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userNo", userId);
		params.put("deptName", deptName);
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".getCount",params);
	}
	
	/**
	 * 根据项目编码获得扣分详细
	 * @param number 项目编码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProcCheckPCEntity> getProcCheckList(String number) {
		return this.getSqlSession().selectList(mapperNameSpace+".getTaskScoreList",number);
	}

	/**
	 * 获得初次更新时间
	 * @param number 项目编码
	 * @return
	 */
	@Override
	public Date getFirstUpdateTime(String number) {
		return (Date) this.getSqlSession().selectOne(mapperNameSpace+".getFirstDate",number);
	}

	/**
	 * 获得最终更新时间
	 * @param number 项目编码
	 * @return
	 */
	@Override
	public Date getLastUpdateTime(String number) {
		return (Date)this.getSqlSession().selectOne(mapperNameSpace+".getLastDate",number);
	}

	/**
	 * 获得每次提交的总分
	 * @param submitNub 1--初次提交,2--最终提交
	 * @return 总分
	 */
	@Override
	public int getScoreFirstOrLast(int submitNub,String number) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("submitNub", submitNub);
		map.put("number", number);
		Object reulst = this.getSqlSession().selectOne(mapperNameSpace+".getScoreSum",map);
		return (Integer)reulst;
	}

	/**
	 * 查询任务是否存在
	 * @param deptCode 项目编号
	 * @return true 存在; false 不存在
	 */
	@Override
	public int hasTask(String deptCode) {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".hasThisTask",deptCode);
	}

	/**
	 * 添加任务信息
	 * @param entity
	 */
	@Override
	public int addTask(TaskCheckEntity entity) {
		this.getSqlSession().insert(mapperNameSpace+".insertTask",entity);
		return 0;
	}

	/**
	 * 最终提交修改时间
	 * @param date 修改时间
	 */
	@Override
	public void updateLastTime(Date date,String number) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("date", date);
		params.put("deptCode", number);
		this.getSqlSession().update(mapperNameSpace+".updateLastTime",params);
	}

	/**
	 * 查询项目编号是否已经提交给PC端
	 * @param number 项目编号
	 * @return
	 */
	@Override
	public int getTaskStatus(String number) {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".getTaskStatus", number);
	}

	/**
	 * 修改历史记录最终提交状态
	 * @param number 项目编号
	 * @return
	 */
	@Override
	public boolean updateRecordStatus(String number) {
		 this.getSqlSession().selectOne(mapperNameSpace+".updateRecordStatus",number);
		return true;
	}

}
