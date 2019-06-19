
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.PorentCarOutside;
import com.deppon.montal.model.PorentCarOutsideEntry;
   /** 
 * @Title: IPorentCarOutsideDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (外请车数据操作) 
 * @author 廖建雄 
 * @date 2013-4-15 下午2:09:36 
 * @version V1.0 
 */
public interface IPorentCarOutsideDao {
    
    
       /** 
       * @Title: getCarOutsideInfo 
       * @Description:(获取外请车明细) 
       * @param @param processinstid
       * @return PorentCarOutside 返回类型 
       * @throws 
       * @date 2013-4-15 下午2:18:21 
       */
    public PorentCarOutside getCarOutsideInfo(String processinstid);
    
       /** 
       * @Title: getCarOutsideEntry 
       * @Description:TODO(获取外请车附属详细内容) 
       * @param @param processinstid
       * @return List<PorentCarOutsideEntry> 返回类型 
       * @throws 
       * @date 2013-4-15 下午2:18:23 
       */
    public List<PorentCarOutsideEntry> getCarOutsideEntry(String processinstid);
}

