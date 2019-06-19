package com.deppon.dpm.module.management.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IServePhotoDao;
import com.deppon.dpm.module.management.server.service.IServePhotoService;
import com.deppon.dpm.module.management.shared.domain.ServeNoticeInfo;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 拼车吧service图片上传接口实现
 * 
 */
public class ServePhotoService implements IServePhotoService {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ServePhotoService.class);
	/**
	 * dao层
	 */
	private IServePhotoDao servePhotoDao;

	/**
	 * @param userNo
	 *            工号
	 * @return str 判断拼车吧是否有权限
	 */
	public String getPermissions(String userNo) {
		logger.info("<<<<<<<<<<<<<<<<<<<<<拼车权限userNo" + userNo);
		//设置一个变量
		String res = "{\"resultFlag\":false,\"failureReason\":\"没有权限！\"}";
		//判断工号是否为null
		if (!StringUtil.isEmpty(userNo)) {
			//判断是否有上传图片的权限
			List<String> listStr = this.servePhotoDao.getPermissions(userNo);
			//进行判断
			return (null != listStr && listStr.size() > 0) ? "{\"resultFlag\":true,\"failureReason\":\"有权限！\"}"
					: res;

		}
		return res;

	}

	/**
	 * @param str
	 *            参数
	 * @return str 拼车吧保存图片接口
	 */
	public String insertPhoto(String str) {
		//声明一个变量
		String res = "{\"resultFlag\":false,\"failureReason\":\"保存失败！\"}";
		//判断传入的参数是否为Null
		if (!StringUtil.isEmpty(str)) {
			//把json格式转为list
			List<ServeNoticeInfo> listInfo = JsonUtil.jsonToList(str,
					ServeNoticeInfo.class);
			//判断listInfo
			if (null != listInfo && listInfo.size() > 0) {
				
				//对数据进行重组
				for(ServeNoticeInfo info : listInfo) {
					String mark = info.getMark();
					//当参数mark=1的时候进行update
					if("1".equals(mark)) {
						int re = this.servePhotoDao.updatePhoto(info);
						if(re == 1) {
							res = "{\"resultFlag\":true,\"failureReason\":\"保存成功！\"}";
						}
					}
					else{
						//进行插入数据
						int result = this.servePhotoDao.insertPhoto(info);
						if(result == 1) {
							res = "{\"resultFlag\":true,\"failureReason\":\"保存成功！\"}";
						}
					}
				}
			

			}

		}
		//返回结果集
		return res;

	}
	

	/**
	 * @return  list
	 * 得到照片列表
	 */
	public List<ServeNoticeInfo> listSer() {
		return this.servePhotoDao.listSer();
		
	}
    //servePhotoDao
	public IServePhotoDao getServePhotoDao() {
		return servePhotoDao;
	}
   //servePhotoDao
	public void setServePhotoDao(IServePhotoDao servePhotoDao) {
		this.servePhotoDao = servePhotoDao;
	}
}
