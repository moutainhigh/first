package com.deppon.montal.module.workitems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OaContractApply;
import com.deppon.montal.module.workitems.service.SQLManager;
import com.deppon.montal.module.workitems.service.WorkItemsService;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: IAdminContractApplyDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(行政类合同申请工作流数据层) 
* @author yin 
* @date 2013-06-20 上午11:40:38 
* @version V1.0 
*/
public class AdminContractApplyDao implements IAdminContractApplyDao{

	private static Logger logger = Logger.getLogger(AdminContractApplyDao.class);
	
	private static final String QUERY_CONTRACT_APPLY_SQL = " "+
			   " select "+
			   " processinstid           ,"+
			   " proposer                ,"+
			   " userid                  ,"+
			   " chargeindepartment      ,"+
			   " signtype                ,"+
			   " originalcontractnumbers ,"+
			   " (select dict.dictname from eos_dict_entry dict where dict.dicttypeid='WFS_HT_CONTRACTTYPE' and dict.dictid = contracttype) contracttype  ,"+
			   " (select dict.dictname from eos_dict_entry dict where dict.dicttypeid='DIP_DIVISION_NEW' and dict.dictid = subordinatedepartment) subordinatedepartment  ,"+
			   " (select dict.dictname from eos_dict_entry dict where dict.dicttypeid='DIP_FINANCEDEPT' and dict.dictid = financedept)  financedept ,"+
			   " itemname                ,"+
			   " quantity                ,"+
			   " unitprice               ,"+
			   " ismain                  ,"+
			   " isframecontract         ,"+
			   " contractname            ,"+
			   " contractamount          ,"+
			   " signingeachotherunit    ,"+
			   " signingourunit          ,"+
			   " contractstarttime       ,"+
			   " contractendtime         ,"+
			   " reason                  ,"+
			   " processinstname         "+
			   " from oa_contractapply where processinstid = ? ";
	
	/**
	 * 获取合同申请
	 * @param processinstid
	 * @return
	 */
	public OaContractApply queryContractApply(String processinstid){
		
    	Object[] params = {processinstid};
    	Connection conn = ConnectionManager.getConnection();
    	OaContractApply apply = null;
		ResultSet rs = null;
    	try{
    		rs = ConnectionManager.query(conn, QUERY_CONTRACT_APPLY_SQL, params);
    		List  resultList = ConvertPojoUtil.resultSetToList(rs);
    		apply = (OaContractApply) ConvertPojoUtil.mapToBean(new OaContractApply(), 
 			       (Map)resultList.get(0));
    	}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
    	return apply;
	}
}
