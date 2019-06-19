
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.CCBoeveryDay;
import com.deppon.montal.module.workitems.dao.BoeveryDayDao;
import com.deppon.montal.module.workitems.dao.IBoeveryDayDao;
/** 
 * @Title: BoeveryDayService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: (日常（新）工作流业务处理) 
 * @author 廖建雄 
 * @date 2013-6-6 下午2:25:25 
 * @version V1.0 
 */
public class BoeveryDayService implements IBoeveryDayService {
    
    IBoeveryDayDao dao = new BoeveryDayDao();
    @Override
    public CCBoeveryDay getBoeveryDayInfo(String processinstid) {
	
	return dao.getBoeveryDayInfo(processinstid);
    }

}

