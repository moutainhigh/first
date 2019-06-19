package com.deppon.montal.conf;

import java.util.List;

import com.deppon.montal.conf.domain.DictEntry;
import com.deppon.montal.util.redis.service.impl.InitDictEntry;

/**
 * 描述：数据字典服务类
 * @author xu.shang
 *
 */
public class DictEntryService {
	private static DictEntryService _instance;
	private DictEntryService() {
	}
	public static DictEntryService getInstance() {
		if (_instance == null) {
			 synchronized(DictEntryService.class) {
				 if (_instance == null) {
					 _instance = new DictEntryService();
				 }
			 }
		}
		return _instance;
	}
	public List<DictEntry> getDataDictEntry() {
		return null;
	}
	public List<DictEntry> getDictEntries(String dicttypeid, String dictid) {
		return InitDictEntry.getDictEntryFromRedis(dicttypeid, dictid);
	}
}
