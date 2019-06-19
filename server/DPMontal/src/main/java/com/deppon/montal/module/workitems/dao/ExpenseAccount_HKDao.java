
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.model.TWFSexpensehkSub;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: ExpenseAccount_HKDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(费用报销香港) 
 * @author 何玲菠 
 * @date 2013-7-17 下午1:59:43 
 * @version V1.0 
 */
public class ExpenseAccount_HKDao implements IExpenseAccount_HKDao {
	private static Logger logger = Logger.getLogger(ExpenseAccount_HKDao.class);
	private static String QUERY_INFO = "select   PROCESSINSTID ,  " +//查询主表信息
			"PROPOSER      ,  " +
			"USERID        ,  " +
			"APPLYDEPT     ,  " +
			"SUBCOMPANY    ,  " +
			"PAYEE         ,  " +
			"PHONENO       ,  " +
			"BANK          ,  " +
			"ACCOUNTTYPE   ,  " +
			"PROVINCE      ,  " +
			"CITY          ,  " +
			"SUBBRANCH     ,  " +
			"PAYMENTMETHOD ,  " +
			"BANKNO        ,  " +
			"INVOICETITLE  ,  " +
			"REASON        ,  " +
			"CREATEDATE    ,  " +
			"BILLTYPE      ,  " +
			"EXTRA1        ,  " +
			"EXTRA2        ,  " +
			"EXTRA3        , " +
			"(SELECT W.WORKITEMNAME"+
	         " FROM WFWORKITEM W"+
	        " WHERE (W.CURRENTSTATE = '10' OR W.CURRENTSTATE = '4')"+
	           "AND W.PROCESSINSTID = a.PROCESSINSTID) CURRENTNODE  "+
			"from T_WFS_EXPENSEHK a " +
			"where 1=1 " +
			"and a.processinstid = ?";
	private static String QUERY_INFO_SUB = "select   ID             ,  " +//查询分录表信息
			"PROCESSINSTID  ,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'WFS_EXPENSETYPE_HK' and e.dictid=a.EXPENSETYPE)   EXPENSETYPE ,  " +
			"FEEDESC        ,  " +
			"trunc(BIZDATE) BIZDATE        ,  " +
			"AMOUNT         ,  " +
			"AMOUNTAPPROVED ,  " +
			"COSTDEPT       ,  " +
			"REMARK           " +
			"from T_WFS_EXPENSEHK_SUB a  " +
			"where 1=1 " +
			"and a.processinstid = ?";
	@Override
	public TWFSexpensehk getTWFSexpensehkByWorkId(String workId) {
		Object[] params = {workId};
		Connection conn = null;
		ResultSet rs = null;
		TWFSexpensehk expense_hk = new TWFSexpensehk();
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				expense_hk = (TWFSexpensehk)ConvertPojoUtil.mapToBean(new TWFSexpensehk(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			logger.error("ExpenseAccount_HKDao SQL错误!" + e.getMessage());
		} catch (IOException e) {
			logger.error("ExpenseAccount_HKDao rs转换为List错误！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return expense_hk;
	}

	@Override
	public List<TWFSexpensehkSub> getTWFSexpensehkSubsByWorkId(String workId) {
		Object[] params = {workId};
		Connection conn = null;
		ResultSet rs = null;
		List<TWFSexpensehkSub> list = new ArrayList<TWFSexpensehkSub>();
		TWFSexpensehkSub expense_hk_sub = new TWFSexpensehkSub();
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO_SUB, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				for (Object temp : resultList) {
					expense_hk_sub = (TWFSexpensehkSub)ConvertPojoUtil.mapToBean(new TWFSexpensehkSub(), (Map)temp);
					list.add(expense_hk_sub);
				}
			}
		} catch (SQLException e) {
			logger.error("ExpenseAccount_HKDao SQL 错误！"+e.getMessage());
		} catch (IOException e) {
			logger.error("ExpenseAccount_HKDao 转换错误！"+e.getMessage());
		} finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return list;
	}

}

