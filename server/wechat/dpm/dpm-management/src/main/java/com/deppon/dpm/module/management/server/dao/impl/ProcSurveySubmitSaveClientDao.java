package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao;
import com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ProcSurveySubmitSaveClientDao extends iBatis3DaoImpl implements IProcSurveySubmitSaveClientDao{

	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.busmanager.ProcSurveySubmitSaveClientDao";

	/* 保存到图片表
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao#saveNativeToPhoto(com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity)
	 */
	@Override
	public int saveNativeToPhoto(ProcSurveySubmitSaveClientEntity parBean)
			throws Exception {
		return this.getSqlSession().insert(mapperNameSpace+".saveNativeToPhoto",parBean);
	}

	/* 保存到关系表
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao#saveNativeToRelation(com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity)
	 */
	@Override
	public int saveNativeToRelation(List<ProcSurveySubmitSaveClientEntity> relaBean)
			throws Exception {
		return this.getSqlSession().insert(mapperNameSpace+".saveNativeToRelation",relaBean);
	}

	/* 更新检查任务状态
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao#updateTaskStatus(int)
	 */
	@Override
	public int updateTaskStatus(int checkId) throws Exception {
		
		return this.getSqlSession().delete(mapperNameSpace+".updateTaskStatus", checkId);
	}

	/* 校验重复保存
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao#checkNativeToPhoto(int)
	 */
	@Override
	public int checkNativeToPhoto(int checkId) throws Exception {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".checkNativeToPhoto", checkId);
	}

	/* 保存错误提交日志
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao#saveToPCLog(com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity)
	 */
	@Override
	public int saveToPCLog(ProcSurveySubmitSaveClientEntity parLog)
			throws Exception {
		return this.getSqlSession().insert(mapperNameSpace+".saveToPCLog",parLog);
	}

	/* 检验任务保存提交前保存日志
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao#saveToPCLogBefore(com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity)
	 */
	@Override
	public int saveToPCLogBefore(ProcSurveySubmitSaveClientEntity parLog)
			throws Exception {
		return this.getSqlSession().insert(mapperNameSpace+".saveToPCLogBefore",parLog);
	}

	

	
}
