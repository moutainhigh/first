
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OABaddebtApply;
import com.deppon.montal.model.OABaddebtChild;
import com.deppon.montal.model.OALessonApply;
import com.deppon.montal.model.OAPersonelimPower;
import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OABaddebtDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(非业务类坏账申请数据操作类) 
 * @author yinrongping 
 * @date 2013-8-2 上午11:11:51 
 * @version V1.0 
 */
public class OABaddebtDao implements IOABaddebtDao {

	private static Logger logger = Logger.getLogger(OABaddebtDao.class);
	
    private static String QUERY_INFO_SQL = "" +
    		 " select processinstid,applyname,applypersoncode,applydeptment, "+
    	     "   applydate,depositcode,acceptdeposit,begindate, "+
    	     "   (select dict.dictname from eos_dict_entry dict  "+
    	     "    where dict.dicttypeid='WFS_BADDEBTTYPE' and dict.dictid = t.baddebttype) baddebttype, "+
    	     "   maturedate,deposittype,debitcode,debitname,customername, "+
    	     "   mishapcode,baddebtmoney,baddebtreason  "+
    	     " from oa_baddebt t where t.processinstid = ? ";
    
    private static String QUERY_DETAIL_INFO = " " +
    		  " select id, processinstid,responsibilitydept, "+
    		  " todeptaccount,responsibilityperson,personwithhold "+
    		  " from oa_baddebt_child t where t.processinstid = ? ";
    		  
	
	@Override
	public OABaddebtApply getBaddebtApply(String processinstid) {

		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OABaddebtApply apply = new OABaddebtApply();
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				apply = (OABaddebtApply)ConvertPojoUtil.mapToBean(new OABaddebtApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OABaddebtApply.getBaddebtApply] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OABaddebtApply.getBaddebtApply] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return apply;
	}

	@Override
	public List<OABaddebtChild> getBaddebtChild(String processinstid) {

		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		List<OABaddebtChild> baddebtList = new ArrayList<OABaddebtChild>();
		try {
		    rs = ConnectionManager.query(conn, QUERY_DETAIL_INFO, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    for (Object object : resultList) {
		    	baddebtList.add((OABaddebtChild)ConvertPojoUtil.mapToBean(
					new OABaddebtChild(), (Map)object));
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[OABaddebtApply.getBaddebtChild] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OABaddebtApply.getBaddebtChild] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return baddebtList;

	}

}

