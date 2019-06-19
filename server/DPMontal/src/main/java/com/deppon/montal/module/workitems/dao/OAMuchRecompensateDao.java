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

import com.deppon.montal.model.OAMuchRecompensate;
import com.deppon.montal.model.OaContractAdd;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/**
 * @author Administrator
 *
 */
public class OAMuchRecompensateDao implements IOAMuchRecompensateDao{

	private static Logger logger = Logger.getLogger(OAMuchRecompensateDao.class);
	
	public static final String QUERY_MUCHRECONPENSATE_SQL = ""+
			" select "+
			"  processinstid, "+
			"  applypersoncode, "+
			"  applypersonname, "+
			"  transportorerrorcode, "+
			"  to_char(recompensiesmoney,'999999999.00') recompensiesmoney, "+
			"  to_char(amountintotal,'999999999.00') amountintotal, "+
			"  (select ede.dictname from eos_dict_entry ede where ede.dicttypeid = 'WFS_YESORNO' and ede.dictid = t.hasrepaydebt) hasrepaydebt, "+
			"  (select emp.empname from om_employee emp where emp.userid = t.deptaccountant) deptaccountant, "+
			"  (select org.orgname from om_organization org where org.finasyscode = t.enterprisedept) enterprisedept, "+
			"  applyreason "+
			" from oa_muchrecompensate t where t.processinstid = ?  ";  
	/**
	 * 获取多赔信息
	 */
	@Override
	public OAMuchRecompensate getMuchRecompensate(String processinstid) {
		
		OAMuchRecompensate sate = new OAMuchRecompensate();
		Object[] param = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		try{
			//申请信息
			rs = ConnectionManager.query(conn, QUERY_MUCHRECONPENSATE_SQL, param);
			List  resultList = ConvertPojoUtil.resultSetToList(rs);
			sate = (OAMuchRecompensate) ConvertPojoUtil.mapToBean(new OAMuchRecompensate(), (Map)resultList.get(0));
		}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return sate;
	}

}
