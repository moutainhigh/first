package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.ISendParcelNewsDao;
import com.deppon.dpm.module.management.server.service.ISendParcelNewsService;
import com.deppon.dpm.module.management.shared.domain.SendParcelNewsEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101(帮别人修改) 收发室消息推送的接口实现
 * 
 */
public class SendParcelNewsService implements ISendParcelNewsService {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(SendParcelNewsService.class);

	/**
	 * dao 接口的注入
	 */
	private ISendParcelNewsDao sendParcelNewsDao;

	/**
	 * @return 得到未发送的消息数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public List<SendParcelNewsEntity> getNews(String userNo) throws BusinessException {
		logger.info("进入消息推送service>>>>>>>>>>>>>>>>>>>>>");
		if (!StringUtil.isEmpty(userNo)) {
			// 查询需要推送的数据
			List<SendParcelNewsEntity> listEntities = this.sendParcelNewsDao
					.getNews(userNo);
			// 判断list是否有数据
			if (null != listEntities && listEntities.size() > 0) {
				logger.info("有需要推送的数据>>>>>>>>>>");
				try {
					// 对查询出来的数据在进行更新
				 updateNews(userNo);

				} catch (BusinessException e) {
					logger.info("收发室消息推送数据更新失败>>>>>>>>>>>>>>");
				}

			}
           //返回数据
			return listEntities;

		}
		return null;

	}

	/**
	 * @param listNews
	 *            消息list
	 * @return 是否更新成功
	 */
	public int updateNews(String userNo) {
		// TODO Auto-generated method stub
		return this.sendParcelNewsDao.updateNews(userNo);
	}

	/**
	 * @param userNo
	 *            用户工号
	 * @return str
	 * @throws BusinessException
	 *             抛出异常
	 */
	public  synchronized String getPushNews(String userNo) throws BusinessException {
		Map<String, Object> mapData = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(userNo)) {
			
			// 查询需要推送的数据
			
			 List<SendParcelNewsEntity> listEntities = this.sendParcelNewsDao
						.getNews(userNo);
             
		
			// 判断list是否有数据
			if (null != listEntities && listEntities.size() > 0) {
				logger.info("有需要推送的数据>>>>>>>>>>");
				mapData.put("errorCode", 0);
				//mapData.put("count", listEntities.size());
				mapData.put("data", listEntities);
				try {
					// 对查询出来的数据在进行更新
					 updateNews(userNo);

				} catch (BusinessException e) {

					logger.info("收发室消息推送数据更新失败>>>>>>>>>>>>>>");
				}

			} else {
				//塞入数据
				mapData.put("errorCode", 1);
				//塞入数据
				mapData.put("data", "");
			}
			//返回数据
			return JsonUtil.mapToJsonString(mapData);
		} else {
			//塞入数据
			mapData.put("errorCode", 1);
			mapData.put("data", "");
			//返回数据
			return JsonUtil.mapToJsonString(mapData);
		}

	}

	/**
	 * @return dao的注入
	 */
	public ISendParcelNewsDao getSendParcelNewsDao() {
		return sendParcelNewsDao;
	}

	/**
	 * @param sendParcelNewsDao dao的注入
	 */
	public void setSendParcelNewsDao(ISendParcelNewsDao sendParcelNewsDao) {
		this.sendParcelNewsDao = sendParcelNewsDao;
	}
}
