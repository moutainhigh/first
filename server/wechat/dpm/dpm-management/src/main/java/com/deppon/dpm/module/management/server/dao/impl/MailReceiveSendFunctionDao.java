package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao;
import com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @author 274858
 *  收发室接收
 */
public class MailReceiveSendFunctionDao extends iBatis3DaoImpl implements IMailReceiveSendFunctionDao{

	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(MailReceiveSendFunctionDao.class);
	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.MailReceiveSendFunctionDao";
	
	/* 更新状态为签收 (本人)
	 * (non-Javadoc)
	 * 
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageRec(com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity)
	 */
	@Override
	public int updatePackageRec(List<MailReceiveSendFunctionEntity> parList)
			throws Exception {
		return this.getSqlSession().update(mapperNameSpace+".updatePackageRec",parList);
	}

	/* 查询是本人签收还是代签
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#selectPackageRec(java.util.List)
	 */
	@Override
	public List<MailReceiveSendFunctionEntity> selectPackageRec(List<MailReceiveSendFunctionEntity> parList)
			throws Exception {
	
		return this.getSqlSession().selectList(mapperNameSpace+".selectPackageRec",parList);
	}

	/* 更新状态为签收 (非本人)
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updateUnOneself(java.util.List)
	 */
	@Override
	public int updateUnOneself(List<MailReceiveSendFunctionEntity> parList)
			throws Exception {
		return this.getSqlSession().update(mapperNameSpace+".updateUnOneself",parList);
	}

	/* 保存代签人信息
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#insertUnUser(java.util.List)
	 */
	@Override
	public int insertUnUser(List<MailReceiveSendFunctionEntity> parList)
			throws Exception {
		return this.getSqlSession().insert(mapperNameSpace+".insertUnUser",parList);
	}

	/* 包裹拒收
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageOut(java.util.List)
	 */
	@Override
	public int updatePackageOut(List<MailReceiveSendFunctionEntity> parList)
			throws Exception {
		return this.getSqlSession().update(mapperNameSpace+".updatePackageOut",parList);
	}

	/* 包裹注销
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageReject(java.util.List)
	 */
	@Override
	public int updatePackageReject(List<MailReceiveSendFunctionEntity> parList)
			throws Exception {
		return this.getSqlSession().update(mapperNameSpace+".updatePackageReject",parList);
	}

	/* 包裹催领
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageCorporal(java.util.List)
	 */
	@Override
	public int updatePackageCorporal(List<MailReceiveSendFunctionEntity> parList)
			throws Exception {
		return this.getSqlSession().update(mapperNameSpace+".updatePackageCorporal",parList);
	}

	/* (non-Javadoc)移动端包裹出库时状态更新
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageNativeRec(java.util.List)
	 */
	@Override
	public int updatePackageNativeRec(
			MailReceiveSendFunctionEntity parList) throws Exception {
		return this.getSqlSession().update(mapperNameSpace+".updatePackageNativeRec",parList);
	}
}
