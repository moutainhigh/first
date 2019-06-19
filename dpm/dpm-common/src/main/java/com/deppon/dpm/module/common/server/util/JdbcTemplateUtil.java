package com.deppon.dpm.module.common.server.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * spring的jdbcTemplate的工具类
 *
 */
public class JdbcTemplateUtil {
	
	/**
	 * 投影查询String
	 */
	public static String queryForString(JdbcTemplate template,String sql, Object[] o) {
		//回调
	    List<String> strLst = template.query(sql,o,
	        new RowMapper<String>() {
	          @Override
	          public String mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	  //返回第一条结果
	        	  return rs.getString(1);
	          }
	    });
	    //判断返回的结果是否为空
	    if (strLst == null || strLst.isEmpty()) {
	    	//为空返回空
	    	return null;
	    } else {
	    	//不为空返回结果List的第一条数据
	    	return strLst.get(0);
	    }
	}
	
	
	/**
	 * 投影查询int
	 * @param template
	 * @param sql
	 * @param o
	 * @return
	 */
	public static int queryForInt(JdbcTemplate template,String sql, Object[] o) {
		//回调
	    List<Integer> intLst = template.query(sql,o,
	        new RowMapper<Integer>() {
	          @Override
	          public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	  //返回第一条结果
	        	  return rs.getInt(1);
	          }
	    });
	    //判断返回的结果是否为空
	    if (intLst == null || intLst.isEmpty()) {
	    	//为空返回0
	    	return -1;
	    } else {
	    	//不为空返回结果List的第一条数据
	    	return intLst.get(0);
	    }
	}
}
