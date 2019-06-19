
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAKouhuoApply;
import com.deppon.montal.module.workitems.dao.DetainedGoodsDao;
import com.deppon.montal.module.workitems.dao.IDetainedGoodsDao;
   /** 
 * @Title: DetainedGoodsService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-8-1 下午4:08:43 
 * @version V1.0 
 */
public class DetainedGoodsService implements IDetainedGoodsService {

	@Override
	public OAKouhuoApply getOAKouhuoApplyById(String pid) {
		IDetainedGoodsDao dao = new DetainedGoodsDao();
		return dao.getOAKouhuoApplyById(pid);
	}

}

