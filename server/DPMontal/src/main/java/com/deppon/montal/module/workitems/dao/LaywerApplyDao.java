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

import com.deppon.montal.model.LaywerApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: LaywerApplyDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(诉讼案件立案/外请律师申请工作流数据层) 
* @author yin 
* @date 2013-06-24 上午11:40:38 
* @version V1.0 
*/
public class LaywerApplyDao implements ILaywerApplyDao {

	private static Logger logger = Logger.getLogger(LaywerApplyDao.class);
	
	private static final String QUERY_LAYWERAPPLY_SQL = " "+
	             " select t.* from laywerapply t where t.processinstid = ? ";
	
	/**
	 * 获取诉讼案件立案/外请律师详细
	 */
	@Override
	public LaywerApply getLaywerApplyInfo(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		LaywerApply apply = new LaywerApply();
		try {
			rs = ConnectionManager.query(conn, QUERY_LAYWERAPPLY_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				apply = (LaywerApply)ConvertPojoUtil.mapToBean(new LaywerApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[LaywerApplyDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[LaywerApplyDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return apply;
	}

}
