
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OASubSidiarySet;
   /** 
 * @Title: ISubsidiarysetService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(子公司设立及变更申请service接口) 
 * @author 何玲菠 
 * @date 2013-7-16 上午10:07:19 
 * @version V1.0 
 */
public interface ISubsidiarysetService {
	OASubSidiarySet getOASubsidiarysetByWorkId(String workId);
}

