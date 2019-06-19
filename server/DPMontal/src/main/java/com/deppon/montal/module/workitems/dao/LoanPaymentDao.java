/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OALoanPaymentInfo;
import com.deppon.montal.model.OASubSidiarySet;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: LoanPaymentDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(借支申请数据层接口) 
* @author yin
* @date 2013-7-18 下午3:23:31 
* @version V1.0 
*/
public class LoanPaymentDao implements ILoanPaymentDao{
	
	private static Logger logger = Logger.getLogger(LoanPaymentDao.class);
	
    private static String QUERY_INFO_SQL = "" +
			    "  select processinstid,applypersoncode,applypersonname,                            "+
			    "         applydept,subsidiary,loantype,costtype,applyreason,                       "+
			    "         (select e.dictname from eos_dict_entry e                                  "+
			    "           where e.dicttypeid = 'DIP_ENTERPRISE_AREA' and e.dictid = t.area) area, "+
			    "          totalmoney,payee,subbranchbank,                                          "+
			    "         (select e.dictname from eos_dict_entry e                                  "+
			    "           where e.dicttypeid = 'DIP_BANKTYPE' and e.dictid = t.area) depositbank, "+
			    "         province,city,account,finalremittance,invoicetitle,                       "+
			    "         occurencydate,payuse,departmentaization,mobilephonebysms                  "+
			    "  from oa_loan_payment_info t where t.processinstid = ?                            ";
	
	
	/**
	 * 获取借支申请信息
	 * @param processinstid
	 * @return
	 */
	@Override
	public OALoanPaymentInfo getLoanPaymentInfo(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = null;
		ResultSet rs = null;
		OALoanPaymentInfo payment = new OALoanPaymentInfo();
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				payment = (OALoanPaymentInfo)ConvertPojoUtil.mapToBean(new OALoanPaymentInfo(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			logger.error("ERROR:[LoanPaymentDao.OALoanPaymentInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
			logger.error("ERROR:[LoanPaymentDao.OALoanPaymentInfo] rs转换为List出错！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return payment;
	}

}
