package com.deppon.app.service;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.app.po.User;

/**
 * 用户服务.
 * 
 * @ClassName: UserService
 * @Description: TODO
 * @date 2014-3-19 下午02:01:50
 * 
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserService {

	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 保存到数据库.
	 * 
	 * @Title: save
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param user
	 * @param @return
	 * @return User
	 * @throws
	 */
	public User save(User user) {
		return (User) this.sessionFactory.getCurrentSession().merge(user);
	}

	/**
	 * 返回用户详情.
	 * 
	 * @Title: getUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param userId
	 * @param @return
	 * @return User
	 * @throws
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getUser(String userId) {
		if (userId == null) {
			return null;
		}
		return (User) this.sessionFactory.getCurrentSession().get(User.class,
				userId);
	}

}
