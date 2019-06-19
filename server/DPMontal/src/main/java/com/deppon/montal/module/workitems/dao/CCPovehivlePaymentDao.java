
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCPovehivlePayment;
import com.deppon.montal.model.CCPovehivlePaymentEntry;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: CCPovehivlePaymentDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-6 上午9:41:04 
 * @version V1.0 
 */
public class CCPovehivlePaymentDao implements ICCPovehivlePaymentDao {
	private static Logger logger = Logger.getLogger(CCPovehivlePaymentDao.class);
    
    private static String QUERY_CCPOVEHIVLEPAYMENT_INFO = " SELECT CC.*,"+
         "(SELECT W.WORKITEMNAME"+
         " FROM WFWORKITEM W"+
        " WHERE (W.CURRENTSTATE = '10' OR W.CURRENTSTATE = '4')"+
           "AND W.PROCESSINSTID = CC.PROCESSINSTID) CURRENTNODE　FROM CC_POVEHIVLEPAYMENT CC WHERE CC.PROCESSINSTID =?";
    private static String QUERY_CCPOVEHIVLEPAYMENTENTRY_INFO = "" +
	    "SELECT *　FROM CC_POVEHIVLEPAYMENTENTRY WHERE PROCESSINSTID =?";
	@Override
	public CCPovehivlePayment getCCPovehivlePaymentByWorkId(String workId) {
		Object[] params = {workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		CCPovehivlePayment ccpovehivlepayment = new CCPovehivlePayment();
		try {
			rs = ConnectionManager.query(conn, QUERY_CCPOVEHIVLEPAYMENT_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				ccpovehivlepayment = (CCPovehivlePayment)ConvertPojoUtil.mapToBean(new CCPovehivlePayment(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[CCPovehivlePaymentDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[CCPovehivlePaymentDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		// TODO Auto-generated method stub return null;
		return ccpovehivlepayment;
	}
	@Override
	public List<CCPovehivlePaymentEntry> getCCPovehivlePaymentEntriesByWorkId(
			String workId) {
		Object[] params = {workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		CCPovehivlePaymentEntry entry = new CCPovehivlePaymentEntry();
		List<CCPovehivlePaymentEntry> list = new ArrayList<CCPovehivlePaymentEntry>();
		try {
			rs = ConnectionManager.query(conn, QUERY_CCPOVEHIVLEPAYMENTENTRY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				for (Object temp : resultList) {
					entry = (CCPovehivlePaymentEntry)ConvertPojoUtil.mapToBean(new CCPovehivlePaymentEntry(), (Map)temp);
					list.add(entry);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (IOException e) {
			
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			
		}
		   // TODO Auto-generated method stub return null;
		return list;
	}
}

