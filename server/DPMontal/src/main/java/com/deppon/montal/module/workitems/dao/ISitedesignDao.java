
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OASitedesign;
   /** 
 * @Title: ISitedesignDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(场地设计申请数据层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface ISitedesignDao {
    
    
       /** 
       * @Title: getSitedesign 
       * @Description:(折扣申请工作流详细) 
       * @param processinstid
       * @return OASitedesign 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public OASitedesign getSitedesign(String processinstid);
}

