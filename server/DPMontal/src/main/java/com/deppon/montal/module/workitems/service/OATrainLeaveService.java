
    package com.deppon.montal.module.workitems.service; 

import java.util.HashMap;
import java.util.Map;
import com.deppon.montal.module.workitems.dao.IOATrainLeaveDao;
import com.deppon.montal.module.workitems.dao.OATrainLeaveDao;
   /** 
 * @Title: DisCountApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(培训请假数据处理) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:50 
 * @version V1.0 
 */
public class OATrainLeaveService implements IOATrainLeaveService {
    
    IOATrainLeaveDao dao = new OATrainLeaveDao();

    @Override
    public Map getTrainLeave(String processinstid) {
	
	Map map = new HashMap<String, Object>();
	
        map.put("OATrainLeave",dao.getTrainLeave(processinstid));
        map.put("OATrainLeaveDetail",dao.getOaTrainLeaveDetails(processinstid));
	return map;
	
    }
    


}

