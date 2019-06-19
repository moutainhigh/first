
    package com.deppon.montal.module.workitems.service; 


import com.deppon.montal.model.OASiteFindPlaceApply;
import com.deppon.montal.module.workitems.dao.IOASiteFindPlaceApplyDao;
import com.deppon.montal.module.workitems.dao.OASiteFindPlaceApplyDao;


   /** 
   * @ClassName: OASiteFindPlaceApplyService 
   * @Description:(这里用一句话描述这个类的作用) 
   * @author 廖建雄 
   * @date 2013-8-26 上午9:00:27 
   * 
   */
public class OASiteFindPlaceApplyService implements IOASiteFindPlaceApplyService {
    IOASiteFindPlaceApplyDao dao = new OASiteFindPlaceApplyDao();
    @Override
    public OASiteFindPlaceApply getSiteFindPlaceApply(String processinstid) {
	return dao.getSiteFindPlaceApply(processinstid);
    }
}

