package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IProcScoreMessageDao;
import com.deppon.dpm.module.management.shared.domain.ProcScoreMessageEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 根据id查找评分详细的dao层实现接口
 * @author 曹嵩
 * @date 2015.7.17
 * 
 */
public class ProcScoreMessageDao extends iBatis3DaoImpl implements
		IProcScoreMessageDao {
	
	String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.procScoreMessage";
	/**
	 * 根据id查找评分详细信息
	 * @param id 页面传过来的id
	 * @return 评分详细信息
	 */
	@Override
	public ProcScoreMessageEntity queryProcScoreMessById(String id)
			throws BusinessException {
		return (ProcScoreMessageEntity) this.getSqlSession().selectOne(mapperNameSpace+".getProcScoreMessage",id);
	}

}
