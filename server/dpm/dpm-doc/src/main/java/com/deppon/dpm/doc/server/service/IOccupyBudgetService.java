package com.deppon.dpm.doc.server.service;

import com.deppon.dpm.doc.server.entity.DDOrderRequestEntity;
import com.deppon.dpm.doc.server.entity.OccupyBudgetResponseEntity;
import com.deppon.dpm.doc.server.entity.OccupyBudgetRquestEntity;

/**
 * 预算占用接口服务类
 * @author wanc
 * 20171128
 *
 */
public interface IOccupyBudgetService {
	/**
	 * 更新预算接口方法
	 * @param rqentity
	 * @return
	 */
	public OccupyBudgetResponseEntity updateBudget(OccupyBudgetRquestEntity rqentity);
	
	/**
	 * 无应答状态订单更新预算凭证
	 * @param rqentity
	 * @return
	 */
	public OccupyBudgetResponseEntity noRespCertif(DDOrderRequestEntity rqentity);
	
	/**
	 * 余额推送消息
	 * @param rqentity
	 * @return
	 */
	public void pushMessageMethord(OccupyBudgetRquestEntity rqentity);
	
}
