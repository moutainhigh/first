
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.model.WFSysDataChanges;
   /** 
 * @Title: IOmEemployeeDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(操作用户数据类) 
 * @author 廖建雄 
 * @date 2013-4-11 上午9:19:35 
 * @version V1.0 
 */
public interface IOmEmployeeDao {
    
       /** 
       * @Title: getApprover 
       * @Description:(获取开发员审批人) 
       * @param @param user
       * @return List<OmEmployee> 返回类型 
       * @throws 
       * @date 2013-4-11 上午11:05:23 
       */
    public List<OmEmployee> getDevApprover(LoginUser user);
    
    
       /** 
       * @Title: getDevManageApprover 
       * @Description:(获取开发经理审批人) 
       * @param @param user
       * @returnList<OmEmployee> 返回类型 
       * @throws 
       * @date 2013-4-11 下午4:16:01 
       */
    public List<OmEmployee> getDevManageApprover(LoginUser user);
}

