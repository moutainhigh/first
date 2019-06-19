package com.deppon.dpm.module.main.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IDiDiPointDao;
import com.deppon.dpm.doc.server.vo.DiDiPointVo;
import com.deppon.dpm.module.main.server.dao.IMessagePointDao;
import com.deppon.dpm.module.main.shared.domain.MessagePointVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;


@SuppressWarnings("all")
public class MessagePointDao extends iBatis3DaoImpl implements IMessagePointDao {
	
	private static final String NAME_SPACE = "com.deppon.dpm.module.main.server.dao.messagePoint.";

	/*
	 * 查询提示
	 */
	@Override
	public MessagePointVo getPoint(String appId){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("joblevel", appId);
		MessagePointVo message = (MessagePointVo)getSqlSession().selectOne(NAME_SPACE + "getpoint",map);
		return message;
	}
	
	/*
	 * 查询已添加的提示
	 */
	public List<MessagePointVo> getAllPoint(int start,int pageSize){
		
		// 参数拼接
		
		Map map = new HashMap();
		// 起始条数
		map.put("start", start);
		// 返回大小
		map.put("pageSize", pageSize);
		
		return getSqlSession().selectList(NAME_SPACE + "getAllpoint", map);
	}
	
	/*
     * 添加提示
     */
	public int insertPoint(MessagePointVo pointVo){
		
		return getSqlSession().insert(NAME_SPACE + "insertPoint", pointVo);
	}
	
	/*
	 * 查询条数
	 */
	public int getCount(){
		
		return (Integer) getSqlSession().selectOne(NAME_SPACE + "getCount");
	}
	
	/*
	 * 更新状态
	 */
	public int updateState(int pointId){
		
		return (Integer) getSqlSession().update(NAME_SPACE + "updateState", pointId);
	}

}
