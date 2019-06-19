package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao;
import com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusEvaluationAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusEvaluationManageEntity;
import com.deppon.dpm.module.management.shared.domain.BusMessageEntity;
import com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity;
import com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * <!-- 异常信息的查询、新增，评价建议的回复、删除，开线建议统计、新增 dao-->
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:xieyidong,date:2015-6-29 上午11:29:26,
 * </p>
 * 
 * @author xieyidong
 * @date 2015-6-29 上午11:29:26
 * @since
 * @version
 */
public class BusMsgAssNewsDao extends iBatis3DaoImpl implements
		IBusMsgAssNewsDao {

	static String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.busMsgAssNews";

	/**
	 * @return 查询所有的突发情况通知数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BusMessageEntity> getGustyMessage() throws BusinessException {
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getGustyMessage");

	}

	/**
	 * @param msgBean
	 *            实体类
	 * @return 标志位
	 * @throws BusinessException
	 *             抛出异常
	 */
	public int saveGustyMessage(BusMessageEntity msgBean) throws BusinessException {

		return this.getSqlSession().insert(
				mapperNameSpace + ".saveGustyMessage", msgBean);
	}

	/**
	 * <p>
	 * 查询所有的点击量
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:41:40
	 * @param hitsBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#findHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	@Override
	public List<BusOpenLineEntity> findHits(BusOpenLineEntity hitsBean)
			throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace + ".findHits",
				hitsBean);
	}

	/**
	 * <p>
	 * 保存点击量
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:42:19
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	@Override
	public int saveHits(BusOpenLineEntity msgBean) throws BusinessException {
		return this.getSqlSession().insert(mapperNameSpace + ".saveHits",
				msgBean);
	}

	/**
	 * <p>
	 * 更新点击量、时间
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:42:46
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#updateHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	@Override
	public int updateHits(BusOpenLineEntity msgBean) throws BusinessException {
		return this.getSqlSession().update(mapperNameSpace + ".updateHits",
				msgBean);

	}

	/**
	 * <p>
	 * 保存开线建议表
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 下午4:22:22
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveSite(com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity)
	 */
	@Override
	public int saveSite(BusNewsSiteEntity msgBean) throws BusinessException {
		return this.getSqlSession().update(mapperNameSpace + ".saveSite",
				msgBean);

	}

	/**
	 * <p>
	 * 获取站点ID
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 下午5:31:27
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getSiteId(com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity)
	 */
	@Override
	public List<BusNewsSiteEntity> getRepeSiteId(BusNewsSiteEntity msgBean)
			throws BusinessException {
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getRepeSiteId", msgBean);
	}

	/**
	 * <p>
	 * 获取站点ID
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 下午5:31:27
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getSiteId(com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity)
	 */
	@Override
	public List<BusNewsSiteEntity> getSiteId(BusNewsSiteEntity msgBean)
			throws BusinessException {
		return this.getSqlSession().selectList(mapperNameSpace + ".getSiteId",
				msgBean);
	}

	/**
	 * <p>
	 * 首次新增站点插入开线建议表
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-7-1 上午9:11:13
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveSiteHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	@Override
	public int saveSiteHits(BusOpenLineEntity msgBean) {
		return this.getSqlSession().insert(mapperNameSpace + ".saveSiteHits",
				msgBean);
	}

	/**
	 * <p>
	 * 获取建议表id
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-7-1 下午7:10:10
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getSiteHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	@Override
	public List<BusOpenLineEntity> getSiteHits(BusOpenLineEntity msgBean) {
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getSiteHits", msgBean);
	}

	/**
	 * <p>
	 * 保存中间表saveCentre
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-7-1 下午7:09:39
	 * @param msgBean
	 * @return
	 * @throws BusinessException
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveCentre(com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity)
	 */
	@Override
	public int saveCentre(BusCentreAdviceEntity msgBean)  {
		return this.getSqlSession().insert(mapperNameSpace + ".saveCentre",
				msgBean);
	}

	/**
	 * <p>
	 * 删除评价回复
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-7-1 下午7:05:44
	 * @param id
	 * @return
	 * @throws BusinessException
	 * @see
	 */
	@Override
	public int deleteReplyMsg(int id) throws BusinessException {
		return this.getSqlSession().delete(mapperNameSpace + ".deleteReplyMsg",
				id);
	}

	/*
	 * <p>Title: saveEvaluateManage</p> <p>Description:保存评价回复表 </p>
	 * 
	 * @param msgBean
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#
	 * saveEvaluateManage
	 * (com.deppon.dpm.module.management.shared.domain.BusEvaluationManageEntity
	 * )
	 */
	@Override
	public int saveEvaluateManage(BusEvaluationManageEntity msgBean)
			throws BusinessException {
		return this.getSqlSession().insert(
				mapperNameSpace + ".saveEvaluateManage", msgBean);
	}

	/*
	 * <p>Title: saveEvaluateAdvice</p> <p>保存建议回复表</p>
	 * 
	 * @param msgBean
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#
	 * saveEvaluateAdvice
	 * (com.deppon.dpm.module.management.shared.domain.BusEvaluationAdviceEntity
	 * )
	 */
	@Override
	public int saveEvaluateAdvice(BusEvaluationAdviceEntity msgBean)
			 {
		return this.getSqlSession().insert(
				mapperNameSpace + ".saveEvaluateAdvice", msgBean);
	}

	/*
	 * <p>Title: deleteReplySugg</p> <p>Description: 删除建议回复表</p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#deleteReplySugg
	 * (int)
	 */
	@Override
	public int deleteReplySugg(int id) throws BusinessException {
		return this.getSqlSession().delete(
				mapperNameSpace + ".deleteReplySugg", id);
	}

	/*
	 * (non-Javadoc) <p>Title: getEvaManage</p> <p>Description:返回评价id</p>
	 * 
	 * @param msgBean
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getEvaManage
	 * (
	 * com.deppon.dpm.module.management.shared.domain.BusEvaluationManageEntity)
	 */
	@Override
	public List<BusEvaluationManageEntity> getEvaManage(
			BusEvaluationManageEntity msgBean) throws BusinessException {
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getEvaManage", msgBean);
	}

	/*
	 * (non-Javadoc) <p>Title: getEvaAdvice</p> <p>Description:返回建议id</p>
	 * 
	 * @param msgBean
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getEvaAdvice
	 * (
	 * com.deppon.dpm.module.management.shared.domain.BusEvaluationAdviceEntity)
	 */
	@Override
	public List<BusEvaluationAdviceEntity> getEvaAdvice(
			BusEvaluationAdviceEntity advBean)  {

		return this.getSqlSession().selectList(
				mapperNameSpace + ".getEvaAdvice", advBean);
	}

}
