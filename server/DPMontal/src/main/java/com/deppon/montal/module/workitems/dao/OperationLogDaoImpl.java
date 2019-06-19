package com.deppon.montal.module.workitems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deppon.montal.util.ConnectionManager;
import com.deppon.wfs.workflow.domain.OperationMessage;

public class OperationLogDaoImpl implements IOperationLogDao {
	/**
	 * 
	* @MethodName: operationLog 
	* @description : 记录操作
	* @author：何玲菠 
	* @date： 2014-2-19 上午9:46:39
	* @param message
	* @return boolean
	 */
	@Override
	public boolean operationLog(OperationMessage message) {
		String INSERT_SQL = "INSERT INTO DPMON_OPERATION(ID,USERID,USERNAME,OPERATION_DATE,OPERATION_TYPE,PROCESSINSTID,SYSCODE) VALUES (?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setLong(1, message.getId());
			ps.setString(2, message.getUserId());
			ps.setString(3, message.getUserName());
			ps.setDate(4, new Date(message.getOperationDate().getTime()));
			ps.setString(5, message.getOperationType());
			ps.setString(6, message.getProcessinstid());
			ps.setString(7, message.getSysCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.closeAll(conn, ps, null);
		}
		return true;
	}
}
