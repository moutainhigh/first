
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.OATrainLeave;
import com.deppon.montal.model.OATrainLeaveDetail;
   /** 
 * @Title: IOATrainLeaveDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(培训请假数据层) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:31 
 * @version V1.0 
 */
public interface IOATrainLeaveDao {
    
    
       /** 
       * @Title: getTrainLeave 
       * @Description:(培训请假流程工作流详细) 
       * @param processinstid
       * @return OATrainLeave 返回类型 
       * @throws 
       * @date 2013-7-16 下午3:29:46 
       */
    public OATrainLeave getTrainLeave(String processinstid);
    /** 
     * @Title: getOaTrainLeaveDetails 
     * @Description:(培训请假流程工作流业务明细) 
     * @param processinstid
     * @return List<OATrainLeaveDetail> 返回类型 
     * @throws 
     * @date 2013-7-16 下午3:29:46 
     */
    public List<OATrainLeaveDetail> getOaTrainLeaveDetails(String processinstid);
}

