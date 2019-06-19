package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusOpenLineAndNewsSiteEntity;

/**
 * 显示所有的建议站点信息Dao层接口
 * @author 曹嵩
 * @date 2015.7.1
 */
public interface IBusOpenLineAndNewsSiteDao {

	/**
	 * 显示所有的建议站点信息
	 * @return list集合
	 */
	public List<BusOpenLineAndNewsSiteEntity> querySiteAll() throws Exception;
}
