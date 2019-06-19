package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IProcSurveyCheckDao;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyCheck;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * dao
 * @author 293888
 *
 */
public class ProcSurveyCheckDao extends iBatis3DaoImpl implements
		IProcSurveyCheckDao {

	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.procSurveyCheckDao";
	
	/* 
	 * 保存工程信息
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveyCheckDao#saveprocSurvey(com.deppon.dpm.module.management.shared.domain.ProcSurveyCheck)
	 */
	@Override
	public int saveprocSurvey(ProcSurveyCheck check) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mapperNameSpace+".saveprocSurvey", check);
	}

	/* 保存工程信息
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveyCheckDao#getCountByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProcSurveyCheck> getCountByCode(String checkName,
			String checkCode) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("checkName", checkName);
		map.put("checkCode", checkCode);
		return this.getSqlSession().selectList(mapperNameSpace+".getCountByCode", map);
	}

	/* 根据id更新数据失效
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveyCheckDao#updSurveyMark(int)
	 */
	@Override
	public int updSurveyMark(int id) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mapperNameSpace+".updSurveyMark", id);
	}

	/* 根据工号查出对应的信息
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveyCheckDao#getProjectList(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProcSurveyCheck> getProjectList(String userNo, String keyWord)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userNo", userNo);
		return this.getSqlSession().selectList(mapperNameSpace+".getProjectList", map);
	}

}
