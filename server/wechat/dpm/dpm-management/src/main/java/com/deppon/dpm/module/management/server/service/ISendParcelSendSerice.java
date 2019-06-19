package com.deppon.dpm.module.management.server.service;

import com.deppon.dpm.module.management.shared.domain.SendParcelSendEntity;

/**
 * <p>寄快递业务处理接口<p>
 * @author 袁中华
 * @date 2015 9.9
 */
public interface ISendParcelSendSerice  {
	/**<p>处理寄快递业务<p>
	 * @param String stu
	 * @return  String
	 */
	public String getNeedManage(String stu) throws Exception;
	
	/**
	 * 执行查询的SQL
	 * @return
	 */
	public String selectSendParcelSend();
	/**
	 * 执行保存SQL
	 * @param sendParcelSendEntity
	 * @return
	 */
	public String savaSendParcelSend(SendParcelSendEntity sendParcelSendEntity);
	/**
	 * 执行修改SQL
	 * @param sendParcelSendEntity
	 * @return
	 */
	public String updateSendParcelSend(SendParcelSendEntity sendParcelSendEntity);
	/**
	 * 执行删除SQL
	 * @param sendParcelSendEntity
	 * @return
	 */
	public String deleteSendParcelSend(SendParcelSendEntity sendParcelSendEntity);
	/**
	 * 判断JSON的值不为空
	 * @param sendParcelSendEntity
	 * @return
	 */
	public boolean getid(SendParcelSendEntity sendParcelSendEntity);
	/**
	 * 判断JSON的值不为空
	 * @param sendParcelSendEntity
	 * @return
	 */
	public boolean getIsNotNull(SendParcelSendEntity sendParcelSendEntity);
	/**
	 * 判断执行SQL后的数量，返回值
	 * @param i
	 * @return
	 */
	public String isNum(int i);
	
}
