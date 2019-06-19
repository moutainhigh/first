
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OASiteFindPlaceApply;



  

   /** 
   * @ClassName: IOASiteFindPlaceApplyDao 
   * @Description:(场地找点业务层) 
   * @author 廖建雄 
   * @date 2013-8-26 上午8:50:46 
   * 
   */
public interface IOASiteFindPlaceApplyService {
    
  

   /** 
   * @Title: getSiteFindPlaceApply 
   * @Description:(获取场地找点工作流详细信息) 
   * @param @param processinstid
   * @return OASiteFindPlaceApply 返回类型 
   * @throws 
   * @date 2013-8-26 上午8:50:44 
   */
public OASiteFindPlaceApply getSiteFindPlaceApply(String processinstid);


}

