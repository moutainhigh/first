/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCEntertainmentExpense;
import com.deppon.montal.model.CCEntertainmentExpenseEntry;
import com.deppon.montal.model.CCExpenseaccountBill;
import com.deppon.montal.model.CCFenlumingxiTable;
import com.deppon.montal.model.OASystempowerApply;
import com.deppon.montal.model.OaWorkItem;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: ICCEntertainmentExpenseDao.java
* @Description:(物资资产采购报销申请数据操作类) 
* @author yin 
* @date 2013-5-28 上午9:19:35 
* @version V1.0 
*/
public class CCExpenseaccountBillDao implements ICCExpenseaccountBillDao {
	
	private static Logger logger = Logger.getLogger(CCExpenseaccountBillDao.class);
	
	public static final String QUERY_CCEXPENSEACCOUNTBILL_SQL = ""+
			" select  s.*, "+
			" (select w.workitemname from wfworkitem w where (w.currentstate = '10' or "+
			" w.currentstate = '4') and w.processinstid = s.processinstid) currentnode "+
			" from cc_expenseaccountbill s                                           "+
			" where s.processinstid = ? ";
	
	public static final String QUERY_CCEXPENSEACCOUNTBILL_DETAIL_SQL = ""+
			" select * "+			
			" from cc_fenlumingxitable "+
			" where  processinstid = ? "; 
	
	@Override
	public CCExpenseaccountBill getCCExpenseaccountBill(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		CCExpenseaccountBill bill = new CCExpenseaccountBill();
		
		try {
		    rs = ConnectionManager.query(conn, QUERY_CCEXPENSEACCOUNTBILL_SQL, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    if (resultList.size() > 0) {
		    	bill = (CCExpenseaccountBill) ConvertPojoUtil.mapToBean(new CCExpenseaccountBill(),
				(Map)resultList.get(0));
		    }
		    
		} catch (SQLException e) {
		    logger.error("ERROR:[CCExpenseaccountBillDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[CCExpenseaccountBillDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return bill;
	}
	
	
	@Override
	public List<CCFenlumingxiTable> getCCExpenseaccountBillEntry(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		List<CCFenlumingxiTable> expenseEntryList = new ArrayList<CCFenlumingxiTable>(); 
		try {
		    
			rs = ConnectionManager.query(conn, QUERY_CCEXPENSEACCOUNTBILL_DETAIL_SQL, params);
			List  resultList = ConvertPojoUtil.resultSetToList(rs);
		    for (Object object : resultList) {
		    	CCFenlumingxiTable  expenseEntry = (CCFenlumingxiTable) ConvertPojoUtil.mapToBean(new CCFenlumingxiTable(), 
			       (Map)object);
			    expenseEntryList.add(expenseEntry);
		    }  
		} catch (SQLException e) {
		    logger.error("ERROR:[CCExpenseaccountBillDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[CCExpenseaccountBillDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return expenseEntryList;
	}


	

}
