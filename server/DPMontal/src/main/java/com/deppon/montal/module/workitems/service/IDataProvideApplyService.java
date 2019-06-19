
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OADataProvideApply;
   /** 
 * @Title: IDataProvideApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (数据提供审批业务层) 
 * @author 廖建雄 
 * @date 2013-5-28 上午9:19:11 
 * @version V1.0 
 */
public interface IDataProvideApplyService {

    /** 
     * @Title: getOADataProvideApply 
     * @Description:(获取数据提供审批工作流详细) 
     * @param @param processinstid
     * @return OADataProvideApply 返回类型 
     * @throws 
     * @date 2013-5-28 上午9:23:36 
     */
  public OADataProvideApply getOADataProvideApply(String processinstid);
}

