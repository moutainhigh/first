package com.deppon.wfs.workflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.deppon.montal.util.ConnectionManager;

public class CheckProcessinstIdDao {
	
	private static String sql = "select decode(processinstid,null,0,processinstid) as \"PROCESSINSTID\" " + 
								"from t_bpms_applyinfo@link_bpsdb " +
			"where processdefname = 'com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.siteRent' " +
			"and condition = '4' " +
			"and processinstid = ?";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	Logger logger = Logger.getLogger(CheckProcessinstIdDao.class);
	
	public Object check(int pro){
		
		conn = ConnectionManager.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pro);
			rs = ps.executeQuery();
			if(rs == null) {
				return null;
			}else if(rs.next()) {
				return rs.getInt("PROCESSINSTID");
			}
				
		} catch (SQLException e) {
			logger.error("场地搬迁资源协调：查询工作流号出现异常" + e);
		} finally {
 			ConnectionManager.closeAll(conn, ps, rs);
		}
		return null;		
	}

}
