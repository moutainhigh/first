
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAMarketingActivities;
   /** 
 * @Title: IMarketingActivitiesDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(营销活动申请数据层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface IMarketingActivitiesDao {
    
    
       /** 
       * @Title: getMarketingActivitiesInfo 
       * @Description:(获取营销活动申请工作流详细) 
       * @param processinstid
       * @return OAMarketingActivities 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public OAMarketingActivities getMarketingActivitiesInfo(String processinstid);
}

