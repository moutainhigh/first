package com.deppon.dpm.module.common.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IQuickContactPcService;

public class QuickContactPcService implements IQuickContactPcService{
	
	private JdbcTemplate template;
	
	/**
	 * 查询所有数据
	 */
	public List<Map<String,Object>> queryList(int begin,int limit) {
		//sql
		String sql = "SELECT id,empName,empCode,Content FROM om_normal_question_handle limit ?,?";
		//执行sql
		List<Map<String,Object>> list = template.query(sql, new RowMapper<Map<String,Object>>(){
			//实现方法
			public Map<String,Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//封装对象
				Map<String,Object> hotLine = new HashMap<String,Object>();
				//编号
				hotLine.put("id", rs.getInt(1));
				//姓名
				hotLine.put("empName", rs.getString(2));
				//工号
				hotLine.put("empCode", rs.getString(3));
				//内容
				hotLine.put("content", rs.getString(4));
				//返回
				return hotLine;
			}
			
		},begin,limit);
		
		return list;
	}
	
	/**
	 * 查询总数据条数
	 */
	public long queryCount() {
		String sql = "SELECT COUNT(1) FROM om_normal_question_handle";
		return template.queryForLong(sql);
	}

	/**
	 * 新增app permission信息
	 */
	public int insert(JSONObject hotLine) {
		String sql = "INSERT INTO om_normal_question_handle (id,empName,empCode,Content) SELECT max(id)+1,?,?,? FROM om_normal_question_handle";
		return template.update(sql, hotLine.getString("empName"),hotLine.getString("empCode"),hotLine.getString("Content"));
	}

	/**
	 * 修改app permission信息
	 */
	public int update(JSONObject hotLine) {
		String sql = "UPDATE om_normal_question_handle SET empCode = ?,empName = ?,Content = ? WHERE id = ? ";
		String name = hotLine.getString("empCode");
		String phone = hotLine.getString("empName");
		String content = hotLine.getString("Content");
		int id = hotLine.getIntValue("id");
		
		return template.update(sql, name,phone,content,id);
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
			sb.append("delete from om_normal_question_handle where id in(");
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
