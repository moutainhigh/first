
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OACarGoTransContract;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OACarGoTransContractDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-8-20 下午2:50:33 
 * @version V1.0 
 */
public class OACarGoTransContractDao implements IOACarGoTransContractDao {
	private static Logger logger = Logger.getLogger(OACarGoTransContractDao.class);
	private static String QUERY_INFO = "select t.processinstid,       " +
			"t.name,       " +
			"t.empid,       " +
			"(select d.dictname from eos_dict_entry d where d.dicttypeid = 'DIP_ENTERPRISE_AREA' and d.dictid = t.area) area,       " +
			"t.subsidiary,       " +
			"t.reason  " +
			"from oa_cargotranscontract t      " +
			"where 1=1      " +
			"and t.processinstid = ?";
	@Override
	public OACarGoTransContract getOACarGoTransContractByProcessinstid(
			String processinstid) {
		Object[] params = {processinstid};
		ResultSet rs = null;
		OACarGoTransContract oaCarGoTransContract = new OACarGoTransContract();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oaCarGoTransContract = (OACarGoTransContract) ConvertPojoUtil.mapToBean(new OACarGoTransContract(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("OACarGoTransContractDao sql错误!" + e);
		} catch (IOException e) {
			   // TODO Auto-generated catch block
			logger.error("OACarGoTransContractDao 转换错误！" +e);
		} finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oaCarGoTransContract;
	}

}

