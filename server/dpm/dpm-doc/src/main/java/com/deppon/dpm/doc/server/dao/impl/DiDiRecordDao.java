package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IDiDiRecordDao;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @author Administrator
 *
 */
public class DiDiRecordDao extends iBatis3DaoImpl  implements IDiDiRecordDao{

	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiRecordDAO";
	
	@Override
	public int insert(DiDiRecordVO didirecordvo) {
		return this.getSqlSession().insert(NAME_SPACE+".insertDidiRecord", didirecordvo);
	}

	@Override
	public int update(int id , String recordstate , String comment) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("id", String.valueOf(id));
    	map.put("recordstate", recordstate);
    	map.put("comment", comment);
		return this.getSqlSession().update(NAME_SPACE+".updateDidiRecord", map);
	}

}
