
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCEntertainmentFees;
   /** 
 * @Title: IEntertainmentFeesService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (应酬费（新）业务层) 
 * @author 廖建雄 
 * @date 2013-6-7 下午3:30:59 
 * @version V1.0 
 */
public interface IEntertainmentFeesService {

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

