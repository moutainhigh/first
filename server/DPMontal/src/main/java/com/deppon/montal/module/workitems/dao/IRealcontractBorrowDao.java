
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OARealcontractBorrow;
   /** 
 * @Title: IRealcontractBorrowDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (实体合同借阅数据层) 
 * @author 廖建雄 
 * @date 2013-5-14 上午9:12:35 
 * @version V1.0 
 */
public interface IRealcontractBorrowDao {
    
       /** 
       * @Title: getOARealcontractBorrowInfo 
       * @Description:(获取实体合同借阅工作流详细) 
       * @param @param processinstid
       * @return OARealcontractBorrow 返回类型 
       * @throws 
       * @date 2013-5-14 上午9:26:50 
       */
    public OARealcontractBorrow getOARealcontractBorrowInfo(String processinstid);
}

