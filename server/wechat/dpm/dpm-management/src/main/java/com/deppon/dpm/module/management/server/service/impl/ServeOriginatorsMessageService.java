package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IServeOriginatorsMessageDao;
import com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;

/**   
* @Description: 拼车吧
* @author 268087 张广波
* @date 2016-1-5 下午4:12:12 
* @version V1.0 
*/
public class ServeOriginatorsMessageService implements 	IServeOriginatorsMessageService {
	/** 
	* @Fields logger 日志
	*/ 
	private Logger logger = LoggerFactory.getLogger(ServeOriginatorsMessageService.class);	
	/**
	 * 门户头像service
	 */
	private IPersonlyImageService personlyImageService;
	
	/** 
	* @Fields serveOriginatorsMessageDao 拼车吧操作dao
	*/ 
	private IServeOriginatorsMessageDao serveOriginatorsMessageDao;
	

	/** 获取图片链接
	 * @param list
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService#getImageUrl(java.util.List)
	 */
	public Map<String, String> getImageUrl(List<String> list) {
		Map<String,String> imageUserNoMap = new HashMap<String, String>();
		for(String userNo : list){
			//判断工号是否为空
			if(StringUtils.isNotBlank(userNo)){
				//校验是否包含工号
				if(!imageUserNoMap.containsKey(userNo)){
					String imageUrl;
					try{
						imageUrl = this.personlyImageService.downloadImage(userNo);
					}catch (Exception e) {
						imageUrl = "";
						logger.info("向门户获取"+userNo+"用户头像信息出现异常  has error");
						e.printStackTrace();
					}
					imageUserNoMap.put(userNo, imageUrl);
				}
			}else{
				logger.info("用户头像信息 传参数 userNo 是 空");
			}
		}
		return imageUserNoMap;
	}
	

	/**保存参与信息
	 * @param entity
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService#saveServePartInfo(com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity)
	 */
	public boolean saveServePartInfo(ServeParticipantsInfoEntity entity) {
		int i = this.serveOriginatorsMessageDao.insertIntoServePart(entity);
		if(i>0){
			return true;
		}
		return false;
	}
	
	/**保存发布信息
	 * @param entity
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService#saveServeOriginatorInfo(com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity)
	 */
	public boolean saveServeOriginatorInfo(ServeOriginatorsInfoEntity entity) {
		int i = this.serveOriginatorsMessageDao.insertIntoServeOriginator(entity);
		if(i>0){
			return true;
		}
		return false;
	}
	
	/** 
	* @Description: 校验提交信息是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午3:39:31 
	*  @param entity
	*  @return 
	*/
	public boolean checkOrigRepeat(ServeOriginatorsInfoEntity entity){
		int i = this.serveOriginatorsMessageDao.checkOrigRepeat(entity);
		if(i>0){
			return true;
		}
		return false;
	}

	
	/** 
	* @Description: 校验报名参与是否重复
	* @author 268087 张广波
	* @date 2015-12-30 下午6:42:40 
	*  @param entity
	*  @return 
	*/
	public boolean checkPartRepeat(ServeParticipantsInfoEntity entity){
		int i = this.serveOriginatorsMessageDao.checkPartRepeat(entity);
		if(i>0){
			return true;
		}
		return false;
	}
	
	
	/** 
	* @Description: 更新报名信息
	* @author 268087 张广波
	* @date 2015-12-30 下午6:45:26 
	*  @param entity
	*  @return 
	*/
	public boolean updatePartInfo(ServeParticipantsInfoEntity entity){
		int i = this.serveOriginatorsMessageDao.updatePartInfo(entity);
		if(i>0){
			return true;
		}
		return false;
	}
	
	
	/** 获取图片字符串信息
	 * @param userNo
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService#getImageURL(java.lang.String)
	 */
	public String getImageURL(String userNo) {
		String imageUrl = "";
		try{
			imageUrl = this.personlyImageService.downloadImage(userNo);
		}catch (Exception e) {
			imageUrl = "";
			logger.info("向门户获取"+userNo+"用户头像信息出现异常  has error");
			e.printStackTrace();
		}
		return imageUrl;
	}	
	

	/** 限制大小
	 * @param id
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService#getLimitSize(int)
	 */
	@Override
	public ServeOriginatorsInfoEntity getLimitSize(int id) {
		return this.serveOriginatorsMessageDao.getOriginatorsInfoById(id);
	}


	/** 
	* @Description: 获取员工图像信息操作service
	* @author 268087 张广波
	* @date 2016-1-5 下午4:15:40 
	*  @return 
	*/
	public IPersonlyImageService getPersonlyImageService() {
		return personlyImageService;
	}

	/** 
	* @Description: 设置员工图像信息操作service
	* @author 268087 张广波
	* @date 2016-1-5 下午4:18:50 
	*  @param personlyImageService 
	*/
	public void setPersonlyImageService(IPersonlyImageService personlyImageService) {
		this.personlyImageService = personlyImageService;
	}


	/** 
	* @Description: 获取拼车操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午4:19:20 
	*  @return 
	*/
	public IServeOriginatorsMessageDao getServeOriginatorsMessageDao() {
		return serveOriginatorsMessageDao;
	}


	/** 
	* @Description: 设置拼车操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午4:19:37 
	*  @param serveOriginatorsMessageDao 
	*/
	public void setServeOriginatorsMessageDao(IServeOriginatorsMessageDao serveOriginatorsMessageDao) {
		this.serveOriginatorsMessageDao = serveOriginatorsMessageDao;
	}
	
}
