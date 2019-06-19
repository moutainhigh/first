package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IBusRedPointDao;
import com.deppon.dpm.module.management.server.service.IBusRedPointService;
/**
 * 显示用户评价表与开线建议表中间表的总数、评价管理建议回复表总数、评价管理评价回复表总数的service层接口
 * @author 曹嵩
 * @date 2015.7.3
 */
public class BusRedPointService implements IBusRedPointService {
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusRedPointService.class);
	
	/**
	 * dao的注入
	 */
	private IBusRedPointDao busRedPointDao;

	/**
	 * @return dao的注入
	 */
	public IBusRedPointDao getBusRedPointDao() {
		return busRedPointDao;
	}

	/**
	 * @param busRedPointDao dao的注入
	 */
	public void setBusRedPointDao(IBusRedPointDao busRedPointDao) {
		this.busRedPointDao = busRedPointDao;
	}


	/**
	 * 得到小红点的总数
	 * @param isAdmin 是否是管理员
	 * @return 总数
	 * @throws Exception
	 */
	public Map<String, Integer> getCount(String isAdmin,String userId) throws Exception {
		int totalCount=0;
		//设置map
		Map<String, Integer> mapList = new HashMap<String, Integer>();
		try {
			logger.info("-----BusRedPointService-----接收的类型为isAdmin:"+isAdmin);
			//如果是管理员
			if(isAdmin.equals("true")){
				mapList.put("count", busRedPointDao.getBusCentreAdviceByCount(userId)) ;
			}else{//否则为非管理员
				//评价管理建议回复表的总数
				int count1 = busRedPointDao.getBusEvaluationAdviceByCount(userId);
				//评价管理评价回复表的总数
				int count2 = busRedPointDao.getBusEvaluationManageByCount(userId);
				//算总数
				totalCount = count1 + count2;
				logger.info("-----BusRedPointService------得到的总数totalCount:"+totalCount);
				//放入map
				mapList.put("count", totalCount);
			}
		} catch (Exception ce) {
			logger.info("-----BusRedPointService------出现异常"+ce);
			ce.printStackTrace();
		}
		//返回数据
		return mapList;
	}

}
