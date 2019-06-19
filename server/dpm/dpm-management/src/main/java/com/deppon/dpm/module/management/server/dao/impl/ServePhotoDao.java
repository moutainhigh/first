package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IServePhotoDao;
import com.deppon.dpm.module.management.shared.domain.ServeNoticeInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 拼车吧上传图片dao接口的实现
 * 
 */
public class ServePhotoDao extends iBatis3DaoImpl implements IServePhotoDao {

	static String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.photo";

	/**
	 * @param userNo
	 *            广告
	 * @return list 判断是否有上传图片的权限
	 */
	public List<String> getPermissions(String userNo) {
		if (!StringUtil.isEmpty(userNo)) {
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getPermissions", userNo);
		}
		return null;

	}

	/**
	 * @param listInfo
	 *            广告表list
	 * @return int 拼车吧照片添加
	 */
	public int insertPhoto(ServeNoticeInfo listInfo) {
		if (null != listInfo ) {
			return this.getSqlSession().insert(
					mapperNameSpace + ".insertPhoto", listInfo);
		}
		return 0;

	}
	
	/**
	 * @param listInfo 广告表list
	 * @return int
	 * 拼车吧照片修改
	 */
	public int updatePhoto(ServeNoticeInfo listInfo) {
		if (null != listInfo) {
			return this.getSqlSession().insert(
					mapperNameSpace + ".updatePhoto", listInfo);
		}
		return 0;
		
	}
	/**
	 * @return  list
	 * 得到照片列表
	 */
	@SuppressWarnings("unchecked")
	public List<ServeNoticeInfo> listSer() {
		return this.getSqlSession().selectList(mapperNameSpace + ".listSer");
		
	}
}
