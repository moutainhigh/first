package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.SendParcelSendEntity;
/**
 * <p>寄快递持久层接口<p>
 * @author 袁中华
 * @date 2015 9.9
 */
public interface ISendParcelSendDao {
	/**<p>保存信息<p>
	 * @param sendParcelSendEntity
	 * @return 
	 */
	public int savaSendParcelSend(SendParcelSendEntity sendParcelSendEntity);
	/**
	 * <p>删除信息<p>
	 * @param i
	 * @return int
	 */
	public int deleteSendParcelSend(int i);
	/**
	 * <p>查询信息<p>
	 * @return  List<SendParcelSendEntity>
	 */
	public List<SendParcelSendEntity> selectSendParcelSend();
	/**
	 * <p>修改信息<p>
	 * @param sendParcelSendEntity
	 * @return  int
	 */
	public int updateSendParcelSend(SendParcelSendEntity sendParcelSendEntity);
}
