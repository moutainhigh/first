package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IProcSurveyDetailsDao;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyMsg;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyPhoto;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101
 * 工程勘测详情dao接口实现
 *
 */
public class ProcSurveyDetailsDao  extends iBatis3DaoImpl implements IProcSurveyDetailsDao {
	static String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.procsureydetail";
	/**
	 * @param partCode
	 *            勘测项目code
	 * @return 勘测详情
	 */
	public List<ProcSurveyMsg> getProcDeatils(String partCode) {
		if (!StringUtil.isEmpty(partCode)) { 
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getProcDeatils", partCode);
		}
		return null;
		
	}
	
	/**
	 * @return 求详情总数
	 */
	public int countDetail() {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace + ".countDetail");
		
	}
	
	/**
	 * @param partCode 勘测项目code
	 * @param checkId 勘测项id
	 * @return list
	 */
	public List<String> getListId(String partCode, String checkId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("partCode", partCode);
		mapObj.put("checkId", checkId);
		
		return this.getSqlSession().selectList(mapperNameSpace + ".getListId", mapObj);
		
	}
	/**
	 * @param partCode 勘测项目code
	 * @return list
	 */
	public List<ProcSurveyMsg> lineIdList(String partCode, String proCode) {
		if (!StringUtil.isEmpty(partCode)) { 
			Map<String, Object> mapObj = new HashMap<String, Object>();
			mapObj.put("partCode", partCode);
			mapObj.put("proCode", proCode);
			
			return this.getSqlSession().selectList(
					mapperNameSpace + ".lineIdList", mapObj);
		}
		return null;
		
	}
	

	/**
	 * @param checkId 已勘测的检查id
	 * @return 详细数据
	 */
	public List<ProcSurveyPhoto> getPhotoDetail(String checkId) {
		if (!StringUtil.isEmpty(checkId)) { 
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getPhotoDetail", checkId);
		}
		return null;
		
	}

}
