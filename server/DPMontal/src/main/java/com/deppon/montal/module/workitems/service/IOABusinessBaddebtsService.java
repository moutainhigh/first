
    package com.deppon.montal.module.workitems.service; 

import java.util.Map;

 

   /** 
   * @ClassName: IOABusinessBaddebtsService 
   * @Description:(业务类坏账申请业务层) 
   * @author 廖建雄 
   * @date 2013-8-5 下午2:07:53 
   * 
   */
public interface IOABusinessBaddebtsService {
    
    
       /** 
       * @Title: getBusinessBaddebt 
       * @Description:(获取业务类坏账申请工作流详细) 
       * @param @param processinstid
       * @return Map 返回类型 
       * @throws 
       * @date 2013-8-5 下午2:42:15 
       */
    public Map getBusinessBaddebt(String processinstid);
}

