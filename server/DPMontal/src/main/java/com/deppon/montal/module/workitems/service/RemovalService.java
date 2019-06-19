
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OARemoval;
import com.deppon.montal.module.workitems.dao.IRemovalDao;
import com.deppon.montal.module.workitems.dao.RemovalDao;
   /** 
 * @Title: RemovalService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(新点开设/旧点搬迁) 
 * @author 何玲菠 
 * @date 2013-7-16 下午2:01:54 
 * @version V1.0 
 */
public class RemovalService implements IRemovalService {

	@Override
	public OARemoval getOAremovalByWorkId(String workId) {
		IRemovalDao dao = new RemovalDao();
		return dao.getOARemoval(workId);
	}

}

