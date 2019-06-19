package com.deppon.dpm.module.common.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.common.server.dao.INativePushCfgDao;
import com.deppon.dpm.module.common.server.service.INativePushCfgService;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;

public class NativePushCfgService implements INativePushCfgService{

	// 注入
	private INativePushCfgDao nativePushCfgDao;
	
	// template
	private JdbcTemplate template;
	
	// 分页查询
	public List<NativePushCfgEntity> list(int start, int rows) {
		return nativePushCfgDao.list(start,rows);
	}
	
	// 查询总条数
	public long queryCount() {
		return nativePushCfgDao.queryCount();
	}

	// 根据id删除
	public void deleteByIds(String ids) {
		
		nativePushCfgDao.deleteByIds(ids.split(","));
	}
	
	// 更新
	public void update(NativePushCfgEntity entity) {
		nativePushCfgDao.update(entity);
	}
	
	// 保存
	public void save(NativePushCfgEntity entity) {
		nativePushCfgDao.save(entity);
	}
	
	// 根据名称查询部门
	public List<Map<String, String>> queryOrgByName(String orgName) {
		String sql = "SELECT ORGNAME FROM om_organization where ORGNAME LIKE '%"+ orgName +"%'";
		List<Map<String, String>> list = template.query(sql, new RowMapper<Map<String, String>>(){
			public Map<String, String> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Map<String,String> map = new HashMap<String, String>();
				map.put("orgName", rs.getString("ORGNAME"));
				return map;
			}
		});
		return list;
	}
	
	// 查询所有有效的
	public List<NativePushCfgEntity> queryUsableAll() {
		return nativePushCfgDao.queryUsableAll();
	}
	
	// setter
	public void setNativePushCfgDao(INativePushCfgDao nativePushCfgDao) {
		this.nativePushCfgDao = nativePushCfgDao;
	}

	// setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
}
