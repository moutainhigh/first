
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OaContractApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: ProjectContractApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(项目类合同签订申请) 
 * @author 何玲菠 
 * @date 2013-7-17 上午8:59:03 
 * @version V1.0 
 */
public class ProjectContractApplyDao implements IProjectContractApplyDao {
	private static Logger logger = Logger.getLogger(ProjectContractApplyDao.class);
	private static String QUERY_INFO = "select PROCESSINSTID,       " +
		"PROPOSER,       " +
		"USERID,       " +
		"CHARGEINDEPARTMENT,       " +
		"SIGNTYPE,       " +
		"ORIGINALCONTRACTNUMBERS,       " +
		"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'WFS_HT_PROJECTCONTRACTTYPE' and e.dictid=a.CONTRACTTYPE) CONTRACTTYPE,       " +
		"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_DIVISION_NEW' and e.dictid=a.SUBORDINATEDEPARTMENT) SUBORDINATEDEPARTMENT,      " +
		"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_FINANCEDEPT' and e.dictid=a.FINANCEDEPT) FINANCEDEPT,       " +
		"ITEMNAME,       " +
		"QUANTITY,       " +
		"UNITPRICE,       " +
		"ISMAIN,       " +
		"ISFRAMECONTRACT,       " +
		"CONTRACTNAME,       " +
		"CONTRACTAMOUNT,       " +
		"SIGNINGEACHOTHERUNIT,       " +
		"SIGNINGOURUNIT,       " +
		"CONTRACTSTARTTIME,       " +
		"CONTRACTENDTIME,       " +
		"REASON,       " +
		"PROCESSINSTNAME,       " +
		"SEAL  " +
		"from OA_CONTRACTAPPLY a " +
		"where 1 = 1   " +
		"and a.processinstid = ?";
	@Override
	public OaContractApply getOAContractApplyByWorkId(String workId) {
		Object[] params = {workId};
		Connection conn = null;
		ResultSet rs = null;
		OaContractApply oacontractapply = null;
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oacontractapply = (OaContractApply)ConvertPojoUtil.mapToBean(new OaContractApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			logger.error("ProjectContractApplyDao SQL错误!"+e.getMessage());
		} catch (IOException e) {
			logger.error("rs转换为list错误！"+e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oacontractapply;
	}

}

