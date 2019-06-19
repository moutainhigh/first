package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity;

/**
 * @author 274858
 * 收发室
 */
public interface IMailReceiveSendFunctionDao{
	
	/* 更新状态为签收 (本人)
	 * (non-Javadoc)
	 * 
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageRec(com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity)
	 */
	public int updatePackageRec(List<MailReceiveSendFunctionEntity> parList) throws Exception;
	/* 查询是本人签收还是代签
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#selectPackageRec(java.util.List)
	 */
	public List<MailReceiveSendFunctionEntity> selectPackageRec(List<MailReceiveSendFunctionEntity> parList) throws Exception;
	/* 更新状态为签收 (非本人)
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updateUnOneself(java.util.List)
	 */
	public int updateUnOneself(List<MailReceiveSendFunctionEntity> parList) throws Exception;
	/* 保存代签人信息
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#insertUnUser(java.util.List)
	 */
	public int insertUnUser(List<MailReceiveSendFunctionEntity> parList) throws Exception;

	/* 包裹拒收
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageOut(java.util.List)
	 */
	public int updatePackageOut(List<MailReceiveSendFunctionEntity> parList) throws Exception;
	/* 包裹注销
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageReject(java.util.List)
	 */
	public int updatePackageReject(List<MailReceiveSendFunctionEntity> parList) throws Exception;

	/* 包裹催领
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageCorporal(java.util.List)
	 */
	public int updatePackageCorporal(List<MailReceiveSendFunctionEntity> parList) throws Exception;
	/* (non-Javadoc)移动端包裹出库时状态更新
	 * @see com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao#updatePackageNativeRec(java.util.List)
	 */
	public int updatePackageNativeRec(MailReceiveSendFunctionEntity parList) throws Exception;
	
	
	
}
