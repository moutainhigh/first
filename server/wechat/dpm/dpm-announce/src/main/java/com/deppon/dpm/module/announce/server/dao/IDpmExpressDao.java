package com.deppon.dpm.module.announce.server.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.announce.shared.domain.DpmExpress;
import com.deppon.dpm.module.announce.shared.domain.EmpDivisionEntity;

/**
 * 早安快递Dao层
 */
public interface IDpmExpressDao {

	/**
	 * 从oa同步早安快递
	 */
	public void syncFromOa(DpmExpress dpmExpress);

	/**
	 * 根据id获取早安快递
	 */
	public DpmExpress getExpressById(String userId, int id, String morningType);

	/**
	 * 获取历史数据
	 */
	public List<DpmExpress> getHistory(String userId, String morningType);

	/**
	 * 完成学习模块
	 */
	public void study(Map<String,Serializable> map);

	// public String getSyb(String userId);
	/**
	 * 根据工号获得所在事业部，如果该员工不属于事业部，怎返回默认“上海事业部”
	 */
	public DpmExpress getExpressToday(Map<String,String> map);
	/**
	 * 根据工号查询所在事业部信息
	 */
	public EmpDivisionEntity getDivisionEntity(String userId);
	/**
	 * 查询该用户所在部门的最近期的早安快递的学习进度信息，若没有，则插入默认的记录
	 */
	public void insertExpressStudy(Map<String, String> map);
	
	/**
	 * 根据用户id查询出所在的事业部名称
	 */
	public String getDivisionName(String userId);

	/**
	 * 插入员工所在事业部信息记录
	 */
	public void insetEmpDivisionInfo(EmpDivisionEntity empDivisionEntity);

	/**
	 * 更新员工事业部信息表
	 */
	public void updateEmpDivisionInfo(EmpDivisionEntity empDivisionEntity);

	/**
	 * 查询第一次学习的时间
	 */
	public Date getFirstStudyTime(Map<String, Serializable> map);
}
