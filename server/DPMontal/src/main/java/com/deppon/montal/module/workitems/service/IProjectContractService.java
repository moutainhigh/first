
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OaContractApply;
   /** 
 * @Title: IProjectContractService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(项目类合同签订申请) 
 * @author 何玲菠 
 * @date 2013-7-17 上午9:16:23 
 * @version V1.0 
 */
public interface IProjectContractService {
	OaContractApply getOAContractApplyByWorkId(String workId);
}

