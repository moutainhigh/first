package com.deppon.montal.login.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deppon.montal.login.model.LoginMessage;
import com.deppon.montal.util.ConnectionManager;

public class UserLoginDao {
	String INSERT_LOGIN_MESSAGE = "INSERT INTO DPMON_LOGIN(ID,USERID,USERNAME,LOGIN_TIME) VALUES (?,?,?,?)";
	public  boolean logLoginMessage(LoginMessage message){
		boolean isLog = true;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(INSERT_LOGIN_MESSAGE);
			ps.setLong(1, message.getId());
			ps.setString(2, message.getUserId());
			ps.setString(3, message.getUserName());
			ps.setDate(4, new Date(message.getLoginDate().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.closeAll(conn, ps, rs);
		}
		return isLog;
	}; 
}
