package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.jpush.api.utils.StringUtils;

import com.deppon.dpm.tongxunlu.server.dao.IMyFavoritesDao;
import com.deppon.dpm.tongxunlu.server.service.IMyFavoritesService;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * service实现
 * 
 * @author 231586
 * 
 */
public class MyFavoritesService implements IMyFavoritesService {
	// jdbcTemplate
	private JdbcTemplate template;
	// set injection
	private IMyFavoritesDao myFavoritesDao;
	// set injection
	private ITongxunLuService tongxunLuService;


	@Override
	public int collectOne(Map<String, String> map) {
		// 先查询存在多少个常用联系人
		String count = "select count(*) from om_myFavorites where empCode = '" + map.get("userId") + "'";
		StringBuilder sb = new StringBuilder();
		// 获取常用联系人
		String myFavorites = myFavoritesDao.getFavorites(map.get("userId"));
		// 获取收藏的人
		String collectEmpCode = map.get("collectEmpCode");
		// 如果常用联系人人数大于0
		if (template.queryForInt(count) > 0) {
			// 获取到的常用联系人不为空
			if (null != myFavorites && myFavorites.length() > 0) {
				// 分隔成一个个工号
				String[] splits = myFavorites.split(",");
				// 循环判断
				for (String split : splits) {
					// 存在当前收藏工号，返回-1，无需操作数据库
					if (split.equals(collectEmpCode)) {
						return -1;
					}
					// 不然就追加工号
					sb.append(split).append(",");
				}
			}
			// 联系人为空，直接添加
			sb = sb.append(collectEmpCode);
			// 拼接sql
			String sql = "update om_myFavorites set collectEmpCode = '"
					+ sb.toString() + "' where empCode = '"
					+ map.get("userId") + "'";
			// 更新数据
			return template.update(sql);
		}
		// 如果常用联系人人数为空，收藏
		return myFavoritesDao.collectOne(map);
	}

	@Override
	public List<EmployeeVO> getFavorites(String userId) {
		// 定义返回结果集
		List<EmployeeVO> resultLists = new ArrayList<EmployeeVO>();
		// 获取常用联系人
		String favorites = myFavoritesDao.getFavorites(userId);
		if(null != favorites && favorites.length() > 0){
			// 分隔
			String[] splits = favorites.split(",");
			resultLists = tongxunLuService.queryEmpByUserIds(splits);
		}
		// 返回结果集
		return resultLists;
	}

	@Override
	public int removeOne(Map<String, String> map) {
		// 添加工号列表
		List<String> lists = new ArrayList<String>();
		// 参数拼接
		StringBuilder sb = new StringBuilder();
		// 根据工号查询常用联系人
		String myFavorites = myFavoritesDao.getFavorites(map.get("userId"));
		if (null != myFavorites && myFavorites.length() > 0) {
			// 分隔
			String[] splits = myFavorites.split(",");
			for (String split : splits) {
				// 如果不等于包含的工号，就添加到list中
				if (!split.equals(map.get("collectEmpCode"))) {
					// 拼接剩余联系人
					sb.append(split).append(",");
				}
				// 很渣，可优化
				lists.add(split);
			}
			// 如果包含
			if (lists.contains(map.get("collectEmpCode"))) {
				myFavorites = sb.toString();
				if(null != myFavorites && StringUtils.isNotEmpty(myFavorites)){
					// 切掉“，”
					myFavorites = myFavorites
							.substring(0, myFavorites.length() - 1);
				}
				// 更新常用联系人
				String sql = "update om_myFavorites set collectEmpCode = '"
						+ myFavorites + "' where empCode = '"
						+ map.get("userId") + "'";
				// 返回
				return template.update(sql);
			}
		}
		// 返回
		return 0;
	}

	@Override
	public int removeAll(String userId) {
		// sql语句
		String sql = "update om_myFavorites set collectEmpCode = null where empCode = '"
				+ userId + "'";
		// 执行
		return template.update(sql);
	}

	// set
	public void setMyFavoritesDao(IMyFavoritesDao myFavoritesDao) {
		this.myFavoritesDao = myFavoritesDao;
	}

	// set
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// set
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}


}
