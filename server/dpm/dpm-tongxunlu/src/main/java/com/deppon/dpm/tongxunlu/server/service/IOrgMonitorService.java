package com.deppon.dpm.tongxunlu.server.service;

public interface IOrgMonitorService {

	void saveOrgAccessCountForUserId(String userId, String id);

	void saveSearchOrgKeywordsForUserId(String userId, String searchName);

}
