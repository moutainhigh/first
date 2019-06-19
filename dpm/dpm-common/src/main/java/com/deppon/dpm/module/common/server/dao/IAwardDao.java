package com.deppon.dpm.module.common.server.dao;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.AwardDetailEntity;
import com.deppon.dpm.module.common.shared.domain.AwardEntity;

/**
 * dao层
 * 
 * @date 2015-08-28
 * @author 231586
 * 
 */
public interface IAwardDao {
	/**
	 * 获取列表信息
	 * 
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<AwardEntity> getAwardList(int begin, int pageSize);

	/**
	 * 添加回复消息
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
	 * 插入悬赏内容
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
	 * 批量删除悬赏
	 * @param ids
	 * @return
	 */
	public int deleteAwardsByIds(String[] ids);

	public Long queryCount();
}
