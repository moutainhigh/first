package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.ISendParcelNewsDao;
import com.deppon.dpm.module.management.shared.domain.SendParcelNewsEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @author 268101 推送消息的dao实现
 *
 */
public class SendParcelNewsDao  extends iBatis3DaoImpl implements ISendParcelNewsDao{
	static String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.sendparcelnews";
	/**
	 * @return 得到未发送的消息数据
	 * @throws Exception 抛出异常
	 */
	@Override
	public List<SendParcelNewsEntity> getNews(String userNo) throws Exception {
		//返回可消息推送的数据
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getNews",userNo);
	}
	/**
	 * @param listNews 消息list
	 * @return 是否更新成功
	 */
	@Override
	public int updateNews(String userNo) {
		//更新发送消息成功的标志位
		return this.getSqlSession().update(mapperNameSpace+".updateNews",userNo);
	}

}
