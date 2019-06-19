package com.deppon.dpm.store.server.dao;

import java.util.List;

import com.deppon.dpm.store.server.entity.QueryModInfo;
import com.deppon.dpm.store.server.entity.StoreMark;
/**
 * 
 * @author XiaoTian
 *
 */
public interface IStoreMarkDao {
  
	/**
	 * 
	 * 批量插入模块打分模块
	 * @param record
	 * @return
	 */
    int insertSelective(List<StoreMark> record);
    /**
     * 循环查询所有模块是否打分
     */
    int selectList(List<StoreMark> record);
    /**
     * 循环更新
     * @param record
     * @return
     */
    int updateSelective(List<StoreMark> record);
    /**
     * 查询一级模块分数
     */
    List<QueryModInfo> selectFirstmod();
    
}