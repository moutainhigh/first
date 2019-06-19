
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OADataProvideApply;
import com.deppon.montal.module.workitems.dao.DataProvideApplyDao;
import com.deppon.montal.module.workitems.dao.IDataProvideApplyDao;
   /** 
 * @Title: DataProvideApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description:(数据提供审批业务处理) 
 * @author 廖建雄 
 * @date 2013-5-28 上午9:19:21 
 * @version V1.0 
 */
public class DataProvideApplyService implements IDataProvideApplyService {

    private IDataProvideApplyDao dao =new DataProvideApplyDao();
    
    @Override
    public OADataProvideApply getOADataProvideApply(String processinstid) {
	  return dao.getOADataProvideApply(processinstid);
    }

}

