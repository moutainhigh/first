package com.deppon.dpm.module.management.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IReserveManageCancelDao;
import com.deppon.dpm.module.management.server.service.IReserveManageCancelService;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
/**
 * 预订管理羽毛球和瑜伽室的取消预订和提前结束service实现类.
 * @author 曹嵩
 * <p>时间:2015.10.20</p>
 */
public class ReserveManageCancelService implements IReserveManageCancelService {
	/**
	 * 日志.
	 */
	private static Logger logger = LoggerFactory.getLogger(ReserveManageCancelService.class);
	
	/**
	 *  reserveManageCancelDao 注入
	 */
	private IReserveManageCancelDao reserveManageCancelDao;

	/**
	 * @return 注入
	 */
	public IReserveManageCancelDao getReserveManageCancelDao() {
		return reserveManageCancelDao;
	}

	/**
	 * @param reserveManageCancelDao 注入
	 */
	public void setReserveManageCancelDao(
			IReserveManageCancelDao reserveManageCancelDao) {
		this.reserveManageCancelDao = reserveManageCancelDao;
	}

	/**
	 * 修改状态并且修改当前时间根据id.
	 * @param status 状态0 –预定 1-取消预定 2-提前结束预定
	 * @param id 编号
	 */
	public int updateState(int status,int id) {
		logger.info("进入预订管理羽毛球和瑜伽室的取消预订和提前结束方法ReserveManageCancelService");
		logger.info("status:"+status+",id:"+id);
		//new一个实体类
		ReserveRecordEntity rre = new ReserveRecordEntity();
		//塞入数据
		rre.setStatus(status);
		//塞入数据
		rre.setId(id);
		//设置 result
		int result = 0;
		try {
			//修改状态
			result = reserveManageCancelDao.updateState(rre);
			//判断状态值
			if(result>0){
				logger.info("修改成功");
			}else{
				logger.info("修改失败");
			}
			logger.info("操作执行完,没有异常");
		} catch (Exception e) {
			logger.info("修改出现异常");
			//抛出异常
			e.printStackTrace();
		}
		//返回结果
		return result;
	}

}
