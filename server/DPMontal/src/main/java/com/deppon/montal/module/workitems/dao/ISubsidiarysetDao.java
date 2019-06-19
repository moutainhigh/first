
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OASubSidiarySet;
   /** 
 * @Title: ISubsidiarysetDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(子公司设立及变更申请dao层) 
 * @author 何玲菠 
 * @date 2013-7-16 上午9:39:38 
 * @version V1.0 
 */
public interface ISubsidiarysetDao {
	OASubSidiarySet getOASubsidiaryset(String pid);
}

