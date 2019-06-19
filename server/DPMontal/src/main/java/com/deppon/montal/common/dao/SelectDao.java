package com.deppon.montal.common.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

public class SelectDao {
	private static Logger logger = Logger.getLogger(SelectDao.class);
	/**
	 *  SELECT *
		FROM (SELECT LEVEL1.*, ROWNUM RN
		      FROM (  SELECT E.*
		              FROM DIPOA.OM_EMPLOYEE E, DIPOA.OM_ORGANIZATION OM
		              WHERE 1=1
		              AND E.EMPCODE=''
		              AND E.EMPNAME=''
		              AND OM.FINASYSCODE=''
		              AND E.EMPSTATUS='ON'
		              AND E.ORGID=OM.ORGID ) LEVEL1
		       WHERE ROWNUM < 20) LEVEL2
		WHERE LEVEL2.RN > 10
	 */
	String empSelectSQLStart = "SELECT LEVEL2.EMPNAME,LEVEL2.EMPCODE,LEVEL2.JOBNAME,LEVEL2.MANAGERID,LEVEL2.ORGNAME,LEVEL2.FINASYSCODE " + 
							   "FROM (SELECT LEVEL1.EMPNAME,LEVEL1.EMPCODE,LEVEL1.JOBNAME,LEVEL1.MANAGERID,LEVEL1.ORGNAME,LEVEL1.FINASYSCODE,ROWNUM RN " + 
								     "FROM (  SELECT E.EMPNAME,E.EMPCODE,E.JOBNAME,OM.MANAGERID,OM.ORGNAME,OM.FINASYSCODE " +
								             "FROM DIPOA.OM_EMPLOYEE E, DIPOA.OM_ORGANIZATION OM " + 
								             "WHERE E.ORGID=OM.ORGID";
	String empSelectSQLEnd = " ) LEVEL1" + 
							 " WHERE ROWNUM <= ?) LEVEL2 " + 
							 "WHERE LEVEL2.RN > ?";
	String empCountsSQL =  " SELECT COUNT(1) AS TOTALCOUNT FROM DIPOA.OM_EMPLOYEE E, DIPOA.OM_ORGANIZATION OM WHERE E.ORGID=OM.ORGID ";
	String deptSelectSQLStart = "SELECT  ORGNAME, FINASYSCODE, ORGCODE " + 
								"FROM (SELECT A.ORGNAME, A.FINASYSCODE, A.ORGCODE, ROWNUM RN " +
								"FROM (SELECT * FROM dipoa.OM_ORGANIZATION S  " + 
									  "WHERE S.ORGCLOSE = '0' AND S.appsyscode = 'DIP' AND S.FINASYSCODE IS NOT NULL";
	String deptSelectSQLEnd =" ) A " + 
               					"WHERE ROWNUM <= ? )  " +
               					"WHERE RN > ?";
	String deptCountsSQL = "SELECT COUNT(1) AS TOTALCOUNT FROM dipoa.OM_ORGANIZATION S WHERE S.ORGCLOSE = '0' AND S.appsyscode = 'DIP' AND S.FINASYSCODE IS NOT NULL";
	private String makeParams (Map<String, String> reqPara) {
		StringBuilder paramStr = new StringBuilder();
		String selectorType = reqPara.get("selectorType");
		if ("empSelector".equals(selectorType)) {
			String empCode = reqPara.get("empCodeQuery");
			String empName = reqPara.get("empNameQuery");
			String finasyscode = reqPara.get("finasyscodeQuery");
			String empStatus = reqPara.get("empStatusQuery");
			if (empCode != null && empCode != "") {
				paramStr.append(" and E.EMPCODE like '%").append(empCode.trim()).append("%'");
			}
			if (empName != null && empName != "") {
				paramStr.append(" and E.EMPNAME like '%").append(empName.trim()).append("%'");
			}
			if (finasyscode != null && finasyscode != "") {
				paramStr.append(" and OM.FINASYSCODE in (").append(finasyscode.trim()).append(")");
			}
			if (empStatus != null && empStatus != "") {
				paramStr.append(" and E.EMPSTATUS like '%").append(empStatus.trim()).append("%'");
			}else {
				paramStr.append(" and E.EMPSTATUS ='").append("on").append("'");
			}
		}else if ("deptSelector".equals(selectorType)){
			String deptName = reqPara.get("deptNameQuery");
			String deptCode = reqPara.get("deptCodeQuery");
			String finasyscode = reqPara.get("finasyscodeQuery");
			if (deptName != null && deptName != "") {
				paramStr.append(" and S.ORGNAME like '%").append(deptName.trim()).append("%'");
			}
			if (deptCode != null && deptCode != "") {
				paramStr.append(" and S.ORGCODE like '%").append(deptCode.trim()).append("%'");
			}
			if (finasyscode != null && finasyscode.length() > 0) {
				paramStr.append(" and S.FINASYSCODE like '%").append(finasyscode.trim()).append("%'");
			}
		}
		return paramStr.toString();
	}
	
	private String makeQueryListSQL (Map<String, String> reqPara) {
		String selectorType = reqPara.get("selectorType");
		String querySQL = null;
		if ("empSelector".equals(selectorType)) {
			querySQL = empSelectSQLStart + makeParams(reqPara) + empSelectSQLEnd;
		}else if ("deptSelector".equals(selectorType)) {
			querySQL = deptSelectSQLStart + makeParams(reqPara) + deptSelectSQLEnd;
		}
		return querySQL;
	}
	
	private String makeQueryCountSQL (Map<String, String> reqPara) {
		String selectorType = reqPara.get("selectorType");
		String querySQL = null;
		if ("empSelector".equals(selectorType)) {
			querySQL = empCountsSQL + makeParams(reqPara);
		}else if ("deptSelector".equals(selectorType)) {
			querySQL = deptCountsSQL + makeParams(reqPara);
		}
		return querySQL;
	}
	/*public static void main(String[] args) {
		StringBuilder paramStr = new StringBuilder();
		System.out.println(":" + paramStr.toString().length());
		Map<String,String> params = new HashMap<String, String>();
		if (params.get("name")==null) {
			System.out.println("====null");
		}
		params.put("sss", null);
		System.out.println("sss:" +params.get("sss") );
	}*/
	public List<Map<String,String>> queryList(Map<String, String> reqPara){
		List<Map<String,String>> list = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String querySQL = makeQueryListSQL(reqPara);
		if (querySQL != null) {
			try {
				ps = conn.prepareStatement(querySQL);
				ps.setString(2, reqPara.get("startPage"));
				ps.setString(1, reqPara.get("endPage"));
				rs = ps.executeQuery();
				list = ConvertPojoUtil.resultSetToList(rs);
			} catch (SQLException e) {
				logger.error("选择器查询异常" + e.getMessage(),e);
			} catch (IOException e) {
				logger.error("流读取失败！" + e.getMessage());
			} finally {
				ConnectionManager.closeAll(conn, ps, rs);
			}
		}
		return list;
	}; 
	public int queryCount(Map<String, String> reqPara){
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String querySQL = makeQueryCountSQL(reqPara);
		int count = 0;
		if (querySQL != null) {
			try {
				ps = conn.prepareStatement(querySQL);
				rs = ps.executeQuery();
				while (rs.next()) {
					count = rs.getInt("TOTALCOUNT");
				}
			} catch (SQLException e) {
				logger.error("选择器查询异常" + e.getMessage(),e);
			} finally {
				ConnectionManager.closeAll(conn, ps, rs);
			}
		}
		return count;
	}
	/**
	 * 
	* @MethodName: querySunOrg 
	* @description : 查询下级子部门
	* @author：caibingbing 
	* @date： 2014-8-6 下午8:38:53
	* @param finasysCode
	* @return String
	 */
	public String querySunOrg(String finasysCode) {
		String finasys = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String querySQL = "select o1.finasyscode,o1.orgname " +
				"from om_organization o1, om_organization o " +
				"where o1.parentorgid = o.orgid and o1.orgclose = 0 and o.finasyscode = ?";
		StringBuffer sb = new StringBuffer();
		if (querySQL != null) {
			try {
				ps = conn.prepareStatement(querySQL);
				ps.setString(1, finasysCode);
				rs = ps.executeQuery();
				while (rs.next()) {
					String st = rs.getString("FINASYSCODE");
					sb.append("'"+st+"'").append(",");
				}
			} catch (SQLException e) {
				logger.error("选择器查询异常" + e.getMessage(),e);
			} finally {
				ConnectionManager.closeAll(conn, ps, rs);
			}
		}
		if(finasysCode != null){
			finasys = sb.append(finasysCode).toString();
		}
		return finasys;
	}; 
	
}
