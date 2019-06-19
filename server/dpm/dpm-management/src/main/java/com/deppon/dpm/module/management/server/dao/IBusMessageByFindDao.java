package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusMessageEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 显示新增消息信息的dao层接口
 * @author 曹嵩
 * @date 2015.06.29
 *
 */
public interface IBusMessageByFindDao {

	/**
	 * 
	 * @return 找到所有的消息信息
	 * @throws BusinessException
	 */
	public List<BusMessageEntity> getBusMessageByFind() throws BusinessException;
}
