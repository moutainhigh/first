package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ServeNoticeInfo;

/**
 * @author 268101
 * 
 *         拼车吧图片上传接口
 */
public interface IServePhotoService {

	/**
	 * @param userNo
	 *            工号
	 * @return str 判断拼车吧是否有权限
	 */
	public String getPermissions(String userNo);

	/**
	 * @param str
	 *            参数
	 * @return str 拼车吧保存图片接口
	 */
	public String insertPhoto(String str);
	
	/**
	 * @return  list
	 * 得到照片列表
	 */
	public List<ServeNoticeInfo> listSer();

}
