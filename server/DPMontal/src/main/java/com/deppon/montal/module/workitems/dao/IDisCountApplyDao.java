
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAdisCountApply;
   /** 
 * @Title: IDisCountApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(折扣申请数据层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface IDisCountApplyDao {
    
    
       /** 
       * @Title: getDisCountApply 
       * @Description:(折扣申请工作流详细) 
       * @param processinstid
       * @return OAdisCountApply 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public OAdisCountApply getDisCountApply(String processinstid);
}

