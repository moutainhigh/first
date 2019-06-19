package com.deppon.dpm.module.announce.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.module.announce.server.dao.INormalQuestionHandleDao;
import com.deppon.dpm.module.announce.server.service.INormalQuestionHandleService;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionHandleEntity;
/**
 * 常见问题处量人service层实现
 * @author 276344
 *
 */
public class NormalQuestionHandleService implements
		INormalQuestionHandleService {
	/**
	 * dao层
	 */
	private INormalQuestionHandleDao normalQuestionHandleDao;
	private String webUrl;

	@Override
	public List<NormalQuestionHandleEntity> getNormalQuestionHandle() {
		/**
		 * 常见问题获取
		 */
		// 数据库中获取的是保存的图片名，要把结果拼接成服务器图片路径地址
		StringBuffer sb = new StringBuffer();
		sb.append(webUrl + "/");
		sb.append("headPhoto/");
	    List<NormalQuestionHandleEntity> normalList = new ArrayList<NormalQuestionHandleEntity>();
	    normalList = normalQuestionHandleDao.getNormalQuestionHandle();	    
		for (NormalQuestionHandleEntity normalQuestionHandleEntity : normalList) {
			String pic = normalQuestionHandleEntity.getPictPath();
			if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(normalQuestionHandleEntity.getPictPath())) {
				normalQuestionHandleEntity.setPictPath(sb + pic);
			}
			
		}
		return normalList;
	}
	
	/**
	 * get
	 * @return
	 */
	public INormalQuestionHandleDao getNormalQuestionHandleDao() {
		return normalQuestionHandleDao;
	}
	/**
	 * set
	 * @param normalQuestionHandleDao
	 */
	public void setNormalQuestionHandleDao(
			INormalQuestionHandleDao normalQuestionHandleDao) {
		this.normalQuestionHandleDao = normalQuestionHandleDao;
	}
	/**
	 * get
	 * @return
	 */
	public String getWebUrl() {
		return webUrl;
	}
	/**
	 * set
	 * @param webUrl
	 */
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
}
