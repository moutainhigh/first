
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAPlaceSublet;
import com.deppon.montal.module.workitems.dao.IOAPlaceSubletDao;
import com.deppon.montal.module.workitems.dao.OAPlaceSubletDao;
   /** 
 * @Title: OAPlaceSubletService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-28 上午11:13:22 
 * @version V1.0 
 */
public class OAPlaceSubletService implements IOAPlaceSubletService {

	@Override
	public OAPlaceSublet getOAPlaceSublet(String workId) {
		IOAPlaceSubletDao dao = new OAPlaceSubletDao();
		OAPlaceSublet oaplacesublet = dao.getOAPlaceSublet(workId);
		return oaplacesublet;
	}
}

