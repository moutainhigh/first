
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OADataRequireApply;
   /** 
 * @Title: IOADataRequireApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(数据需求审批流程数据层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface IOADataRequireApplyDao {
    
    
       /** 
       * @Title: getDataRequireApply 
       * @Description:(数据需求审批流程工作流详细) 
       * @param processinstid
       * @return OAdisCountApply 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public OADataRequireApply getDataRequireApply(String processinstid);
}

