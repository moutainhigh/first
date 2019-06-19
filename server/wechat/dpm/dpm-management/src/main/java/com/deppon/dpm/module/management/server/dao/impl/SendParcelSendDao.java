package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.ISendParcelSendDao;
import com.deppon.dpm.module.management.shared.domain.SendParcelSendEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class SendParcelSendDao extends iBatis3DaoImpl implements ISendParcelSendDao {
	private  String mappernamespace="com.deppon.dpm.module.management.server.dao.sendParcelSendDao.";
	/**<p>保存信息<p>
	 * @param sendParcelSendEntity
	 * @return 
	 */
	public int savaSendParcelSend(SendParcelSendEntity sendParcelSendEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+"savaSendParcelSend", sendParcelSendEntity) ;
	}
	/**
	 * <p>删除信息<p>
	 * @param i
	 * @return int
	 */
	public int deleteSendParcelSend(int i) {
		// TODO Auto-generated method stub
		return this.getSqlSession().delete(mappernamespace+"deleteSendParcelSend", i);
	}

	/**
	 * <p>查询信息<p>
	 * @return  List<SendParcelSendEntity>
	 */
	public List<SendParcelSendEntity> selectSendParcelSend() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(mappernamespace+"getSendParcelSend");
	}
	/**
	 * <p>修改信息<p>
	 * @param sendParcelSendEntity
	 * @return  int
	 */
	public int updateSendParcelSend(SendParcelSendEntity sendParcelSendEntity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mappernamespace+"updateSendParcelSend", sendParcelSendEntity);
	}

}
