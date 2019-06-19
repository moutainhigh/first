
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OASealCarveApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OASealCarveApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(刻章申请dao层) 
 * @author 何玲菠 
 * @date 2013-8-20 下午3:46:35 
 * @version V1.0 
 */
public class OASealCarveApplyDao implements IOASealCarveApplyDao {
	private static Logger logger = Logger.getLogger(OASealCarveApply.class);
	private static String QUERY_INFO = "select PROCESSINSTID ,  " +
			"NAME          ,  " +
			"USERID        ,  " +
			"DEPTNAME      ,  " +
			"(select d.dictname from eos_dict_entry d where d.dicttypeid = 'DIP_DIVISION_NEW' and d.dictid = t.area) AREA          ,  " +
			"SUBCOM        ,  " +
			"ISFIRSTCARVE  ,  " +
			"SEALNAME      ,  " +
			"SEALTYPE      ,  " +
			"PROVIDECOM    ,  " +
			"ISRECORDINPS ,  " +
			"REASON        ,  " +
			"EMPID         ,  " +
			"FINANCEDEPT   ,  " +
			"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = t.PROCESSINSTID) currentnode"+
			"  from oa_sealcarveapply t where 1=1 and t.processinstid = ?";
	@Override
	public OASealCarveApply getOASealCarveApplyByprocessinstid(
			String processinstid) {
		OASealCarveApply oaSealCarveApply = new OASealCarveApply();
		Object[] params = {processinstid};
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oaSealCarveApply = (OASealCarveApply) ConvertPojoUtil.mapToBean(new OASealCarveApply(), (Map) resultList.get(0));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("OASealCarveApplyDao sql错误!"+ e);
		} catch (IOException e) {
			logger.error("OASealCarveApplyDao 转换错误!" +e);
		} finally {
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oaSealCarveApply;
	}

}

