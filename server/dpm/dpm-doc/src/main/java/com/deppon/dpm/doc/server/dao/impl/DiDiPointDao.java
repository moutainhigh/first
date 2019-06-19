package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IDiDiPointDao;
import com.deppon.dpm.doc.server.vo.DiDiPointVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class DiDiPointDao extends iBatis3DaoImpl implements IDiDiPointDao {
	
	private static final String NAME_SPACE = "com.deppon.dpm.doc.server.dao.DiDiPointDao.";

	/*
	 * 查询提示
	 */
	@Override
	public DiDiPointVo getPoint(){
		
		return (DiDiPointVo) getSqlSession().selectOne( NAME_SPACE + "getpoint");
	}
	
	/*
	 * 查询已添加的提示
	 */
	public List<DiDiPointVo> getAllPoint(int start,int pageSize){
		
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
	public int insertPoint(DiDiPointVo pointVo){
		
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
