/**
 * 
 */
package com.deppon.montal.login.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deppon.montal.login.dao.UserLoginDao;
import com.deppon.montal.login.model.LoginMessage;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.util.ConnectionManager;
import com.eos.foundation.common.utils.CryptoUtil;
import com.google.gson.Gson;

/**
 * 用户登录service
 * @author yin
 *
 */
public class UserLoginService {

	
	/**
	 * 登录权限验证
	 * @param userid
	 * @return
	 */
	public boolean validateLoginRole(String userid,String jobName){
		
		String sql = SQLManager.VALIDATE_LOGIN_ROLE;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(2, userid);
			stmt.setString(1, jobName);
			rs = stmt.executeQuery();
			while(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		return flag;
	}
	
	/**
	 * 根据userid获取用户信息
	 * @param userid
	 * @return
	 */
	public LoginUser getLoginUser(String userid){
		String sql = SQLManager.PASSWORD_LOGIN_CHECK;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		              
		try{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userid);
			rs = stmt.executeQuery();
			if(rs.next()){
					LoginUser login = new LoginUser();
					login.setUserId(rs.getString("userid"));
					login.setEmpId(Long.parseLong(rs.getString("empid")));
					login.setEmpName(rs.getString("operatorname"));
					login.setJobName(rs.getString("jobname"));
					return login;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		return null;
	}
	
	
	/**
	 * 登录验证
	 * @param userid
	 * @param password
	 * @return
	 */
	public LoginUser loginCheck(String userid,String password){
		
		String sql = SQLManager.PASSWORD_LOGIN_CHECK;
		//MD5加密
		password = CryptoUtil.digestByMD5(password);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		              
		try{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userid);
			rs = stmt.executeQuery();
			if(rs.next()){
				if(password.equals(rs.getString("password"))){
					LoginUser login = new LoginUser();
					login.setUserId(rs.getString("userid"));
					login.setEmpName(rs.getString("operatorname"));
					login.setJobName(rs.getString("jobname"));
					return login;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		return null;
	}
	
	/**
     * 获取人员代办数量
     * @param userId
     * @return
     */
    public String getWorkFlowCountByUserId(String userId,String sysCode){
    	
//    	String sql = SQLManager.getQueryWFCount(sysCode);
    	String sql = SQLManager.queryAllWFCount(userId);
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String res = "";
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, userId);
//			stmt.setString(2, userId);
//			stmt.setString(3, userId);
//			stmt.setString(4, userId);
			rs = stmt.executeQuery();
			while(rs.next()){
				res = rs.getString("NUM")==null?"0":rs.getString("NUM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		//为空处理
		if(res == ""){
			res = "0";
		}
		return res;
    }
    
    /**
     * 查询滚动新闻
     * @return
     */
    public String queryRollNews(String empid,int count){
    	String sql = SQLManager.QUERY_ROLLNEWS_SQL;
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<OaRollNews> list = new ArrayList<OaRollNews>();
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, empid);
			stmt.setInt(2, count);
			rs = stmt.executeQuery();
			while(rs.next()){
				OaRollNews ment = new OaRollNews();
				ment.setGgid(rs.getBigDecimal("ggid"));
				ment.setHeader(rs.getString("header"));
				ment.setFilename(rs.getString("file_new_name"));
				if(null != rs.getString("ckbh")){
					ment.setCkbh(new BigDecimal("1"));//已读
				}else{
					ment.setCkbh(new BigDecimal("0"));//未读
				}
				
				list.add(ment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		Gson gson = new Gson(); 
		return gson.toJson(list);
    }
    
    /**
     * 
    * @MethodName: logLoginMessage 
    * @description : 记录登陆信息到登陆信息表
    * @author：何玲菠 
    * @date： 2014-2-18 下午5:05:47
    * @param message 实体
    * @return boolean 是否成功标志位
     */
    public boolean logLoginMessage(LoginMessage message){
    	UserLoginDao dao = new UserLoginDao();
    	return dao.logLoginMessage(message);
    }
}
