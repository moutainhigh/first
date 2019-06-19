package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IProcMaintainStaticUpdateServieceDao;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @author 274858
 *
 * 工程维修退回、已审核DAO
 */
public class ProcMaintainStaticUpdateServieceDao extends iBatis3DaoImpl implements IProcMaintainStaticUpdateServieceDao{

	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.ProcMaintainStaticUpdateServieceDao";
	
	/* 状态更新方法
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcMaintainStaticUpdateServieceDao#updateStatus(com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity)
	 */
	@Override
	public int updateStatus(ProcMaintainEntity parBean) throws Exception{
		return this.getSqlSession().update(mapperNameSpace+".updateStatus",parBean);
	}

	/* 
	 * 工程管理和验收 权限控制
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcMaintainStaticUpdateServieceDao#managerCheck(java.lang.String)
	 */
	@Override
	public int managerCheck(String userNo) throws Exception {
	
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".managerCheck",userNo);
	}

	/* 工程维修 权限控制
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcMaintainStaticUpdateServieceDao#maintainRight(java.lang.String)
	 */
	@Override
	public int maintainRight(String userNo) throws Exception {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".maintainRight",userNo);
	}

}
