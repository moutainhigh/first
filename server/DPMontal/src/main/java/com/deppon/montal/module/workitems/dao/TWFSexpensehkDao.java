/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.model.TWFSexpensehkSub;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: TWFSexpensehkDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description: 付款申请（香港）/费用报销申请 数据库操作类
* @author yin
* @date 2013-7-16 上午10:16:25 
* @version V1.0 
*/
public class TWFSexpensehkDao implements ITWFSexpensehkDao{

	private static Logger logger = Logger.getLogger(TWFSexpensehkDao.class);
	
	//获取付款申请信息SQL
	private static String QUERY_INFO_SQL = " "+
			" select processinstid,proposer,userid,applydept,subcompany, "+
		    "    payee,phoneno,bank,accounttype,province,city,subbranch, "+
		    "    paymentmethod,bankno,invoicetitle,reason,createdate, "+
		    "    billtype,extra1,extra2,extra3,  "+
		    "    (select w.workitemname from wfworkitem w "+
            "     where (w.currentstate = '10' or  w.currentstate = '4') "+
            "       and w.processinstid = t.processinstid ) currentnode "+
		    " from t_wfs_expensehk t where t.processinstid = ? ";
	
	//获取付款申请详细信息SQL
	private static String QUERY_SUB_INFO_SQL = " "+
			" select  id,processinstid,feedesc,bizdate,amount, "+
	        " amountapproved,costdept,remark,  "+
	        " (select dict.dictname from eos_dict_entry dict   "+
	        " where dict.dicttypeid='WFS_EXPENSETYPE_HK' and dict.dictid = t.expensetype) expensetype  "+
	        " from t_wfs_expensehk_sub t where t.processinstid = ?   ";
	
	/**
	 * 获取付款申请信息
	 * @param processinstid
	 * @return
	 */
	public TWFSexpensehk getWFSexpensehkInfo(String processinstid){
		Object[] params = new Object[]{processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		TWFSexpensehk expensehk = null;
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				expensehk = (TWFSexpensehk)ConvertPojoUtil.mapToBean(new TWFSexpensehk(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[TWFSexpensehkDao.getWFSexpensehkInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[TWFSexpensehkDao.getWFSexpensehkInfo] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return expensehk;
	}
	
	/**
	 * 获取付款申请详细信息
	 * @param processinstid
	 * @return
	 */
	public List<TWFSexpensehkSub> getWFSexpensehkSub(String processinstid){
		Object[] params = new Object[]{processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		List<TWFSexpensehkSub> expensehkSubList = new ArrayList<TWFSexpensehkSub>();
		try {
			rs = ConnectionManager.query(conn, QUERY_SUB_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			for (Object object : resultList) {
				TWFSexpensehkSub  expensehkSub = (TWFSexpensehkSub) ConvertPojoUtil.mapToBean(new TWFSexpensehkSub(), 
			       (Map)object);
				expensehkSubList.add(expensehkSub);
		    }  
		} catch (SQLException e) {
		    logger.error("ERROR:[TWFSexpensehkDao.getWFSexpensehkSub] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[TWFSexpensehkDao.getWFSexpensehkSub] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return expensehkSubList;
	}
}
