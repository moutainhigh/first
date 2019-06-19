package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IProcScoreMessageDao;
import com.deppon.dpm.module.management.server.service.IProcScoreMessageService;
import com.deppon.dpm.module.management.shared.domain.ProcScoreMessageEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 根据id查找评分详细的service层实现接口.
 * @author 曹嵩
 * 2015.7.17
 * 
 */
public class ProcScoreMessageService implements IProcScoreMessageService {

	/**
	 * 日志.
	 */
	private Logger logger = LoggerFactory.getLogger(ProcScoreMessageService.class);

	/**
	 * procScoreMessageDao 注入
	 */
	private IProcScoreMessageDao procScoreMessageDao;

	/**
	 * @return procScoreMessageDao
	 */
	public IProcScoreMessageDao getProcScoreMessageDao() {
		return procScoreMessageDao;
	}

	/**
	 * @param procScoreMessageDao procScoreMessageDao
	 */
	public void setProcScoreMessageDao(IProcScoreMessageDao procScoreMessageDao) {
		this.procScoreMessageDao = procScoreMessageDao;
	}
	/**
	 * 根据id查找评分详细信息
	 * @param id 页面传过来的id
	 * @return 评分详细信息
	 */
	public List<Object> queryprocScoreMess(String id)
			throws BusinessException {
		logger.info(">>>>>>>>>进入到ProcScoreMessageService接口的queryprocScoreMess方法,传过来的id:"
				+ id);
        //根据id查找评分详细信息
		ProcScoreMessageEntity psme = procScoreMessageDao
				.queryProcScoreMessById(id);
		//new objList
		List<Object> objList = new ArrayList<Object>();
		List<Object> deductSprojectList = new ArrayList<Object>();
		List<Object> serviceItemsList = new ArrayList<Object>();
		Map<String, Object> mapList = new HashMap<String, Object>();
        //判断对象是否为null
		if (psme != null) {
			// 将扣分项目分割出来保存到map集合里面
			String[] deductSproject = psme.getDeductSproject().split("\\|");
			//logger.info("deductSproject分割后为:" + deductSproject);
			for (int i = 0; i < deductSproject.length; i++) {
				deductSprojectList.add(deductSproject[i]);
			}
			//map塞入数据
			mapList.put("deductSproject", deductSprojectList);

			// 将维修事项分割出来保存到map集合里面
			String[] serviceItems = psme.getServiceItems().trim().split("\\|");
			//logger.info("serviceItems分割后为:" + serviceItems);
			for (int i = 0; i < serviceItems.length; i++) {
				serviceItemsList.add(serviceItems[i]);
			}
			//塞入数据
			mapList.put("serviceItems", serviceItemsList);
			//塞入数据
			objList.add(mapList);
			objList.add(psme);
		} else {
			logger.info("psme实体类为null");
		}
		//返回数据
		return objList;
	}

}
