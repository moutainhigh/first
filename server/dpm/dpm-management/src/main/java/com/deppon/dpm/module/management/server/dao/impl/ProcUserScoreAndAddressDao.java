package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IProcUserScoreAndAddressDao;
import com.deppon.dpm.module.management.shared.domain.ProcUserScoreAndAddressEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 提交显示所有0分项dao层实现接口
 * @author 曹嵩
 * @date 2015.7.30
 */
@SuppressWarnings("unchecked")
public class ProcUserScoreAndAddressDao extends iBatis3DaoImpl implements
		IProcUserScoreAndAddressDao {
	
	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.procScoreMessage";

	/**
	 * 得到功能栏代码值
	 * @param pusaae
	 * @return 功能代码值
	 * @throws BusinessException
	 */
	@Override
	public List<ProcUserScoreAndAddressEntity> getProType(
			ProcUserScoreAndAddressEntity pusaae) throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace+".getProType", pusaae);
	}
	/**
	 * 得到所有的0分项信息
	 * @param pusaae
	 * @return 所有0分项信息
	 * @throws BusinessException
	 */
	@Override
	public List<ProcUserScoreAndAddressEntity> getProcUserScoreAndAddress(
			ProcUserScoreAndAddressEntity pusaae) throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace+".getProcUserScoreAndAddress",pusaae);
	}
	/**
	 * 得到检查的门店总数
	 * @param pusaae
	 * @return 检查门店总数
	 * @throws BusinessException
	 */
	@Override
	public int getCountStore() throws BusinessException {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".getCountStore");
	}
	/**
	 * 得到这一项门店不合格总数
	 * @param pusaae
	 * @return 门店不合格总数
	 * @throws BusinessException
	 */
	@Override
	public int getCountScopeId(
			ProcUserScoreAndAddressEntity pusaae) throws BusinessException {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".getCountScopeId", pusaae);
	}

}
