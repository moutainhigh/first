package com.deppon.dpm.uums.server.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.uums.server.domain.RoleEntity;
import com.deppon.dpm.uums.server.util.Constants;
import com.deppon.esb.core.exception.ESBBusinessException;
import com.deppon.esb.core.process.IProcess;
import com.deppon.esb.pojo.transformer.jaxb.SendRoleInfoRequestTrans;
import com.deppon.esb.pojo.transformer.jaxb.SendRoleInfoResponseTrans;
import com.deppon.uums.inteface.domain.usermanagement.RoleInfo;
import com.deppon.uums.inteface.domain.usermanagement.SendRoleInfoProcessReult;
import com.deppon.uums.inteface.domain.usermanagement.SendRoleInfoRequest;
import com.deppon.uums.inteface.domain.usermanagement.SendRoleInfoResponse;

/**
 * 用来从UUMS同步公司“角色信息”到FOSS数据库：无SUC
 * ClassName: JmsSyncRoleInfoProcessor <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午11:38:47 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public class JmsSyncRoleInfoProcessor implements IProcess {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JmsSyncRoleInfoProcessor.class);
	/**
	 * 国际化对象
	 */
//	private static final II18n i18n = I18nManager.getI18n(JmsSyncRoleInfoProcessor.class); 

	// 同步"角色信息"接口结果操作Service
//	private IRoleService roleService;

	// 业务锁
//	private IBusinessLockService businessLockService;

	@Override
	public Object process(Object req) throws ESBBusinessException {

		LOGGER.info(" ***************************** Begin to record data ***************************** ");

		SendRoleInfoRequest sendRoleInfoRequest = (SendRoleInfoRequest) req;
		SendRoleInfoResponse sendRoleInfoResponse = new SendRoleInfoResponse();

		LOGGER.info(new SendRoleInfoRequestTrans()
				.fromMessage(sendRoleInfoRequest));

		if (null != sendRoleInfoRequest) {
			int successCount = 0, failCount = 0;
			List<SendRoleInfoProcessReult> detailList = sendRoleInfoResponse
					.getProcessResult();
			for (RoleInfo roleInfo : sendRoleInfoRequest.getRoleInfo()) {
				// FOSS"角色信息"信息初始化
				RoleEntity roleEntity = null;
				try {
					// 业务锁
//					MutexElement mutex = new MutexElement(
//							roleInfo.getRoleEnCode(), "UUMS_ROLE_CODE",
//							MutexElementType.UUMS_ROLE_CODE);
//					LOGGER.info("开始加锁：" + mutex.getBusinessNo());
//					boolean result = businessLockService.lock(mutex,
//							NumberConstants.NUMBER_10);
//					if (result) {
//						LOGGER.info("成功加锁：" + mutex.getBusinessNo());
						roleEntity = this
								.vaidationUUMSDataObjectIntoFOSS(roleInfo);
						if (Constants.NUMERAL_S_ONE
								.equalsIgnoreCase(roleInfo.getChangeType())) {
							if (null == roleEntity) {
								roleEntity = new RoleEntity();
							}
							//sonar 整改
//							else {
//								//throw new BusinessException(i18n.get("dpms.uums.roleAlreadyExists"));
//							}
						}
						//sonar 整改
//						else {
//							if (null == roleEntity) {
//								//throw new BusinessException(i18n.get("dpms.uums.roleNotExists"));
//							}
//						}
						// 数据转换与封装
						if (StringUtils.isNotBlank(roleInfo.getRoleEnCode())) {
							roleEntity.setCode(roleInfo.getRoleEnCode().trim());
						} else {
							roleEntity.setCode(roleInfo.getRoleEnCode());
						}

						roleEntity.setName(roleInfo.getRoleName());
						roleEntity
								.setCreateUser(Constants.EXTERNAL_SYSTEM_UUMS_USER_ACCOUNT);

						//sonar 整改
						// 根据同步的动作执行对应的"新增"
//						if (Constants.NUMERAL_S_ONE
//								.equalsIgnoreCase(roleInfo.getChangeType())) {
//
//							//roleService.addRole(roleEntity);
//
//						} else if (Constants.NUMERAL_S_THREE
//								.equalsIgnoreCase(roleInfo.getChangeType())) {
//							// 根据同步的动作执行对应的"删除"
//							//roleService.deleteRole(roleEntity);
//						} else if (Constants.NUMERAL_S_TWO
//								.equalsIgnoreCase(roleInfo.getChangeType())) {
//							// 根据同步的动作执行对应的"修改"
//							//roleService.updateRole(roleEntity);
//						} else {
////							throw new BusinessException(i18n.get("dpms.uums.changeTypeUndefind"));
//						}
//						LOGGER.info("开始解锁：" + mutex.getBusinessNo());
//						// 解业务锁
//						businessLockService.unlock(mutex);
//						LOGGER.info("完成解锁：" + mutex.getBusinessNo());
//					} else {
//
//						failCount++;
//						detailList.add(this.recordSynchronizedRequestDataError(
//								roleInfo, false, "出现了高并发操作！"));
//						LOGGER.info("失败加锁：" + mutex.getBusinessNo());
//						continue;
//					}
					successCount++;
					detailList.add(this.recordSynchronizedRequestDataError(
							roleInfo, true, null));
				} catch (Exception e) {
					failCount++;
					detailList.add(this.recordSynchronizedRequestDataError(
							roleInfo, false, e.getMessage()));
					LOGGER.error(e.getMessage(), e);
					continue;
				}
			}
			sendRoleInfoResponse.setSuccessCount(successCount);
			sendRoleInfoResponse.setFailedCount(failCount);

			LOGGER.info(new SendRoleInfoResponseTrans()
					.fromMessage(sendRoleInfoResponse));
		}

		LOGGER.info(" ***************************** End to record data ***************************** ");
		return sendRoleInfoResponse;
	}

	@Override
	public Object errorHandler(Object req) throws ESBBusinessException {
		LOGGER.error("ESB处理错误");
		return null;
	}

	/**
	 * <p>
	 * 验证当前的UUMS"角色信息"信息是否已经存在FOSS中
	 * </p>
	 * 
	 * @author 100847-foss-GaoPeng
	 * @date 2012-11-21 下午6:50:00
	 * @param tractor
	 *            UUMS"角色信息"信息参数实体
	 * @return FOSS"角色信息"信息实体
	 * @see
	 */
	private RoleEntity vaidationUUMSDataObjectIntoFOSS(RoleInfo roleInfo) {
		if (null == roleInfo || StringUtils.isBlank(roleInfo.getRoleEnCode())) {
			return null;
		}
		//return roleService.queryRoleByCode(roleInfo.getRoleEnCode());
		return null;
	}

	/**
	 * <p>
	 * 对同步的UUMS对象的做成功和失败的记录
	 * </p>
	 * 
	 * @author 100847-foss-GaoPeng
	 * @date 2012-11-21 下午3:42:13
	 * @param tractor
	 *            请求的"角色信息"序列化对象
	 * @param result
	 *            0表示失败，1表示成功
	 * @param reason
	 *            失败的原因
	 * @return
	 * @see
	 */
	private SendRoleInfoProcessReult recordSynchronizedRequestDataError(
			RoleInfo roleInfo, boolean result, String reason) {
		SendRoleInfoProcessReult sendRoleInfoProcessReult = new SendRoleInfoProcessReult();
		sendRoleInfoProcessReult.setRoleId(roleInfo.getRoleId());
		sendRoleInfoProcessReult.setResult(result);
		// 判断操作是否失败，失败需要强制增加原因
		if (!result) {
			sendRoleInfoProcessReult.setReason(reason);
		}
		sendRoleInfoProcessReult.setRoleId(roleInfo.getRoleId());
		sendRoleInfoProcessReult.setRoleName(roleInfo.getRoleName());
		sendRoleInfoProcessReult.setRoleBasCode(roleInfo.getRoleBasCode());
		sendRoleInfoProcessReult.setChangeType(roleInfo.getChangeType());
		return sendRoleInfoProcessReult;
	}

	/**
	 * @param roleService
	 *            the roleService to set
	 */
//	public void setRoleService(IRoleService roleService) {
//		this.roleService = roleService;
//	}

//	public void setBusinessLockService(IBusinessLockService businessLockService) {
//		this.businessLockService = businessLockService;
//	}

}
