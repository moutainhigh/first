package com.deppon.dpm.module.common.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IHxQuestionPcService;

public class HxQuestionPcService implements IHxQuestionPcService{
	
	private JdbcTemplate template;
	
	/**
	 * 查询所有数据
	 */
	public List<Map<String,Object>> queryList(int begin,int limit) {
		//sql
		String sql = "SELECT question_id,question,answer FROM om_hx_question limit ?,?";
		//执行sql
		List<Map<String,Object>> list = template.query(sql, new RowMapper<Map<String,Object>>(){
			//实现方法
			public Map<String,Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//封装对象
				Map<String,Object> question = new HashMap<String,Object>();
				//问题编号
				question.put("id", rs.getInt(1));
				//问题名称
				question.put("question", rs.getString(2));
				//问题答案
				question.put("answer", rs.getString(3));
				//返回
				return question;
			}
			
		},begin,limit);
		
		return list;
	}
	
	/**
	 * 查询总数据条数
	 */
	public long queryCount() {
		String sql = "SELECT COUNT(1) FROM om_hx_question";
		return template.queryForLong(sql);
	}

	/**
	 * 新增问题信息
	 */
	public int insert(JSONObject question) {
		String sql = "INSERT INTO om_hx_question (question,answer) values(?,?)";
		return template.update(sql, question.getString("question"),question.getString("answer"));
	}

	/**
	 * 修改问题信息
	 */
	public int update(JSONObject question) {
		String sql = "UPDATE om_hx_question SET question = ?,answer = ? WHERE question_id = ? ";
		String questionName = question.getString("question");
		String answer = question.getString("answer");
		int id = question.getIntValue("id");
		
		return template.update(sql, questionName,answer,id);
	}
	
	/**
	 * 根据问题编号删除信息
	 */
	public void deleteByApplyCodes(String questionIds) {
		//根据,切割
		String[] ids = questionIds.split(",");
		//健壮判断
		if(null != ids && ids.length > 0){
			//由于拼接字符串
			StringBuilder sb = new StringBuilder();
			sb.append("delete from om_hx_question where question_id in(");
			//遍历
			for (String id : ids) {
				//拼接
				sb.append(id + ",");
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
