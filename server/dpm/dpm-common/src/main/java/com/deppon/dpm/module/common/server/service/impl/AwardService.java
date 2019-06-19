package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.common.server.dao.IAwardDao;
import com.deppon.dpm.module.common.server.service.IAwardService;
import com.deppon.dpm.module.common.shared.domain.AwardDetailEntity;
import com.deppon.dpm.module.common.shared.domain.AwardEntity;

/**
 * 实现层
 * 
 * @date 2015-08-28
 * @author 231586
 * 
 */
public class AwardService implements IAwardService {
	/**
	 * set injection
	 */
	private IAwardDao awardDao;
	/**
	 * jdbc模板
	 */
	private JdbcTemplate template;

	/**
	 * 获取悬赏列表数据
	 */
	@Override
	public List<AwardEntity> getAwardList(int begin, int pageSize) {
		// 获取悬赏列表数据
		return awardDao.getAwardList(begin, pageSize);
	}

	/**
	 * 获取回复信息
	 */
	@Override
	public List<AwardDetailEntity> getAwardDetail(String articleID, int begin,
			int pageSize) {
		// 获取回复信息
		return awardDao.getAwardDetail(articleID, begin, pageSize);
	}

	/**
	 * 添加回复信息
	 */
	@Override
	public int insertReply(AwardDetailEntity entity) {
		// 添加回复信息
		return awardDao.insertReply(entity);
	}

	/**
	 * 阅读量的插入
	 */
	@Override
	public int insertRecord(String articleID, String userId) {
		// 阅读量的插入
		String sql = "insert into om_award_record (articleID,userId,createTime) values ('"
				+ articleID + "','" + userId + "',now())";
		// 更新
		return template.update(sql);
	}

	/**
	 * 阅读量查询
	 */
	@Override
	public int setReadingQuantityById(String articleID) {
		// 阅读量的查询
		String sql = "select count(distinct(userId)) from om_award_record where articleID = '"
				+ articleID + "'";
		// 查询
		return template.queryForInt(sql);
	}

	/**
	 * 添加悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int insertAward(AwardEntity entity) {
		// 添加悬赏内容
		return awardDao.insertAward(entity);
	}

	/**
	 * 删除悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int deleteAward(AwardEntity entity) {
		// 删除悬赏信息
		return awardDao.deleteAward(entity);
	}

	/**
	 * 根据ids删除多条悬赏
	 */
	@Override
	public int deleteAwardsByIds(String ids) {
		String[] awardIds = ids.split(",");
		return awardDao.deleteAwardsByIds(awardIds);
	}

	/**
	 * 更新悬赏内容
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int updateAward(AwardEntity entity) {
		// 更新悬赏内容
		return awardDao.updateAward(entity);
	}

	/**
	 * 获取悬赏内容信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public AwardEntity getAwardEntity(AwardEntity entity) {
		return awardDao.getAwardEntity(entity);
	}
	
	/**
	 * 查询悬赏总条数
	 */
	@Override
	public Long queryCount() {
		return awardDao.queryCount();
	}

	/**
	 * set
	 * 
	 * @param awardDao
	 */
	public void setAwardDao(IAwardDao awardDao) {
		this.awardDao = awardDao;
	}

	/**
	 * set
	 * 
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
