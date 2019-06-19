
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OASubSidiarySet;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OASubsidiarysetDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(子公司设立及变更申请层) 
 * @author 何玲菠 
 * @date 2013-7-16 上午9:41:19 
 * @version V1.0 
 */
public class SubsidiarysetDao implements ISubsidiarysetDao {
	private static Logger logger = Logger.getLogger(SubsidiarysetDao.class);
	private static String QUERY_INFO = "select s.name, " +
			"s.processinstid," +
			"decode(s.type,'1','变更','2','设立','3','注销') type," +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_ENTERPRISE_AREA' and e.dictid = s.area) area," +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_FINANCEDEPT' and e.dictid = s.financedep) financedep," +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'WFS_MATTER_TEAM' and e.dictid = s.matterteam) matterteam, " +
			"s.subcompany," +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_COMPENSATION_NEW' and e.dictid = s.compensation) compensation," +
			"decode(s.updatetype,'1','经营范围','2','注册地址','3','注册资本','4','法定代表人','5','经营期限','6','董事','7','监事','8','经理','9','名称') updatetype,  " +
			"s.beforeupdate, " +
			"s.afterupdate, " +
			"s.reason  " +
			"from oa_subsidiaryset s " +
			"where 1=1 " +
			"and s.processinstid = ?";
	@Override
	public OASubSidiarySet getOASubsidiaryset(String pid) {
		Object[] params = {pid};
		Connection conn = null;
		ResultSet rs = null;
		OASubSidiarySet subsidiaryset = new OASubSidiarySet();
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				subsidiaryset = (OASubSidiarySet)ConvertPojoUtil.mapToBean(new OASubSidiarySet(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			logger.error("ERROR:[SubsidiarysetDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
			logger.error("ERROR:[SubsidiarysetDao] rs转换为List出错！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return subsidiaryset;
	}

}

