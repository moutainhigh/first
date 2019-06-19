package com.deppon.dpm.module.common.server.service;

import java.util.List;

import com.deppon.dpm.module.common.shared.domain.WelcomePageEntity;
import com.deppon.dpm.module.common.shared.domain.WelcomePageLinkEntity;
import com.deppon.foss.framework.service.IService;

/**
 * 欢迎页配置service
 * 
 * @date 2015-08-24
 * @author 231586
 * 
 */
public interface IEditWelcomePageService extends IService {
	/**
	 * 保存配置信息，便于展示
	 * 
	 * @param pageEntity
	 * @return
	 */
	public int savePic(WelcomePageEntity pageEntity);

	/**
	 * 获取详细信息
	 * 
	 * @param userId
	 * @param isDetail
	 * @return
	 */
	public List<WelcomePageEntity> getDetails(String userId,boolean isDetail);

	/**
	 * 根据Id删除配置信息
	 * 
	 * @param pageId
	 * @return
	 */
	public int delWelcomePage(String pageIds);

	/**
	 * 获取欢迎页列表
	 * @param userId
	 * @param begin
	 * @param rows
	 * @return
	 */
	public List<WelcomePageEntity> getWelcomePageList(int begin,
			int rows);
	/**
	 * 数据总条数
	 * @param userId
	 * @return
	 */
	public Long queryCount();

	/**
	 * 获取所有应用链接
	 * @return
	 */
	public List<WelcomePageLinkEntity> getWelcomePageLinks();
	
}
