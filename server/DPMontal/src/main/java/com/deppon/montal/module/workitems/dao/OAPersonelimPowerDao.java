
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.LaywerApply;
import com.deppon.montal.model.OAPersonelimPower;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OAPersonelimPowerDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 人事授权申请数据操作层 
 * @author yinrongping 
 * @date 2013-8-1 下午3:08:38 
 * @version V1.0 
 */
public class OAPersonelimPowerDao implements IOAPersonelimPowerDao{

	private static Logger logger = Logger.getLogger(OAPersonelimPowerDao.class);
	
	private static final String QUERY_INFO_SQL = " "+
			" select processinstid,empid,applyname,impowerto, userid, "+
		    "   impowerstarttime,impowerendtime,reason, " +
		    " (select dict.dictname from eos_dict_entry dict where dict.dicttypeid='DIP_IFVALID' and dict.dictid = t.isauthorized) isauthorized "+
		    " from personelimpower t where t.processinstid = ? ";
	
	/**
	 * 获取人事授权申请信息
	 */
	@Override
	public OAPersonelimPower getPersonelimPower(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAPersonelimPower apply = new OAPersonelimPower();
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				apply = (OAPersonelimPower)ConvertPojoUtil.mapToBean(new OAPersonelimPower(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OAPersonelimPowerDao.getPersonelimPower] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OAPersonelimPowerDao.getPersonelimPower] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return apply;
	}

}

