package com.deppon.dpm.module.common.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IAppPermissionPcService;
import com.deppon.dpm.module.common.server.service.ILocationPermissionPcService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationPermissionPcService implements ILocationPermissionPcService {
	
	private JdbcTemplate template;
	
	/**
	 * 查询所有数据
	 */
	public List<Map<String,Object>> queryList(int begin,int limit) {
		//sql
		String sql = "SELECT id,orgid,userid,level,status FROM location_permission limit ?,?";
		//执行sql
		List<Map<String,Object>> list = template.query(sql, new RowMapper<Map<String,Object>>(){
			//实现方法
			public Map<String,Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//封装对象
				Map<String,Object> appPermission = new HashMap<String,Object>();
				//编号
				appPermission.put("id", rs.getInt(1));
				//orgid
				appPermission.put("orgid", rs.getInt(2));
				//userid
				appPermission.put("userid", rs.getString(3));
				//level
				appPermission.put("level", rs.getString(4));
				//status
				appPermission.put("status", rs.getString(5));
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
		String sql = "SELECT COUNT(1) FROM location_permission";
		return template.queryForLong(sql);
	}

	/**
	 * 新增app permission信息
	 */
	public int insert(JSONObject appPermission) {
		String sql = "INSERT INTO location_permission (orgid,userid,level,status) values(?,?,?,'on')";
		return template.update(sql, appPermission.getIntValue("orgid"),
							appPermission.getString("userid"),appPermission.getString("level"));
	}

	/**
	 * 修改app permission信息
	 */
	public int update(JSONObject appPermission) {
		String sql = "UPDATE location_permission SET orgid = ?,userid = ?,status = ?,level = ? WHERE id = ? ";

		int orgid = appPermission.getIntValue("orgid");
		int id = appPermission.getIntValue("id");
		String status = appPermission.getString("status");
		String userid = appPermission.getString("userid");
		String level = appPermission.getString("level");
		
		return template.update(sql,orgid,userid,status,level,id);
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
			sb.append("delete from location_permission where id in(");
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
