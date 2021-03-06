
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OABorrowsealApply;
   /** 
 * @Title: IBorrowsealApplyDao.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (借章申请业务层) 
 * @author 廖建雄 
 * @date 2013-6-26 下午2:01:51 
 * @version V1.0 
 */
public interface IBorrowsealApplyService {
    
    
       /** 
       * @Title: getBorrowsealApply 
       * @Description:(获取借章申请工作流详细信息) 
       * @param @param processinstid
       * @return OABorrowsealApply 返回类型 
       * @throws
       * @date 2013-6-26 下午2:03:21 
       */
    public OABorrowsealApply getBorrowsealApply(String processinstid);

}

