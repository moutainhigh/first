
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAManagerProcess;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OAManagerProcessDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(流程新建/变更/废除 dao层) 
 * @author 何玲菠 
 * @date 2013-8-21 上午11:40:12 
 * @version V1.0 
 */
public class OAManagerProcessDao implements IOAManagerProcessDao {
	private static Logger logger = Logger.getLogger(OAManagerProcessDao.class);
	private static String QUERY_INFO = "select   PROCESSINSTID    ,  " +
			"APPLYNAME        ,  " +
			"APPLYDEPTNAME    ,  " +
			"APPLYUSERID      ,  " +
			"APPLYPROCESSNAME ,  " +
			"VERSIONNO        ,  " +
			"(SELECT D.DICTNAME FROM EOS_DICT_ENTRY D WHERE D.DICTTYPEID = 'WFS_MANPROCEAPPLYTYPE' AND D.DICTID = T.APPLYTYPE) APPLYTYPE        ,  " +
			"APPLYREASON       " +
			"from oa_managerprocess t " +
			"WHERE 1=1  " +
			"AND T.PROCESSINSTID = ?";
	@Override
	public OAManagerProcess getOAManagerProcessByProcessinstid(
			String processinstid) {
		OAManagerProcess oaManagerProcess = new OAManagerProcess();
		Connection conn = null;
		ResultSet rs = null;
		Object[] params = {processinstid};
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oaManagerProcess = (OAManagerProcess) ConvertPojoUtil.mapToBean(new OAManagerProcess(), (Map) resultList.get(0));
			}
		} catch (SQLException e) {
			logger.error("OAManagerProcessDao sql错误！"+e);
		} catch (IOException e) {
			logger.error("OAManagerProcessDao 转换错误!"+e);
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oaManagerProcess;
	}

}

