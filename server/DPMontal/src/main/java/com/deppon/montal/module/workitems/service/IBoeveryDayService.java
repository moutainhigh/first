
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCBoeveryDay;
   /** 
 * @Title: IBoeveryDayService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (日常（新）工作流业务层) 
 * @author 廖建雄 
 * @date 2013-6-6 下午2:25:13 
 * @version V1.0 
 */
public interface IBoeveryDayService {
    
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

