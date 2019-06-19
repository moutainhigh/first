
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.deppon.montal.model.OABankAccountOpencl;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OABankAccountOpenClDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 银行开户/销户申请数据操作层
 * @author yinrongping 
 * @date 2013-8-23 上午9:20:53 
 * @version V1.0 
 */
public class OABankAccountOpenClDao implements IOABankAccountOpenClDao{

	private static Logger logger = Logger.getLogger(OABankAccountOpenClDao.class);
	
    private static String QUERY_INFO_SQL = "" +
    		" select  processinstid,applytype,accountingdept,accountopenname, "+
            "         (select dict.dictname from eos_dict_entry dict  "+
            "         where dict.dicttypeid='DIP_BANKTYPE' and dict.dictid = t.bankname) bankname, "+
            "         accounts,name,accounttype,reason,empid,accountingname, "+
            "        (select org.orgname from om_employee emp ,om_organization org  "+
            "        where emp.orgid = org.orgid and emp.empid = t.empid ) orgname "+
            "  from oa_bankaccountopencl t where t.processinstid = ?  ";
	
	/**
	 * 获取银行开户/销户申请信息
	 */
	@Override
	public OABankAccountOpencl getBankAccountOpenClInfo(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OABankAccountOpencl apply = new OABankAccountOpencl();
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				apply = (OABankAccountOpencl)ConvertPojoUtil.mapToBean(new OABankAccountOpencl(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OABankAccountOpenClDao.getBankAccountOpenClInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OABankAccountOpenClDao.getBankAccountOpenClInfo] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return apply;
		
	}

}

