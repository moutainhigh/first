
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.PorentCarOutside;
import com.deppon.montal.model.PorentCarOutsideEntry;
import com.deppon.montal.module.workitems.dao.IPorentCarOutsideDao;
import com.deppon.montal.module.workitems.dao.PorentCarOutsideDao;

/** 
 * @Title: PorentCarOutsideDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (外请车数据操作) 
 * @author 廖建雄 
 * @date 2013-4-15 下午2:10:42 
 * @version V1.0 
 */
public class PorentCarOutsideService implements IPorentCarOutsideService {
    IPorentCarOutsideDao dao = new PorentCarOutsideDao();
    @Override
    public PorentCarOutside getCarOutsideInfo(String processinstid) {
	return dao.getCarOutsideInfo(processinstid);
    }

    @Override
    public List<PorentCarOutsideEntry> getCarOutsideEntry(String processinstid) {
	return dao.getCarOutsideEntry(processinstid);
    }
   
}

