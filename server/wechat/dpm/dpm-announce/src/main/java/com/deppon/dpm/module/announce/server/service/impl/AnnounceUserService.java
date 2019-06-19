package com.deppon.dpm.module.announce.server.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.deppon.dpm.module.announce.server.dao.IAnnounceUserDao;
import com.deppon.dpm.module.announce.server.service.IAnnounceUserService;
import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;
import com.deppon.dpm.module.announce.shared.util.UUIDUtils;

/**
 * 
 * @ClassName: AnnounceService
 * @Description: 公告管理Service实现类
 * @author 045925/YANGBIN
 * @date 2015-3-18 下午3:32:20
 * 
 */
public class AnnounceUserService implements IAnnounceUserService {
	/**
	 * set injection
	 */
	private IAnnounceUserDao announceUserDao;

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入公告
	 * @param @param entity
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
	public int insert(AnnounceUserEntity entity) {
		// 如果oaId为空
		if (StringUtils.isEmpty(entity.getAppAnnounceId())) {
			// 返回0，及插入不成功
			return 0;
		}
		// 如果工号为空
		if (StringUtils.isEmpty(entity.getEmpCode())) {
			// 返回0，及插入不成功
			return 0;
		}
		// 如果类型为空
		if (StringUtils.isEmpty(entity.getType())) {
			// 返回0，及插入不成功
			return 0;
		}
		// 创建日期及当前日期
		Date createDate = new Date();
		// id
		entity.setId(UUIDUtils.getUUID());
		// 创建时间
		entity.setCreateTime(createDate);
		// 创建人工号
		entity.setCreateUserCode(entity.getEmpCode());
		// 存储
		return announceUserDao.insert(entity);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 删除用户公告
	 * @param @param entity
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
	public int delete(String id) {
		// 如果id为空
		if (StringUtils.isEmpty(id)) {
			// 删除失败
			return 0;
		}
		// 删除
		return announceUserDao.delete(id);
	}

	/**
	 * 
	 * @Title: queryIdByAnnounceId
	 * @Description: 根据当前手机用户，公告ID查看是否存在主键ID
	 * @param @param queryParam
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@Override
	public String queryCommonId(AnnounceUserEntity queryParam) {
		// 根据公告ID查看是否存在主键ID
		return announceUserDao.queryCommonId(queryParam);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 更新用户公告
	 * @param @param entity
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
	public int update(AnnounceUserEntity entity) {
		// 更新
		return announceUserDao.update(entity);
	}

	/**
	 * 
	 * @Title: queryCommonAll
	 * @Description: 根据当前手机用户，公告ID查看是否存在主键ID
	 * @param @param queryParam
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@Override
	public List<AnnounceUserEntity> queryCommonAll(AnnounceUserEntity queryParam) {
		// 根据ID查看是否存在主键ID
		return announceUserDao.queryCommonAll(queryParam);
	}

	/**
	 * set
	 * @param announceUserDao
	 */
	public void setAnnounceUserDao(IAnnounceUserDao announceUserDao) {
		this.announceUserDao = announceUserDao;
	}
}
