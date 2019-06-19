package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.module.management.server.dao.IInformationDao;
import com.deppon.dpm.module.management.shared.domain.InformationSort;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * @author 
 * IInformationDao 接口
 */
public class InformationDao extends iBatis3DaoImpl implements IInformationDao {
    //工作空间
	private String NAME_SPACE = "com.deppon.dpm.module.management.server.dao.infoStore.";

	/**
	 * @param userId 工号
	 * @return list
	 */ 
	public List<InformationSort> list(String userId) {
		@SuppressWarnings("unchecked")
		//查询数据
		List<InformationSort> selectList = getSqlSession().selectList(
				NAME_SPACE + "list");
		//返回数据
		return selectList;
	}

	/**
	 * @param userId 工号
	 * @param infoId 参数
	 */
	public void download(String userId, int id) {
		getSqlSession().update(NAME_SPACE + "download", id);
		String sort = getSort(userId);
		//判断参数是否为null
		if (StringUtils.isNotEmpty(sort)) {
			if (sort.endsWith(",0")) {
				//截取数据
				String substring = sort.substring(0, sort.indexOf(",0"));
				sort = substring + "," + id + ",0";
			} else if (sort.equals("0")) {
				sort = id + "," + sort;
			} else {
				sort = sort + "," + id;
			}
			sort(userId, sort);
		} else {
			sort(userId, String.valueOf(id));
		}
	}

	/**
	 * @param userId 工号
	 * @param sortStr 排序
	 */
	public void sort(String userId, String sortStr) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("sortStr", "'" + sortStr + "'");
		//更新数据
		getSqlSession().update(NAME_SPACE + "updateSort", map);
	}

	/**
	 * @param userId 工号
	 * @return 返回数据
	 */
	public String getSort(String userId) {
		//返回数据
		return (String) getSqlSession().selectOne(NAME_SPACE + "getSort",
				userId);
	}

}
