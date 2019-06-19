package com.deppon.dpm.module.management.server.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.deppon.dpm.module.management.shared.domain.NQHandleEntity;
import com.deppon.foss.framework.exception.BusinessException;



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
	
	public static final int NUMBER_OF_RESULT = 99;
	/**
	 * 插入应用详情
	 */
	@Override
	public int insertAppDetail(int appstoreId,String appName,String appIntroduce,String newFeature,String detailMessage,File[] photos,String[] photosName){
		int result = 0;
		//判断该应用详情是否已添加   如果应用详情表中无此应用，可插入
		int count = appDetailDao.getappdetailCount(appName);
		if(count == 0){
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
			//存储图片
			if(photos != null && photosName != null){
				// 获取应用详情图片路径
				String appDetailAddress = photoAddressService.getAppDetailAddress();
				try {
					// 上传图片文件
					if(appDetailAddress!=null&&appDetailAddress.length()>0){
						List<String> returnPath = UploadUtil.uploadFiles(photos,
								appDetailAddress, photosName);
						// 路径
						String path = null;
						// 直接获取图片路径
						if (returnPath != null && returnPath.size() > 0) {
							path = returnPath.toString().substring(1,
									returnPath.toString().length() - 1);
							// 文件图片
							map.put("file_path", path);
						}
					}
				} catch (Exception e) {
					logger.info("insertAppDetail:" + e);
					result = -1;
				}
			}
			//插入应用详情信息	
			try {
				result = appDetailDao.insertAppDetail(map);
			} catch (Exception e) {
				logger.info("insertAppDetail:" + e);
				e.printStackTrace();
			}
		}else{
			//若已存在
			result = NUMBER_OF_RESULT;
		}
		return result;
	}
	
	/**
	 * 根据id查询应用详情
	 */
	public static final int NUMBER_OF_FN = 5;
	@Override
	public AppDetailEntity selectAppDetailById(int appstoreId){
		// 获取应用详情图片路径(带IP、端口)
		String appDetailAddress = photoAddressService.getServerHostPort()
				+ photoAddressService.getAppDetailAddress().replace("/dpmfile", "");
		//获得应用详情实体
		appDetailEntity = appDetailDao.selectAppDetailById(appstoreId);
		if(appDetailEntity != null){
			BigDecimal bg = new BigDecimal(appDetailEntity.getTotalScope());
			//截取到小数点后一位
	        double f1 = bg.setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
	        //获取小数点后一位数字
			/*char fn = ((f1+"").substring((f1+"").indexOf("."), (f1+"").length())).charAt(1);*/
	        String fn = (f1+"").charAt((f1+"").length()-1) + "";
	        //string转int
			int fnn = Integer.parseInt(fn);
			if( fnn < NUMBER_OF_FN){
				appDetailEntity.setTotalScope(Double.valueOf((f1+"").charAt(0)+"."+"0"));
			}else{
				appDetailEntity.setTotalScope(Double.valueOf((f1+"").charAt(0)+"."+"5"));
			}
			//数据请求不为null
			if(appDetailAddress!=null&&appDetailAddress.length()>0){
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
		}else{
			appDetailEntity = new AppDetailEntity();
			appDetailEntity.setAppstoreId(appstoreId);
		}
		return appDetailEntity;
	}
	
	/**
	 * 查询应用详情列表
	 */
	public List<AppDetailEntity> getAppDetailList(String userId){
		List<AppDetailEntity> appdetailList = new ArrayList<AppDetailEntity>();
		//获取应用详情列表
		if(userId.equals("265564")){
			appdetailList = appDetailDao.getAllDetailList(userId);
		}else{
			appdetailList = appDetailDao.getAppDetailList(userId);
		}
		//遍历列表重新设置图片地址
		for(AppDetailEntity appdetail : appdetailList){
			// 获取应用详情图片路径(带IP、端口)
			String appDetailAddress = photoAddressService.getServerHostPort()
					+ photoAddressService.getAppDetailAddress().replace("/dpmfile", "");
			//数据请求不为null
			if(appdetail != null && appDetailAddress.length()>0){
				// 获取文件名
				String photosName = appdetail.getAppPhoto();
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
					appdetail.setAppPhoto(str);
				}
			}
		}
		return appdetailList;
	}
	
	/**
	 * 修改应用详情
	 */
	public int updateAppDetail(AppDetailEntity appDetailEntity,File[] photos,String[] photosName, String appManager){
		int result = 0;
		// 用以拼接参数
		Map<Object, Object> map = new HashMap<Object, Object>();
		//应用id
		map.put("id", appDetailEntity.getId());
		// 应用名称
		map.put("appName", appDetailEntity.getAppName());
		// 应用介绍
		if(appDetailEntity.getAppIntroduce() != null){
			map.put("appIntroduce", appDetailEntity.getAppIntroduce());
		}
		//新特性
		if(appDetailEntity.getNewFeature() != null){
			map.put("newFeature", appDetailEntity.getNewFeature());
		}
		// 详细信息
		if(appDetailEntity.getDetailMessage() != null){
			map.put("detailMessage", appDetailEntity.getDetailMessage());
		}
		if(photos != null && photosName != null){
			// 获取应用详情图片路径
			String appDetailAddress = photoAddressService.getAppDetailAddress();
			try {
				// 上传图片文件
				if(appDetailAddress!=null&&appDetailAddress.length()>0){
					List<String> returnPath = UploadUtil.uploadFiles(photos,
							appDetailAddress, photosName);
					// 路径
					String path = null;
					// 直接获取图片路径
					if (returnPath != null && returnPath.size() > 0) {
						path = returnPath.toString().substring(1,
								returnPath.toString().length() - 1);
						// 文件图片
						map.put("file_path", path);
					}
				}
			} catch (Exception e) {
				logger.info("getAppDetailAddress-update:" + e);
				result = -1;
			}
		}
		
		//更新应用详情信息
		try {
		    result = appDetailDao.updateAppDetail(map);
		} catch (Exception e) {
			logger.info("updateAppDetail:" + e);
			result = -1;
		}
		
        if(appManager != null && !appManager.equals("") && appManager.length() == 6){
        	map.put("appManager", appManager);
        	int res = appDetailDao.updateAppManager(map);
        	NQHandleEntity nqEntity = appDetailDao.getNQHandleByApp(appDetailEntity.getAppName());
        	NQHandleEntity nqEntity1 = appDetailDao.getNQHandlebyCode(appManager);
        	
        	if(nqEntity.getContent().equals(appDetailEntity.getAppName())){
        		if(nqEntity1 != null && nqEntity1.getEmpCode()!= null){
        			//原对接人只负责此应用 但新对接人有其他应用
        			String content = nqEntity1.getContent() + "、" +appDetailEntity.getAppName();
        			Map<Object, Object> map1 = new HashMap<Object, Object>();
        			map1.put("id", nqEntity1.getId());
        			map1.put("content", content);
        			int res1 = appDetailDao.updateNQHandle(map1);
        			int res2 = appDetailDao.deleteNQHandle(nqEntity.getId());
        		}else{
        			//原对接人只负责此应用 且新对接人无其他应用
        			Map<Object, Object> map1 = new HashMap<Object, Object>();
        			map1.put("id", nqEntity.getId());
        			map1.put("empCode", appManager);
        			int res1 = appDetailDao.updateNQHandle(map1);
        		}
        	}else{
        		//原对接人负责多个应用
        		String content = nqEntity.getContent();
        		if(nqEntity.getContent().contains(appDetailEntity.getAppName() + "、")){
        			content = nqEntity.getContent().replace(appDetailEntity.getAppName() + "、", "");
        		}else{
        			content = nqEntity.getContent().replace("、" + appDetailEntity.getAppName(), "");
        		}

        		Map<Object, Object> map1 = new HashMap<Object, Object>();
        		map1.put("id", nqEntity.getId());
        		map1.put("content", content);
        		int res1 = appDetailDao.updateNQHandle(map1);

        		if(nqEntity1 != null && nqEntity1.getEmpCode()!= null){
                    //新对接人也有其他应用
        			String content1 = nqEntity1.getContent() + "、" + appDetailEntity.getAppName();
        			Map<Object, Object> map2 = new HashMap<Object, Object>();
        			map2.put("id", nqEntity1.getId());
        			map2.put("content", content1);
        			int res2 = appDetailDao.updateNQHandle(map2);
        		}else{
        			//新对接人无其他应用
        			Map<Object, Object> map2 = new HashMap<Object, Object>();
        			map2.put("empCode", appManager);
        			map2.put("content", appDetailEntity.getAppName());
        			int res2 = appDetailDao.insertNQHandle(map2);
        		}
        		
        	}
		}
		
		return result;
	}
	
	/**
	 * 计算应用评分
	 */
	@Override
	public Double getAppScore(int appId) throws BusinessException{
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
				
				if(appCommentEntity != null){
					//应用id
					appCommentEntity.setAppId(appstoreId);
					//评论人id
					appCommentEntity.setEmpCode(empCode);
					//评论内容
					appCommentEntity.setContent(content);
					//得分
					appCommentEntity.setScore(score);
					//插入应用评论
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
