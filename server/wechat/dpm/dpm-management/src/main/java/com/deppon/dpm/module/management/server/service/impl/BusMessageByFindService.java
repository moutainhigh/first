package com.deppon.dpm.module.management.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IBusMessageByFindDao;
import com.deppon.dpm.module.management.server.service.IBusMessageByFindService;
import com.deppon.dpm.module.management.shared.domain.BusMessageEntity;
/**
 * 显示新增消息信息的service层实现接口
 * @author 曹嵩
 * @date 2015.06.29
 *
 */
public class BusMessageByFindService implements IBusMessageByFindService {
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusMessageByFindService.class);
	//注入dao
	private IBusMessageByFindDao busMessageByFindDao;
	
    //get set
	public IBusMessageByFindDao getBusMessageByFindDao() {
		return busMessageByFindDao;
	}


	 //get set
	public void setBusMessageByFindDao(IBusMessageByFindDao busMessageByFindDao) {
		this.busMessageByFindDao = busMessageByFindDao;
	}

    //得到班车数据
	@Override
	public List<BusMessageEntity> getBusMessageByFind() throws Exception {
		//返回班车数据
		return busMessageByFindDao.getBusMessageByFind();
	}

}
