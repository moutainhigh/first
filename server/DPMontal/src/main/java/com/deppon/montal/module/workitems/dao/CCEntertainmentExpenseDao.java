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
import com.deppon.montal.model.OASystempowerApply;
import com.deppon.montal.model.OaWorkItem;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: ICCEntertainmentExpenseDao.java
* @Description:(应酬费用报销申请数据操作类) 
* @author yin 
* @date 2013-5-14 上午9:19:35 
* @version V1.0 
*/
public class CCEntertainmentExpenseDao implements ICCEntertainmentExpenseDao {
	
	private static Logger logger = Logger.getLogger(CCEntertainmentExpenseDao.class);
	
	public static final String QUERY_CCENTERTAINMENTEXPENSE_SQL = ""+
			" select                                                                   "+
			"   processinstid,billid,billname,applydate,applypersonnumber,             "+
			"   applypersonname,applydept,applycompany,applytype,                      "+
			"   position,paytype,payee,province,city, bank,                            "+
			"   branchbank,banknumber,attachmentnum,amount,                            "+
			"   amountapproved,amountbalance,loanamount,discription,                   "+
			"   creator,creattime,lastupdateuser,lastupdatetime,                       "+
			"   auditor,auditdate,billstate,isloanbill,                                "+
			"   amountused,loanbillnumber,payeeproperty,lastremitdate,                 "+
			"   invoicetitle,purpose, fivouchered,changepurpose,billtype,phonenumber,  "+
			" (select w.workitemname from wfworkitem w where (w.currentstate = '10' or "+
			" w.currentstate = '4') and w.processinstid = s.processinstid) currentnode "+
			" from cc_entertainmentexpense s                                           "+
			" where s.processinstid = ? ";
	
	public static final String QUERY_CCENTERTAINMENTEXPENSE_DETAIL_SQL = ""+
			" select "+
			"   processinstid,expensetype,discription,bizdate,id,"+
			"   amount,amountapproved,costdept, costcompany,remark,entryid "+
			" from cc_extertainmentexpenseentry "+
			" where  processinstid = ? "; 
	
	@Override
	public CCEntertainmentExpense getCCEntertainmentExpense(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		CCEntertainmentExpense expense = new CCEntertainmentExpense();
		
		try {
		    rs = ConnectionManager.query(conn, QUERY_CCENTERTAINMENTEXPENSE_SQL, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    if (resultList.size() > 0) {
		    	expense = (CCEntertainmentExpense) ConvertPojoUtil.mapToBean(new CCEntertainmentExpense(),
				(Map)resultList.get(0));
		    }
		    
		} catch (SQLException e) {
		    logger.error("ERROR:[CCEntertainmentExpenseDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[CCEntertainmentExpenseDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return expense;
	}
	
	
	@Override
	public List<CCEntertainmentExpenseEntry> getCCEntertainmentExpenseEntry(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		List<CCEntertainmentExpenseEntry> expenseEntryList = new ArrayList<CCEntertainmentExpenseEntry>(); 
		try {
		    
			rs = ConnectionManager.query(conn, QUERY_CCENTERTAINMENTEXPENSE_DETAIL_SQL, params);
			List  resultList = ConvertPojoUtil.resultSetToList(rs);
		    for (Object object : resultList) {
		    	CCEntertainmentExpenseEntry  expenseEntry = (CCEntertainmentExpenseEntry) ConvertPojoUtil.mapToBean(new CCEntertainmentExpenseEntry(), 
			       (Map)object);
			    expenseEntryList.add(expenseEntry);
		    }  
		} catch (SQLException e) {
		    logger.error("ERROR:[CCEntertainmentExpenseDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[CCEntertainmentExpenseDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return expenseEntryList;
	}

}
