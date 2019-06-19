
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.WFSysDataChanges;
   /** 
 * @Title: IWFSysDataChangesDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-4-11 上午9:19:35 
 * @version V1.0 
 */
public interface IWFSysDataChangesDao {
    
    /** 
     * @Title: getSysDataChangesDetail 
     * @Description:(获取数据变更申请明细) 
     * @param @param processinstid
     * @return WFSysDataChanges 返回类型 
     * @throws 
     * @date 2013-4-10 下午5:54:56 
     */
    public WFSysDataChanges getSysDataChangesDetail(String processinstid);
    
}

