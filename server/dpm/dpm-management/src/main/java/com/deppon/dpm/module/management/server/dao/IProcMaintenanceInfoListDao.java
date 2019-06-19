package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;

/**
 * 工程维修信息详情显示dao层.
 * @author 曹嵩
 * <p>时间:2015.9.29</p>
 */
public interface IProcMaintenanceInfoListDao {

	/**
	 * 分页显示工程维修详情.
	 * @param pageNum 当前页面
	 * @param pageSize 页面显示多少条数据
	 * @param userNo 员工工号
	 * @return 工程维修信息list集合
	 */
	public List<ProcMaintainEntity> getProcMainList(int pageNum,int pageSize,String userNo);
	
	/**
	 * 获取工程维修信息共有多少条数据.
	 * @param userNo 员工工号
	 * @return 多少条数据
	 */
	public int getCount(String userNo);
	
	/**
	 * 根据单号查询工号.
	 * @param bill 单号
	 * @return 工号
	 */
	public String getUserNo(String bill);
}
