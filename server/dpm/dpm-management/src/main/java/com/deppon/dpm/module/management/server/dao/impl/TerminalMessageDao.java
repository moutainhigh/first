package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.ITerminalMessageDao;
import com.deppon.dpm.module.management.shared.domain.TerminalMessageEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 移动办公IT服务台终端消息推送接口
 * 移动办公IT服务台图标当有任务下发时，右上方显示任务数量
 * @author 237986
 *
 */
public class TerminalMessageDao extends iBatis3DaoImpl implements
		ITerminalMessageDao {

	/**
	 * 保存终端消息
	 * @param terminal
	 * @return
	 */
	public int saveTerminalMessage(TerminalMessageEntity terminal) {
		return this.getSqlSession().insert("com.deppon.dpm.module.management.server.dao.terminalmessage.insert",terminal);
	}
}
