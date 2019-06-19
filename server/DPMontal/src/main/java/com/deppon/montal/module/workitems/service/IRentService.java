
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.CCPorent;
   import com.deppon.montal.model.CCPorentEntry;
/** 
 * @Title: IRentService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(房租service接口) 
 * @author 何玲菠 
 * @date 2013-5-28 上午9:10:37 
 * @version V1.0 
 */
public interface IRentService {
	public CCPorent queryRentByWorkId(String workId);
	public List<CCPorentEntry> queryRentEntryByWorkId(String workId);
}

