
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OADismissal;
   /** 
 * @Title: IDismissalDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (免职申请数据层) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:01:51 
 * @version V1.0 
 */
public interface IDismissalDao {
    
    
       /** 
       * @Title: getDismissal 
       * @Description:(获取免职申请工作流详细信息) 
       * @param @param processinstid
       * @return OADismissal 返回类型 
       * @throws
       * @date 2013-6-26 下午2:03:21 
       */
    public OADismissal getDismissal(String processinstid);

}

