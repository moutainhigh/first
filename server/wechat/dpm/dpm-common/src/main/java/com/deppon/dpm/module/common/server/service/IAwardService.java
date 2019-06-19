package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.AwardDetailEntity;
import com.deppon.dpm.module.common.shared.domain.AwardEntity;
import com.deppon.foss.framework.service.IService;

/**
 * 悬赏service层
 * 
 * @date 2015-08-28
 * @author 231586
 * 
 */
public interface IAwardService extends IService  {
	/**
	 * 获取悬赏列表数据
	 * 
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<AwardEntity> getAwardList(int begin, int pageSize);

	/**
	 * 添加回复信息
	 * 
	 * @param entity
	 * @return
	 */
	public int insertReply(AwardDetailEntity entity);

	/**
	 * 获取回复信息
	 * 
	 * @param articleID
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<AwardDetailEntity> getAwardDetail(String articleID, int begin,
			int pageSize);

	/**
	 * 阅读量的插入
	 * 
	 * @param articleID
	 * @param userId
	 * @return
	 */
	public int insertRecord(String articleID, String userId);

	/**
	 * 阅读量查询
	 * 
	 * @param articleID
	 * @return
	 */
	public int setReadingQuantityById(String articleID);

	/**
	 * 添加悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	public int insertAward(AwardEntity entity);

	/**
	 * 删除悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	public int deleteAward(AwardEntity entity);

	/**
	 * 更新悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	public int updateAward(AwardEntity entity);

	/**
	 * 获取悬赏内容信息
	 * 
	 * @param entity
	 * @return
	 */
	public AwardEntity getAwardEntity(AwardEntity entity);

	/**
	 * 删除多条悬赏
	 * @param ids
	 */
	public int deleteAwardsByIds(String ids);

	/**
	 * 查询悬赏总条数
	 * @return
	 */
	public Long queryCount();

}
