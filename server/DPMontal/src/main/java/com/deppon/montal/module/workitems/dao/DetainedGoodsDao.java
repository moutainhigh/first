
    package com.deppon.montal.module.workitems.dao; 

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.deppon.montal.model.OAKouhuoApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: DetainedGoodsDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-8-1 下午3:55:41 
 * @version V1.0 
 */
public class DetainedGoodsDao implements IDetainedGoodsDao {
	private Logger logger = Logger.getLogger(DetainedGoodsDao.class);
	private String QUERY_INFO = "select * from oa_kouhuoapply t where 1=1 and t.processinstid = ?";

	@Override
	public OAKouhuoApply getOAKouhuoApplyById(String pid) {
		Object[] params = {pid};
		Connection conn = null;
		ResultSet rs = null;
		OAKouhuoApply kouhuoapply = new OAKouhuoApply();
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				kouhuoapply = (OAKouhuoApply) ConvertPojoUtil.mapToBean(new OAKouhuoApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("DetainedGoodsDao SQL错误！" + e.getMessage());
		} catch (IOException e) {
			   // TODO Auto-generated catch block
			logger.error("DetainedGoodsDao rs转换为List错误！"+ e.getMessage());
		} finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return kouhuoapply;
	}

}

