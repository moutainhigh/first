
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.CCEntertainmentFees;
   /** 
 * @Title: IEntertainmentFeesDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (应酬费（新）数据层) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:43:00 
 * @version V1.0 
 */
public interface IEntertainmentFeesDao {

    
       /** 
       * @Title: getFees 
       * @Description:(获取应酬费（新）工作流详细) 
       * @param @param processinstid
       * @return CCEntertainmentFees 返回类型 
       * @throws 
       * @date 2013-6-7 下午3:24:21 
       */
    public CCEntertainmentFees getFees(String processinstid);
}

