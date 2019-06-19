
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OADataProvideApply;
   /** 
 * @Title: IDataProvideApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (数据提供审批数据层) 
 * @author 廖建雄 
 * @date 2013-5-28 上午9:18:40 
 * @version V1.0 
 */
public interface IDataProvideApplyDao {
    
    
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

