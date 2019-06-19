
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OaContractApply;
   /** 
 * @Title: IProjectContractApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(项目类合同申请) 
 * @author 何玲菠 
 * @date 2013-7-17 上午8:56:55 
 * @version V1.0 
 */
public interface IProjectContractApplyDao {
	OaContractApply getOAContractApplyByWorkId(String workId);
}

