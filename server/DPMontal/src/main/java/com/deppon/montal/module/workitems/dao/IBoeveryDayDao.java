
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.CCBoeveryDay;
   /** 
 * @Title: IBoeveryDayDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(日常（新）工作流数据层) 
 * @author 廖建雄 
 * @date 2013-6-6 上午11:40:38 
 * @version V1.0 
 */
public interface IBoeveryDayDao {

    
       /** 
       * @Title: getBoeveryDayInfo 
       * @Description:(获取日常（新）工作流详细) 
       * @param @param processinstid
       * @return CCBoeveryDay 返回类型 
       * @throws 
       * @date 2013-6-6 上午11:47:16 
       */
    public CCBoeveryDay getBoeveryDayInfo(String processinstid);
}

