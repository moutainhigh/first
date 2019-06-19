package com.deppon.dpm.module.management.server.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.module.management.server.dao.IApplyStoreDao;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.module.management.shared.domain.ApplyStoreAppraise;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ApplyStoreServiceDao extends iBatis3DaoImpl implements
		IApplyStoreDao {
	/**
	 * namespace
	 */
	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.applyStore.";

	/**
	 * namespace
	 */
	private String NAME_SPACE_APPRAISE = "com.deppon.dpm.module.management.server.dao.ApplyStoreAppraise.";

	/**
	 * 获取应用商店列表
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ApplyStore> list(String userId) {
		// 获取
		List<ApplyStore> selectList = getSqlSession().selectList(
				NAME_SPACE + "list");
		// 返回
		return selectList;
	}

	/**
	 * 下载成功后，根据工号保存新的排序到数据库
	 */
	@Override
	public void download(String userId, int id) {
		// 更新下载量
//		getSqlSession().update(NAME_SPACE + "download", id);
		// 获取排序
		String sort = getSort(userId);
		// 不为空
		if (StringUtils.isNotEmpty(sort)) {
			// 以，0结尾
			if (sort.endsWith(",0")) {
				// 截取，添加，插入
				String substring = sort.substring(0, sort.indexOf(",0"));
				// 重新排序
				sort = substring + "," + id + ",0";
			} else if (sort.equals("0")) {
				// 重新排序
				sort = id + "," + sort;
			} else {
				// 重新排序
				sort = sort + "," + id;
			}
			// 重新排序
			sort(userId, sort);
		} else {
			// 重新排序
			sort(userId, String.valueOf(id));
		}
	}

	/**
	 * 排序
	 */
	@Override
	public void sort(String userId, String sortStr) {
		sortStr = rmRepeatForSort(sortStr);
		// 条件拼接
		Map<String, String> map = new HashMap<String, String>();
		// 工号
		map.put("userId", userId);
		// 排序
		map.put("sortStr", "'" + sortStr + "'");
		// 更新
		getSqlSession().update(NAME_SPACE + "updateSort", map);
	}

	/**
	 * 根据工号获取排序
	 */
	@Override
	public String getSort(String userId) {
		// 获取排序
		String strSort = (String) getSqlSession().selectOne(NAME_SPACE + "getSort",
				userId);
		return rmRepeatForSort(strSort);
	}
	
	private String rmRepeatForSort(String strSort) {
		// 判断
		if (StringUtils.isBlank(strSort)) {
			// 返回
			return null;
		}
		// 定义集合
		List<String> list = null;
		// 切割
		String[] strs = strSort.split(",");
		// 判断
		if (null != strs && strs.length > 0) {
			// new
			list = new ArrayList<String>();
			// 遍历
			for (String str : strs) {
				// 去重
				if (!list.contains(str)) {
					list.add(str);
				}
			}
		}
		// 判断
		if (null != list) {
			// StringBuilder
			StringBuilder sb = new StringBuilder();
			// 遍历
			for (String applyId : list) {
				// 添加
				sb.append(applyId).append(",");
			}
			// 去掉最后一个,
			sb.deleteCharAt(sb.length() - 1);
			// 返回
			return sb.toString();
		}
		// 返回
		return null;
	}

	/**
	 * 获取应用商店列表总数
	 */
	@Override
	public Long getApplyStoreCount() {
		return (Long)getSqlSession().selectOne(NAME_SPACE + "getApplyStoreCount");
	}

	/**
	 * 获取应用商店列表
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ApplyStore> getApplyStoreList(int appId, int begin, int pageSize) {
		// 返回值
		List<ApplyStore> selectList = new ArrayList<ApplyStore>();
		// 条件拼接
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("pageSize", pageSize);
		// 判断是否为空
		if (appId != 0) {
			map.put("appId", appId);
		}
		// 获取应用商店列表
		selectList = getSqlSession().selectList(NAME_SPACE + "listApplyStore",
				map);
		// 返回
		return selectList;
	}

	/**
	 * 插入应用商店
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int insertApplyStore(ApplyStore entity) {
		// 插入应用商店
		return getSqlSession().insert(NAME_SPACE + "insertApplyStore", entity);
	}

	/**
	 * 更新应用商店
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int updateApplyStore(ApplyStore entity) {
		// 更新应用商店
		return getSqlSession().update(NAME_SPACE + "updateApplyStore", entity);
	}

	/**
	 * 删除应用商店
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int deleteApplyStore(ApplyStore entity) {
		// 应用商店id
		int appId = entity.getAppId();
		if (appId != 0) {
			// 删除信息
			return getSqlSession().delete(NAME_SPACE + "deleteApplyStore",
					appId);
		} else {
			return 0;
		}
	}
	
	/**
	 * 切换应用下载平台
	 */
	@Override
	public void updateDLoadLine(int line) {
		this.getSqlSession().update(NAME_SPACE + "updateDLoadLine",
				line);
	}

	/**
	 * 获取应用商店详情信息
	 * 
	 * @param appId
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ApplyStore getApplyStoreById(int appId) {
		ApplyStore app = null;
		// 获取应用商店列表
		List<ApplyStore> selectList = getSqlSession().selectList(
				NAME_SPACE + "getApplyStoreByid", appId);
		if (selectList != null && selectList.size() > 0) {
			app = selectList.get(0);
		}
		// 返回
		return app;
	}

	/**
	 * 获取应用评论列表
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ApplyStoreAppraise> getApplyStoreAppraiseList(
			ApplyStoreAppraise entity, int begin, int pageSize) {
		// 条件拼接
		Map map = new HashMap();
		map.put("begin", begin);
		map.put("pageSize", pageSize);
		// 判断是否为空
		if (entity.getAppId() != 0) {
			map.put("appId", entity.getAppId());
		}
		if (StringUtils.isNotBlank(entity.getEmpcode())) {
			map.put("empcode", entity.getEmpcode());
		}
		// 获取应用评论列表
		List<ApplyStoreAppraise> selectList = getSqlSession().selectList(
				NAME_SPACE_APPRAISE + "listApplyStoreAppraise", map);
		// 返回
		return selectList;
	}

	/**
	 * 插入应用评论信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int insertApplyStoreAppraise(ApplyStoreAppraise entity) {
		// 插入应用商店
		return getSqlSession().insert(
				NAME_SPACE_APPRAISE + "insertApplyStoreAppraise", entity);
	}

	/**
	 * 屏蔽用户评论
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int updateApplyStoreAppraise(ApplyStoreAppraise entity) {
		// 更新应用评论信息
		return getSqlSession().update(
				NAME_SPACE_APPRAISE + "updateApplyStoreAppraise", entity);
	}

}
