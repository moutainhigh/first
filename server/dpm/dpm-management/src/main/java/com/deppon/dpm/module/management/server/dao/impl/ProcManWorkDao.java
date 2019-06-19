package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;

import com.deppon.dpm.module.management.server.dao.IProcManWorkDao;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**   
* @Description: 校验是否重复、查询申请单详情等
* @author 268087 张广波
* @date 2015-11-16 下午1:59:56 
* @version V1.0 
*/
public class ProcManWorkDao extends iBatis3DaoImpl implements IProcManWorkDao {
	String namespace = "com.deppon.dpm.module.management.server.dao.manWorkSet";
	/** 校验是否重复
	 * @param userNo
	 * @return
	 * @see com.deppon.dpm.module.management.server.dao.IProcManWorkDao#checkIsRepMan(java.lang.String)
	 */
	public int checkIsRepMan(String userNo) {		
		return (Integer)getSqlSession().selectOne(namespace+".checkIsRepMan", userNo);
	}
	
	/** 查询申请单详情
	 * @param pid
	 * @return
	 * @see com.deppon.dpm.module.management.server.dao.IProcManWorkDao#queryForList(java.lang.String)
	 */
	public ProcMaintainEntity queryForList(String pid) {
		return (ProcMaintainEntity)getSqlSession().selectOne(namespace+".queryForList", pid);
	}
	/** 保存申请单信息
	 * @param maintainEntity
	 * @return
	 * @see com.deppon.dpm.module.management.server.dao.IProcManWorkDao#saveProcMan(com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity)
	 */
	public int saveProcMan(ProcMaintainEntity maintainEntity) {		
		return getSqlSession().insert(namespace+".saveProcMan", maintainEntity);
	}
	/** 更新申请单详情
	 * @param maintainEntity
	 * @return
	 * @see com.deppon.dpm.module.management.server.dao.IProcManWorkDao#updateProcMan(com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity)
	 */
	public int updateProcMan(ProcMaintainEntity maintainEntity) {
		return getSqlSession().update(namespace+".updateProcMan", maintainEntity);
	}
	
	

	/**工程勘测-更新勘测单状态
	 * @param paramHashMap
	 * @return
	 * @see com.deppon.dpm.module.management.server.dao.IProcManWorkDao#updateSurveyState(java.util.HashMap)
	 */
	public int updateSurveyState(HashMap<String, String> paramHashMap) {
		return (Integer)getSqlSession().update(namespace+".updateSurveyState", paramHashMap);
	}
}
