package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.ProcScoreMessageEntity;
/**
 * 根据id查找评分详细的dao层接口
 * @author 曹嵩
 * @date 2015.7.17
 */
public interface IProcScoreMessageDao {
	
	/**
	 * 根据id查找评分详细信息
	 * @param id 页面传过来的id
	 * @return 评分详细信息
	 */
	public ProcScoreMessageEntity queryProcScoreMessById(String id) throws Exception;
}
