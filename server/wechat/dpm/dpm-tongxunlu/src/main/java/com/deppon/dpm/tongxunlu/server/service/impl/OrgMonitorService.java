package com.deppon.dpm.tongxunlu.server.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.tongxunlu.server.service.IOrgMonitorService;

public class OrgMonitorService implements IOrgMonitorService {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrgAccessCountForUserId(String userId, String orgId) {
		String sql = "INSERT INTO org_access_monitor VALUES(NULL,?,?,1,NOW(),NOW()) " + 
					"ON DUPLICATE KEY UPDATE count = count + 1,update_time = NOW()";
		jdbcTemplate.update(sql, userId,orgId);
	}
	
	@Override
	public void saveSearchOrgKeywordsForUserId(String userId, String searchName) {
		if(StringUtils.isNotBlank(searchName) && searchName.trim().length() > 1) {
			String sql = "INSERT INTO org_search_keywords_monitor VALUES(NULL,?,?,1,NOW(),NOW()) " + 
					"ON DUPLICATE KEY UPDATE count = count + 1,update_time = NOW()";
			jdbcTemplate.update(sql, userId, searchName.trim());
		}
	}

	
	/**
	 * setter
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
