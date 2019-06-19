package com.deppon.montal.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * @author yin
 * 数据库帮助类，封装是查询和更新的方法
 * 此类是线程安全的
 */
public class ConnectionManager {
	
	private static Logger logger = Logger.getLogger(ConnectionManager.class); 
	
	/**
	 * 初始化数据库参数
	 * 读取配置信息
	 */
	static{		
		
	}
	
	/**
	 * 获取连接
	 * 将线程绑定到线程中是为了一个线程只创建一个连接，节省资源的同时，也方便控制事务
	 * 
	 */
	public static Connection getConnection(){
		 Connection conn = null;
	     Context ct = null;
	     try{
	    	 ct = new InitialContext();
	    	 DataSource ds = (DataSource)ct.lookup("java:oracleds");//java:oracleds  java:comp/env/jdbc/ds-oa
	    	 conn = (Connection)ds.getConnection();
		  }catch (Exception e) {
			  logger.error("检查url,用户名，密码是否正确:"+e.getMessage());
			  e.printStackTrace();
		  } 
	      return conn;
	}
	/**
	 * 封闭插入，删除，更新语句的方法
	 * 将connection作为参数传入，一方面是为了线程安全，
	 * 另一方面是可以在Service层控制Connection的开关从及事务
	 */
	
	public static int update(Connection conn,String sql,Object...params) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(sql);
		if(params != null){
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
		}
		int count =  ps.executeUpdate();
		return count;
	}
	/**
	 * 执行查询的方法
	 * >>>>>此方法有待改进，本人认为返回ResultSet不是一个好的解决方法
	 * >>>>>欢迎大家提出好的解决方案
	 */
	public static ResultSet query(Connection conn,String sql,Object...params) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(sql);
		if(params != null){
			for(int i=0;i<params.length;i++){
			    ps.setObject(i+1, params[i]);
			}
		}
		ResultSet rs =  ps.executeQuery();
		return rs;
	}
	
	/**
	 * 关闭数据库
	 * 同时从线程中移除
	 */
	public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
		try {
			if(null != rs){
				rs.close();
			}
			if(null != stmt){
				stmt.close();
			}
			
			if(conn != null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("关闭连接失败:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
} 