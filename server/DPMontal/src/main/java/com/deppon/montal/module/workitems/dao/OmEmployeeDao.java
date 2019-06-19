
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OmEmployeeDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-4-11 上午9:20:30 
 * @version V1.0 
 */
public class OmEmployeeDao implements IOmEmployeeDao {
    
    private static Logger logger = Logger.getLogger(OmEmployeeDao.class);
    
    
    /**获取开发人员*****************************************/
    private static String QUERY_APPROVER_DEV = "" +
    		" SELECT  EMP.USERID, " +
    		"EMP.EMPNAME," +
    		"(SELECT ORGNAME FROM OM_ORGANIZATION WHERE ORGID = EMP.ORGID )ORGNAME " +
    		" FROM OM_EMPLOYEE EMP WHERE EMP.ORGID IN " +
    		" (SELECT E.ORGID FROM OM_EMPLOYEE E  WHERE E.USERID =?)" +
    		" AND EMP.EMPSTATUS ='on'" ;
    
    /**获取开发经理****************************************/
    private static String QUERY_APPROVER_DEVMANAGE = "" +
    		"SELECT OM_ORGANIZATION.ORGNAME ORGNAME," +
    		"OM_EMPLOYEE.USERID USERID," +
    		"OM_EMPLOYEE.EMPNAME EMPNAME," +
    		"AC_OPERATORROLE.ROLEID ROLEID," +
    		"'['||ORGNAME||']'||EMPNAME ALLNAME, " +
    		"OM_EMPLOYEE.DEGREE," +
    		"OM_EMPLOYEE.JOBNAME" +
    		" FROM OM_ORGANIZATION" +
    		" INNER JOIN OM_EMPLOYEE ON OM_ORGANIZATION.ORGID = OM_EMPLOYEE.ORGID" +
    		" INNER JOIN AC_OPERATOR ON OM_EMPLOYEE.USERID = AC_OPERATOR.USERID" +
    		" INNER JOIN AC_OPERATORROLE ON AC_OPERATOR.OPERATORID = AC_OPERATORROLE.OPERATORID" +
    		" WHERE AC_OPERATORROLE.ROLEID = 'DevManager' AND OM_EMPLOYEE.EMPSTATUS ='on'" +
    		" AND  OM_EMPLOYEE.USERID !=?";
    
    public List<OmEmployee> getDevApprover(LoginUser user){
	String sql = QUERY_APPROVER_DEV;
	Object[] params = {user.getUserId()};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	List<OmEmployee> employees = new ArrayList<OmEmployee>();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		employees.add((OmEmployee)ConvertPojoUtil.mapToBean(
				new OmEmployee(), (Map)object));
	    }
	} catch (SQLException e) {
	    logger.error("SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return employees;
    }
    public List<OmEmployee> getDevManageApprover(LoginUser user){
	String sql = QUERY_APPROVER_DEVMANAGE;
	Object[] params = {user.getUserId()};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	List<OmEmployee> employees = new ArrayList<OmEmployee>();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		employees.add((OmEmployee)ConvertPojoUtil.mapToBean(
			new OmEmployee(), (Map)object));
	    }
	} catch (SQLException e) {
	    logger.error("SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return employees;
    }
}

