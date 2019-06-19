package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ServeNoticeInfo;

/**
 * @author 268101 拼车吧上传图片dao接口
 * 
 * 
 */
public interface IServePhotoDao {
	/**
	 * @param userNo
	 *            广告
	 * @return list 判断是否有上传图片的权限
	 */
	public List<String> getPermissions(String userNo);

	/**
	 * @param listInfo
	 *            广告表list
	 * @return int 拼车吧照片添加
	 */
	public int insertPhoto(ServeNoticeInfo listInfo);
	
	/**
	 * @param listInfo 广告表list
	 * @return int
	 * 拼车吧照片修改
	 */
	public int updatePhoto(ServeNoticeInfo listInfo);
	/**
	 * @return  list
	 * 得到照片列表
	 */
	public List<ServeNoticeInfo> listSer();

}
