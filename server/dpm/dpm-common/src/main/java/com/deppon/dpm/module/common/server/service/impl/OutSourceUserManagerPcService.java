package com.deppon.dpm.module.common.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IOutSourceUserManagerPcService;

public class OutSourceUserManagerPcService implements IOutSourceUserManagerPcService{
	
	private JdbcTemplate template;
	
	/**
	 * 查询所有数据
	 */
	public List<Map<String,Object>> queryList(int begin,int limit) {
		//sql
		String sql = "SELECT s_id,staff_id,staff_name,phone,passwd FROM outsource_user limit ?,?";
		//执行sql
		List<Map<String,Object>> list = template.query(sql, new RowMapper<Map<String,Object>>(){
			//实现方法
			public Map<String,Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//封装对象
				Map<String,Object> user = new HashMap<String,Object>();
				//s_id
				user.put("id", rs.getInt(1));
				//staff_id
				user.put("staff_id", rs.getString(2));
				//staff_name
				user.put("staff_name", rs.getString(3));
				//staff_name
				user.put("phone", rs.getString(4));
				//passwd
				user.put("passwd", rs.getString(5));
				//返回
				return user;
			}
			
		},begin,limit);
		
		return list;
	}
	
	/**
	 * 查询总数据条数
	 */
	public long queryCount() {
		String sql = "SELECT COUNT(1) FROM outsource_user";
		return template.queryForLong(sql);
	}

	/**
	 * 新增outsource user信息
	 */
	public int insert(JSONObject appPermission) {
		//String sql = "INSERT INTO app_permission (appid,orgid,userid,level,status) values(?,?,?,?,'on')";
		/*return template.update(sql, appPermission.getIntValue("appid"),appPermission.getIntValue("orgid"),
							appPermission.getString("userid"),appPermission.getString("level"));*/
		return 0;
	}

	/**
	 * 修改outsource user信息
	 */
	public int update(JSONObject user) {
		String sql = "UPDATE outsource_user SET passwd = ? WHERE staff_id = ? ";
		String staff_id = user.getString("staff_id");
		String passwd = user.getString("passwd");
		
		return template.update(sql,passwd,staff_id);
	}
	
	/**
	 * 根据应用编号删除信息
	 */
	public void deleteByApplyCodes(String applyCodes) {
		
	}
	
	/**
	 * judge password is strong or not
	 * */
	public boolean isWeakPassword(String encoded_password){
		String sql = "SELECT count(*) FROM weak_password WHERE password = ?;";
		boolean isWeak = template.queryForInt(sql, encoded_password) > 0 ? true : false;
		return isWeak;
	}

	// setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
