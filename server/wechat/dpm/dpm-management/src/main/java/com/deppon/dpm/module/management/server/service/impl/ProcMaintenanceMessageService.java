package com.deppon.dpm.module.management.server.service.impl;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.management.server.dao.IProcMaintenanceInfoListDao;
import com.deppon.dpm.module.management.server.service.IProcMaintenanceMessageService;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;

/**
 * 工程维修已退回和自行维修消息推送service层.
 * 
 * @author 曹嵩
 *         <p>
 *         时间:2015.10.9
 *         </P>
 */
public class ProcMaintenanceMessageService implements
		IProcMaintenanceMessageService {

	/**
	 * 日志
	 */
	private static Logger logger = Logger
			.getLogger(ProcMaintenanceMessageService.class);

	/**
	 * 推送消息方法
	 */
	private TpushNewsService tpushNewsService;

	/**
	 * dao的注入
	 */
	private IProcMaintenanceInfoListDao procMaintenanceInfoListDao;

	/**
	 * @return  推送消息方法
	 */
	public TpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}

	/**
	 * @param tpushNewsService 推送消息方法
	 */
	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	/**
	 * @return dao的注入
	 */
	public IProcMaintenanceInfoListDao getProcMaintenanceInfoListDao() {
		return procMaintenanceInfoListDao;
	}

	/**
	 * @param procMaintenanceInfoListDao dao的注入
	 */
	public void setProcMaintenanceInfoListDao(
			IProcMaintenanceInfoListDao procMaintenanceInfoListDao) {
		this.procMaintenanceInfoListDao = procMaintenanceInfoListDao;
	}
	private final int PROCMAINTENANCE_STATUS = 8;

	/**
	 * 工程维修消息推送.
	 * @param self 0:非自行维修,1:自行维修
	 * @param bill 单号
	 * @param status -1:退回,0:审核中
	 */
	public void getProcMainMessage(int self, String bill, int status) {

		logger.info("进入工程维修已退回和自行维修消息推送service层的方法getProcMainMessage");
		
		//工程维修状态

		// 自行维修消息体
		String  selfServicIng  = "工作流号为:" + bill + "的维修申请以审批完毕，请自行维修.";

		// 已退回消息体
		String  hasBeanRet  = "工作流号为:" + bill + "的维修申请被退回，请及时处理.";

		logger.info("self:" + self + ";bill:" + bill + ";status:" + status);
		logger.info("自行维修消息体:" + selfServicIng);
		logger.info("已退回消息体:" + hasBeanRet);
		NewsCenterEntity nce = null;
		try {
			//掉门户类
			nce = new NewsCenterEntity("14", PROCMAINTENANCE_STATUS, 0, 1, "工程维修");

			// 得到工号
			String userNo = procMaintenanceInfoListDao.getUserNo(bill);
			logger.info("工号为:" + userNo);
			// 0:非自行维修,1:自行维修
			if (self == 1) { 
				// 如果为自行维修推送消息
				tpushNewsService.pushUserNews(userNo, "工程维修通知", selfServicIng,
						nce);
			} // 否则不做处理.
			// -1:退回,0:审核中
			if (status == -1) { 
				// 如果为退回推送消息
				tpushNewsService.pushUserNews(userNo, "工程维修通知",
						hasBeanRet, nce);
			}// 否则不做处理.

			logger.info("工程维修推送消息成功.");
		} catch (Exception e) {
			logger.info("工程维修消息推送异常.");
			e.printStackTrace();
		}

	}

}
