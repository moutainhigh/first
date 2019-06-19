package com.deppon.dpm.module.common.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.WelcomePageEntity;

/**
 * 配置页dao层
 * 
 * @date 2015-08-24
 * @author 231586
 * 
 */
public interface IEditWelcomePageDao {
	/**
	 * 保存配置信息，便于展示
	 * 
	 * @param pageEntity
	 * @return
	 */
	public int savePic(WelcomePageEntity pageEntity);

	/**
	 * 获取详细信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<WelcomePageEntity> getDetails(String userId);
	
	/**
	 * 获取欢迎页列表
	 * @param userId
	 * @param begin
	 * @param rows
	 * @return
	 */
	public List<WelcomePageEntity> getWelcomePageList(int begin,
			int rows);

	/**
	 * 查询数据总条数
	 * @param userId
	 * @return
	 */
	public Long queryCount();

	/**
	 * 根据ids查询出配置页信息
	 * @param map
	 * @return
	 */
	public List<String> selectWelcomePages(Map<String, String[]> map);

	/**
	 * 根据ids删除配置页信息
	 * @param map
	 * @return
	 */
	public int delWelcomePages(Map<String, String[]> map);
}
