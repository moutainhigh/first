
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.OAaddAttendance;
   /** 
 * @Title: IOAaddAttendanceDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (补考勤工作流业务数据层) 
 * @author 廖建雄 
 * @date 2013-4-27 上午9:57:11 
 * @version V1.0 
 */
public interface IOAaddAttendanceDao {

    
       /** 
       * @Title: getAddAttendanceInfo 
       * @Description:(获取补考勤工作流明细) 
       * @param @param processinstid
       * @return OAaddAttendance 返回类型 
       * @throws 
       * @date 2013-4-27 上午10:48:08 
       */
    public OAaddAttendance getAddAttendanceInfo(String processinstid);
}

