package com.deppon.dpm.module.common.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IAutoPunchGlobalAddressService;
import com.deppon.dpm.module.common.server.service.ILocationPermissionPcService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoPunchGlobalAddressService implements IAutoPunchGlobalAddressService {
	
	private JdbcTemplate template;
	
	/**
	 * 查询所有数据
	 */
	public List<Map<String,Object>> queryList(int begin,int limit) {
		//sql
		String sql = "SELECT id,userid FROM autoPunchGlobalAddress_permission limit ?,?";
		//执行sql
		List<Map<String,Object>> list = template.query(sql, new RowMapper<Map<String,Object>>(){
			//实现方法
			public Map<String,Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//封装对象
				Map<String,Object> appPermission = new HashMap<String,Object>();
				//编号
				appPermission.put("id", rs.getInt(1));
				//userid
				appPermission.put("userid", rs.getString(2));
				//返回
				return appPermission;
			}
			
		},begin,limit);
		
		return list;
	}
	
	/**
	 * 查询总数据条数
	 */
	public long queryCount() {
		String sql = "SELECT COUNT(1) FROM autoPunchGlobalAddress_permission";
		return template.queryForLong(sql);
	}

	/**
	 * 新增app permission信息
	 */
	public int insert(JSONObject appPermission) {
		String sql = "INSERT INTO autoPunchGlobalAddress_permission (userid) values(?)";
		return template.update(sql, appPermission.getString("userid"));
	}

	/**
	 * 修改app permission信息
	 */
	public int update(JSONObject appPermission) {
		String sql = "UPDATE autoPunchGlobalAddress_permission SET userid = ? WHERE id = ? ";

		int id = appPermission.getIntValue("id");
		String userid = appPermission.getString("userid");

		
		return template.update(sql,userid,id);
	}
	
	/**
	 * 根据应用编号删除信息
	 */
	public void deleteByApplyCodes(String applyCodes) {
		//根据,切割
		String[] codes = applyCodes.split(",");
		//健壮判断
		if(null != codes && codes.length > 0){
			//由于拼接字符串
			StringBuilder sb = new StringBuilder();
			sb.append("delete from autoPunchGlobalAddress_permission where id in(");
			//遍历
			for (String code : codes) {
				//拼接
				sb.append(code + ",");
			}
			//删除多余的,
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append(")");
			//执行sql
			template.update(sb.toString());
		}
	}

	// setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
