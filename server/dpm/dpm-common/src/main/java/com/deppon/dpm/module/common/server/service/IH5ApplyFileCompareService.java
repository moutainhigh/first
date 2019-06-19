package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.H5FileCountEntity;

public interface IH5ApplyFileCompareService {
	
	/**
	 * 保存
	 */
	public int saveCount(int applyCode,int count);
	
	/**
	 * 更新
	 */
	public int updateCount(int applyCode,int count);
	
	/**
	 * 查询
	 */
	public int getFileCount(int applyCode);

	/**
	 *查询所有数据 
	 */
	public List<H5FileCountEntity> queryList(int begin,int limit);

	/**
	 *查询总数据条数 
	 */
	public long queryCount();

	/**
	 * 新增H5资源文件信息
	 */
	public int insert(int applyCode, int count);

	/**
	 * 修改H5资源文件信息
	 */
	public int update(int applyCode, int count);

	/**
	 * 根据应用编号删除信息
	 */
	public void deleteByApplyCodes(String applyCodes);
}
