package com.deppon.dpm.module.management.server.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.service.impl.PhotoAddressService;
import com.deppon.dpm.module.common.server.util.UploadUtil;
import com.deppon.dpm.module.management.server.dao.IAppDetailDao;
import com.deppon.dpm.module.management.server.service.IAppDetailService;
import com.deppon.dpm.module.management.shared.domain.AppCommentEntity;
import com.deppon.dpm.module.management.shared.domain.AppDetailEntity;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;



/**
 * 应用详情service实现层
 * 
 * @author 491275
 *
 */
public class AppDetailService implements IAppDetailService{
	
	// 日志
    private static final Logger logger = Logger.getLogger(AppDetailService.class);
    /**
	 * set injection
	 */
    private IAppDetailDao appDetailDao;
    
    /**
	 * set injection
	 */
	private PhotoAddressService photoAddressService;

	/**
	 * set injection
	 */
	private AppCommentEntity appCommentEntity = new AppCommentEntity();
	
	/**
	 * set injection
	 */
	private AppDetailEntity appDetailEntity = new AppDetailEntity();

	
	/**
	 * 查询应用商店所有app的id和名字 
	 */
	public List<ApplyStore> selectAllAppId(){	
		List<ApplyStore> list = appDetailDao.selectAllAppId();
		return list;
	}
	
	/**
	 * 根据id查询app名字
	 */
	public String selectAppNameById(int appId){	
		return appDetailDao.selectAppNameById(appId);
	}
	
	/**
	 * 插入应用详情
	 */
	@Override
	public int insertAppDetail(int appstoreId,String appName,String appIntroduce,String newFeature,String detailMessage,File[] photos,String[] photosName){
		int result = 0;
		// 获取应用详情图片路径
		String appDetailAddress = photoAddressService.getAppDetailAddress();
		try {
			// 上传图片文件
			if(appDetailAddress != ""){
				List<String> returnPath = UploadUtil.uploadFiles(photos,
						appDetailAddress, photosName);

			    // 用以拼接参数
			    Map<Object, Object> map = new HashMap<Object, Object>();
			    // 应用商店对应id
			    map.put("appstoreId", appstoreId);
			    // 应用名称
			    map.put("appName", appName);
			    // 应用介绍
		    	map.put("appIntroduce", appIntroduce);
		    	//新特性
		    	map.put("newFeature", newFeature);
			    // 详细信息
		    	map.put("detailMessage", detailMessage);
		    	// 路径
			    String path = null;
			    // 直接获取图片路径
			    if (returnPath != null && returnPath.size() > 0) {
				    path = returnPath.toString().substring(1,
						returnPath.toString().length() - 1);
			    	// 文件图片
				    map.put("file_path", path);
			    }
			    //插入应用详情信息	
			    result = appDetailDao.insertAppDetail(map);
			}
		} catch (Exception e) {
			logger.info("insertAppDetail:" + e);
			result = -1;
		}
		return result;
	}
	
	/**
	 * 查询应用详情
	 */
	@Override
	public AppDetailEntity selectAppDetailById(int appstoreId){
		// 获取应用详情图片路径(带IP、端口)
		String appDetailAddress = photoAddressService.getServerHostPort()
				+ photoAddressService.getAppDetailAddress();
		//获得应用详情实体
		appDetailEntity = appDetailDao.selectAppDetailById(appstoreId);
		//数据请求不为null
		if(appDetailEntity != null && appDetailAddress != ""){
			// 获取文件名
			String photosName = appDetailEntity.getAppPhoto();
			// 不为null
			if (StringUtils.isNotEmpty(photosName)) {
				// 多个文件
				String[] split = photosName.split(",");
				// 拼接
				StringBuilder sb = new StringBuilder();
				// 循环
				for (int j = 0; j < split.length; j++) {
					// 默认list中的之后元素前面会有空，放在浏览器上会有%20字段，导致图片无法显示
					String file = appDetailAddress + "/" + split[j].trim();
					// 拼接
					sb.append(file.trim());
					// 拼接
					sb.append(",");
				}
				String str = sb.substring(0 , sb.length() - 1);
				// 重新设置
				appDetailEntity.setAppPhoto(str);
			}
		}
		return appDetailEntity;
	}
	
	/**
	 * 计算应用评分
	 */
	@Override
	public Double getAppScore(int appId) throws Exception{
		System.out.println(appDetailDao.getAppScore(appId));
		return appDetailDao.getAppScore(appId);
	}
	
	/**
	 * 插入应用评论
	 */
	@Override
	public int insertAppComment(int appstoreId,String empCode,String content,int score){
		int result = 0;
		/*if(appDetailDao.getEmpCodeCount(empCode) == 0){*/
			try{
				//应用id
				appCommentEntity.setAppId(appstoreId);
				//评论人id
				appCommentEntity.setEmpCode(empCode);
				//评论内容
				appCommentEntity.setContent(content);
				//得分
				appCommentEntity.setScore(score);
				//插入应用评论
				if(appCommentEntity != null){
					result = appDetailDao.insertAppComment(appCommentEntity);
				}
				//重新计算应用总评分
				if(result > 0){
					Double totalScore = appDetailDao.getAppScore(appstoreId);
					Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("appstoreId", appstoreId);
					map.put("totalScore", totalScore);
					appDetailDao.updateTotalScore(map);
				}
			}catch(Exception e){
				logger.info("insertAppDetail:" + e);
				result = -1;
			}
		/*}*/
		return result;
	}
	
	/**
	 * 分页展示评论列表
	 */
	@Override
	public List<AppCommentEntity> getCommentList(int appstoreId,int startNo,int pageSize){
		return appDetailDao.getCommentList(appstoreId, startNo, pageSize);
	}
	
	/**
	 * 获取有回复权限的工号
	 */
	public List<String> getExcEmpcodeList(){
		return appDetailDao.getExcEmpcodeList();
	}
	
	/**
	 * 获得该应用的评论条数
	 */
	public int getCommentCount(int appstoreId){
		return appDetailDao.getCommentCount(appstoreId);
	}
	
	/**
	 * 添加评论回复
	 */
	public int updateCommentReply(int commentId, String replyContent, String replyEmpCode){
		//封装实体
		appCommentEntity.setCommentId(commentId);
		appCommentEntity.setReplyContent(replyContent);
		appCommentEntity.setReplyEmpCode(replyEmpCode);
		//插入评论回复
		return appDetailDao.updateCommentReply(appCommentEntity);
	}
	
	public IAppDetailDao getAppDetailDao() {
		return appDetailDao;
	}

	public void setAppDetailDao(IAppDetailDao appDetailDao) {
		this.appDetailDao = appDetailDao;
	}

	public AppCommentEntity getAppCommentEntity() {
		return appCommentEntity;
	}

	public void setAppCommentEntity(AppCommentEntity appCommentEntity) {
		this.appCommentEntity = appCommentEntity;
	}
	
	public PhotoAddressService getPhotoAddressService() {
		return photoAddressService;
	}

	public void setPhotoAddressService(PhotoAddressService photoAddressService) {
		this.photoAddressService = photoAddressService;
	}

	public AppDetailEntity getAppDetailEntity() {
		return appDetailEntity;
	}

	public void setAppDetailEntity(AppDetailEntity appDetailEntity) {
		this.appDetailEntity = appDetailEntity;
	}

}
