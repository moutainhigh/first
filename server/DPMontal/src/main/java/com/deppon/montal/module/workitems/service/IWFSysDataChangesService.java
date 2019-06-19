
    package com.deppon.montal.module.workitems.service; 

import java.util.Map;

import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.WFSysDataChanges;
   /** 
 * @Title: IWFSysDataChangesService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(数据变更申请) 
 * @author 廖建雄 
 * @date 2013-4-10 下午4:22:12 
 * @version V1.0 
 */
public interface IWFSysDataChangesService {
    
       /** 
       * @Title: getSysDataChangesDetail 
       * @Description:(获取数据变更申请明细) 
       * @param @param processinstid
       * @return WFSysDataChanges 返回类型 
       * @throws 
       * @date 2013-4-10 下午5:54:56 
       */
    public WFSysDataChanges getSysDataChangesDetail(String processinstid);
    
       /** 
       * @Title: getApprover 
       * @Description:(获取可选择的下一个节点审批人员) 
       * @return Map 返回类型 （开发人员集合，开发经理集合）
       * @throws 
       * @date 2013-4-10 下午5:54:58 
       */
    public Map getApprover(LoginUser user);

}

