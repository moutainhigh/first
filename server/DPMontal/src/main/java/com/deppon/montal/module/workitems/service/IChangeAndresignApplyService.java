
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAChangeAndresignApply;
   /** 
 * @Title: IChangeAndresignApply.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (异动调动申请业务层) 
 * @author 廖建雄 
 * @date 2013-5-28 上午9:35:38 
 * @version V1.0 
 */
public interface IChangeAndresignApplyService {
    
       /** 
       * @Title: getOAChaApply 
       * @Description:(获取异动调动申请工作流详细) 
       * @param @param processinstid
       * @return OAChangeAndresignApply 返回类型 
       * @throws 
       * @date 2013-5-28 上午9:38:28 
       */
    public OAChangeAndresignApply getOAChaApply(String processinstid);

}

