package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusEvaluationAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusEvaluationManageEntity;
import com.deppon.dpm.module.management.shared.domain.BusMessageEntity;
import com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity;
import com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity;

public interface IBusMsgAssNewsDao {
	/**
	 * <!-- 异常信息的查询、新增，评价建议的回复、删除，开线建议统计、新增 dao-->
	 * <p style="display:none">modifyRecord</p>
	 * <p style="display:none">version:V1.0,author:xieyidong,date:2015-6-29 上午11:29:26,</p>
	 * @author xieyidong
	 * @date 2015-6-29 上午11:29:26
	 * @since
	 * @version
	 */
	public List<BusMessageEntity> getGustyMessage() throws Exception;
	/**
	 * @param msgBean 实体类
	 * @return 标志位
	 * @throws Exception 抛出异常
	 */
	public int saveGustyMessage(BusMessageEntity msgBean) throws Exception;
	/** 
	 * <p>查询所有的点击量</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:41:40
	 * @param hitsBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#findHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	public List<BusOpenLineEntity> findHits(BusOpenLineEntity msgBean) throws Exception;
	/** 
	 * <p>保存点击量</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:42:19
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	public int saveHits(BusOpenLineEntity msgBean) throws Exception;
	/** 
	 * <p>更新点击量、时间</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:42:46
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#updateHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	public int updateHits(BusOpenLineEntity msgBean) throws Exception;
	/** 
	 * <p>保存开线建议表</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午4:22:22
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveSite(com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity)
	 */
	public int saveSite(BusNewsSiteEntity msgBean) throws Exception;
	/** 
	 * <p>获取站点ID</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午5:31:27
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getSiteId(com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity)
	 */
	public List<BusNewsSiteEntity> getSiteId(BusNewsSiteEntity msgBean) throws Exception;
	/** 
	 * <p>首次新增站点插入开线建议表</p> 
	 * @author xieyidong
	 * @date 2015-7-1 上午9:11:13
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveSiteHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	public int saveSiteHits(BusOpenLineEntity msgBean) ;
	/** 
	 * <p>获取建议表id</p> 
	 * @author xieyidong
	 * @date 2015-7-1 下午7:10:10
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getSiteHits(com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity)
	 */
	public List<BusOpenLineEntity> getSiteHits(BusOpenLineEntity msgBean) ;	
	/** 
	 * <p>保存中间表saveCentre</p> 
	 * @author xieyidong
	 * @date 2015-7-1 下午7:09:39
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveCentre(com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity)
	 */
	public int saveCentre(BusCentreAdviceEntity msgBean) ;

	/**
	 * <p>删除评价回复</p> 
	 * @author xieyidong
	 * @date 2015-7-1 下午7:05:44
	 * @param id
	 * @return
	 * @throws Exception
	 * @see
	 */
	public int deleteReplyMsg(int msgBean) throws Exception;
	/* 
	 * <p>Title: saveEvaluateManage</p>
	 * <p>Description:保存评价回复表 </p>
	 * @param msgBean
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveEvaluateManage(com.deppon.dpm.module.management.shared.domain.BusEvaluationManageEntity)
	 */
	public int saveEvaluateManage(BusEvaluationManageEntity msgBean) throws Exception;
	/* 
	 * <p>Title: saveEvaluateAdvice</p>
	 * <p>保存建议回复表</p>
	 * @param msgBean
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#saveEvaluateAdvice(com.deppon.dpm.module.management.shared.domain.BusEvaluationAdviceEntity)
	 */
	public int saveEvaluateAdvice(BusEvaluationAdviceEntity msgBean) ;
	/* 
	 * <p>Title: deleteReplySugg</p>
	 * <p>Description: 删除建议回复表</p>
	 * @param id
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#deleteReplySugg(int)
	 */
	public int deleteReplySugg(int id) throws Exception;
	/** 
	 * <p>获取站点ID</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午5:31:27
	 * @param msgBean
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getSiteId(com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity)
	 */
	public List<BusNewsSiteEntity>  getRepeSiteId(BusNewsSiteEntity msgBean) throws Exception;
	/* (non-Javadoc)
	 * <p>Title: getEvaManage</p>
	 * <p>Description:返回评价id</p>
	 * @param msgBean
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getEvaManage(com.deppon.dpm.module.management.shared.domain.BusEvaluationManageEntity)
	 */
	public List<BusEvaluationManageEntity> getEvaManage(BusEvaluationManageEntity msgBean) throws Exception;
	/* (non-Javadoc)
	 * <p>Title: getEvaAdvice</p>
	 * <p>Description:返回建议id</p>
	 * @param msgBean
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao#getEvaAdvice(com.deppon.dpm.module.management.shared.domain.BusEvaluationAdviceEntity)
	 */
	public List<BusEvaluationAdviceEntity> getEvaAdvice(BusEvaluationAdviceEntity advBean) ;
	
}
