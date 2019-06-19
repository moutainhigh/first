
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCPorent;
import com.deppon.montal.model.CCPorentEntry;
import com.deppon.montal.module.workitems.dao.IRentDao;
import com.deppon.montal.module.workitems.dao.RentDao;
   /** 
 * @Title: RentService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-5-28 上午9:13:26 
 * @version V1.0 
 */
public class RentService implements IRentService {
	private IRentDao dao = new RentDao();
	@Override
	public CCPorent queryRentByWorkId(String workId) {
		return dao.queryRentByWorkId(workId);
	}

	@Override
	public List<CCPorentEntry> queryRentEntryByWorkId(String workId) {
		return dao.queryRentEntryByWorkId(workId);
	}
}

