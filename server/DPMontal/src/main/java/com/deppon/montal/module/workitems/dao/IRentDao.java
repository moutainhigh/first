
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.CCPorent;
   import com.deppon.montal.model.CCPorentEntry;
/** 
 * @Title: IRentDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(房租dao层接口) 
 * @author 何玲菠 
 * @date 2013-5-28 上午9:04:48 
 * @version V1.0 
 */
public interface IRentDao {
	public CCPorent queryRentByWorkId(String workId);
	public List<CCPorentEntry> queryRentEntryByWorkId(String workId);
}

