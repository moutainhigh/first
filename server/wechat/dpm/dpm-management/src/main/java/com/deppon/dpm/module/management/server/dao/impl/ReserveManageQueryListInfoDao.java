package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao;
import com.deppon.dpm.module.management.shared.domain.ReserveAdminEntity;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;


/**
 * @author 274858
 *
 */
@SuppressWarnings("unchecked")
public class ReserveManageQueryListInfoDao extends iBatis3DaoImpl implements
		IReserveManageQueryListInfoDao {

	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.busmanager.ReserveManageQueryListInfoDao";

	
	/* (non-Javadoc)
	 * 空闲时间查询
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#querySiteLeisureList(com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity)
	 */
	
	@Override
	public List<ReserveRecordEntity> querySiteLeisureList(ReserveRecordEntity parBean)
			throws Exception {
		
		return this.getSqlSession().selectList(mapperNameSpace+".querySiteLeisureList",parBean);
	}


	/* (non-Javadoc)
	 * 场地信息查询
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#querySiteInfo(java.lang.String)
	 */
	@Override
	public List<ReserveRecordEntity> querySiteInfo(int siteMark)
			throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".querySiteInfo",siteMark);
	}


	/* (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#querySiteDateList(int)
	 */
	@Override
	public List<ReserveRecordEntity> querySiteDateList(ReserveRecordEntity parBean) throws Exception {
		
		return this.getSqlSession().selectList(mapperNameSpace+".querySiteDateList",parBean);
	}


	/* 
	 * 查询管理员信息
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#queryAdmin()
	 */
	@Override
	public List<ReserveAdminEntity> queryAdmin() throws Exception {
		return this.getSqlSession().selectList(mapperNameSpace+".queryAdmin");
	}


	/* 保存管理员信息
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#saveAdminInfo(com.deppon.dpm.module.management.shared.domain.ReserveAdminEntity)
	 */
	@Override
	public int saveAdminInfo(ReserveAdminEntity parBean)
			throws Exception {
		return this.getSqlSession().insert(mapperNameSpace+".saveAdminInfo", parBean);
	}


	/* 删除管理信息
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#deleteAdminInfo(int)
	 */
	@Override
	public int deleteAdminInfo(String id) throws Exception {
		return this.getSqlSession().delete(mapperNameSpace+".deleteAdminInfo", id);
	}


	/* 检验超级管理员
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#checkSuperAdmin(java.lang.String)
	 */
	@Override
	public int checkSuperAdmin(String userNo) throws Exception {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".checkSuperAdmin", userNo);
	}


	/* 查询重复管理员
	 * @see com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao#queryAdminInfo(java.lang.String)
	 */
	@Override
	public int queryAdminInfo(String userNo) throws Exception {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".queryAdminInfo", userNo);
	}

}
