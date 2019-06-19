
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCExpenseClaim;
import com.deppon.montal.model.CCExpenseClaimEntry;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: CCExpenseClaimDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(通用费用工作流数据操作) 
 * @author 廖建雄 
 * @date 2013-4-27 上午9:58:34 
 * @version V1.0 
 */
public class CCExpenseClaimDao implements ICCExpenseClaimDao {
    private static Logger logger = Logger.getLogger(CCExpenseClaimDao.class);
    
    private static String QUERY_CC_EXPENSECLAIM_INFO = " SELECT CC.*,"+
         "(SELECT W.WORKITEMNAME"+
         " FROM WFWORKITEM W"+
        " WHERE (W.CURRENTSTATE = '10' OR W.CURRENTSTATE = '4')"+
           "AND W.PROCESSINSTID = CC.PROCESSINSTID) CURRENTNODE　FROM CC_EXPENSECLAIM CC WHERE CC.PROCESSINSTID =?";
    private static String QUERY_CC_EXPENSECLAIMENTRY_INFO = "" +
	    "SELECT *　FROM CC_EXPENSECLAIMENTRY WHERE PROCESSINSTID =?";

    @Override
    public CCExpenseClaim getCCExpenseClaim(String processinstid) {
	
	String sql = QUERY_CC_EXPENSECLAIM_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	CCExpenseClaim expenseClaim = new CCExpenseClaim();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
		expenseClaim = (CCExpenseClaim) ConvertPojoUtil.mapToBean(new CCExpenseClaim(),
			(Map)resultList.get(0));
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[CCExpenseClaimDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[CCExpenseClaimDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return expenseClaim;
    }

    @Override
    public List<CCExpenseClaimEntry> getCCExpenseClaimeEntry(String processinstid) {
	
	String sql = QUERY_CC_EXPENSECLAIMENTRY_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	CCExpenseClaimEntry expenseClaimEntry = new CCExpenseClaimEntry();
	List<CCExpenseClaimEntry> list = new ArrayList<CCExpenseClaimEntry>();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
	    	for (Object temp : resultList) {
	    		expenseClaimEntry = (CCExpenseClaimEntry) ConvertPojoUtil.mapToBean(new CCExpenseClaimEntry(),
	    				(Map)temp);
	    		list.add(expenseClaimEntry);
	    	}
			}
	} catch (SQLException e) {
	    logger.error("ERROR:[CCExpenseClaimDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[CCExpenseClaimDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return list;
    }

}

