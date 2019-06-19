
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCPodailyPayment;
import com.deppon.montal.model.CCPodailyPaymentEntry;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: PodailyPaymentDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (日常付款数据操作) 
 * @author 廖建雄 
 * @date 2013-5-14 下午4:10:35 
 * @version V1.0 
 */
public class PodailyPaymentDao implements IPodailyPaymentDao {
    private static Logger logger = Logger.getLogger(PodailyPaymentDao.class);
    
    private static String QUERY_CC_PODAILYPAYMENT_INFO= "" +
    		"SELECT CC.PROCESSINSTID,CC.APPLYPERSONNAME,CC.APPLYDEPT,CC.APPLYCOMPANY," +
    		"CC.APPLYTYPE,CC.INVOICETITLE,CC.PAYEE,CC.AMOUNT,CC.BANKNUMBER," +
    		"CC.AMOUNTAPPROVED,CC.BANK,CC.LASTREMITDATE,CC.DISCRIPTION," +
    		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = CC.PROCESSINSTID)CURRENTNODE" +
    		" FROM CC_PODAILYPAYMENT CC WHERE CC.PROCESSINSTID = ?";
    private static String QUERY_CC_PODAILYPAYMENTENTRY_INFO= "" +
    		"SELECT EXPENSETYPE,DISCRIPTION,BIZDATE,AMOUNT,AMOUNTAPPROVED,COSTDEPT,REMARK" +
    		" FROM CC_PODAILYPAYMENTENTRY WHERE PROCESSINSTID = ?";

    @Override
    public CCPodailyPayment getCCPodailyPaymentInfo(String processinstid) {
	String sql = QUERY_CC_PODAILYPAYMENT_INFO;
	Object[] params = {processinstid};
	ResultSet rs = null;
	Connection conn = ConnectionManager.getConnection();
	CCPodailyPayment payment = new CCPodailyPayment();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		payment = (CCPodailyPayment) ConvertPojoUtil.mapToBean(
			new CCPodailyPayment(), (Map) object);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[PodailyPaymentDao getCCPodailyPaymentInfo] SQL语句出错！" 
		    	+ e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[PodailyPaymentDao getCCPodailyPaymentInfo] rs转换为List失败!" 
		    	+ e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn,null, rs);
	}
	return payment;
    }
    public List<CCPodailyPaymentEntry> getCCPodailyPaymentEntry(String processinstid) {
	
	String sql = QUERY_CC_PODAILYPAYMENTENTRY_INFO;
	Object[] params = {processinstid};
	ResultSet rs = null;
	Connection conn = ConnectionManager.getConnection();
	List<CCPodailyPaymentEntry> paymentEntry = new ArrayList<CCPodailyPaymentEntry>();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    for (Object object : resultList) {
		paymentEntry.add((CCPodailyPaymentEntry) ConvertPojoUtil.mapToBean(
			new CCPodailyPaymentEntry(), (Map) object));
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[PodailyPaymentDao getCCPodailyPaymentEntry] SQL语句出错！" 
		    	+ e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[PodailyPaymentDao getCCPodailyPaymentEntry] rs转换为List失败!" 
		    	+ e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn,null, rs);
	}
	return paymentEntry;
    }

}

