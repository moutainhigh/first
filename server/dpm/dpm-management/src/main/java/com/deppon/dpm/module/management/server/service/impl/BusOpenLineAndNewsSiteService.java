package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IBusOpenLineAndNewsSiteDao;
import com.deppon.dpm.module.management.server.service.IBusOpenLineAndNewsSiteService;
import com.deppon.dpm.module.management.shared.domain.BusOpenLineAndNewsSiteEntity;
import com.deppon.foss.framework.exception.BusinessException;
/**
 * 显示所有的建议站点信息service层实现接口
 * @author 曹嵩
 * @date 2015.7.1
 */
public class BusOpenLineAndNewsSiteService implements
		IBusOpenLineAndNewsSiteService {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusOpenLineAndNewsSiteService.class);
	/**
	 *  busOpenLineAndNewsSiteDao 注入
	 */
	private IBusOpenLineAndNewsSiteDao busOpenLineAndNewsSiteDao;
	/**
	 * @return  注入
	 */ 
	public IBusOpenLineAndNewsSiteDao getBusOpenLineAndNewsSiteDao() {
		return busOpenLineAndNewsSiteDao;
	}

	/**
	 * @param busOpenLineAndNewsSiteDao 注入
	 */
	public void setBusOpenLineAndNewsSiteDao(
			IBusOpenLineAndNewsSiteDao busOpenLineAndNewsSiteDao) {
		this.busOpenLineAndNewsSiteDao = busOpenLineAndNewsSiteDao;
	}

	/**
	 * 显示所有的建议站点信息
	 * @return list集合
	 */
	public List<BusOpenLineAndNewsSiteEntity> querySiteAll() throws BusinessException {
		//得到建议站点信息
		List<BusOpenLineAndNewsSiteEntity> bolanseList = busOpenLineAndNewsSiteDao.querySiteAll();
		try {
			//日期格式转换
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			//循环数据
			for (BusOpenLineAndNewsSiteEntity b : bolanseList) {
				//判断日期
				if(b.getCreateDate()!=null){
					b.setStrDate(sdf.format(b.getCreateDate()));
				}else{
					//没有设置为null
					b.setStrDate("");
				}
			}
		} catch (BusinessException ce) {
			logger.info("BusOpenLineAndNesSiteService-----querySiteAll---发生异常");
			//抛出异常
			ce.printStackTrace();
		}
		//打出bug
		logger.info("BusOpenLineAndNesSiteService-----querySiteAll---获取数据成功,bolanseList集合:"+bolanseList);
		//返回bolanseList
		return bolanseList;
	}

}
