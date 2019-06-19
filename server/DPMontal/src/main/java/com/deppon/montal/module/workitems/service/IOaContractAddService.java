package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OaContractAdd;

public interface IOaContractAddService {
	/**
	 * @获取月结客户签订工作流详细信息
	 * @param processinstid 工作流号
	 * @return
	 */
	public OaContractAdd getContractAdd(String processinstid);
}
