
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAUseSealApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OAUseSealApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-8-1 下午1:53:07 
 * @version V1.0 
 */
public class OAUseSealApplyDao implements IOAUseSealApplyDao {
	private Logger logger = Logger.getLogger(OAUseSealApplyDao.class);
	private String QUERY_INFO = "select   PROCESSINSTID    ," +
			"  NAME             ," +
			"  USERID           ," +
			"  DEPT             ," +
			"  (select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_DIVISION_NEW' and e.dictid = a.area)  AREA," +
			"  SEALNAME         ,  " +
			"SEALTYPE         ,  " +
			"REASON           ,  " +
			"AMSSN            ,  " +
			"AMSAPPLYTYPE     ,  " +
			"EXTEND1          ,  " +
			"EXTEND2          ,  " +
			"SEALCODE         ,  " +
			"APPLYDATE        ,  " +
			"AGREEDATE        ,  " +
			"LASTAPPROVALER   ,  " +
			"SEALTYPECODE     ,  " +
			"SEALDEPT         ,  " +
			"SEALTRUSTEE      ,  " +
			"SEALCOUNTS       ,  " +
			"SEALBRIEF        ,  " +
			"SEALNEEDNAME     ,  " +
			"SEALUSEDATE , " +
			"SEALSEQUENCECODE ,  " +
			"SEALGENERALCODE  ,  " +
			"SEALARCHIVALCODE ,  " +
			"SEALASAVEDEPT      " +
			"from oa_usesealapply a " +
			"where 1=1 " +
			"and a.processinstid = ?";
	@Override
	public OAUseSealApply getOAUseSealApplyById(String pid) {
		Object[] params = {pid};
		Connection conn = null;
		ResultSet rs = null;
		OAUseSealApply oausesealapply = new OAUseSealApply();
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oausesealapply = (OAUseSealApply) ConvertPojoUtil.mapToBean(new OAUseSealApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			logger.error("OAUseSealApplyDao SQL错误" + e.getMessage());
		} catch (IOException e) {
			logger.error("OAUseSealApplyDao rs转化为List错误" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oausesealapply;
	}

}

