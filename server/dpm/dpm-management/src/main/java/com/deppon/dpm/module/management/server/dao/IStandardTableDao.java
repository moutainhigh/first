package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.StandardTableEntity;

/**
 * @author 王亚男
 * 验收明细基础信息表同步
 */
public interface IStandardTableDao {
	
	/**
	 * 批量插入基础数据信息
	 * @param list
	 */
	public void insertTable(List<StandardTableEntity> list);
	
	/**
	 * 批量修改验收明细基础信息
	 * @param list
	 */
	public int updateTable(List<StandardTableEntity> list);
	
	/**
	 * 查询验收明细基础信息是否存在
	 * @param standCode
	 * @return
	 */
	public int hasStandardCheck(String standardCode);
	
	/**
	 * 批量删除验收明细基础信息
	 * @param list
	 * @return
	 */
	public int deleteStandardInfo(List<StandardTableEntity> list);
	
	/**
	 * 查询所有明细信息
	 * @return
	 */
	public List<StandardTableEntity> getStandardAll();
	
	/**
	 * 根据区域信息查询 验收明细信息
	 * @param navCode
	 * @return
	 */
	public List<StandardTableEntity> getStandardListByNavCode(String navCode);
	
}
