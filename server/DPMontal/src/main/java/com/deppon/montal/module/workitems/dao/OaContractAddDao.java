package com.deppon.montal.module.workitems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OaContractAdd;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

public class OaContractAddDao implements IOaContractAddDao{
	private static Logger logger = Logger.getLogger(OaContractAddDao.class);
	private static final String QUERY_CONTRACTADD = "" +
			"select t.processinstid,"+
			"t.applypersoncode,"+
			"t.applypersonname,"+
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_DIVISION_NEW' and t.divisioncode = e.dictid) divisioncode,"+
			"t.applypersondept,"+
			"t.applytype,"+
			"t.contractnumber,"+
			"t.subsidiary,"+
			"t.contractstartdate,"+
			"t.contractenddate,"+
			"t.customercode,"+
			"t.customername,"+
			"t.amountofconsignment,"+
			"t.customerallname,"+
			"t.nodesectiontype,"+
			"t.balanceaccount,"+
			"t.settleaccountsdate,"+
			"t.freightdiscount,"+
			"t.preferentialtype,"+
			"t.generationratediscount,"+
			"t.chargeratediscount,"+
			"t.NEWCARGOFEEDISCOUNT,"+
			"t.DELIVERYFEEDISCOUNT,"+
			"t.PROTOCOLCONTACTNAME,"+
			"t.CONTACTPHONE,"+
			"t.CONTACTTEL,"+
			"t.APPLYREASON "+
			" from oa_contractinfo t "+
			" where 1=1 and "+
			" t.processinstid = ?";
	public OaContractAdd getOaContraAddInfo(String processinstid){
		OaContractAdd oacontracadd = new OaContractAdd();
		Object[] param = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		try{
			//申请信息
			rs = ConnectionManager.query(conn, QUERY_CONTRACTADD, param);
			List  resultList = ConvertPojoUtil.resultSetToList(rs);
			oacontracadd = (OaContractAdd) ConvertPojoUtil.mapToBean(new OaContractAdd(), (Map)resultList.get(0));
		}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oacontracadd;
	}
}
