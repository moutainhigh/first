
    package com.deppon.montal.module.workitems.service; 

import java.util.Map;

 /** 
 * @Title: IOAaddAttendanceService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (补考勤工作流业务处理) 
 * @author 廖建雄 
 * @date 2013-4-27 上午11:02:36 
 * @version V1.0 
 */
public interface IOAaddAttendanceService {

    
       /** 
       * @Title: getAddAttendanceInfo 
       * @Description:(获取补考勤工作流明细) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @return Map 返回类型 
       * @throws 
       * @date 2013-4-27 上午11:03:48 
       */
    public Map<String,Object> getAddAttendanceInfo(String processinstid);
}

