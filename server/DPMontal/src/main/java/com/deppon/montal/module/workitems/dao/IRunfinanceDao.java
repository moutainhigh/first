
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OARunfinance;
   /** 
 * @Title: IRunfinanceDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (资金运作数据层) 
 * @author 廖建雄 
 * @date 2013-6-20 下午3:00:37 
 * @version V1.0 
 */
public interface IRunfinanceDao {

    
       /** 
       * @Title: getRunfinance 
       * @Description:(获取资金运作工作流详细信息) 
       * @param @param processinstid
       * @return OARunfinance 返回类型 
       * @throws 
       * @date 2013-6-20 下午3:01:06 
       */
    public OARunfinance getRunfinance(String processinstid);
}

