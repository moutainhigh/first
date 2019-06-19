
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAChangeAndresignApply;
import com.deppon.montal.module.workitems.dao.ChangeAndresignApplyDao;
import com.deppon.montal.module.workitems.dao.IChangeAndresignApplyDao;
   /** 
 * @Title: ChangeAndresignApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-5-28 上午9:45:33 
 * @version V1.0 
 */
public class ChangeAndresignApplyService implements IChangeAndresignApplyService {
    private IChangeAndresignApplyDao dao = new ChangeAndresignApplyDao();

    @Override
    public OAChangeAndresignApply getOAChaApply(String processinstid) {

	return dao.getOAChaApply(processinstid);

    }

}

